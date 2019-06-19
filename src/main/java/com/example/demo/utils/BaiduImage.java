package com.example.demo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.example.demo.constant.CodeNumber;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ZhuDi
 * @Time 2019-06-17
 * @Description
 * @ModifyTime
 */
@Slf4j
public class BaiduImage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaiduImage.class);

    private static final String APP_ID = "16541437";
    private static final String API_KEY = "zl05GSQvuKaye0QfW4RfmETn";
    private static final String SECRET_KEY = "frVHzLdjFqvUlmH5CBphVKkAqXrWz24c";

    private static AipImageClassify client = null;

    /**
     * 植物类图片识别
     * @param file
     * @return
     * @throws IOException
     */
    public static Map<String, Object> plantDetect(MultipartFile file) throws Exception {

        Map<String, Object> result = new HashMap<>();
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap();
        options.put("baike_num", "5");

        JSONObject res = client.plantDetect(file.getBytes(), options);

        if(res.has("error_code")){
            LOGGER.error("调用云识图接口出现错误，错误信息为：{}", String.valueOf(res));
            result.put("code", CodeNumber.MAP_ERROR_CODE);
        }else {
            String score = res.getJSONArray("result").getJSONObject(0).getString("score");
            if(CodeNumber.NUM_ZERO.equals(score)){
                LOGGER.info("调用云识别返回错误，图片识别为非植物：{}", String.valueOf(res));
                result.put("code", CodeNumber.MAP_PARAM_ERROR_CODE);
            }else{
                result.put("code",CodeNumber.MAP_SUCCESS_CODE);
                result.put("result", getResultMap(res));
            }

        }
        return result;
    }

    /**
     * 通用物体识别
     * @param file
     * @return
     * @throws Exception
     */
    public static Map<String, Object> commonDetect(MultipartFile file) throws Exception {

        Map<String, Object> result = new HashMap<>();
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap();
        options.put("baike_num", "5");

        JSONObject res = client.advancedGeneral(file.getBytes(), options);

        if(res.has("error_code")){
            LOGGER.error("调用云识图接口出现错误，错误信息为：{}", String.valueOf(res));
            result.put("code", CodeNumber.MAP_ERROR_CODE);
        }else {
            String score = res.getJSONArray("result").getJSONObject(0).getString("score");
            if(CodeNumber.NUM_ZERO.equals(score)){
                LOGGER.info("调用云识别返回错误，图片识别非能识别：{}", String.valueOf(res));
                result.put("code", CodeNumber.MAP_PARAM_ERROR_CODE);
            }else{
                result.put("code",CodeNumber.MAP_SUCCESS_CODE);
                result.put("result", getResultMap(res));
            }

        }
        return result;
    }

    /**
     * 菜品识别
     * @param file
     * @return
     * @throws Exception
     */
    public static Map<String, Object> dishDetect(MultipartFile file) throws Exception {

        Map<String, Object> result = new HashMap<>();
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap();
        options.put("baike_num", "5");

        JSONObject res = client.dishDetect(file.getBytes(), options);

        if(res.has("error_code")){
            LOGGER.error("调用云识图接口出现错误，错误信息为：{}", String.valueOf(res));
            result.put("code", CodeNumber.MAP_ERROR_CODE);
        }else {
            String score = res.getJSONArray("result").getJSONObject(0).getString("score");
            if(CodeNumber.NUM_ZERO.equals(score)){
                LOGGER.info("调用云识别返回错误，图片识别为非菜品：{}", String.valueOf(res));
                result.put("code", CodeNumber.MAP_PARAM_ERROR_CODE);
            }else{
                result.put("code",CodeNumber.MAP_SUCCESS_CODE);
                result.put("result", getResultMap(res));
            }

        }
        return result;
    }

    /**
     * 汽车识别
     * @param file
     * @return
     * @throws Exception
     */
    public static Map<String, Object> carDetect(MultipartFile file) throws Exception {

        Map<String, Object> result = new HashMap<>();
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap();
        options.put("baike_num", "5");

        JSONObject res = client.carDetect(file.getBytes(), options);

        if(res.has("error_code")){
            LOGGER.error("调用云识图接口出现错误，错误信息为：{}", String.valueOf(res));
            result.put("code", CodeNumber.MAP_ERROR_CODE);
        }else {
            String score = res.getJSONArray("result").getJSONObject(0).getString("score");
            if(CodeNumber.NUM_ZERO.equals(score)){
                LOGGER.info("调用云识别返回错误，图片识别为非汽车：{}", String.valueOf(res));
                result.put("code", CodeNumber.MAP_PARAM_ERROR_CODE);
            }else{
                result.put("code",CodeNumber.MAP_SUCCESS_CODE);
                result.put("result", getResultMap(res));
            }

        }
        return result;
    }

    /**
     * 动物识别
     * @param file
     * @return
     * @throws Exception
     */
    public static Map<String, Object> animalDetect(MultipartFile file) throws Exception {

        Map<String, Object> result = new HashMap<>();
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap();
        options.put("baike_num", "5");

        JSONObject res = client.animalDetect(file.getBytes(), options);

        if(res.has("error_code")){
            LOGGER.error("调用云识图接口出现错误，错误信息为：{}", String.valueOf(res));
            result.put("code", CodeNumber.MAP_ERROR_CODE);
        }else {
            String score = res.getJSONArray("result").getJSONObject(0).getString("score");
            if(CodeNumber.NUM_ZERO.equals(score)){
                LOGGER.info("调用云识别返回错误，图片识别为非动物：{}", String.valueOf(res));
                result.put("code", CodeNumber.MAP_PARAM_ERROR_CODE);
            }else{
                result.put("code",CodeNumber.MAP_SUCCESS_CODE);
                result.put("result", getResultMap(res));
            }

        }
        return result;
    }

    /**
     * 根据接口返回信息拼装结果集
     * @param response
     * @return
     * @throws Exception
     */
    private static Map<String, Object> getResultMap(JSONObject response) throws Exception{

        Map<String, Object> result = new HashMap<>();

        JSONArray resultArray = response.getJSONArray("result");

        List associationalResult = new ArrayList();
        for(int i = 0; i < resultArray.length(); i ++){
            if(i == 0){
                result.put("name",resultArray.getJSONObject(i).get("name"));
                result.put("baike_url", resultArray.getJSONObject(i).getJSONObject("baike_info").get("baike_url"));
                result.put("description", resultArray.getJSONObject(i).getJSONObject("baike_info").get("description"));
            }else{
                associationalResult.add(resultArray.getJSONObject(i).get("name"));
            }
        }
        result.put("associationalResult", associationalResult);

        return result;
    }

}