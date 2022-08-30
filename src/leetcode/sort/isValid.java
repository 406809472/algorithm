package leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.lang.Math.abs;

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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr.length) {
                count[arr[i] - 1]++;
            }
        }
        int ans = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == i + 1) {
                ans = count[i] > ans ? count[i] : ans;
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

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
     * 如果存在，返回 true ；否则，返回 false 。
     *滑动窗口
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet set = new HashSet();
        for(int i  = 0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
    @Test
    public void test() {
        int[] arr = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(arr, 1));
    }

    /**
     * 给你一个包含 n 个整数nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList();
        if (nums == null || nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return lists;
            }
            if (i>0 &&nums[i] == nums[i-1]){
                continue;
            }
            int cur = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int temp =cur + nums[left] + nums[right];
                if (temp == 0){
                    List<Integer> list = new ArrayList();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left<right && nums[left] == nums[left+1])left++;
                    while (left<right && nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }else if (temp<0){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return lists;
    }
}
