package Modelo;


import java.util.LinkedList;

//Esta clase va a almacenar las claves primarias de empleados.dat
//para asegurarse que se mantiene la integridad referencial
public class keyEmpleados {
    public static LinkedList<Integer> keyEmp_no = new LinkedList<Integer>();
    public static boolean encuentraEmpleado(int emp_noBusca){
        int i=0;
        while(i<keyEmp_no.size() && !keyEmp_no.get(i).equals(emp_noBusca)){
            System.out.println("--"+keyEmp_no.get(i));
            i++;//Mientras no lo encuentre sigue buscando
        }
        return (keyEmp_no.size()>0 && keyEmp_no.get(i)==emp_noBusca);
    }
}
