package Controlador;


import Modelo.*;
import Vista.VistaJefeDepart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

//Autor: Miguel Angel Hita Acevjddo
public class ControladorJefeDepart implements ActionListener{

    private VistaJefeDepart vjd;
    
    public ControladorJefeDepart(VistaJefeDepart vjd){
        this.vjd = vjd;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
	switch(e.getActionCommand()){
                    case "Vista Empleados":
                        procesoFin();
                        vjd.vistaEmpleActionPerformed(e);
                        break;
                    case "Vista Depart":
                        procesoFin();
                        vjd.vistaDepartActionPerformed(e);
                        break;
                    case "Vista Emple-Depart":
                        procesoFin();
                        vjd.vistaEmpleDepartActionPerformed(e);
                        break;
                    case "Vista Jefe-Depart":
                        procesoFin();
                        vjd.vistaJefeDepartActionPerformed(e);
                        break;
                    case "Vista Salarios-Emple":
                        procesoFin();
                        vjd.vistaSalariosEmpleActionPerformed(e);
                        break;
                    case "Vista Salarios-Cargos":
                        procesoFin();
                        vjd.vistaCargosEmpleActionPerformed(e);
        }	
        try{
            if(vjd.gettextFieldFecha_Desde().split("/").length==3 && vjd.gettextFieldFecha_Hasta().split("/").length==3){
                Integer.parseInt(vjd.gettextFieldCodigoEmpleado());
                String[] rowData = {vjd.gettextFieldCodigoDepartamento(),vjd.gettextFieldCodigoEmpleado(),vjd.gettextFieldFecha_Desde(),vjd.gettextFieldFecha_Hasta()};
                switch(e.getActionCommand()){
                    case "BUSCAR":
                        byte campo = 0;
                        switch(vjd.desplegable()){
                            case "Codigo Departamento":
                                campo = 0;
                                break;
                            case "Codigo Empleado":
                                campo = 1;
                                break;
                            case "Fecha_Desde":
                                campo = 2;
                                break;
                            case "Fecha_Hasta":
                                campo = 3;
                        }
                        if(vjd.gettextFieldBuscar().equalsIgnoreCase("")){
                            vjd.settablaJefeDepart(getTablaModelo());
                        }else{
                            vjd.settablaJefeDepart(busqueda(campo,vjd.gettextFieldBuscar()));
                        }

                        break;
                    case "Añadir":
                            if(modelo.creaObjeto(rowData)){
                                vjd.settablaJefeDepart(getTablaModelo());// <-- en rowData metería los datos de la fila nueva pero necesitamos la info de los cuadros
                            }else{
                                System.out.println("No lo ha añadido correctamente");
                            }
                        break;
                    case "Modificar":
                        if(modelo.modificaObjeto(rowData)){
                            //Objeto modificado correctamente (encontrado y modificado)
                            vjd.settablaJefeDepart(getTablaModelo());
                            System.out.println("Objeto modificado correctamente");
                        }else{
                            //Objeto no modificado correctamente (no ha encontrado o hubo algún error al modificar)
                            System.out.println("Hubo algún error al modificar el objeto");
                        }

                        break;
                    case "Eliminar":
                        if(modelo.eliminarRegistro(rowData)){
                            vjd.settablaJefeDepart(getTablaModelo());
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
            tabla = new String[obj.size()][4];
            for(i=0;i<obj.size();i++){
                registro = modelo.obtenArrayDepartJefe((Objetos.departJefe) obj.get(i));
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
        final byte objEl = 5;//<-- modificar por vista
        modelo.setTablaActual(objEl);
        modelo.cargaFichero();
        vjd.settablaJefeDepart(getTablaModelo());
    }
    
    public void procesoFin(){
        modelo.guardarCambios();
        vjd.settablaJefeDepart(new String[0][0]);
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
