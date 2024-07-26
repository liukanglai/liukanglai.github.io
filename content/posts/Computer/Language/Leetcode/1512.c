int numIdenticalPairs(int *nums, int numsSize) {
  int shu[101] = {0};
  int count = 0;
  for (int i = 0; i < numsSize; i++) {
    shu[nums[i]]++;
    count += shu[nums[i]] - 1;
  }
  return count;
}
