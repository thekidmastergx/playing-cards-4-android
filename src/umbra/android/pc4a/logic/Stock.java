package umbra.android.pc4a.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Stock {
	public ArrayList<Card> cStockStorage = new ArrayList<Card>();
	
	public static void Swap(ArrayList<Card> transfer,Stock giver,Stock taker){
		giver.cStockStorage.removeAll(transfer);
		taker.cStockStorage.addAll(transfer);
	}
	
	public static void Swap(Card transfer,Stock giver,Stock taker){
		giver.cStockStorage.remove(transfer);
		taker.cStockStorage.add(transfer);
	}
	
	public void Shuffle(){
		long seed = System.nanoTime();
		Collections.shuffle(cStockStorage,new Random(seed));
	}
	
	public String[] readStock(){
		String[] hand = new String[cStockStorage.size()];
		int i = 0;
		for(Card display:cStockStorage){
			hand[i]=display.readCard();
			i++;
		}
		return hand;
	}
	
	public static Stock[] splitStack(Stock sDeck,int cardCount){
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
		Stock[] array = {swapOne,swapTwo};
		return array;
	}
	
	public static Stock[] splitEvenly(Stock sDeck, int amountOfStocks){
		Stock[] finalArray = new Stock[amountOfStocks];
		Stock[] holderArray;
		Stock currentSplit = sDeck;
		for(int i = amountOfStocks; i > 0; i--){
			holderArray=Stock.splitStack(currentSplit, currentSplit.getSize()/i);
			finalArray[i-1] = holderArray[0];
			currentSplit = holderArray[1];
		}
		return finalArray;
	}
	
	public int getSize(){
		return this.cStockStorage.size();
	}
	
}
