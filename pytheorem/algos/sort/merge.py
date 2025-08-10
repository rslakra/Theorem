#
# Author: Rohtash Lakra
#
from typing import Any

from pytheorem.adts.sort.base import AbstractSort
from pytheorem.logger import getLogger

logger = getLogger(__name__)


class MergeSort(AbstractSort):

    def sortAsc(self, items: Any) -> Any:
        logger.debug("+sortAsc(%s)", items)
        pass

    def sortDesc(self, items: Any) -> Any:
        logger.debug("+sortDesc(%s)", items)
        pass
