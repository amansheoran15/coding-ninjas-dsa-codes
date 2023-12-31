package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode {
    public static List<List<Integer>> threeSum(int[] arr) {
        int j,k;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length ; i++){
            j=i+1;
            k=arr.length-1;
            int sum = -arr[i];
//            System.out.println(sum);
            while (j<k){
                if(arr[j]+arr[k] == sum){
//                    System.out.println(i+" "+j+" "+k);
                    while( j<arr.length-1 && arr[j]==arr[j+1]){
                        j++;
                    }
                    while(arr[k]==arr[k-1] && k>i+1){
                        k--;
                    }
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    boolean contain = false;
//                    for (List<Integer> list: ans){
//                        if(list.equals(temp)){
//                            contain = true;
//                        }
//                    }
                    if(!contain){
                        ans.add(temp);
                    }
                    j++;
                }else if(arr[j]+arr[k] < sum){
                    j++;
                }else{
                    k--;
                }

            }
        }
        return ans;
    }

    public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int sum;
        if(target>=0){
            sum = Integer.MIN_VALUE/2;
        }else{
            sum = Integer.MAX_VALUE/2;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
//                System.out.println(Math.absExact(arr[i]+arr[j]+arr[k]-sum)+" "+Math.absExact(target-sum));
                if(Math.absExact(arr[i]+arr[j]+arr[k]-sum)<Math.absExact(target-sum)){
                    sum = arr[i]+arr[j]+arr[k];
                    j++;
                    k--;
                }else{
                    k--;
                }
            }
        }

        return sum;
    }
    public static void main(String[] args) {
//        int[] arr = {-1,0,1,2,-1,-4};
//        List<List<Integer>> ans = threeSum(arr);
//        System.out.println(ans.toString());

        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0},-100));

    }
}
