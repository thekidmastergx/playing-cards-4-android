package umbra.android.pc4a.logic;

public class Card {
	public final CardSuit cardSuit;
	public final CardNumber cardNumber;
	public boolean bFacedUp = true;

	public Card(CardSuit cardSuit,CardNumber cardNumber){
		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
	}

	public String readCard() {
		if(this.bFacedUp){
			return cardNumber+"of"+cardSuit;
		}else{
			return null;
		}
	}
	
	public void flipCard(){
		bFacedUp = !(bFacedUp);
	}
}
