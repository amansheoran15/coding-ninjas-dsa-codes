import java.util.*;
class ArraySum{
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

    public static int sumArr(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int linearSearch(int[] arr,int ele){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ele){
                return i;
            }
        }
        return -1;
    }

    public static int[] populateArr(int N){
        int[] arr = new int[N];
        boolean even = N%2==0;
        int end;
        if(even)
            end = N/2 - 1;
        else
            end = N/2;
        int ele = 1;
        for (int i = 0; i<=end; i++){
            arr[i] = ele;
            ele +=2;
        }
        if (even)
            ele = arr[end] + 1;
        else
            ele = arr[end] - 1;

        for (int i = end+1; i < arr.length; i++) {
            arr[i] = ele;
            ele-=2;
        }
        return arr;
    }

    public static void swapArr(int[] arr){
        boolean even = arr.length%2==0;
        int end;
        if(even)
            end = arr.length;
        else
            end = arr.length-1;
        for (int i = 0; i < end; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
    
    public static int unique(int[] arr){
        int[] isDone = new int[arr.length/2+1];
        int isDoneIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            loop: if(linearSearch(isDone,arr[i])==-1){
                for(int j=i+1; j<arr.length; j++){
                    if(arr[i]==arr[j]){
                        isDone[isDoneIndex++] = arr[i];
                        break loop;
                    }
                }
                return arr[i];
            }
        }
        return -1;
    }

    public static int duplicate(int[] arr){
        int sumN = 0;
        for (int i = 0; i < arr.length; i++) {
            sumN += arr[i];
        }
        int n = arr.length-2;
        int sumN_2 = n*(n+1)/2;
        return (sumN-sumN_2);

    }

    public static void intersection(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]){
                    System.out.println(arr1[i]);
                    arr2[j] = Integer.MIN_VALUE;
                }
            }
        }
    }

    public static void pairSum(int[] arr, int x){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i!=j && arr[i] + arr[j] == x){
                    System.out.println(arr[i]+" "+arr[j]);
                }
            }
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public static void sort01(int[] arr){
        int first = 0;
        int second = 1;
        int i=0;
        while(arr[i]!=1){
            first++;
            i++;
        }
        second = first+1;
        while(second<arr.length){
            if(arr[first]>arr[second]){
                int temp = arr[first];
                arr[first] = arr[second];
                arr[second] = temp;
                first++;
            }
            second++;
        }
    }

    public static void main(String args[]){
        int size;
        System.out.println("Input size of the array: ");
        Scanner s = new Scanner(System.in);
        size = s.nextInt();
        int[] arr = new int[size];
        takeInput(arr);

//        printArr(arr);
//        System.out.println("Sum is: "+sumArr(arr));
//        System.out.println("Enter element to be searched: ");
//        int ele = s.nextInt();
//        System.out.println("Element found at index: " +linearSearch(arr,ele));
//        int N;
//        System.out.println("Enter N: ");
//        N = s.nextInt();
//        int[] popuArr = populateArr(N);
//        printArr(popuArr);

//        swapArr(arr);
//        printArr(arr);

//        System.out.println("Unique element is: " + unique(arr));


//        System.out.println("Duplicate element is: " + duplicate(arr));

//        int[] arr1 = {2,6,8,5,4,3};
//        int[] arr2 = {2,3,4,7};
//        intersection(arr1,arr2);

//        pairSum(arr,10);

        sort01(arr);
        printArr(arr);
    }
}