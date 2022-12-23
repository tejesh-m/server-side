package com.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.record.entity.EmploymentRecord;
import com.record.service.IRecordService;

@RestController
@RequestMapping("/record")
public class EmployeeRecordController {

	@Autowired
	private IRecordService recordService;

	@GetMapping("/emp/{empId}")
	public List<EmploymentRecord> getRecord(@PathVariable("empId") Long empId) {
		return this.recordService.getRecordOfEmployee(empId);

	}
}
