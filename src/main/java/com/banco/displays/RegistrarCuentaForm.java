/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.implementaciones.ClienteDAO;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.ICuentaDAO;
import javax.swing.JOptionPane;

public class RegistrarCuentaForm extends javax.swing.JFrame {

    private final Cliente cliente;
    private final ICuentaDAO cuentaDAO;

    public RegistrarCuentaForm(Cliente cliente, ICuentaDAO cuentaDAO) {
        this.cliente = cliente;
        this.cuentaDAO = cuentaDAO;
        initComponents();
    }

    public boolean isInformationsRequiered() {
        if (usuarioTF.getText().equalsIgnoreCase("")
                || jPasswordField1.getText().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    private Cuenta extraerDatosFormularioUsuario() {
        String usuario = this.usuarioTF.getText();
        String contraseña = this.jPasswordField1.getText();
        Cuenta cuenta = new Cuenta(usuario, contraseña);
        return cuenta;
    }

    private void mostrarMensajeCuentaCreada(Cuenta cuenta) {
        JOptionPane.showMessageDialog(this, "se agregó la cuenta: " + cuenta.getId(),
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeErrorCrearCuenta() {
        JOptionPane.showMessageDialog(this, "No fue posible agregar la cuenta", "Error", JOptionPane.OK_OPTION);

    }

    private Cuenta registrarCuenta() {

        try {
            Cuenta cuenta = this.extraerDatosFormularioUsuario();

            Cuenta clienteGuardado = this.cuentaDAO.crear(cuenta, cliente);
            this.mostrarMensajeCuentaCreada(clienteGuardado);
            return clienteGuardado;
        } catch (Exception e) {
            this.mostrarMensajeErrorCrearCuenta();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usuarioTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aceptarBT = new javax.swing.JButton();
        cancelarBT = new javax.swing.JButton();
        regresarBT = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Registra una Cuenta");

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel2.setText("Constraseña:");

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel3.setText("Usuario:");

        aceptarBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        aceptarBT.setText("Aceptar");
        aceptarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBTActionPerformed(evt);
            }
        });

        cancelarBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        cancelarBT.setText("Cancelar");
        cancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBTActionPerformed(evt);
            }
        });

        regresarBT.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        regresarBT.setText("Regresar");
        regresarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBTActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(aceptarBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(cancelarBT)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(regresarBT)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuarioTF)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(regresarBT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBT)
                    .addComponent(cancelarBT))
                .addGap(54, 54, 54))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarBTActionPerformed

    private void aceptarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBTActionPerformed
        registrarCuenta();
    }//GEN-LAST:event_aceptarBTActionPerformed

    private void cancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarBTActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBT;
    private javax.swing.JButton cancelarBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton regresarBT;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
}
