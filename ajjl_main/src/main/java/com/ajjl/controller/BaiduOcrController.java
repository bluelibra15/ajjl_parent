package com.ajjl.controller;

import ch.qos.logback.core.util.FileUtil;
import com.ajjl.common.HttpUtil;
import com.ajjl.common.MyTools;
import com.ajjl.pojo.Result;
import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;


@RestController
@RequestMapping("/baiduOcr")
public class BaiduOcrController {
    //设置APPID/AK/SK
    public static final String APP_ID = "19479627";
    public static final String API_KEY = "drVYF8NkGGRO1Qj3o5MUtsGx";
    public static final String SECRET_KEY = "83cwYWtrrSA2qOU1zQnmLRIuv798CMcE ";


    @RequestMapping("/strOcr")
    public Result strOcr(@RequestBody Map<String,String> map){
        // 请求url
        Gson gson = new Gson();
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        try {
            String imageBase64 = map.get("imageBase64");
            String encode = URLEncoder.encode(imageBase64, "UTF-8");
            String param = "image=" + encode;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = getAuth(API_KEY,SECRET_KEY);

            String result = HttpUtil.post(url, accessToken, param);
            //System.out.println(result);
            Map map2 = (Map<String,Object>)gson.fromJson(result, Map.class);
            List<Map<String,String>> wordsLists = (ArrayList<Map<String,String>>)map2.get("words_result");
            List<String> strings = new ArrayList<>();
            for (Map<String, String> wordsList : wordsLists) {
                String words = wordsList.get("words");
                strings.add(words);
            }
            MyTools.logInfo(strings);
            return new Result(true,"识别成功",strings);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"识别失败");
        }
    }

    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            //for (String key : map.keySet()) {
            //    System.err.println(key + "--->" + map.get(key));
            //}
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            //System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
