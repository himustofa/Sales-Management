package com.mk.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mk.bean.Validation;
import com.mk.bean.WSResponse;
import com.mk.dao.IEmployeeRecordDAO;
import com.mk.model.Award;
import com.mk.model.Education;
import com.mk.model.Experience;

@Service("employeeRecordService")
public class EmployeeRecordService implements IEmployeeRecordService {

//	@Autowired(required=true)
//	@Qualifier("employeeRecordDAO")
//	IEmployeeRecordDAO employeeRecordDAO;
	
	@Autowired
	IEmployeeRecordDAO employeeRecordDAO;
	
	
	/***************************************** Insert & Update ******************************************/

	@Override
	public WSResponse manageEmployeeOfficialRecord(Map<String, String[]> request) {

		String successMessage = "Saved successfully";
		String errorMessage = "Unsuccessful";

		UUID id = null;
		UUID awdId = null;
		UUID expId = null;
		
		//User currentUser = userService.getCurrentUser();
		ArrayList<String> commonErrors = this.validateOfficialRecord(request);			//Modal fields validation
		System.out.println("Errors Service=======================================================" + commonErrors.size());
		

		String companyName = request.get("company_name")[0];
		String companyCode = request.get("company_code")[0];
		String empCode = request.get("emp_code")[0];
		String empName = request.get("emp_name")[0];
		
		System.err.println("Service company code====" + companyCode);
		System.err.println("Service company name====" + companyName);
		System.err.println("Service emp code====" + empCode);
		System.err.println("Service emp name====" + empName);
		
		
		//=============== Education ===============
		
		String[] ids = (String[]) request.get("education_id[]");
		String[] degrees = (String[]) request.get("degree[]");
		String[] institute = (String[]) request.get("institute[]");
		String[] passingYear = (String[]) request.get("passing_year[]");
		String[] result = (String[]) request.get("result[]");
		String[] educationType = (String[]) request.get("education_type[]");
		String[] remarkEducation = (String[]) request.get("remark[]");
		System.err.println("Service Education ID Array==============================================" + Arrays.toString(ids));

		//System.err.println("Service degrees====" + degrees.toString());
		//System.err.println("Service passingYear====" + passingYear.toString());
		
		if (commonErrors.size() == 0) {
			Education empEducation = new Education();

			Map<String, Object> deleteEducationRequest = new HashMap<String, Object>();
			deleteEducationRequest.put("ids", ids);
			deleteEducationRequest.put("clientCode", "MK");
			deleteEducationRequest.put("companyCode", companyCode);
			deleteEducationRequest.put("empCode", request.get("emp_code")[0]);
			employeeRecordDAO.deleteEmployeeEducation(deleteEducationRequest);

			for (int i = 0; degrees != null && i < degrees.length; i++) {
				if (ids[i] != null && !ids[i].equals("")) {
					empEducation = employeeRecordDAO.getEmployeeEducationDocById(UUID.fromString(ids[i]));
					empEducation.setUpdatedByCode("786");
					empEducation.setUpdatedByName("Mustofa Kamal");
					empEducation.setUpdatedByCompanyCode("MK");
					empEducation.setUpdatedByCompanyName("MK Enterprise");
					empEducation.setUpdatedByUsername("hikamal");
					empEducation.setUpdatedByEmail("mustofa2008@gmail.com");
					empEducation.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				} else {
					empEducation = new Education();
					empEducation.setCreatedByCode("786");
					empEducation.setCreatedByName("Mustofa Kamal");
					empEducation.setCreatedByCompanyCode("MK");
					empEducation.setCreatedByCompanyName("MK Enterprise");
					empEducation.setCreatedByEmail("mustofa2008@gmail.com");
					empEducation.setCreatedByUsername("hikamal");
					empEducation.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				}
				
				empEducation.setEmpCode(empCode);
				empEducation.setEmpName(empName);
				empEducation.setCompanyCode(companyCode);
				empEducation.setCompanyName(companyName);
				empEducation.setClientCode("MK");
				empEducation.setClientName("mkgroup");

				empEducation.setDegree(degrees[i]);
				empEducation.setInstitute(institute[i]);
				empEducation.setPassingYear(passingYear[i]);
				empEducation.setResult(result[i]);
				empEducation.setEducationType(educationType[i]);
				empEducation.setRemark(remarkEducation[i]);

				id = employeeRecordDAO.updateEmployeeEducationDoc(empEducation);
			}
		}
		
		

		//=============== Award ===============
		
		String[] awardId = (String[]) request.get("award_id[]");
		String[] awardName = (String[]) request.get("award_name[]");
		String[] organizationName = (String[]) request.get("organization_name[]");
		String[] achievementDate = (String[]) request.get("achievement_date[]");
		System.err.println("Service Award ID Array===================================================" + Arrays.toString(awardId));
		
		//System.err.println("Service awardName====" + awardName.toString());
		//System.err.println("Service organizationName====" + organizationName.toString());
		
		if (commonErrors.size() == 0) {
			Award empAward = new Award();

			Map<String, Object> deleteAwardRequest = new HashMap<String, Object>();
			deleteAwardRequest.put("awardId", awardId);
			deleteAwardRequest.put("clientCode", "MK");
			deleteAwardRequest.put("companyCode", companyCode);
			deleteAwardRequest.put("empCode", request.get("emp_code")[0]);
			employeeRecordDAO.deleteEmployeeAward(deleteAwardRequest);

			for (int i = 0; awardName != null && i < awardName.length; i++) {
				if (awardId[i] != null && !awardId[i].equals("")) {
					empAward = employeeRecordDAO.getEmployeeAwardDocById(UUID.fromString(awardId[i]));
					empAward.setUpdatedByCode("786");
					empAward.setUpdatedByName("Mustofa Kamal");
					empAward.setUpdatedByCompanyCode("MK");
					empAward.setUpdatedByCompanyName("MK Enterprise");
					empAward.setUpdatedByUsername("hikamal");
					empAward.setUpdatedByEmail("mustofa2008@gmail.com");
					empAward.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				} else {
					empAward = new Award();
					empAward.setCreatedByCode("786");
					empAward.setCreatedByName("Mustofa Kamal");
					empAward.setCreatedByCompanyCode("MK");
					empAward.setCreatedByCompanyName("MK Enterprise");
					empAward.setCreatedByEmail("mustofa2008@gmail.com");
					empAward.setCreatedByUsername("hikamal");
					empAward.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				}
				
				empAward.setEmpCode(empCode);
				empAward.setEmpName(empName);
				empAward.setCompanyCode(companyCode);
				empAward.setCompanyName(companyName);
				empAward.setClientCode("MK");
				empAward.setClientName("mkgroup");

				empAward.setAwardName(awardName[i]);
				empAward.setOrganizationName(organizationName[i]);
				empAward.setAchievementDate(achievementDate[i]);

				awdId = employeeRecordDAO.updateEmployeeAwardDoc(empAward);
			}
		}
		
		
		
		//=============== Experience ===============
		
		String[] experienceId = (String[]) request.get("experience_id[]");
		String[] orgName = (String[]) request.get("org_name[]");
		String[] role = (String[]) request.get("role[]");
		String[] startDate = (String[]) request.get("start_date[]");
		String[] endDate = (String[]) request.get("end_date[]");
		String[] remarkExperience = (String[]) request.get("remark_experience[]");
		System.err.println("Service Experience ID Array==============================================" + Arrays.toString(experienceId));
		
		//System.err.println("Service orgName====" + orgName.toString());
		//System.err.println("Service role====" + role.toString());
		//System.err.println("Service startDate====" + startDate.toString());
		//System.err.println("Service endDate====" + endDate.toString());
		
		if (commonErrors.size() == 0) {
			Experience empExperience = new Experience();

			Map<String, Object> deleteExperienceRequest = new HashMap<String, Object>();
			deleteExperienceRequest.put("experienceId", experienceId);
			deleteExperienceRequest.put("clientCode", "MK");
			deleteExperienceRequest.put("companyCode", companyCode);
			deleteExperienceRequest.put("empCode", request.get("emp_code")[0]);
			employeeRecordDAO.deleteEmployeeExperience(deleteExperienceRequest);

			for (int i = 0; orgName != null && i < orgName.length; i++) {
				if (experienceId[i] != null && !experienceId[i].equals("")) {
					empExperience = employeeRecordDAO.getEmployeeExperienceDocById(UUID.fromString(experienceId[i]));
					empExperience.setUpdatedByCode("786");
					empExperience.setUpdatedByName("Mustofa Kamal");
					empExperience.setUpdatedByCompanyCode("MK");
					empExperience.setUpdatedByCompanyName("MK Enterprise");
					empExperience.setUpdatedByUsername("hikamal");
					empExperience.setUpdatedByEmail("mustofa2008@gmail.com");
					empExperience.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				} else {
					empExperience = new Experience();
					empExperience.setCreatedByCode("786");
					empExperience.setCreatedByName("Mustofa Kamal");
					empExperience.setCreatedByCompanyCode("MK");
					empExperience.setCreatedByCompanyName("MK Enterprise");
					empExperience.setCreatedByEmail("mustofa2008@gmail.com");
					empExperience.setCreatedByUsername("hikamal");
					empExperience.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				}
				
				empExperience.setEmpCode(empCode);
				empExperience.setEmpName(empName);
				empExperience.setCompanyCode(companyCode);
				empExperience.setCompanyName(companyName);
				empExperience.setClientCode("MK");
				empExperience.setClientName("mkgroup");

				empExperience.setOrginations(orgName[i]);
				empExperience.setRole(role[i]);
				empExperience.setStartDate(startDate[i]);
				empExperience.setEndDate(endDate[i]);
				empExperience.setRemark(remarkExperience[i]);
				
				expId = employeeRecordDAO.updateEmployeeExperienceDoc(empExperience);
			}
		}
		

		if (id != null || awdId != null || expId != null) {
			return WSResponse.createSuccess(successMessage, null, null);		//null = object empEducation | empAward | empExperience
		} else {
			return WSResponse.createFailure(errorMessage, commonErrors.toArray(new String[commonErrors.size()]));
		}
		
		
	}

	
	/***************************************** Server Side Validation ******************************************/

