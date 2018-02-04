package Modelo;


import Objetos.empleado;
import Objetos.empleDepart;
import Objetos.empleCargo;
import Objetos.departamento;
import Objetos.departJefe;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import Objetos.salario;

//Contenido:
/*
 - creaObjeto: recibe un byte que hará referencia al objeto que desea instanciar y
                el array de strings son los parámetros del registro a crear.
                Todos los crea...(algo) privados son llamados desde este método.
 - modificaObjeto:  mas o menos es lo mismo que "eligeObjeto" (solo que "eligeObjeto"
                los crea y "modificaObjeto" modifica los ya creados previamente).
                Todos los modifica...(algo) son llamados desde este método.
 - eliminarRegistro: usa el numero de campos clave para ir comprobando las
                coincidencias en el LinkedList del modelo.
 - buscaPorCampo: 
*/

/*objElegido:
1 .- empleado
2 .- departamento
3 .- salario
4 .- empleCargo
5 .- departJefe
6 .- departEmple
*/
public class modelo {
    //Atributos:
    private static LinkedList<Object> obj = new LinkedList<Object>();
    private static byte tablaActual;
    private static final byte numPkEmpleado=1;
    private static final byte numPkDepartamento=2;
    private static final byte numPkSalario=2;
    private static final byte numPkEmpleCargo=3;
    private static final byte numPkDepartJefe=2;
    private static final byte numPkEmpleDepart=2;
    //Metodos publicos:
    public static LinkedList<Object> getObjetos(){
        return obj;
    }
    
    public static boolean creaObjeto(String[] campos){
        Object ultimoObj=null;
        switch(tablaActual){
            case 1:
                if((ultimoObj=(Object)creaEmpleado(campos))!=null){
                    obj.addLast(ultimoObj);
                }
                break;
            case 2:
                if((ultimoObj=(Object)creaDepartamento(campos))!=null){
                    obj.addLast(ultimoObj);
                }
                break;
            case 3:
                if((ultimoObj=(Object)creaSalario(campos))!=null){
                    obj.addLast(ultimoObj);
                }
                break;
            case 4:
                if((ultimoObj=(Object)creaEmpleCargo(campos))!=null){
                    obj.addLast(ultimoObj);
                }
                break;
            case 5:
                if((ultimoObj=(Object)creaDepartJefe(campos))!=null){
                    obj.addLast(ultimoObj);
                }
                break;
            case 6:
                if((ultimoObj=(Object)creaEmpleDepart(campos))!=null){
                    obj.addLast(ultimoObj);
                }
                break;
        }
        return (ultimoObj!=null);//Si no es nulo devolverá true, lo que significará que se ha creado
    }//listo
    
