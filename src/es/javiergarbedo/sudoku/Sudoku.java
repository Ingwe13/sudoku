package es.javiergarbedo.sudoku;

public class Sudoku {

    private char[][] puzzle;
    private String initialPuzzle;
    private final int SIZE = 9;

    public Sudoku(String initialPuzzle) {
        this.initialPuzzle = initialPuzzle;
        puzzle = new char[SIZE][SIZE];
        int positionInString = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                puzzle[row][col] = initialPuzzle.charAt(positionInString);
                positionInString++;
            }
        }
    }

    public char getValue(int row, int col) {
        if (puzzle[row][col] != '.') {
            return puzzle[row][col];
        } else {
            return ' ';
        }
    }

    public boolean setValue(int row, int col, char value) {
        //Sólo podrá añadir el valor si la posición está libre, no se encuentra
        //  ese valor en la misma fila, ni en la misma columna, ni el mismo cuadro3x3
        if (puzzle[row][col] == '.' && !isNumInRow(value, row)
                && !isNumIncolumn(value, col) && !isNumIn3x3Box(value, row, col)
                && value >= '0' && value <= '9') {
            puzzle[row][col] = value;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeValue(int row, int col) {
        //Permite eliminar si esa posición estaba vacía en el puzzle inicial
        if (!isInInitialPuzzle(row, col)) {
            puzzle[row][col] = '.';
            return true;
        } else {
            return false;
        }
    }

    public boolean isFinished() {
        //Si hay algún punto en el array, el sudoku no está finalizado
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (puzzle[row][col] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isInInitialPuzzle(int row, int col) {
        int positionInString = row * SIZE + col;
        return initialPuzzle.charAt(positionInString) != '.';
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < SIZE; row++) {
            if (row % 3 == 0) {
                result += "\n";
            }
            for (int col = 0; col < SIZE; col++) {
                if (col % 3 == 0) {
                    result += ' ';
                }
                result += puzzle[row][col];
            }
            result += "\n";
        }
        return result;
    }

    private boolean isNumInRow(char value, int row) {
        for (int col = 0; col < SIZE; col++) {
            if (puzzle[row][col] == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumIncolumn(char value, int col) {
        for (int row = 0; row < SIZE; row++) {
            if (puzzle[row][col] == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumIn3x3Box(char value, int row, int col) {
        int startRow, endRow, startCol, endCol;
        //Obtener la fila inicial y final correspondiente al cuadro donde se encuentre la fila y columna solicitada
        // 8 > 6
        startRow = (row / 3) * 3;
        endRow = startRow + 2;
        startCol = (col / 3) * 3;
        endCol = startCol + 2;
        //Recorrer el cuadro comprobando si existe el número
        for (int iRow = startRow; iRow <= endRow; iRow++) {
            for (int iCol = startCol; iCol <= endCol; iCol++) {
                if (puzzle[iRow][iCol] == value) {
                    return true;
                }
            }
        }
        return false;
    }

}
