package sort.leetcode.queue;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 */
public class findFirst {
    public  char firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == null) {
                hashMap.put(chars[i], 0);
            }
            hashMap.put(chars[i], hashMap.get(chars[i]) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            Integer times = hashMap.get(chars[i]);
            if (times == 1){
                return chars[i];
            }
        }
        return ' ';
    }
    // 计数数组
    public char firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) count[c - 'a']++;
        for (char c : chars) {
            if (count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
