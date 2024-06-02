package com.ribasdevelopment.excel_generator.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ribasdevelopment.excel_generator.models.Post;

@Service
public class ExcelService {
	
    public ByteArrayInputStream createExcel(List<Post> posts) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Sheet sheet = workbook.createSheet("Pessoas");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("UserId");
            headerRow.createCell(2).setCellValue("Title");
            headerRow.createCell(3).setCellValue("Body");

            int rowIdx = 1;
            for (Post post : posts) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(post.getId());
                row.createCell(1).setCellValue(post.getUserId());
                row.createCell(2).setCellValue(post.getTitle());
                row.createCell(3).setCellValue(post.getBody());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } finally {
            workbook.close();
        }
    }
}
