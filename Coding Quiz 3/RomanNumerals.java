import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        int bil;
        

        Scanner input = new Scanner(System.in);

        bil = input.nextInt();

        String[] romawi = {"MMM","MM","M","CM","DCCC","DCC","DC","D","CD","CCC","CC","C","XC","LXXX","LXX","LX","L","XL","XXX","XX","X","IX","VIII","VII","VI","V","IV","III","II","I"};

        int[] numerals ={3000,2000,1000,900,800,700,600,500,400,300,200,100,90,80,70,60,50,40,30,20,10,9,8,7,6,5,4,3,2,1};
    
        if (bil>=1&&bil<=3999) {
            for (int i = 0; i < numerals.length; i++) {
                while (bil>=numerals[i]) {
                    System.out.print(romawi[i]);
                    bil %= numerals[i];
                }
            }
        }    
    }

}
