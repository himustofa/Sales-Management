package com.mk.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mk.model.Award;
import com.mk.model.Education;
import com.mk.model.Experience;

public interface IEmployeeRecordDAO {

	int deleteEmployeeEducation(Map<String, Object> request);

	Education getEmployeeEducationDocById(UUID id);

	UUID updateEmployeeEducationDoc(Education employeeEducation);

	List<Education> getAllEmployeeEducationDoc(Map<String, String> params);

	int deleteEmployeeAward(Map<String, Object> request);

	Award getEmployeeAwardDocById(UUID id);

	UUID updateEmployeeAwardDoc(Award employeeAward);

	List<Award> getAllEmployeeAwardDoc(Map<String, String> params);

	int deleteEmployeeExperience(Map<String, Object> request);

	Experience getEmployeeExperienceDocById(UUID id);

	UUID updateEmployeeExperienceDoc(Experience employeeExprience);

	List<Experience> getAllEmployeeExperienceDoc(Map<String, String> params);

}
