package com.nareshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nareshit.common.ExcelDownload;
import com.nareshit.common.PdfDownload;
import com.nareshit.dto.EmployeeDto;
import com.nareshit.exception.EmployeeException;
import com.nareshit.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/")
	public ModelAndView employeeOperation() {
		return new ModelAndView("saveEmp");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmp(EmployeeDto employeeDto) {
		System.out.println(employeeDto);
		if (employeeDto.getEname().isEmpty() || employeeDto.getSal() == null || employeeDto.getMobileNum().isEmpty()) {
			throw new EmployeeException("Employee Details " + employeeDto + " can't Null !");
		} else {
			employeeService.saveEmployee(employeeDto);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
	public ModelAndView getAllEmployee() {
		ModelAndView modelAndView = new ModelAndView("listEmp");
		modelAndView.addObject("listOfEmps", employeeService.findAllEmployees());
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{eid}", method = RequestMethod.GET)
	public String removeEmployee(@PathVariable(value = "eid") String eid) {
		if (eid != null) {
			employeeService.removeEmployee(Long.valueOf(eid));
		} else {
			throw new EmployeeException("Employee Id " + eid + " can't NULL!");
		}
		return "redirect:/getAllEmp";
	}

	@RequestMapping(value = "/update/{eid}", method = RequestMethod.GET)
	public ModelAndView getEmployeeById(@PathVariable(value = "eid") String eid) {
		ModelAndView modelAndView = new ModelAndView("updateEmp");
		if (eid != null) {
			modelAndView.addObject("singleEmpRecords", employeeService.findEmplyoeeById(Long.valueOf(eid)));
		} else {
			throw new EmployeeException("Employee Id " + eid + " can't NULL!");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(EmployeeDto employeeDto) {
		System.out.println(employeeDto);
		if (employeeDto.getEname().isEmpty() || employeeDto.getSal() == null || employeeDto.getMobileNum().isEmpty()) {
			throw new EmployeeException("Employee Details " + employeeDto + " can't Null !");
		} else {
			employeeService.editEmployee(employeeDto);
		}
		return "redirect:/getAllEmp";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView downloadFiles(@RequestParam(value = "type") String type) {
		System.out.println(type + "   Download File Controller");
		ModelAndView modelAndView = new ModelAndView("listEmp");
		if (type != null && type.equals("xls")) {
			return new ModelAndView(new ExcelDownload(), "lisOfEmp", employeeService.findAllEmployees());
		} else if (type.equals("pdf")) {
			return new ModelAndView(new PdfDownload(), "lisOfEmp", employeeService.findAllEmployees());
		}

		return modelAndView;
	}

}
