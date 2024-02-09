import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println(convertDecimalNumbersToBinary(5));
        System.out.println(convertDecimalNumbersToBinary(6));
        System.out.println(convertDecimalNumbersToBinary(13));

    }

    public static boolean checkForPalindrome(String text) {
        Stack<String> stack = new Stack<>();
        text = text.toLowerCase();

        ArrayList<String> textList = new ArrayList<>(Arrays.asList(text.split("")));
        Queue<String> kontrolList = new LinkedList<>();

        for(int i = 0; i < textList.size(); i++){
            if(!(textList.get(i).equals(".") || textList.get(i).equals(",") || textList.get(i).equals("?") || textList.get(i).equals("!") || textList.get(i).equals("_") || textList.get(i).equals("-") || textList.get(i).equals(" ") || textList.get(i).equals("'"))){
                stack.push(textList.get(i));
                kontrolList.add(textList.get(i));
            }
        }
        for(int i = 0; i < kontrolList.size(); i++){
            if(!(stack.pop().equals(kontrolList.poll()))){
                return false;
            } else if (i == kontrolList.size()){
                return true;
            }
        }
        return true;
    }

    public static String convertDecimalNumbersToBinary(int number) {
        Stack<Integer> binariyVers = new Stack<>();
        int sonuc = 0, kalan = 0, elemanSayi = 0;
        String cikti = "";


        while(sonuc != -1){
            if(number > 1){
                kalan = number % 2;
                number -= kalan;
                binariyVers.add(kalan);
                number /= 2;
            } else {
                binariyVers.add(number);
                sonuc = -1;
            }
        }

        System.out.println(binariyVers);
        elemanSayi = binariyVers.size();

        for(int i = elemanSayi - 1; i >= 0; i--) {
            if (i != 0)
                cikti += 2 + "^" + i*binariyVers.pop() + " + ";
            else
                cikti += 2 + "^" + i*binariyVers.pop();
        }

        return cikti;
    }
}