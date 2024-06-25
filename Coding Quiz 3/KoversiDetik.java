import java.util.Scanner;

public class KoversiDetik {
    public static void main(String[] args) {
        int bil, hari = 0, jam=0, menit=0, detik=0;

        Scanner input = new Scanner(System.in);
        bil = input.nextInt();

        do {
                if (bil>=86400) {
                    bil -= 86400;
                    hari++;
                }else if(bil<86400&&bil>=3600){
                    bil -=3600;
                    jam++;
                }else if(bil<3600&&bil>=60){
                    bil -=60;
                    menit++;
                }else{
                    detik = bil;
                    bil =0;
                }
            
            } while (bil!=0);
        System.out.println(hari);
        System.out.println(jam);
        System.out.println(menit);
        System.out.println(detik);
    }  

    
}

// 1 hari 86400
// 1 jam  3600
// 1 menit 60
// 1 detik 1
