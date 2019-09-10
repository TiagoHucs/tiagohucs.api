package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Musica;
import com.example.repository.MusicaRepository;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    @Autowired
    MusicaRepository musicaRepository;

    public HSSFWorkbook criaRelatorio() throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetMusicas = workbook.createSheet("Musicas");

        List<Musica> musicaList = musicaRepository.findAll();

        CellStyle styleTitulo = StyleRelatorioBuilder.getStyleTitulo(workbook);
        CellStyle styleLinha = StyleRelatorioBuilder.getStyleLinha(workbook);

        int rownum = 0;

        Row row = sheetMusicas.createRow(rownum++);
        int cellnum = 0;
        Cell cellTitleNome = row.createCell(cellnum++);
        cellTitleNome.setCellValue("Nome");
        cellTitleNome.setCellStyle(styleTitulo);
        Cell cellTitleLink = row.createCell(cellnum++);
        cellTitleNome.setCellStyle(styleTitulo);
        cellTitleLink.setCellValue("Link");

        rownum = 1;
        for (Musica musica : musicaList) {
            row = sheetMusicas.createRow(rownum++);
            cellnum = 0;
            Cell cellNome = row.createCell(cellnum++);
            cellNome.setCellStyle(styleLinha);
            cellNome.setCellValue(musica.getNome());
            Cell cellLink = row.createCell(cellnum++);
            cellLink.setCellStyle(styleLinha);
            cellLink.setCellValue(musica.getLink());
        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File("relatorio.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");
            return workbook;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
        }
        return null;
    }

    public byte[] criarArquivoRelatorio() {


        ByteArrayOutputStream relatorioBytes = null;

        try {
            HSSFWorkbook workbook = criaRelatorio();
            relatorioBytes = new ByteArrayOutputStream();
            workbook.write(relatorioBytes);
            relatorioBytes.close();
        } catch (IOException e) {
            //log.error("Erro ao tentar gravar o relatório Excel.\n {}", e.getMessage(), e);
            System.out.println("Erro ao tentar gravar o relatório Excel. "+ e);
        } finally {
            IOUtils.closeQuietly(relatorioBytes);
        }
        return relatorioBytes.toByteArray();
    }
    
}
