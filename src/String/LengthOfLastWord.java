package String;

/**
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {

        if (s.equals(" ")||s.equals("")){
            System.out.println(0);
            return 0;
        }
        String[] words = s.split(" ");
        try {
            String lastWord = words[words.length-1];
            System.out.println(lastWord.length());
            return lastWord.length();
        }catch (Exception e){
            System.out.println(0);
            return 0;
        }


    }
    //通过charat逐位判断，效率更高
    public static int lengthOfLastWord1(String s) {
        int count = 0;
        int end = s.length()-1;
        while (end>0&& s.charAt(end)==' '){
            end--;
        }
        while (end>0 && s.charAt(end)!=' '){

            count++;
            end--;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        String s = "    ";
        lengthOfLastWord1(s);
    }
}
