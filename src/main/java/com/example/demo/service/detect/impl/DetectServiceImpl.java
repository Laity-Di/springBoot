package com.example.demo.service.detect.impl;

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
    public Map<String, Object> imageDetect(MultipartFile file) {

        Map<String, Object> result = new HashMap<>();
        try {
            result = BaiduImage.imageDetect(file);
        }catch (Exception e){
            LOGGER.error("调用BaiduImage.imageDetect出现异常，异常信息为：{}", e.getMessage());
            result.put("code", "50");
        }

        return result;
    }
}
