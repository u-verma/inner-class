package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableDemo {
    public static final Logger LOG = Logger.getLogger(RunnableDemo.class.getName());

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    LOG.log(Level.INFO, "Running the run job: " + i);
                    i++;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
