package Modelo;


import java.util.LinkedList;

//Esta clase va a almacenar las claves primarias de departamentos.dat
//para asegurarse que se mantiene la integridad referencial
public class keyDepartamentos {
    public static LinkedList<String> keyDept_no = new LinkedList<String>();
    public static boolean encuentraDepartamento(String dept_noBusca){
        int i=0;
        while(i<keyDept_no.size() && !keyDept_no.get(i).equalsIgnoreCase(dept_noBusca)){
            i++;//Mientras no lo encuentre sigue buscando
        }
        return !keyDept_no.get(i).equalsIgnoreCase(dept_noBusca);
    }
}
