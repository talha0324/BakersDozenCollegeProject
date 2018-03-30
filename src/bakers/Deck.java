package bakers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards;
	Deck()
	{
		//deck initialization
		cards=new ArrayList<Card>();
		char [] suits={'C','D','H','S'};
		for(int j=0;j<4;j++)
			for(int i=1;i<=13;i++)
				cards.add(new Card(suits[j],i));
	}
	public void reset()
	{
		cards=new ArrayList<Card>();
		char [] suits={'C','D','H','S'};
		for(int j=0;j<4;j++)
			for(int i=1;i<=13;i++)
				cards.add(new Card(suits[j],i));

	}
	public void Shuffle()
	{
		Collections.shuffle(cards);
	}
	public void Display()
	{
		for(int i=0;i<cards.size();i++)
			System.out.println(cards.get(i).get_suit()+" "+cards.get(i).get_rank());
	}
}
