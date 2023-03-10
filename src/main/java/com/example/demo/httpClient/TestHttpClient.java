package com.example.demo.httpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.expression.ParseException;

public class TestHttpClient {

	public static void main(String[] args) {
	 
			// 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	 
			// 创建Post请求
			HttpPost httpPost = new HttpPost("https://5ddd5c9c-cf53-47d6-aa13-a814157df8af.mock.pstmn.io/new");
			// 响应模型
			CloseableHttpResponse response = null;
			try {
				// 由客户端执行(发送)Post请求
				response = httpClient.execute(httpPost);
				// 从响应模型中获取响应实体
				HttpEntity responseEntity = response.getEntity();
	 
				System.out.println("响应状态为:" + response.getStatusLine());
				if (responseEntity != null) {
					System.out.println("响应内容长度为:" + responseEntity.getContentLength());
					System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// 释放资源
					if (httpClient != null) {
						httpClient.close();
					}
					if (response != null) {
						response.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
