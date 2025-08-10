#
# Author: Rohtash Lakra
#
from typing import Any

from pytheorem.adts.sort.base import AbstractSort
from pytheorem.logger import getLogger

logger = getLogger(__name__)


class InsertionSort(AbstractSort):

    def sortAsc(self, items: Any) -> Any:
        logger.debug("+sortAsc(%s)", items)
        for index, item in enumerate(items):
            # logger.debug("index=%s, item=%s", index, item)
            last_index = index
            for i in range(index, 0, -1):
                if items[i - 1] > item:
                    # move the current item to next
                    items[i] = items[i - 1]
                    last_index = i - 1
                else:
                    break

            # logger.debug("last_index=%s", last_index)
            # insert the item at the last index
            items[last_index] = item

        logger.debug("-sortAsc(), items=%s", items)
        return items

    def sortDesc(self, items: Any) -> Any:
        logger.debug("+sortDesc(%s)", items)
        for index, item in enumerate(items):
            last_index = index
            for i in range(index, 0, -1):
                if items[i - 1] < item:
                    # move the current item to next
                    items[i] = items[i - 1]
                    last_index = i - 1
                else:
                    break

            # logger.debug("last_index=%s", last_index)
            # insert the item at the last index
            items[last_index] = item

        logger.debug("-sortDesc(), items=%s", items)
        return items

    # def sort(self, items: Any, order: SortOrder) -> Any:
    #     if SortOrder.ASC == order:
    #         return self.sortAsc(items)
    #     elif SortOrder.DESC == order:
    #         return self.sortDesc(items)
    #
    #     return None
