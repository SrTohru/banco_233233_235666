/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.implementaciones.ClienteDAO;
import com.banco.interfaces.IClienteDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class RegistroForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;

    public RegistroForm(IClienteDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
        initComponents();
    }

    public boolean isInformationsRequiered() {
        if (nameTF.getText().equalsIgnoreCase("")
                || apellidoTF.getText().equalsIgnoreCase("")
                || apellidoMTF.getText().equalsIgnoreCase("")
                || calleTF.getText().equalsIgnoreCase("")
                || numeroTF.getText().equalsIgnoreCase("")
                || coloniaTF.getText().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
  
    private Cliente extraerDatosFormulario() {
        String nombre = this.nameTF.getText();
        String apellidoPaterno = this.apellidoTF.getText();
        String apellidoMaterno = this.apellidoMTF.getText();
      
        Integer idDireccion = 1; //TODO: CAMBIAR POR VALOR DE COMBO
// FINISH THIS
        Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, idDireccion);
        return cliente;
    }
    
    private void mostrarMensajeClienteGuardado(Cliente clienteGuardado) {
        JOptionPane.showMessageDialog(this, "se agregó el cliente: " + clienteGuardado.getId(),
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }

      private void test(){
        
    }
    
    private void mostrarMensajeErrorClienteGuardado() {
        JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente", "Error", JOptionPane.OK_OPTION);

    }
    private void registrarCliente() {
        try {
            Cliente cliente = this.extraerDatosFormulario();
            Cliente clienteGuardado = this.clientesDAO.registrarse(cliente);
            this.mostrarMensajeClienteGuardado(clienteGuardado);
        } catch (Exception e) {
            this.mostrarMensajeErrorClienteGuardado();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        registerBT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        apellidoTF = new javax.swing.JTextField();
        apellidoMTF = new javax.swing.JTextField();
        fechaNacimientoTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        calleTF = new javax.swing.JTextField();
        numeroTF = new javax.swing.JTextField();
        coloniaTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        regresoBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Registro");

        registerBT.setBackground(new java.awt.Color(255, 255, 255));
        registerBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        registerBT.setForeground(new java.awt.Color(0, 0, 0));
        registerBT.setText("Registrarse");
        registerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel3.setText("Apellido paterno");

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel4.setText("Apellido materno");

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel5.setText("Fecha de nacimiento");

        nameTF.setBackground(new java.awt.Color(255, 255, 255));
        nameTF.setForeground(new java.awt.Color(0, 0, 0));

        apellidoTF.setBackground(new java.awt.Color(255, 255, 255));
        apellidoTF.setForeground(new java.awt.Color(0, 0, 0));

        apellidoMTF.setBackground(new java.awt.Color(255, 255, 255));
        apellidoMTF.setForeground(new java.awt.Color(0, 0, 0));

        fechaNacimientoTF.setBackground(new java.awt.Color(255, 255, 255));
        fechaNacimientoTF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel6.setText("Informacion personal");

        jLabel7.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel7.setText("Calle");

        jLabel8.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel8.setText("Numero");

        jLabel9.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel9.setText("Coliona");

        calleTF.setBackground(new java.awt.Color(255, 255, 255));
        calleTF.setForeground(new java.awt.Color(0, 0, 0));
        calleTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calleTFActionPerformed(evt);
            }
        });

        numeroTF.setBackground(new java.awt.Color(255, 255, 255));
        numeroTF.setForeground(new java.awt.Color(0, 0, 0));

        coloniaTF.setBackground(new java.awt.Color(255, 255, 255));
        coloniaTF.setForeground(new java.awt.Color(0, 0, 0));
        coloniaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coloniaTFActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel10.setText("Direccion");

        regresoBT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        regresoBT.setText("Regresar");
        regresoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresoBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresoBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameTF)
                                .addComponent(apellidoTF)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(apellidoMTF)
                                .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(coloniaTF))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(calleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(numeroTF, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(registerBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(regresoBT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calleTF)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(numeroTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(coloniaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(apellidoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoMTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(registerBT)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBTActionPerformed
        if (isInformationsRequiered()) {
            registrarCliente();
        } else {
            JOptionPane.showConfirmDialog(this, "Error, ingrese toda la informacion requerida");
        }
    }//GEN-LAST:event_registerBTActionPerformed

    private void calleTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calleTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calleTFActionPerformed

    private void coloniaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coloniaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coloniaTFActionPerformed

    private void regresoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresoBTActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_regresoBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoMTF;
    private javax.swing.JTextField apellidoTF;
    private javax.swing.JTextField calleTF;
    private javax.swing.JTextField coloniaTF;
    private javax.swing.JTextField fechaNacimientoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField numeroTF;
    private javax.swing.JButton registerBT;
    private javax.swing.JButton regresoBT;
    // End of variables declaration//GEN-END:variables
}
