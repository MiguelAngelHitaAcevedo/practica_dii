package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
//Autores:  Adrián Hurbano Gomez
//          Miguel Ángel Hita Acevedo
//          Emilio García Barroso

public class TrabajaFicheroDat{
    //Atributos
    private static File fichero;
    private static byte tablaActual;
    //Métodos:
    
    public static boolean guardarRegistros(LinkedList<String[]> pListaRegistros,File fich) {
        //Entorno
        // el LinkedList no es de objetos, son un linkedlist con el objeto ya desglosado, osea todos los campos String con sus datos
        int i;
        DataOutputStream bw = null;
        FileOutputStream fw;
        boolean esCorrecto;
        //Algoritmo
        esCorrecto = true;
        try {
            if (compruebaFichero(fich)) {
                fw = new FileOutputStream(fichero);
                bw = new DataOutputStream(fw);
                switch (tablaActual) {
                    case 1:
                        for (i = 0; i < pListaRegistros.size(); i++) {
                            bw.writeInt(Integer.parseInt(pListaRegistros.get(i)[0]));
                            bw.writeUTF(pListaRegistros.get(i)[1]);
                            bw.writeUTF(pListaRegistros.get(i)[2]);
                            bw.writeUTF(pListaRegistros.get(i)[3]);
                            bw.writeUTF(pListaRegistros.get(i)[4]);
                            bw.writeUTF(pListaRegistros.get(i)[5]);
                        }//Fin Para
                        break;
                    case 2:
                        for (i = 0; i < pListaRegistros.size(); i++) {
                            bw.writeUTF(pListaRegistros.get(i)[0]);
                            bw.writeUTF(pListaRegistros.get(i)[1]);
                        }//Fin Para
                        break;
                    case 3:
                        for (i = 0; i < pListaRegistros.size(); i++) {
                            bw.writeInt(Integer.parseInt(pListaRegistros.get(i)[0]));
                            bw.writeUTF(pListaRegistros.get(i)[1]);
                            bw.writeFloat(Float.parseFloat(pListaRegistros.get(i)[2]));
                            bw.writeUTF(pListaRegistros.get(i)[3]);
                        }//Fin Para
                        break;
                    case 4:
                        for (i = 0; i < pListaRegistros.size(); i++) {
                            bw.writeInt(Integer.parseInt(pListaRegistros.get(i)[0]));
                            bw.writeUTF(pListaRegistros.get(i)[1]);
                            bw.writeUTF(pListaRegistros.get(i)[2]);
                            bw.writeUTF(pListaRegistros.get(i)[3]);
                        }//Fin Para
                        break;
                    case 5:
                        for (i = 0; i < pListaRegistros.size(); i++) {
                            bw.writeUTF(pListaRegistros.get(i)[0]);
                            bw.writeInt(Integer.parseInt(pListaRegistros.get(i)[1]));
                            bw.writeUTF(pListaRegistros.get(i)[2]);
                            bw.writeUTF(pListaRegistros.get(i)[3]);
                        }//Fin Para
                        break;
                    case 6:
                        for (i = 0; i < pListaRegistros.size(); i++) {
                            bw.writeUTF(pListaRegistros.get(i)[0]);
                            bw.writeInt(Integer.parseInt(pListaRegistros.get(i)[1]));
                            bw.writeUTF(pListaRegistros.get(i)[2]);
                            bw.writeUTF(pListaRegistros.get(i)[3]);
                        }//Fin Para
                        break;
                }
                bw.close();
            }else{
                esCorrecto = false;
            }
        } catch (Exception ex) {
            System.out.println("Error Guardando en el fichero");
            esCorrecto = false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException ex) {
                }
            }
        }
        fichero = null;
        return esCorrecto;
    }//Fin Metodo

    public static void getRegistros(File fich) {
        int i;
        String[] linea;
        DataInputStream dis = null;
        try {
            if(compruebaFichero(fich)){
                dis = new DataInputStream(new FileInputStream(fichero));
                switch (tablaActual) {
                    case 1:
                        linea = new String[6];
                        while (true) {
                            linea[0] = String.valueOf(dis.readInt());
                            linea[1] = dis.readUTF();
                            linea[2] = dis.readUTF();
                            linea[3] = dis.readUTF();
                            linea[4] = dis.readUTF();
                            linea[5] = dis.readUTF();
                            modelo.creaObjeto(linea);
                        }//Fin Para
                    case 2:
                        linea = new String[2];
                        while (true) {
                            linea[0] = dis.readUTF();
                            linea[1] = dis.readUTF();
                            modelo.creaObjeto( linea);
                        }//Fin Para
                    case 3:
                        linea = new String[4];
                        while (true) {
                            linea[0] = String.valueOf(dis.readInt());
                            linea[1] = dis.readUTF();
                            linea[2] = String.valueOf(dis.readFloat());
                            linea[3] = dis.readUTF();
                            modelo.creaObjeto(linea);
                        }//Fin Para
                    case 4:
                        linea = new String[4];
                        while (true) {
                            linea[0] = String.valueOf(dis.readInt());
                            linea[1] = dis.readUTF();
                            linea[2] = dis.readUTF();
                            linea[3] = dis.readUTF();
                            modelo.creaObjeto(linea);
                        }//Fin Para
                    case 5:
                        linea = new String[4];
                        while (true) {
                            linea[0] = dis.readUTF();
                            linea[1] = String.valueOf(dis.readInt());
                            linea[2] = dis.readUTF();
                            linea[3] = dis.readUTF();
                            modelo.creaObjeto(linea);
                        }//Fin Para
                    case 6:
                        linea = new String[4];
                        while (true) {
                            linea[0] = dis.readUTF();
                            linea[1] = String.valueOf(dis.readInt());
                            linea[2] = dis.readUTF();
                            linea[3] = dis.readUTF();
                            modelo.creaObjeto(linea);
                            System.out.println("bueno");
                        }//Fin Para
                }
            }
        } catch (Exception ex) {
        }finally{
            if(dis!=null){
                try {
                    dis.close();
                } catch (IOException ex) {
                }
            }
        }
    }//Fin Metodo

    public static boolean compruebaFichero(File pFichero) {
        //Entorno
        boolean siExiste;
        //Algoritmo
        siExiste = false;
        if (pFichero.exists()) {
            siExiste = true;
            TrabajaFicheroDat.fichero = pFichero;
            switch(pFichero.getName()){
                case "empleados.dat":
                    tablaActual = 1;
                    break;
                case "departamentos.dat":
                    tablaActual = 2;
                    break;
                case "salarios.dat":
                    tablaActual = 3;
                    break;
                case "cargos.dat":
                    tablaActual = 4;
                    break;
                case "jefeDepart.dat":
                    tablaActual = 5;
                    break;
                case "empleDeparts.dat":
                    tablaActual = 6;
                    
            }
        }
        return siExiste;
    }//Fin Metodo

}//Fin Clase
