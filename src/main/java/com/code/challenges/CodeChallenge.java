package com.code.challenges;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.*;


/**
 * =============================================================================
 * CODE CHALLENGE: Transaction Log Parser
 * =============================================================================
 *
 * CONTEXT:
 * You are given a list of transaction logs from a payment system.
 * Each log entry has the format: "user_id|action|amount"
 * Actions can be: DEPOSIT or WITHDRAWAL
 *
 *
 *
 * TASKS:
 * 1. Parse the logs and compute the NET BALANCE for each user.
 *    Net balance = sum of deposits - sum of withdrawals.
 *    Print each user and their balance, sorted alphabetically by user_id.
 *
 * 2. Find and print the user with the HIGHEST net balance.
 *    If there's a tie, print any one of them.
 *
 * 3. Print the MOST FREQUENT character in all user_ids combined
 *    (excluding duplicates from repeated log entries of the same user).
 *    In other words, count characters across the SET of unique user_ids.
 *    If there's a tie, print any one of them.
 *
 * EXPECTED OUTPUT for the provided input:
 *
 *    --- Net Balances ---
 *    user_07: 250.00
 *    user_13: 50.00
 *    user_42: 325.00
 *
 *    --- Highest Balance ---
 *    user_42: 325.00
 *
 *    --- Most Frequent Char in User IDs ---
 *    '_': 3
 *
 * NOTES:
 * - You may use any standard library classes.
 * - Focus on correctness first, then code clarity.
 * - Feel free to create helper methods.
 * =============================================================================
 */

public class CodeChallenge {

    public static class UserInfo {
        private String userId;
        private String actionType;
        private double amount;

        public UserInfo(String userId, String actionType, double amount) {
            this.userId = userId;
            this.actionType = actionType;
            this.amount = amount;
        }

        public String getUserId() {
            return userId;
        }

        public UserInfo setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getActionType() {
            return actionType;
        }

        public UserInfo setActionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        public double getAmount() {
            return amount;
        }

        public UserInfo setAmount(double amount) {
            this.amount = amount;
            return this;
        }
    }

    static final List<String> LOGS = List.of(
            "user_42|DEPOSIT|150.00",
            "user_13|WITHDRAWAL|30.00",
            "user_42|DEPOSIT|200.00",
            "user_07|WITHDRAWAL|50.00",
            "user_13|DEPOSIT|100.00",
            "user_42|WITHDRAWAL|75.00", //275
            "user_07|DEPOSIT|300.00",
            "user_13|WITHDRAWAL|20.00",
            "user_42|DEPOSIT|50.00" // 325
    );

    public static void main(String[] args) {


        // TASK 1: Parse logs and compute net balance per user.
        //         Print sorted alphabetically by user_id.
        //         Format: "user_id: balance" (2 decimal places)
        System.out.println("--- Net Balances ---");
        // TODO: Implement here

        Map<String, Double> userBalanceMap = new HashMap<>();

        List<UserInfo> userInfoList = LOGS.stream().map( s -> {
            String[] userInfoArr = s.split("\\|");
            return new UserInfo(userInfoArr[0], userInfoArr[1], Double.parseDouble(userInfoArr[2]) );
        }).sorted( (a, b) ->a.getUserId().compareTo(b.getUserId())).toList();

        for(int i = 0; i < userInfoList.size() ; i++) {

            if( userBalanceMap.get(userInfoList.get(i).getUserId()) != null) {
                // it exist
                if(userInfoList.get(i).getActionType().equals("DEPOSIT")) {
                    Double amountToAddd = userBalanceMap.get(userInfoList.get(i).getUserId());
                    double total = userInfoList.get(i).getAmount() + amountToAddd;
                    userBalanceMap.put(userInfoList.get(i).getUserId(), total);
                } else {
                    Double amountToAddd = userBalanceMap.get(userInfoList.get(i).getUserId());
                    double total = userInfoList.get(i).getAmount() - amountToAddd;
                    userBalanceMap.put(userInfoList.get(i).getUserId(), total);
                }

            } else {
                if(userInfoList.get(i).getActionType().equals("DEPOSIT")) {
                    userBalanceMap.put(userInfoList.get(i).getUserId(), userInfoList.get(i).getAmount());
                } else
                    userBalanceMap.put(userInfoList.get(i).getUserId(), -userInfoList.get(i).getAmount());
            }
        }

        userBalanceMap.entrySet().stream().forEach( m -> {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
            System.out.println();
        });


        // TASK 2: Find and print the user with the highest net balance.
        System.out.println("\n--- Highest Balance ---");
        // TODO: Implement here




        // TASK 3: Collect the SET of unique user_ids, then count character
        //         frequency across all of them. Print the most frequent char.
        //         Format: "'char': count"
        System.out.println("\n--- Most Frequent Char in User IDs ---");
        // TODO: Implement here


    }
}

