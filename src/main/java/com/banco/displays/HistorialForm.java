/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.configPaginado.ConfiguracionPaginado;
import com.banco.dominio.Cliente;
import com.banco.dominio.Transaccion;
import com.banco.implementaciones.ClienteDAO;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.ICuentaDAO;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistorialForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;
    private final ICuentaDAO cuentaDAO;
    private Cliente cliente;
    private ConfiguracionPaginado configPaginado;

    public HistorialForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO, Cliente cliente) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        this.cliente = cliente;
        initComponents();

        cuentaDAO.mostrarCuentasDeClienteEnComboBox(cliente.getId(), jComboBox2);
        cargarTablaTransacciones();

    }

    private void cargarTablaTransacciones() {
        try {
            String idCuenta = jComboBox2.getSelectedItem().toString();
            String id = idCuenta.substring(0, 1);

            List<Transaccion> listaClientes = this.cuentaDAO.consultarTransferencias(this.configPaginado, Integer.parseInt(id));
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaHistorial.getModel();
            modeloTabla.setRowCount(0);
            for (Transaccion trans : listaClientes) {
                Object[] fila = {trans.getIdCliente(), trans.getTipo(), trans.getMonto(), trans.getFecha()};
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    private void avanzarPagina(){
        this.configPaginado.avanzarPagina();
        this.cargarTablaTransacciones();
    }

    private void retrocederPagina(){
        this.configPaginado.retrocederPagina();
        this.cargarTablaTransacciones();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        regresarBT = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        regresarBT1 = new javax.swing.JButton();
        retrocederBT = new javax.swing.JButton();
        avanzarBT = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Historial");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setText("Tipo de Operación");

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo de Operación", "Cantidad", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaHistorial);

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setText("Tu Historial");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transferencia", "Retirso sin cuenta" }));

        regresarBT.setText("Regresar");
        regresarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setText("Tus cuentas");

        regresarBT1.setText("Aceptar");
        regresarBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBT1ActionPerformed(evt);
            }
        });

        retrocederBT.setText("<Retroceder");
        retrocederBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrocederBTActionPerformed(evt);
            }
        });

        avanzarBT.setText("Avanzar >");
        avanzarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarBTActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(regresarBT)
                .addGap(151, 151, 151)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(125, 125, 125)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(retrocederBT)
                                .addGap(127, 127, 127)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avanzarBT))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(193, 193, 193))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(regresarBT1)
                                .addGap(142, 142, 142)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(regresarBT)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(regresarBT1)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retrocederBT)
                    .addComponent(avanzarBT)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBTActionPerformed
        // TODO add your handling code here:
        dispose();
        if(cliente != null){
        new InicioForm(clientesDAO, cuentaDAO, cliente).setVisible(true);    
        }else{
            new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
        }
        
    }//GEN-LAST:event_regresarBTActionPerformed

    private void regresarBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBT1ActionPerformed
        cargarTablaTransacciones();
    }//GEN-LAST:event_regresarBT1ActionPerformed

    private void retrocederBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrocederBTActionPerformed
        // TODO add your handling code here:
        avanzarPagina();
    }//GEN-LAST:event_retrocederBTActionPerformed

    private void avanzarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarBTActionPerformed
        // TODO add your handling code here:
        retrocederPagina();
    }//GEN-LAST:event_avanzarBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avanzarBT;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresarBT;
    private javax.swing.JButton regresarBT1;
    private javax.swing.JButton retrocederBT;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
