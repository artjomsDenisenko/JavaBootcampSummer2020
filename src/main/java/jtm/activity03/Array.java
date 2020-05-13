package jtm.activity03;

import java.util.Arrays;

public class Array {
    static int[] array;

    public static void main(String[] args) {
        // TODO Use passed parameters for main method to initialize array
        // Hint: use Run— Run configurations... Arguments to pass parameters to
        // main method when calling from Eclipse
        array = new int[args.length];
        for(int n = 0; n< args.length; n++) {
            array[n] = Integer.parseInt(args[n]);
        }

        // Sort elements in this array in ascending order
        // Hint: use Integer.parseInt(args[n]) to convert passed
        // parameters from String to int
        //Sort the array in ascending order
        // Hint: use Arrays.sort(...) from
        // https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
        Arrays.sort(array,0,array.length);


    }

    public static void printSortedArray() {
        // TODO print content of array on standard output
        // Hint: use Arrays.toString(array) method for this
        System.out.println(Arrays.toString(array));
    }

    public static int[] returnSortedArray() {
        // TODO return reference to this array
        return array;
    }

}