package com.siazon.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountNumbersTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void threadTest() {
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