package com.nareshit.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nareshit.dto.EmployeeDto;

public class PdfDownload extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setHeader("Content-disposition", "attachment; filename=\"emp_list.pdf\"");

		List<EmployeeDto> list = (List<EmployeeDto>) model.get("lisOfEmp");

		Table table = new Table(4);
		table.addCell("EID");
		table.addCell("ENAME");
		table.addCell("SALARY");
		table.addCell("MOB NUM");

		for (EmployeeDto employeeDto : list) {
			table.addCell(String.valueOf(employeeDto.getEid()));
			table.addCell(employeeDto.getEname());
			table.addCell(String.valueOf(employeeDto.getSal()));
			table.addCell(employeeDto.getMobileNum());
		}
		document.add(table);
	}

}
