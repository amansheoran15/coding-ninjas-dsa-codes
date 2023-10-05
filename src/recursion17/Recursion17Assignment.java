package recursion17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public static void printSubsets(int[] arr,int startIndex, ArrayList<Integer> output){
        if(startIndex>arr.length-1){
            System.out.println(output.toString());
            return;
        }
//        System.out.println(output.toString());
        printSubsets(arr,startIndex+1,output);
        ArrayList<Integer> newOut = new ArrayList<>(output);
        newOut.add(arr[startIndex]);
        printSubsets(arr,startIndex+1,newOut);
    }

    public static List<List<Integer>> returnSubsetSumK(int[] arr,int startIndex,int k){
        if(startIndex>arr.length-1){
            return new ArrayList<>(){};
        }
        if(arr[startIndex]==k){
            List<List<Integer>> a = new ArrayList<>();
            ArrayList<Integer> b= new ArrayList<>();
            b.add(arr[startIndex]);
            a.add(b);
            return a;
        }
        List<List<Integer>> smallAns1 = returnSubsetSumK(arr,startIndex+1,k);
        List<List<Integer>> smallAns2 = returnSubsetSumK(arr,startIndex+1,k-arr[startIndex]);

        if(!smallAns2.isEmpty()){
            for(List<Integer> subset : smallAns2){
                subset.add(arr[startIndex]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(smallAns1);
        ans.addAll(smallAns2);
        return ans;
    }

    public static List<List<Integer>> returnSubsetSumK(int[] arr,int k){
        List<List<Integer>> ans = returnSubsetSumK(arr,0,k);
        for(List<Integer> subset: ans){
            Collections.reverse(subset);
        }
        return ans;
    }


    public static void printSubsetSumK(int[] arr ,int startIndex,int k, ArrayList<Integer> output){
        if(startIndex>arr.length-1){
            int sum=0;
            for(int i:output){
                sum+=i;
            }
            if(sum==k){
                System.out.println(output.toString());
            }
            return;
        }
        printSubsetSumK(arr,startIndex+1,k,output);
        ArrayList<Integer> newOut = new ArrayList<>(output);
        newOut.add(arr[startIndex]);
        printSubsetSumK(arr,startIndex+1,k,newOut);
    }

    public static void printSubsetSumK2(int[] arr , int startIndex, int k, ArrayList<Integer> output){
        if(startIndex>arr.length-1){
            if(k==0){
                System.out.println(output.toString());
            }
            return;
        }
        printSubsetSumK2(arr,startIndex+1,k,output);
        ArrayList<Integer> newOut = new ArrayList<>(output);
        newOut.add(arr[startIndex]);
        printSubsetSumK2(arr,startIndex+1,k-arr[startIndex],newOut);
    }

    public static String[] returnCodes(int num){
        if(num==0){
            String[] s = {""};
            return s;
        }

        String[] smallAns1 = returnCodes(num/10);
        String[] smallAns2 = returnCodes(num/100);
        char code1 = (char)(num%10 + 'a' - 1);
        char code2 = ' ';
        boolean code2Check = false;
        if(num/10 !=0 && num%100 < 27){
            code2 = (char) (num%100 + 'a' - 1);
            code2Check = true;
        }
        for(int i=0; i<smallAns1.length; i++){
            smallAns1[i] = smallAns1[i] + code1;
        }
        if(code2Check){
            for(int i=0; i<smallAns2.length; i++){
                smallAns2[i] = smallAns2[i] + code2;
            }
        }
        int len = code2Check?smallAns1.length + smallAns2.length:smallAns1.length;
        String[] ans = new String[len];
        int k = 0;
        for(String s:smallAns1){
            ans[k++] = s;
        }
        if(code2Check){
            for(String s:smallAns2){
                ans[k++] = s;
            }
        }
        return ans;
    }

    public static void printCodes(int num, String output){
        if(num==0){
            System.out.println(output);
            return;
        }

        printCodes(num/10,((char)(num%10 + 'a' - 1)) + output);
        if(num/10!=0 && num%100 <= 26){
            printCodes(num/100,((char)(num%100 + 'a' - 1)) + output);
        }
    }

    public static String[] returnPermutations(String str){
        if(str.length() == 1){
            String[] s = {str};
            return s;
        }

        String[] smallAns = returnPermutations(str.substring(1));
        String[] ans = new String[str.length()*smallAns.length];
        int k = 0;
        for(String s: smallAns){
            String dup;
            for (int i = 0; i <= s.length(); i++) {
                dup = s.substring(0,i) + str.charAt(0) + s.substring(i);
                ans[k++] = dup;
            }
        }

        return ans;
    }

    public static void printPermutations(String str, String output){
        if(str.isEmpty()){
            System.out.println(output);
            return;
        }

        for (int i = 0; i <= output.length(); i++) {
            printPermutations(str.substring(1),output.substring(0,i)+str.charAt(0)+output.substring(i));
        }
    }



    public static void main(String[] args) {
//        System.out.println(checkAB("abbabbabbabbaaaa"));

//        System.out.println(staircase(4));

//        int arr[] = {1,10,9,8,100,65,34};
//        System.out.println(binarySearch(arr,65,0,arr.length-1));

        int[] arr2 = {1,2,5,3,7};
//        List<List<Integer>> ans = returnSubsets(arr2,0, arr2.length-1);
//        System.out.println(ans.toString());
        ArrayList<Integer> ans = new ArrayList<>();
//        printSubsets(arr2,0,ans);

//        System.out.println(returnSubsetSumK(arr2,8));
//        printSubsetSumK2(arr2,0,8,ans);

//        System.out.println(Arrays.toString(returnCodes(1)));
//        printCodes(1,"");

        System.out.println(Arrays.toString(returnPermutations("abc")));
        printPermutations("abc","");
    }
}
