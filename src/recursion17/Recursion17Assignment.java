package recursion17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion17Assignment {
    public static boolean checkAB2(String str){
        if(str.length() <= 1){
            return true;
        }
        boolean smallAns;

        if(str.charAt(0)=='a'){
            smallAns = checkAB2(str.substring(1));
        }else{
            smallAns = checkAB2(str.substring(2));
        }

        if(smallAns){
            if(str.length()>2 && str.charAt(0)=='b' && str.charAt(1) == 'b'){
                return (str.charAt(2)=='a');
            }else if(str.length() == 2 && str.charAt(0)=='b' && str.charAt(1) == 'b'){
                return true;
            }
            if(str.charAt(0)=='a'){
                return ((str.charAt(1)=='b' && str.charAt(2) == 'b')||str.charAt(1)=='a');
            }
        }
        return false;
    }

    public static int staircase(int n){
        if(n<0){
            return 0;
        }
        if(n<=1){
            return 1;
        }

        int ans1 = staircase(n-1);
        int ans2 = staircase(n-2);
        int ans3 = staircase(n-3);

        System.out.println(ans1 + " " + ans2 + " " + ans3);
        return ans1+ans2+ans3;

    }

    public static int binarySearch(int[] arr,int x,int startIndex,int endIndex){
        Arrays.sort(arr);
        if(arr.length == 0){
            return -1;
        }
        int mid = (startIndex+endIndex)/2;
        if(arr[mid] == x){
            return mid;
        }
        if(arr[mid]<x){
            return binarySearch(arr,x,mid+1,endIndex);
        }else{
            return binarySearch(arr,x,startIndex,mid-1);
        }
    }

    public static boolean checkAB(String str){
        if(str.charAt(0)=='a'){
            return checkAB2(str);
        }
        return false;
    }

    public static List<List<Integer>> returnSubsets(int[] arr,int startIndex,int endIndex){
        if(startIndex>endIndex){
            List<List<Integer>> a = new ArrayList<>();
            a.add(new ArrayList<>());
            return a;
        }

        List<List<Integer>> smallAns = returnSubsets(arr,startIndex+1,endIndex);

        List<List<Integer>> ans = new ArrayList<>(smallAns);
        for(List<Integer> subset: smallAns){
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(arr[startIndex]);
            ans.add(newSubset);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(checkAB("abbabbabbabbaaaa"));

//        System.out.println(staircase(4));

//        int arr[] = {1,10,9,8,100,65,34};
//        System.out.println(binarySearch(arr,65,0,arr.length-1));

        int[] arr2 = {15,20,12};
        List<List<Integer>> ans = returnSubsets(arr2,0, arr2.length-1);
        System.out.println(ans.toString());
    }
}
