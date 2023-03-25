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
---# Header file

- "mpi.h"

- rc = MPI_Xxx

# 
- Rank id

- Group
- communicator
- MPI_COMM_WORLD: pre-defined communicator

## MPI_Init()

- before all
- only once

## MPI_Finalize()

## MPI_Comm_size(comm, &size)
- return size
## MPI_Comm_rank(comm, &rank)
- return rank


        int rc;
        rc = MPI_Init(&argc, &argv);
        if(rc != MPI_SUCCESS) {
            printf("");
            MPI_Abort(MPI_COMM_WORLD, rc);
        }
        MPI_Comm_size(MPI_COMM_WORLD, &size)
        MPI_Comm_rank(MPI_COMM_WORLD, &rank)
        printf("%d, %d", size, rank);
        MPI_Finalize();

# Blocking send
- MPI_Send(buffer, count, type, dest, tag, comm)
# Non-blocking send
- MPI_Isend(buffer, count, type, dest, tag, comm, request)
# Blocking receive
- MPI_Recv(buffer, count, type, source, tag, comm, status)
# Non-blocking receive
- MPI_IRecv(buffer, count, type, source, tag, comm, request)

- buffer: Address space of data(send or receive)
- type: MPI_CHAR, MPI_INT...
- count: the number of data elemens
- source: the rank (task id)..
- tag: assign message
- status:
- request:


for non-blocking: MPI_Wait(request, status);


MPI_Barrier(comm)
MPI_Bcast(&buffer, count, datatype, root, comm) // root to other
MPI_Scatter(&sendbuf, sendcnt, sendtype, &recvbuf, recvcnt, recvtype, root, comm) // 均分
MPI_Gather(&sendbuf, sendcnt, sendtype, &recvbuf, recvcnt, recvtype, root, comm) //
MPI_Reduce(&sendbuf, &recvbuf, count, datatype, op, dest, comm) // all reduce
MPI_Allgather(&sendbuf, sendcnt, sendtype, &recvbuf, recvcnt, recvtype, comm) //
MPI_Allreduce(&sendbuf, &recvbuf, count, datatype, op, comm) // all reduce
