#
# Author: Rohtash Lakra
#
from typing import List

from parameterized import parameterized

from pytheorem.adts.sort.base import SortOrder
from pytheorem.algos.sort.insertion import InsertionSort
from pytheorem.logger import getLogger
from pytheorem.tests.base import AbstractTestCase

logger = getLogger(__name__)


class InsertionSortTest(AbstractTestCase):

    @classmethod
    def setUpClass(cls):
        # set app at class level
        cls.instance = InsertionSort()
        logger.debug("InsertionSortTest()")

    @parameterized.expand([
        ([
             [23, 1, 89, 39, 71, 82],
             [23, 87, 8, 39, 9, 82],
             [10, 56, 20, 78, 19, 90]
         ],
         [
             [1, 23, 39, 71, 82, 89],
             [8, 9, 23, 39, 82, 87],
             [10, 19, 20, 56, 78, 90]
         ]),
    ])
    def testSortAsc(self, input_list: List[List[int]], expected: List[List[int]]):
        logger.debug("testSortAsc() -> input_list=%s, expected=%s", input_list, expected)
        # instance = InsertionSort()
        for index, items in enumerate(input_list):
            result = self.instance.sort(items, SortOrder.ASC)
            logger.debug("result=%s", result)
            assert result == expected[index]

    @parameterized.expand([
        ([
             [23, 1, 89, 39, 71, 82],
             [23, 87, 8, 39, 9, 82],
             [10, 56, 20, 78, 19, 90]
         ],
         [
             [89, 82, 71, 39, 23, 1],
             [87, 82, 39, 23, 9, 8],
             [90, 78, 56, 20, 19, 10]
         ]),
    ])
    def testSortDesc(self, input_list: List[List[int]], expected: List[List[int]]):
        logger.debug("testSortDesc() -> input_list=%s, expected=%s", input_list, expected)
        for index, items in enumerate(input_list):
            result = self.instance.sort(items, SortOrder.DESC)
            logger.debug("result=%s", result)
            assert result == expected[index]