    public static boolean modificaObjeto(String[] campos){
        int pos=existeKey(campos);
        Object ultimoObj=null;
        byte i;
        int num;
        switch(tablaActual){
            case 1://empleado
                if(pos!=-1){//Si existe (buscando las pks)
                    String[] aModificar=obtenArrayEmpleado((empleado)obj.get(pos));//<--
                    num = keyEmpleados.keyEmp_no.indexOf(Integer.parseInt(campos[0]));
                    keyEmpleados.keyEmp_no.remove(num);
                    for(i=0;i<campos.length;i++){//va comprobando que campos cambiar
                        if(!campos[i].equalsIgnoreCase("")){//Si es un campo introducido como vacio, el objeto no cambia
                            aModificar[i]=campos[i];
                        }
                    }
                    obj.remove(pos);//borra el objeto del LinkedList
                    obj.add(pos, ultimoObj=creaEmpleado(aModificar));//y crea uno nuevo en la misma posicion <--
                }
                break;
            case 2://departamento
                if(pos!=-1){//Si existe (buscando las pks)
                    String[] aModificar=obtenArrayDepartamento((departamento)obj.get(pos));//<--
                    num = keyDepartamentos.keyDept_no.indexOf(Integer.parseInt(campos[0]));
                    keyDepartamentos.keyDept_no.remove(num);
                    for(i=0;i<campos.length;i++){//va comprobando que campos cambiar
                        if(!campos[i].equalsIgnoreCase("")){//Si es un campo introducido como vacio, el objeto no cambia
                            aModificar[i]=campos[i];
                        }
                    }
                    obj.remove(pos);//borra el objeto del LinkedList
                    obj.add(pos, ultimoObj=creaDepartamento(aModificar));//y crea uno nuevo en la misma posicion
                }
                break;
            case 3://salario
                if(pos!=-1){//Si existe (buscando las pks)
                    String[] aModificar=obtenArraySalario((salario)obj.get(pos));
                    for(i=0;i<campos.length;i++){//va comprobando que campos cambiar
                        if(!campos[i].equalsIgnoreCase("")){//Si es un campo introducido como vacio, el objeto no cambia
                            aModificar[i]=campos[i];
                        }
                    }
                    obj.remove(pos);//borra el objeto del LinkedList
                    obj.add(pos, ultimoObj=creaSalario(aModificar));//y crea uno nuevo en la misma posicion
                }
                break;
            case 4://empleCargo
                if(pos!=-1){//Si existe (buscando las pks)
                    String[] aModificar=obtenArrayEmpleCargo((empleCargo)obj.get(pos));
                    for(i=0;i<campos.length;i++){//va comprobando que campos cambiar
                        if(!campos[i].equalsIgnoreCase("")){//Si es un campo introducido como vacio, el objeto no cambia
                            aModificar[i]=campos[i];
                        }
                    }
                    obj.remove(pos);//borra el objeto del LinkedList
                    obj.add(pos, ultimoObj=creaEmpleCargo(aModificar));//y crea uno nuevo en la misma posicion
                }
                break;
            case 5://departJefe
                if(pos!=-1){//Si existe (buscando las pks)
                    String[] aModificar=obtenArrayDepartJefe((departJefe)obj.get(pos));
                    for(i=0;i<campos.length;i++){//va comprobando que campos cambiar
                        if(!campos[i].equalsIgnoreCase("")){//Si es un campo introducido como vacio, el objeto no cambia
                            aModificar[i]=campos[i];
                        }
                    }
                    obj.remove(pos);//borra el objeto del LinkedList
                    obj.add(pos, ultimoObj=creaDepartJefe(aModificar));//y crea uno nuevo en la misma posicion
                }
                break;
            case 6://departEmple
                if(pos!=-1){//Si existe (buscando las pks)
                    String[] aModificar=obtenArrayEmpleDepart((empleDepart)obj.get(pos));
                    for(i=0;i<campos.length;i++){//va comprobando que campos cambiar
                        if(!campos[i].equalsIgnoreCase("")){//Si es un campo introducido como vacio, el objeto no cambia
                            aModificar[i]=campos[i];
                        }
                    }
                    obj.remove(pos);//borra el objeto del LinkedList
                    obj.add(pos, ultimoObj=creaEmpleDepart(aModificar));//y crea uno nuevo en la misma posicion
                }
                break;
        }
        return (ultimoObj!=null);
    }
    
    public static boolean eliminarRegistro(String[] campos){
        int pos=existeKey(campos);
        if(pos!=-1){
            obj.remove(pos);
        }
        return pos!=-1;//Si lo ha encontrado devuelve true
    }//listo
    
    public static LinkedList<String[]> buscarPorCampo(byte c,String introducido){//en el linkedlist se guarda un array de string (que son los campos del objeto)
        LinkedList<String[]> objEncontrados=new LinkedList<String[]>();
        int i;
        String[] campos;
        switch(tablaActual){
            case 1://empleado
                for(i=0;i<obj.size();i++){
                    campos=obtenArrayEmpleado((empleado)obj.get(i));
                    if(campos[c].equalsIgnoreCase(introducido)){
                        objEncontrados.add(campos);
                    }
                }
                break;
            case 2://departamento
                for(i=0;i<obj.size();i++){
                    campos=obtenArrayDepartamento((departamento)obj.get(i));
                    if(campos[c].equalsIgnoreCase(introducido)){
                        objEncontrados.add(campos);
                    }
                }
                break;
            case 3://salario
                for(i=0;i<obj.size();i++){
                    campos=obtenArraySalario((salario)obj.get(i));
                    if(campos[c].equalsIgnoreCase(introducido)){
                        objEncontrados.add(campos);
                    }
                }
                break;
            case 4://empleCargo
                for(i=0;i<obj.size();i++){
                    campos=obtenArrayEmpleCargo((empleCargo)obj.get(i));
                    if(campos[c].equalsIgnoreCase(introducido)){
                        objEncontrados.add(campos);
                    }
                }
                break;
            case 5://departJefe
                for(i=0;i<obj.size();i++){
                    campos=obtenArrayDepartJefe((departJefe)obj.get(i));
                    if(campos[c].equalsIgnoreCase(introducido)){
                        objEncontrados.add(campos);
                    }
                }
                break;
            case 6://departEmple
                for(i=0;i<obj.size();i++){
                    campos=obtenArrayEmpleDepart((empleDepart)obj.get(i));
                    if(campos[c].equalsIgnoreCase(introducido)){
                        objEncontrados.add(campos);
                    }
                }
                break;
        }
        return objEncontrados;
    }//listo
    
