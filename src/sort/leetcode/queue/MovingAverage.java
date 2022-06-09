package sort.leetcode.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 */
public class MovingAverage {
    private int size;
    private double total;
    private Queue queue = new LinkedList();

    public MovingAverage(int size) {
        this.size = size;
    }


    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            total += val;
            return (total) / queue.size();
        }
        int old = (int) queue.poll();
        queue.offer(val);
        total = total - old + val;
        return total / queue.size();
    }
}
