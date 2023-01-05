#include <Client.h>
#include <Ethernet.h>
#include <Server.h>
#include <Udp.h>
#include <SPI.h>

// Pino onde o Termistor esta conectado
#define PINOTERMISTOR A0
// Valor do termistor na temperatura nominal
#define TERMISTORNOMINAL 10000      
// Temp. nominal descrita no Manual
#define TEMPERATURENOMINAL 25
// Número de amostragens para 
#define NUMAMOSTRAS 5
// Beta do nosso Termistor
#define BCOEFFICIENT 3977
// valor do resistor em série
#define SERIESRESISTOR 10000
#define RELEAQUECEDOR 51 //LIGAR RESISTENCIA

int chsala = 20;
int chcozinha = 21;
int chquarto1 = 22;
int chquarto2 = 23;
int chquarto3 = 24;
int chcorredor = 25;
int chgaragem = 26;
int chluz = 27;
int chbanheiro = 28;
int chlavanderia = 29;
int ventilador1 = 9;
int portaotrava = 30;
int valorventilador = 255;
int valortemp = 0;
//parametros web_ethernet
byte mac[] = { 
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
byte ip[] = { 
  192, 168, 1, 15 }; // definição do ip do arduino
EthernetServer server(8090); // porta do roteador
EthernetClient client;
int conta_caracter=0 ;
int max_linha = 80 ;
String linha_de_entrada = String(max_linha) ;
int corigeIniTxt=0;
int amostra[NUMAMOSTRAS];
int i; 

void setup() {
  Ethernet.begin(mac, ip); // inicia ethernet shield  
  Serial.begin(9600);
  SPI.begin();
  pinMode(chsala, OUTPUT);
  pinMode(chcozinha, OUTPUT);
  pinMode(chquarto1, OUTPUT);
  pinMode(chquarto2, OUTPUT);
  pinMode(chquarto3, OUTPUT);
  pinMode(chcorredor, OUTPUT);
  pinMode(chgaragem, OUTPUT);
  pinMode(chluz, OUTPUT);
  pinMode(chbanheiro, OUTPUT);
  pinMode(chlavanderia, OUTPUT);
  pinMode(ventilador1, OUTPUT);
  pinMode(portaotrava, OUTPUT);
  pinMode(RELEAQUECEDOR, OUTPUT);
  digitalWrite(RELEAQUECEDOR, LOW);
  digitalWrite(chsala, LOW);
  digitalWrite(chcozinha, LOW);
  digitalWrite(chquarto1, LOW);
  digitalWrite(chquarto2, LOW);
  digitalWrite(chquarto3, LOW);
  digitalWrite(chcorredor, LOW);
  digitalWrite(chgaragem, LOW);
  digitalWrite(chluz, LOW);
  digitalWrite(chbanheiro, LOW);
  digitalWrite(chlavanderia, LOW);
  digitalWrite(portaotrava, LOW);
  analogWrite(ventilador1, LOW);
  analogReference(EXTERNAL);
}


void loop()
{
  client = server.available();
  if (client) {
    // an http request ends with a blank line
    boolean current_line_is_blank = true;
    conta_caracter=0 ;
    linha_de_entrada="" ;

    while (client.connected()) {
      if (client.available()) {
        // recebe um caracter enviado pelo browser
        char c = client.read();
        // se a linha não chegou ao máximo do armazenamento
        // então adiciona a linha de entrada
        if(linha_de_entrada.length() < max_linha) {
          linha_de_entrada.concat(c) ;
        }
        if (c == '\n' && current_line_is_blank) {
          // envia uma resposta padrão ao header http recebido
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println();
          // começa a enviar o formulário
          client.print("<html>") ;
          client.print("<body>");
          break;
        }

        if (c == '\n') {
          Serial.print(linha_de_entrada.length()) ;
          Serial.print("->") ;
          Serial.print(linha_de_entrada) ;
          if(linha_de_entrada.indexOf("GET") != -1 ){
            if(linha_de_entrada.indexOf("CMD=CHSAON") != -1 ){
              digitalWrite(chsala, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHSAOFF") != -1 ){
              digitalWrite(chsala, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHCOON") != -1 ){
              digitalWrite(chcorredor, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHCOOFF") != -1 ){
              digitalWrite(chcorredor, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHGAON") != -1 ){
              digitalWrite(chgaragem, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHGAOFF") != -1 ){
              digitalWrite(chgaragem, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHCOZON") != -1 ){
              digitalWrite(chcozinha, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHCOZOFF") != -1 ){
              digitalWrite(chcozinha, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHLAON") != -1 ){
              digitalWrite(chlavanderia, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHLAOFF") != -1 ){
              digitalWrite(chlavanderia, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHLUON") != -1 ){
              digitalWrite(chluz, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHLUOFF") != -1 ){
              digitalWrite(chluz, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHQU1ON") != -1 ){
              digitalWrite(chquarto1, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHQU1OFF") != -1 ){
              digitalWrite(chquarto1, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHQU2ON") != -1 ){
              digitalWrite(chquarto2, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHQU2OFF") != -1 ){
              digitalWrite(chquarto2, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHQU3ON") != -1 ){
              digitalWrite(chquarto3, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHQU3OFF") != -1 ){
              digitalWrite(chquarto3, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=CHBAON") != -1 ){
              digitalWrite(chbanheiro, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=CHBAOFF") != -1 ){
              digitalWrite(chbanheiro, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=PORTAOON") != -1 ){
              digitalWrite(portaotrava, HIGH);
            }
            if(linha_de_entrada.indexOf("CMD=PORTAOOFF") != -1 ){
              digitalWrite(portaotrava, LOW);
            }
            if(linha_de_entrada.indexOf("CMD=VENT0") != -1 ){
              valorventilador = 255;
            }
            if(linha_de_entrada.indexOf("CMD=VENT10") != -1 ){
              valorventilador = 229;
            }
            if(linha_de_entrada.indexOf("CMD=VENT20") != -1 ){
              valorventilador = 204;
            }
            if(linha_de_entrada.indexOf("CMD=VENT30") != -1 ){
              valorventilador = 178;
            }
            if(linha_de_entrada.indexOf("CMD=VENT40") != -1 ){
              valorventilador = 153;
            }
            if(linha_de_entrada.indexOf("CMD=VENT50") != -1 ){
              valorventilador = 128;
            }
            if(linha_de_entrada.indexOf("CMD=VENT60") != -1 ){
              valorventilador = 102;
            }
            if(linha_de_entrada.indexOf("CMD=VENT70") != -1 ){
              valorventilador = 77;
            }
            if(linha_de_entrada.indexOf("CMD=VENT80") != -1 ){
              valorventilador = 51;
            }
            if(linha_de_entrada.indexOf("CMD=VENT90") != -1 ){
              valorventilador = 26;
            }
            if(linha_de_entrada.indexOf("CMD=VENT100") != -1 ){
              valorventilador = 0;
            }
            if(linha_de_entrada.indexOf("CMD=NBP0") != -1 ){
              valortemp = 0;
            }
            if(linha_de_entrada.indexOf("CMD=NBP17") != -1 ){
              valortemp = 17;
            }
            if(linha_de_entrada.indexOf("CMD=NBP18") != -1 ){
              valortemp = 18;
            }
            if(linha_de_entrada.indexOf("CMD=NBP19") != -1 ){
              valortemp = 19;
            }
            if(linha_de_entrada.indexOf("CMD=NBP20") != -1 ){
              valortemp = 20;
            }
            if(linha_de_entrada.indexOf("CMD=NBP21") != -1 ){
              valortemp = 21;
            }
            if(linha_de_entrada.indexOf("CMD=NBP22") != -1 ){
              valortemp = 22;
            }
            if(linha_de_entrada.indexOf("CMD=NBP23") != -1 ){
              valortemp = 23;
            }
            if(linha_de_entrada.indexOf("CMD=NBP24") != -1 ){
              valortemp = 24;
            }
            if(linha_de_entrada.indexOf("CMD=NBP25") != -1 ){
              valortemp = 25;
            }
            if(linha_de_entrada.indexOf("CMD=NBP26") != -1 ){
              valortemp = 26;
            }
            if(linha_de_entrada.indexOf("CMD=NBP27") != -1 ){
              valortemp = 27;
            }
            if(linha_de_entrada.indexOf("CMD=NBP28") != -1 ){
              valortemp = 28;
            }
            if(linha_de_entrada.indexOf("CMD=NBP29") != -1 ){
              valortemp = 29;
            }
            if(linha_de_entrada.indexOf("CMD=NBP30") != -1 ){
              valortemp = 30;
            }
            if(linha_de_entrada.indexOf("CMD=NBP31") != -1 ){
              valortemp = 31;
            }
            if(linha_de_entrada.indexOf("CMD=NBP32") != -1 ){
              valortemp = 32;
            }
            if(linha_de_entrada.indexOf("CMD=NBP33") != -1 ){
              valortemp = 33;
            }
            if(linha_de_entrada.indexOf("CMD=NBP34") != -1 ){
              valortemp = 34;
            }
            if(linha_de_entrada.indexOf("CMD=NBP35") != -1 ){
              valortemp = 35;
            }
            if(linha_de_entrada.indexOf("CMD=NBP36") != -1 ){
              valortemp = 36;
            }
            if(linha_de_entrada.indexOf("CMD=NBP37") != -1 ){
              valortemp = 37;
            }
            if(linha_de_entrada.indexOf("CMD=NBP38") != -1 ){
              valortemp = 38;
            }
          }

          analogWrite(ventilador1, valorventilador); // Liga Ventilador
          //MEDIÇÃO DE TEMPERATURA
          float media;
          for (i=0; i< NUMAMOSTRAS; i++) {
            amostra[i] = analogRead(PINOTERMISTOR);
            delay(10);
          }

          media = 0;
          for (i=0; i< NUMAMOSTRAS; i++) {
            media += amostra[i];
          }
          media /= NUMAMOSTRAS;
          // Converte o valor da tensão em resistência
          media = 1023 / media - 1;
          media = SERIESRESISTOR / media;

          //Faz o cálculo pela fórmula do Fator Beta
          float temperatura;
          temperatura = media / TERMISTORNOMINAL;     // (R/Ro)
          temperatura = log(temperatura); // ln(R/Ro)
          temperatura /= BCOEFFICIENT;                   // 1/B * ln(R/Ro)
          temperatura += 1.0 / (TEMPERATURENOMINAL + 273.15); // + (1/To)
          temperatura = 1.0 / temperatura;                 // Inverte o valor
          temperatura -= 273.15;                         // Converte para Celsius
          Serial.print("Temperatura no Sensor é: "); 
          Serial.print(temperatura);
          Serial.println(" *C");
          if((temperatura-2) <= valortemp ){
            digitalWrite(RELEAQUECEDOR, HIGH);
          }
          else {
            if((temperatura+2)>= valortemp ){
              digitalWrite(RELEAQUECEDOR, LOW);
            }
          }
          current_line_is_blank = true;
          linha_de_entrada="" ;
        } 
        else if (c != '\r') {
          // recebemos um carater que não é linefeed ou retorno de carro
          // então recebemos um caracter e a linha de entrada não está mais vazia
          current_line_is_blank = false;
        }
      }
    }
    // dá um tempo para o browser receber os caracteres
    delay(1);
    client.stop();
  }// fim parametros web client
}



