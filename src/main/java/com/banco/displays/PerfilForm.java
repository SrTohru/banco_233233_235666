/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cuenta;
import com.banco.interfaces.IClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PerfilForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;

    /**
     * Creates new form PerfilForm
     */
    public PerfilForm(IClienteDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
        initComponents();
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        registrarCuentaDAO = new javax.swing.JButton();
        hacerDepositoBT = new javax.swing.JButton();
        actualizarClienteBT = new javax.swing.JButton();
        historialBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Tu Perfil");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setText("Saldo");

        registrarCuentaDAO.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        registrarCuentaDAO.setText("Registrar Cuenta");
        registrarCuentaDAO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarCuentaDAOActionPerformed(evt);
            }
        });

        hacerDepositoBT.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        hacerDepositoBT.setText("Hacer Deposito");
        hacerDepositoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerDepositoBTActionPerformed(evt);
            }
        });

        actualizarClienteBT.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        actualizarClienteBT.setText("Actualizar Información");
        actualizarClienteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarClienteBTActionPerformed(evt);
            }
        });

        historialBT.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        historialBT.setText("Tu Historial");
        historialBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)))
                .addGap(235, 235, 235))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hacerDepositoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historialBT, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrarCuentaDAO, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarClienteBT))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarClienteBT)
                    .addComponent(historialBT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarCuentaDAO)
                    .addComponent(hacerDepositoBT))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void historialBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialBTActionPerformed
        // TODO add your handling code here:
        dispose();
        new HistorialForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_historialBTActionPerformed

    private void hacerDepositoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hacerDepositoBTActionPerformed
        // TODO add your handling code here:
        dispose();
      //  new DepositoForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_hacerDepositoBTActionPerformed

    private void actualizarClienteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarClienteBTActionPerformed
        // TODO add your handling code here:
        dispose();
        new ActualizarClienteForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_actualizarClienteBTActionPerformed

    private void registrarCuentaDAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarCuentaDAOActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_registrarCuentaDAOActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarClienteBT;
    private javax.swing.JButton hacerDepositoBT;
    private javax.swing.JButton historialBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton registrarCuentaDAO;
    // End of variables declaration//GEN-END:variables
}
