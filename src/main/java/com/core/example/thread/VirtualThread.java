package com.core.example.thread;

public class VirtualThread {
    
    public static void main(String[] args) {
        // Creating a virtual thread
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Index: " + i);
            }
        });

        // Wait for the virtual thread to complete
        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}