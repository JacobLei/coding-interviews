package chap2;

/**
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *  假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReconstructTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    /**
     * 递归构建二叉树
     * [preStart + 1, preStart + i - inStart]前序序列中左子树封闭区间，其中i - inStart表示左子树的长度
     * [preStart + i - inStart + 1, preEnd] 前序序列中右子树封闭区间
     * @param pre       前序序列
     * @param preStart  前序序列封闭区间的左指针
     * @param preEnd    前序序列封闭区间的右指针
     * @param in        中序序列
     * @param inStart   中序序列封闭区间的左指针
     * @param inEnd     中序序列封闭区间的右指针
     * @return          树的根结点
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        for(int i=inStart; i<=inEnd; i++){
            if(in[i] == rootVal){
                root.left = reConstructBinaryTree(pre, preStart+1, preStart+i-inStart, in, inStart, i-1);
                root.right = reConstructBinaryTree(pre, preStart+i-inStart+1, preEnd, in, i+1, inEnd);
            }
        }

        return root;
    }
}
