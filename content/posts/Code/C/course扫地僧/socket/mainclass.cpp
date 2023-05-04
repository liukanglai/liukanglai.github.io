// 企业系统的软件框架，基本不变，自由集成第三方框架。
// socket通信产品， 加密，解密。
//
// 解决办法：定义接口层，调用第三方

#include <cstring>
#include <iostream>

#include "head/CSckFactoryImp1.h"
// #include "head/CSocketProtocol.h"

int SckSendAndRev(CSocketProtocol *sp, unsigned char *in, int inlen,
                  unsigned char *out, int *outlen) {
  int ret = 0;
  ret = sp->cltSocketInit();
  if (ret != 0) {
    return 0;
  }
  ret = sp->cltSocketSend(in, inlen);
  if (ret != 0) {
    return 0;
  }
  ret = sp->cltSocketRev(out, outlen);
  if (ret != 0) {
    return 0;
  }
  ret = sp->cltSocketDestory();
  if (ret != 0) {
    return 0;
  }
  return 0;
}

int main(int argc, char *argv[]) {
  int ret = 0;
  unsigned char in[4096];
  int inlen;
  unsigned char out[4096];
  int outlen = 0;

  strcpy((char *)in, "liukanglai");
  inlen = 9;

  CSocketProtocol *sp = 0;
  sp = new CSckFactoryImp1;

  ret = SckSendAndRev(sp, in, inlen, out, &outlen);
  if (ret != 0) {
    std::printf("func SckSendAndRev() err:%d\n", ret);
    return ret;
  }
  delete sp;

  std::cout << "hello..." << std::endl;
  return ret;
}
