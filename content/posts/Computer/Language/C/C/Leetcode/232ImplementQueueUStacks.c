typedef struct {
  int stackIn[100];
  int stackOut[100];
  int in;
  int out;
} MyQueue;

MyQueue* myQueueCreate() {
  MyQueue* obj = malloc(sizeof(MyQueue));
  memset(obj->stackIn, 0, sizeof(obj->stackIn));
  memset(obj->stackOut, 0, sizeof(obj->stackOut));
  obj->in = 0, obj->out = 0;
  return obj;
}

void myQueuePush(MyQueue* obj, int x) { obj->stackIn[(obj->in)++] = x; }

int myQueuePop(MyQueue* obj) {
  if (obj->out == 0) {
    if (obj->in == 0) {
      return NULL;
    }
    while (obj->in > 0) {
      obj->stackOut[(obj->out)++] = obj->stackIn[--(obj->in)];
    }
  }
  (obj->out)--;
  return obj->stackOut[obj->out];
}

int myQueuePeek(MyQueue* obj) {
  if (obj->out == 0) {
    if (obj->in == 0) {
      return NULL;
    }
    while (obj->in > 0) {
      obj->stackOut[(obj->out)++] = obj->stackIn[--(obj->in)];
    }
  }
  return obj->stackOut[(obj->out) - 1];
}

bool myQueueEmpty(MyQueue* obj) {
  if (obj->in == 0 && obj->out == 0) {
    return 1;
  }
  return 0;
}

void myQueueFree(MyQueue* obj) {
  obj->in = 0;
  obj->out = 0;
  free(obj);  // ！！！
}

/**
 * Your MyQueue struct will be instantiated and called as such:
 * MyQueue* obj = myQueueCreate();
 * myQueuePush(obj, x);

 * int param_2 = myQueuePop(obj);

 * int param_3 = myQueuePeek(obj);

 * bool param_4 = myQueueEmpty(obj);

 * myQueueFree(obj);
*/
