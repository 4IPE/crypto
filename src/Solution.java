
import java.util.Scanner;

public class Solution {
    private final String ALPHABET =  "abcdefghijklmnopqrstuvwxyz";

    public StringBuilder taskOne() {
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        int code = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        if(command==1){
            return encoder(str,code);
        }
        else{
            return decoder(str, code);
        }
    }
    public StringBuilder encoder (String str,int code){
        StringBuilder stringBuilder = new StringBuilder();
        char[] charStr = str.toCharArray();
        for(int i =0 ;i<charStr.length;i++){
            String lowerCase = String.valueOf(charStr[i]).toLowerCase();
            if(ALPHABET.contains(lowerCase)){
                int ind = ALPHABET.indexOf(lowerCase);
                if(ind+code>=ALPHABET.length()){
                    int res = ALPHABET.length()-ind;

                    int res2 = code - res;
                    if(Character.isUpperCase(charStr[i])){
                        stringBuilder.append(String.valueOf(ALPHABET.charAt(res2)).toUpperCase());
                    }
                    else {
                        stringBuilder.append(ALPHABET.charAt(res2));
                    }

                }
                else{
                    if(Character.isUpperCase(charStr[i])){
                        stringBuilder.append(String.valueOf(ALPHABET.charAt(ind+code)).toUpperCase());
                    }
                    else {
                        stringBuilder.append(ALPHABET.charAt(ind+code));
                    }

                }
            }
            else{
                stringBuilder.append(charStr[i]);
            }
        }
       return stringBuilder;
    }
    public StringBuilder decoder(String str ,int code){
        String strLow = str.toLowerCase();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < strLow.length(); i++) {
            int charPosition = ALPHABET.indexOf(strLow.charAt(i));
            int keyVal = (charPosition - code) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            if(Character.isUpperCase(str.charAt(i))){
                String replaceVal = String.valueOf(ALPHABET.charAt(keyVal)).toUpperCase();
                message.append(replaceVal);
            }
            else if(ALPHABET.contains(String.valueOf(str.charAt(i)))) {
                char replaceVal = ALPHABET.charAt(keyVal);
                message.append(replaceVal);
            }
            else {
                char replaceVal = str.charAt(i);
                message.append(replaceVal);
            }

        }
        return message;
    }

}
