package com.rui.dialog_demo;

import org.junit.Test;

/**
 * Created by rui on 2019/10/28
 */
public class SortTest {

    int[] arr = new int[]{2, 1, 3, 4, 7, 9, 8, 0};

    @Test
    public void bubbleSort() {
        // 第一位置的关键字在一次循环后一定变成最小值
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
            printArr(arr);
            System.out.println();
        }
//        printArr(arr);
    }

    private void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    @Test
    public void bubbleSort2() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
            printArr(arr);
            System.out.println();
        }
//        printArr(arr);
    }

    @Test
    public void bubbleSort3() {
        boolean isSort;
        for (int i = 0; i < arr.length - 1; i++) {
            isSort = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                    isSort = false;
                }
            }
            printArr(arr);
            System.out.println();
            if (isSort) {
                break;
            }
        }
    }

}
