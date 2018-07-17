package com.mashitatechnologies.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.mashitatechnologies.constants.UserURIConstants;
import com.mashitatechnologies.dao.ProvincesDAO;
import com.mashitatechnologies.model.Provinces;

public class ProvinceControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/mashitatechnologies";
	
	public static void main(String args[]) {
		
		System.out.println("*****");
		testCreateProvince();
		System.out.println("*****");
		testGetAllProvinces();

	}

	private static void testCreateProvince() {
		
		ProvincesDAO dao = new ProvincesDAO();
		Provinces province1 = new Provinces();
		Provinces province2 = new Provinces();
		Provinces province3 = new Provinces();
		Provinces province4 = new Provinces();
		Provinces province5 = new Provinces();
		Provinces province6 = new Provinces();
		Provinces province7 = new Provinces();
		Provinces province8 = new Provinces();
		Provinces province9 = new Provinces();
		
		province1.setProvinceName("Gauteng");
		province1.setProvinceAbbriation("GP");
		province2.setProvinceName("Mpumalanga");
		province2.setProvinceAbbriation("MP");
		province3.setProvinceName("Limpompo");
		province3.setProvinceAbbriation("L");
		province4.setProvinceName("North West");
		province4.setProvinceAbbriation("NW");
		province5.setProvinceName("Free State");
		province5.setProvinceAbbriation("FS");
		province6.setProvinceName("KwaZulu Natal");
		province6.setProvinceAbbriation("KZN");
		province7.setProvinceName("Eastern Cape");
		province7.setProvinceAbbriation("EC");
		province8.setProvinceName("Western Cape");
		province8.setProvinceAbbriation("WC");
		province9.setProvinceName("Northern Cape");
		province9.setProvinceAbbriation("NC");
		
		
		try {
			System.out.println(dao.createProvince(province1));
			System.out.println(dao.createProvince(province2));
			System.out.println(dao.createProvince(province3));
			System.out.println(dao.createProvince(province4));
			System.out.println(dao.createProvince(province5));
			System.out.println(dao.createProvince(province6));
			System.out.println(dao.createProvince(province7));
			System.out.println(dao.createProvince(province8));
			System.out.println(dao.createProvince(province9));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void testGetAllProvinces() {
		ProvincesDAO dao = new ProvincesDAO();
		try {
			List<Provinces> allProvince = dao.getAllProvinces();
			for(Provinces province: allProvince) {
				System.out.println("Province Name " + province.getProvinceName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
