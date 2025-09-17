package com.code.challenges.maps;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.*;

/*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Explanation:
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
    Example 2:
    Input: strs = [""]
    Output: [[""]]
    Example 3:
    Input: strs = ["a"]
    Output: [["a"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
        groupAnagram(anagrams);
    }

    private static List<List<String>> groupAnagram(String[] anagrams) {
        // Key -> Anagram Key
        // Value -> List of anagrams related to the Key
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(int i = 0; i < anagrams.length; i++) {

            // Store a Key into the Map
            // before => sort: anagrams[i] Char Sequence
            char[] tempCharArray = anagrams[i].toCharArray();
            Arrays.sort(tempCharArray);
            String key = Arrays.toString(tempCharArray);

            if(anagramMap.containsKey(key)) {
                // Append Anagram
                anagramMap.get(key).add(anagrams[i]);
            } else {
                // Insert Anagram
                List<String> initialAnagramList = new ArrayList<>();
                initialAnagramList.add(anagrams[i]);
                anagramMap.put(key, initialAnagramList);
            }
        }

        List<List<String>> a = anagramMap.entrySet().stream().map(Map.Entry::getValue).toList();

        List<String> b = anagramMap.entrySet().stream()
                .map(Map.Entry::getValue).toList().getFirst();

        //System.out.println(b);

        return a;
    }
}
