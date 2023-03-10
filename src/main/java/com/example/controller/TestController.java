package com.example.controller;

/**
 * @author Chenjl
 * @date 2023/3/8 14:48
 */

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TestController {
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/completions";

    public static void main(String[] args) throws IOException {
//        test1();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json");
        requestHeaders.set("Authorization", "Bearer " + API_KEY);

        HttpHost proxy = new HttpHost("127.0.0.1", 7890);
        HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
            @Override
            public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                // 如果需要对请求的URL进行定制化处理，可以在这里进行
                return super.determineProxy(target, request, context);
            }
        }).build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "text-davinci-003");
        requestBody.put("prompt", "Hello, how are you?");
        requestBody.put("max_tokens", 4000);
        requestBody.put("temperature",0.5);

        HttpEntity<Map<String, Object>> fromEntity = new HttpEntity<>(requestBody, requestHeaders);

        String responseBody = restTemplate.postForObject(API_URL, fromEntity, String.class);
        System.out.println(responseBody);
    }

    private static void test1() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost(API_URL);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "Bearer " + API_KEY);
        request.setHeader("Connection", "keep-alive");

        String prompt = "你好";
        String requestBody = String.format("{\"prompt\":\"%s\",\"max_tokens\":5000,\"model\":text-davinci-003,\"temperature\":0.5}", URLEncoder.encode(prompt, "UTF-8"));

        request.setEntity(new StringEntity(requestBody));

        HttpResponse response = client.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());

        System.out.println(responseBody);
    }
}
