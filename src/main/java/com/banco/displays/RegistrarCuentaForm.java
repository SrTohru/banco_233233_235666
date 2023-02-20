/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
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
        return (aliasTF.getText().equalsIgnoreCase(""));
    }

    private Cuenta extraerDatosFormularioUsuario() {
        String alias = this.aliasTF.getText();
        Cuenta cuenta = new Cuenta(cliente.getId(), alias);
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

            Cuenta cuentaGuardada = this.cuentaDAO.crear(cuenta, cliente);
            this.mostrarMensajeCuentaCreada(cuentaGuardada);
            return cuentaGuardada;
        } catch (Exception e) {
            this.mostrarMensajeErrorCrearCuenta();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        aliasTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        aceptarBT = new javax.swing.JButton();
        cancelarBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Registra una Cuenta");

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel3.setText("Alias:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aceptarBT)
                .addGap(75, 75, 75)
                .addComponent(cancelarBT)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aliasTF, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aliasTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBT)
                    .addComponent(aceptarBT))
                .addGap(151, 151, 151))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBTActionPerformed
        Cuenta c = registrarCuenta();
        
        if(c != null){
            dispose();
        }
    }//GEN-LAST:event_aceptarBTActionPerformed

    private void cancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTActionPerformed
        // TODO add your handling code here:
        dispose();
         new InicioForm(null, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_cancelarBTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBT;
    private javax.swing.JTextField aliasTF;
    private javax.swing.JButton cancelarBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
