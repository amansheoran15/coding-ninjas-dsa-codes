package recursion14;

import java.util.Scanner;

public class Recursion {

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

    public static int power(int e, int p){
        if(p==0){
            return 1;
        }
        return power(e,p-1)*e;
    }

    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static boolean isArrSorted(int[] arr,int startIndex){
        if(arr.length<=1 || startIndex == arr.length-1){
            return true;
        }
        boolean smallAns = isArrSorted(arr,startIndex+1);
        if(smallAns){
            if(arr[startIndex]<arr[startIndex+1]){
                return true;
            }
        }
        return false;
    }

    public static int sumOfArr(int[] arr,int startIndex){
        if(arr.length==1){
            return arr[0];
        }
        if(arr.length == 0){
            return 0;
        }
        if(startIndex == arr.length-1){
            return arr[startIndex];
        }
        int smallAns = sumOfArr(arr,startIndex+1);
        return arr[startIndex] + smallAns;
    }

    public static boolean checkNumInArr(int[] arr,int startIndex,int num){
        if(arr.length==0){
            return false;
        }
        if(startIndex == arr.length-1){
            return arr[startIndex] == num;
        }

        boolean smallAns = checkNumInArr(arr,startIndex+1,num);
        boolean isPresent = arr[startIndex] == num;
        return smallAns || isPresent;
    }

    public static int firstIndOfNum(int[] arr, int startIndex,int num){
        if(arr.length == 0){
            return -1;
        }
        if(arr[startIndex] == num){
            return startIndex;
        }
        return firstIndOfNum(arr,startIndex + 1,num);
    }

    public static int lastIndOfNum(int[] arr,int startIndex,int num){
        if(arr.length == 0){
            return -1;
        }
        if(startIndex == arr.length-1){
            if(arr[startIndex] == num){
                return startIndex;
            }else{
                return -1;
            }
        }

        return lastIndOfNum(arr,startIndex+1,num);

    }

    public static void allIndOfNum(int[] arr,int startIndex,int num){
        if(arr.length == 0){
            return;
        }
        if(startIndex == arr.length - 1){
            if(arr[startIndex] == num){
                System.out.print(startIndex+" ");
            }
            return;
        }
        if(arr[startIndex] == num){
            System.out.print(startIndex+" ");

        }
        allIndOfNum(arr,startIndex + 1,num);
    }

    public static void main(String[] args) {
//        System.out.println(power(2,10));
//        System.out.println(fibonacci(6));

        int size;
        System.out.println("Input size of the array: ");
        Scanner s = new Scanner(System.in);
        size = s.nextInt();
        int[] arr = new int[size];
        takeInput(arr);

//        System.out.println(isArrSorted(arr,0));

//        System.out.println(sumOfArr(arr,0));
//        System.out.println(checkNumInArr(arr,0,10));

//        System.out.println(firstIndOfNum(arr,0,8));

//        System.out.println(lastIndOfNum(arr,0,8));

        allIndOfNum(arr,0,8);
    }
}
