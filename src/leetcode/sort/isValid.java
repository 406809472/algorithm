package leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合
 */
public class isValid {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || c == ')' && stack.pop() != '(' || c == ']' && stack.pop() != '[' || c == '}' && stack.pop() != '{') {
                return false;
            }
        }
        return stack.isEmpty();

    }

    /**
     * 删除有序数组中的重复项
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        Object[] array = treeSet.toArray();
        for (int i = 0; i < array.length; i++) {
            nums[i] = (int) array[i];
        }
        return array.length;

    }
    public int findLucky(int[] arr) {
        int[] count = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=arr.length){
                count[arr[i]-1]++;
            }
        }
        int ans = -1;
        for(int i = 0;i<count.length;i++){
            if(count[i] == i+1){
                ans = count[i]>ans?count[i]:ans;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[] arr = new int[]{2,2,3,4};
        System.out.println(findLucky(arr));
    }
}
