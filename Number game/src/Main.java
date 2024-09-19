import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        for(int i=0;i>=0;i++){
            System.out.println("I am thinking a word between 1 to 10! guess it!");
            Random r1=new Random();
            int a=r1.nextInt(10);
           // System.out.println(a);
            int aux=0;
            for(int k=0;k<3;k++) {
                System.out.println("Enter the guss ? ");
                Scanner sc = new Scanner(System.in);
                int l = sc.nextInt();
                if(l==a) {
                    System.out.println("Yah right guess");
                    aux=1;
                    break;
                }
                else if (l>a) {
                    System.out.println("No it is less than you'r guess");

                } else if (l<a) {
                    System.out.println("No it is grater than you'r guess");

                }

            }
            if(aux==0){
                System.out.println("Time out better luck next time");
            }




        }
    }
}