#include "uthash.h"

struct hashTable {
  int key;
  int val;
  UT_hash_handle hh;
};

int canConstruct0(char* ransomNote, char* magazine) {
  struct hashTable* hashtable = NULL;
  for (int i = 0; i < strlen(magazine); i++) {
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &(magazine[i]),
                  tmp);  // 出错了，不理解。。。
                         // 应该是哈希表寻找只能用int型的指针，不能用char的。
    if (tmp == NULL) {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = magazine[i], tmp->val = 1;
      HASH_ADD_INT(hashtable, key, tmp);
    } else {
      (tmp->val)++;
    }
  }
  for (int i = 0; i < strlen(ransomNote); i++) {
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &(ransomNote[i]), tmp);
    if (tmp == NULL || tmp->val <= 0) {
      return 0;
    } else {
      (tmp->val)--;
    }
  }
  return 1;
}
bool canConstruct(char* ransomNote, char* magazine) {
  struct hashTable* hashtable = NULL;
  for (int i = 0; i < strlen(magazine); i++) {
    int ikey = magazine[i];
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &ikey, tmp);
    if (tmp == NULL) {
      tmp = malloc(sizeof(struct hashTable));
      tmp->key = magazine[i], tmp->val = 1;
      HASH_ADD_INT(hashtable, key, tmp);
    } else {
      (tmp->val)++;
    }
  }
  for (int i = 0; i < strlen(ransomNote); i++) {
    int ikey = ransomNote[i];
    struct hashTable* tmp;
    HASH_FIND_INT(hashtable, &ikey, tmp);
    if (tmp == NULL || tmp->val <= 0) {
      return 0;
    } else {
      (tmp->val)--;
    }
  }
  return 1;
}
/*
 class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        if (ransomNote.size() > magazine.size()) {
            return false;
        }
        vector<int> cnt(26);
        for (auto & c : magazine) {
            cnt[c - 'a']++;
        }
        for (auto & c : ransomNote) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
};

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/ransom-note/solution/shu-jin-xin-by-leetcode-solution-ji8a/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