    private static void limpiaTabla(){
        obj=new LinkedList<Object>();
    }//listo
    
    public static int existeKey(String[] campos){//buscaPorCampo
        int pos=-1,i=0;
        String[] comprobante;
        switch(tablaActual){
            case 1://empleado
                comprobante=new String[numPkEmpleado];
                while(pos+1<obj.size() && i<numPkEmpleado){
                    i=0;
                    pos++;
                    comprobante=obtenArrayEmpleado((empleado)obj.get(pos));
                    while(i<numPkEmpleado && comprobante[i].equalsIgnoreCase(campos[i])){
                        i++;
                    }
                }
                break;
            case 2://departamento
                comprobante=new String[numPkDepartamento];
                while(pos+1<obj.size() && i<numPkDepartamento){
                    i=0;
                    pos++;
                    comprobante=obtenArrayDepartamento((departamento)obj.get(pos));
                    while(i<numPkDepartamento && comprobante[i].equalsIgnoreCase(campos[i])){
                        i++;
                    }
                }
                break;
            case 3://salario
                comprobante=new String[numPkSalario];
                while(pos+1<obj.size() && i<numPkSalario){
                    i=0;
                    pos++;
                    comprobante=obtenArraySalario((salario)obj.get(pos));
                    while(i<numPkSalario && comprobante[i].equalsIgnoreCase(campos[i])){
                        i++;
                    }
                }
                break;
            case 4://empleCargo
                comprobante=new String[numPkEmpleCargo];
                while(pos+1<obj.size() && i<numPkEmpleCargo){
                    i=0;
                    pos++;
                    comprobante=obtenArrayEmpleCargo((empleCargo)obj.get(pos));
                    while(i<numPkEmpleCargo && comprobante[i].equalsIgnoreCase(campos[i])){
                        i++;
                    }
                }
                break;
            case 5://departJefe
                comprobante=new String[numPkDepartJefe];
                while(pos+1<obj.size() && i<numPkDepartJefe){
                    i=0;
                    pos++;
                    comprobante=obtenArrayDepartJefe((departJefe)obj.get(pos));
                    while(i<numPkDepartJefe && comprobante[i].equalsIgnoreCase(campos[i])){
                        i++;
                    }
                }
                break;
            case 6://departEmple
                comprobante=new String[numPkEmpleDepart];
                while(pos+1<obj.size() && i<numPkEmpleDepart){
                    i=0;
                    pos++;
                    comprobante=obtenArrayEmpleDepart((empleDepart)obj.get(pos));
                    while(i<numPkEmpleDepart && comprobante[i].equalsIgnoreCase(campos[i])){
                        i++;
                    }
                }
                break;
        }
        if(i < numPkEmpleado){//Porque si ha salido de los bucles gracias a esta condición, es que no ha encontrado las coincidencias
            pos = -1;
        }
        return pos;
    }//listo
    
    public static void cargaFichero(){//Al inicio de la ejecución
        File fich=null;
        switch(tablaActual){
            case 1://empleado
                fich=new File("empleados.dat");
                break;
            case 2://departamento
                fich=new File("departamentos.dat");
                break;
            case 3://salario
                fich=new File("salarios.dat");
                break;
            case 4://empleCargo
                fich=new File("cargos.dat");
                break;
            case 5://departJefe
                fich=new File("jefeDepart.dat");
                break;
            case 6://departEmple
                fich=new File("empleDeparts.dat");
                break;
        }
        modelo.limpiaTabla();
        TrabajaFicheroDat.getRegistros(fich);
    }//Al iniciar
    
