import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        int[] array = new int[T];
        for(int i =0; i< T; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            
            array[i] = a+b;
        }
        
        for(int i : array){
            System.out.println(i);
        }
    }
}