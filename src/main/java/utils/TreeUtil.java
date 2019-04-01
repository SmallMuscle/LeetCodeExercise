package utils;

public class TreeUtil {

    public static int getTreeDepth(TreeNode tn) {
        int depth = 0;
        if (null != tn) {
            ++depth;
            int leftDepth = getTreeDepth(tn.getLeft());
            int rightDepth = getTreeDepth(tn.getRight());
            depth += leftDepth > rightDepth ? leftDepth : rightDepth;
        }
        return depth;
    }
}
