#
# Author: Rohtash Lakra
#
class Math:

    @staticmethod
    def max(left: int, right: int) -> int:
        """Returns the max value of the left and right"""
        return left if left > right else right

    @staticmethod
    def min(left: int, right: int) -> int:
        """Returns the min value of the left and right"""
        return left if left < right else right

    pass
