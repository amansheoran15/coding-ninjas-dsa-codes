import java.util.*;
class SearchSort{
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

    public static int binarySearch(int[] arr,int ele){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == ele){
                return mid;
            }else if(arr[mid]<ele){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] arr){
        int start = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int ind = -1;
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j]<arr[i]){
                    ind = j;
                    System.out.println("inside ind loop" + ind);
                    break;
                }
            }
            System.out.println(ind);
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

    public static int[] merge2array(int[] arr1, int[] arr2){
        int firstArrPointer = 0, secondArrPointer = 0, mergedArrPointer = 0;
        int[] mergedArr = new int[arr1.length + arr2.length];
        while(firstArrPointer < arr1.length && secondArrPointer < arr2.length){
            if(arr1[firstArrPointer] < arr2[secondArrPointer]){
                mergedArr[mergedArrPointer++] = arr1[firstArrPointer++];
            }else{
                mergedArr[mergedArrPointer++] = arr2[secondArrPointer++];
            }
        }

        while(firstArrPointer < arr1.length){
            mergedArr[mergedArrPointer++] = arr1[firstArrPointer++];
        }
        while (secondArrPointer< arr2.length){
            mergedArr[mergedArrPointer++] = arr2[secondArrPointer++];
        }

        return mergedArr;
    }

    public static void pushZeroes(int[] arr){
        int zeroPointer = 0, nonZeroPointer;
        while(arr[zeroPointer]!=0){
            zeroPointer++;
        }
        nonZeroPointer = zeroPointer+1;
        while(arr[nonZeroPointer]==0){
            nonZeroPointer++;
        }
        while(nonZeroPointer<arr.length){
            if(arr[nonZeroPointer]!=0){
                int temp = arr[zeroPointer];
                arr[zeroPointer] = arr[nonZeroPointer];
                arr[nonZeroPointer] = temp;
                while(arr[zeroPointer]!=0){
                    zeroPointer++;
                }
            }
            nonZeroPointer++;

        }
    }

    public static void rotateArr(int[] arr, int k){
        while(k!=0){
            int temp = arr[0];
            for (int i = 0; i < arr.length-1 ; i++) {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
            k--;
        }
    }

    public static int secondMaxInArr(int[] arr){
        int max = arr[0], secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            if(arr[i]<max && arr[i]>secondMax){
                secondMax = arr[i];
            }
        }
        if(max == secondMax){
            return -1;
        }
        return secondMax;
    }

    public static int checkArrRotation(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i+1]<arr[i]){
                return i+1;
            }
        }
        return 0;
    }

    public static void sort012(int[] arr){
        int current = 0,zeroPos = 0,twoPos = arr.length - 1;

        while(current<arr.length ){
            while(arr[zeroPos] == 0){
                zeroPos++;
            }
            while(arr[twoPos] == 2){
                twoPos--;
            }
            if(current > zeroPos && arr[current] == 0){
                int temp = arr[current];
                arr[current] = arr[zeroPos];
                arr[zeroPos] = temp;
                zeroPos++;
            }else if(current < twoPos && arr[current] == 2){
                int temp = arr[current];
                arr[current] = arr[twoPos];
                arr[twoPos] = temp;
                twoPos--;
            }else{
                current++;

            }
//            printArr(arr);
//            System.out.println();

        }
    }

    public static int[] sumOf2Arr(int[] arr1, int[] arr2){
        int maxLen = arr1.length>arr2.length?arr1.length+1:arr2.length+1;
        int ansArr[] = new int[maxLen];
        int arr1Pointer = arr1.length-1, arr2Pointer = arr2.length - 1;
        int carry = 0;
        int ansArrPointer = ansArr.length-1;
        while(arr1Pointer>=0 && arr2Pointer>=0){
            int sum = arr1[arr1Pointer] + arr2[arr2Pointer] + carry;
            carry = sum/10;
            ansArr[ansArrPointer] = sum%10;
            System.out.println(ansArr[ansArrPointer] + " " + carry);
            ansArrPointer--;
            arr1Pointer--;
            arr2Pointer--;
        }
        while(arr1Pointer>=0){
            int sum = arr1[arr1Pointer--] + carry;
            carry = sum/10;
            ansArr[ansArrPointer--] = sum%10;
        }
        while(arr2Pointer>=0){
            int sum = arr2[arr2Pointer--] + carry;
            carry = sum/10;
            ansArr[ansArrPointer--] = sum%10;
        }
        if(carry != 0){
            ansArr[ansArrPointer] = carry;
        }
        return ansArr;
    }

    public static void main(String args[]){
//        int[] arr = {1 ,2 ,3 ,4 ,5 ,6 ,7};
//        System.out.println("Element found at index: "+binarySearch(arr,7));

        int arr2[] = {2 ,13 ,4 ,1 ,3 ,6 ,28};
//        selectionSort(arr2);
//        bubbleSort(arr2);
//        insertionSort(arr2);
//        printArr(arr2);

//        int[] arr3 = {1,5,7,8};
        int[] arr4 = {3,4,6,9};
//        int[] mergedArr = merge2array(arr3,arr4);
//        printArr(mergedArr);

//        int[] arr5 = {9,0,0,8,2};
//        pushZeroes(arr5);
//        printArr(arr5);

        int arr6[] = {1,2,3,4,5,6,7};
//        rotateArr(arr6,2);
//        printArr(arr6);

        int[] arr7 = {-10, -40 ,-25 ,-12 ,-25 ,-10};
//        System.out.println(secondMaxInArr(arr7));

        int[] arr8 = {5 ,6 ,1 ,2 ,3 ,4};
//        System.out.println(checkArrRotation(arr8));

        int[] arr9 = {1,0,2,0,1,1,1,2,2,0,0,0,1,1,2,2,0,0};
//        sort012(arr9);
//        printArr(arr9);

        int[] arr10 = {9,7,6,1};
        int[] arr11 = {4,5,9};
        printArr(sumOf2Arr(arr10,arr11));

    }
}