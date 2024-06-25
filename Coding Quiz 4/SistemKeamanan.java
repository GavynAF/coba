import java.util.Scanner;

public class SistemKeamanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String kalimat = input.nextLine();

        String tanpaSpasi = hapusSpasi(kalimat);

        System.out.println(tanpaSpasi);
        System.out.println(isPalindrom(tanpaSpasi));
        System.out.println(hitungJumlahHuruf(tanpaSpasi));

        if (isPalindrom(tanpaSpasi)) {
            System.out.println("Silahkan Masuk");
        } else {
            System.out.println("Akses Ditolak");
        }
    }

    public static String hapusSpasi(String kalimat) {
        StringBuilder kalimatTanpaSpasi = new StringBuilder();
        for (int i = 0; i < kalimat.length(); i++) {
            if (kalimat.charAt(i) != ' ') {
                kalimatTanpaSpasi.append(kalimat.charAt(i));
            }
        }
        return kalimatTanpaSpasi.toString();
    }

    public static boolean isPalindrom(String kalimat) {
        StringBuilder kebalik = new StringBuilder();
        char[] puter;
        puter = kalimat.toCharArray();
        for (int i = puter.length-1; i >=0 ; i--) {
            kebalik.append(puter[i]);
        }
        String reverse = kebalik.toString();

        if (kalimat.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    public static int hitungJumlahHuruf(String kalimat) {
        char[] puter;
        puter = kalimat.toCharArray();
        
        return puter.length;
    }
}
