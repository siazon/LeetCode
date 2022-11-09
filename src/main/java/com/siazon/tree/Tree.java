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

        TreeNode treeNode19 = new TreeNode(19);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode19);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode8 = new TreeNode(8, treeNode9, null);
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

    //对称二叉树
    public boolean isSymmetric1(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    public int maxDepthRecursion(TreeNode root) {
        if (root == null) return 0;
        int leftLenght = maxDepthRecursion(root.left);
        int rightLenght = maxDepthRecursion(root.right);
        return Math.max(leftLenght, rightLenght) + 1;
    }

    //    public int maxNTreeDepth(TreeNode root) {
//        if (root == null) return 0;
//        int depth = 0;
//        if (root.children != null) {
//            for (TreeNode node : root.children) {
//                depth = Math.max(node.val, depth);
//            }
//        }
//        return depth + 1;
//    }
    //最小深度迭代
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur.left == null && cur.right == null)
                    return depth;
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
        }
        return depth;
    }

    //最小深度递归
    public int minDepthRecursion(TreeNode root) {
        if (root == null) return 0;
        int leftLenght = maxDepthRecursion(root.left);
        int rightLenght = maxDepthRecursion(root.right);
        if (root.left == null)
            return rightLenght + 1;
        if (root.right == null)
            return leftLenght + 1;
        return Math.min(leftLenght, rightLenght) + 1;
    }

    //222.完全二叉树的节点个数
    public int getNodeNumber(TreeNode root) {
        if (root == null) return 0;
        int number = 0;
        int leftNumber = getNodeNumber(root.left);
        int rightNumber = getNodeNumber(root.right);
        return leftNumber + rightNumber + 1;
    }

    public int getNodeNumbers(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int number = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                number++;
                if (node != null && node.left != null) que.offer(node.left);
                if (node != null && node.right != null) que.offer(node.right);
            }
        }
        return number;
    }

    //110.平衡二叉树
    public boolean isBalanceTree(TreeNode root) {
        return getLength(root) != -1;
    }

    private int getLength(TreeNode node) {
        if (node == null) return 0;
        int left = getLength(node.left);
        if (left == -1) return -1;
        int right = getLength(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    //257. 二叉树的所有路径
    public List<String> getTreePath(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> paths = new ArrayList<>();
        traversalTreePath(root, paths, list);
        return list;
    }

    private void traversalTreePath(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                str.append(paths.get(i)).append("->");
            }
            str.append(paths.get(paths.size() - 1));
            res.add(str.toString());
            return;
        }
        if (root.left != null) {
            traversalTreePath(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversalTreePath(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }

    public int leftSum(TreeNode root) {
        getLeftSum(root);
        return sum;
    }

    int sum = 0;

    public void getLeftSum(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            getLeftSum(root.left);
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
        }
        if (root.right != null)
            getLeftSum(root.right);


    }

    int maxDepth = 0;
    int leftValue = 0;

    //513.找树左下角的值
    public int getMaxLeft(TreeNode root) {
        leftValue = root.val;
        maxLeft(root, leftValue);
        return leftValue;
    }

    public void maxLeft(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (maxDepth < deep) {
                maxDepth = deep;
                leftValue = root.val;
            }
        }
        if (root.left != null)
            maxLeft(root.left, deep + 1);
        if (root.right != null)
            maxLeft(root.right, deep + 1);
    }

    //112. 路径总和
    public boolean sumNode(TreeNode root, int target) {
        boolean res = false;
        target -= root.val;
        if (root.left == null && root.right == null)
            return target == 0;
        if (root.left != null) {
            boolean sRes = sumNode(root.left, target);
            if (sRes) return sRes;
        }
        if (root.right != null) {
            boolean sRes = sumNode(root.right, target);
            if (sRes) return sRes;
        }
        return res;
    }


}

