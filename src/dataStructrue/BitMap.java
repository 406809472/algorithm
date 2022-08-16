package dataStructrue;

/**
 * 位图
 */
public class BitMap {
    private long[] map;

    public BitMap(int max) {
        map = new long[(max + 64) >> 6];
    }

    //num&63即等于num%64
    public void add(int num) {
        map[num >> 6] |= (1L << (num & 63));
    }

    public void delete(int num) {
        map[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (map[num >> 6] & (1L << (num & 63))) != 0;
    }
}
