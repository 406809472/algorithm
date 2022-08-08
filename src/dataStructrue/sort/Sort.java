package dataStructrue.sort;

public class Sort {

    /**
     * 选择排序，思想是遍历数组找到一个最小的数与零位置交换，然后在1位置重复上述行为，直到N位置。
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }

    }

    /**
     * 冒泡排序，思想是在0-N位置上相邻的数依次比较谁大谁后移，然后N位置上就是最大值，再在0-N-1位置上排序，依此类推
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序，思想是让0-1位置上有序，再让0-2位置上有序，直到让0-N位置上有序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = 1; end < arr.length; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    /**
     * 插入排序coding优化版
     *
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = 1; end < arr.length; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    /**
     * 二分查找
     * @param arr
     * @param num
     * @return
     */
    public static boolean binarySearch(int[] arr,int num){
        if (arr == null || arr.length == 0){
            return false;
        }
        int l = 0;
        int r = arr.length;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid] == num){
                return true;
            }else if (arr[mid] > num){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return false;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
