package com.siazon.queue;

import java.util.*;

public class Queue2Stack {
    public static void main(String[] args) {
        // System.out.println(checkStr());
        // deleteSameStr();

        Queue<String> q = new PriorityQueue<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // null,因为队列为空


        //   int[] res=  maxSlidingWindow();
        //   for(int i:res){
        //     System.out.println(i);
        //   }
    }
    public static int[] maxSlidingWindow() {
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
    public static void deleteSameStr() {
        String str = "abbac";
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char p = (char) stack.peek();
            if (c == p)
                stack.pop();
            else
                stack.push(c);
        }

    }

    public static boolean checkStr() {

        String str = "{([])}";
        if (str.length() % 2 == 1)
            return false;
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');

            } else if (c == '[') {
                stack.push(']');

            } else if (stack.isEmpty() || (char) stack.peek() != c) {

                return false;

            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}

class myStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue2.offer(x); // 先放在辅助队列中
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }

    public Integer pop() {
        return queue1.poll();
    }

    public Integer top() {
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}