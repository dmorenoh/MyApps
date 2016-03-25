package com.app.sudoku.controller.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmorenoh on 17/3/16.
 */
public class Sudoku {
    private static final int TOTAL_CELLS = 81;

    private Cell[][] board = new Cell[9][9];

    private Map<Integer, Region> rows = new HashMap<Integer, Region>();
    private Map<Integer, Region> columns = new HashMap<Integer, Region>();
    private Map<Integer, Region> boxes = new HashMap<Integer, Region>();

}
