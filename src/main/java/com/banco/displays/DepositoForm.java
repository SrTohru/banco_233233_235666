/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.ICuentaDAO;

/**
 *
 * @author Usuario
 */
public class DepositoForm extends javax.swing.JFrame {

   private final IClienteDAO clientesDAO;
   private final ICuentaDAO cuentaDAO;
   
   private Cliente cliente;
   private Cuenta cuenta; 
   
    public DepositoForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO, Cliente cliente, Cuenta cuenta) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        this.cliente = cliente;
        this.cuenta = cuenta;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositarBT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cantidadTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idCuentaDestinoTF = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        depositarBT1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        depositarBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        depositarBT.setText("Depositar");
        depositarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarBTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setText("Cantidad");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setText("Deposito");

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setText("Tu Saldo:");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setText("Id Cuenta Destino");

        jTextField1.setEditable(false);

        depositarBT1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        depositarBT1.setText("Cancelar");
        depositarBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarBT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cantidadTF, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(idCuentaDestinoTF)
                            .addComponent(jTextField1))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(depositarBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(depositarBT1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idCuentaDestinoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cantidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(depositarBT)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(depositarBT1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void depositarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarBTActionPerformed
       
    }//GEN-LAST:event_depositarBTActionPerformed

    private void depositarBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarBT1ActionPerformed
        dispose();
    }//GEN-LAST:event_depositarBT1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidadTF;
    private javax.swing.JButton depositarBT;
    private javax.swing.JButton depositarBT1;
    private javax.swing.JTextField idCuentaDestinoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
