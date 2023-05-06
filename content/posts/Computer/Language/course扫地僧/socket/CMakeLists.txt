cmake_minimum_required(VERSION 3.26)
project(socket)

set(CMAKE_CXX_STANDARD 14)

include_directories(head)

add_executable(socket
        head/CSckFactoryImp1.h
        head/CSocketProtocol.h
        mainclass.cpp CSckFactoryImp1.cpp)
