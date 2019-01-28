package sword_offer.chap2;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class MinNumberInRotateArray {

    /**
     * 先使用二分查找，如果二分查找解决不了再使用顺序查找
     * @param array 旋转数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int[] array){
        if(array == null || array.length == 0)
            return 0;

        int left = 0, right = array.length-1, mid = left;

        while (array[left] >= array[right]){
            if(right - left == 1){
                mid = right;
                break;
            }
            mid = (left + right) / 2;

            // 如果left，right，mid的值都相等，则只能顺序查找
            if(array[left] == array[right] && array[left] == array[mid]){
                return orderFind(array, left, right);
            }

            if(array[mid]>=array[left])
                left = mid;
            else if(array[mid]<=array[right])
                right = mid;
        }

        return array[mid];
    }

    private int orderFind(int[] array, int left, int right) {
        int res = array[left];
        for (int i = left+1; i < right; i++) {
            if(res > array[i])
                res = array[i];
        }
        return res;
    }
}
