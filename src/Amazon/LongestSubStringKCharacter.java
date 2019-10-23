package Amazon;

import java.util.HashSet;

/*
""" Asked by: Amazon [Hard]
Given an integer k and a string s, find the length of the longest substring that contains at most k
distinct characters.
For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
"""
 */
public class LongestSubStringKCharacter {

    String longestString = "";
    public static void main(String s[]) {
        LongestSubStringKCharacter longestSubStringKCharacter = new LongestSubStringKCharacter();
        String word = "abcba";
        longestSubStringKCharacter.findLongestSubStringKDistinctElement(word, 0, word.length()-1, 2);
        System.out.println(longestSubStringKCharacter.longestString);
    }

    public String findLongestSubStringKDistinctElement(String word, int i, int j,  int k) {

        if(!word.isEmpty())
           {
            if(countOfDistinctElement(word, i, j) == k) {
                return word.substring(i, j);
            }

            else{
                String currWord = findLongestSubStringKDistinctElement(word, i, j-1, k);
                String currWord1 = findLongestSubStringKDistinctElement(word, i+1, j, k);

                if(currWord.length() >= longestString.length() && currWord1.length() >= currWord.length())
                    longestString = currWord1;
                else  if(currWord1.length() >= longestString.length() && currWord.length() >= currWord1.length())
                    longestString = currWord;
            }
        }

        return longestString;
    }

    private int countOfDistinctElement(String word, int start, int end) {
        HashSet<String> set = new HashSet<>();
        for( int i = start; i< end; i++) {
            set.add(word.charAt(i)+"");
        }
        return set.size();
    }
}
