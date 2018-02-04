
package Vista;

import Controlador.ControladorCargos;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import Controlador.*;
public class VistaCargos extends javax.swing.JFrame implements WindowListener{

    private JComboBox buscaCampo;
    private JTable tablaCargos;
    private ControladorCargos cc;
    //Cuadros de dailogo
    private JTextField textFieldBuscar;
    private JTextField textFieldCodigoEmpleado;//emp_no
    private JTextField textFieldCargo;//Cargo
    private JTextField textFieldFecha_desde;//Fecha_desde
    private JTextField textFieldFecha_hasta;//Fecha_hasta
    
    
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

    public String gettextFieldCargo() {
        String mensaje = "";
        try{
            mensaje = textFieldCargo.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldFecha_desde() {
        String mensaje = "";
        try{
            mensaje = textFieldFecha_desde.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }

    public String gettextFieldFecha_hasta() {
        String mensaje = "";
        try{
            mensaje = textFieldFecha_hasta.getText();
        }catch(NullPointerException npe){
        }
        return mensaje;
    }
    
    public VistaCargos() {
        initComponents();
        //settablaCargos(ce.getTablaModelo());
    }
    
    public void settablaCargos(String[][] dataVector){
        tablaCargos.setModel(new DefaultTableModel(dataVector
                , new String[]{"Emp_No", "Cargo", "Fecha Desde", "Fecha Hasta"}));
    }
    
    public String desplegable(){//devuelve el seleccionado en el desplegable
        return buscaCampo.getSelectedItem().toString();
    }
    

    
    
    @SuppressWarnings("unchecked")                      
    private void initComponents() {
        addWindowListener(this);
        JPanel jPanel1 = new javax.swing.JPanel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JSeparator jSeparator3 = new javax.swing.JSeparator();
        JSeparator jSeparator4 = new javax.swing.JSeparator();
        JLabel jLabel1 = new javax.swing.JLabel();
        buscaCampo = new javax.swing.JComboBox();
        textFieldBuscar = new javax.swing.JTextField();
        JButton jButton1 = new javax.swing.JButton();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        textFieldCodigoEmpleado = new javax.swing.JTextField();
        textFieldCargo = new javax.swing.JTextField();
        textFieldFecha_desde = new javax.swing.JTextField();
        textFieldFecha_hasta = new javax.swing.JTextField();
        JButton aniadir = new javax.swing.JButton();
        JButton modificar = new javax.swing.JButton();
        JButton eliminar = new javax.swing.JButton();
        JMenuItem vistaEmple = new JMenuItem();
        JMenuItem vistaDepart = new JMenuItem();
        JMenuItem vistaEmpleDepart = new JMenuItem();
        JMenuItem vistaJefeDepart = new JMenuItem();
        JMenuItem vistaSalariosEmple = new JMenuItem();
        JMenuItem vistaCargosEmple = new JMenuItem();
        JMenuItem salir = new JMenuItem();
        JMenu selectVista = new JMenu();
        JMenuBar BarraDeMenu = new JMenuBar();
        tablaCargos = new JTable();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Emp_No", "Cargo", "Fecha Desde", "Fecha Hasta"
            }
        ));
        cc = new ControladorCargos(this);
        jScrollPane1.setViewportView(tablaCargos);

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

        jLabel1.setText("Buscar por: ");

        buscaCampo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Emp_No", "Cargo", "Fecha Desde", "Fecha Hasta" }));

        textFieldBuscar.addActionListener(cc);

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(cc);

        jLabel2.setText("Codigo Empleado");

        jLabel3.setText("Cargo");

        jLabel4.setText("Fecha Desde");

        jLabel5.setText("Fecha Hasta");

        textFieldCodigoEmpleado.addActionListener(cc);

        aniadir.setText("Añadir");
        aniadir.addActionListener(cc);

        modificar.setText("Modificar");
        modificar.addActionListener(cc);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(cc);

        //Seteo del menú, Adicion de los items (vistas) al desplegable
        selectVista.setText("Selec. Vista");

        vistaEmple.setText("Vista Empleados");
        selectVista.add(vistaEmple);
        vistaEmple.addActionListener(cc);

        vistaDepart.setText("Vista Depart");
        selectVista.add(vistaDepart);
        vistaDepart.addActionListener(cc);

        vistaEmpleDepart.setText("Vista Emple-Depart");
        selectVista.add(vistaEmpleDepart);
        vistaEmpleDepart.addActionListener(cc);

        vistaJefeDepart.setText("Vista Jefe-Depart");
        selectVista.add(vistaJefeDepart);
        vistaJefeDepart.addActionListener(cc);

        vistaSalariosEmple.setText("Vista Salarios-Emple");
        selectVista.add(vistaSalariosEmple);
        vistaSalariosEmple.addActionListener(cc);

        vistaCargosEmple.setText("Vista Cargos-Emple");
        selectVista.add(vistaCargosEmple);
        vistaCargosEmple.addActionListener(cc);

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
                                    .addComponent(buscaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldFecha_hasta)
                                    .addComponent(textFieldFecha_desde)
                                    .addComponent(textFieldCargo)
                                    .addComponent(textFieldCodigoEmpleado)
                                    .addComponent(textFieldBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                .addComponent(buscaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addComponent(aniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(textFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(7, 7, 7))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(textFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(textFieldFecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(19, 19, 19))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldFecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                       
    
    //Cambio de vistas
    public void vistaEmpleActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
        new VistaSalarios().setVisible(true);
        
    }
    public void vistaCargosEmpleActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new Vista.VistaCargos().setVisible(true);
        
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
                new VistaCargos().setVisible(true);
            }
        });
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        cc.procesoInicio();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("hace el cierre bien");
        cc.procesoFin();
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
