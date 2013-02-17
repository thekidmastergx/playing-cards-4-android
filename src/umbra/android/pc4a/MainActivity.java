package umbra.android.pc4a;

import umbra.android.pc4a.logic.StockDeck;
import umbra.android.pc4a.logic.Table;
import umbra.android.pc4a.logic.TablePlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.Editable;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView Tv1 = (TextView) findViewById(R.id.textView1);
        final TextView Tv2 = (TextView) findViewById(R.id.textView2);
        final TextView Tv3 = (TextView) findViewById(R.id.textView3);
        final TextView Tv4 = (TextView) findViewById(R.id.textView4);
        final Button bow = (Button) findViewById(R.id.button1);
      
        final Table dealer = new Table();
        final TablePlayer one = new TablePlayer();
        final TablePlayer two = new TablePlayer();
        final TablePlayer three = new TablePlayer();
        final TablePlayer four = new TablePlayer();
        final String[] names ={"one","two","three","four"};


        
        bow.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String nameOne = "";
				String nameTwo = "";
				String nameThree = "";
				String nameFour = "";
				
		        dealer.placeStock("DECK", new StockDeck());
		        dealer.splitEvenly("DECK", 4, names);
		        
		        Table.stockTransfer("one", "HAND", dealer, one);
		        Table.stockTransfer("two", "HAND", dealer, two);
		        Table.stockTransfer("three", "HAND", dealer, three);
		        Table.stockTransfer("four", "HAND", dealer, four);
		        
		        for(String readOut:one.getStock("HAND").readStock()){
		        	nameOne += readOut+"\n";
		        }
		        for(String readOut:two.getStock("HAND").readStock()){
		        	nameTwo += readOut+"\n";
		        }
		        for(String readOut:three.getStock("HAND").readStock()){
		        	nameThree += readOut+"\n";
		        }
		        for(String readOut:four.getStock("HAND").readStock()){
		        	nameFour += readOut+"\n";
		        }
		        
		        Tv1.setText(nameOne);
		        Tv2.setText(nameTwo);
		        Tv3.setText(nameThree);
		        Tv4.setText(nameFour);
		        
		        dealer.removeStock("DECK");
		        one.removeStock("HAND");
		        two.removeStock("HAND");
		        three.removeStock("HAND");
		        four.removeStock("HAND");
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
