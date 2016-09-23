package com.tomyca.loginout;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class GetjsonData {

	    public static void main(String args[])
	    {
	        try {

//	            JSONObject  obj = new JSONObject();
//	                    obj.append("opr", "pwdLogin");
//	                    obj.append("rememberPwd", "0");
//	                    obj.append("userName", "14jqhuang");
//	                    obj.append("pwd","578111Jia");
	                    
//	            System.out.println(obj);
	            // 创建url资源
	            URL url = new URL("http://a.stu.edu.cn/ac_portal/login.php");
	            // 建立http连接
	            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	         // //设置连接属性 
				httpConn.setDoOutput(true);//使用 URL 连接进行输出
				httpConn.setDoInput(true);// 使用 URL 连接进行输入
				httpConn.setUseCaches(false);// 忽略缓存 
				httpConn.setRequestMethod("POST");// 设置URL请求方法 (Method)
//				String requestString = "opr=pwdLogin&userName=14jqhuang&pwd=578111Jia&rememberPwd=0"; 
				String requestString = "opr=pwdLogin&userName=14jqhuang&pwd=578111JIa&rememberPwd=0"; 
				// 设置请求属性 
				// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致 
//				byte[] requestStringBytes = obj.toString().getBytes("UTF-8"); 
				byte[] requestStringBytes = requestString.getBytes("UTF-8"); 
				System.out.println(requestStringBytes);
				// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
				httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

				// 建立输出流，并写入数据
				OutputStream outputStream = httpConn.getOutputStream(); //包含connect（）方法
				outputStream.write(requestStringBytes); 
				outputStream.close(); 
				System.out.println(httpConn.getResponseCode());
//				InputStream in=httpConn.getInputStream();
	            // 请求返回的状态
	            if (httpConn.getResponseCode() == 200) {
	                System.out.println("连接成功");
	                // 请求返回的数据
	                InputStream in = httpConn.getInputStream();
	                System.out.println("in : "+in);
	                System.out.println(9.9999878e-1);
	                System.out.println("count: "+in.available());
	                String a = null;
	                try {
	                    byte[] data1 = new byte[in.available()];
	                    System.out.println("data1 : "+data1);
	                    in.read(data1);
	                    // 转成字符串
	                    a = new String(data1);
	                    JSONObject ob = new JSONObject(a);
	                    System.out.println(ob.get("success"));
	                    in.close();
	                    System.out.println(a);
//	                    Thread.sleep(3000);
	                    new Getflux();
	                } catch (Exception e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	               
	            } else {
	                System.out.println("no++");
	            }

	        } catch (Exception e) {

	        }

	    }
}