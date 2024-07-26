char *toLowerCase(char *s) {
  int i = 0;
  while (s[i] != '\0') {
    if(s[i++] >= 97)
      continue;
    s[i++] += 32;
  }
  return s;
}
