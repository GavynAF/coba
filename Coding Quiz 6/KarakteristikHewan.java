import java.util.Scanner;

public class KarakteristikHewan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int persentase = Integer.parseInt(input.nextLine());
        String HewanA = input.nextLine().replaceAll(" ","");
        String HewanB = input.nextLine().replaceAll(" ", "");

        if ((hitungPersentaseKesamaan(HewanA, HewanB)>=persentase)&&(persentase>=50&&persentase<=100)) {
            System.out.println("sama");
        } else {
            System.out.println("tidak sama");
        }
    }

    public static double hitungPersentaseKesamaan(String ciriHewanA, String ciriHewanB){
        char[] ciri= {'k','h','o','d','a','u','b','m'};
        char[] arrHewanA = ciriHewanA.toCharArray();
        char[] arrHewanB = ciriHewanB.toCharArray();
        int sama = 0;

        for (int i = 0; i < arrHewanA.length; i++) {
            for (int j = 0; j < arrHewanB.length; j++) {
                for (int j2 = 0; j2 < ciri.length; j2++) {
                    if (arrHewanA[i] == arrHewanB[j]&&arrHewanB[j]==ciri[j2]) {
                        sama++; 
                    }
                }
                
            }
        }
        int total = 0;
        if(arrHewanA.length>arrHewanB.length){
            total = arrHewanA.length;
        }else{
            total = arrHewanB.length;
        }
        
        return ((double) sama / total) * 100;
    }

}
