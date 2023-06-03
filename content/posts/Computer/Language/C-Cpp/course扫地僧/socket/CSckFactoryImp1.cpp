#include <cstdlib>
#include <cstring>

#include "head/CSckFactoryImp1.h"

int CSckFactoryImp1::cltSocketInit(/*out*/) {
  p = 0;
  len = 0;
  return 0;
}
// 客户端发报文
int CSckFactoryImp1::cltSocketSend(unsigned char *buf /*in*/,
                                   int buflen /*in*/) {
  p = (unsigned char *)malloc(sizeof(unsigned char) * buflen);
  if (p == 0) {
    return -1;
  }
  memcpy(p, buf, buflen);
  len = buflen;
  return 0;
}
// 客户端收报文
int CSckFactoryImp1::cltSocketRev(unsigned char *buf /*in*/,
                                  int *buflen /*in out*/) {
  if (buf == 0 || buflen == 0) {
    return -1;
  }
  *buflen = this->len;
  memcpy(buf, this->p, this->len);
  return 0;
}
// 客户端释放资源
int CSckFactoryImp1::cltSocketDestory() {
  if (p != 0) {
    free(p);
    p = 0;
    len = 0;
  }

  return 0;
}
