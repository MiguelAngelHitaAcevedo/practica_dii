
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Vista.VistaCargos;
import Objetos.empleCargo;
import Modelo.modelo;

public class ControladorCargos implements ActionListener{

    private VistaCargos vc;
    
    public ControladorCargos(VistaCargos vc){
        this.vc = vc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Vista Empleados":
                procesoFin();
                vc.vistaEmpleActionPerformed(e);
                break;
            case "Vista Depart":
                procesoFin();
                vc.vistaDepartActionPerformed(e);
                break;
            case "Vista Emple-Depart":
                procesoFin();
                vc.vistaEmpleDepartActionPerformed(e);
                break;
            case "Vista Jefe-Depart":
                procesoFin();
                vc.vistaJefeDepartActionPerformed(e);
                break;
            case "Vista Salarios-Emple":
                procesoFin();
                vc.vistaSalariosEmpleActionPerformed(e);
                break;
            case "Vista Salarios-Cargos":
                procesoFin();
                vc.vistaCargosEmpleActionPerformed(e);
        }
        try{
            if(vc.gettextFieldFecha_desde().split("/").length==3 && vc.gettextFieldFecha_hasta().split("/").length==3){
                Integer.parseInt(vc.gettextFieldCodigoEmpleado());
                String[] rowData = {vc.gettextFieldCodigoEmpleado(),vc.gettextFieldCargo(),vc.gettextFieldFecha_desde(),vc.gettextFieldFecha_hasta()};
                switch(e.getActionCommand()){
                    case "BUSCAR":
                        byte campo = 0;
                        switch(vc.desplegable()){
                            case "Código Empleado":
                                campo = 0;
                                break;
                            case "Cargo":
                                campo = 1;
                                break;
                            case "Fecha Desde":
                                campo = 2;
                                break;
                            case "Fecha Hasta":
                                campo = 3;
                        }
                        if(vc.gettextFieldBuscar().equalsIgnoreCase("")){
                            vc.settablaCargos(getTablaModelo());
                        }else{
                            vc.settablaCargos(busqueda(campo,vc.gettextFieldBuscar()));
                        }

                        break;
                    case "Añadir":
                            if(modelo.creaObjeto(rowData)){
                                vc.settablaCargos(getTablaModelo());// <-- en rowData metería los datos de la fila nueva pero necesitamos la info de los cuadros
                            }else{
                                System.out.println("No lo ha añadido correctamente");
                            }
                        break;
                    case "Modificar":
                        if(modelo.modificaObjeto(rowData)){
                            //Objeto modificado correctamente (encontrado y modificado)
                            vc.settablaCargos(getTablaModelo());
                            System.out.println("Objeto modificado correctamente");
                        }else{
                            //Objeto no modificado correctamente (no ha encontrado o hubo algún error al modificar)
                            System.out.println("Hubo algún error al modificar el objeto");
                        }

                        break;
                    case "Eliminar":
                        if(modelo.eliminarRegistro(rowData)){
                            if(rowData.length == 0){
                                System.out.println("Tabla vacia");
                            }else{
                            vc.settablaCargos(getTablaModelo());
                            }
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
                registro = modelo.obtenArrayEmpleCargo((Objetos.empleCargo) obj.get(i));//<---
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
        final byte objEl = 4;//<-- modificar por vista
        modelo.setTablaActual(objEl);
        modelo.cargaFichero();
        vc.settablaCargos(getTablaModelo());
    }
    
    public void procesoFin(){
        modelo.guardarCambios();
        vc.settablaCargos(new String[0][0]);
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
