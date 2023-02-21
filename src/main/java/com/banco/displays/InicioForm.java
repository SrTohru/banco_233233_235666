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

    public InicioForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO, Cliente cliente) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        this.cliente = cliente;
        this.cuenta = null;

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
    private void mostrarErrorHistorial() {
        JOptionPane.showMessageDialog(this, "No se puede ver el historial sin haber iniciado sesion",
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }
      private void mostrarErrorActualizar() {
        JOptionPane.showMessageDialog(this, "No se puede realizar una actualizacion sin haber iniciado sesion",
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }
        private void mostrarErrorGenerarRetiro() {
        JOptionPane.showMessageDialog(this, "No se puede generar un retiro sin haber iniciado sesion",
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }
        
          private void mostrarErrorCrearCuenta() {
        JOptionPane.showMessageDialog(this, "No se puede crear un cuenta sin haber iniciado sesion",
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
        generarRetiroBT = new javax.swing.JButton();
        crearCuentBT1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio");
        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Inicio");

        inicioSesionBT.setBackground(new java.awt.Color(255, 255, 255));
        inicioSesionBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inicioSesionBT.setForeground(new java.awt.Color(0, 0, 0));
        inicioSesionBT.setText("Iniciar sesion");
        inicioSesionBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesionBTActionPerformed(evt);
            }
        });

        registroBT.setBackground(new java.awt.Color(255, 255, 255));
        registroBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registroBT.setForeground(new java.awt.Color(0, 0, 0));
        registroBT.setText("Registro");
        registroBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBTActionPerformed(evt);
            }
        });

        historialBT.setBackground(new java.awt.Color(255, 255, 255));
        historialBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        historialBT.setForeground(new java.awt.Color(0, 0, 0));
        historialBT.setText("Historial");
        historialBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialBTActionPerformed(evt);
            }
        });

        depositoBT.setBackground(new java.awt.Color(255, 255, 255));
        depositoBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        depositoBT.setForeground(new java.awt.Color(0, 0, 0));
        depositoBT.setText("Deposito");
        depositoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositoBTActionPerformed(evt);
            }
        });

        actualizaClienteBT.setBackground(new java.awt.Color(255, 255, 255));
        actualizaClienteBT.setForeground(new java.awt.Color(0, 0, 0));
        actualizaClienteBT.setText("Actualizar cliente");
        actualizaClienteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaClienteBTActionPerformed(evt);
            }
        });

        generarRetiroBT.setBackground(new java.awt.Color(255, 255, 255));
        generarRetiroBT.setForeground(new java.awt.Color(0, 0, 0));
        generarRetiroBT.setText("Generar retiro");
        generarRetiroBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarRetiroBTActionPerformed(evt);
            }
        });

        crearCuentBT1.setBackground(new java.awt.Color(255, 255, 255));
        crearCuentBT1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crearCuentBT1.setForeground(new java.awt.Color(0, 0, 0));
        crearCuentBT1.setText("Crear cuenta");
        crearCuentBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCuentBT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(inicioSesionBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(depositoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizaClienteBT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generarRetiroBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(registroBT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(historialBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crearCuentBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositoBT)
                    .addComponent(inicioSesionBT))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crearCuentBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(registroBT)
                        .addComponent(historialBT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizaClienteBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarRetiroBT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
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

        if (cliente != null) {
            new DepositoForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
            dispose();
        } else {
            mostrarErrorDeposito();
        }


    }//GEN-LAST:event_depositoBTActionPerformed

    private void actualizaClienteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaClienteBTActionPerformed
        if (cliente != null) {
            dispose();
            new ActualizarClienteForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
            dispose();
        } else {
            mostrarErrorActualizar();
        }
    }//GEN-LAST:event_actualizaClienteBTActionPerformed

    private void historialBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialBTActionPerformed
        // TODO add your handling code here:

        if (cliente != null) {
            dispose();
            new HistorialForm(clientesDAO,cuentaDAO, cliente).setVisible(true);
            dispose();
        } else {
            mostrarErrorHistorial();
        }
    }//GEN-LAST:event_historialBTActionPerformed

    private void generarRetiroBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarRetiroBTActionPerformed
        if (cliente != null) {
            dispose();
            new GenerarRetiroSinCuenta(cuentaDAO, clientesDAO, cliente).setVisible(true);
        } else {
            mostrarErrorGenerarRetiro();
        }
    }//GEN-LAST:event_generarRetiroBTActionPerformed

    private void crearCuentBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCuentBT1ActionPerformed
        if (cliente != null) {
            dispose();
            new RegistrarCuentaForm(cliente, clientesDAO, cuentaDAO).setVisible(true);
        } else {
            mostrarErrorCrearCuenta();
        }
    }//GEN-LAST:event_crearCuentBT1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizaClienteBT;
    private javax.swing.JButton crearCuentBT1;
    private javax.swing.JButton depositoBT;
    private javax.swing.JButton generarRetiroBT;
    private javax.swing.JButton historialBT;
    private javax.swing.JButton inicioSesionBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton registroBT;
    // End of variables declaration//GEN-END:variables
}
