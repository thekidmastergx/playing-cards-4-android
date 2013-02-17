package umbra.android.pc4a.logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
	
	public HashMap<String,Stock> fieldCard = new HashMap<String,Stock>();
	
	public void placeStock(String name, Stock deck){
		fieldCard.put(name, deck);
	}
	
	public Stock newStock(String name){
		fieldCard.put(name, new Stock());
		return this.getStock(name);
	}
	
	public Stock getStock(String name){
		return fieldCard.get(name);
	}
	
	public void removeStock(String name){
		fieldCard.remove(name);
	}
	
	public static void stockTransfer(String oldName,String newName,Table giver, Table taker){
		Stock tst = giver.getStock(oldName);
		giver.removeStock(oldName);
		if(taker.fieldCard.containsKey(newName)){
			taker.removeStock(newName);
		}
		taker.placeStock(newName, tst);
	}
	
	public void splitStack(String name,int cardCount, String[] newNames){
		Stock sDeck = this.getStock(name);
		ArrayList<Card> one =new ArrayList<Card>();
		ArrayList<Card> two =new ArrayList<Card>();
		Stock swapOne = new Stock();
		Stock swapTwo = new Stock();
		for(Card current:sDeck.cStockStorage){
			if(cardCount > sDeck.cStockStorage.indexOf(current)){
				one.add(current);
			}else{
				two.add(current);
			}
		}
		Stock.Swap(one, sDeck, swapOne);
		Stock.Swap(two, sDeck, swapTwo);
		this.removeStock(name);
		this.placeStock(newNames[0], swapOne);
		this.placeStock(newNames[1], swapTwo);
	}
	
	public void splitEvenly(String name, int amountOfStocks, String[] newNames){
		ArrayList<ArrayList<Card>> alCardHandle = new ArrayList<ArrayList<Card>>();
		ArrayList<Card> splittingDeck =this.getStock(name).cStockStorage;
		int deckNumber;
		for(int i = 0; i < amountOfStocks;i++){
			alCardHandle.add(new ArrayList<Card>());
		}
		for(int j = 0; j< splittingDeck.size();j++){
			deckNumber = j % amountOfStocks;
			alCardHandle.get(deckNumber).add(splittingDeck.get(j));
		}
		for(int k = 0; k < amountOfStocks;k++){
			Stock.Swap(alCardHandle.get(k), this.getStock(name), this.newStock(newNames[k]));
		}
		this.removeStock(name);
	}
}
