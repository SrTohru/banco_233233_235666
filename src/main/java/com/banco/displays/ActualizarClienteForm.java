/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.ICuentaDAO;
import javax.swing.JOptionPane;

public class ActualizarClienteForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;
    private final ICuentaDAO cuentaDAO;
    private Cliente cliente;

    public ActualizarClienteForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO, Cliente cliente) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        this.cliente = cliente;
        initComponents();

        ponerDatos(cliente);
    }

    public void ponerDatos(Cliente cliente) {
        nameTF.setText(cliente.getNombre());
        apellidoPaternoTF.setText(cliente.getApellidoPaterno());
        apellidoMaternoTF.setText(cliente.getApellidoMaterno());
        usuarioTF.setText(cliente.getUsuario());
        fechaNacimientoTF.setText(cliente.getFechaNacimiento());

    }

    public boolean isInformationRequiered() {
        if (nameTF.getText().isEmpty()
                || apellidoPaternoTF.getText().isEmpty()
                || apellidoMaternoTF.getText().isEmpty()
                || nipTF.getText().isEmpty()
                || usuarioTF.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private Cliente extraerDatosFormularioUsuario() {
        String nombre = this.nameTF.getText();
        String apellidoPaterno = this.apellidoPaternoTF.getText();
        String apellidoMaterno = this.apellidoMaternoTF.getText();
        String fechaNacimiento = this.fechaNacimientoTF.getText();
        String usuario = this.usuarioTF.getText();
        String nip = this.nipTF.getText();
        Cliente clienteActualizado = new Cliente(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, nip, usuario);
        return clienteActualizado;
    }

    public boolean actualizarCliente(Cliente clienteOriginal, Cliente clienteActualizado) {
        try {

            clientesDAO.actualizar(clienteOriginal, clienteActualizado);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nipTF = new javax.swing.JPasswordField();
        usuarioTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        apellidoPaternoTF = new javax.swing.JTextField();
        apellidoMaternoTF = new javax.swing.JTextField();
        fechaNacimientoTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        regresoBT = new javax.swing.JButton();
        registerBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Actualizar Informacion del Cliente");

        jLabel12.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel12.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel5.setText("YYYY-MM-DD");

        jLabel11.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel11.setText("Informacion personal");

        nipTF.setBackground(new java.awt.Color(255, 255, 255));
        nipTF.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nipTF.setForeground(new java.awt.Color(0, 0, 0));

        usuarioTF.setBackground(new java.awt.Color(255, 255, 255));
        usuarioTF.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usuarioTF.setForeground(new java.awt.Color(0, 0, 0));
        usuarioTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTFActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel13.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel14.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel14.setText("NIP");

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel3.setText("Apellido paterno");

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel4.setText("Apellido materno");

        nameTF.setBackground(new java.awt.Color(255, 255, 255));
        nameTF.setForeground(new java.awt.Color(0, 0, 0));

        apellidoPaternoTF.setBackground(new java.awt.Color(255, 255, 255));
        apellidoPaternoTF.setForeground(new java.awt.Color(0, 0, 0));

        apellidoMaternoTF.setBackground(new java.awt.Color(255, 255, 255));
        apellidoMaternoTF.setForeground(new java.awt.Color(0, 0, 0));
        apellidoMaternoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoMaternoTFActionPerformed(evt);
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
        fechaNacimientoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaNacimientoTFActionPerformed(evt);
            }
        });
        fechaNacimientoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fechaNacimientoTFKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel6.setText("Informacion de cuenta");

        regresoBT.setBackground(new java.awt.Color(255, 255, 255));
        regresoBT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        regresoBT.setForeground(new java.awt.Color(0, 0, 0));
        regresoBT.setText("Cancelar");
        regresoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresoBTActionPerformed(evt);
            }
        });

        registerBT.setBackground(new java.awt.Color(255, 255, 255));
        registerBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        registerBT.setForeground(new java.awt.Color(0, 0, 0));
        registerBT.setText("Actualizar");
        registerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(apellidoPaternoTF)
                                    .addComponent(nameTF)
                                    .addComponent(apellidoMaternoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuarioTF, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(nipTF))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(registerBT)
                        .addGap(248, 248, 248))
                    .addComponent(regresoBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(apellidoPaternoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(apellidoMaternoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nipTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(usuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(registerBT)
                .addGap(7, 7, 7)
                .addComponent(regresoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTFActionPerformed

    private void apellidoMaternoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoMaternoTFActionPerformed

    }//GEN-LAST:event_apellidoMaternoTFActionPerformed

    private void fechaNacimientoTFComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_fechaNacimientoTFComponentAdded

    }//GEN-LAST:event_fechaNacimientoTFComponentAdded

    private void fechaNacimientoTFComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_fechaNacimientoTFComponentRemoved

    }//GEN-LAST:event_fechaNacimientoTFComponentRemoved

    private void fechaNacimientoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaNacimientoTFActionPerformed

    }//GEN-LAST:event_fechaNacimientoTFActionPerformed

    private void fechaNacimientoTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaNacimientoTFKeyReleased
        if (!(evt.getKeyCode() == 8)) {
            if (fechaNacimientoTF.getText().length() == 4) {
                fechaNacimientoTF.setText(fechaNacimientoTF.getText() + "-");
            } else if (fechaNacimientoTF.getText().length() == 7) {
                fechaNacimientoTF.setText(fechaNacimientoTF.getText() + "-");
            }
        }
    }//GEN-LAST:event_fechaNacimientoTFKeyReleased

    private void regresoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresoBTActionPerformed
        // TODO add your handling code here:
        dispose();

        new InicioForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
    }//GEN-LAST:event_regresoBTActionPerformed

    private void registerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBTActionPerformed
        if (isInformationRequiered()) {
            if (actualizarCliente(cliente, extraerDatosFormularioUsuario())) {
                this.cliente = extraerDatosFormularioUsuario();
                dispose();
                new InicioForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el cliente");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Error, ingrese toda la informacion requerida");
        }
    }//GEN-LAST:event_registerBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoMaternoTF;
    private javax.swing.JTextField apellidoPaternoTF;
    private javax.swing.JTextField fechaNacimientoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameTF;
    private javax.swing.JPasswordField nipTF;
    private javax.swing.JButton registerBT;
    private javax.swing.JButton regresoBT;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
}
