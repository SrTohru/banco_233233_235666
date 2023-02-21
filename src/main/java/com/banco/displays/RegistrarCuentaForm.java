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

public class RegistrarCuentaForm extends javax.swing.JFrame {

    private final Cliente cliente;
    private final ICuentaDAO cuentaDAO;
    private final IClienteDAO clienteDAO;
    
    public RegistrarCuentaForm(Cliente cliente,IClienteDAO clienteDAO, ICuentaDAO cuentaDAO) {
        this.cliente = cliente;
        this.cuentaDAO = cuentaDAO;
        this.clienteDAO = clienteDAO;
        initComponents();
        idClienteTF.setText(cliente.getId().toString());
    }

    public boolean isInformationsRequiered() {
        return (montoDineroTF.getText().equalsIgnoreCase(""));
    }

    private Cuenta extraerDatosFormularioUsuario() {
        Double monto = Double.parseDouble(this.montoDineroTF.getText());
        Cuenta cuenta = new Cuenta(cliente.getId(), monto);
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
        montoDineroTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        aceptarBT = new javax.swing.JButton();
        cancelarBT = new javax.swing.JButton();
        idClienteTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Registra una Cuenta");

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel3.setText("Monto de dinero:");

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

        idClienteTF.setEditable(false);

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel4.setText("IdCliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idClienteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(montoDineroTF, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aceptarBT)
                .addGap(75, 75, 75)
                .addComponent(cancelarBT)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idClienteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoDineroTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBT)
                    .addComponent(aceptarBT))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBTActionPerformed
        Cuenta c = registrarCuenta();

        if (c != null) {
            dispose();
            new InicioForm(clienteDAO, cuentaDAO, cliente, c).setVisible(true);
        }
    }//GEN-LAST:event_aceptarBTActionPerformed

    private void cancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTActionPerformed
        // TODO add your handling code here:
        dispose();
        if(cliente != null){
            new InicioForm(clienteDAO, cuentaDAO, cliente).setVisible(true);
        }else{
             new InicioForm(clienteDAO, cuentaDAO).setVisible(true);
        }
    
    }//GEN-LAST:event_cancelarBTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBT;
    private javax.swing.JButton cancelarBT;
    private javax.swing.JTextField idClienteTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField montoDineroTF;
    // End of variables declaration//GEN-END:variables
}
