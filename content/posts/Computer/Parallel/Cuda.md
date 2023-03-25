---
title: ""
draft: false
tags: ["first"]
author: "liukanglai"
# author: ["Me", "You"] # multiple authors
showToc: true
TocOpen: false
hidemeta: false
comments: false
description: "Desc Text."
canonicalURL: "https://canonical.url/to/page"
disableHLJS: true # to disable highlightjs
disableShare: false
disableHLJS: false
hideSummary: false
searchHidden: true
ShowReadingTime: true
ShowBreadCrumbs: true
ShowPostNavLinks: true
ShowWordCount: true
ShowRssButtonInSectionTermList: true
UseHugoToc: true
cover:
    image: "<image path/url>" # image path/url
    alt: "<alt text>" # alt text
    caption: "<text>" # display caption under cover
    relative: false # when using page bundles set this to true
    hidden: true # only hide on current single page
editPost:
    URL: "https://github.com/<path_to_repo>/content"
    Text: "Suggest Changes" # edit text
    appendFilePath: true # to append file path to Edit link
---# hardware

1. max
- one block up to have 512(or 1024) threads
- max dimension size of block:(1024, 1024, 64), grid:(2^31-1, 2^16-1, 2^16-1)
- concurrent kernel execution: 32
- max threads per multiprocessor: 2048
- max threads per block: 1024

2. 
- G80 have 16 SM assignment: Streaming Multiprocessors (SM) to run the threads, up to 8 blocks, and(not or) 768 threads.
- G80, scheduling: 32 threads - a warp, divide eack block to many warps, 8 cpus, each do 4 threads, each do a warp.  Really parallel
- shared memory (16K) to a SM, 2 blocks, each can only use 8K.

## memory

- local memory
- shared memory per block(48M)
- global memory
- constant memory

# compile (nvcc)

1. nvcc to PTX Code and CPU Code
2. PTX to Target Compiler (G80, GPU...)

# grammar

