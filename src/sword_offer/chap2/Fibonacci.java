package sword_offer.chap2;

/**
 *  现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Fibonacci {

    /**
     * 迭代法，推荐使用
     */
    public int Fibonacci(int n) {
        if (n == 0 || n == 1){
            return n;
        }

        int pre1 = 0, pre2 = 1;
        for (int i = 2; i <=n ; i++) {
            int tmp = pre2;
            pre2 = pre1 + pre2;
            pre1 = tmp;
        }

        return pre2;
    }

    /**
     * 递归法
     */
    public int Fibonacci2(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
