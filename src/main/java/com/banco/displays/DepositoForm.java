/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.banco.displays;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.implementaciones.CuentaDAO;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.ICuentaDAO;
import javax.swing.JOptionPane;

public class DepositoForm extends javax.swing.JFrame {

    private final IClienteDAO clientesDAO;
    private final ICuentaDAO cuentaDAO;

    private CuentaDAO cuentadao;
    private Cliente cliente;

    public DepositoForm(IClienteDAO clientesDAO, ICuentaDAO cuentaDAO, Cliente cliente) {
        this.clientesDAO = clientesDAO;
        this.cuentaDAO = cuentaDAO;
        this.cliente = cliente;
        initComponents();

        cuentaDAO.mostrarCuentasDeClienteEnComboBox(cliente.getId(), jComboBox1);
    }

    public boolean realizarDeposito() {
        String idString = this.jComboBox1.getSelectedItem().toString();
        int idOrigen = Integer.parseInt(idString.substring(0, 1));
        int idDestino = Integer.parseInt(this.idCuentaDestinoTF.getText());
        double montoDeposito = Double.parseDouble(this.cantidadTF.getText());

        try {
            cuentaDAO.transferir(idOrigen, idDestino, montoDeposito);
            mostrarMensajeDepositoHecho(idOrigen, idDestino);
            return true;
        } catch (Exception e) {
            mostrarMensajeErroDeposito();
            return false;
        }
    }

    private void mostrarMensajeDepositoHecho(int idOrigen, int idDestino) {
        JOptionPane.showMessageDialog(this, "Se realizo el deposito a: " + idDestino + ", proveniente de: " + idOrigen,
                "Información ", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeErroDeposito() {
        JOptionPane.showMessageDialog(this, "No fue posible realizar el deposito", "Error", JOptionPane.OK_OPTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositarBT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cantidadTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idCuentaDestinoTF = new javax.swing.JTextField();
        cancelarBT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        depositarBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        depositarBT.setText("Depositar");
        depositarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarBTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setText("Cantidad");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setText("Deposito");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setText("Id Cuenta Destino");

        cancelarBT.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        cancelarBT.setText("Cancelar");
        cancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setText("Tus cuentas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idCuentaDestinoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel2)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelarBT)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(depositarBT)
                        .addGap(168, 168, 168))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idCuentaDestinoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cantidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depositarBT)
                .addGap(18, 18, 18)
                .addComponent(cancelarBT)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void depositarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarBTActionPerformed
        if (realizarDeposito()) {
            dispose();
            
            
            if (cliente != null) {
                new InicioForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
            } else {
                new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
            }
        } else {
            dispose();
            if (cliente != null) {
                new InicioForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
            } else {
                new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
            }
        }
    }//GEN-LAST:event_depositarBTActionPerformed

    private void cancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTActionPerformed
        dispose();
        if (cliente != null) {
            new InicioForm(clientesDAO, cuentaDAO, cliente).setVisible(true);
        } else {
            new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
        }
    }//GEN-LAST:event_cancelarBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBT;
    private javax.swing.JTextField cantidadTF;
    private javax.swing.JButton depositarBT;
    private javax.swing.JTextField idCuentaDestinoTF;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
