package Controlador;


import Vista.VistaSalarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Modelo.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Autor: Miguel Angel Hita Acevedo
public class ControladorSalarios implements ActionListener{

    private VistaSalarios vs;
    
    public ControladorSalarios(VistaSalarios vs){
        this.vs = vs;
    }
    @Override
    
    public void actionPerformed(ActionEvent e) {
	switch(e.getActionCommand()){
                    case "Vista Empleados":
                        procesoFin();
                        vs.vistaEmpleActionPerformed(e);
                        break;
                    case "Vista Depart":
                        procesoFin();
                        vs.vistaDepartActionPerformed(e);
                        break;
                    case "Vista Emple-Depart":
                        procesoFin();
                        vs.vistaEmpleDepartActionPerformed(e);
                        break;
                    case "Vista Jefe-Depart":
                        procesoFin();
                        vs.vistaJefeDepartActionPerformed(e);
                        break;
                    case "Vista Salarios-Emple":
                        procesoFin();
                        vs.vistaSalariosEmpleActionPerformed(e);
                        break;
                    case "Vista Cargos-Emple":
                        procesoFin();
                        vs.vistaCargosEmpleActionPerformed(e);
        }	
        try{
            if(vs.gettextFieldFecha_Desde().split("/").length==3 && vs.gettextFieldFecha_Hasta().split("/").length==3){
                Integer.parseInt(vs.gettextFieldCodigoEmpleado());
                String[] rowData = {vs.gettextFieldCodigoEmpleado(),vs.gettextFieldFecha_Desde(),vs.gettextFieldSalario(),vs.gettextFieldFecha_Hasta()};
                switch(e.getActionCommand()){
                    case "BUSCAR":
                        byte campo = 0;
                        switch(vs.desplegable()){
                            case "Código Empleado":
                                campo = 0;
                                break;
                            case "Fecha_Desde":
                                campo = 1;
                                break;
                            case "Salario":
                                campo = 2;
                                break;
                            case "Fecha_Hasta":
                                campo = 3;
                        }
                        if(vs.gettextFieldBuscar().equalsIgnoreCase("")){
                            vs.settablaSalarios(getTablaModelo());
                        }else{
                            vs.settablaSalarios(busqueda(campo,vs.gettextFieldBuscar()));
                        }

                        break;
                    case "Añadir":
                            if(Modelo.modelo.creaObjeto(rowData)){
                                vs.settablaSalarios(getTablaModelo());// <-- en rowData metería los datos de la fila nueva pero necesitamos la info de los cuadros
                            }else{
                                System.out.println("No lo ha añadido correctamente");
                            }
                        break;
                    case "Modificar":
                        if(Modelo.modelo.modificaObjeto(rowData)){
                            //Objeto modificado correctamente (encontrado y modificado)
                            vs.settablaSalarios(getTablaModelo());
                            System.out.println("Objeto modificado correctamente");
                        }else{
                            //Objeto no modificado correctamente (no ha encontrado o hubo algún error al modificar)
                            System.out.println("Hubo algún error al modificar el objeto");
                        }

                        break;
                    case "Eliminar":
                        if(Modelo.modelo.eliminarRegistro(rowData)){
                            vs.settablaSalarios(getTablaModelo());
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
        LinkedList<Object> obj = Modelo.modelo.getObjetos();
        if(obj!=null && obj.size()>0){
            tabla = new String[obj.size()][4];
            for(i=0;i<obj.size();i++){
                registro = Modelo.modelo.obtenArraySalario((Objetos.salario) obj.get(i));
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
        final byte objEl = 3;//<-- modificar por vista
        modelo.setTablaActual(objEl);
        modelo.cargaFichero();
        vs.settablaSalarios(getTablaModelo());
    }
    
    public void procesoFin(){
        modelo.guardarCambios();
        vs.settablaSalarios(new String[0][0]);
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
