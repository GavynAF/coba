import java.util.Scanner;

public class TokoTujuhSembilan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlahProduk=0;

        String[] namaProduk;
		String[] label;
		int [] harga;
		
        jumlahProduk = Integer.valueOf(input.nextLine());

        namaProduk = new String[jumlahProduk];
		label = new String[jumlahProduk];
		harga = new int [jumlahProduk];

        for (int i = 0; i < jumlahProduk; i++) {
			namaProduk[i] = input.nextLine();
			label[i] = input.nextLine();
			harga[i] = Integer.parseInt(input.nextLine());
            
        }

        for (int index = 0; index < jumlahProduk; index++) {
            System.out.println(namaProduk[index]);
            int labaPercentage = getLabaPercentage(label[index]);
            int hargajual = (int)(kalkulasiHargaJual(labaPercentage, harga[index]));
            System.out.println(hargajual);
            // System.out.println(label[index]);
            System.out.println();
        }
    }

    public static int getLabaPercentage(String labaPercentage) {
        int persentase = 0;
        switch (labaPercentage) {
            case "Good":
                persentase = 15;
                break;
            case "Recommended":
                persentase = 25;
                break;
            case "Best Seller":
                persentase = 35;
                break;
            case "Normal":
                persentase = 10;
                break;
            default:
                break;
        }
        return persentase;
    }

    public static double kalkulasiHargaJual(int labaPercentage, int hargaProduksi) {
        double hargajual=0;

        hargajual = (labaPercentage/100.0)*hargaProduksi;

        return hargajual+hargaProduksi;
    }
}
