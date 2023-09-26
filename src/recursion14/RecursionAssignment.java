package recursion14;

public class RecursionAssignment {
    public static int mult(int m,int n){
        if(n==0){
            return 0;
        }
        if(m==0){
            return 0;
        }
        return m+mult(m,n-1);
    }

    public static int countZeroes(int num){
        if(num/10 == 0){
            if(num == 0){
                return 1;
            }
            return 0;
        }
        int lastDig = num%10;
        if(lastDig == 0){
            return 1+countZeroes(num/10);
        }
        return countZeroes(num/10);
    }

    public static double geometricSum(int k){
        if(k==0){
            return (1);
        }
        return geometricSum(k-1) + (1/Math.pow(2.0,k));
    }

    public static StringBuilder preProcess(String str){
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>47 && str.charAt(i)<58){
                newStr.append(str.charAt(i));
            }else if(str.charAt(i)>64 && str.charAt(i)<91){
                char c = (char) (str.charAt(i) + 32);
                newStr.append(c);
            }else if(str.charAt(i)>96 && str.charAt(i)<123){
                newStr.append(str.charAt(i));
            }
        }
        return newStr;
    }

    public static boolean checkPalindrome(String str,int startIndex,int endIndex){
        if(str.length()==1){
            return true;
        }
        if(startIndex >= endIndex){
            return true;
        }
        boolean smallAns = checkPalindrome(str,startIndex+1,endIndex-1);
        if(smallAns){
            return str.charAt(startIndex) == str.charAt(endIndex);
        }
        return false;
    }

    public static int sumOfDigits(int n){
        if(n/10==0){
            return n;
        }
        return n%10 + sumOfDigits(n/10);
    }

    public static void main(String[] args) {
//        System.out.println(mult(3,10));

//        System.out.println(countZeroes(1032000004));

//        System.out.println(geometricSum(4));

//        String str = "ninja";
//        System.out.println(checkPalindrome(str,0,str.length()-1));

        System.out.println(sumOfDigits(12009));
    }
}
