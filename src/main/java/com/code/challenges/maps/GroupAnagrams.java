package com.code.challenges.maps;

import com.sun.source.tree.BreakTree;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.*;

/*

Statement:

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

    private static void groupAnagram(String[] anagrams) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String anagram: anagrams) {
            //sort anagram String
            char[] anagramArrKey = anagram.toCharArray();
            Arrays.sort(anagramArrKey);
            String anagramKey = Arrays.toString(anagramArrKey);

            if(anagramMap.containsKey(anagramKey)) {
                anagramMap.get(anagramKey).add(anagram);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(anagram);
                anagramMap.put(anagramKey, anagramList);
            }
        }
        System.out.println(anagramMap);

        List< List<String>> output = anagramMap.values().stream().toList();
        System.out.println(output);
    }
}
