package _leetcode;

public class text6__fanzhuan {//遍历交换即可
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }

    public TreeNode qianxubianli(TreeNode root){
        if (root==null) return root ;

        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        qianxubianli(root.left);//顺序无关
        qianxubianli(root.right);
        return root;
    }
}
