package com.dao;

import java.util.List;

import com.model.Hospital;

public interface HospitalDAO {

	int addHospital(Hospital hospital);
	int deleteHospital(String drName);
	int updateHospital(Hospital hospital);
	Hospital findDrByName(String drName);
	List<Hospital> showAllDrList();
}
