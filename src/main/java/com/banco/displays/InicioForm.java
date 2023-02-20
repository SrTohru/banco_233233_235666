/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.ICuentaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class InicioForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;
    private final ICuentaDAO cuentaDAO;

    private Cliente cliente;
    private Cuenta cuenta;

    public InicioForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;

        initComponents();
    }

    public InicioForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO, Cliente cliente, Cuenta cuenta) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        this.cliente = cliente;
        this.cuenta = cuenta;

        initComponents();
    }

    private void mostrarErrorDeposito() {
        JOptionPane.showMessageDialog(this, "No se puede realizar un deposito sin haber iniciado sesion",
                "Información ", JOptionPane.INFORMATION_MESSAGE);
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

        inicioSesionBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inicioSesionBT.setText("Iniciar sesion");
        inicioSesionBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesionBTActionPerformed(evt);
            }
        });

        registroBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registroBT.setText("Registro");
        registroBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBTActionPerformed(evt);
            }
        });

        historialBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        historialBT.setText("Historial");
        historialBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialBTActionPerformed(evt);
            }
        });

        depositoBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        depositoBT.setText("Deposito");
        depositoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositoBTActionPerformed(evt);
            }
        });

        actualizaClienteBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(actualizaClienteBT)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inicioSesionBT)
                                .addGap(27, 27, 27)
                                .addComponent(historialBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(depositoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registroBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizaClienteBT)
                    .addComponent(inicioSesionBT)
                    .addComponent(historialBT))
                .addGap(18, 18, 18)
                .addComponent(registroBT)
                .addGap(18, 18, 18)
                .addComponent(depositoBT)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inicioSesionBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioSesionBTActionPerformed
        dispose();
        new LoginForm(clientesDAO, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_inicioSesionBTActionPerformed

    private void registroBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBTActionPerformed
        dispose();
        new RegistroClienteForm(clientesDAO, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_registroBTActionPerformed

    private void depositoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositoBTActionPerformed

        if (cliente != null && cuenta != null) {
            new DepositoForm(clientesDAO, cuentaDAO, cliente, cuenta).setVisible(true);
            dispose();
        } else {
            mostrarErrorDeposito();
        }


    }//GEN-LAST:event_depositoBTActionPerformed

    private void actualizaClienteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaClienteBTActionPerformed
        new ActualizarClienteForm(clientesDAO).setVisible(true);
    }//GEN-LAST:event_actualizaClienteBTActionPerformed

    private void historialBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialBTActionPerformed
        // TODO add your handling code here:
        dispose();
           if (cliente != null && cuenta != null) {
            new HistorialForm(clientesDAO).setVisible(true);
            dispose();
        } else {
            mostrarErrorDeposito();
        }
    }//GEN-LAST:event_historialBTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizaClienteBT;
    private javax.swing.JButton depositoBT;
    private javax.swing.JButton historialBT;
    private javax.swing.JButton inicioSesionBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton registroBT;
    // End of variables declaration//GEN-END:variables
}
