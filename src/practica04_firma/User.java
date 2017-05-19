package practica04_firma;


import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Procesa la cadena del nombre DNIe USUARIOC=ES, SERIALNUMBER=26038239P,
 * SURNAME=CUEVAS, GIVENNAME=JUAN CARLOS, CN="CUEVAS MARTINEZ, JUAN CARLOS
 * (FIRMA)"
 *
 * @author Juan Carlos
 */
public class User {

    public static final String NAME="GIVENNAME=";
    public static final String DNI="SERIALNUMBER=";
    public static final String CN="CN=\"=";
    String name = "";
    String apellidos = "";
    String dni = "";

    public User(){};
    
    public User(String data) {

        name = data.substring(data.indexOf(NAME) + NAME.length());
        name = name.substring(0, name.indexOf(","));
        dni = data.substring(data.indexOf(DNI) + DNI.length());
        dni = dni.substring(0, dni.indexOf(","));
        apellidos = data.substring(data.indexOf(CN) + CN.length());
        apellidos = apellidos.substring(0, apellidos.indexOf(","));
    }
    

    public String getName() {
        return name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }
    
    /**
     * Método con marca temporal para generar los datos a firmar.
     * @param url detipo String.
     * @return 
     */
    public String[] firmando(String url){
        
        Date date = new Date();
        String[] datos = new String[2];
        
        datos[0] = "&url="+ url + "&fecha="+date.toString() + "name="+name +"&apellidos="+ apellidos+ "&dni="+dni+ "&fecha="+date.toString() ;
        //Datos a firmar
        datos[1] = url+date.toString()+name+apellidos+dni;
        
        return datos;
    }

}
