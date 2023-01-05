package com.example.tcc;


import java.net.*;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClienteHttpGet implements Runnable {
    //usa pra executar
    String url="";
    /*
     * Próprio contrutor já requisita a url e inicia a Thread;
     */
    public ClienteHttpGet(String urlParam) {
        super();
        url=urlParam;
        System.out.println("url="+url);
        Thread t = new Thread(this);
        t.start();
    }
    
    //faz nada
    public void fim() {
     
    }
    
    /*
     * Método RUN da Thread;
     * */
    public void run() {
            //criando objeto Cliente
            HttpClient cliente = new DefaultHttpClient();
            //criando objeto requisicao GET
            HttpGet requiscao = new HttpGet();
            try {
                //Setando a url a ser executada
                requiscao.setURI(new URI(url));
                //Executando no objeto Cliente, detalhe este método retorna um HttpResponse mas não uso.
                cliente.execute(requiscao);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}