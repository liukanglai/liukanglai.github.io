/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
double* convertTemperature(double celsius, int* returnSize) {
    double *ans = malloc(2*sizeof(double));
    if(ans == NULL){ // 注意NULL
      *returnSize = 0;
      return NULL;
    }
    ans[0] = celsius  + 273.15;
    ans[1] = celsius * 1.80 + 32.00;
    *returnSize = 2;
    return ans;
}
