package com.example.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

public class StyleRelatorioBuilder {

    public static CellStyle getStyleTitulo(HSSFWorkbook workbook){
        CellStyle styleTitulo = workbook.createCellStyle();
        styleTitulo.setAlignment(HorizontalAlignment.CENTER);
        styleTitulo.setWrapText(true);
        styleTitulo.setFillBackgroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        styleTitulo.setBorderRight(BorderStyle.THIN);
        styleTitulo.setRightBorderColor(IndexedColors.BLACK.getIndex());
        styleTitulo.setBorderLeft(BorderStyle.THIN);
        styleTitulo.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        styleTitulo.setBorderTop(BorderStyle.THIN);
        styleTitulo.setTopBorderColor(IndexedColors.BLACK.getIndex());
        styleTitulo.setBorderBottom(BorderStyle.THIN);
        styleTitulo.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        return styleTitulo;
    }

    public static CellStyle getStyleLinha(HSSFWorkbook workbook){
        CellStyle styleTitulo = workbook.createCellStyle();
        styleTitulo.setWrapText(true);
        styleTitulo.setBorderRight(BorderStyle.THIN);
        styleTitulo.setRightBorderColor(IndexedColors.BLACK.getIndex());
        styleTitulo.setBorderLeft(BorderStyle.THIN);
        styleTitulo.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        styleTitulo.setBorderTop(BorderStyle.THIN);
        styleTitulo.setTopBorderColor(IndexedColors.BLACK.getIndex());
        styleTitulo.setBorderBottom(BorderStyle.THIN);
        styleTitulo.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        return styleTitulo;
    }
}
