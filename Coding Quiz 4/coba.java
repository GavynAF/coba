public class coba {
    public static void main(String[] args) {
        String kebalikX, kalimat="WOILAHKATAGWTEH";
        System.err.println(kalimat);

        StringBuilder kebalik = new StringBuilder();
        char[] puter;
        puter = kalimat.toCharArray();
        for (int index = puter.length-1; index >= 0; index--) {
            kebalik.append(puter[index]);
        }

        String reverse = kebalik.toString();
        System.out.println(reverse);
    }
}
