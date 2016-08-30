/**
 * Created by rasefon on 16-7-2.
 */
public class LowestCommonAncestor2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if ((hasNode(root.left, p) && hasNode(root.right, q)) || (hasNode(root.left, q) && hasNode(root.right, p))) {
            return root;
        }

        TreeNode result = lowestCommonAncestor(root.left, p, q);

        if (null != result) {
            return result;
        }

        return lowestCommonAncestor(root.right, p, q);
    }

    private boolean hasNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root.val == node.val) {
            return true;
        }

        if (hasNode(root.left, node)) {
            return true;
        }

        return hasNode(root.right, node);
    }
}
