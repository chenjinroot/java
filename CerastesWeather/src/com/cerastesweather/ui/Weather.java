/*
 ======================================================
 Name        : Weather.java
 Author      : cerastes
 Version     : 1.0
 Copyright   : Copyright chen 2013. All rights reserved.
 Description : ����
 Made in China
 ======================================================
 */
package com.cerastesweather.ui;

import java.util.ArrayList;
import java.util.List;

import com.cerastesweather.dao.GetCityNumber;
import com.cerastesweather.dao.GetWeather;
import com.cerastesweather.domain.Weeks;

public class Weather {

	public static void main(String[] args) {
		// ��ȡ���б��
		String cityNumber = GetCityNumber.getCityNumber();
		System.out.println(cityNumber);
		List<Weeks> weeks = new ArrayList<Weeks>();
		// ��ȡ����
		if (cityNumber.equals("û���ҵ�")) {

		} else {
			try {
				GetWeather getWeather = new GetWeather(cityNumber);
				weeks = getWeather.getWeekList();
				System.out.println(weeks.size());
				for (int i = 0; i < weeks.size(); i++) {
					System.out.println(weeks.get(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
