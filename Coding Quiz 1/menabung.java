import java.util.Scanner;
/**
 * menabung
 */
public class menabung {
    public static void main(String[] args) {
        int jumlahkeluarga, bulan, total=0;

        Scanner input = new Scanner(System.in);
        jumlahkeluarga = input.nextInt();
        bulan = input.nextInt();

        if((jumlahkeluarga>1&&jumlahkeluarga<6)&&(bulan>0&&bulan<13)){
            for (int i = 1; i <=bulan; i++) {
                int x = bulanx(i);
                int totalperbulan = x*(1+x)/2;
                total = total +totalperbulan;
            }
            System.out.println(total*jumlahkeluarga*1000);
        }
        
    }

    public static int bulanx(int bulan) {
        switch (bulan) {
            case 2:
                return 29;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}