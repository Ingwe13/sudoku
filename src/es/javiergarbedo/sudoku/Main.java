package es.javiergarbedo.sudoku;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {

    private Sudoku sudoku;
    private final int TOP_LEVEL = 1000;

    /**
     * Creates new form Main
     */
    public Main() throws FileNotFoundException, IOException {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sudoku");
        //Pasar foco al panel para que recoja pulsaciones de teclado
        sudokuPanel1.requestFocus();

        //Rellenar lista desplegable de niveles 1 a 1000
        String[] levelNames = new String[TOP_LEVEL];
        for (int i = 0; i < TOP_LEVEL; i++) {
            levelNames[i] = String.valueOf(i + 1);
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(levelNames));

        String lastLevel = "0";
        //TODO: Leer desde un archivo de propiedades el número del último nivel seleccionado
        //  y guardarlo en la variable lastlevel
        FileReader fr;
        int caract;

        fr = new FileReader("sudoku_levels.txt");

        caract = fr.read();

        while (caract != -1) {

//Hacer algo con el carácter leído

            caract = fr.read();
        }

        jComboBox1.setSelectedIndex(Integer.valueOf(lastLevel));
        int levelSelected = jComboBox1.getSelectedIndex();
        setLevel(levelSelected);
    }

    private void setLevel(int level) {
        String strLevel = "";
        if (level < TOP_LEVEL) {
            //TODO: Cargar el puzzle en la variable strLevel desde el archivo sudoku_levels.txt,
            //  en función del nivel que se encuentre en el parámetro level.

            //Para probar finalización del juego (falta 4 y 6)
            //strLevel = "78419623532158..97956327418297451386845963172613872954179645823432718569568239741";
            sudoku = new Sudoku(strLevel);
            sudokuPanel1.setSudoku(sudoku);
            sudokuPanel1.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sudokuPanel1 = new es.javiergarbedo.sudoku.SudokuPanel();
        jLabelLevel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        sudokuPanel1.setMinimumSize(new java.awt.Dimension(361, 361));
        sudokuPanel1.setPreferredSize(new java.awt.Dimension(361, 361));

        javax.swing.GroupLayout sudokuPanel1Layout = new javax.swing.GroupLayout(sudokuPanel1);
        sudokuPanel1.setLayout(sudokuPanel1Layout);
        sudokuPanel1Layout.setHorizontalGroup(
            sudokuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        sudokuPanel1Layout.setVerticalGroup(
            sudokuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        jLabelLevel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLevel.setText("Nivel:");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sudokuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLevel)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sudokuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        setLevel(jComboBox1.getSelectedIndex());
        sudokuPanel1.requestFocus();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //TODO: Guardar en un archivo de propiedades el número del nivel seleccionado en la lista desplegable

        dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabelLevel;
    private es.javiergarbedo.sudoku.SudokuPanel sudokuPanel1;
    // End of variables declaration//GEN-END:variables
}
