package com.tomyca.loginout;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Getflux {

		    public Getflux()
		    {
		        try {

		            URL url = new URL("http://a.stu.edu.cn/ac_portal/userflux");
		            // 建立http连接
		            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		            //设置连接属性 
					httpConn.setDoOutput(true);//使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存 
					httpConn.setRequestMethod("POST");// 设置URL请求方法 (Method)
					String requestString = ""; 
					// 设置请求属性 
					// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致 
					byte[] requestStringBytes = requestString.getBytes("UTF-8"); 
					System.out.println(requestStringBytes);
					// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
					httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream(); //包含connect（）方法
					outputStream.write(requestStringBytes); 
					outputStream.close(); 
					System.out.println(httpConn.getResponseCode());
		            // 请求返回的状态
		            if (httpConn.getResponseCode() == 200) {
		                System.out.println("连接成功1");
		                // 请求返回的数据
		                InputStream in = httpConn.getInputStream();
		                String a = "null";
		                try {
		                    byte[] data1 = new byte[in.available()];
		                    in.read(data1);
		                    // 转成字符串
		                    a = new String(data1);
//		                    System.out.println("字符长度为： "+a.length());
//		                    System.out.println("用户名称长度为: "+a.indexOf("日流量额"));
//		                    System.out.println("14jqhuang的长度为： "+a.indexOf("14jqhuang"));
//		                    System.out.println("username: "+a.substring(187));
		                    
		                    System.out.println(a);
		                } catch (Exception e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		                finally{
		                	System.out.println("inputstream went wrong");
		                	in.close();
		                }
		            } else {
		                System.out.println("no++");
		            }

		        } catch (Exception e) {

		        }

		    }
		    
		    public static void main(String[] args) {
				new Getflux();
			}
}
