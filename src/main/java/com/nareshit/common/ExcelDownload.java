package com.nareshit.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nareshit.dto.EmployeeDto;

public class ExcelDownload extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-disposition", "attachment; filename=\"emp_list.xls\"");

		List<EmployeeDto> list = (List<EmployeeDto>) model.get("lisOfEmp");

		Sheet sheet = workbook.createSheet("Employee List");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("EID");
		header.createCell(1).setCellValue("ENAME");
		header.createCell(2).setCellValue("SALARY");
		header.createCell(3).setCellValue("MOB NUB");

		int rowNum = 1;

		for (EmployeeDto employeeDto : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(employeeDto.getEid());
			row.createCell(1).setCellValue(employeeDto.getEname());
			row.createCell(2).setCellValue(employeeDto.getSal());
			row.createCell(3).setCellValue(employeeDto.getMobileNum());

		}

	}

}
