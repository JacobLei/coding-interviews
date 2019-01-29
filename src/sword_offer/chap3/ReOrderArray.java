package sword_offer.chap3;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    /**
     * 借组辅助数组来保证奇数与奇数、偶数与偶数的相对位置不变
     */
    public void reOrderArray(int[] array) {
        if(array == null || array.length == 0)
            return ;

        int len = array.length;
        int[] tmp = new int[len];
        int pos = 0;

        for (int i = 0; i < len; i++) {
            if(isOdd(array[i])){
                tmp[pos++] = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if(!isOdd(array[i])){
                tmp[pos++] = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            array[i] = tmp[i];
        }


    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
