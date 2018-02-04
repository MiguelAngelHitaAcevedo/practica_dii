package Modelo;


import java.util.Calendar;
import java.util.GregorianCalendar;
//Programa: Utilidades
/*
Autor: Adrián Urbano Gómez
       Emilio Gracía Barroso
       Miguel Ángel Hita Acebedo
 */
public class utilidades {
    //Metodos

    public static boolean esFechaCorrecta(String pFecha) {
        //Entorno
        boolean esCorrecta;
        short anio;
        byte mes;
        byte dia;
        byte diasMes;
        String[] fechaTroceada;
        //Algoritmo
        esCorrecta = true;
        //Meto cada parte de la fecha en variables separadas para trabajar más comodamente
        fechaTroceada = pFecha.split("/");
        dia = Byte.parseByte(fechaTroceada[0]);
        mes = Byte.parseByte(fechaTroceada[1]);
        anio = Short.parseShort(fechaTroceada[2]);
        //Compruebo la fecha
        if(mes <1 || mes > 12){
                esCorrecta = false;
            }else{
                if(dia <1 ){
                    esCorrecta=false;
                }else{
                    switch(mes){
                        case 2:
                            if((anio%400==0) || ((anio % 4==0) && !(anio % 100==0))){
                                diasMes=29;
                            }else{
                                diasMes=28;
                            }
                            break;
                        case 4:case 6:case 9:case 11:
                            diasMes=30;
                            break;
                        default:
                            diasMes=31;
                            break;
                    }
                    esCorrecta = dia<=diasMes;
                }
            }
        return esCorrecta;
    }

    public static boolean esSexoCorrecto(String pSexo) {
        return ((pSexo.toUpperCase().charAt(0)=='H' || pSexo.toUpperCase().charAt(0)=='H') && pSexo.length()==1);
    }

    public static boolean esNumeroEntero(String pNumero) {
        //Entorno    
        boolean esCorrecto;
        int numero;
        //Algoritmo
        esCorrecto = true;
        try {
            numero = Integer.parseInt(pNumero);
        } catch (NumberFormatException nfe) {
            esCorrecto = false;
        }
        return esCorrecto;
    }

    public static boolean esNumeroReal(String pNumero) {
        //Entorno
        boolean esCorrecto;
        float numero;
        //Algoritmo
        esCorrecto = true;
        try {
            numero = Float.parseFloat(pNumero);
        } catch (NumberFormatException nfe) {
            esCorrecto = false;
        }
        return esCorrecto;
    }
}
