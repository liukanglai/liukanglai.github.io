int smallestEvenMultiple(int n) {
  if (n % 2 == 0) {
    return n;
  }
  return 2 * n;
}

int smallestEvenMultiple(int n) {
  return n % 2 == 0 ? n : 2 * n;
}
