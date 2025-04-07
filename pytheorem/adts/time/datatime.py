#
# Author: Rohtash Lakra
#
import logging
import time

logger = logging.getLogger(__name__)


def now() -> float:
    """Returns current time as float."""
    return time.time()


def timeMillis() -> int:
    """Returns current time in milliseconds."""
    return int(time.time() * 1000)
