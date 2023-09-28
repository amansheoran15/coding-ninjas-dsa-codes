package recursion15;

import java.util.Arrays;

public class recursion15 {
    public static String removeChar(String str,char c1,char c2){
        if(str.length()==1){
            if(str.charAt(0)==c1){
                return Character.toString(c2);
            }
            return str;
        }
        String smallAns = removeChar(str.substring(1),c1,c2);
        if(str.charAt(0)==c1){
            smallAns = c2+smallAns;
        }else{
            smallAns = str.charAt(0)+smallAns;
        }
        return smallAns;
    }

    public static String removeDuplicates(String str){
        if(str.length() == 0 || str.length() == 1){
            return str;
        }
        String smallAns = removeDuplicates(str.substring(1));
        if(str.charAt(0)==smallAns.charAt(0)){
            return smallAns;
        }
        return str.charAt(0) + smallAns;
    }

    public static void merge2array(int[] arr,int startIndex,int endIndex){
        int mid = (startIndex+endIndex)/2;
        int i = startIndex;
        int j=mid+1;

        int[] ans = new int[endIndex-startIndex+1];
        int ansIndex = 0;

        while(i<=mid && j<=endIndex){
            if(arr[i]<arr[j]){
                ans[ansIndex++] = arr[i++];
            }else{
                ans[ansIndex++] = arr[j++];
            }
        }

        while(i<=mid){
            ans[ansIndex++] = arr[i++];
        }

        while(j<=endIndex){
            ans[ansIndex++] = arr[j++];
        }

        for (int k = 0; k < ans.length; k++) {
            arr[k+startIndex] = ans[k];
        }

        return;
    }

    public static void mergeSort(int[] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int mid = (startIndex+endIndex) / 2;
        mergeSort(arr,startIndex,mid);
        mergeSort(arr,mid+1,endIndex);
        merge2array(arr,startIndex,endIndex);
    }

    public static int partition(int[] arr,int startIndex,int endIndex){
        int pivot = arr[startIndex];
        int count = 0;
        for (int i = startIndex+1; i <= endIndex ; i++) {
            if(arr[i]<=pivot){
                count++;
            }
        }
        int pivotIndex = startIndex + count;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = pivot;
        arr[startIndex] = temp;

        int i = startIndex;
        int j = endIndex;
        while(i<pivotIndex && j>pivotIndex){
            if(arr[i]>pivot){
                while(arr[j]>pivot){
                    j--;
                }
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }
            i++;
        }
        return pivotIndex;
    }

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex = partition(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);
    }

    public static void main(String[] args) {
//        System.out.println(removeChar("xbxcd",'x','a'));

//        System.out.println(removeDuplicates("xxxyyyzzzwwzzyz"));

        int arr[] = {6,3,4,8,6,7,9,1,1};
//        mergeSort(arr,0,arr.length-1);
//        merge2array(arr,0, arr.length-1);
//        System.out.println(Arrays.toString(arr));


//        System.out.println(partition(arr,0,arr.length-1));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
