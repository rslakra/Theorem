#
# Author: Rohtash Lakra
#
import logging

logger = logging.getLogger(__name__)


def longest_substring_with_k_unique_chars(input: str, k: int) -> str:
    """
    Finds the longest substring with exactly k unique characters.

    Args:
        input (str): The input string.
        k (int): The number of unique characters.

    Returns:
        str: The longest substring, or an empty string if none found.
    """
    logger.debug(f"+longest_substring_with_k_unique_chars({input}, {k})")
    if input is None or len(input) < k:
        logger.debug("-longest_substring_with_k_unique_chars(), return empty")
        return ""

    startIndex, endIndex = 0, 0
    longest_substring = ""
    char_freq = {}

    while endIndex < len(input):
        logger.debug(f"char_freq={char_freq}")
        char_freq[input[endIndex]] = char_freq.get(input[endIndex], 0) + 1

        while len(char_freq) > k:
            char_freq[input[startIndex]] -= 1
            if char_freq[input[startIndex]] == 0:
                logger.debug(f"Removing char={input[startIndex]}")
                del char_freq[input[startIndex]]

            startIndex += 1

        logger.debug(f"startIndex={startIndex}, endIndex={endIndex}, , longest_substring={longest_substring}")
        if endIndex - startIndex + 1 > len(longest_substring):
            longest_substring = input[startIndex:endIndex + 1]

        endIndex += 1

    logger.debug(f"-longest_substring_with_k_unique_chars(), longest_substring={longest_substring}")
    return longest_substring


def longest_substring_of_k_unique_chars(input: str) -> str:
    """
    Finds the longest substring with exactly k unique characters.

    Args:
        input (str): The input string.
        k (int): The number of unique characters.

    Returns:
        str: The longest substring, or an empty string if none found.
    """
    logger.debug(f"+longest_substring_of_k_unique_chars({input})")
    if input is None:
        logger.debug("-longest_substring_of_k_unique_chars(), return empty")
        return ""

    k = int(input[0])
    temp_word = word = input[1:k + 1]
    endIndex = k
    while endIndex < len(input) - 1:
        if len(set(temp_word)) <= k:
            if len(temp_word) > len(word):
                word = temp_word
            endIndex += 1
            temp_word = temp_word + input[endIndex]
        else:
            temp_word = temp_word[1:len(temp_word)]

    if len(temp_word) > len(word):
        word = temp_word

    logger.debug(f"-longest_substring_of_k_unique_chars(), word={word}")
    return word