	public ArrayList<String> validateOfficialRecord(Map<String, String[]> requestMap) {

		ArrayList < String > errors = new ArrayList < String > ();
		
       /* if (Validation.isStrEmpty(requestMap.get("company_code")[0])) {
            errors.add("Company Code should not be empty");
        }

        if (Validation.isStrEmpty(requestMap.get("emp_code")[0])) {
            errors.add("Employee Code should not be empty");
        }
        
        String[] ids = (String[]) requestMap.get("education_id[]");
        String[] degrees = (String[]) requestMap.get("degree[]");
		String[] passingYear = (String[]) requestMap.get("passing_year[]");
		String[] institute = (String[]) requestMap.get("institute[]");
		String[] result = (String[]) requestMap.get("result[]");
		String[] educationType = (String[]) requestMap.get("education_type[]");
		String[] remarkEducation = (String[]) requestMap.get("remark[]");
		
		for (int i = 0; degrees != null && i < degrees.length; i++) {
//			if (ids[i] != null && !ids[i].equals("")) {
				if (!degrees[i].matches("^[a-zA-Z0-9,.:;'!-_ ]{1,150}+$")) {
					errors.add("Degree should not be empty and length must be maximum 150 characters");
				}
//			}
		}
		for (int i = 0; passingYear != null && i < passingYear.length; i++) {
//			if (ids[i] != null && !ids[i].equals("")) {
				String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";	//Sample: 1900|2000-01-31
				String regexYear = "^((19|20)\\d\\d)$";		//OR ^(19|20)\d{2}$
				if (!Pattern.matches(regexYear, passingYear[i])) { //^[0-9]{4}+$
					errors.add("Passing Year should not be empty and must be valid");
				}
//			}
		}
		for (int i = 0; institute != null && i < institute.length; i++) {
			if (Validation.isValidLength(institute[i], 255)){
				errors.add("Institute length must be maximum 255 characters");
			}
		}
		for (int i = 0; result != null && i < result.length; i++) {
			if (Validation.isValidLength(result[i], 50)){
				errors.add("Result length must be maximum 50 characters");
			}
		}
		for (int i = 0; educationType != null && i < educationType.length; i++) {
			if (Validation.isValidLength(educationType[i], 50)){
				errors.add("Education Type length must be maximum 50 characters");
			}
		}
		for (int i = 0; remarkEducation != null && i < remarkEducation.length; i++) {
			if (Validation.isValidLength(remarkEducation[i], 255)){
				errors.add("Remark length must be maximum 255 characters");
			}
		}
		
		String[] awardId = (String[]) requestMap.get("award_id[]");
		String[] awardName = (String[]) requestMap.get("award_name[]");
		String[] organizationName = (String[]) requestMap.get("organization_name[]");
		String[] achievementDate = (String[]) requestMap.get("achievement_date[]");
		
		for (int i = 0; awardName != null && i < awardName.length; i++) {
//			if (awardId[i] != null && !awardId[i].equals("")) {
				if (!awardName[i].matches("^[a-zA-Z0-9,.:;'!-_ ]{1,150}+$")) {
					errors.add("Award should not be empty and length must be maximum 150 characters");
				}
//			}
		}
		for (int i = 0; awardName != null && i < organizationName.length; i++) {
//			if (awardId[i] != null && !awardId[i].equals("")) {
				if (!organizationName[i].matches("^[a-zA-Z0-9,.:;'!-_ ]{1,255}+$")) {
					errors.add("Organization Name should not be empty and length must be maximum 255 characters");
				}
//			}
		}
		for (int i = 0; achievementDate != null && i < achievementDate.length; i++) {
			if(!Validation.isValidDate(achievementDate[i])){
				errors.add("Invalid achievement date format");
			} 
			if(Validation.compareDateWithCurrentDate(achievementDate[i])== false){
				errors.add("Invalid achievement date");
     		}
		}
		
		String[] experienceId = (String[]) requestMap.get("experience_id[]");
		String[] orgName = (String[]) requestMap.get("org_name[]");
		String[] role = (String[]) requestMap.get("role[]");
		String[] startDate = (String[]) requestMap.get("start_date[]");
		String[] endDate = (String[]) requestMap.get("end_date[]");
		String[] remarkExperience = (String[]) requestMap.get("remark_experience[]");
		
		for (int i = 0; orgName != null && i < orgName.length; i++) {
//			if (experienceId[i] != null && !experienceId[i].equals("")) {
				if (!orgName[i].matches("^[a-zA-Z0-9,.:;'!-_ ]{1,150}+$")) {
					errors.add("Organization Name should not be empty and length must be maximum 150 characters");
				}
//			}
		}
		for (int i = 0; orgName != null && i < role.length; i++) {
//			if (experienceId[i] != null && !experienceId[i].equals("")) {
				if (!role[i].matches("^[a-zA-Z0-9,.:;'!-_ ]{1,200}+$")) {
					errors.add("Role should not be empty and length must be maximum 200 characters");
				}
//			}
		}
		for (int i = 0; startDate != null && i < startDate.length; i++) {
			if(!Validation.isValidDate(startDate[i])){
				errors.add("Invalid start date format");
			}
		}
		for (int i = 0; endDate != null && i < endDate.length; i++) {
			if(!Validation.isValidDate(endDate[i])){
				errors.add("Invalid end date format");
			}
		}
		for (int i = 0; remarkExperience != null && i < remarkExperience.length; i++) {
			if (Validation.isValidLength(remarkExperience[i], 255)){
				errors.add("Remark length must be maximum 255 characters");
			}
		}*/

		
        return errors;
	}
	
	/***************************************** OTHER ******************************************/
	
	@Override
	public List<Education> getAllEmpEducation(Map<String, String> map) {
		return employeeRecordDAO.getAllEmployeeEducationDoc(map);
	}
	
	@Override
	public List<Award> getAllEmpAward(Map<String, String> map) {
		return employeeRecordDAO.getAllEmployeeAwardDoc(map);
	}
	
	@Override
	public List<Experience> getAllEmpExperience(Map<String, String> map) {;
		return employeeRecordDAO.getAllEmployeeExperienceDoc(map);
	}

	
}
