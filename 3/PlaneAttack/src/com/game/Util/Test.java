package com.game.Util;

public class Test {
    public  static boolean isTrue = true;
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        new Thread(testThread).start();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        TestThread2 testThread2 = new TestThread2();
        new Thread(testThread2).start();
    }
}
class TestThread implements Runnable{
    public void run(){
        while (Test.isTrue){
            System.out.println();
        }
    }
}
class TestThread2 implements  Runnable{
    public void run(){
        Test.isTrue = false;
    }
}

