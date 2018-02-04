package Vista;

import Controlador.ControladorJefeDepart;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class VistaJefeDepart extends JFrame implements WindowListener {

    private JComboBox buscaCampo;
    private JTable tablaJefeDepart;
    private ControladorJefeDepart ce;
    //Cuadros de dailogo
    private JTextField textFieldBuscar;
    private JTextField textFieldCodigoEmpleado;
    private JTextField textFieldCodigoDepartamento;
    private JTextField textFieldFechaDesde;
    private JTextField textFieldFechaHasta;

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

    public String gettextFieldCodigoDepartamento() {
        String mensaje = "";
        try {
            mensaje = textFieldCodigoDepartamento.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public String gettextFieldFecha_Desde() {
        String mensaje = "";
        try {
            mensaje = textFieldFechaDesde.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public String gettextFieldFecha_Hasta() {
        String mensaje = "";
        try {
            mensaje = textFieldFechaHasta.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public DefaultTableModel gettablaJefeDepart() {
        return (DefaultTableModel) tablaJefeDepart.getModel();
    }

    public void settablaJefeDepart(String[][] dataVector) {
        tablaJefeDepart.setModel(new DefaultTableModel(dataVector, new String[]{"Dept_no", "Emp_no", "Fecha_Desde", "Fecha_Hasta"}));
    }

    public String desplegable() {//devuelve el seleccionado en el desplegable
        return buscaCampo.getSelectedItem().toString();
    }

    public VistaJefeDepart() {
        initComponents();
        settablaJefeDepart(ce.getTablaModelo());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        addWindowListener(this);
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        tablaJefeDepart = new JTable();
        JSeparator jSeparator2 = new JSeparator();
        JSeparator jSeparator1 = new JSeparator();
        JSeparator jSeparator3 = new JSeparator();
        JSeparator jSeparator4 = new JSeparator();
        JLabel labelBuscar = new JLabel();
        buscaCampo = new JComboBox();
        textFieldBuscar = new JTextField();
        JButton botonBuscar = new JButton();
        JLabel labelCodigoEmpleado = new JLabel();
        JLabel labelCodigoDepartamento = new JLabel();
        JLabel labelFechaDesde = new JLabel();
        JLabel labelFechaHasta = new JLabel();
        textFieldCodigoEmpleado = new JTextField();
        textFieldCodigoDepartamento = new JTextField();
        textFieldFechaDesde = new JTextField();
        textFieldFechaHasta = new JTextField();
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

        tablaJefeDepart.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
            {null, null, null, null}
        },
                new String[]{
            "Dept_no", "Emp_no", "Fecha Desde", "Fecha Hasta"
        }));
        jScrollPane1.setViewportView(tablaJefeDepart);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane1));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        //Seteo menu
        selectVista.setText("Selec. Vista");
        BarraDeMenu.add(selectVista);
        setJMenuBar(BarraDeMenu);
        //Busqueda de datos
        labelBuscar.setText("Buscar por: ");
        buscaCampo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Codigo Empleado", "Codigo Departamento", "Fecha_Desde", "Fecha_Hasta"}));

        ce = new ControladorJefeDepart(this);//Referencia al controlador
        //Seteo de los labels
        labelCodigoEmpleado.setText("Codigo Empleado");
        labelCodigoDepartamento.setText("Codigo Departamento");
        labelFechaDesde.setText("Fecha Desde");
        labelFechaHasta.setText("Fecha Hasta");
        //Seteo de los botones
        botonBuscar.setText("BUSCAR");
        botonBuscar.addActionListener(ce);
        botonAniadir.setText("Añadir");
        botonAniadir.addActionListener(ce);
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(ce);
        botonBorrar.setText("Eliminar");
        botonBorrar.addActionListener(ce);
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
                .addComponent(labelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(buscaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(labelCodigoDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelCodigoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(textFieldFechaHasta)
                .addComponent(textFieldFechaDesde)
                .addComponent(textFieldCodigoDepartamento)
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
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))));
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
                .addComponent(labelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buscaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(botonAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelCodigoEmpleado)
                .addComponent(textFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCodigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
                .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textFieldCodigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(textFieldFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
                .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(labelFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textFieldFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>                        

    //Cambio de vistas
    public void vistaEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaEmpleadosFinal().setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
        }
    }

    public void vistaDepartActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaDepartamentosFinal().setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
        }
    }
    public void vistaEmpleDepartActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaEmpleDepart().setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
        }
    }
    public void vistaJefeDepartActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaJefeDepart().setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
        }
    }
    public void vistaSalariosEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaSalarios().setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
        }
    }
    public void vistaCargosEmpleActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new VistaCargos().setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
        }
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
                new VistaJefeDepart().setVisible(true);
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
