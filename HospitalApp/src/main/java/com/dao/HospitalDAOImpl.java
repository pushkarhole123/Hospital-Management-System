package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Hospital;
import com.utility.DBUtility;

public class HospitalDAOImpl implements HospitalDAO {

	@Override
	public int addHospital(Hospital hospital) {
		int noOfRows = 0;
		String sql = "INSERT INTO HOSPITAL VALUES(?, ?, ?)";
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, hospital.getDrName());
			ps.setString(2, hospital.getDept());
			ps.setDouble(3, hospital.getSalary());
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Add Hospital Issue " + e);
		}

		return noOfRows;
	}

	@Override
	public int deleteHospital(String drName) {
		int noOfRows = 0;
		String sql = "DELETE FROM HOSPITAL WHERE DR_NAME=?";
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, drName);
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Delete Hospital Issue " + e);
		}
		return noOfRows;
	}

	@Override
	public int updateHospital(Hospital hospital) {
		int noOfRows = 0;
		String sql = "UPDATE HOSPITAL SET DEPT=?, SALARY=? WHERE DR_NAME=?";
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, hospital.getDept());
			ps.setDouble(2, hospital.getSalary());
			ps.setString(3, hospital.getDrName());
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Update Hospital Issue " + e);
		}
		return noOfRows;
	}

	@Override
	public Hospital findDrByName(String drName) {
		Hospital hospital = null;
		String sql = "SELECT * FROM HOSPITAL WHERE DR_NAME=?";
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, drName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				hospital = new Hospital(rs.getString(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (Exception e) {
			System.out.println("Find Dr Name " + e);

		}
		return hospital;

	}

	@Override
	public List<Hospital> showAllDrList() {
		Hospital hospital = null;
		List<Hospital> list = new ArrayList<>();
		String sql = "SELECT * FROM HOSPITAL";
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hospital = new Hospital(rs.getString(1), rs.getString(2), rs.getDouble(3));
				list.add(hospital);
			}
		} catch(Exception e) { 
			System.out.println("Show All Hospital "+e);
		}
		return list;
	}

}
