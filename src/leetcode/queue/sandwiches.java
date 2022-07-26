package leetcode.queue;

/**
 * 无法吃到午餐学生的数量
 */
public class sandwiches {

    public int countStudents(int[] students, int[] sandwiches) {
        if (students == null || students.length == 0) {
            return 0;
        }
        if (sandwiches == null || sandwiches.length == 0) {
            return students.length;
        }
        // Like[0] 喜欢圆形的学生数，Like[1]喜欢方形的学生数
        int[] like = new int[2];
        //统计喜欢圆形和方形的学生人数
        for (int student : students) {
            like[student]++;
        }
        for (int sandwiche : sandwiches) {
            if (like[sandwiche] == 0) {
                //说明喜欢圆形或者方形的学生已经没有了，顶部的三明治没人取走了。
                break;
            }
            //对应的学生喜欢一个减少一个
            like[sandwiche]--;
        }
        return like[0] + like[1];
    }
}
