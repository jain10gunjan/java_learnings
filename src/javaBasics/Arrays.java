package javaBasics;

import java.lang.Math;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        arr1[4] = 5;
        printArray(arr1);

        //Multidimensional Array:
        int[][] arr2 = new int[3][4];

        //Random values:
        // (int)(Math.random() * 100)


        for(int i=0; i< 3;i++ ) {
            for (int j = 0; j < 4; j++) {
                arr2[i][j] = (int) (Math.random() * 100);
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

        //Jagged Array
        int[][] nums = new int[3][];
        nums[0] = new int[3];
        nums[1] = new int[4];
        nums[2] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (int) (Math.random() * 100);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

    }

    //4:22
    public static void printArray(int[] arr){
        for (int j : arr) {
            System.out.println(j);
        }
    }
}

