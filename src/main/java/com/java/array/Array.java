package com.java.array;

import java.io.*;

/**
 * 二维数组 <-> 稀疏数组
 *
 * @author zJiaLi
 * @since 2020-09-06 20:21
 */
public class Array {
    public static void main(String[] args) throws IOException {
        //1.创建二维数组
        int[][] initArray = new int[11][11];
        initArray[3][4] = 2;
        initArray[6][3] = 5;
        initArray[7][8] = 1;
        System.out.println("initArray: ");
        int sum = 0;
        for (int[] row : initArray) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
        //2.创建稀疏数组,行为 sum+1 , 因为第一行为原二维数组的信息
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int index = 0;
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                if (initArray[i][j] != 0) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = initArray[i][j];
                }
            }
        }
        System.out.println("sparseArray: ");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d ", data);
            }
            System.out.println();
        }

        // 3. 将稀疏数组sparseArray 写入到meta.data
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("meta.data")))) {
            oos.writeObject(sparseArray);
            oos.flush();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("meta.data")))) {
            int[][] sparseArrayData = (int[][]) ois.readObject();
            // 4.将稀疏数组转换为二维数组
            int[][] reduceArray = new int[sparseArrayData[0][0]][sparseArrayData[0][1]];
            for (int i = 1; i < sparseArrayData.length; i++) {
                reduceArray[sparseArrayData[i][0]][sparseArrayData[i][1]] = sparseArrayData[i][2];
            }

            System.out.println("reduceArray: ");
            for (int[] row : reduceArray) {
                for (int data : row) {
                    System.out.printf("%d ", data);
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
