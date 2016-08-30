/**
 * Created by rasefon on 16-7-18.
 * Minimum Depth of Binary Tree
 */
public class LC111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 1;
        }

        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = minDepth(root.left) + 1;
        }

        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = minDepth(root.right) + 1;
        }

        if (rightDepth != 0 && leftDepth != 0) {
            return rightDepth > leftDepth ? leftDepth : rightDepth;
        } else if (rightDepth == 0 && leftDepth != 0) {
            return leftDepth;
        } else if (rightDepth != 0 && leftDepth == 0) {
            return rightDepth;
        } else {
            return 1;
        }
    }
}
