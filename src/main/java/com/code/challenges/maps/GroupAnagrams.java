package com.code.challenges.maps;

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

    private static List<List<String>> groupAnagram(String[] anagrams) {
        // Key -> Anagram Key
        // Value -> List of anagrams related to the Key

        Map<String, List<String>> anagramsMap = new HashMap<>();

        for(String anagram: anagrams) {

            char[] anagramArr = anagram.toCharArray();
            Arrays.sort(anagramArr);

            if(anagramsMap.containsKey(Arrays.toString(anagramArr))) {

                anagramsMap.get(Arrays.toString(anagramArr)).add(anagram);

            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(anagram);
                anagramsMap.put(Arrays.toString(anagramArr), anagramList);
            }
        }

        System.out.println(anagramsMap);

        List<List<String>> anagramResp = anagramsMap.entrySet().stream().map( entryValue -> entryValue.getValue()).toList();
        System.out.println(anagramResp);
        return anagramResp;
    }
}
