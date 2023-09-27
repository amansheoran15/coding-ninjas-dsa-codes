package recursion15;

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

    public static int[] merge2array(int[] arr1, int[] arr2){

    }

//    public static void mergeSort(int[] arr,int startIndex,int endIndex){
//        if(arr.length==1){
//            return;
//        }
//        int mid = (startIndex+endIndex) / 2;
//        mergeSort(arr,startIndex,mid);
//        mergeSort(arr,mid+1,endIndex);
//    }

    public static void main(String[] args) {
//        System.out.println(removeChar("xbxcd",'x','a'));

        System.out.println(removeDuplicates("xxxyyyzzzwwzzyz"));
    }
}
