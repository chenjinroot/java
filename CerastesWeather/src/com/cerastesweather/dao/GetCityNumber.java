/*
 ======================================================
 Name        : GetCityNumber.java
 Author      : cerastes
 Version     : 1.0
 Copyright   : Copyright chen 2013. All rights reserved.
 Description : ����ip��ȡ�������Ͷ�Ӧ����Ԥ������numder
 Made in China
 ======================================================
 */
package com.cerastesweather.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GetCityNumber {

	/*
	 * ��http://iframe.ip138.com/ic.asp��ȡ������������ip��ַ�����ڳ���
	 */
	public static String getWebCon(String domain) {
		System.out.println("��ʼ��ȡ����...(" + domain + ")");
		StringBuffer sb = new StringBuffer();
		try {
			java.net.URL url = new java.net.URL(domain);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();

		} catch (Exception e) { // Report any errors that arise
			sb.append(e.toString());
			System.err.println(e);
			System.err
					.println("Usage:   java   HttpClient   <URL>   [<filename>]");
		}
		return sb.toString();
	}

	/*
	 * �����http://iframe.ip138.com/ic.asp��õ����ݣ����س�����Ϣ
	 */
	public static String getLocation(String domain) {
		String ipString = domain;
		int a = ipString.indexOf("����");
		int b = ipString.indexOf("</center>");

		if (a > 0 && b > 0 && a < b) {
			ipString = ipString.substring(ipString.indexOf("����"),
					ipString.indexOf("</center>"));
			ipString = ipString.replace("���ԣ�", "");
			ipString = ipString.replace("��", "");
			ipString = ipString.replace("ʡ", "");
			ipString = ipString.replace("��", "");
			ipString = ipString.replace("��", "");
			ipString = ipString.replace("��", "");
			ipString = ipString.replace("��", "");
			ipString = ipString.replace("�ֵ�", "");
			ipString = ipString.replace("������", "");
			ipString = ipString.replace("����", "");
			String city[] = ipString.split(" ");
			ipString = city[0];
		} else {
			System.out.println(ipString);
			ipString = "�������⣡��";
		}
		return ipString;
	}

	/*
	 * ���ݳ��л�ȡ���б���
	 */
	public static String cityNum(String cityString) {
		String cityNum = "û���ҵ�";
		try {
			String encoding = "GBK";
			String filePath = "src/com/cerastesweather/resource/citys.txt";
			File file = new File(filePath);
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);// ���ǵ������ʽ
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					lineTxt = lineTxt.replace(" ", "");
					int a = lineTxt.indexOf("=");

					if (a > 0 && lineTxt.split("=").length == 2
							&& lineTxt.split("=")[1].equals(cityString)) {
						cityNum = lineTxt.split("=")[0];
					}
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return cityNum;
	}

	public static String getCityNumber() {
		String webCon = getWebCon("http://iframe.ip138.com/ic.asp");
		System.out.println(webCon);
		String cityString = getLocation(webCon);
		System.out.println("���ڳ���Ϊ��" + cityString);
		String cityNum = cityNum(cityString);
		System.out.println("���д���Ϊ" + cityNum);
		return cityNum;
	}

}
