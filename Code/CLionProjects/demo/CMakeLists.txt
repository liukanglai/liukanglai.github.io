cmake_minimum_required(VERSION 3.19)
project(demo C)

set(CMAKE_C_STANDARD 99)

add_executable(demo main.c)

all:
    gcc -O3 -fopenmp -lm main.c ~/github/OpenBLAS/build/lib/libopenblas.a -o gemm -I ~/github/OpenBLAS/build