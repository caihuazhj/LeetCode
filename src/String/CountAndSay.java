package String;

public class CountAndSay {
    public String countAndSay(int n) {
        int i =1;
        String result = "1";
        while (i<n){
            count(result);
            i++;
        }
        return result;
    }

    public String count(String res){
        char c = res.charAt(0);
        int num =1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1;i<res.length();i++){
            if (res.charAt(i)==c){
                num++;
            }
            stringBuilder.append(String.valueOf(num)+c);
            c = res.charAt(i);
            num =1;
        }
        stringBuilder.append(String.valueOf(num)+c);
        return stringBuilder.toString();

    }
}
