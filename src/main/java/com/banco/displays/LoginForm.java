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
//finish this
    
    public void insertar(){
        if(isInfoRequieres()){
      //      clientesDAO.registrarse(userTF.getText(), passwordTF.getText());
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
        jLabel1 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Inicio de sesion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(userLB)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(passwordLB)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(loginBT, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(registerBT)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBT)
                .addGap(88, 88, 88)
                .addComponent(registerBT)
                .addContainerGap())
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBT;
    private javax.swing.JLabel passwordLB;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JButton registerBT;
    private javax.swing.JLabel userLB;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
