
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Vista.VistaEmpleDepart;
import Modelo.modelo;

public class ControladorEmpleDepart implements ActionListener{
    
    private VistaEmpleDepart ved;
    
    public ControladorEmpleDepart(VistaEmpleDepart ved){
        this.ved = ved;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
                    case "Vista Empleados":
                        procesoFin();
                        ved.vistaEmpleActionPerformed(e);
                        break;
                    case "Vista Depart":
                        procesoFin();
                        ved.vistaDepartActionPerformed(e);
                        break;
                    case "Vista Emple-Depart":
                        procesoFin();
                        ved.vistaEmpleDepartActionPerformed(e);
                        break;
                    case "Vista Jefe-Depart":
                        procesoFin();
                        ved.vistaJefeDepartActionPerformed(e);
                        break;
                    case "Vista Salarios-Emple":
                        procesoFin();
                        ved.vistaSalariosEmpleActionPerformed(e);
                        break;
                    case "Vista Salarios-Cargos":
                        procesoFin();
                        ved.vistaCargosEmpleActionPerformed(e);
        }
        try{
            if(ved.gettextFieldFecha_desde().split("/").length==3 && ved.gettextFieldFecha_hasta().split("/").length==3){
                Integer.parseInt(ved.gettextFieldCodigoEmpleado());
                String[] rowData = {ved.gettextFieldCodigoEmpleado(),ved.gettextFieldCodigoDepartamento()
                        ,ved.gettextFieldFecha_desde(),ved.gettextFieldFecha_hasta()};
                switch(e.getActionCommand()){
                    case "BUSCAR":
                        byte campo = 0;
                        switch(ved.desplegable()){
                            case "Código Empleado":
                                campo = 0;
                                break;
                            case "Nombre":
                                campo = 1;
                                break;
                            case "Apellido":
                                campo = 2;
                                break;
                            case "fecha_nac":
                                campo = 3;
                                break;
                            case "sexo":
                                campo = 4;
                                break;
                            case "fecha_contratacion":
                                campo = 5;
                        }
                        if(ved.gettextFieldBuscar().equalsIgnoreCase("")){
                            ved.settablaEmpleDepart(getTablaModelo());
                        }else{
                            ved.settablaEmpleDepart(busqueda(campo,ved.gettextFieldBuscar()));
                        }

                        break;
                    case "Añadir":
                            if(modelo.creaObjeto(rowData)){
                                ved.settablaEmpleDepart(getTablaModelo());// <-- en rowData metería los datos de la fila nueva pero necesitamos la info de los cuadros
                            }else{
                                System.out.println("No lo ha añadido correctamente");
                            }
                        break;
                    case "Modificar":
                        if(modelo.modificaObjeto(rowData)){
                            //Objeto modificado correctamente (encontrado y modificado)
                            ved.settablaEmpleDepart(getTablaModelo());
                            System.out.println("Objeto modificado correctamente");
                        }else{
                            //Objeto no modificado correctamente (no ha encontrado o hubo algún error al modificar)
                            System.out.println("Hubo algún error al modificar el objeto");
                        }

                        break;
                    case "Eliminar":
                        if(modelo.eliminarRegistro(rowData)){
                            ved.settablaEmpleDepart(getTablaModelo());
                        }else{
                            System.out.println("Hubo algún problema en la eliminación");
                        }
                }
            }else{
                //alguna fecha está mal introducida
                System.out.println("Fecha mal introducida");
            }
        }catch(NumberFormatException nfe){
            //El codigo de empleado es un número
            System.out.println("El codigo del empleado debe ser un número");
        }
    }
    
    //(int camposPk): String[][] ---> solo introduce el num de campos porque siempre las pk van a estar primero
    
    public String[][] getTablaModelo(){//Pasa un array bidimensional con el contenido de la tabla desde el modelo
        String[] registro;
        int i,c;
        String[][] tabla = null;//[filas][columnas]
        LinkedList<Object> obj = modelo.getObjetos();
        if(obj!=null && obj.size()>0){
            tabla = new String[obj.size()][4];//<---
            for(i=0;i<obj.size();i++){
                registro = modelo.obtenArrayEmpleDepart((Objetos.empleDepart) obj.get(i));//<---
                for(c=0;c<registro.length;c++){
                    tabla[i][c] = registro[c];
                }
            }
        }else{
            //Registro vacío
        }
        return tabla;
    }
    
    public void procesoInicio(){
        final byte objEl = 6;//<-- modificar por vista
        modelo.setTablaActual(objEl);
        modelo.cargaFichero();
        ved.settablaEmpleDepart(getTablaModelo());
    }
    
    public void procesoFin(){
        modelo.guardarCambios();
        ved.settablaEmpleDepart(new String[0][0]);
    }
    
    private String[][] busqueda(byte colBusqueda,String cadBusca){
        int f,c;
        String[][] tabla = getTablaModelo();
        LinkedList<String[]> tablaBusqueda = new LinkedList<String[]>();
        for(f = 0;f<tabla.length;f++){
            if(tabla[f][colBusqueda].equalsIgnoreCase(cadBusca)){
                tablaBusqueda.add(tabla[f]);
            }
        }
        tabla = new String[tablaBusqueda.size()][tablaBusqueda.get(0).length];
        for(f = 0;f<tabla.length;f++){
            for(c = 0;c<tabla[0].length;c++){
                tabla [f][c] = tablaBusqueda.get(f)[c];
            }
        }
        return tabla;
    }
}
