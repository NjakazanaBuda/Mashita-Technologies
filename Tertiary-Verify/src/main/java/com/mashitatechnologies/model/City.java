package com.mashitatechnologies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mashitatechnologies.helper.IDataEntity;
import com.mashitatechnologies.model.Provinces;
import com.mashitatechnologies.serializer.CitySerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(using = CitySerializer.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="city")

public class City implements IDataEntity,java.io.Serializable{
	
	
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id", unique = true, nullable = false)
	private Long cityId;
	
	@Column(name = "city_name", nullable = false)
	private String cityName;
	
	@Column(name = "city_abbriation", nullable = false)
	private String cityAbbriation;
	
	@Column(name = "city_code", nullable = false)
	private int cityCode;
	
    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
	private Provinces provinces;
	
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	public String getCityAbbriation() {
		return cityAbbriation;
	}

	public void setCityAbbriation(String cityAbbriation) {
		this.cityAbbriation = cityAbbriation;
	}
	
	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	
	//@ManyToOne
	//@JoinColumn(name = "province_id", nullable = false)
	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}
	
	@Override
	public String toString() {
		return "Cities [cityId=" + cityId + ", cityAbbriation=" + cityAbbriation + ", cityCode=" + cityCode 
				+ ", cityName=" + cityName + ", provinces=" + provinces + "]";
	}

}
