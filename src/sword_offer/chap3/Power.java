package sword_offer.chap3;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 不得使用库函数直接实现，无需考虑大数问题。
 */
public class Power {

    /**
     * 最直接的方法，将base乘exponent次。
     * @param base      基数
     * @param exponent 次幂
     * @return  base^exponent
     */
    public double Power(double base, int exponent) {
        if(base == 0)
            return 0;
        double res = 1.0;
        int absExponent = Math.abs(exponent);
        for(int i=0; i<absExponent; i++){
            res *= base;
        }

        return exponent < 0 ? 1 / res : res;
    }

    /**
     * 如果exponent=32，则上面的方法在循环中循环32次。
     * 现在换一种思路，当知道base的16次方，那么在该基础上再平方一次即可得到base的32次方；
     * 而base的16次方为base的8次方的基础上平方。
     * 因此可以先求平方，再在平方的基础上求4次方，然后再求8次方，再求16次方，最后求32次方。
     * 这种思路的时间复杂度为O(logn)。
     */
    public double Power2(double base, int exponent) {
        if (base == 0)
            return 0;

        double res = 1.0;
        int absExponent = Math.abs(exponent);

        while(absExponent != 0){
            // 判断absExponent是否为奇数
            if ((absExponent&1) != 0)
                res *= base;

            base *= base;
            // 将absExponent除以2
            absExponent = absExponent >> 1;
        }

        return exponent < 0 ? 1 / res : res;
    }
}
