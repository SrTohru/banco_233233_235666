/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.interfaces.IClienteDAO;

/**
 *
 * @author PC
 */
public class InicioForm extends javax.swing.JFrame {

    /**
     * Creates new form InicioForm
     */    private final IClienteDAO clientesDAO;
//TEST
 //TEST//TESTD
     //TESTASDA
 //TEST//ASDASD//TESTASDASAS
     
    public InicioForm(IClienteDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inicioSesionBT = new javax.swing.JButton();
        registroBT = new javax.swing.JButton();
        historialBT = new javax.swing.JButton();
        depositoBT = new javax.swing.JButton();
        actualizaClienteBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Inicio");

        inicioSesionBT.setText("Iniciar sesion");
        inicioSesionBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesionBTActionPerformed(evt);
            }
        });

        registroBT.setText("Registro");
        registroBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBTActionPerformed(evt);
            }
        });

        historialBT.setText("Historial");

        depositoBT.setText("Deposito");
        depositoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositoBTActionPerformed(evt);
            }
        });

        actualizaClienteBT.setText("Actualizar cliente");
        actualizaClienteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaClienteBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(depositoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(actualizaClienteBT)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inicioSesionBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historialBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizaClienteBT)
                    .addComponent(inicioSesionBT)
                    .addComponent(historialBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registroBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depositoBT)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioSesionBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioSesionBTActionPerformed
        new LoginForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_inicioSesionBTActionPerformed

    private void registroBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBTActionPerformed
         new RegistroForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_registroBTActionPerformed

    private void depositoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositoBTActionPerformed
        new DepositoForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_depositoBTActionPerformed

    private void actualizaClienteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaClienteBTActionPerformed
        new ActualizarClienteForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_actualizaClienteBTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizaClienteBT;
    private javax.swing.JButton depositoBT;
    private javax.swing.JButton historialBT;
    private javax.swing.JButton inicioSesionBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton registroBT;
    // End of variables declaration//GEN-END:variables
}
