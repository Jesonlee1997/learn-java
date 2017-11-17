package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author lijs
 * @date 17-11-12.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int[] dp = new int[s.length()];
            int start = 0;
            int end = 0;
            int longest = 0;
            for (int i = 0; i < s.length(); i++) {
                Integer j;
                Character c = s.charAt(i);
                if ((j = map.get(c)) != null) {
                    if (j >= start) {
                       start = j + 1;
                    }
                }
                map.put(c, i);
                end = i;
                longest = Math.max(longest, end - start + 1);
            }
            return longest;
        }

        public static void main(String[] args) {
            System.out.println(new Solution().lengthOfLongestSubstring("ababcabcda"));
        }
    }
}
