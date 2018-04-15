package com.company;

public class Buffer {
    private String message = null;

    synchronized public String take() {
        while (message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = message;
        System.out.println("take " + s);
        message = null;
        notifyAll();
        return s;
    }

    synchronized public void put(String s) {
        while (message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message = s;
        System.out.println("put " + s);
        notifyAll();
    }
}
