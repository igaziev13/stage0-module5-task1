package com.epam.mjc.stage0;

//imp__ort java.util.Arrays;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {

        return new String[]{"winter", "spring", "summer","autumn"};

    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] result = new int[length];
        for (int i=0;i<length;i++)
            result[i] = i+1;
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int result=0;
        for (int j : arr) result = result + j;
        return result;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i=0;i<arr.length;i++)
            if (arr[i]==number)
                return i;
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reversed = new String[arr.length];

        for (int i=0;i<arr.length;i++)
            reversed[i] = arr[arr.length-1-i];
        return reversed;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int length = 0, position = 0;
        for (int k : arr) if (k > 0) length++;

        int[] positives = new int[length];
        if (length>0)
            for (int j : arr)
                if (j > 0) {
                    positives[position] = j;
                    position++;
                }
        return positives;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        /*for (int i : arr[0])
            System.out.println(i);
        System.out.println("\nNEXT DIMENSION\n");
        for (int i : arr[1])
            System.out.println(i);*/
        //Sorting array #0
        if (arr.length>0)
            for (int i=0;i<arr[0].length;i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    int tmp;
                    if (arr[0][i] < arr[0][j]) {
                        tmp = arr[0][i];
                        arr[0][i] = arr[0][j];
                        arr[0][j] = tmp;
                    }
                }
            }

        //Sorting array #1
        if (arr.length==2) {
            for (int i = 0; i < arr[1].length; i++) {
                for (int j = 0; j < arr[1].length; j++) {
                    int tmp;
                    if (arr[1][i] < arr[1][j]) {
                        tmp = arr[1][i];
                        arr[1][i] = arr[1][j];
                        arr[1][j] = tmp;
                    }
                }
            }
            //Sorting dimensions
            int[] temp = arr[0];
            if (arr[0].length > arr[1].length) {
                arr[0] = arr[1];
                arr[1] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        ArrayTasks test = new ArrayTasks();
        int[][] t = {{10, 5, -10, 2, 5, 7, 1, -88, 30, 91, 3}, {}};//{{10, 5, -10, 2, 5, 7, 0, -88, 0, 91, 3},{}};//

        //System.out.println(t[1][2]);

        //t[0] = new int[] {9, 3, 6, 0, -7, 24, 789032, 911, -93098};
        //t[1] = new int[] {29, -9, 5, 0};
        t = test.sortRaggedArray(t);
        System.out.println(t.length);
        System.out.println(t[0].length);
        System.out.println(t[1].length);
        for (int i : t[0])
            System.out.println(i);
        //System.out.println("\nNEXT DIMENSION\n");
        //for (int i : t[1])
        //    System.out.println(i);
    }
}
