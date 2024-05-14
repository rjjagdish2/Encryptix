import java.util.Scanner;
import java.util.Random;

public class main{
	public static void main(String[] a){
		
		int g_num=0 , gen_num=1 , atmpt=0, n_round=1,count_round=0, max=100,min=1;
		Scanner sc = new Scanner(System.in);	
		Random rnd =new Random();
		
		do{
			gen_num=rnd.nextInt((max-min+1)+min);
			System.out.println(gen_num);
			count_round++;
			atmpt=0;		
		try{
			do{
				System.out.print("Gusse Number Between 1-100: ");			
				while(!sc.hasNextInt()){				
				System.out.println("Invalid input. Please enter an integer.");               
				sc.next();
				atmpt++;
				}
				g_num=sc.nextInt();
				atmpt++;				
			}while(g_num!=gen_num);
			System.out.println("-------------------");
			System.out.println("Successfully Gussed At : "+atmpt + " Attempt");
		}
		catch(Exception e){
			System.out.println(e);
		}		
		
		System.out.println("-----------------------------------------------------------");
		System.out.print("Enter 1 to Play Next Round \n Enter 0 to Exit: ");
		n_round=sc.nextInt();		
		}while(n_round==1);
		System.out.print("You Have Played " + count_round + " Rounds!!");
	}

}