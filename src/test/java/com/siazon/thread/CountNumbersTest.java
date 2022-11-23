package com.siazon.thread;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class CountNumbersTest {

    @BeforeEach
    void setUp() {
    }

    // 记录被遍历过的节点
    boolean[] visited;
    // 记录从起点到当前节点的路径
    boolean[] onPath;

    /* 图遍历框架 */
    void traverse(Graph graph, int s) {
        if (visited[s]) return;
        // 经过节点 s，标记为已遍历
        visited[s] = true;
        // 做选择：标记节点 s 在路径上
        onPath[s] = true;
        for (int neighbor : graph.neighbors(s)) {
            traverse(graph, neighbor);
        }
        // 撤销选择：节点 s 离开路径
        onPath[s] = false;

        TreeNode
    }

    @Test
    void test() {


        List<? extends Number> list = new ArrayList<Integer>();
        List<? super Number> list2 = new ArrayList<Object>();
        String a = new String("Interviewbit");
        String b = new String("Interviewbit");
        String c = "Interviewbit";
        String d = "Interviewbit";
        System.out.println(a.hashCode() + " " + b.hashCode() + " " + c.hashCode() + " " + d.hashCode());
    }

    @Test
    void threadTest() {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.peekLast());

//
//        CountNumbers countNumbers = new CountNumbers();
//        countNumbers.Start();
//        System.out.println("running");

    }

    @Test
    void threadTest1() throws InterruptedException {
        ThreadDemo demo = new ThreadDemo();
        demo.start();
        System.out.println("start");
        System.out.println("started");
        demo.interrupt();
        demo.join();
        System.out.println("stoped");

    }
}