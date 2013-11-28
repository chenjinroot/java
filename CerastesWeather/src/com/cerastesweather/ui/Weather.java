/*
 ======================================================
 Name        : Weather.java
 Author      : cerastes
 Version     : 1.0
 Copyright   : Copyright chen 2013. All rights reserved.
 Description : 天气
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
		// 获取城市编号
		String cityNumber = GetCityNumber.getCityNumber();
		System.out.println(cityNumber);
		List<Weeks> weeks = new ArrayList<Weeks>();
		// 获取天气
		if (cityNumber.equals("没有找到")) {

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
