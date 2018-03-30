package bakers;

public class Card {
	char suit;
	int rank;
	Card()
	{
		suit='\0';
		rank=-1;
	}
	public Card(char suit,int rank)
	{
		this.suit=suit;
		this.rank=rank;
	}
	public Card(Card c)
	{
		this.suit=c.suit;
		this.rank=c.rank;
	}
	public char get_suit(){ return suit;	}
	public int get_rank(){	return rank;	}
	public void set_suit(char suit){	this.suit=suit;	}
	public void set_rank(int rank){	this.rank=rank;	}

}
