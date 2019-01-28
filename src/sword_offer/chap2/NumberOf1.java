package sword_offer.chap2;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    /**
     * 主要思想：
     *      将一个数n减一后与原数字相与[(n-1)&n]得到结果为该数的二进制的最后一位1变为0
     */
    public int NumberOf1(int n) {
        int res = 0;

        while(n != 0){
            n = (n-1) & n;
            res++;
        }

        return res;
    }

    /**
     * 主要思想：
     *      1. 设置一个标志位 flag = 1;
     *      2. 判断(flag & n) 是否为0，若不为0，则表示n在该位置的二进制为1；
     *      3. 左移flag，跳转步骤2，直到flag为0为止。
     */
    public int NumberOf1LeftMove(int n){
        int flag = 1, res = 0;

        while(flag != 0){
            if( (flag & n) != 0)
                res++;
            flag = flag << 1;
        }

        return res;
    }

    /**
     * Java中 操作符 >>> 表达无符号向右移动
     */
    public int NumberOf1RightMove(int n){
        int res = 0;

        while(n != 0){
            if((n & 1) != 0)
                res++;

            n = n >>> 1;
        }

        return res;
    }
}
