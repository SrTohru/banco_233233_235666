/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

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
//finish this
    
    public void insertar(){
        if(isInfoRequieres()){
            Cuenta cuenta = obtenerInformacionCuenta();
       cuentaDAO.iniciarSesion(cuenta);
        }else{
            JOptionPane.showMessageDialog(this, "erorr");
        }
            
        
    }
    
    public Cuenta obtenerInformacionCuenta(){
        String user = this.userTF.getText();
        String password = this.passwordTF.getText();
       // Cuenta c = new Cuenta(user, password);
        
        return null;
    }
    public boolean isInfoRequieres(){
        
        if(userTF.getText().equalsIgnoreCase("") || passwordTF.getText().equalsIgnoreCase("")){
            return false;
        }
        
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginBT = new javax.swing.JButton();
        registerBT = new javax.swing.JButton();
        passwordTF = new javax.swing.JTextField();
        userTF = new javax.swing.JTextField();
        passwordLB = new javax.swing.JLabel();
        userLB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        regresarBT = new javax.swing.JButton();

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

        registerBT.setBackground(new java.awt.Color(255, 255, 255));
        registerBT.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        registerBT.setForeground(new java.awt.Color(0, 0, 0));
        registerBT.setText("Registrarse");
        registerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBTActionPerformed(evt);
            }
        });

        passwordTF.setBackground(new java.awt.Color(255, 255, 255));
        passwordTF.setForeground(new java.awt.Color(0, 0, 0));

        userTF.setBackground(new java.awt.Color(255, 255, 255));
        userTF.setForeground(new java.awt.Color(0, 0, 0));

        passwordLB.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        passwordLB.setText("Password");

        userLB.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        userLB.setText("Usuario");

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Inicio de sesion");

        regresarBT.setText("Regresar");
        regresarBT.setToolTipText("");
        regresarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(regresarBT)
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addGap(103, 188, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLB)
                            .addComponent(passwordLB))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginBT)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordTF, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addComponent(userTF)))
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(registerBT)
                        .addGap(243, 243, 243))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(regresarBT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLB))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLB))
                .addGap(36, 36, 36)
                .addComponent(loginBT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(registerBT)
                .addGap(47, 47, 47))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBTActionPerformed
        
        dispose();
       //new RegistroClienteForm(clientesDAO, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_registerBTActionPerformed

    private void loginBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTActionPerformed
      if(isInfoRequieres()){
          insertar();
      }else{
          JOptionPane.showMessageDialog(this, "asdasdasdasdasda");
      }
    }//GEN-LAST:event_loginBTActionPerformed

    private void regresarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBTActionPerformed
        // TODO add your handling code here:
        dispose();
        new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
    }//GEN-LAST:event_regresarBTActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBT;
    private javax.swing.JLabel passwordLB;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JButton registerBT;
    private javax.swing.JButton regresarBT;
    private javax.swing.JLabel userLB;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
