package de;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;

import javax.swing.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportPDF {
    // Định nghĩa font chữ cho văn bản trong PDF
	private static final Font FONT_NORMAL = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
	private static final Font FONT_BOLD = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);


    public static void exportSelectedRowToPDF(JTable table) throws IOException, DocumentException {
        // Create a new Document
        Document document = new Document();
        // Set margin
        document.setMargins(36f, 36f, 36f, 36f);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn đường dẫn lưu file PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int userChoice = fileChooser.showSaveDialog(null);
        if (userChoice == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Create PDF writer
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            // Open document
            document.open();

            // Create a PDF table with the same number of columns as JTable
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            // Add table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                // Thêm dòng này để sử dụng font chữ đã định nghĩa
                pdfTable.addCell(new com.itextpdf.text.Phrase(table.getColumnName(i), FONT_BOLD));
            }

            // Add selected row to PDF
            int selectedRow = table.getSelectedRow();
            for (int column = 0; column < table.getColumnCount(); column++) {
                Object value = table.getValueAt(selectedRow, column);
                if (value != null) {
                    // Thêm dòng này để sử dụng font chữ đã định nghĩa
                    pdfTable.addCell(new com.itextpdf.text.Phrase(value.toString(), FONT_NORMAL));
                } else {
                    // Handle null values
                    pdfTable.addCell("");
                }
            }

            document.add(pdfTable);
            document.close();
        }
    }
    
    public static void exportRowsToPDF1(List<List<Object>> rowDataList) throws IOException, DocumentException {
        // Tạo một hộp thoại cho phép người dùng chọn đường dẫn và tên file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn đường dẫn lưu file PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int userChoice = fileChooser.showSaveDialog(null);
        if (userChoice == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Create a new Document
            Document document = new Document();
            // Set margin
            document.setMargins(36f, 36f, 36f, 36f);

            // Create PDF writer
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            // Open document
            document.open();

            // Create a PDF table with 5 columns
            PdfPTable pdfTable = new PdfPTable(6);

            // Set column widths
            float[] columnWidths = {2f, 2f, 6f, 2f, 2f, 4f};
            pdfTable.setWidths(columnWidths);

            // Add column headers with bold font
            pdfTable.addCell(new PdfPCell(new Phrase("Details Export ID", FONT_BOLD)));
            pdfTable.addCell(new PdfPCell(new Phrase("Export ID", FONT_BOLD)));
            pdfTable.addCell(new PdfPCell(new Phrase("ProductName", FONT_BOLD)));
            pdfTable.addCell(new PdfPCell(new Phrase("Price", FONT_BOLD)));
            pdfTable.addCell(new PdfPCell(new Phrase("Approver", FONT_BOLD)));
            pdfTable.addCell(new PdfPCell(new Phrase("Date", FONT_BOLD)));

            // Loop through the list of row data
            for (List<Object> rowData : rowDataList) {
                // Add each row of data as a row in the PDF table
                for (Object cellData : rowData) {
                    pdfTable.addCell(new PdfPCell(new Phrase(cellData.toString(), FONT_NORMAL)));
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(null, "Xuất PDF thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }



}

