package sort;

/**
 * @author sbqstart
 * @create 2022/5/9 - 21:02
 *
 */
public class SortAndBit {
    private static int[] arr = new int[]{4, 2, 7, 9, 4, 6, 87, 5, 45, 68, 32, 10};

    public static void main(String[] args) {
//        sortAndBit.insertionSort(arr);
//       for (int i : arr){
//           System.out.println(i);
//       }
//        int[] arr1 = new int[]{11, 11, 22, 22, 3, 3, 3, 44, 44, 44, 55, 55, 6, 6};
//        mergeInsert(arr, 0, 11);
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node1.left = node2;
        node1.right = node3;
//        node2.right = node4;
        System.out.println(isf(node1));


    }

    /**
     * 插序排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, r, p[1] + 1);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    /**
     * 堆排序以及堆结构的两个操作heapInsert，heapify
     */

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }//O(logN)
//        for (int i = arr.length;-1 i >= 0 ; i--) {
//            heapify(arr,i,arr.length);
//        }O(N)
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize < 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeInsert(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeInsert(arr, l, mid);
        mergeInsert(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 一个数组里有一堆数，只有一个数字出现了奇数次，其余的数都出现了偶数次，写一个算法求出出现了奇数次的那个数
     */
    public static int findOne(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result = result ^ i;
        }
        return result;
    }

    /**
     * 一个数组里有一堆数，只有两个数字出现了奇数次，其余的数都出现了偶数次，写一个算法求出出现了奇数次的那个数
     */
    public static void findTwo(int[] arr) {
        int eor = 0;
        //for循环后此时eor=a^b
        for (int i : arr) {
            eor = eor ^ i;
        }
        //得到eor最右侧的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i : arr) {
            if ((rightOne & i) == 0) {
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne + "     " + (eor ^ onlyOne));

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static class info {
        boolean isf;

        public info(boolean is) {
            isf = is;
        }
    }

    public static info process(Node x) {
        if (x == null) {
            return new info(true);
        }
        info leftProcess = process(x.left);
        info rightProcess = process(x.right);
        if (leftProcess.isf != true || rightProcess.isf!=true){
           return new info(false);
        }
        boolean isf = true;
        if ((x.left == null && x.right != null) || (x.left != null && x.right == null)) {
            isf = false;
        }
        return new info(isf);
    }
    public static boolean isf(Node head){
        if (head == null){
            return true;
        }
        info info = process(head);
        return info.isf;
    }
}