    public static void guardarCambios(){
        File fich=null;
        int i;
        LinkedList<String[]> aGuardar = new LinkedList<String[]>();
        switch(tablaActual){
            case 1://empleado
                fich=new File("empleados.dat");
                for(i = 0;i<obj.size();i++){
                    aGuardar.add(modelo.obtenArrayEmpleado((empleado) obj.get(i)));
                }
                break;
            case 2://departamento
                fich=new File("departamentos.dat");
                for(i = 0;i<obj.size();i++){
                    aGuardar.add(modelo.obtenArrayDepartamento((departamento) obj.get(i)));
                }
                break;
            case 3://salario
                fich=new File("salarios.dat");
                for(i = 0;i<obj.size();i++){
                    aGuardar.add(modelo.obtenArraySalario((salario) obj.get(i)));
                }
                break;
            case 4://empleCargo
                fich=new File("cargos.dat");
                for(i = 0;i<obj.size();i++){
                    aGuardar.add(modelo.obtenArrayEmpleCargo((empleCargo) obj.get(i)));
                }
                break;
            case 5://departJefe
                fich=new File("jefeDepart.dat");
                for(i = 0;i<obj.size();i++){
                    aGuardar.add(modelo.obtenArrayDepartJefe((departJefe) obj.get(i)));
                }
                break;
            case 6://departEmple
                fich=new File("empleDeparts.dat");
                for(i = 0;i<obj.size();i++){
                    aGuardar.add(modelo.obtenArrayEmpleDepart((empleDepart) obj.get(i)));
                }
                break;
        }
        if(fich!=null && !fich.exists()){
            try {
                fich.createNewFile();
            } catch (IOException ex) {
            }
        }
        modelo.limpiaTabla();
        TrabajaFicheroDat.guardarRegistros(aGuardar,fich);
    }//Al terminar
    
    //Metodos privados "crea":
    private static empleado creaEmpleado(String[] campos){
        empleado empleCreado=null;
        //Si todos los campos son correctos lo introduce en el objeto
        if(existeKey(campos)==-1){
            if(utilidades.esFechaCorrecta(campos[3])){
                if(utilidades.esNumeroEntero(campos[0])){
                    if(utilidades.esSexoCorrecto(campos[4])){
                        if(utilidades.esFechaCorrecta(campos[5])){
                            
                        }else{
                            System.out.println("fecha2mal");
                        }
                    }else{
                        System.out.println("sexomal");
                    }
                }else{
                    System.out.println("noesnumEntero");
                }
            }else{
                System.out.println("fecha1mal");
            }
        }else{
            System.out.println("existekey");
        }
        if(existeKey(campos)==-1 && utilidades.esFechaCorrecta(campos[3]) && utilidades.esNumeroEntero(campos[0]) && utilidades.esSexoCorrecto(campos[4]) && utilidades.esFechaCorrecta(campos[5])){
            int emp_no=Integer.parseInt(campos[0]);
            String nombre=campos[1];
            String apellido=campos[2];
            String fecha_nac=campos[3];
            String sexo=campos[4];
            String fecha_contratacion=campos[5];
            keyEmpleados.keyEmp_no.add(emp_no);
            empleCreado=new empleado(emp_no,nombre,apellido,fecha_nac,sexo,fecha_contratacion);
            System.out.println("Añadido correctamente");
        }
        return empleCreado;
    }
    
    private static departamento creaDepartamento(String[] campos){
        departamento deptCreado=null;
        if(existeKey(campos)==-1 && utilidades.esNumeroEntero(campos[0])){
            String dept_no=campos[0];
            String dept_name=campos[1];
            keyDepartamentos.keyDept_no.add(dept_no);
            deptCreado=new departamento(dept_no,dept_name);
        }
        return deptCreado;
    }
    
