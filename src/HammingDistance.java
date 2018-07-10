import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * The Hamming distance between two integers
 * is the number of positions at which the corresponding bits are different.
 * 比较二进制的各个位不一样的
 * Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        //直接用异或运算计算出一共有多少位不同
        int xor = x^y;
        int count = 0;
        for (int i=0;i<32;i++){
            //与1 进行与运算 相同则加一
            count +=(xor >> i) & 1;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        hammingDistance(4,1);
    }
}
