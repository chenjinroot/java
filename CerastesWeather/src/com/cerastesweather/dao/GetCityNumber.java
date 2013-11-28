/*
 ======================================================
 Name        : GetCityNumber.java
 Author      : cerastes
 Version     : 1.0
 Copyright   : Copyright chen 2013. All rights reserved.
 Description : 根据ip获取城市名和对应天气预报城市numder
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
	 * 从http://iframe.ip138.com/ic.asp获取本机所在网络ip地址和所在城市
	 */
	public static String getWebCon(String domain) {
		System.out.println("开始读取内容...(" + domain + ")");
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
	 * 处理从http://iframe.ip138.com/ic.asp获得的数据，返回城市信息
	 */
	public static String getLocation(String domain) {
		String ipString = domain;
		int a = ipString.indexOf("来自");
		int b = ipString.indexOf("</center>");

		if (a > 0 && b > 0 && a < b) {
			ipString = ipString.substring(ipString.indexOf("来自"),
					ipString.indexOf("</center>"));
			ipString = ipString.replace("来自：", "");
			ipString = ipString.replace("市", "");
			ipString = ipString.replace("省", "");
			ipString = ipString.replace("区", "");
			ipString = ipString.replace("县", "");
			ipString = ipString.replace("镇", "");
			ipString = ipString.replace("村", "");
			ipString = ipString.replace("街道", "");
			ipString = ipString.replace("自治区", "");
			ipString = ipString.replace("特区", "");
			String city[] = ipString.split(" ");
			ipString = city[0];
		} else {
			System.out.println(ipString);
			ipString = "网络问题！！";
		}
		return ipString;
	}

	/*
	 * 根据城市获取城市编码
	 */
	public static String cityNum(String cityString) {
		String cityNum = "没有找到";
		try {
			String encoding = "GBK";
			String filePath = "src/com/cerastesweather/resource/citys.txt";
			File file = new File(filePath);
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);// 考虑到编码格式
			if (file.isFile() && file.exists()) { // 判断文件是否存在
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
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return cityNum;
	}

	public static String getCityNumber() {
		String webCon = getWebCon("http://iframe.ip138.com/ic.asp");
		System.out.println(webCon);
		String cityString = getLocation(webCon);
		System.out.println("所在城市为：" + cityString);
		String cityNum = cityNum(cityString);
		System.out.println("城市代码为" + cityNum);
		return cityNum;
	}

}
