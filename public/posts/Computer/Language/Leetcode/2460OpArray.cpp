#include <vector>

class Solution {
 public:
  std::vector<int> applyOperations(std::vector<int>& nums) {
    for (auto i = nums.begin(); i != nums.end() - 1; i++) {
      if (*i == *(i + 1)) {
        *i = *i * 2;
        *(i + 1) = 0;
      }
    }
    return shift0End(nums);
  }

  std::vector<int> shift0End(std::vector<int>& nums) {
    auto j = nums.begin();
    while (j < nums.end() && *(j++) != 0)
      ;
    auto i = j - 1;
    while (j < nums.end()) {
      if (*j != 0) {
        auto tem = *i;
        *i = *j;
        *j = tem;
        i++;
        j++;
      } else {
        j++;
      }
    }
    return nums;
  }
};
class S_Solution {
 public:
  std::vector<int> applyOperations(std::vector<int>& nums) {
    auto j = nums.begin();
    auto i = nums.begin();
    for (; i != nums.end() - 1; i++) {
      if (*i == *(i + 1)) {
        *i = *i * 2;
        *(i + 1) = 0;
      }
      if (*i != 0) {
        if (i != j) std::swap(*i, *j);
        j++;
      }
    }
    if (*i != 0) {
      std::swap(*i, *j);
    }
    return nums;
  }
};
