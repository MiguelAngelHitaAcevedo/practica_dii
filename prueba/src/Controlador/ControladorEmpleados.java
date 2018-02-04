package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Vista.VistaEmpleadosFinal;
import Objetos.empleado;
import Modelo.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorEmpleados implements ActionListener{

    private VistaEmpleadosFinal ve;
    
    public ControladorEmpleados(VistaEmpleadosFinal ve){
        this.ve = ve;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
                    case "Vista Empleados":
                        procesoFin();
                        ve.vistaEmpleActionPerformed(e);
                        break;
                    case "Vista Depart":
                        procesoFin();
                        ve.vistaDepartActionPerformed(e);
                        break;
                    case "Vista Emple-Depart":
                        procesoFin();
                        ve.vistaEmpleDepartActionPerformed(e);
                        break;
                    case "Vista Jefe-Depart":
                        procesoFin();
                        ve.vistaJefeDepartActionPerformed(e);
                        break;
                    case "Vista Salarios-Emple":
                        procesoFin();
                        ve.vistaSalariosEmpleActionPerformed(e);
                        break;
                    case "Vista Salarios-Cargos":
                        procesoFin();
                        ve.vistaCargosEmpleActionPerformed(e);
        }
        try{
            if(ve.gettextFieldFechaEmpleado().split("/").length==3 && ve.gettextFieldFechaContratacionEmpleado().split("/").length==3){
                Integer.parseInt(ve.gettextFieldCodigoEmpleado());
                String[] rowData = {ve.gettextFieldCodigoEmpleado(),ve.gettextFieldNombreEmpleado()
                        ,ve.gettextFieldApellidoEmpleado(),ve.gettextFieldFechaEmpleado()
                        ,ve.gettextFieldSexoEmpleado().toUpperCase(),ve.gettextFieldFechaContratacionEmpleado()};
                switch(e.getActionCommand()){
                    case "BUSCAR":
                        byte campo = 0;
                        switch(ve.desplegable()){
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
                        if(ve.gettextFieldBuscar().equalsIgnoreCase("")){
                            ve.settablaEmpleados(getTablaModelo());
                        }else{
                            ve.settablaEmpleados(busqueda(campo,ve.gettextFieldBuscar()));
                        }

                        break;
                    case "Añadir":
                            if(modelo.creaObjeto(rowData)){
                                ve.settablaEmpleados(getTablaModelo());// <-- en rowData metería los datos de la fila nueva pero necesitamos la info de los cuadros
                            }else{
                                System.out.println("No lo ha añadido correctamente");
                            }
                        break;
                    case "Modificar":
                        if(modelo.modificaObjeto(rowData)){
                            //Objeto modificado correctamente (encontrado y modificado)
                            ve.settablaEmpleados(getTablaModelo());
                            System.out.println("Objeto modificado correctamente");
                        }else{
                            //Objeto no modificado correctamente (no ha encontrado o hubo algún error al modificar)
                            System.out.println("Hubo algún error al modificar el objeto");
                        }

                        break;
                    case "Eliminar":
                        if(modelo.eliminarRegistro(rowData)){
                            ve.settablaEmpleados(getTablaModelo());
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
            tabla = new String[obj.size()][6];//<---
            for(i=0;i<obj.size();i++){
                registro = Modelo.modelo.obtenArrayEmpleado((Objetos.empleado) obj.get(i));//<---
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
        final byte objEl = 1;//<-- modificar por vista
        modelo.setTablaActual(objEl);
        modelo.cargaFichero();
        ve.settablaEmpleados(getTablaModelo());
    }
    
    public void procesoFin(){
        modelo.guardarCambios();
        ve.settablaEmpleados(new String[0][0]);
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
