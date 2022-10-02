package com.siazon.tree;

import java.util.*;

public class Tree {
    public static void main(String[] args) {
        TreeNode tree = CreateTree();
        // List<List<Integer>> list = LayerTraversal(tree);
        // for(List<Integer> item: list)
        // {
        //     System.out.println();
        //     for (int i : item)
        //    System.out.print(i);
        // }
        System.out.println(minlen(tree));
    }

    public static int minlen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minlen(root.left);
        int rightDepth = minlen(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static TreeNode CreateTree() {
        /*
         *    5
         *  4   6
         * 1 2 7 8
         * 前5412678 中1425768 后1247865
         */
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode8);
        TreeNode root = new TreeNode(5, treeNode4, treeNode6);

        return root;
    }

    public static int maxlen(TreeNode node) {
        if (node == null) return 0;
        int left = maxlen(node.left);
        int right = maxlen(node.right);

        return Math.max(left, right) + 1;
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> checkFun(TreeNode root) {
        Checkfun1(root, 0);
        return result;
    }

    public static void Checkfun1(TreeNode node, int deep) {
        if (node == null) return;
        deep++;
        if (result.size() < deep) {
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep - 1).add(node.val);
        Checkfun1(node.left, deep);
        Checkfun1(node.right, deep);

    }

    public static List<List<Integer>> LayerTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            int i = queue.size();
            List<Integer> items = new ArrayList<>();
            while (i > 0) {
                TreeNode node = queue.poll();
                items.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                i--;
            }
            result.add(items);

        }
        return result;
    }

    public static List<Integer> commonTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                if (cur.right != null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) stack.push(cur.left);
            } else {
                stack.pop();
                cur = stack.pop();
                result.add(cur.val);
            }

        }
        return result;
    }

    public static List<Integer> midorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    static void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        inorder(root.right, list);
        list.add(root.val);

    }
}

