package Vista;

import Vista.VistaJefeDepart;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorSalarios;

public class VistaSalarios extends JFrame implements WindowListener {
    private JComboBox jComboBox1;
    private JTable tablaSalarios;
    private ControladorSalarios ce;
    //Cuadros de dailogo
    private JTextField textFieldBuscar;
    private JTextField textFieldCodigoEmpleado;
    private JTextField textFieldSalario;
    private JTextField textFieldFecha_Desde;
    private JTextField textFieldFecha_Hasta;

    public String gettextFieldBuscar() {
        return textFieldBuscar.getText();
    }

    public String gettextFieldCodigoEmpleado() {
        String mensaje = "";
        try {
            mensaje = textFieldCodigoEmpleado.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public String gettextFieldSalario() {
        String mensaje = "";
        try {
            mensaje = textFieldSalario.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public String gettextFieldFecha_Desde() {
        String mensaje = "";
        try {
            mensaje = textFieldFecha_Desde.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public String gettextFieldFecha_Hasta() {
        String mensaje = "";
        try {
            mensaje = textFieldFecha_Hasta.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public VistaSalarios() {
        initComponents();
        settablaSalarios(ce.getTablaModelo());
    }

    public DefaultTableModel gettablaSalarios() {
        return (DefaultTableModel) tablaSalarios.getModel();
    }

    public void settablaSalarios(String[][] dataVector) {
        tablaSalarios.setModel(new DefaultTableModel(dataVector,
                new String[]{"Emp_No", "Fecha_Desde", "Salario", "Fecha_Hasta"}));
    }


    public String desplegable() {//devuelve el seleccionado en el desplegable
        return jComboBox1.getSelectedItem().toString();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        addWindowListener(this);
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        tablaSalarios = new JTable();
        JSeparator jSeparator2 = new JSeparator();
        JSeparator jSeparator1 = new JSeparator();
        JSeparator jSeparator3 = new JSeparator();
        JSeparator jSeparator4 = new JSeparator();
        JLabel jLabel1 = new JLabel();
        jComboBox1 = new JComboBox();
        textFieldBuscar = new JTextField();
        JButton botonBuscar = new JButton();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        textFieldCodigoEmpleado = new JTextField();
        textFieldSalario = new JTextField();
        textFieldFecha_Desde = new JTextField();
        textFieldFecha_Hasta = new JTextField();
        JButton botonAniadir = new JButton();
        JButton botonModificar = new JButton();
        JButton botonBorrar = new JButton();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenuItem jMenuItem1 = new JMenuItem();
        JMenuItem vistaEmple = new JMenuItem();
        JMenuItem vistaDepart = new JMenuItem();
        JMenuItem vistaEmpleDepart = new JMenuItem();
        JMenuItem vistaJefeDepart = new JMenuItem();
        JMenuItem vistaSalariosEmple = new JMenuItem();
        JMenuItem vistaCargosEmple = new JMenuItem();
        JMenuItem salir = new JMenuItem();
        JMenu selectVista = new JMenu();
        JMenuBar BarraDeMenu = new JMenuBar();
        JLabel mensaje = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaSalarios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null}
                },
                new String[]{
                    "Emp_No", "Fecha Desde", "Salario", "Fecha Hasta"
                }
        ));
        jScrollPane1.setViewportView(tablaSalarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        //Seteo menu
        selectVista.setText("Selec. Vista");
        BarraDeMenu.add(selectVista);
        setJMenuBar(BarraDeMenu);

        jLabel1.setText("Buscar por: ");
        //Adicion de los campos del ComboBox
        jComboBox1.setModel(new DefaultComboBoxModel(new String[]{"Codigo Empleado", "Salario", "Fecha_Desde", "Fecha_Hasta"}));

        ce = new ControladorSalarios(this);//Referencia al controlador
        textFieldBuscar.addActionListener(ce);

        textFieldCodigoEmpleado.addActionListener(ce);
        //Seteo de los botones y su funcionalidad
        botonBuscar.setText("BUSCAR");
        botonBuscar.addActionListener(ce);
        botonAniadir.setText("Añadir");
        botonAniadir.addActionListener(ce);
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(ce);
        botonBorrar.setText("Eliminar");
        botonBorrar.addActionListener(ce);

        jLabel2.setText("Codigo Empleado");
        jLabel3.setText("Salario");
        jLabel4.setText("Fecha Desde");
        jLabel5.setText("Fecha Hasta");

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
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                                .addGap(56, 56, 56)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(textFieldFecha_Hasta)
                                                                        .addComponent(textFieldFecha_Desde)
                                                                        .addComponent(textFieldSalario)
                                                                        .addComponent(textFieldCodigoEmpleado)
                                                                        .addComponent(textFieldBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                                                .addGap(37, 37, 37)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(botonAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 106, Short.MAX_VALUE)))
                                                .addGap(1, 1, 1)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(textFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addGap(19, 19, 19)
                                                                                                        .addComponent(botonAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addComponent(textFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addGap(7, 7, 7))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                                        .addComponent(textFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(20, 20, 20)
                                                                                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                .addGap(9, 9, 9)
                                                                                                .addComponent(textFieldFecha_Desde, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGap(19, 19, 19))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(textFieldFecha_Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(44, 44, 44))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        pack();
    }
    
    //Cambio de vistas
    public void vistaEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        Modelo.modelo.guardarCambios();
         this.dispose();
        new VistaEmpleadosFinal().setVisible(true);
        
    }
    public void vistaDepartActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaDepartamentosFinal().setVisible(true);
        
    }
    public void vistaEmpleDepartActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaEmpleDepart().setVisible(true);
        
    }
    public void vistaJefeDepartActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaJefeDepart().setVisible(true);
        
    }
    public void vistaSalariosEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new Vista.VistaSalarios().setVisible(true);
        
    }
    public void vistaCargosEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaCargos().setVisible(true);
        
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {

        } catch (InstantiationException ex) {

        } catch (IllegalAccessException ex) {

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSalarios().setVisible(true);
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