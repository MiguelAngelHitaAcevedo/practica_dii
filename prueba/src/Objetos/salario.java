package Objetos;


/**
 * Programa: Empleados
 * @author Adrián Urbano Gómez
 *          Emilio García Barroso
 *          Miguel Ángel Hita Acebedo
 */
public class salario {
    //Atributos
    private int emp_no;
    private String fecha_desde;
    private float salario; 
    private String fecha_hasta;
    
    //Constructores
    public salario(int pEmp_no,String pFechaDesde,float pSalario, String pFechaHasta){
        setEmp_no(pEmp_no);
        setSalarios(pSalario);
        setFecha_hasta(pFechaHasta);
        setFecha_desde(pFechaDesde);
    }
    
    //Metodos
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    
    public void setFecha_hasta(String fechaHasta) {
        this.fecha_hasta = fechaHasta;
    }
    
    public void setFecha_desde(String fechaDesde) {
        this.fecha_desde = fechaDesde;
    }
    
    public int getEmp_no() {
        return emp_no;
    }
    
    public String getFecha_hasta() {
        return fecha_hasta;
    }
    
    public String getFecha_desde() {
        return fecha_desde;
    }
    
    public float getSalarios() {
        return salario;
    }
    
    public void setSalarios(float salario) {
        this.salario = salario;
    }
}