cudaMalloc(&Md, size)
cudaMalloc((void /**)&Md, size) // 强转，普遍

cudaMemcpy(Md, M, size, cudaMemcpyHostToDevice) // cudaMemcpyDeviceToHost, cudaMemcpyDeviceToDevice...
cudaFree(Md)

        _device_ float DeviceFUnc  (device to device) // can't use the address of function
        _global_ void KernelFunc (host to device) // kernel function
        _host_ float HostFunc (host to host)
        _host_ _device_ ...

        // variable type
        _shared_  
        _devide_ 
        _constant_

- 不写，默认host

- on device function: no recursion; no static variable declaration inside; no 变参

        int tx = threadIdx.x;
        int ty = threadIdx.y;

- dimGrid(1, 1) (block in it)
- dimBlock(width,width) (have max. Thread in it)

## Kernel

    kernelFunc<<< nB, nT, nS, Sid>>>(...) // nS, Sid are optional
- nB: grid size
- nT: block size
- nS: shared memory size (bytes)
- Sid: stream ID, default is 0 (kernel trans)

- ... 内must is device points


#

- dim3 (x, y, z)
- threadIdx, blockIdx, blockDim, gridDim
- /__syncthreads()

- host access it: global constant, can't: register(automatic), shared, local
- GPU can only use pointers in global memory, no other pointers

        // Matrices are stored in row-major order:
        // M(row, col) = *(M.elements + row * M.width + col)
        typedef struct {
            int width;
            int height;
            float* elements;
        } Matrix;

        // Thread block size
        #define BLOCK_SIZE 16
        // Forward declaration of the matrix multiplication kernel

        __global__ void MatMulKernel(const Matrix, const Matrix, Matrix);
        // Matrix multiplication - Host code
        // Matrix dimensions are assumed to be multiples of BLOCK_SIZE

        void MatMul(const Matrix A, const Matrix B, Matrix C) {
            // Load A and B to device memory
            Matrix d_A;
            d_A.width = A.width; d_A.height = A.height;
            size_t size = A.width * A.height * sizeof(float);
            cudaMalloc(&d_A.elements, size);
            cudaMemcpy(d_A.elements, A.elements, size,
            cudaMemcpyHostToDevice);
            Matrix d_B;
            d_B.width = B.width; d_B.height = B.height;
            size = B.width * B.height * sizeof(float);
            cudaMalloc(&d_B.elements, size);
            cudaMemcpy(d_B.elements, B.elements, size,
            cudaMemcpyHostToDevice);

            // Allocate C in device memory
            Matrix d_C;
            d_C.width = C.width; d_C.height = C.height;
            size = C.width * C.height * sizeof(float);
            cudaMalloc(&d_C.elements, size);

            // Invoke kernel
            dim3 dimBlock(BLOCK_SIZE, BLOCK_SIZE);
            dim3 dimGrid(B.width / dimBlock.x, A.height / dimBlock.y);
            MatMulKernel<<<dimGrid, dimBlock>>>(d_A, d_B, d_C);

            // Read C from device memory
            cudaMemcpy(C.elements, d_C.elements, size,
            cudaMemcpyDeviceToHost);

            // Free device memory
            cudaFree(d_A.elements);
            cudaFree(d_B.elements);
            cudaFree(d_C.elements);
        }
        // Matrix multiplication kernel called by MatMul()
        __global__ void MatMulKernel(Matrix A, Matrix B, Matrix C){
            // Each thread computes one element of C
            // by accumulating results into Cvalue

            float Cvalue = 0;
            int row = blockIdx.y * blockDim.y + threadIdx.y;
            int col = blockIdx.x * blockDim.x + threadIdx.x;
            for (int e = 0; e < A.width; ++e){
                Cvalue += A.elements[row * A.width + e] * B.elements[e * B.width + col];
            }
            C.elements[row * C.width + col] = Cvalue;
        }


# Shared Memory

- each thread block is responsible for computing one square sub-matrix Csub of C and each thread within the block is responsible for computing one element of Csub.
- the sub-matrix of A of dimension (A.width, block_size) that has the same row indices as Csub, and the sub-matrix of B of dimension (block_size, A.width )that has the same column indices as Csub.
- two rectangular matrices are divided into as many square matrices of dimension block_size 
- first loading the two corresponding square matrices from global memory to shared memory with one thread loading one element of each matrix,
- each thread compute one element of the product. 
- Each thread accumulates the result of each of these products into a register and once done writes the result to global memory.


        // Matrices are stored in row-major order:
        // M(row, col) = *(M.elements + row * M.stride + col)
        typedef struct {
            int width;
            int height;
            int stride;
            float* elements;
        } Matrix;
        // Get a matrix element
        __device__ float GetElement(const Matrix A, int row, int col) {
            return A.elements[row * A.stride + col];
        }
        // Set a matrix element
        __device__ void SetElement(Matrix A, int row, int col, float value) {
            A.elements[row * A.stride + col] = value;
        }
        // Get the BLOCK_SIZExBLOCK_SIZE sub-matrix Asub of A that is
        // located col sub-matrices to the right and row sub-matrices down
        // from the upper-left corner of A
        __device__ Matrix GetSubMatrix(Matrix A, int row, int col) {
            Matrix Asub;
            Asub.width = BLOCK_SIZE;
            Asub.height = BLOCK_SIZE;
            Asub.stride = A.stride;
            Asub.elements = &A.elements[A.stride * BLOCK_SIZE * row + BLOCK_SIZE * col];
            return Asub;
        }
        // Thread block size
        #define BLOCK_SIZE 16

        // Forward declaration of the matrix multiplication kernel
        __global__ void MatMulKernel(const Matrix, const Matrix, Matrix);

        // Matrix multiplication - Host code
        // Matrix dimensions are assumed to be multiples of BLOCK_SIZE
        void MatMul(const Matrix A, const Matrix B, Matrix C) {
            // Load A and B to device memory
            Matrix d_A;
            d_A.width = d_A.stride = A.width; 
            d_A.height = A.height;
            size_t size = A.width * A.height * sizeof(float);
            cudaMalloc(&d_A.elements, size);
            cudaMemcpy(d_A.elements, A.elements, size,
            cudaMemcpyHostToDevice);
            Matrix d_B;
            d_B.width = d_B.stride = B.width; d_B.height = B.height;
            size = B.width * B.height * sizeof(float);
            cudaMalloc(&d_B.elements, size);
            cudaMemcpy(d_B.elements, B.elements, size,
            cudaMemcpyHostToDevice);
            // Allocate C in device memory
            Matrix d_C;
            d_C.width = d_C.stride = C.width; d_C.height = C.height;
            size = C.width * C.height * sizeof(float);
            cudaMalloc(&d_C.elements, size);

            // Invoke kernel
            dim3 dimBlock(BLOCK_SIZE, BLOCK_SIZE);
            dim3 dimGrid(B.width / dimBlock.x, A.height / dimBlock.y);
            MatMulKernel<<<dimGrid, dimBlock>>>(d_A, d_B, d_C);

            // Read C from device memory
            cudaMemcpy(C.elements, d_C.elements, size, cudaMemcpyDeviceToHost);

            // Free device memory
            cudaFree(d_A.elements);
            cudaFree(d_B.elements);
            cudaFree(d_C.elements);
        }

        //Matrix multiplication kernel called by MatMul()
        _global_ void MatMulKernel(Matrix A, Matrix B, Matrix C){
            // Block row and column
            int blockRow = blockIdx.y;
            int blockCol = blockIdx.x;

            // Each thread block computes one sub-matrix Csub of C
            Matrix Csub = GetSubMatrix(C, blockRow, blockCol);

            // Each thread computes one element of Csub
            // by accumulating results into Cvalue
            float Cvalue = 0;

            // Thread row and column within Csub
            int row = threadIdx.y;
            int col = threadIdx.x;

            // Loop over all the sub-matrices of A and B that are
            // required to compute Csub
            // Multiply each pair of sub-matrices together
            // and accumulate the results
            for (int m = 0; m < (A.width / BLOCK_SIZE); ++m) {

                /Global, local, texture, constant, shared and register memory. / Get sub-matrix Asub of A
                Matrix Asub = GetSubMatrix(A, blockRow, m);

                // Get sub-matrix Bsub of B
                Matrix Bsub = GetSubMatrix(B, m, blockCol);

                // Shared memory used to store Asub and Bsub respectively
                __shared__ float As[BLOCK_SIZE][BLOCK_SIZE];
                __shared__ float Bs[BLOCK_SIZE][BLOCK_SIZE];

                // Load Asub and Bsub from device memory to shared memory
                // Each thread loads one element of each sub-matrix
                As[row][col] = GetElement(Asub, row, col);
                Bs[row][col] = GetElement(Bsub, row, col);

                // Synchronize to make sure the sub-matrices are loaded
                // before starting the computation
                __syncthreads();

                // Multiply Asub and Bsub together
                for (int e = 0; e < BLOCK_SIZE; ++e){
                    Cvalue += As[row][e] * Bs[e][col];
                }

                // Synchronize to make sure that the preceding
                // computation is done before loading two new
                // sub-matrices of A and B in the next iteration
                __syncthreads();
            }
            // Write Csub to device memory
            // Each thread writes one element
            SetElement(Csub, row, col, Cvalue);
        }

## API

- Math: sprt, sin...
- memory


# branch

- all do, to give up some.


