package dataStructrue;

import dataStructrue.sort.Sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,6,8,345,45,7,2,4,56,3,85,3,7,4,6};
        Sort.selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