    private static salario creaSalario(String[] campos){
        salario salarioCreado=null;
        if(existeKey(campos)==-1 && utilidades.esNumeroEntero(campos[0]) && utilidades.esNumeroReal(campos[2])){
            int emp_no=Integer.parseInt(campos[0]);
            String fecha_desde=campos[1];
            float salarios=Float.parseFloat(campos[2]);
            String fecha_hasta=campos[3];
            salarioCreado=new salario(emp_no,fecha_desde,salarios,fecha_hasta);
        }
        return salarioCreado;
    }
    
    private static empleCargo creaEmpleCargo(String[] campos){
        empleCargo empleCargoCreado=null;
        if(existeKey(campos)==-1 && utilidades.esNumeroEntero(campos[0]) && utilidades.esFechaCorrecta(campos[2]) && utilidades.esFechaCorrecta(campos[3])){// && keyEmpleados.encuentraEmpleado(Integer.parseInt(campos[0])) && keyDepartamentos.encuentraDepartamento(campos[1])
            int emp_no=Integer.parseInt(campos[0]);
            String cargo=campos[1];
            String fecha_desde=campos[2];
            String fecha_hasta=campos[3];
            empleCargoCreado=new empleCargo(emp_no,cargo,fecha_desde,fecha_hasta);
        }
        return empleCargoCreado;
    }
    
    private static departJefe creaDepartJefe(String[] campos){
        departJefe departJefeCreado=null;
        if(existeKey(campos)==-1 && utilidades.esNumeroEntero(campos[1]) && utilidades.esFechaCorrecta(campos[2]) && utilidades.esFechaCorrecta(campos[3]) && keyEmpleados.encuentraEmpleado(Integer.parseInt(campos[1])) && keyDepartamentos.encuentraDepartamento(campos[0])){
            String dept_no=campos[0];
            int emp_no=Integer.parseInt(campos[1]);
            String fecha_desde=campos[2];
            String fecha_hasta=campos[3];
            departJefeCreado=new departJefe(dept_no,emp_no,fecha_desde,fecha_hasta);
        }
        return departJefeCreado;
    }
    
    private static empleDepart creaEmpleDepart(String[] campos){
        empleDepart empleDepartCreado=null;
        if(existeKey(campos)==-1 && utilidades.esNumeroEntero(campos[1]) && utilidades.esFechaCorrecta(campos[2]) && utilidades.esFechaCorrecta(campos[3])){// && keyEmpleados.encuentraEmpleado(Integer.parseInt(campos[1])) && keyDepartamentos.encuentraDepartamento(campos[0])
            String dept_no=campos[0];
            int emp_no=Integer.parseInt(campos[1]);
            String fecha_desde=campos[2];
            String fecha_hasta=campos[3];
            empleDepartCreado=new empleDepart(dept_no,emp_no,fecha_desde,fecha_hasta);
        }
        return empleDepartCreado;
    }
    
    //Metodos obtenArray
    public static String[] obtenArrayEmpleado(empleado e){
        String[] campos = {""+e.getEmp_no(),e.getNombre(),e.getApellidos(),e.getFecha_nac(),e.getSexo(),e.getFecha_contratacion()};
        return campos;
    }
    
    public static String[] obtenArrayDepartamento(departamento d){
        String[] campos={d.getDept_no(),d.getDept_name()};
        return campos;
    }
    
    public static String[] obtenArraySalario(salario s){
        String[] campos={""+s.getEmp_no(),s.getFecha_desde(),""+s.getSalarios(),s.getFecha_hasta()};
        return campos;
    }
    
    public static String[] obtenArrayEmpleCargo(empleCargo ec){
        String[] campos={""+ec.getEmp_no(),ec.getCargo(),ec.getFecha_desde(),ec.getFecha_hasta()};
        return campos;
    }
    
    public static String[] obtenArrayDepartJefe(departJefe df){
        String[] campos={df.getDept_no(),""+df.getEmp_no(),df.getFecha_desde(),df.getFecha_hasta()};
        return campos;
    }
    
    public static String[] obtenArrayEmpleDepart(empleDepart ed){
        String[] campos={ed.getDept_no(),""+ed.getEmp_no(),ed.getFecha_desde(),ed.getFecha_hasta()};
        return campos;
    }
    //get y set de tabla Actual
    public static byte getTablaActual() {
        return tablaActual;
    }

    public static void setTablaActual(byte tablaActual) {
        modelo.tablaActual = tablaActual;
    }
}