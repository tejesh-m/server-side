package com.record.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.record.entity.EmploymentRecord;

@Service
public class RecordServiceImpl implements IRecordService {
	
	//fake list of employement record
	List<EmploymentRecord> list = List.of(
			new EmploymentRecord(101L, "TCS", "TCS@gmail.com", 3, 1310L),
			new EmploymentRecord(102L, "Infosys", "Infosys@gmail.com", 2, 1311L),
			new EmploymentRecord(103L, "CTS", "CTS@gmail.com", 7, 1312L),
			new EmploymentRecord(104L, "Wipro", "wipro@gmail.com", 2, 1313L),
			new EmploymentRecord(105L, "Lenovo", "Lenova@gmail.com", 5, 1313L),
			new EmploymentRecord(106L, "Google", "Google@gmail.com", 6, 1314L),
			new EmploymentRecord(107L, "Dell", "Dell@gmail.com", 3, 1315L),
			new EmploymentRecord(108L, "Hp", "Hp@gmail.com", 3, 1316L),
			new EmploymentRecord(109L, "Samsung", "Samsung@gmail.com", 4, 1317L)
			
			);

	@Override
	public List<EmploymentRecord> getRecordOfEmployee(Long empId) {
		return list.stream().filter(employmentRecord -> employmentRecord.getEmpId().equals(empId)).collect(Collectors.toList());
	}
	
}
