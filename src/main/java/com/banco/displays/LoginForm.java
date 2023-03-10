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
 * @author Usuario
 */
public class LoginForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;
    private final ICuentaDAO cuentaDAO;

    public LoginForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        initComponents();
    }

    public Cliente consultarCuenta() {
        try {
            Cliente cliente = obtenerInformacionCuenta();
            Cliente c = cuentaDAO.iniciarSesion(cliente);
            return c;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
            return null;
        }

    }

    public Cliente obtenerInformacionCuenta() {
        String user = this.userTF.getText();
        String password = this.passwordTF.getText();
        Cliente c = new Cliente(user, password);

        return c;
    }

    public boolean isInfoRequieres() {

        if (userTF.getText().equalsIgnoreCase("") || passwordTF.getText().equalsIgnoreCase("")) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginBT = new javax.swing.JButton();
        cancelarBT = new javax.swing.JButton();
        userTF = new javax.swing.JTextField();
        passwordLB = new javax.swing.JLabel();
        userLB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordTF = new javax.swing.JPasswordField();
        registerBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(153, 255, 204));

        loginBT.setBackground(new java.awt.Color(255, 255, 255));
        loginBT.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        loginBT.setForeground(new java.awt.Color(0, 0, 0));
        loginBT.setText("Iniciar sesion");
        loginBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTActionPerformed(evt);
            }
        });

        cancelarBT.setBackground(new java.awt.Color(255, 255, 255));
        cancelarBT.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        cancelarBT.setForeground(new java.awt.Color(0, 0, 0));
        cancelarBT.setText("Cancelar");
        cancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBTActionPerformed(evt);
            }
        });

        userTF.setBackground(new java.awt.Color(255, 255, 255));
        userTF.setForeground(new java.awt.Color(0, 0, 0));

        passwordLB.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        passwordLB.setText("Password");

        userLB.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        userLB.setText("Usuario");

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Inicio de sesion");

        passwordTF.setBackground(new java.awt.Color(255, 255, 255));
        passwordTF.setForeground(new java.awt.Color(0, 0, 0));

        registerBT.setBackground(new java.awt.Color(255, 255, 255));
        registerBT.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        registerBT.setForeground(new java.awt.Color(0, 0, 0));
        registerBT.setText("Registrarse");
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
                .addGap(190, 190, 190)
                .addComponent(jLabel1)
                .addGap(103, 188, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelarBT)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLB)
                            .addComponent(passwordLB))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loginBT)
                                .addComponent(userTF, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addComponent(passwordTF))
                            .addComponent(registerBT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLB))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLB)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(loginBT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerBT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(cancelarBT)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTActionPerformed

        dispose();
        new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_cancelarBTActionPerformed

    private void loginBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTActionPerformed
        if (isInfoRequieres()) {
            Cliente c = consultarCuenta();
            if (c != null) {
                dispose();
                new InicioForm(clientesDAO, cuentaDAO, c).setVisible(true);
                JOptionPane.showMessageDialog(this, "Inicio sesion correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo crear el cliente");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese toda la informacion requerida");
        }
    }//GEN-LAST:event_loginBTActionPerformed

    private void registerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBTActionPerformed
        dispose();
        new RegistroClienteForm(clientesDAO, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_registerBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBT;
    private javax.swing.JLabel passwordLB;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JButton registerBT;
    private javax.swing.JLabel userLB;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
