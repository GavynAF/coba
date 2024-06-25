import java.util.Scanner;

public class berlubang {
    public static void main(String[] args) {
        char[] teks;
        int jumlah = 0;

        Scanner input = new Scanner(System.in);
        teks = input.next().toCharArray();

        
        for(int i = 0; i< teks.length; i++){
            int lubang=0;
            switch (teks[i]) {
                //1 lubang = AabdDegoOpPqQR4690
                case 'A':
                case 'a':
                case 'b':
                case 'd':
                case 'D':
                case 'e':
                case 'g':
                case 'o':
                case 'O':
                case 'p':
                case 'P':
                case 'q':
                case 'Q':
                case 'R':
                case '4':
                case '6':
                case '9':
                case '0':
                    lubang = 1;
                    break;
                //2 lubang = B8
                case 'B':
                case '8':
                    lubang = 2;
                    break;
                //tidak ada lubang = cCEfFGhHiIjJkKLlmMnNrSsTtUuvVWwxXyYZZ12357
                default:
                    lubang = 0;
                    break;
            }
            jumlah = jumlah+lubang;
            
        }
        System.out.print(jumlah);
        
    }
}




