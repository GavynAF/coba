import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String posisi, divisi;

        posisi = input.nextLine();
        divisi = input.next();

        String[] position = {"Software Engineer","Data Analyst", "UX Designer", "Project Manager", "QA ENgineer"};
        String[] division = {"Surabaya","Jakarta","Bandung","Medan","Makassar"};
    
        int pos=0,div=0;
        for (int i = 0; i < position.length; i++) {
            if (position[i].equals(posisi)) {
                pos = i;
            }
            if (division[i].equals(divisi)) {
                div = i;
            }
        }

        int gajipokok = getGajiPokok(pos, div);
        int tunjangan = (22*50000)+calculateTunjanganKesehatan(gajipokok)+getTunjanganTransport(div);
        int PotonganBPJS = calculatePotonganBPJS(gajipokok);
        int PotonganPPH = calculatePotonganPPH(gajipokok);
        int totalpotongan = PotonganBPJS+PotonganPPH;
        int gajibersih = calculateGajiBersih(gajipokok, tunjangan, totalpotongan);
        String formatGajiBersih = FormatCurrency(gajibersih);

        printHasil(posisi, divisi, formatGajiBersih);
    }

    public static String FormatCurrency(int gajibersih) {
        StringBuilder format = new StringBuilder();
        String angka = Integer.toString(gajibersih);
        int z =0;
        for (int i = angka.length()-1; i >= 0 ; i--) {
            format.append(angka.charAt(z));
            if (i%3==0&&i!=0) {
                format.append(",");
            }
            z++;
            //0 1 2, 3 45, 678,
        }
        format.append(".00");

        return format.toString();
        
    }

    public static int getGajiPokok(int pos, int div) {
        int[][] gajiPokok = {
                                {8000000,9000000,7500000,7200000,8500000},
                                {7000000,8000000,6500000,6200000,7500000},
                                {7500000,8500000,7000000,6800000,8000000},
                                {10000000,11000000,9500000,9200000,10500000},
                                {7500000,8500000,7000000,6800000,8000000}
                            };
        
        int gaji = gajiPokok[pos][div];       
        return gaji;
    }

    public static int getTunjanganTransport(int div) {
        int[] tunjanganTransport = {1000000,1500000,1200000,1100000,1300000};
        int transport = tunjanganTransport[div];

        return transport;
    }


    public static int calculateTunjanganKesehatan(int gajipokok) {
        return (int)(0.02*gajipokok);
    }

    public static int calculatePotonganBPJS(int gajipokok) {
        return (int)(0.03*gajipokok);
    }

    public static int calculatePotonganPPH(int gajipokok) {
        return (int)(0.05*gajipokok);
    }

    public static int calculateGajiBersih(int gajipokok, int tunjangan, int potongan) {
        return gajipokok+tunjangan-potongan;
    }

    public static void printHasil(String posisi, String divisi, String gajibersih){
        System.out.println(posisi);
        System.out.println(divisi);
        System.out.println("22 hari");
        System.out.println(gajibersih);
    }
}
