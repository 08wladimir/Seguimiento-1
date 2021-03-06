/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Wladimir
 */
public class Menu extends javax.swing.JFrame {

    public int id;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdU = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMostrar.setText("Mostrar Tabla");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id de Usuario:");

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdU, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        
        try{
            int id = Integer.parseInt(txtIdU.getText());   
            int User_id = 0;
            try 
            {
                Connection con = null;

                Conexion conexion = new Conexion();
                con = conexion.Conexion(con);
                Statement stmt = con.createStatement();
                String qry = "SELECT * FROM tblPersonas";
                ResultSet rs = stmt.executeQuery(qry);

                while(rs.next())
                {   
                    User_id = rs.getInt("Id_Usuario");

                    if(id == User_id){
                        con.close();
                    }
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            if(User_id == id){
                JOptionPane.showMessageDialog(this, "El Id ingresado ya esta ocupado en la base de Datos","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                Insertar insertar = new Insertar(id);
                insertar.setVisible(rootPaneCheckingEnabled);
                this.setVisible(false);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Inserte un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        try{
            int id = Integer.parseInt(txtIdU.getText());   
            int User_id = 0;
            try 
            {
                Connection con = null;

                Conexion conexion = new Conexion();
                con = conexion.Conexion(con);
                Statement stmt = con.createStatement();
                String qry = "SELECT * FROM tblPersonas";
                ResultSet rs = stmt.executeQuery(qry);

                while(rs.next())
                {   
                    User_id = rs.getInt("Id_Usuario");

                    if(id == User_id){
                        con.close();
                    }
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            if(User_id == id){
                Eliminar eliminar = new Eliminar(id);
                eliminar.setVisible(rootPaneCheckingEnabled);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "El Id ingresado no esta en la base de Datos","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Inserte un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        try{
            int id = Integer.parseInt(txtIdU.getText());   
            int User_id = 0;
            try 
            {
                Connection con = null;

                Conexion conexion = new Conexion();
                con = conexion.Conexion(con);
                Statement stmt = con.createStatement();
                String qry = "SELECT * FROM tblPersonas";
                ResultSet rs = stmt.executeQuery(qry);

                while(rs.next())
                {   
                    User_id = rs.getInt("Id_Usuario");

                    if(id == User_id){
                        con.close();
                    }
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            if(User_id == id){
                Modificar modificar = new Modificar(id);
                modificar.setVisible(rootPaneCheckingEnabled);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "El Id ingresado no esta en la base de Datos","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Inserte un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        Mostrar mostrar = new Mostrar();
        mostrar.setVisible(rootPaneCheckingEnabled);
        this.setVisible(false);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdU;
    // End of variables declaration//GEN-END:variables

}
