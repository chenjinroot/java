/*
 ======================================================
 Name        : GetWeather.java
 Author      : cerastes
 Version     : 1.0
 Copyright   : Copyright chen 2013. All rights reserved.
 Description : ���ݳ���numder��ȡ�������������������
 Made in China
 ======================================================
 */
package com.cerastesweather.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

//import com.cerastes.weather.Weather;
import com.cerastesweather.domain.Weeks;

public class GetWeather {
	private List<Weeks> weekList=new ArrayList<Weeks>();
	String Ctiyid;

	public List<Weeks> getWeekList() {
		return weekList;
	}

	URLConnection connectionData;
	StringBuilder sb;
	BufferedReader br;// ��ȡdata������
	JSONObject jsonData;
	JSONObject info;

	public GetWeather(String Cityid) throws IOException, NullPointerException {
		// ��������ip��ַ

		this.Ctiyid = Cityid;
		// ������������̨��API
		URL url = new URL("http://m.weather.com.cn/data/" + Ctiyid + ".html");
		connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		try {
			br = new BufferedReader(new InputStreamReader(
					connectionData.getInputStream(), "UTF-8"));
			sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (SocketTimeoutException e) {
			System.out.println("���ӳ�ʱ");
		} catch (FileNotFoundException e) {
			System.out.println("�����ļ�����");
		}
		String datas = sb.toString();
		System.out.println(datas);

		jsonData = JSONObject.fromObject(datas);
		// System.out.println(jsonData.toString());
		info = jsonData.getJSONObject("weatherinfo");

		// �õ�1��6����������
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= 6; i++) {
			// �õ�δ��6�������
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, i - 1);
			Date date = cal.getTime();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("city", info.getString("city").toString());// ����
			map.put("date_y", sf.format(date));// ����
			map.put("week", getWeek(cal.get(Calendar.DAY_OF_WEEK)));// ����
			map.put("fchh", info.getString("fchh").toString());// ����ʱ��
			map.put("weather", info.getString("weather" + i).toString());// ����
			map.put("temp", info.getString("temp" + i).toString());// �¶�
			map.put("wind", info.getString("wind" + i).toString());// ���
			map.put("fl", info.getString("fl" + i).toString());// ����
			map.put("index", info.getString("index").toString());// ����Ĵ���ָ��
			map.put("index_uv", info.getString("index_uv").toString());// ����ָ��
			map.put("index_tr", info.getString("index_tr").toString());// ����ָ��
			map.put("index_co", info.getString("index_co").toString());// ����ָ��
			map.put("index_cl", info.getString("index_cl").toString());// ����ָ��
			map.put("index_xc", info.getString("index_xc").toString());// ϴ��ָ��
			map.put("index_d", info.getString("index_d").toString());// ������ϸ����ָ��
			list.add(map);
		}
		// ����̨��ӡ������
		for (int j = 0; j < list.size(); j++) {
			Map<String, Object> wMap = list.get(j);
			System.out.println(wMap.get("city") + "\t" + wMap.get("date_y")
					+ "\t" + wMap.get("week") + "\t" + wMap.get("weather")
					+ "\t" + wMap.get("temp") + "\t" + wMap.get("index_uv")
					+ "\t" + wMap.get("wind") + "\t" + wMap.get("wind"));
			Weeks week = new Weeks();
			week.setCity(wMap.get("city")+"");
			week.setDate_y(wMap.get("date_y")+"");
			week.setFchh(wMap.get("fchh")+"");
			week.setFl(wMap.get("fl")+"");
			week.setIndex(wMap.get("index")+"");
			week.setIndex_cl(wMap.get("index_cl")+"");
			week.setIndex_co(wMap.get("index_co")+"");
			week.setIndex_d(wMap.get("index_d")+"");
			week.setIndex_tr(wMap.get("index_tr")+"");
			week.setIndex_uv(wMap.get("index_uv")+"");
			week.setIndex_xc(wMap.get("index_xc")+"");
			week.setTemp(wMap.get("temp")+"");
			week.setWeather(wMap.get("weather")+"");
			week.setWeek(wMap.get("week")+"");
			week.setWind(wMap.get("wind")+"");
			weekList.add(week);
		}

	}

	private String getWeek(int iw) {
		String weekStr = "";
		switch (iw) {
		case 1:
			weekStr = "������";
			break;
		case 2:
			weekStr = "����һ";
			break;
		case 3:
			weekStr = "���ڶ�";
			break;
		case 4:
			weekStr = "������";
			break;
		case 5:
			weekStr = "������";
			break;
		case 6:
			weekStr = "������";
			break;
		case 7:
			weekStr = "������";
			break;
		default:
			break;
		}
		return weekStr;
	}
}
