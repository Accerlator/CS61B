public class Args_sum {
    public static void main(String[] str) {
        int length = str.length;
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum = sum + Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
}