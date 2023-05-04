// SOCKETCLIENT_H
#ifndef _SOCKETCLIENT_H
#endif _SOCKETCLIENT_H

#ifdef __cplusplus
extern "C"
#endif

    // 第一套api函数
    // 客户端环境初始化
    int
    socketclient_init(void **handle);
// 报文发送
int socketclient_send(void **handle, unsigned char *buf, int buflen);
// 报文接收
int socketclient_recv(void **handle, unsigned char *buf, int buflen);
// 环境释放
int socketclient_destory(void **handle);
