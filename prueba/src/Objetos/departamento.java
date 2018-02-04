package Objetos;


/**
 * Programa: Empleados
 * @author Adrián Urbano Gómez
 *          Emilio García Barroso
 *          Miguel Ángel Hita Acebedo
 */
public class departamento {
    //Atributos
    private String dept_no;
    private String dept_name;
    
    //Constructores
    public departamento(String pDept_no, String pDept_name){
        setDept_no(pDept_no);
        setDept_name(pDept_name);
        
    }
    //Metodos
    public void setDept_no(String Dept_no) {
        this.dept_no = Dept_no;
    }
    
    public void setDept_name(String Dept_name) {
        this.dept_name = Dept_name;
    }
    
    public String getDept_no() {
        return dept_no;
    }
    
    public String getDept_name() {
        return dept_name;
    }
}//Fin Clase
