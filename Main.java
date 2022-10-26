import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Main {

  // Problem Statement #
  // Problem 1: Given a binary tree, find its minimum depth

  private static int minDepth(TreeNode root) {
    int minDepth = 0;
    if (root == null)
      return minDepth;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {

      minDepth++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {

        TreeNode currentNode = queue.poll();
        // check and return if currentnode is leaf node
        if (currentNode.left == null && currentNode.right == null)
          return minDepth;
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.add(currentNode.left);
        if (currentNode.right != null)
          queue.add(currentNode.right);
      }
    }
    return minDepth;
  }

  // Problem 1: Given a binary tree, find its maximum depth (or height).

  private static int maxDepth(TreeNode root) {
    int maxDepth = 0;
    if (root == null)
      return maxDepth;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      maxDepth++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {

        TreeNode currentNode = queue.poll();
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.add(currentNode.left);
        if (currentNode.right != null)
          queue.add(currentNode.right);
      }
    }
    return maxDepth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    System.out.println(Main.minDepth(root));
    System.out.println(Main.maxDepth(root));

  }
}