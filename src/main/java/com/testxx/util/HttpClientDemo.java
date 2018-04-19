package com.testxx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientDemo {

    @RequestMapping("/home")
    public void home1() throws IOException {
        Student student = new Student();
        student.setName("张三");
        student.setAge(25);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(student);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        String url = "http://localhost/home2";
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity se = new StringEntity(jsonStr,"utf-8");
        se.setContentType("text/json");
        httpPost.setEntity(se);
        CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost);
        if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200){
            System.out.println("ok");
            String result = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(result);
        }

    }

    @RequestMapping("/home2")
    @ResponseBody
    public String home2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        ServletInputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String jsonStr = null;
        StringBuilder result = new StringBuilder();
        while ((jsonStr = reader.readLine()) != null){
            result.append(jsonStr);
        }
        reader.close();
        Gson gson = new Gson();
        Student student = gson.fromJson(result.toString(), Student.class);
        System.out.println(student);
        return "{result:ok}";
    }
}
