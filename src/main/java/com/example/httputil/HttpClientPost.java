package com.example.httputil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Chenjl
 */
@Component
public class HttpClientPost {

    public static String post(String url, String body) throws Exception {
        return post(url, body, null, 0);
    }

    public static String post(String url, String body, String proxyIp, int proxyPort)
            throws Exception {
        return post(url, body, null, proxyIp, proxyPort);
    }

    public static String post(String url, String body, Map<String, String> headers, String proxyIp, int proxyPort)
            throws Exception {
        return post(url, null, body, headers, proxyIp, proxyPort,0);
    }
    public static String post(String url, String body, Map<String, String> headers, String proxyIp, int proxyPort, int timeOut)
            throws Exception {
        return post(url, null, body, headers, proxyIp, proxyPort,timeOut);
    }

    public static String post(String url, Map<String, String> params, String body, Map<String, String> headers, String proxyIp, int proxyPort,int timeOut)
            throws Exception {
//		CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpClient httpclient = new SSLClient();
        HttpPost httpPost = new HttpPost(buildUrlWithQueryString(url, params));
        if (null != proxyIp && 0 != proxyPort) {
            HttpHost proxy = new HttpHost(proxyIp, proxyPort, "http");
            if(timeOut==0){
                //增加超时时间
                RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(250000).setSocketTimeout(250000).setConnectTimeout(250000).setProxy(proxy).build();
                httpPost.setConfig(config);
            }else{
                RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeOut).setSocketTimeout(timeOut).setConnectTimeout(timeOut).setProxy(proxy).build();
                httpPost.setConfig(config);
            }

        }
        if (!StringUtils.isEmpty(body)) {
            StringEntity requestEntity = new StringEntity(body, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(requestEntity);
        }
        if (null == headers) {
            httpPost.addHeader("Content-Type", "application/json");
        } else {
            for (String key : headers.keySet()) {
                httpPost.addHeader(key, headers.get(key));
            }
        }
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String resp = EntityUtils.toString(responseEntity, "UTF-8");
        return resp;
    }

    /**
     * Build queryString of the url
     */
    private static String buildUrlWithQueryString(String url, Map<String, String> queryParas) {
        if (queryParas == null || queryParas.isEmpty()) {
            return url;
        }

        StringBuilder sb = new StringBuilder(url);
        boolean isFirst;
        if (url.indexOf('?') == -1) {
            isFirst = true;
            sb.append('?');
        } else {
            isFirst = false;
        }

        for (Entry<String, String> entry : queryParas.entrySet()) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append('&');
            }

            String key = entry.getKey();
            String value = entry.getValue();
            if (!StringUtils.isEmpty(value)) {
                try {
                    value = URLEncoder.encode(value, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
            sb.append(key).append('=').append(value);
        }
        return sb.toString();
    }
}
