package Objetos;


/**
 * Programa: Empleados
 * @author Adrián Urbano Gómez
 *          Emilio García Barroso
 *          Miguel Ángel Hita Acebedo
 */
public class empleado {
    //Atributos
    private int emp_no;
    private String nombre;
    private String apellidos;
    private String fecha_nac;
    private String sexo;
    private String fecha_contratacion;
    //Constructores
    public empleado(int pEmp_no, String pNombre, String pApellidos, String pFecha_Nac, String pSexo, String pFecha_Contratacion){
        setEmp_no(pEmp_no);
        setNombre(pNombre);
        setApellidos(pApellidos);
        setSexo(pSexo);
        setFecha_nac(pFecha_Nac);
        setFecha_contratacion(pFecha_Contratacion);
    }
    
    //Metodos
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }
    
    public int getEmp_no() {
        return emp_no;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public String getFecha_nac() {
        return fecha_nac;
    }
    
    public String getFecha_contratacion() {
        return fecha_contratacion;
    }
    
}//Fin Clase
