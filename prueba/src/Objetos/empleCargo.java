package Objetos;


/**
 * Programa: Empleados
 * @author Adrián Urbano Gómez
 *          Emilio García Barroso
 *          Miguel Ángel Hita Acebedo
 */
public class empleCargo {
    //Atributos
    private int emp_no;
    private String cargo;
    private String fecha_desde;
    private String fecha_hasta;
    
    //Constructores
    public empleCargo(int pEmp_no,String pCargo, String pFechaDesde,String pFechaHasta){
        setEmp_no(pEmp_no);
        setCargo(pCargo);
        setFecha_hasta(pFechaHasta);
        setFecha_desde(pFechaDesde);
    }
    //Metodos
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    
    public void setCargo(String Cargo) {
        this.cargo = Cargo;
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
    
    public String getCargo() {
        return cargo;
    }
    
    public String getFecha_hasta() {
        return fecha_hasta;
    }
    
    public String getFecha_desde() {
        return fecha_desde;
    }
}
