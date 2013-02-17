package umbra.android.pc4a.logic;

public class StockDeck extends Stock{
	
	public StockDeck(){
		for(CardSuit cardSuit:CardSuit.values()){
			for(CardNumber cardNumber: CardNumber.values()){
				cStockStorage.add(new Card(cardSuit,cardNumber));
			}
		}
		this.Shuffle();
		
	}

}
