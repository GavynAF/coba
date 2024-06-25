import java.util.Scanner;

public class AgentTravel {
    public static void main(String[] args) {
        int n;

        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        if (n>0&&n<=120) {
            System.out.println(rekomendasi(n));
        }

    }
    public static int rekomendasi(int n) {
        int Rec=0;
        int[] kapasitas = {60,45,32,18,12};
        int[] harga = {2300000,2000000,1800000,1500000,1300000};

        if(n <=kapasitas[0]){
            for (int i = 0; i < kapasitas.length; i++) {
                if (n<=kapasitas[i]) {
                    Rec = harga[i];
                }
            }
        }else{
            for (int i = 0; i < kapasitas.length; i++) {
                for (int j = 0; j < kapasitas.length; j++) {
                    if (n<=kapasitas[i]+kapasitas[j]) {
                        int total = harga[i] + harga[j];
                        if (Rec ==0||total<Rec){
                            Rec = total;
                        }
                    }
                }
            }
        }
        return Rec;
    }
}
