/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.dominio.Direccion;
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

    private Cliente extraerDatosFormularioUsuario() {
        String nombre = this.nameTF.getText();
        String apellidoPaterno = this.apellidoTF.getText();
        String apellidoMaterno = this.apellidoMTF.getText();
        String fechaNacimiento = this.fechaNacimientoTF.getText();
// FINISH THIS
        Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, 0);
        return cliente;
    }

    private Direccion extraerDatosFormularioDireccion() {
        String calle = this.calleTF.getText();
        String colonia = this.coloniaTF.getText();
        String numero = this.numeroTF.getText();

// FINISH THIS
        Direccion direccion = new Direccion(calle, colonia, numero);
        return direccion;
    }

    private void mostrarMensajeClienteGuardado(Cliente clienteGuardado) {
        JOptionPane.showMessageDialog(this, "se agregó el cliente: " + clienteGuardado.getId(),
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeDireccionGuardada(Direccion direccion) {
        JOptionPane.showMessageDialog(this, "se agregó la direccion: " + direccion.getId(),
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }

    private void test() {

    }

    private void mostrarMensajeErrorClienteGuardado() {
        JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente", "Error", JOptionPane.OK_OPTION);

    }
    
       private void mostrarMensajeErrorDireccionGuardada() {
        JOptionPane.showMessageDialog(this, "No fue posible agregar la direccion", "Error", JOptionPane.OK_OPTION);

    }


    private void registrarCliente() {
        try {
            Direccion direccion = this.extraerDatosFormularioDireccion();
            Direccion direccionGuardada = this.clientesDAO.ingresarDireccion(direccion);
            
            this.mostrarMensajeDireccionGuardada(direccionGuardada);
        } catch (Exception e) {
            this.mostrarMensajeErrorDireccionGuardada();
        }

        try {
            Cliente cliente = this.extraerDatosFormularioUsuario();
            cliente.setIdDireccion(1);
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
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        nameTF.setBackground(new java.awt.Color(255, 255, 255));
        nameTF.setForeground(new java.awt.Color(0, 0, 0));

        apellidoTF.setBackground(new java.awt.Color(255, 255, 255));
        apellidoTF.setForeground(new java.awt.Color(0, 0, 0));

        apellidoMTF.setBackground(new java.awt.Color(255, 255, 255));
        apellidoMTF.setForeground(new java.awt.Color(0, 0, 0));
        apellidoMTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoMTFActionPerformed(evt);
            }
        });

        fechaNacimientoTF.setBackground(new java.awt.Color(255, 255, 255));
        fechaNacimientoTF.setForeground(new java.awt.Color(0, 0, 0));
        fechaNacimientoTF.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                fechaNacimientoTFComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                fechaNacimientoTFComponentRemoved(evt);
            }
        });
        fechaNacimientoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fechaNacimientoTFKeyReleased(evt);
            }
        });

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

        jLabel12.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel12.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel5.setText("YYYY-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(apellidoTF))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(apellidoMTF, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(regresoBT)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(112, 112, 112))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
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
                                .addComponent(numeroTF, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(registerBT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel5)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(apellidoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoMTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(registerBT)
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void apellidoMTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoMTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoMTFActionPerformed

    private void fechaNacimientoTFComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_fechaNacimientoTFComponentAdded

    }//GEN-LAST:event_fechaNacimientoTFComponentAdded

    private void fechaNacimientoTFComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_fechaNacimientoTFComponentRemoved

    }//GEN-LAST:event_fechaNacimientoTFComponentRemoved

    private void fechaNacimientoTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaNacimientoTFKeyReleased

        if (!(evt.getKeyCode() == 8)) {
            if (fechaNacimientoTF.getText().length() == 4) {
                fechaNacimientoTF.setText(fechaNacimientoTF.getText() + "-");
            } else if (fechaNacimientoTF.getText().length() == 7) {
                fechaNacimientoTF.setText(fechaNacimientoTF.getText() + "-");
            }
        }


    }//GEN-LAST:event_fechaNacimientoTFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoMTF;
    private javax.swing.JTextField apellidoTF;
    private javax.swing.JTextField calleTF;
    private javax.swing.JTextField coloniaTF;
    private javax.swing.JTextField fechaNacimientoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
