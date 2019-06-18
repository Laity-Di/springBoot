package com.example.demo.service.detect;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author ZhuDi
 * @Time 2019-06-18
 * @Description
 * @ModifyTime
 */
public interface IDetectService {

    public Map<String, Object> imageDetect(MultipartFile file);
}
