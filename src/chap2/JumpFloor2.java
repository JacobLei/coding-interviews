package chap2;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor2 {

    public int jumpFloorII(int target) {
        if (target == 1)
            return 1;
        int pre = 1, res = 0;

        for (int i = 2; i <= target; i++) {
            res = 2 * pre;
            pre = res;
        }

        return res;
    }
}
