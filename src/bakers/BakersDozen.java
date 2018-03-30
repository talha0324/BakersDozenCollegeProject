package bakers;
import java.util.ArrayList;

public class BakersDozen {
	Deck D=new Deck();
	ArrayList<ArrayList<Card>> tableau;//13 cells in total
	ArrayList<ArrayList<Card>> homeCell;// 4 cells in total.  1=club,	2=diamonds,	3=heart,	4=spade
	public BakersDozen()
	{
		//initialize game
		D.Shuffle();
		tableau=new ArrayList<ArrayList<Card>>(13);
		homeCell=new ArrayList<ArrayList<Card>>(4);
		System.out.println("deck size="+D.cards.size());
		for(int i=0;i<13;i++)
		{
			tableau.add(new ArrayList<Card>());
			for(int j=0;j<4;j++)
			{
				tableau.get(i).add(D.cards.get(D.cards.size()-1));
				D.cards.remove(D.cards.size()-1);
			}
			int x=0;
			for(int j=0;j<4;j++)
			{
				if(tableau.get(i).get(j).rank==13)
				{
					Card temp=new Card(tableau.get(i).get(j));
					tableau.get(i).set(j, new Card(tableau.get(i).get(x)));
					tableau.get(i).set(x, new Card(temp));
					x++;
				}
			}
		}
		for(int i=0;i<4;i++)
			homeCell.add(new ArrayList<Card>());
		System.out.println("deck size="+D.cards.size());
		
	}
	public boolean PerformMove(int PickFromTableauPile,int PlaceOnTableauPile)
	{
		PickFromTableauPile--;
		PlaceOnTableauPile--;
		if(!(PickFromTableauPile>=0 && PickFromTableauPile<13 && PlaceOnTableauPile>=0 && PlaceOnTableauPile<13))
			return false;
		if(tableau.get(PickFromTableauPile).size()==0)
			return false;
		if(tableau.get(PlaceOnTableauPile).size()==0)
			return false;
		Card temp=new Card(tableau.get(PickFromTableauPile).get(tableau.get(PickFromTableauPile).size()-1));
		Card temp2=new Card(tableau.get(PlaceOnTableauPile).get(tableau.get(PlaceOnTableauPile).size()-1));
		System.out.println("Picking from "+PickFromTableauPile+" Card "+temp.suit+" "+temp.rank);
		System.out.println("Placing on "+PlaceOnTableauPile+" Card "+temp2.suit+" "+temp2.rank);
		
		if((temp.rank)==(temp2.rank-1))
		{
			tableau.get(PlaceOnTableauPile).add(tableau.get(PickFromTableauPile).get(tableau.get(PickFromTableauPile).size()-1));
			tableau.get(PickFromTableauPile).remove(tableau.get(PickFromTableauPile).size()-1);
			System.out.println("Success");
			return true;
		}
		else
		{
			System.out.println("Fail");
			return false;
		}
	}
	public boolean MoveToHomeCell(int PickFromTableauPile)
	{
		if(!(PickFromTableauPile>=0 && PickFromTableauPile<13))
			return false;
		if(tableau.get(PickFromTableauPile).size()==0)
			return false;
		Card temp=new Card(tableau.get(PickFromTableauPile).get(tableau.get(PickFromTableauPile).size()-1));
		int x=getHomeCellNo(temp.suit);
		if(homeCell.get(x).size()==0)
		{
			if(temp.rank==1){
				homeCell.get(x).add(new Card(temp));
				return true;}
			return false;
		}
		else
		{
			Card temp2=homeCell.get(x).get(homeCell.get(x).size()-1);
			if(temp2.rank==(temp.rank-1))
			{
				homeCell.get(x).add(new Card(temp));
				return true;
			}
			return false;
		}
	}
	public int getHomeCellNo(char c)
	{
		//1=club,	2=diamonds,	3=heart,	4=spade
		if(c=='C')
			return 0;
		else if(c=='D')
			return 1;
		else if(c=='H')
			return 2;
		else if(c=='S')
			return 3;
		else
			return -1;
	}
	public int getMaxLengthOfATableauCell()
	{
		int c=0;
		for(int i=0;i<tableau.size();i++)
			if(tableau.get(i).size()>c)
				c=tableau.get(i).size();
		return c;
	}
	public int getMaxLengthOfAHomeCell()
	{
		int c=0;
		for(int i=0;i<homeCell.size();i++)
			if(homeCell.get(i).size()>c)
				c= homeCell.get(i).size();
		return c;
	}
	public Card getTopCard(int i)
	{
		return tableau.get(i).get(tableau.get(i).size()-1);
	}
	public boolean PlaceCard(int PlaceOnCell,Card c)
	{
		if(tableau.get(PlaceOnCell).get(tableau.get(PlaceOnCell).size()-1).rank==(c.rank+1)){
			tableau.get(PlaceOnCell).add(new Card(c));
			return true;
		}
		return false;
	}
	public boolean PlaceCardHome(Card c)
	{
		int x=getHomeCellNo(c.suit);
		if(homeCell.get(x).size()==0)
		{
			if(c.rank==1){
				homeCell.get(x).add(new Card(c));
				return true;}
			return false;
		}
		else
		{
			Card temp2=homeCell.get(x).get(homeCell.get(x).size()-1);
			if(temp2.rank==(c.rank-1))
			{
				homeCell.get(x).add(new Card(c));
				return true;
			}
			return false;
		}
	}
	public boolean PickCard(int i)
	{
		if(tableau.get(i).size()>0){
			tableau.get(i).remove(tableau.get(i).size()-1);
			return true;
		}
		return false;
	}
	public boolean PickCardHome(int i)
	{
		return false;
	}
	public int getCellLength(int i)
	{
		return tableau.get(i).size();
	}
	public int getHomeLength(char s)
	{
		int x=getHomeCellNo(s);
		return homeCell.get(x).size();
	}
	public void DisplayTableau()
	{
		System.out.println("Tableau\n===============================================================================================");
		for(int i=0;i<13;i++)
		{
			System.out.print((i+1)+"->\t");
			for(int j=0;j<tableau.get(i).size();j++)
			{
				System.out.print("{"+tableau.get(i).get(j).suit+","+tableau.get(i).get(j).rank+"}\t");
			}
			System.out.println();
		}
		System.out.println("===============================================================================================");
	}
	public void DisplayHomeCell()
	{
		System.out.println("HOME CELL\n=====================================================================");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<homeCell.get(i).size();j++)
			{
				System.out.print("{"+homeCell.get(i).get(j).suit+","+homeCell.get(i).get(j).rank+"}\t");
			}
			System.out.println();
		}
		System.out.println("===============================================================================================");
	}
}
