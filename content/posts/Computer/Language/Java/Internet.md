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
---# ip(InetAddress class)

- IPV4/6
- 127.0.0.1(localhost)
- 公网，私网(192.168.0.0-192.168.255.255)
- 域名-DNS-服务器

        // 实例化
        InetAddress inet = InetAddress.getByName("192.168.0.1");
        InetAddress inet = InetAddress.getByName("www.google.com");
        
        getLocalHost();

        //
        getHostName();
        getHostAddress();


# 端口(process)

- 0-1023 (HTTP:80, FTP:21, Telnet:23)
- 1024-49151 (分配)

> Socket: IP+端口

# 网络通讯协议(传输层)

## OSI

## TCP(传输层)/IP(网络层)

- TCP(three handshake to start, for big data transmission, four handshake to end) UDP(no connection)
        
        // Client
        Socket socket = new Socket("127.0.0.1", 8888);
        socket.getInputStream();

        socket.shutdownOutput();

        // Server
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept(); // accept client

        char[] buffer = new char[20];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while(len = is.read(buffer) != -1)
            baos.write(buffer, 0, len); // no 乱码
        socket.getInetAddress();

## UDP


        // sender
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(data, 0, length, inet, 8888);
        socket.send(packet);


        // receiver
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[20];
        DatagramPacket packet = new DatagramPacket(buffer, 0, length);
        socket.receive(packet);

# URL

- https://localhost:8080/hello/...

        URl url = new URl("http://...");
        url.getProtocol();
        url.getHost();
        url.getPort();
        url.getPath();
        url.getFile();
        url.getQuery();

        URLConnection urlc = url.openConnection();
        urlc.connect();
        urlc.getInputStream();
        urlc.disconnect();

        url.openStream();
