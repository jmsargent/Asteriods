package com.company;

import java.util.Vector;
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

        ang = Math.toRadians(ang);


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

    /**
     * takes a vector described in polar coordinates and converts it to cartesian coordinates.
     */
    public static double[] toCartesian(double angle, double magnitude){
        return new double[] {(Math.cos(Math.toRadians(angle))*magnitude),(Math.sin(Math.toRadians(angle))*magnitude)};
    }

    public static boolean isNegative(double d){
        return (d<0.0);
    }

    /**
     * calculates the new angle such that the resulting angle always is positive
     * @param d
     * @param delta
     * @return
     */

    public static double calcPosAngle(double d, double delta){
        double result=0;

        return result;
    }

    public static double[] scaleToLen(int len,double[] v){

        for (int i = 0; i < v.length; i++) {
            v[i] = v[i]/arraySum(v)*len;
        }


        return v;
    }
    
    public static double arraySum(double a[]){
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i]);
        }
        return sum;
    }

    public static double vectorLength(double[] vector){

        double length = 0;

        for (int i = 0; i < vector.length; i++) {
            length = length + Math.pow(vector[i],2.0);
        }

        return (Math.sqrt(length));
    }

    public static double[] vectorSubtraction(double[] v1, double[] v2){

        if (v1.length != v2.length)
            throw new ArrayIndexOutOfBoundsException("This method only accepts 2 arrays of the same length.");


        double[] difference = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            difference[i] = v1[i] - v2[i];
        }

        return difference;
    }
}
