package sort.leetcode.queue;

/**
 * @author sbqstart
 * @create 2022/6/1 - 13:11
 */
public class queue {

    public static void main(String[] args) {
        int[] tickets = new int[]{1, 2, 3, 4};
        int k = 3;
        int total = timeRequiredToBuy(tickets, k);
        System.out.println("total:" + total);
    }

    /**
     * 买票时间
     *
     * @param tickets
     * @param k
     * @return
     */
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {

                if (tickets[i] > 0) {
                    tickets[i]--;
                    if (tickets[k] == 0) {
                        return total + 1;
                    }
                    total++;
                }
            }

        }

        return total;
    }

}
