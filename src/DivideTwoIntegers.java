/**
 * 29. Divide Two Integers
 * Given two integers dividend and divisor,
 * divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 *
 *
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //在程序 判定之前要考虑特殊情况，被除数/除数取最大和最小值时，否则会超时
        //辅助数组
        long[] array = new long[50];
        int i = -1;
        long sum = 0;
        int re = 0;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        //除数为0 返回max
        if (divisor ==0){
            return Integer.MAX_VALUE;
        }

        //计算绝对值
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);


        //指数逼近
        while (b<=a){
            array[++i] = b;
            b =b*2;

        }
        //逼近完成后，找到指数
        for (int j=i;j>=0;j--){
            if (sum+array[j]>a){
                continue;
            }else{
                sum += array[j];
                re+=Math.pow(2,j);

            }

        }
        //正负号
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            return -re;
        }else{
            return re;
        }
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648
                ,2));
    }
}
