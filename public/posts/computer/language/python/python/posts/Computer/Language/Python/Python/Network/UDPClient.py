# !usr/bin/env python3
# -*- coding: utf-8 -*-
# Author:liukanglai
# Blog:
# Time:2022-05-17 10:55:56
# Name:UDPClient.py
# Version:V1.0

from socket import *

serverName = '127.0.0.1'
serverPort = 12001
clientSocket = socket(AF_INET, SOCK_DGRAM)

message = input('Input lowercase sentence:')
clientSocket.sendto(message.encode(), (serverName, serverPort))
modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
print(modifiedMessage.decode())
clientSocket.close()
