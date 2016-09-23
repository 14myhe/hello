package com.tomyca.loginout;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Logout 
{
	public Logout()
	{
		try
		{ 
			//action(表单)
			// 建立连接 
			URL url = new URL("http://a.stu.edu.cn/ac_portal/login.php"); 
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection(); 
			// //设置连接属性 
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出 
			httpConn.setDoInput(true);// 使用 URL 连接进行输入 
			httpConn.setUseCaches(false);// 忽略缓存 
			httpConn.setRequestMethod("GET");// 设置URL请求方法 (Method)
			String requestString = "opr=logout"; 
			// 设置请求属性 
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致 
			byte[] requestStringBytes = requestString.getBytes("UTF-8"); 
			// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
			httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			// 建立输出流，并写入数据 
			OutputStream outputStream = httpConn.getOutputStream(); //包含connect（）方法
			outputStream.write(requestStringBytes); 
			outputStream.close(); 
			
			InputStream inStream=httpConn.getInputStream();
			inStream.close();
		}
		catch (Exception e) 
		{}
	}
	public static void main(String[] args) {
		new Logout();
	}
}

