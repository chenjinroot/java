/*
 ======================================================
 Name        : Weeks.java
 Author      : cerastes
 Version     : 1.0
 Copyright   : Copyright chen 2013. All rights reserved.
 Description : ��������ģ��
 Made in China
 ======================================================
 */
package com.cerastesweather.domain;

public class Weeks {
	@Override
	public String toString() {
		
		return "����:"+city+"    "+
				"����:"+date_y+"    "+
				"����:"+week+"    "+
				"����ʱ��:"+fchh+"    "+
				"����:"+weather+"    "+
				"�¶�:"+temp+"    "+
				"���:"+wind+"    "+
				"����:"+fl+"    "+
				"����Ĵ���ָ��:"+index+"    "+
				"����ָ��:"+index_uv+"    "+
				"����ָ��:"+index_tr+"    "+
				"����ָ��:"+index_co+"    "+
				"����ָ��:"+index_cl+"    "+
				"ϴ��ָ��:"+index_xc+"    "+
				"index_xc:"+index_d+"    "
				;
	}
	private String city;// ����
	private String date_y;// ����
	private String week;// ����
	private String fchh;// ����ʱ��
	private String weather;// ����
	private String temp;// �¶�
	private String wind;// ���
	private String fl;// ����
	private String index;// ����Ĵ���ָ��
	private String index_uv;// ����ָ��
	private String index_tr;// ����ָ��
	private String index_co;// ����ָ��
	private String index_cl;// ����ָ��
	private String index_xc;// ϴ��ָ��
	private String index_d;// ������ϸ����ָ��
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate_y() {
		return date_y;
	}
	public void setDate_y(String date_y) {
		this.date_y = date_y;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getFchh() {
		return fchh;
	}
	public void setFchh(String fchh) {
		this.fchh = fchh;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getIndex_uv() {
		return index_uv;
	}
	public void setIndex_uv(String index_uv) {
		this.index_uv = index_uv;
	}
	public String getIndex_tr() {
		return index_tr;
	}
	public void setIndex_tr(String index_tr) {
		this.index_tr = index_tr;
	}
	public String getIndex_co() {
		return index_co;
	}
	public void setIndex_co(String index_co) {
		this.index_co = index_co;
	}
	public String getIndex_cl() {
		return index_cl;
	}
	public void setIndex_cl(String index_cl) {
		this.index_cl = index_cl;
	}
	public String getIndex_xc() {
		return index_xc;
	}
	public void setIndex_xc(String index_xc) {
		this.index_xc = index_xc;
	}
	public String getIndex_d() {
		return index_d;
	}
	public void setIndex_d(String index_d) {
		this.index_d = index_d;
	}

}
