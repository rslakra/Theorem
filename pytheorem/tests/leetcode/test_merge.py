#
# Author: Rohtash Lakra
#
from collections import defaultdict
from typing import List

from parameterized import parameterized

from pytheorem.adts.array.union_find import UnionFind
from pytheorem.leetcode.merge import LC721AccountsMerge
from pytheorem.logger import getLogger
from pytheorem.tests.base import AbstractTestCase

logger = getLogger(__name__)


class LC721AccountsMergeTest(AbstractTestCase):

    @parameterized.expand([
        # Example 1:
        # Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john_texas@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        # Output: [["John","john_texas@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        # Explanation:
        # The first and second John's are the same person as they have the common email "johnsmith@mail.com".
        # The third John and Mary are different people as none of their email addresses are used by other accounts.
        # We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
        # ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
        ([
             ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
             ["John", "johnsmith@mail.com", "john_texas@mail.com"],
             ["Mary", "mary@mail.com"],
             ["John", "johnnybravo@mail.com"]
         ],
         [
             ["John", "john_newyork@mail.com", "johnsmith@mail.com", "john_texas@mail.com"],
             ["Mary", "mary@mail.com"],
             ["John", "johnnybravo@mail.com"]
         ]),

        # Example 2:
        # Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
        # Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
        # ([
        #      ["Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"],
        #      ["Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"],
        #      ["Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"],
        #      ["Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"],
        #      ["Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"]
        #  ],
        #  [
        #      ["Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"],
        #      ["Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"],
        #      ["Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"],
        #      ["Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"],
        #      ["Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co"]
        #  ])
    ])
    def testAccountsMerge(self, accounts: List[List[str]], expected: List[List[str]]):
        logger.debug("testAccountsMerge() -> accounts=%s, expected=%s", accounts, expected)
        instance = LC721AccountsMerge()
        result = instance.accountsMerge(accounts)
        print(result)
        assert result == expected


def accounts_merge(accounts):
    uf = UnionFind(len(accounts))
    email_mapping = {}

    for i, account in enumerate(accounts):
        emails = account[1:]

        for email in emails:
            if email in email_mapping:
                if account[0] != accounts[email_mapping[email]][0]:
                    return
                uf.union(email_mapping[email], i)

            email_mapping[email] = i

    merged_accounts = defaultdict(list)
    for email, ids in email_mapping.items():
        merged_accounts[uf.find(ids)].append(email)

    final_merged = []

    for parent, emails in merged_accounts.items():
        final_merged.append([accounts[parent][0]] + sorted(emails))
    return final_merged


# driver code
def main():
    all_accounts = [[["Emma", "emma@mail.com", "emma_work@mail.com"], ["Bob", "bob_home@mail.com", "bob123@mail.com"],
                     ["Emma", "emma_art@mail.com", "emma_work@mail.com"], ["Bob", "bob321@mail.com"]],
                    [["John", "johnsmith@mail.com", "john_newyork@mail.com"],
                     ["John", "johnsmith@mail.com", "john00@mail.com"], ["Mary", "mary@mail.com"],
                     ["John", "johnnybravo@mail.com"]],
                    [["Sarah", "sarah@mail.com", "sh@mail.com"], ["Sarah", "sarah1@mail.com", "sarahh@mail.com"],
                     ["Sarah", "sh3@mail.com"]],
                    [["Alice", "alice@mail.com"], ["Alice", "alice_alice@mail.com", "alice@mail.com"],
                     ["Alice", "alice@mail.com", "alice123@mail.com", "aalicee@mail.com"]],
                    [["Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"],
                     ["Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"],
                     ["Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"],
                     ["Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"],
                     ["Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"]]]

    for i in range(len(all_accounts)):
        print(i + 1, ".\tAccounts: \n\t[", sep="")
        for a in all_accounts[i]:
            print("\t", a)
        print("\t]")

        merged = accounts_merge(all_accounts[i])

        if (merged == None):
            print("Error!\nAccounts sharing some email(s) should have the same names.")
            return

        print("\n\tMerged accounts: \n\t[")
        for m in merged:
            print("\t", m)
        print("\t]")
        print("-" * 100)


if __name__ == '__main__':
    main()
