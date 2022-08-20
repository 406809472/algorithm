package leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

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

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    @Test
    public void test(){
        int[] arr = new int[]{2,2,3,4};
        System.out.println(findLucky(arr));
    }
}
