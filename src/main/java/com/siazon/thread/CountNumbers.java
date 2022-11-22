package com.siazon.thread;

public class CountNumbers implements Runnable {
    Thread T;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public void Start() {
        if (T == null) {
            T = new Thread(this);
            T.start();
        }
    }
}
