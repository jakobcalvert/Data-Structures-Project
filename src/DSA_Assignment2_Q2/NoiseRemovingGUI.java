/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DSA_Assignment2_Q2;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Jakob
 */
public class NoiseRemovingGUI extends javax.swing.JFrame {

    //stores the processed image 
    ImageProcess ip;

    /**
     * Creates new form NewJFrame
     */
    public NoiseRemovingGUI() {
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

        Load = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Before = new javax.swing.JLabel();
        After = new javax.swing.JLabel();
        removeNoise = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.setEnabled(false);
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Before.setText(" ");

        After.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        After.setText(" ");

        removeNoise.setText("Remove noise");
        removeNoise.setEnabled(false);
        removeNoise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNoiseActionPerformed(evt);
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
                        .addComponent(Load)
                        .addGap(132, 132, 132)
                        .addComponent(removeNoise)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(Save))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Before)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(After)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Before, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(After, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Load)
                    .addComponent(Save)
                    .addComponent(removeNoise))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        //Saves the image as noise_removed.jpg once the user clicks the save button
        ip.save("noise_removed.jpg");
    }//GEN-LAST:event_SaveActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        //
        JFileChooser imageFileChooser = new JFileChooser(new File("."));
        int stateImageFileChooser = imageFileChooser.showOpenDialog(null);

        if (stateImageFileChooser == JFileChooser.APPROVE_OPTION) {
            String fileName = imageFileChooser.getSelectedFile().getPath();
            ip = new ImageProcess(fileName);

            ImageIcon icon = new ImageIcon(fileName);
            Image image = icon.getImage();
            Image imagePreview = image.getScaledInstance(240, 200, java.awt.Image.SCALE_SMOOTH); 
            icon = new ImageIcon(imagePreview);
            Before.setIcon(icon);

            removeNoise.setEnabled(true);
        }
    }//GEN-LAST:event_LoadActionPerformed

    private void removeNoiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeNoiseActionPerformed
        // TODO add your handling code here:
        ip.cleanNoise();
        ImageIcon icon = new ImageIcon(ip.buffered_image);
        Image image = icon.getImage();
        Image imagePreview = image.getScaledInstance(240, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(imagePreview); 
        After.setIcon(icon);
        Save.setEnabled(true);
    }//GEN-LAST:event_removeNoiseActionPerformed

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
            java.util.logging.Logger.getLogger(NoiseRemovingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NoiseRemovingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NoiseRemovingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NoiseRemovingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NoiseRemovingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel After;
    private javax.swing.JLabel Before;
    private javax.swing.JButton Load;
    private javax.swing.JButton Save;
    private javax.swing.JButton removeNoise;
    // End of variables declaration//GEN-END:variables
}