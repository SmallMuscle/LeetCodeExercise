package com.test.dsTest.tree;

import com.test.bean.Tree.binaryTree.TreeNode;

public class AVLTreeTest {



    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for (int i = 0; i <= 30; i++) {
            tree.put(new TreeNode(i));
        }

        for (int i = 15; i >= 0; --i) {
            tree.printTree();
            tree.remove(i);
        }
        tree.printTree();
        /*for (int i = 0; i <= 18; i++) {
            tree.remove(i);
            tree.printTree();
        }*/

    }


}
