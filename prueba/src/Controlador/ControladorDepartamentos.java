package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Vista.VistaDepartamentosFinal;
import Objetos.departamento;
import Modelo.modelo;

public class ControladorDepartamentos implements ActionListener{

    private VistaDepartamentosFinal vd;
    
    public ControladorDepartamentos(VistaDepartamentosFinal vd){
        this.vd = vd;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
                    case "Vista Empleados":
                        procesoFin();
                        vd.vistaEmpleActionPerformed(e);
                        break;
                    case "Vista Depart":
                        procesoFin();
                        vd.vistaDepartActionPerformed(e);
                        break;
                    case "Vista Emple-Depart":
                        procesoFin();
                        vd.vistaEmpleDepartActionPerformed(e);
                        break;
                    case "Vista Jefe-Depart":
                        procesoFin();
                        vd.vistaJefeDepartActionPerformed(e);
                        break;
                    case "Vista Salarios-Emple":
                        procesoFin();
                        vd.vistaSalariosEmpleActionPerformed(e);
                        break;
                    case "Vista Salarios-Cargos":
                        procesoFin();
                        vd.vistaCargosEmpleActionPerformed(e);
        }
        String[] rowData = {vd.gettextFieldNumeroDepartamento(),vd.gettextFieldNombreDepartamento()};
        switch(e.getActionCommand()){
            case "BUSCAR":
                byte campo = 0;
                switch(vd.desplegable()){
                    case "dept_no":
                        campo = 0;
                        break;
                    case "nombre departamento":
                        campo = 1;
                }
                if(vd.gettextFieldBuscar().equalsIgnoreCase("")){
                    vd.settablaDepartamentos(getTablaModelo());
                }else{
                    vd.settablaDepartamentos(busqueda(campo,vd.gettextFieldBuscar()));
                }

                break;
            case "Añadir":
                    if(modelo.creaObjeto(rowData)){
                        vd.settablaDepartamentos(getTablaModelo());// <-- en rowData metería los datos de la fila nueva pero necesitamos la info de los cuadros
                    }else{
                        System.out.println("No lo ha añadido correctamente");
                    }
                break;
            case "Modificar":
                if(modelo.modificaObjeto(rowData)){
                    //Objeto modificado correctamente (encontrado y modificado)
                    vd.settablaDepartamentos(getTablaModelo());
                    System.out.println("Objeto modificado correctamente");
                }else{
                    //Objeto no modificado correctamente (no ha encontrado o hubo algún error al modificar)
                    System.out.println("Hubo algún error al modificar el objeto");
                }

                break;
            case "Eliminar":
                if(modelo.eliminarRegistro(rowData)){
                    vd.settablaDepartamentos(getTablaModelo());
                }else{
                    System.out.println("Hubo algún problema en la eliminación");
                }
        }
    }
    
    //(int camposPk): String[][] ---> solo introduce el num de campos porque siempre las pk van a estar primero
    
    public String[][] getTablaModelo(){//Pasa un array bidimensional con el contenido de la tabla desde el modelo
        String[] registro;
        int i,c;
        String[][] tabla = null;//[filas][columnas]
        LinkedList<Object> obj = modelo.getObjetos();
        if(obj!=null && obj.size()>0){
            tabla = new String[obj.size()][2];//<---
            for(i=0;i<obj.size();i++){
                registro = modelo.obtenArrayDepartamento((Objetos.departamento) obj.get(i));//<---
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
        final byte objEl = 2;//<-- modificar por vista
        modelo.setTablaActual(objEl);
        modelo.cargaFichero();
        vd.settablaDepartamentos(getTablaModelo());
    }
    
    public void procesoFin(){
        modelo.guardarCambios();
        vd.settablaDepartamentos(new String[0][0]);
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
