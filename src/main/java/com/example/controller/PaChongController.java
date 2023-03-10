package com.example.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chenjl
 * @date 2022/11/3 16:31
 */
@RestController
public class PaChongController {

    public static void main(String[] args) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.guidexs.com/82203/tc_824341.html";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();
        int j = body.indexOf("<script type=\"text/javascript\">app2();</script>");
        j += 64;
        body = body.substring(j);
        List<String> strings = Arrays.asList(body.split("<br/><br/>"));
        String msg = "";
        for (int i = 0; i < strings.size() - 2; i++) {
            msg += strings.get(i) + "\n";
        }
        msg +="\n\n\n";
        ttt(msg,url);
//        test();
    }

    private static void test() throws IOException {
        Integer start = 10;
        Integer end = 10;
        for (int i = start; i <= end; i++) {
            String url = "https://www.xiashuyun.com/416663/read_" + i + ".html";
            Document document = null;
            try {
                document = Jsoup.parse(new URL(url), 10000);
            } catch (IOException e) {
                System.out.println("加载到   " + url + "    出问题");
                throw e;
            }
            String h1 = document.getElementsByTag("h1").first().text();
            String content = document.getElementsByClass("content_detail").html();
            String text = h1 + "\n" + content + "\n\n\n";
            ttt(text, url);
        }
        System.out.println("写入信息完成");
    }

    private static void ttt(String content, String url) throws IOException {
        try {
            File file = new File("寒门.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            //使用true，即进行append file

            FileWriter fileWritter = new FileWriter(file.getName(), true);


            fileWritter.write(content);

            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载到" + url + "出问题");
        }
    }
}
