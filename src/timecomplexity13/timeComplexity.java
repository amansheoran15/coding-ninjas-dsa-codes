package timecomplexity13;

import java.util.Scanner;

public class timeComplexity {
    public static void takeInput(int[] arr){
        Scanner s = new Scanner(System.in);
        for (int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int equilibriumIndex(int[] arr){
        int leftSum = 0, rightSum = 0;
        for (int i = 1; i < arr.length; i++) {
            rightSum += arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            leftSum += arr[i-1];
            rightSum -= arr[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int size;
        System.out.println("Input size of the array: ");
        Scanner s = new Scanner(System.in);
        size = s.nextInt();
        int[] arr = new int[size];
        takeInput(arr);

        System.out.println(equilibriumIndex(arr));
    }
}
