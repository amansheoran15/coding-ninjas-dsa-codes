package arrays2d;

import java.util.Scanner;

public class Arrays2D {
    public static void takeInput2D(int[][] arr){
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = s.nextInt();
            }
        }
    }

    public static void printArr2D(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void rowWiseSum(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum+=arr[i][j];
            }
            System.out.print(sum+" ");
        }
    }

    public static int largestColumnSum(int[][] arr){
        int sum;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void largestRowOrCol(int[][] arr){
        boolean isRow = true;
        int sum;
        int maxInd = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            sum=0;
            for (int j=0; j<arr[i].length; j++){
                sum += arr[i][j];
            }
            if(sum>maxSum){
                maxSum = sum;
                maxInd = i;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            if(sum>maxSum){
                maxSum = sum;
                isRow = false;
                maxInd = i;
            }
        }
        if(isRow){
            System.out.println("row " + maxInd + " " + maxSum );
        }else{
            System.out.println("col " + maxInd + " " + maxSum );
        }
    }

    public static int sumOnBoundaryAndDiagonal(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == 0 || j==0 || i == arr.length - 1 || j == arr.length-1 || i == j || i+j == arr.length-1){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static void printLikeWave(int[][] arr){
        int i=0,j=0;
        boolean reverse = false;
        while(j<arr[0].length){
            if(!reverse){
                System.out.println(arr[i][j] + " ");
                i++;
                if(i==arr.length){
                    reverse = true;
                    i--;
                    j++;
                }
            }
            else{
                System.out.print(arr[i][j] + " ");
                i--;
                if(i==-1){
                    reverse = false;
                    i++;
                    j++;
                }
            }
        }
    }

    public static void printLikeSpiral(int[][] arr){
        boolean row = true, reverse = false;
        int i=0,j=0;
        int prev_j = arr[0].length;
        int prev_i = arr.length;
        int prev_i_reverse = 0;
        int prev_j_reverse = -1;
        int itr = 0;

        while(itr < arr.length*arr[0].length){
            if(row && !reverse){
                System.out.print(arr[i][j] + " ");
                j++;
                if(j==prev_j){
                    j--;
                    i++;
                    row=false;
                    prev_j--;
                }
            }
            else if(!row && !reverse){
                System.out.print(arr[i][j] + " ");
                i++;
                if(i==prev_i){
                    i--;
                    j--;
                    row=true;
                    reverse=true;
                    prev_i--;
                }
            }else if(row && reverse){
                System.out.print(arr[i][j] + " ");
                j--;
                if(j==prev_j_reverse){
                    j++;
                    i--;
                    prev_j_reverse++;
                    row = false;
                }
            }else if(!row && reverse){
                System.out.print(arr[i][j] + " ");
                i--;
                if(i==prev_i_reverse){
                    i++;
                    j++;
                    prev_i_reverse++;
                    row=true;
                    reverse=false;
                }
            }
            itr++;
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter size of 2D array(rows and columns): ");
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("Give input: ");
        takeInput2D(arr);
        System.out.println("Elements you entered: ");
        printArr2D(arr);

        System.out.println();

//        rowWiseSum(arr);

//        System.out.println(largestColumnSum(arr));

//        largestRowOrCol(arr);

//        System.out.println(sumOnBoundaryAndDiagonal(arr));

//        printLikeWave(arr);

        printLikeSpiral(arr);
    }
}
