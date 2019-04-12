package utils;

import bean.TreeNode;

public class TreeUtil {

    public static int getTreeDepth(TreeNode tn) {
        int depth = 0;
        if (null != tn) {
            ++depth;
            int leftDepth = getTreeDepth(tn.left);
            int rightDepth = getTreeDepth(tn.right);
            depth += leftDepth > rightDepth ? leftDepth : rightDepth;
        }
        return depth;
    }
}
