package com.mk.service;

import java.util.List;
import java.util.Map;

import com.mk.bean.WSResponse;
import com.mk.model.Award;
import com.mk.model.Education;
import com.mk.model.Experience;


public interface IEmployeeRecordService {

	WSResponse manageEmployeeOfficialRecord(Map<String, String[]> request);

	List<Education> getAllEmpEducation(Map<String, String> map);

	List<Award> getAllEmpAward(Map<String, String> map);

	List<Experience> getAllEmpExperience(Map<String, String> map);

}
