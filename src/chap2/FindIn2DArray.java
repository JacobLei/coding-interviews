package chap2;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindIn2DArray {
    /**
     * 由于矩阵从上到下递增，从左到右递增，
     * 因此将右上角的元素与目标值比较，
     * 如果右上角的值大于目标值，则删除该列，即col--，
     * 如果右上角的值小于目标值，则删除该行，即row++。
     * @param target    目标值
     * @param array     二维数组
     * @return          在二维数组中是否找目标值
     */
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0)
            return false;

        int rows = array.length, cols = array[0].length, row = 0, col = cols - 1;

        while(row<rows && col>=0){
            if(array[row][col]>target){
                col--;
            }else if(array[row][col]<target){
                row++;
            }else{
                return true;
            }
        }

        return false;
    }
}
