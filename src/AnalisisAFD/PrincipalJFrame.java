/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisAFD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Oscar Chaves Navarro <ochndev at github.com>
 */
public class PrincipalJFrame extends javax.swing.JFrame {

    private LogicaDeLaAplicacion LDLA;
    int archivo_cargado;
    String cadena_entrada;
    int caracter_actual;
    
    public PrincipalJFrame() {
        
        LDLA = new LogicaDeLaAplicacion();
        initComponents();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .dat","dat");
        jFileChooser.setFileFilter(filter);
        jFileChooser.setDialogTitle("Abrir archivo de Automata");
        jFileChooser.setCurrentDirectory(new File("\\"));
        archivo_cargado = 0;
        caracter_actual = 0;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        BotonSimulacion = new javax.swing.JButton();
        BotonPasoAPaso = new javax.swing.JButton();
        TextoEntrada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        BotonCargarArchivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmica y Modelos de Computación - Oscar Chaves Navarro");

        BotonSimulacion.setText("SIMULACIÓN");
        BotonSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSimulacionActionPerformed(evt);
            }
        });

        BotonPasoAPaso.setText("PASO A PASO");
        BotonPasoAPaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPasoAPasoActionPerformed(evt);
            }
        });

        TextoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoEntradaActionPerformed(evt);
            }
        });

        jLabel1.setText("CADENA DE ENTRADA (Escriba una cadena de texto y pulse Intro)");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Salida del programa");

        BotonCargarArchivo.setText("Cargar archivo");
        BotonCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarArchivoActionPerformed(evt);
            }
        });

        jButton1.setLabel("REESTABLECER");
        jButton1.setMaximumSize(new java.awt.Dimension(99, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(99, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(99, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextoEntrada)
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(BotonCargarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonPasoAPaso, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(BotonCargarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPasoAPaso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoEntradaActionPerformed
        cadena_entrada = this.TextoEntrada.getText();
        System.out.println("CADENA DE CARACTERES: "+cadena_entrada);
        System.out.println();
        LDLA.setCadena(cadena_entrada);
    }//GEN-LAST:event_TextoEntradaActionPerformed

    private void BotonCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarArchivoActionPerformed
        
        String ruta;
        int elemento;     

        elemento = jFileChooser.showOpenDialog(this);
        
        if(elemento == JFileChooser.APPROVE_OPTION){
            
            try {
                ruta = jFileChooser.getSelectedFile().getAbsolutePath();
                 System.out.println(ruta);               
                LDLA.CargarArchivo(ruta);
                archivo_cargado = 1;
                
            } catch (IOException ex) {
                Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_BotonCargarArchivoActionPerformed

    private void BotonSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSimulacionActionPerformed

        String salida;
        
        if(this.TextoEntrada.getText().length() > 0 && this.archivo_cargado == 1){
            
            LDLA.setCadena(this.TextoEntrada.getText());
            salida = LDLA.simulacion();
            this.jTextArea1.setText(salida);
            
            if(salida.contains("MUERTO")){
                
                JOptionPane.showMessageDialog(this, "Cadena -INCORRECTA- ");
                
            }else if(salida.contains("FINAL")){
                
                JOptionPane.showMessageDialog(this, "Cadena -CORRECTA-");
                
            }
            
           
        }
        
        if(this.TextoEntrada.getText().length() <= 0)            
            JOptionPane.showMessageDialog(this, "Error, debe introducir una CADENA DE ENTRADA");
            
        if(this.archivo_cargado == 0)          
            JOptionPane.showMessageDialog(this, "Error, primero debe cargar un ARCHIVO .dat");
            
        

    }//GEN-LAST:event_BotonSimulacionActionPerformed

    private void BotonPasoAPasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPasoAPasoActionPerformed
        
        String salida = "";
        this.jTextArea1.setText("");
        
        if(this.archivo_cargado == 1 && this.TextoEntrada.getText().length() > 0){ 
            
            LDLA.setCadena(this.TextoEntrada.getText());
            if(caracter_actual < LDLA.getCadena().length()){
            
                salida = LDLA.simulacionPasoAPaso(caracter_actual);
                System.out.println();
                System.out.println(salida);
                this.jTextArea1.setText(salida);
                caracter_actual++;
                
            }
        }
        
        if(salida.contains("MUERTO") && caracter_actual == LDLA.getCadena().length()){
                
            JOptionPane.showMessageDialog(this, "Cadena -INCORRECTA- ");
                
        }else if(salida.contains("FINAL") && caracter_actual == LDLA.getCadena().length()){
                
            JOptionPane.showMessageDialog(this, "Cadena -CORRECTA-");
                
        }
        
        if(this.TextoEntrada.getText().length() <= 0)        
            JOptionPane.showMessageDialog(this, "Error, debe introducir una CADENA DE ENTRADA");

        if(this.archivo_cargado == 0)            
            JOptionPane.showMessageDialog(this, "Error, primero debe cargar un ARCHIVO .dat");
        
    }//GEN-LAST:event_BotonPasoAPasoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        caracter_actual = 0;
        archivo_cargado = 0;
        TextoEntrada.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCargarArchivo;
    private javax.swing.JButton BotonPasoAPaso;
    private javax.swing.JButton BotonSimulacion;
    private javax.swing.JTextField TextoEntrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}