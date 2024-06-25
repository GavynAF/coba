import java.util.Scanner;

public class destinasiWisata {
    public static void main(String[] args) {
        int person=0, day=0, budget=0;

        Scanner input = new Scanner(System.in);
        person = input.nextInt();
        day = input.nextInt();
        budget = input.nextInt();

        budgettravel(person, budget, day);


    }

    public static void budgettravel(int person, int budget, int day) {
        int lombok, bangkok, singapura, tokyo, total;
        String destinasi= "Need more budget";
        boolean status = true;
        total = 0;
        //tokyo>bangkok>lombok>singapura
        lombok = (person*2170000)+((person*125000)*day)+((person*75000)*day)+(person*250000);
        bangkok = (person*3780000)+((person*155000)*day)+((person*55000)*day)+(person*300000);
        singapura = (person*1200000)+((person*170000)*day)+((person*85000)*day)+(person*360000);
        tokyo = (person*4760000)+((person*170000)*day)+((person*105000)*day)+(person*325000);
    
        if (budget>=singapura&&budget<lombok) {
            total = singapura;
            destinasi = "Singapura";
        } else if(budget>=lombok&&budget<bangkok){
            total = lombok;
            destinasi = "Lombok";
        }else if(budget>=bangkok&&budget<tokyo){
            total = bangkok;
            destinasi = "Bangkok";
        }else if(budget>=tokyo){
            total = tokyo;
            destinasi = "Tokyo";
        }else{
            status = false;
        }
        
        if(status){
            System.out.print(destinasi);
            System.out.println(" "+total);
        }else{
            System.out.println(destinasi);
        }
        
    }
}
