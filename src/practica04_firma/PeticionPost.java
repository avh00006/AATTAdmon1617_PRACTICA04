/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04_firma;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author ANGEL
 */
public class PeticionPost {
  private URL url;
String data;

public PeticionPost (String url) throws MalformedURLException{
this.url = new URL(url);
data="";
}

       /**
 * Metodo para codificar el usuario y la clave a enviar.
 * @param propiedad 
 * @param valor
 * @throws UnsupportedEncodingException
 */
public void add (String propiedad, String valor) throws UnsupportedEncodingException{
//codificamos cada uno de los valores
if (data.length()>0)
data+= "&"+ URLEncoder.encode(propiedad, "UTF-8")+ "=" +URLEncoder.encode(valor, "UTF-8");
else
data+= URLEncoder.encode(propiedad, "UTF-8")+ "=" +URLEncoder.encode(valor, "UTF-8");
}

    /**
 * Metodo para establecer la conexion y devolver la respuesta del servidor.
 * @return String respuesta
 * @throws IOException
 */

public String getRespueta() throws IOException {
String respuesta = "";
//abrimos la conexiÃ³n
URLConnection conn = url.openConnection();
//especificamos que vamos a escribir
conn.setDoOutput(true);
      try (OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
          wr.write(data);
      }

  //obtenemos el flujo de lectura
  BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
     String linea;
     //procesamos la salida
     while ((linea = rd.readLine()) != null) {
        respuesta+= linea;
     }
     
            String cadenaDondeBuscar = respuesta;
            String loQueQuieroBuscar = "Usuario autenticado correctamente!";
            String[] palabras = loQueQuieroBuscar.split("\\s+");
            for (String palabra : palabras) {
            if (cadenaDondeBuscar.contains(palabra)) {
            respuesta = ("OK");
            
            }else{
             respuesta= ("ERROR");
          }
}
          
return respuesta;
}

}
