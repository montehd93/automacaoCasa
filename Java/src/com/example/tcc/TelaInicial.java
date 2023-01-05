package com.example.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.example.tcc.ClienteHttpGet;


public class TelaInicial extends Activity {
	
	public Button btlampadas, btbanheiro, btventilador, btteste;
	public CheckBox portao;
    public ClienteHttpGet clienteON;
    public ClienteHttpGet clienteOFF;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        btlampadas = (Button)
        		findViewById(R.id.btlampadas);
        btbanheiro = (Button)
        		findViewById(R.id.btbanheiro);
        btventilador = (Button)
        		findViewById(R.id.btventilador);

        
        CheckBox repeatsala = ( CheckBox ) findViewById( R.id.portao );
        repeatsala.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View portao) {
        		if (((CheckBox) portao).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Portão Travado!", Toast.LENGTH_SHORT).show();
                	clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=PORTAOON");
        		}else{
        			Toast.makeText(getApplicationContext(), "Portão Destravado!", Toast.LENGTH_SHORT).show();
                	clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=PORTAOOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        btbanheiro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent TrocaBanheiro = new
				Intent(TelaInicial.this,TelaBanheiro.class);
				onPause();
				onStop();
				startActivity(TrocaBanheiro);
			}
		});
        btlampadas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent TrocaLampada = new
					Intent(TelaInicial.this,TelaLampadas.class);
					onPause();
					onStop();
					startActivity(TrocaLampada);}
		});
        btventilador.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent TrocaVentilador = new
				Intent(TelaInicial.this,TelaVentilador.class);
				onPause();
				onStop();
				startActivity(TrocaVentilador);			}
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
