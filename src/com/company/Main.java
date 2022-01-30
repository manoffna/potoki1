package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SecondMethod();
        //thread1.start();
        //thread2.start();
        //thread1.join();
        //thread2.join();
        //System.out.println("One thread time: " + (System.currentTimeMillis() - thread1.a) + " ms.");
    };

    public static void SecondMethod(){
        int size = 10_000_000;
        final int half = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        };
        long a = System.currentTimeMillis();
        System.out.println(a);

        float[] leftHalf = new float [arr.length/2];
        float[] rightHalf = new float[arr.length/2];
        System.arraycopy(arr, 0, leftHalf, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, rightHalf, 0, arr.length/2);

        Thread thread1 = new Thread(() -> {
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            };
            System.out.println("One thread time: " + (System.currentTimeMillis() - a) + " ms.");});

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            };
            System.out.println("Second thread time: " + (System.currentTimeMillis() - a) + " ms.");});

        thread1.start();
        thread2.start();

        float[] mergedArray = new float[arr.length];
        System.arraycopy(leftHalf, 0, mergedArray,0,arr.length/2);
        System.arraycopy(rightHalf, 0, mergedArray, arr.length/2, arr.length/2);
        System.out.println("Gluing time: " + (System.currentTimeMillis() - a) + " ms.");


    //public static void secondMethod(){


        }
    };