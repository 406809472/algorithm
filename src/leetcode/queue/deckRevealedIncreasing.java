package leetcode.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 950. 按递增顺序显示卡牌
 */
public class deckRevealedIncreasing {
    public int[] deckRevealedIncreasingSolution(int[] deck){
        if (deck == null || deck.length <2){
            return deck;
        }
        Arrays.sort(deck);
        Queue queue = new LinkedList<>();
        for (int i = deck.length-1; i >=0; i--) {
            queue.offer(deck[i]);
            if (i == 0){
                break;
            }
            queue.offer(queue.poll());
        }
        for (int i = deck.length-1; i >=0; i--) {
            deck[i] = (int) queue.poll();
        }
        return deck;
    }
}
