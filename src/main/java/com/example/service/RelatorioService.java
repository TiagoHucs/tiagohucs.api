package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Musica;
import com.example.repository.MusicaRepository;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    @Autowired
    MusicaRepository musicaRepository;

    public FileOutputStream criaRelatorio() throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetMusicas = workbook.createSheet("Musicas");

        List<Musica> musicaList = musicaRepository.findAll();

        int rownum = 0;
        for (Musica musica : musicaList) {
            Row row = sheetMusicas.createRow(rownum++);
            int cellnum = 0;
            Cell cellNome = row.createCell(cellnum++);
            cellNome.setCellValue(musica.getNome());
            Cell cellLink = row.createCell(cellnum++);
            cellLink.setCellValue(musica.getLink());
        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File("relatorio.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");
            return out;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
        }
        return null;
    }
}
