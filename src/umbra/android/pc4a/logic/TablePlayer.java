package umbra.android.pc4a.logic;

public class TablePlayer extends Table{
	
	public void drawStock(int amount,String deck, String hand){
		Card drawnCard;
		for(int i = 0;i<amount;i++){
			if(!(this.getStock(deck).cStockStorage.isEmpty())){
				drawnCard = this.getStock(deck).cStockStorage.get(0);
				Stock.Swap(drawnCard, this.getStock(deck), this.getStock(hand));
			}
		}
	}
	

	
}
