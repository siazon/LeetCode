package com.siazon.thread;

public class ThreadDemo extends Thread {
    Thread T;

    @Override
    public void run() {
        System.out.println("Thread");
    }

    public void Start() {
        if (T == null) {
            T = new Thread(this);
            T.start();
        }
    }
}
