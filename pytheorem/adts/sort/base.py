#
# Author: Rohtash Lakra
#
from abc import abstractmethod, ABC
from enum import auto, unique
from typing import Any

from pytheorem.enums.base import BaseEnum
from pytheorem.leetcode.merge import logger


@unique
class SortOrder(BaseEnum):
    ASC = auto()
    DESC = auto()


class AbstractSort(ABC):

    @abstractmethod
    def sortAsc(self, items: Any) -> Any:
        raise NotImplementedError()

    @abstractmethod
    def sortDesc(self, items: Any) -> Any:
        raise NotImplementedError()

    def sort(self, items: Any, order: SortOrder) -> Any:
        logger.debug("+sort(%s)", items)
        if SortOrder.ASC == order:
            return self.sortAsc(items)
        elif SortOrder.DESC == order:
            return self.sortDesc(items)
        else:
            raise NotImplementedError()
