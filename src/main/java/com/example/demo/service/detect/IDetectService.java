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

    /**
     * 植物识别
     * @param file
     * @return
     */
    public Map<String, Object> plantDetect(MultipartFile file);

    /**
     * 通用物体识别
     * @param file
     * @return
     */
    public Map<String, Object> commonDetect(MultipartFile file);

    /**
     * 菜品识别
     * @param file
     * @return
     */
    public Map<String, Object> dishDetect(MultipartFile file);

    /**
     * 汽车识别
     * @param file
     * @return
     */
    public Map<String, Object> carDetect(MultipartFile file);

    /**
     * 动物识别
     * @param file
     * @return
     */
    public Map<String, Object> animalDetect(MultipartFile file);
}
