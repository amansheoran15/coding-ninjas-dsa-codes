package recursion15;

public class Recursion15Assignment {
    public static String replacePi(String str){
        if(str.length()<=1){
            return str;
        }
        String smallAns = replacePi(str.substring(1));
        if(str.charAt(0)=='p' && smallAns.charAt(0)=='i'){
            smallAns = "3.14" + smallAns.substring(1);
        }else{
            smallAns = str.charAt(0)+smallAns;
        }
        return smallAns;
    }

    public static int str2int(String str){
        if(str.length()==1){
            return str.charAt(0)-'0';
        }
        int smallAns = str2int(str.substring(1));
        if(str.charAt(0)=='-'){
            return -1*smallAns;
        }
        int ans = (int) ((str.charAt(0)-'0')*Math.pow(10,str.length()-1) + smallAns);
        return ans;
    }

    public static String pairStar(String str){
        if(str.length()<=1){
            return str;
        }
        String smallAns = pairStar(str.substring(1));
        if(str.charAt(0)==smallAns.charAt(0)){
            smallAns = str.charAt(0) + "*" + smallAns;
        }else{
            smallAns = str.charAt(0) + smallAns;
        }

        return smallAns;
    }

    public static void towerOfHanoi(int n,char start, char dest, char aux){
        if(n==1){
            System.out.println(start+" "+dest);
            return;
        }
        towerOfHanoi(n-1,start,aux,dest);
        towerOfHanoi(1,start,dest,aux);
        towerOfHanoi(n-1,aux,dest,start);
    }

    public static void main(String[] args) {
        System.out.println(replacePi("xpipix"));

        System.out.println(str2int("1234"));

        System.out.println(pairStar("aaaa"));

        towerOfHanoi(3,'a','c','b');
    }
}
