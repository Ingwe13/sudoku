package es.javiergarbedo.sudoku;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.beans.Beans;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class SudokuPanel extends javax.swing.JPanel {

    private final int CELL_SIZE = 40;
    private final int NUM_COLUMNS = 9;
    private final int NUM_ROWS = 9;
    private final Color BACKGROUND_SELECTED = Color.ORANGE;
    private final Color BACKGROUND_CLUE = new Color(255, 228, 181);
    private final Color BACKGROUND_NORMAL = new Color(255, 255, 224);
    private int rowSelected = -1;
    private int colSelected = -1;
    private Sudoku sudoku = null;
    private static Locale locale;

    /**
     * Creates new form SudokuPanel
     */
    public SudokuPanel() {
        initComponents();


    }

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public int getRowSelected() {
        return rowSelected;
    }

    public int getColSelected() {
        return colSelected;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (sudoku != null && !Beans.isDesignTime()) {
            //Pintar las rayas horizontales
            for (int i = 0; i <= NUM_ROWS; i++) {
                if (i % 3 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.drawLine(0, CELL_SIZE * i, CELL_SIZE * NUM_COLUMNS, CELL_SIZE * i);
            }
            //Pintar las rayas verticales
            for (int i = 0; i <= NUM_COLUMNS; i++) {
                if (i % 3 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.drawLine(CELL_SIZE * i, 0, CELL_SIZE * i, CELL_SIZE * NUM_ROWS);
            }
            //TODO: Pintar los cuadros de las celdas
            //TODO: Pintar los valores            
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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        rowSelected = evt.getY() / CELL_SIZE;
        colSelected = evt.getX() / CELL_SIZE;
        if (rowSelected >= NUM_ROWS || colSelected >= NUM_COLUMNS) {
            rowSelected = -1;
            colSelected = -1;
        } else if (sudoku.isInInitialPuzzle(rowSelected, colSelected)) {
            rowSelected = -1;
            colSelected = -1;
        }
        repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (getRowSelected() != -1 && getColSelected() != -1) {
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
                sudoku.setValue(getRowSelected(), getColSelected(), evt.getKeyChar());
                repaint();
                if (sudoku.isFinished()) {
                    //TODO: Adaptar al idioma del sistema
                    String msgLevelCompleted = "Nivel completado";
                    Locale locale = new Locale("ES", "EN");
                    ResourceBundle bundle = ResourceBundle.getBundle("res/strings", locale);
                    //Obtener el idioma por defecto del sistema (de la máquina virtual Java)
                    locale = Locale.getDefault();
                    //Método que muestra una serie de etiquetas en el idioma seleccionado.
                   
                    //Ahora en Español
                    locale = new Locale("ES","ES");
    
                    //Ahora en aleman
                    locale = new Locale("ES","DE");
                 
                    
                    JOptionPane.showMessageDialog(this, msgLevelCompleted, "Sudoku", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                    || evt.getKeyCode() == KeyEvent.VK_DELETE) {
                sudoku.removeValue(getRowSelected(), getColSelected());
                repaint();
            }
        }
    }//GEN-LAST:event_formKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void showPersonData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
