import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

/**
 * 744. Find Smallest Letter Greater Than Target
 * Given a list of sorted 有序 characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 *
 * Example
 * Input:
    letters = ["c", "f", "j"]
    target = "a"
    Output: "c"

     Note:
     letters has a length in range [2, 10000].
     letters consists of lowercase letters, and contains at least 2 unique letters.
     target is a lowercase letter.

 */
public class FirstLargerLetter {

    public static char nextGreatestLetter() {

        char target;
        char c = ' ';
        Scanner scanner = new Scanner(System.in);
        //输入
        while (scanner.hasNext()){
            int k = scanner.nextInt();
            char[] letters = new char[k];
            for (int i=0;i<letters.length;i++){
                letters[i] = scanner.next().charAt(0);
                System.out.println(letters[i]);
            }
            target = scanner.next().charAt(0);
            System.out.println(target);


        for (char a :letters) {
            if (a>target){
                System.out.println(a);
                c= a;
                System.out.println("shini");
                return c;
            }else{
                c= letters[0];
            }
        }
        System.out.println(letters[0]);
        }
        return c;
    }

    public static char bsNextChar(char[] letters,char target){

        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target){
                lo = mi + 1;
            }
            else{
                hi = mi;
            }
        }
        return letters[lo % letters.length];
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'c','h','j','t','u'};
        System.out.println(bsNextChar(chars,'e'));
    }

}
