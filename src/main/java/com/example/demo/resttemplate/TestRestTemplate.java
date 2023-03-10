package com.example.demo.resttemplate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestRestTemplate {

	public static void main(String[] args) {

//		getMethod();

//		postMethod();
	}

	private static void getMethod() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://hz3z.cwgk.net:8899/bjAccount/frmctrl.do?method={getPubData}&pms={json}";
		Map<String,String> map = new HashMap<>();
		map.put("getPubData","GetPubData");
		String json = "{\"distno\":\"010558\",\"bdate\":\"2020-10-01\",\"edate\":\"2020-11-01\"," +
				"\"username\":\"测试村级\",\"password\":\"123456.\",\"tid\":\"zbinfo\"}";
		map.put("json",json);
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, map);
		String responseJson = response.getBody();
	}

	private static void postMethod() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> postForEntity = restTemplate.postForEntity("http://localhost:8084/hello", "a", String.class);
		String body = postForEntity.getBody();
		System.out.println(body);
		MediaType contentType = postForEntity.getHeaders().getContentType();
		System.out.println(contentType.getType());
	}
}
