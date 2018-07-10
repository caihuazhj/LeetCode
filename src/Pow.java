/**
 * 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n x的n次幂.
 */
public class Pow {
    //递归调用
    //数字太大会存在stackoverflow
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if (n<0){
            return 1/myPow(x,-n);
        }

        if (n%2==0){
            return myPow(x,n/2)*myPow(x,n/2);
        }else{
            return x*myPow(x,n/2)*myPow(x,n/2);
        }
    }

    //折半查找
    public  double myPow2(double x, int n){
        if (n < 0){
            return 1 / power(x, -n);
        }
        return power(x, n);
    }
    public double power(double x, int n) {
        if (n == 0){
            return 1;
        }
        double half = power(x, n / 2);
        if (n % 2 == 0){
            return half * half;
        }
        return x * half * half;
    }

    public double myPow3(double x, int n) {
        if (n == 0){
            return 1;
        }
        double half = myPow3(x, n / 2);
        if (n % 2 == 0){
            return half * half;
        }
        else if (n > 0){
            return half * half * x;
        }
        else
        {
            return half * half / x;
        }
    }
    public static void main(String[] args) {
        Pow pow =new Pow();

        System.out.println(pow.myPow(0.000001,
                2147483647));
    }
}
