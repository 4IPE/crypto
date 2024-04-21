

public class Main {
    public static void main(String[] args) {
        DoubleEncoder doubleEncoder = new DoubleEncoder();
        String str = doubleEncoder.encoder("двойная перестановка",new int[]{3,1,4,2},new int[]{3,2,4,1,5});
        System.out.println(str);
        doubleEncoder.decoder(str,new int[]{3,1,4,2},new int[]{3,2,4,1,5});
    }
}