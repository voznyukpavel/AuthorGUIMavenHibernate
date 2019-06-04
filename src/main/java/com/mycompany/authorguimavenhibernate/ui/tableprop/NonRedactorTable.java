/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.authorguimavenhibernate.ui.tableprop;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pavel
 */
public class NonRedactorTable extends DefaultTableModel {

    private ArrayList nonEditableCells = new ArrayList();

    public NonRedactorTable(Vector v1, Vector v2) {
        super(v1, v2);
    }

//				public NonRedactorTable(Vector tableData, Vector<String> tableHeaders) {
//								super(v1,v2);
//				}
    public void setColumnEditable(int column, boolean editable) {
        for (int i = 0; i < this.getRowCount(); i++) {
            if (editable) {
                while (nonEditableCells.remove(new Cell(i, column))) {
                }
            } else {
                nonEditableCells.add(new Cell(i, column));
            }
        }
    }

    class Cell {

        Integer Row = null;
        Integer Col = null;

        public Cell(Integer row, Integer col) {
            if (row != null) {
                this.Row = row;
            } else {
                this.Row = 0;
            }
            if (col != null) {
                this.Col = col;
            } else {
                this.Col = 0;
            }
        }

        public Integer getRow() {
            return this.Row;
        }

        public Integer getCol() {
            return this.Col;
        }

        public boolean equals(Cell cell) {
            if (cell.getRow() == this.getRow() && cell.getCol() == this.getCol()) {
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object oCell) {
            Cell cell = (Cell) oCell;
            return equals(cell);
        }
    }
}
