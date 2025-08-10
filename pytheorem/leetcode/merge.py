#
# Author: Rohtash Lakra
#
from collections import defaultdict
from typing import List

from pytheorem.logger import getLogger

logger = getLogger(__name__)


class LC721AccountsMerge:
    """
    URL: https://leetcode.com/problems/merge-lc721-accounts

    721. Accounts Merge
    Given a list of accounts where each element accounts[i] is a list of strings, where the first element
    accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

    Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some
    common email to both accounts. Note that even if two accounts have the same name, they may belong to different
    people as people could have the same name. A person can have any number of accounts initially, but all of their
    accounts definitely have the same name.

    After merging the accounts, return the accounts in the following format: the first element of each account is the
    name, and the rest of the elements are emails in sorted order.
    The accounts themselves can be returned in any order.
    """

    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        logger.debug("+accountsMerge(%s)", accounts)
        merged_accounts = []
        owners = defaultdict(list)

        all_accounts = []
        accounts_map = defaultdict(list)
        for account in accounts:
            all_accounts.append((account[0], account[1]))
            accounts_map[account[0]].append(account[1])

        logger.debug("all_accounts=%s", all_accounts)

        # iterate each item of an account
        for _, (account, email) in enumerate(all_accounts):
            if email in owners[account]:
                # merge the accounts if name is not similar
                owners[account].extend(accounts_map[account])
            else:
                owners[account].append(email)
        logger.debug("owners=%s", owners)

        for account, emails in owners.items():
            merged_accounts.append([account, *set(owners[account])])

        logger.debug("-accountsMerge(), merged_accounts=%s", merged_accounts)
        return merged_accounts
