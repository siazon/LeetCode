package com.siazon.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class CountNumbersTest {

    @BeforeEach
    void setUp() {
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