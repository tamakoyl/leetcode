from functools import lru_cache
from typing import List

class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        n = len(price)

        # 不使用大礼包直接进行购买
        def without_special(needs):
            return sum(needs[i] * price[i] for i in range(n))

        # 缓存不同 needs 状态的最小花费，避免重复计算
        # lru_cache 会自动缓存函数的 输入参数和返回值的对应关系
        @lru_cache(None)
        def dfs(remaining_needs):
            # 如果需求已完全满足，花费为 0
            if all(x == 0 for x in remaining_needs):
                return 0

            min_cost = without_special(remaining_needs)

            # 遍历每个礼包
            for offer in special:
                new_needs = []
                for j in range(n):
                    # 如果礼包中某个物品数量超过当前需求，则跳过
                    if remaining_needs[j] < offer[j]:
                        break
                    # 计算使用当前礼包后的新需求
                    new_needs.append(remaining_needs[j] - offer[j])
                else:
                    # 礼包可用时，递归计算使用该礼包后的最小花费
                    min_cost = min(min_cost, offer[-1] + dfs(tuple(new_needs)))
            
            return min_cost

        # 初始调用，属于的是shoppingOffers的方法
        return dfs(tuple(needs))

# 示例用法
price = [2, 5]
special = [[3, 0, 5], [1, 2, 10]]
needs = [3, 2]
solution = Solution()
print("最低花费:", solution.shoppingOffers(price, special, needs))  # 输出应为 14
