package timecomplexity13;

import java.util.ArrayList;
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

    public static ArrayList<Integer> subarrayWithGivenSum(int[] arr, int s){
        int i = 0;
        int j = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(i<=j && i<arr.length && j < arr.length){
            if(i==j && arr[j] == s){
                ans.add(i+1);
                ans.add(i+1);
                break;
            }else if(sum+arr[j]<s){
                sum += arr[j];
                j++;
            }else if(sum+arr[j]>s){
                if (i != 0) {
                    sum-=arr[i];
                }
                i++;
                if(j<i){
                    j++;
                }
            }else{
                ans.add(i+1);
                ans.add(j+1);
                break;
            }
        }
//        System.out.println(ans.get(0)+ " "+ans.get(1));
        if(ans.isEmpty()){
            ans.add(-1);
            return ans;
        }
        return ans;
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int ind = -1;
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j]<arr[i]){
                    ind = j;
//                    System.out.println("inside ind loop" + ind);
                    break;
                }
            }
//            System.out.println(ind);
            if(ind == -1){
                for (int k = i; k > 0 ; k--) {
                    arr[k] = arr[k-1];
                }
                arr[0] = ele;

            }else{
                for (int k = i; k > ind ; k--) {
                    arr[k] = arr[k-1];
                }
                arr[ind+1] = ele;
            }
        }
    }

    public static void pairSum(int[] arr, int k){
        insertionSort(arr);
        printArr(arr);
        System.out.println();
        int i = 0, j = arr.length - 1;

        int i_count=1, j_count = 1;

        int num_pair = 0;

        while(i<j){
            if(arr[i]+arr[j]>k){
                j--;
            }else if(arr[i]+arr[j]<k){
                i++;
            }else{
                i_count = 1;
                j_count = 1;
//                System.out.println(arr[i] + " " + arr[j]);
                if(arr[i] == arr[j]){
                    while(i<arr.length-1 && arr[i]==arr[i+1]){
                        i_count++;
                        i++;
                    }
                    for (int l = 1; l < i_count; l++) {
                        num_pair += l;
                    }
                }else{
                    while(arr[i]==arr[i+1]){
                        i_count++;
                        i++;
                    }
                    while(arr[j]==arr[j-1]){
                        j_count++;
                        j--;
                    }
                    num_pair += i_count * j_count;

                }
                i++;
                j--;
            }
        }

        System.out.println(num_pair);
    }

    public static void main(String[] args) {
        int size;
        System.out.println("Input size of the array: ");
        Scanner s = new Scanner(System.in);
        size = s.nextInt();
        int[] arr = new int[size];
        takeInput(arr);
//        System.out.println(arr[544]);

//        System.out.println(equilibriumIndex(arr));

//        pairSum(arr,10);

        ArrayList<Integer> ans = subarrayWithGivenSum(arr,2755);
        for (int a:ans){
            System.out.print(a +" ");
        }
    }
}
