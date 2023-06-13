package com.example.demo.exporttoexcel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.model.Invoice;

public class ExportToExcel {

	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<Invoice> listInvoices;
	
	public ExportToExcel(List<Invoice> listInvoices) {
		
		this.listInvoices = listInvoices;
		workbook	=	new XSSFWorkbook();
	}
	
	private void writeHeaderLine() {
		
		sheet = workbook.createSheet("Export Invoices");
		
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		
		style.setFont(font);
		
		createCell(row, 0, "Invoice ID", style);      
        createCell(row, 1, "Invoice No", style);       
        createCell(row, 2, "Date", style);    
        createCell(row, 3, "Total", style);
        createCell(row, 4, "Customer Id", style);
		
	}
	
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		
		sheet.autoSizeColumn(columnCount);
		
		Cell cell = row.createCell(columnCount);
		
		if(value instanceof Integer) {
		     cell.setCellValue((Integer) value);
		    } else if (value instanceof Boolean) {
		        cell.setCellValue((Boolean) value);
		    }else {
		        cell.setCellValue((String) value);
		    }
		    cell.setCellStyle(style);
	
	}
	 private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	                 
	        for (Invoice invoice : listInvoices) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	             
	            createCell(row, columnCount++, invoice.getInvoice_id() , style);
	            createCell(row, columnCount++, invoice.getInvoice_no() , style);
	            createCell(row, columnCount++, invoice.getDate_added() , style);
	            createCell(row, columnCount++, invoice.getTotal_amount() , style);
	            createCell(row, columnCount++, invoice.getCustomer_id() , style);
	             
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
	    }
}