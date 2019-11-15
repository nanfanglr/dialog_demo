package com.rui.dialog_demo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    int[] arrS = {10, 2, 4, 8, 12, 16, 14, 18, 6, 20};

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSearch() {
        int index = search(arr, 6);
        System.out.println("index=" + index);
    }

    //二分法查找
    public int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    @Test
    public void testInsertSort() {
        insertSort(arrS);
        for (int i : arrS) {
            System.out.print(i + ",");
        }
    }

    //插入排序 升序
    public void insertSort(int[] arr) {
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < arr.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = arr[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < arr[j]) {
                arr[j + 1] = arr[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            arr[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
    }

    @Test
    public void testBubbleSort() {
        System.out.println(Arrays.toString(arrS));
        bubbleSort(arrS);
        System.out.println(Arrays.toString(arrS));
    }

    //冒泡排序 升序
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int j, int i) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    @Test
    public void testBiBubbleSort() {
        System.out.println(Arrays.toString(arrS));
        biBubbleSort(arrS);
        System.out.println(Arrays.toString(arrS));
    }

    //双向冒泡排序 升序
    public void biBubbleSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);

                }
            }
            for (int i = end; i > start; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);

                }
            }
            start++;
            end--;
        }
    }

    @Test
    public void testSelectionSort() {
        System.out.println(Arrays.toString(arrS));
        selectionSort(arrS);
        System.out.println(Arrays.toString(arrS));
    }

    //选择排序
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    @Test
    public void builderTest() {
        BuilderFactory build = new BuilderFactory.Builder()
                .withCpu("Intel-88")
                .withBoard("weixin")
                .withHhd("susam")
                .withScreen("jingdongfang")
                .build();
        System.out.print(build.toString());
    }

}