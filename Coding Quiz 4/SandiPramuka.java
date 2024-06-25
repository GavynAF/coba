import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandiPramuka {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String kalimat;

        kalimat = input.nextLine().toUpperCase();
        String sandi = encodeToSandi(kalimat);
        System.out.println(sandi);

    }
    private static String encodeToSandi(String kalimat) {
        StringBuilder sandi = new StringBuilder();
        char[] karakter = kalimat.toCharArray();

        for (int i = 0; i < karakter.length; i++) {
            int num = getSandiNumber(karakter[i]);
            if (i>0&&num == getSandiNumber(karakter[i-1])) {
                sandi.append("-");
            }
            for (int j = 0; j < getCount(karakter[i]); j++) {
                sandi.append(num);
            }
        }

        return sandi.toString();
    }
    private static int getSandiNumber(char c){
        switch (c) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
                return 1;
            case 'E':
            case 'F': 
            case 'G': 
            case 'H':
                return 2;
            case 'I':
            case 'J':
            case 'K':
            case 'L':
                return 3;
            case 'M':
            case 'N':
            case 'O':
            case 'P':
                return 4;
            case 'Q':
            case 'R':
            case 'S':           
            case 'T':
                return 5;
            case 'U':
            case 'V':
            case 'W':
            case 'X':
                return 6;
            case 'Y':
            case 'Z':
                return 7;
            case ' ':
                return 0;
            default:
                return 0;
        }
    }
    public static int getCount(char c) {
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'M':
            case 'Q':
            case 'U':
            case 'Y':
            case ' ':
                return 1;
            case 'B':
            case 'F':
            case 'J':
            case 'N':
            case 'R':
            case 'V':
            case 'Z':
                return 2;
            case 'C':
            case 'G':
            case 'K':
            case 'O':
            case 'S':
            case 'W':
                return 3;
            case 'D':
            case 'H':
            case 'L':
            case 'P':
            case 'T':
            case 'X':
                return 4;
            default:
                return 0;
        }
    }
    private static List<String> generateSandiString(String kalimat) {
        List<String> listSandi = new ArrayList<String>();
        for (char huruf : kalimat.toCharArray()) {
            int sandi = getSandiNumber(huruf);
            int count = getCount(huruf);
            for (int index = 0; index < count; index++) {
                if (listSandi.lastIndexOf(listSandi)==sandi) {
                    listSandi.add("-");
                }
                listSandi.add(""+sandi);
            }
        }
        return listSandi;
    }
} 
