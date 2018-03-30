package bakersTest;
import static org.junit.Assert.*;

import org.junit.Test;

import bakers.BakersDozen;
import bakers.Card;

public class BakersDozenTest {

	@Test
	public void test1() {//initially holds 4 cards in each cell
		BakersDozen B=new BakersDozen();
		int c=B.getMaxLengthOfATableauCell();
		assertEquals(c, 4);
	}
	@Test
	public void test2() {//Baker's Dozen tableau pile correctly determines if adding a specific card is legal or illegal
		BakersDozen B=new BakersDozen();
		Card temp=new Card('A',3);
		Card temp2=B.getTopCard(6);
		boolean res=B.PlaceCard(6,temp);
		if((temp.get_rank()+1)==temp2.get_rank())
			assertEquals(res,true);
		else
			assertEquals(res,false);
	}
	@Test
	public void test3(){//Baker's Dozen tableau pile correctly returns if removing top card is legal or illegal 
		BakersDozen B=new BakersDozen();
		int l=B.getCellLength(3);
		boolean res=B.PickCard(3);
		if(l==0)
			assertEquals(res, false);
		else
			assertEquals(res, true);
	}
	@Test
	public void test4(){//Adding card to Baker's Dozen tableau pile increases its number of cards and results in that card being the tableau pile's new top card 
		BakersDozen B=new BakersDozen();
		int length1=B.getCellLength(5);
		Card temp=new Card(B.getTopCard(5));
		int t=temp.get_rank();
		t--;
		temp.set_rank(t);
		B.PlaceCard(5, temp);
		int length2=B.getCellLength(5);
		assertEquals(true,(length1==(length2-1)));
	}
	@Test
	public void test5(){//Removing card from Baker's Dozen tableau pile decreases its number of cards and results in following card being the new top card 
		BakersDozen B=new BakersDozen();
		int length1=B.getCellLength(4);
		B.PickCard(4);
		int length2=B.getCellLength(4);
		assertEquals(true,(length1==(length2+1)));
	}
	@Test
	public void test6(){//Homecell piles in Baker's Dozen initially hold 0 cards
		BakersDozen B=new BakersDozen();
		int c=B.getMaxLengthOfAHomeCell();
		assertEquals(c, 0);
	}

	@Test
	public void test7(){//Baker's Dozen homecell pile correctly determines if adding a specific card is legal or illegal
		BakersDozen B=new BakersDozen();
		Card temp=new Card('H',2);
		assertEquals(false,B.PlaceCardHome(temp));
		temp.set_rank(1);
		assertEquals(true,B.PlaceCardHome(temp));
	}
	@Test
	public void test8(){//Baker's Dozen homecell pile correctly returns if removing top card is legal or illegal
		BakersDozen B=new BakersDozen();
		assertEquals(false,B.PickCardHome(1));
	}
	@Test 
	public void test9(){//Adding card to Baker's Dozen homecell pile increases its number of cards and results in that card being the homecell pile's new top card 
		BakersDozen B=new BakersDozen();
		Card t=new Card('H',1);
		int length1=B.getHomeLength('H');
		B.PlaceCardHome(t);
		int length2=B.getHomeLength('H');
		assertEquals(true,(length1==(length2-1)));
	}
}
