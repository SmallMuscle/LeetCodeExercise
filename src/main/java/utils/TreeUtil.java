package utils;

import bean.TreeNode;

public class TreeUtil {

    public static int getTreeDepth(TreeNode tn) {
        if (null == tn) return 0;
        int leftDepth = getTreeDepth(tn.left);
        int rightDepth = getTreeDepth(tn.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
}
