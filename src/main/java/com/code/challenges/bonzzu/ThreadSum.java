package com.code.challenges.bonzzu;

import lombok.Getter;

public class ThreadSum {

    static void main(String[] args) {
        Sum sumTask = new Sum(5, 10);
        Thread thread = new Thread(sumTask);
        thread.start();

        try {
            // Wait for the thread to finish calculation
            thread.join();
            System.out.println("The sum is: " + sumTask.getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sum implements Runnable {
    private final int a;
    private final int b;
    @Getter
    private int result;

    public Sum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        this.result = this.a + this.b;
    }
}
