package com.example.spring_boot_scheduler.Services;

import com.example.spring_boot_scheduler.Model.Student;
import com.example.spring_boot_scheduler.Repository.StudentRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private StudentRepository studentRepository;

    public byte[] generateReport() throws IOException {
        List<Student> student = studentRepository.findAll();

        SXSSFWorkbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        writeHeaderLine(sheet);
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Student student1 : student) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, student1.getId(), style);
            createCell(row, columnCount++, student1.getName(), style);
            createCell(row, columnCount++, student1.getGender(), style);
            createCell(row, columnCount++, student1.getEmail(), style);
            createCell(row, columnCount++, student1.getPhone(), style);
            createCell(row, columnCount++, student1.getAddress(), style);
            createCell(row, columnCount++, student1.getCourse(), style);
            createCell(row, columnCount++, student1.getCollegeName(), style);
            createCell(row, columnCount++, student1.getStatus(), style);

        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
        } finally {
            bos.close();
        }
        return bos.toByteArray();

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }  else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }
        else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeHeaderLine(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("NAME");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("GENDER");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("EMAIL");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("PHONE");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("ADDRESS");

        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("COURSE");

        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("COLLEGE NAME");

        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("STATUS");

    }
}
