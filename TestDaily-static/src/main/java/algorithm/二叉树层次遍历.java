package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zjg
 * @description:
 * @date 2021/3/25 15:16
 */
public class 二叉树层次遍历 {
    public static void main(String[] args) {

    }

    /**
     * @author zjg
     * @description: 树的结构
     * @date 2021/3/25 15:46
     */
    class TreeNode {
        public TreeNode left, right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level <= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    /**
     * 借助队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        List result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * "Z"字遍历  示例：4->3->2->7->5->2->1
     *       4
     *    3     2
     *  1  2  5   7
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFromLeft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            isFromLeft = !isFromLeft;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (isFromLeft) {
                    node = ((LinkedList<TreeNode>) queue).pollFirst();
                } else {
                    node = ((LinkedList<TreeNode>) queue).pollLast();
                }
                list.add(node.val);
                if (isFromLeft) {
                    if (node.left != null) {
                        ((LinkedList<TreeNode>) queue).offerLast(node.left);
                    }
                    if (node.right != null) {
                        ((LinkedList<TreeNode>) queue).offerLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        ((LinkedList<TreeNode>) queue).offerFirst(node.right);
                    }
                    if (node.left != null) {
                        ((LinkedList<TreeNode>) queue).offerFirst(node.left);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }


}
