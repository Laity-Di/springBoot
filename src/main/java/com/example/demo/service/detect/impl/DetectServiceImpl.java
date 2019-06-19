package com.example.demo.service.detect.impl;

import com.example.demo.constant.CodeNumber;
import com.example.demo.service.detect.IDetectService;
import com.example.demo.utils.BaiduImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhuDi
 * @Time 2019-06-18
 * @Description
 * @ModifyTime
 */
@Service
public class DetectServiceImpl implements IDetectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetectServiceImpl.class);

    @Override
    public Map<String, Object> plantDetect(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();
        try {
            result = BaiduImage.plantDetect(file);
        }catch (Exception e){
            LOGGER.error("调用BaiduImage.imageDetect出现异常，异常信息为：{}", e.getMessage());
            result.put("code", CodeNumber.ERROR_CODE);
        }

        return result;
    }

    @Override
    public Map<String, Object> commonDetect(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();
        try {
            result = BaiduImage.commonDetect(file);
        }catch (Exception e){
            LOGGER.error("调用BaiduImage.commonDetect出现异常，异常信息为：{}", e.getMessage());
            result.put("code", CodeNumber.ERROR_CODE);
        }

        return result;
    }

    @Override
    public Map<String, Object> dishDetect(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();
        try {
            result = BaiduImage.dishDetect(file);
        }catch (Exception e){
            LOGGER.error("调用BaiduImage.dishDetect出现异常，异常信息为：{}", e.getMessage());
            result.put("code", CodeNumber.ERROR_CODE);
        }

        return result;
    }

    @Override
    public Map<String, Object> carDetect(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();
        try {
            result = BaiduImage.carDetect(file);
        }catch (Exception e){
            LOGGER.error("调用BaiduImage.carDetect出现异常，异常信息为：{}", e.getMessage());
            result.put("code", CodeNumber.ERROR_CODE);
        }

        return result;
    }

    @Override
    public Map<String, Object> animalDetect(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();
        try {
            result = BaiduImage.animalDetect(file);
        }catch (Exception e){
            LOGGER.error("调用BaiduImage.animalDetect出现异常，异常信息为：{}", e.getMessage());
            result.put("code", CodeNumber.ERROR_CODE);
        }

        return result;
    }
}
