package com.example.demo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author ZhuDi
 * @Time 2019-06-17
 * @Description
 * @ModifyTime
 */
public class BaiduImage {
    //设置APPID/AK/SK
    public static final String APP_ID = "你的 App ID";
    public static final String API_KEY = "你的 Api Key";
    public static final String SECRET_KEY = "你的 Secret Key";
    public static AipImageClassify client = null;

    public static void main(String[] args) {
        // 初始化一个AipImageClassifyClient
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
// client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
// client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
// 也可以直接通过jvm启动参数设置此环境变量
// System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

// 调用接口
        String image = "D:/images/shu.jpg";
// JSONObject res = client.objectDetect(image, new HashMap());
// System.out.println(res.toString(2));
        BaiduImage.localImage(client, image);
    }

    public static void localImage(AipImageClassify client, String image) {
        // 传入可选参数调用接口
        HashMap options = new HashMap();

        JSONObject res = client.plantDetect(image, options);

    }


    // 获取植物名称
    public static Object getPlantName(MultipartFile file) throws IOException {
// 初始化一个AipImageClassifyClient
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

// 传入可选参数调用接口
        HashMap options = new HashMap();
// 参数为本地图片二进制数组
        JSONObject res = client.plantDetect(file.getBytes(), options);
// JSONArray jsonArray = res.getJSONArray("result");
// JSONObject jsonObject = null;
// Object object = "";
// for (int i = 0; i < jsonArray.length(); i++) {
// jsonObject = jsonArray.getJSONObject(i);
// object = jsonObject.get("name");
// }
        Object object = null;
        try {
            object = res.getJSONArray("result").getJSONObject(0).get("name");
        } catch (Exception e) {
            return "非植物,请重新上传";
        }
        return object;
    }
    // 获取动物名称
    public static Object getAnimalName(MultipartFile file) throws IOException {
// 初始化一个AipImageClassifyClient
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
// 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
// 传入可选参数调用接口
        HashMap options = new HashMap();
        options.put("top_num", "1");
// 参数为本地图片二进制数组
        JSONObject res = client.animalDetect(file.getBytes(), options);
        Object object = null;
        try {
            object = res.getJSONArray("result").getJSONObject(0).get("name");
        } catch (Exception e) {
            return "非动物,请重新上传";
        }
        return object;
    }
}