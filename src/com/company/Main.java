package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Thread> threadlist = new LinkedList<>();
        Buffer buffer = new Buffer();
        for (int i = 0; i < 10; i++) {
            threadlist.add(new Thread(new Producer(buffer)));
            threadlist.add(new Thread(new Consumer(buffer)));
        }
        for (Thread t : threadlist) {
            t.start();
        }
    }

}
