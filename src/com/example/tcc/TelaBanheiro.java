package com.example.tcc;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.tcc.ClienteHttpGet;

public class TelaBanheiro extends Activity {
	
	public Button btmenu, btenviartemperatura;
	public Text valortemp;
    public ClienteHttpGet clienteON;
    public ClienteHttpGet clienteOFF;
    private Switch ligaaquece;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_banheiro);
        
        final NumberPicker np = (NumberPicker) findViewById (R.id.temperatura);
        np.setMinValue(17);
        np.setMaxValue(38);
        np.setValue(25);
        np.setWrapSelectorWheel(false);
        np.setEnabled(false);
    
        btmenu = (Button)
        		findViewById(R.id.btmenuprin);
        btenviartemperatura = (Button)
        		findViewById(R.id.bttemp);
        ligaaquece = (Switch) 
        		findViewById(R.id.ligaaquecedor); 
        ligaaquece.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			public void onCheckedChanged(CompoundButton ligaaquece,	boolean isChecked) {
	    		if (isChecked) {
	    			np.setEnabled(true);
        btenviartemperatura.setOnClickListener(new View.OnClickListener() {
   	    		public void onClick(View arg0) {
				final int pickedValue = np.getValue();
		        TextView textView = (TextView)findViewById(R.id.valortemp);
		        textView.setText(Integer.toString(pickedValue));
       	    	new ClienteHttpGet("http://192.168.1.15:8090/?CMD=NBP"+pickedValue);
			}
        });
	    		}else{
	    			np.setEnabled(false);
	    			btenviartemperatura.setOnClickListener(new View.OnClickListener() {
	       	    		public void onClick(View arg0) {
	       	    			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=NBP0");
	       	    			Toast.makeText(getApplicationContext(), "Ligue o Aquecedor", Toast.LENGTH_SHORT).show();
	       	    		}
	    			});
	    		}
			}
        });
        
        btmenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent trocamenu = new
				Intent(TelaBanheiro.this,TelaInicial.class);
				onPause();
				onStop();
				startActivity(trocamenu);
			}
        });
        CheckBox repeatbanh = ( CheckBox ) findViewById( R.id.chlamp );
        repeatbanh.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View portao) {
        		if (((CheckBox) portao).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Luz Acesa!", Toast.LENGTH_SHORT).show();
                	clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHBAON");
        		}else{
        			Toast.makeText(getApplicationContext(), "Luz Apagada!", Toast.LENGTH_SHORT).show();
                	clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHBAOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
      }
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
