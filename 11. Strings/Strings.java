import java.util.*;

class Strings{

    public static int countWords(String str){
        if(str == ""){
            return 0;
        }
        int words = 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                words++;
            }
        }
        return words;
    }

    public static String reverseString(String str){
        for (int i = 0; i < str.length()/2; i++) {
            char temp = str.charAt(i);
            str = str.substring(0,i) + str.charAt(str.length() - i - 1) + str.substring(i+1);
//            System.out.println(str);
            str = str.substring(0,str.length() - i - 1) + temp + str.substring(str.length() - i);
//            System.out.println(str);
//            System.out.println();
        }
//        System.out.println(str);
        return str;
    }

    public static boolean checkPalindrome(String str){
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void printAllSubstrings(String str){
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                System.out.println(str.substring(i,j+1));
            }
        }
    }

    public static void printAllSubstringsLengthWise(String str){
        int endIndex = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length()-i; j++) {
                System.out.println(str.substring(j,j+endIndex));
            }
            endIndex++;
        }
    }

    public static String reverseEachWord(String str){
        String ansStr = "";
        String intermStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) ==' '){
                ansStr += reverseString(intermStr) + " ";
                intermStr = "";
            }else{
                intermStr += str.charAt(i);
            }
        }
        ansStr += reverseString(intermStr);
        return ansStr;
    }

    public static String reverseStringWordWise(String str){
        String ansStr = "";
        String intermStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                ansStr = intermStr +" "+ ansStr;
                intermStr = "";
            }
            else{
                intermStr += str.charAt(i);
            }
        }
        ansStr = intermStr +" "+ ansStr;
        return ansStr;
    }

    public static boolean checkPermuation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            int ind = str2.indexOf(str1.charAt(i));
            if(ind == -1){
                return false;
            }

            str2 = str2.substring(0,ind) + '*' + str2.substring(ind+1);
//            System.out.println(str2);
        }
        return true;
    }

    public static String removeConsecutiveDuplicates(String str){
        int i = 0;
        while(i<str.length()-1){
            if(str.charAt(i) == str.charAt(i+1)){
                str = str.substring(0,i) + str.substring(i+1);
            }else{
                i++;
            }
        }
        return str;
    }

    public static String removeCharacter(String str, char X){
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != X){
                newStr += str.charAt(i);
            }
        }

        return newStr;
    }

    public static char highestOccuringCharacter(String str){
        int[] freqArr = new int[256];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            freqArr[str.charAt(i)]++;
            if(freqArr[str.charAt(i)] > freqArr[max]){
                max = str.charAt(i);
            }
        }

        return (char)max;
    }

    public static String stringCompression(String str){
        int num = 1;
        String outStr = "";
        char ch = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ch){
                num++;
            }else if(num!=1){
                outStr += ch;
                outStr+=num;
                num = 1;
                ch = str.charAt(i);
            }else{
                num = 1;
                outStr+=ch;
                ch = str.charAt(i);
            }
        }
        outStr += ch;
        if(num != 1){
            outStr+=num;
        }
        return outStr;
    }


    public static void main(String[] args){
//        String str1 = "Hellooo";
//        String str2 = "Gel";
//        System.out.println(str1.compareTo(str2));

        Scanner s = new Scanner(System.in);
        String str3 = s.nextLine();
//        System.out.println(countWords(str3));

//        System.out.println(reverseString(str3));

//        System.out.println(checkPalindrome(str3));

//        printAllSubstrings(str3);
//        printAllSubstringsLengthWise(str3);

//        System.out.println(reverseEachWord(str3));

//        System.out.println(reverseStringWordWise(str3));

//        System.out.println(checkPermuation("abc","cbd"));

//        System.out.println(removeConsecutiveDuplicates(str3));

//        System.out.println(removeCharacter("xxyyzxx",'y'));

//        System.out.println(highestOccuringCharacter("abcdeapapqarr"));

        System.out.println(stringCompression(str3));
    }
}