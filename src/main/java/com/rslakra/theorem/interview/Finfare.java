package com.rslakra.theorem.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 09/01/2025 8:36 AM
 */
public class Finfare {

    class Transaction {
        String account;
        String id;
        String type;
        int amount;

        Transaction(String input) {
            String[] tokens = input.split(" ");
            this.account = tokens[0];
            this.id = tokens[1];
            this.type = tokens[2];
            this.amount = Integer.parseInt(tokens[3]);
        }

        @Override
        public String toString() {
            return "Transaction <" +
                    "account=" + account +
                    ", id=" + id +
                    ", type=" + type +
                    ", amount=" + amount +
                    '>';
        }
    }

    final Map<String, List<Transaction>> transactions = new HashMap<>();
    final Map<String, Integer> balances = new HashMap<>();

    public void preProcessor(List<String> transactionLogs) {
        for (String trx : transactionLogs) {
            Transaction tx = new Transaction(trx);
            List<Transaction> transactions = this.transactions.getOrDefault(tx.account, new ArrayList<>());
            transactions.add(tx);
            this.transactions.put(tx.account, transactions);
            int balance = balances.getOrDefault(tx.account, 0);
            if (tx.type.equals("deposit")) {
                balance += tx.amount;
            } else {
                balance -= tx.amount;
            }

            balances.put(tx.account, balance);
        }
    }

    public void printTx(String accountId) {
        System.out.println(transactions.get(accountId) + ", balance:" + balances.get(accountId));
    }


    public static void main(String[] args) {
        System.out.println("Hello world");

        // 1. Print transactions for a given account
        // 2. Get ending balances for each account

        Finfare instance = new Finfare();
        List<String> transactionLogs = List.of(
                "AcctA Tx1 deposit 3",
                "AcctB Tx2 deposit 4",
                "AcctA Tx3 withdraw 1",
                "AcctA Tx4 deposit 2",
                "AcctB Tx5 withdraw 2",
                "AcctC Tx6 deposit 5",
                "AcctC Tx7 withdraw 3",
                "AcctB Tx8 deposit 2"
        );

        instance.preProcessor(transactionLogs);
        instance.printTx("AcctA");
    }
}
