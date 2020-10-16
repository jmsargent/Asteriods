package com.company;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyMath {

    /**
     * Adds constant to every every indice of array
     * @param a
     * @param b
     * @return
     */

    public static int[] arrayConstAddition(int a[], int b){

        int[] sum = new int[a.length];


        for (int i = 0; i < a.length; i++) {
            sum[i] = a[i] + b;
        }

        return sum;
    }

    public static int[] roundedIntArray(double[] a, int size){
        int[] a2 = new int[size];

        for (int i = 0; i < size; i++) {
            a2[i] = roundToNearestInt(a[i]);
        }

        return a2;
    }

    public static int roundToNearestInt(double d){

        int floor = (int) d;

        if (d-floor < 0.5 ){
            return floor + 1;
        }else {
            return floor;
        }

    }


    public static double[] mergeXY(double x, double y){
        double merged[] = new double[2];
        merged[0] = x;
        merged[1] = y;
        return merged;
    }


    public static double[] rotatePoint(double ang, double[] xyPoint) {

        double tempAngPosX;
        double tempAngPosY;

        double[] rotatedPoint = {0,0};

        // new xcord from rotational matrix is calculated by
        rotatedPoint[0] = xyPoint[0] * Math.cos(ang) - xyPoint[1] * Math.sin(ang);


        // new ycord from rotational matrix is calculated by
        rotatedPoint[1] = xyPoint[0] * Math.sin(ang) + xyPoint[1] * Math.cos(ang);

        return rotatedPoint;
    }


    /**
     * Matrix transpose
     * @param matrix
     * @return
     */
    public static double[][] transposeMatrix(final double[][] matrix) {
        return IntStream.range(0, matrix[0].length)
                .mapToObj(i -> Stream.of(matrix).mapToDouble(row -> row[i]).toArray())
                .toArray(double[][]::new);
    }

}
