package bakers;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BakersDozen B=new BakersDozen();
		while(true)
		{
			B.DisplayHomeCell();
			B.DisplayTableau();
			System.out.println("==Play a Move==");
			System.out.print("Pick from:");
			Scanner r = new Scanner(System.in);
			int n=r.nextInt();
			System.out.print("Place On:");
			int n2=r.nextInt();
			B.PerformMove(n, n2);
			B.DisplayHomeCell();
			B.DisplayTableau();
		}
	}

}
