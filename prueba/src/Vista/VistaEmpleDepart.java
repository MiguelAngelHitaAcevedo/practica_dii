
package Vista;

import Controlador.ControladorEmpleDepart;
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

public class VistaEmpleDepart extends javax.swing.JFrame implements WindowListener{

    private JComboBox buscaCampo;
    private JTable tablaEmpleDepart;
    private ControladorEmpleDepart ced;
    //Cuadros de dailogo
    private JTextField textFieldBuscar;
    private JTextField textFieldCodigoEmpleado;
    private JTextField textFieldCodigoDepartamento;
    private JTextField textFieldFecha_desde;
    private JTextField textFieldFecha_hasta;

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

    public String gettextFieldFecha_desde() {
        String mensaje = "";
        try {
            mensaje = textFieldFecha_desde.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    public String gettextFieldFecha_hasta() {
        String mensaje = "";
        try {
            mensaje = textFieldFecha_hasta.getText();
        } catch (NullPointerException npe) {
        }
        return mensaje;
    }

    
    public String desplegable(){//devuelve el seleccionado en el desplegable
        return buscaCampo.getSelectedItem().toString();
    }
    
    public VistaEmpleDepart() {
        initComponents();
        //settablaEmpleDepart(cjd.getTablaModelo());
    }

    public void settablaEmpleDepart(String[][] dataVector) {
        tablaEmpleDepart.setModel(new DefaultTableModel(dataVector,
                 new String[]{"Emp_No", "Dept_no", "Fecha Desde", "Fecha Hasta"}));
    }

    @SuppressWarnings("unchecked")                        
    private void initComponents() {
        addWindowListener(this);
        JPanel jPanel1 = new javax.swing.JPanel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleDepart = new javax.swing.JTable();
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
         textFieldCodigoDepartamento = new javax.swing.JTextField();
         textFieldFecha_desde = new javax.swing.JTextField();
         textFieldFecha_hasta = new javax.swing.JTextField();
        JButton jButton2 = new javax.swing.JButton();
        JButton jButton3 = new javax.swing.JButton();
        JButton jButton4 = new javax.swing.JButton();
        JMenuItem vistaEmple = new JMenuItem();
        JMenuItem vistaDepart = new JMenuItem();
        JMenuItem vistaEmpleDepart = new JMenuItem();
        JMenuItem vistaJefeDepart = new JMenuItem();
        JMenuItem vistaSalariosEmple = new JMenuItem();
        JMenuItem vistaCargosEmple = new JMenuItem();
        JMenu selectVista = new JMenu();
        JMenuBar BarraDeMenu = new JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaEmpleDepart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Emp_No", "Dept_no", "Fecha Desde", "Fecha Hasta"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleDepart);

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
        
        ced = new ControladorEmpleDepart(this);
        
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setText("Buscar por: ");

        buscaCampo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Emp_No", "Dept_no", "Fecha Desde", "Fecha Hasta" }));

        jButton1.addActionListener(ced);
        jButton1.setText("BUSCAR");

        jLabel2.setText("Codigo Empleado");

        jLabel3.setText("Codigo Departamento");

        jLabel4.setText("Fecha Desde");

        jLabel5.setText("Fecha Hasta");

        jButton2.addActionListener(ced);
        jButton2.setText("Añadir");

        jButton3.addActionListener(ced);
        jButton3.setText("Modificar");

        jButton4.addActionListener(ced);
        jButton4.setText("Eliminar");

        //Seteo del menú, Adicion de los items (vistas) al desplegable
        selectVista.setText("Selec. Vista");

        vistaEmple.setText("Vista Empleados");
        selectVista.add(vistaEmple);
        vistaEmple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaEmpleActionPerformed(evt);
            }
        });

        vistaDepart.setText("Vista Depart");
        selectVista.add(vistaDepart);
        vistaDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaDepartActionPerformed(evt);
            }
        });

        vistaEmpleDepart.setText("Vista Emple-Depart");
        selectVista.add(vistaEmpleDepart);
        vistaEmpleDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaEmpleDepartActionPerformed(evt);
            }
        });

        vistaJefeDepart.setText("Vista Jefe-Depart");
        selectVista.add(vistaJefeDepart);
        vistaJefeDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaJefeDepartActionPerformed(evt);
            }
        });

        vistaSalariosEmple.setText("Vista Salarios-Emple");
        selectVista.add(vistaSalariosEmple);
        vistaSalariosEmple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaSalariosEmpleActionPerformed(evt);
            }
        });

        vistaCargosEmple.setText("Vista Cargos-Emple");
        selectVista.add(vistaCargosEmple);
        vistaCargosEmple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaCargosEmpleActionPerformed(evt);
            }
        });

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
                                    .addComponent(textFieldCodigoDepartamento)
                                    .addComponent(textFieldCodigoEmpleado)
                                    .addComponent(textFieldBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(textFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(7, 7, 7))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(textFieldCodigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        new Vista.VistaSalarios().setVisible(true);
        
    }
    public void vistaCargosEmpleActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
        new Vista.VistaCargos().setVisible(true);
        
    }
    
    public static void main(String args[]) {
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
                new VistaEmpleDepart().setVisible(true);
            }
        });
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        ced.procesoInicio();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ced.procesoFin();
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
