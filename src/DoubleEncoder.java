import java.util.ArrayList;
import java.util.List;

public class DoubleEncoder {
    public String encoder(String text, int [] xKey, int[] yKey) {
        char[] charMas = text.replaceAll("//s+", "").toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char elem:charMas){
            charList.add(elem);
        }
        char[][] data = new char[yKey.length][xKey.length];
        for(int i =0;i<yKey.length;i++){
            for (int j =0;j<xKey.length;j++){
                data[yKey[i]-1][xKey[j]-1] = charList.get(0);
                charList.remove(0);
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i =0;i<data.length;i++){
           for(int j = 0;j<data[i].length;j++){
               str.append(data[i][j]);
           }
        }
        return String.valueOf(str);

    }
    public void decoder(String text, int [] xKey, int[] yKey) {
        char[] charMas = text.replaceAll("//s+", "").toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char elem:charMas){
            charList.add(elem);
        }
        char[][] data = new char[yKey.length][xKey.length];
        StringBuilder str = new StringBuilder();
        for(int i =0;i<yKey.length;i++){
            for (int j =0;j<xKey.length;j++){
                data[i][j] = charList.get(0);
                charList.remove(0);
            }
        }
        for(int i =0;i<yKey.length;i++){
            for(int j = 0;j<xKey.length;j++){
                str.append(data[yKey[i]-1][xKey[j]-1]);
            }
        }
        System.out.println(str);

    }

}
