package com.example.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tcc.ClienteHttpGet;



public class TelaVentilador extends Activity {
		
	public Button btmenu;
	public ClienteHttpGet ClienteON;
	public ClienteHttpGet ClienteOFF;
	private Switch ligaventilador1;
	private SeekBar seek = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ventilador);
        
        ligaventilador1 = (Switch) findViewById(R.id.ligaventilador1);        
        ligaventilador1.setChecked(false);

        ligaventilador1.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			public void onCheckedChanged(CompoundButton ligaventilador1,	boolean isChecked) {
	    		if (isChecked) {
	        			Toast.makeText(getApplicationContext(), "Ligou o Ventilador", Toast.LENGTH_SHORT).show();
	        			seek = (SeekBar) findViewById(R.id.VentilaBar);
	        	        seek.setEnabled(true);
	        			seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
	        				@Override
	        				public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
	        					int progressChanged = progress;
	        	    			TextView textView = (TextView)findViewById(R.id.Progress);
	        			        int progress2 = progressChanged*10; 
	        			        textView.setText(Integer.toString(progress2)+"%");
	        			        ClienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=VENT"+progress2);
	        				}

	        				@Override
	        				public void onStartTrackingTouch(SeekBar arg0) {
	        					// TODO Auto-generated method stub
	        					
	        				}

	        				@Override
	        				public void onStopTrackingTouch(SeekBar arg0) {
	        					// TODO Auto-generated method stub
	        					
	        				}
	        	        	
	        	        });
	        		}else{
	        			Toast.makeText(getApplicationContext(), "Ventilador Desligado", Toast.LENGTH_SHORT).show();
	        			ClienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=VENT0"); //IP do arduino, requisição http para executar o comando
	        	        ligaventilador1.setChecked(false);
	        	        seek.setEnabled(false);
	                	}
	                	}
	            });
        
        btmenu = (Button)
        		findViewById(R.id.btmenu1);
        
        btmenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent trocamenu2 = new
				Intent(TelaVentilador.this,TelaInicial.class);
				onPause();
				onStop();
				startActivity(trocamenu2);
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
