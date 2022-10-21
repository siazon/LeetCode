package com.siazon.tree;

import java.util.*;

public class Tree {

    public TreeNode tree;

    public int minLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minLength(root.left);
        int rightDepth = minLength(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public TreeNode createTree() {
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
        TreeNode treeNode6 = new TreeNode(6, treeNode7, treeNode8);

        return new TreeNode(5, treeNode4, treeNode6);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public void reverseTree(TreeNode root) {
        if (root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        reverseTreeSub(nodes);
    }

    private void reverseTreeSub(List<TreeNode> preNodes) {
        if (preNodes.isEmpty()) return;
        List<Integer> nodes = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node : preNodes) {
            nodes.add(node.val);
            if (node.left != null) nextNodes.add(node.left);
            if (node.right != null) nextNodes.add(node.right);
        }
        Collections.reverse(nodes);
        result.add(nodes);
        reverseTreeSub(nextNodes);
    }

    public int maxlength(TreeNode node) {
        if (node == null) return 0;
        int left = maxlength(node.left);
        int right = maxlength(node.right);

        return Math.max(left, right) + 1;
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> checkFun(TreeNode root) {
        checkfun1(root, 0);
        return result;
    }

    //递归广度优先
    private void checkfun1(TreeNode node, int deep) {
        if (node == null) return;
        deep++;
        if (result.size() < deep) {
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep - 1).add(node.val);
        checkfun1(node.left, deep);
        checkfun1(node.right, deep);

    }

    public void levelTraversal(TreeNode root) {
        if (root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        levelTraversalSub(nodes);
    }

    private void levelTraversalSub(List<TreeNode> preNodes) {
        if (preNodes.isEmpty()) return;
        List<Integer> nodes = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node : preNodes) {
            nodes.add(node.val);
            if (node.left != null)
                nextNodes.add(node.left);
            if (node.right != null)
                nextNodes.add(node.right);

        }
        result.add(nodes);
        levelTraversalSub(nextNodes);
    }

    public List<List<Integer>> layerTraversal(TreeNode root) {
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

    //统一迭代写法
    public List<Integer> commonTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                if (cur.right != null) stack.push(cur.right);
                stack.push(cur);//此二行所在位置代表什么顺序
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

    //中序迭代
    public List<Integer> midorderTraversal(TreeNode root) {
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

    //前序迭代
    public List<Integer> preorderTraversal(TreeNode root) {
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

    //后序递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    //后序递归
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        inorder(root.right, list);
        list.add(root.val);

    }
}

