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


public class TelaLampadas extends Activity {
	public Button btmenu;
	public CheckBox chsala,chcorredor,chgaragem,chcozinha,chlavanderia,chluz,chquarto1,chquarto2,chquarto3;
    public ClienteHttpGet clienteON;
    public ClienteHttpGet clienteOFF;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lampadas);
             
        CheckBox repeatsala = ( CheckBox ) findViewById( R.id.chsala );
        repeatsala.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View sala) {
        		if (((CheckBox) sala).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHSAON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHSAOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });

        CheckBox corredor = ( CheckBox ) findViewById( R.id.chcorredor );
        corredor.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View corredor) {
        		if (((CheckBox) corredor).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHCOON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHCOOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox garagem = ( CheckBox ) findViewById( R.id.chgaragem );
        garagem.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View garagem) {
        		if (((CheckBox) garagem).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHGAON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHGAOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox cozinha = ( CheckBox ) findViewById( R.id.chcozinha );
        cozinha.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View cozinha) {
        		if (((CheckBox) cozinha).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHCOZON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHCOZOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox lavanderia = ( CheckBox ) findViewById( R.id.chlavanderia );
        lavanderia.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View lavanderia) {
        		if (((CheckBox) lavanderia).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHLAON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHLAOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox luz = ( CheckBox ) findViewById( R.id.chluz );
        luz.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View luz) {
        		if (((CheckBox) luz).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHLUON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHLUOFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox quarto1 = ( CheckBox ) findViewById( R.id.chquarto1 );
        quarto1.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View quarto1) {
        		if (((CheckBox) quarto1).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHQU1ON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHQU1OFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox quarto2 = ( CheckBox ) findViewById( R.id.chquarto2 );
        quarto2.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View quarto2) {
        		if (((CheckBox) quarto2).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHQU2ON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHQU2OFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        CheckBox quarto3 = ( CheckBox ) findViewById( R.id.chquarto3 );
        quarto3.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View quarto3) {
        		if (((CheckBox) quarto3).isChecked()) {
				// TODO Auto-generated method stub
        			Toast.makeText(getApplicationContext(), "Salgado Gordinho", Toast.LENGTH_SHORT).show();
        			clienteON = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHQU3ON");
        		}else{
        			Toast.makeText(getApplicationContext(), "To Com Fome", Toast.LENGTH_SHORT).show();
        			clienteOFF = new ClienteHttpGet("http://192.168.1.15:8090/?CMD=CHQU3OFF"); //IP do arduino, requisição http para executar o comando
                	}
                	}
            });
        btmenu = (Button)
        		findViewById(R.id.btmenuprin);
           
        btmenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent lampadamenu = new
				Intent(TelaLampadas.this,TelaInicial.class);
				onPause();
				onStop();
				startActivity(lampadamenu);
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
