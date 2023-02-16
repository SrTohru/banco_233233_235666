/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.interfaces.IClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class LoginForm extends javax.swing.JFrame {

   private final IClienteDAO clientesDAO;
    public LoginForm(IClienteDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
        initComponents();
    }

    
    public void insertar(){
        if(isInfoRequieres()){
            clientesDAO.registrarse(userTF.getText(), passwordTF.getText());
        }else{
            JOptionPane.showMessageDialog(this, "erorr");
        }
            
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(153, 255, 204));

        loginBT.setBackground(new java.awt.Color(255, 255, 255));
        loginBT.setForeground(new java.awt.Color(0, 0, 0));
        loginBT.setText("Iniciar sesion");
        loginBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTActionPerformed(evt);
            }
        });

        registerBT.setBackground(new java.awt.Color(255, 255, 255));
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

        passwordLB.setText("Password");

        userLB.setText("User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBT)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userLB)
                            .addComponent(passwordLB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userTF, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(passwordTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(loginBT, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLB))
                .addGap(27, 27, 27)
                .addComponent(loginBT)
                .addGap(64, 64, 64)
                .addComponent(registerBT)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerBTActionPerformed

    private void loginBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTActionPerformed
      if(isInfoRequieres()){
          insertar();
      }else{
          JOptionPane.showMessageDialog(this, "asdasdasdasdasda");
      }
    }//GEN-LAST:event_loginBTActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginBT;
    private javax.swing.JLabel passwordLB;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JButton registerBT;
    private javax.swing.JLabel userLB;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
