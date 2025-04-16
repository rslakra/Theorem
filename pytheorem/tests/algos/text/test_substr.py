#
# Author: Rohtash Lakra
#
import logging

from pytheorem.algos.text.substr import longest_substring_of_k_unique_chars
from pytheorem.algos.text.substr import longest_substring_with_k_unique_chars
from pytheorem.tests.base import AbstractTestCase

logger = logging.getLogger(__name__)


class SubStrTest(AbstractTestCase):

    def test_longest_substring_with_k_unique_chars(self):
        """Tests 'longest_substring_with_k_unique_chars' method"""
        logger.debug("+test_longest_substring_with_k_unique_chars()")
        inputData = [
            (None, 1, ''),
            ("longest", 7, 'longest'),
            ("abcaaabc", 2, 'caaa'),
        ]
        for input, k, expected in inputData:
            logger.debug(f"input={input}, k={k}, expected={expected}")
            longest_substring = longest_substring_with_k_unique_chars(input, k)
            logger.debug(f"longest_substring={longest_substring}")
            self.assertEqual(expected, longest_substring)

        logger.debug("-test_longest_substring_with_k_unique_chars()")
        print()

    def test_longest_substring_of_k_unique_chars(self):
        """Tests 'longest_substring_with_k_unique_chars' method"""
        logger.debug("+test_longest_substring_of_k_unique_chars()")
        inputData = [
            ("7longest", 'longest'),
            ("2abcaaabc", 'aaabc'),
        ]
        for input, expected in inputData:
            longest_substring = longest_substring_of_k_unique_chars(input)
            logger.debug(f"longest_substring={longest_substring}")
            self.assertEqual(expected, longest_substring)

        logger.debug("-test_longest_substring_of_k_unique_chars()")
        print()
