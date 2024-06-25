import java.util.Scanner;

public class BahasaPanda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String kalimat = input.nextLine().toUpperCase();
        String sandi = generateSandiString(encodeToSandi(kalimat));
        System.out.println(sandi);
    }
    private static int getSandiNumber(char C) {
        switch (C) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'I':
                return 9;
            case 'J':
                return 10;
            case 'K':
                return 11;
            case 'L':
                return 12;
            case 'M':
                return 13;
            case 'N':
                return 14;
            case 'O':
                return 15;
            case 'P':
                return 16;
            case 'Q':
                return 17;
            case 'R':
                return 18;
            case 'S':
                return 19;
            case 'T':
                return 20;
            case 'U':
                return 21;
            case 'V':
                return 22;
            case 'W':
                return 23;
            case 'X':
                return 24;
            case 'Y':
                return 25;
            case 'Z':
                return 26;
            case ' ':
                return 0;
            default:
                return 0;
        }
    }

    private static int[] encodeToSandi(String input) {
        int [] sandi;
        char[] kalimat = input.toCharArray();
        sandi = new int[kalimat.length];
        
        // StringBuilder sandi = new StringBuilder();
        // char[] karakter = input.toCharArray();
        for (int i = 0; i < kalimat.length; i++) {
            int x = getSandiNumber(kalimat[i]);
            sandi[i] = x;

        }
        return sandi;
        
    }

    private static String generateSandiString(int[] sandi) {
        StringBuilder sandiString = new StringBuilder();
        for (int i = 0; i < sandi.length; i++) {
            if(sandi[i]==0){
                sandiString.append("-");
            }else{
                sandiString.append(sandi[i]);
            }
            if (sandi[i]!=0 && (i<sandi.length-1&&sandi[i+1]!=0)) {
                sandiString.append(".");
            }
        }
        return sandiString.toString();
    }

}
