package NumSequence;

import bean.Tree.QuadTree.Node;

public class L_427_ConstructQuadTree {

    /*
        We want to use quad trees to store an N x N boolean grid. Each cell in
        the grid can only be true or false. The root node represents the whole
        grid. For each node, it will be subdivided into four children nodes until
        the values in the region it represents are all the same.

        Each node has another two boolean attributes : isLeaf and val. isLeaf is
        true if and only if the node is a leaf node. The val attribute for a leaf
        node contains the value of the region it represents.

        Your task is to use a quad tree to represent a given grid. The following
        example may help you understand the problem better:

        Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
            images/Example_L_427_ConstructQuadTree_1.png
        It can be divided according to the definition above:
            images/Example_L_427_ConstructQuadTree_2.png

        The corresponding quad tree should be as following, where each node is
        represented as a (isLeaf, val) pair.

        For the non-leaf nodes, val can be arbitrary, so it is represented as *.
            images/Example_L_427_ConstructQuadTree_3.png

        Note:
            N is less than 1000 and guaranteened to be a power of 2.
            If you want to know more about the quad tree, you can refer to its wiki.
                https://en.wikipedia.org/wiki/Quadtree

     */

    public static void main(String[] args) {
        L_427_ConstructQuadTree l = new L_427_ConstructQuadTree();
        int[][] grid = {{1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0}};
        Node node = l.construct(grid);
    }

    public Node construct(int[][] grid) {
        return construct1(grid);
    }

    public Node construct1(int[][] grid) {
        Node result = null;
        result = constructTree(grid, 0, 0, grid.length);
        return result;
    }


    public Node constructTree(int[][] grid, int x, int y, int len) {
         if (len == 2) {
            if (grid[x][y] == grid[x][y + 1] && grid[x][y] == grid[x + 1][y] && grid[x][y] == grid[x + 1][y + 1]) {
                return new Node(grid[x][y] == 1, true, null, null, null,    null);
            } else {
                return new Node(true,
                        false,
                        new Node(grid[x][y] == 1, true, null, null, null,    null),
                        new Node(grid[x][y + 1] == 1, true, null, null, null,    null),
                        new Node(grid[x + 1][y] == 1, true, null, null, null,    null),
                        new Node(grid[x + 1][y + 1] == 1, true, null, null, null,    null));
            }
        } else {
            Node child1 = constructTree(grid, x, y, len >> 1);
            Node child2 = constructTree(grid, x, y + (len >> 1), len >> 1);
            Node child3 = constructTree(grid, x + (len >> 1), y, len >> 1);
            Node child4 = constructTree(grid, x + (len >> 1), y + (len >> 1), len >> 1);
            if (true == child1.isLeaf && child1.isLeaf == child2.isLeaf && child1.isLeaf == child3.isLeaf && child1.isLeaf == child4.isLeaf
                && child1.val == child2.val && child1.val == child3.val && child1.val == child4.val) {
                return new Node(child1.val, true, null, null, null, null);
            } else {
                return new Node(true,
                        false,
                        child1,
                        child2,
                        child3,
                        child4);

            }
        }
    }
}
