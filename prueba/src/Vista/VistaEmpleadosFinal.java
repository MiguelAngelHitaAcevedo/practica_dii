package Vista;
//Imports de los componentes que se van ha usar en la vista
import Controlador.ControladorEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class VistaEmpleadosFinal extends JFrame implements WindowListener {
    private JComboBox buscaCampo;
    private JTable tablaEmpleados;
    private ControladorEmpleados ce;
    //Cuadros de dailogo
    private JTextField textFieldBuscar;
    private JTextField textFieldCodigoEmpleado;
    private JTextField textFieldNombreEmpleado;
    private JTextField textFieldApellidoEmpleado;
    private JTextField textFieldFechaEmpleado;
    private JTextField textFieldSexoEmpleado;
    private JTextField textFieldFechaContratacionEmpleado;
    
    
    public String gettextFieldBuscar() {
        return textFieldBuscar.getText();
    }

    public String gettextFieldCodigoEmpleado() {
        String mensaje = "";
        try{
            mensaje = textFieldCodigoEmpleado.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldNombreEmpleado() {
        String mensaje = "";
        try{
            mensaje = textFieldNombreEmpleado.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldApellidoEmpleado() {
        String mensaje = "";
        try{
            mensaje = textFieldApellidoEmpleado.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldFechaEmpleado() {
        String mensaje = "";
        try{
            mensaje = textFieldFechaEmpleado.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldSexoEmpleado() {
        String mensaje = "";
        try{
            mensaje = textFieldSexoEmpleado.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldFechaContratacionEmpleado() {
        String mensaje = "";
        try{
            mensaje = textFieldFechaContratacionEmpleado.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }
    
    public VistaEmpleadosFinal() {
        initComponents();
        settablaEmpleados(ce.getTablaModelo());
    }
    
    public void settablaEmpleados(String[][] dataVector){
        tablaEmpleados.setModel(new DefaultTableModel(dataVector
                , new String[]{"Emp_No", "Nombre", "Apellidos", "Fecha_nac", "Sexo", "Fecha_Contratacion"}));
    }
    
    public String desplegable(){//devuelve el seleccionado en el desplegable
        return buscaCampo.getSelectedItem().toString();
    }
    
    @SuppressWarnings("unchecked")                   
    private void initComponents() {
        //Entorno
        //Creación e instaciación de los componentes de nuestra vista
        addWindowListener(this);
        JButton Buscar = new JButton();
        JButton Aniadir = new JButton();
        JButton Modificar = new JButton();
        JButton Borrar = new JButton();
        buscaCampo = new JComboBox();
        JLabel LabelBuscar = new JLabel();
        JLabel LabelCodEmpleado = new JLabel();
        JLabel LabelNombreEmple = new JLabel();
        JLabel LabelApellidoEmple = new JLabel();
        JLabel LabelFechaNacEmple = new JLabel();
        JLabel LabelSexoEmple = new JLabel();
        JLabel LabelFechaContratacionEmple = new JLabel();
        JMenu selectVista = new JMenu();
        JMenuBar BarraDeMenu = new JMenuBar();
        JPanel PanelVista = new JPanel();
        JScrollPane ScrollTabla = new JScrollPane();
        JSeparator SeparadorTop = new JSeparator();
        JSeparator SeparadorBottom = new JSeparator();
        JSeparator SeparadorEzkerra = new JSeparator();
        JSeparator SeparadorDerecha = new JSeparator();
        tablaEmpleados = new JTable();
        textFieldBuscar = new JTextField();
         textFieldCodigoEmpleado = new JTextField();
         textFieldNombreEmpleado = new JTextField();
         textFieldApellidoEmpleado = new JTextField();
         textFieldFechaEmpleado = new JTextField();
         textFieldSexoEmpleado = new JTextField();
         textFieldFechaContratacionEmpleado = new JTextField();
        JMenuItem vistaEmple = new JMenuItem();
        JMenuItem vistaDepart = new JMenuItem();
        JMenuItem vistaEmpleDepart = new JMenuItem();
        JMenuItem vistaJefeDepart = new JMenuItem();
        JMenuItem vistaSalariosEmple = new JMenuItem();
        JMenuItem vistaCargosEmple = new JMenuItem();
        JMenuItem salir = new JMenuItem();
        JLabel mensaje = new JLabel();
        //Algoritmo
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        tablaEmpleados.setModel(new DefaultTableModel(
                new Object[][]{
            {null, null, null, null, null, null}
        },
                new String[]{
            "Emp_No", "Nombre", "Apellidos", "Fecha_nac", "Sexo", "Fecha_Contratacion"
        }));
        ScrollTabla.setViewportView(tablaEmpleados);
        //Seteo Horizontal del layout de la vista
        GroupLayout LayoutPanelPrincipal = new GroupLayout(PanelVista);
        PanelVista.setLayout(LayoutPanelPrincipal);
        LayoutPanelPrincipal.setHorizontalGroup(
                LayoutPanelPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(SeparadorBottom, GroupLayout.Alignment.TRAILING)
                .addComponent(ScrollTabla));
        //Seteo Vertical del layout de la vista
        LayoutPanelPrincipal.setVerticalGroup(
                LayoutPanelPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(LayoutPanelPrincipal.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollTabla, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeparadorBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
       
        SeparadorEzkerra.setOrientation(SwingConstants.VERTICAL);
        SeparadorDerecha.setOrientation(SwingConstants.VERTICAL);
        //Seteo menu
        selectVista.setText("Selec. Vista");
        BarraDeMenu.add(selectVista);
        setJMenuBar(BarraDeMenu);
        
        
        
        //Busqueda de datos
        LabelBuscar.setText("Buscar por: ");
        //Adicion de los campos del ComboBox
        buscaCampo.setModel(new DefaultComboBoxModel(new String[]{"Código Empleado", "Nombre", "Apellido", "fecha_nac", "sexo","fecha_contratacion"}));
        
        
        ce = new ControladorEmpleados(this);//Referencia al controlador
        
        
        textFieldBuscar.addActionListener(ce);
        //seteo Labels de los campos para rellenar
        LabelCodEmpleado.setText("Codigo Empleado");
        LabelNombreEmple.setText("Nombre");
        LabelApellidoEmple.setText("Apellido");
        LabelFechaNacEmple.setText("Fecha");
        LabelSexoEmple.setText("Sexo");
        LabelFechaContratacionEmple.setText("Fecha_Contratacion");
        textFieldCodigoEmpleado.addActionListener(ce);
        //Seteo de los botones y su funcionalidad
        Buscar.setText("BUSCAR");
        Buscar.addActionListener(ce);
        Aniadir.setText("Añadir");
        Aniadir.addActionListener(ce);
        Modificar.setText("Modificar");
        Modificar.addActionListener(ce);
        Borrar.setText("Eliminar");
        Borrar.addActionListener(ce);
        //Seteo del menú, Adicion de los items (vistas) al desplegable
        selectVista.setText("Selec. Vista");

        vistaEmple.setText("Vista Empleados");
        selectVista.add(vistaEmple);
        vistaEmple.addActionListener(ce);

        vistaDepart.setText("Vista Depart");
        selectVista.add(vistaDepart);
        vistaDepart.addActionListener(ce);

        vistaEmpleDepart.setText("Vista Emple-Depart");
        selectVista.add(vistaEmpleDepart);
        vistaEmpleDepart.addActionListener(ce);

        vistaJefeDepart.setText("Vista Jefe-Depart");
        selectVista.add(vistaJefeDepart);
        vistaJefeDepart.addActionListener(ce);

        vistaSalariosEmple.setText("Vista Salarios-Emple");
        selectVista.add(vistaSalariosEmple);
        vistaSalariosEmple.addActionListener(ce);

        vistaCargosEmple.setText("Vista Cargos-Emple");
        selectVista.add(vistaCargosEmple);
        vistaCargosEmple.addActionListener(ce);

        BarraDeMenu.add(selectVista);

        setJMenuBar(BarraDeMenu);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        //Seteo horizontal del panel (poner bonito los componentes del panel horizontalmente (de izquierda a derecha))
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(PanelVista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(SeparadorTop)
                .addGroup(layout.createSequentialGroup()
                .addComponent(SeparadorDerecha, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelBuscar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(buscaCampo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(LabelNombreEmple, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelCodEmpleado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelApellidoEmple, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelFechaNacEmple, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelFechaContratacionEmple, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelSexoEmple, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(textFieldFechaContratacionEmpleado, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addComponent(textFieldSexoEmpleado, GroupLayout.Alignment.LEADING)
                .addComponent(textFieldFechaEmpleado, GroupLayout.Alignment.LEADING)
                .addComponent(textFieldApellidoEmpleado, GroupLayout.Alignment.LEADING)
                .addComponent(textFieldNombreEmpleado, GroupLayout.Alignment.LEADING)
                .addComponent(textFieldCodigoEmpleado, GroupLayout.Alignment.LEADING)
                .addComponent(textFieldBuscar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Buscar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addComponent(Aniadir, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addComponent(Modificar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addComponent(Borrar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 106, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addComponent(SeparadorEzkerra, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))));
        //Seteo vertical de los componentes del panel (donde van ha caer los componentes si miramos el panel pixel a pixel de arriba a abajo)
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelVista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(SeparadorEzkerra, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(SeparadorDerecha, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(LabelBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(buscaCampo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(Buscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Aniadir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(LabelCodEmpleado)
                .addComponent(textFieldCodigoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNombreEmple, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
                .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textFieldNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Modificar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelApellidoEmple, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(textFieldApellidoEmpleado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
                .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(LabelFechaNacEmple, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(textFieldFechaEmpleado, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(LabelSexoEmple, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelFechaContratacionEmple, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(Borrar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(textFieldSexoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(textFieldFechaContratacionEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparadorTop, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)));
        pack();
    }   
    //Cambio de vistas
    public void vistaEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new Vista.VistaEmpleadosFinal().setVisible(true);
        
    }
    public void vistaDepartActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaDepartamentosFinal().setVisible(true);
        
    }
    public void vistaEmpleDepartActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaEmpleDepart().setVisible(true);
        
    }
    public void vistaJefeDepartActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaJefeDepart().setVisible(true);
        
    }
    public void vistaSalariosEmpleActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new Vista.VistaSalarios().setVisible(true);
        
    }
    public void vistaCargosEmpleActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new Vista.VistaCargos().setVisible(true);
        
    } 

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            //Lanzar la vista 
            public void run() {
                new VistaEmpleadosFinal().setVisible(true);
            }
        });
    }

    @Override
    public void windowOpened(WindowEvent e) {
        ce.procesoInicio();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ce.procesoFin();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}