package Objetos;


/**
 * Programa: Empleados
 * @author Adrián Urbano Gómez
 *          Emilio García Barroso
 *          Miguel Ángel Hita Acebedo
 */
public class departJefe {
    //Atributos
    private String dept_no;
    private int emp_no;
    private String fecha_desde;
    private String fecha_hasta;
    //Constructores
    public departJefe(String pDept_no,int pEmp_no,String pFechaDesde, String pFechaHasta){
        setDept_no(pDept_no);
        setEmp_no(pEmp_no);
        setFecha_hasta(pFechaHasta);
        setFecha_desde(pFechaDesde);
    }
    //Metodos
    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }
    
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    
    public void setFecha_hasta(String fechaHasta) {
        this.fecha_hasta = fechaHasta;
    }
    
    public void setFecha_desde(String fechaDesde) {
        this.fecha_desde = fechaDesde;
    }
    
    public String getDept_no() {
        return dept_no;
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
}
