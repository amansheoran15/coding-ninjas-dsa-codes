public class Rough {
    public static void main(String args[]){
        long a = 12345678999990L;
        System.out.println("hello" + a);
        System.out.println((byte)~-10);
        byte b = 7;
        System.out.println((byte)b<<1);

        int[][] arr = new int[4][];
        for (var i = 0; i<arr.length ; i++){
            arr[i] = new int[7];
        }
        for (var i = 0; i<arr.length; i++){
            for (var j =0; j<arr[i].length; j++){
                arr[i][j] = i+j;
            }
        }

        for(var i:arr){
            for (var j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
