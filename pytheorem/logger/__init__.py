#
# Author: Rohtash Lakra
#
# from pytheorem.logger.logutils import RequestIdFilter
#
# reqeustIdFilter = RequestIdFilter()
# https://dev.to/camillehe1992/mask-sensitive-data-using-python-built-in-logging-module-45fa

import logging

UTF_8 = 'utf-8'


def configLogger():
    # Configure default loggers
    logging.basicConfig(level=logging.DEBUG, format="[%(asctime)s] [%(process)d] [%(levelname)s] - %(message)s")


def getLogger(__name__):
    return logging.getLogger(__name__)

configLogger()

# init logger
# logger = getLogger(__name__)
