import java.util.Scanner;

public class trial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String p = input.nextLine();
        String d = input.next();

        int[][] gajiPokok = {
            {8000000,9000000,7500000,7200000,8500000},
            {7000000,8000000,6500000,6200000,7500000},
            {7500000,8500000,7000000,6800000,8000000},
            {10000000,11000000,9500000,9200000,10500000},
            {7500000,8500000,7000000,6800000,8000000},
        };

        String[] posisi = {"Software Engineer","Data Analyst", "UX Designer", "Project Manager", "QA ENgineer"};

        String[] divisi = {"Surabaya","Jakarta","Bandung","Medan","Makassar"};
    
        int x=0,y=0;
        for (int i = 0; i < gajiPokok.length; i++) {
            if (posisi[i].equals(p)) {
                x = i;
            }
            if (divisi[i].equals(d)) {
                y = i;
            }
        }
        System.out.println(gajiPokok[x][y]);
    }
     
}
