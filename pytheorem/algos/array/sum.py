#
# Author: Rohtash Lakra
#
class LC1TwoSum:

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = dict()
        for index, num in enumerate(nums):
            # print(f"index={index}, num={num}")
            diff = target - num
            # if diff in map.keys():
            # if diff in map:
            if map.__contains__(diff):
                return [map[diff], index]
            else:
                map[num] = index

        return [-1, -1]


instance = LC1TwoSum()
# Example 1:
#
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
#
result = instance.twoSum([2,7,11,15], 9)
print(result)
print()
result = instance.twoSum([2,11,15,7], 9)
print(result)
