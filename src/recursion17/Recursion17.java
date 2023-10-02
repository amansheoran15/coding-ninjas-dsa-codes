package recursion17;

import java.util.Arrays;

public class Recursion17 {

    public static String[] returnSubsequences(String str){
        if(str.length()==1){
            return new String[]{"",str};
        }
        String[] smallAns = returnSubsequences(str.substring(1));
        String[] ans = new String[smallAns.length*2];
        for (int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
        }
        for (int i = 0; i < smallAns.length; i++) {
            ans[smallAns.length+i] = str.charAt(0)+smallAns[i];
        }

        return ans;
    }

    public static void printSubsequences(String str, String considered){
        if(str.isEmpty()){
            System.out.println(considered);
            return;
        }
        printSubsequences(str.substring(1),considered);
        printSubsequences(str.substring(1),considered+str.charAt(0));
    }

    private static char[] keypadStrings(int num){
        return switch (num) {
            case 2 -> new char[]{'a', 'b', 'c'};
            case 3 -> new char[]{'d', 'e', 'f'};
            case 4 -> new char[]{'g', 'h', 'i'};
            case 5 -> new char[]{'j', 'k', 'l'};
            case 6 -> new char[]{'m', 'n', 'o'};
            case 7 -> new char[]{'p', 'q', 'r', 's'};
            case 8 -> new char[]{'t', 'u', 'v'};
            case 9 -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[]{'1'};
        };
    }

    public static String[] returnKeypad(int num){
        if(num==0){
            return new String[]{""};
        }
        String[] smallAns = returnKeypad(num/10);
        char[] numChars = keypadStrings(num%10);
        String[] ans = new String[smallAns.length * numChars.length];

        int i = 0;
        int j;
        for(char c: numChars){
            j=0;
            for(String s:smallAns){
                ans[i++] = smallAns[j++]+c;
            }
        }

        return ans;
    }

    public static void printKeypad(int num, String output){
        if(num==0){
            System.out.println(output);
            return;
        }
        char[] charArr = keypadStrings(num%10);
        for (char c:charArr) {
            printKeypad(num/10,c+output);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(returnSubsequences("xyz")));

        System.out.println(Arrays.toString(returnKeypad(23)));

//        printSubsequences("xyz","");

        printKeypad(23,"");
    }
}
