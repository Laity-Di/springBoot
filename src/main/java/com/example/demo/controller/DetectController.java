package com.example.demo.controller;

import com.example.demo.service.detect.IDetectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;


/**
 * @Author ZhuDi
 * @Time 2019-06-17
 * @Description
 * @ModifyTime
 */
@RestController
@RequestMapping("/detect/")
public class DetectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetectController.class);

    @Autowired
    private IDetectService iDetectService;


    @PostMapping("v1.0.0/plant/")
    public Object plantDetect(@RequestParam("file") MultipartFile file){

        Map<String, Object> detectResult = iDetectService.plantDetect(file);;
//        if (!("00").equals(detectResult.get("code"))){
//
//        }


        return detectResult;

    }

    @PostMapping("v1.0.0/common/")
    public Object commonDetect(@RequestParam("file") MultipartFile file){

        Map<String, Object> detectResult = iDetectService.commonDetect(file);;
//        if (!("00").equals(detectResult.get("code"))){
//
//        }


        return detectResult;

    }

    @PostMapping("v1.0.0/dish/")
    public Object dishDetect(@RequestParam("file") MultipartFile file){

        Map<String, Object> detectResult = iDetectService.dishDetect(file);;
//        if (!("00").equals(detectResult.get("code"))){
//
//        }


        return detectResult;

    }

    @PostMapping("v1.0.0/car/")
    public Object carDetect(@RequestParam("file") MultipartFile file){

        Map<String, Object> detectResult = iDetectService.carDetect(file);;
//        if (!("00").equals(detectResult.get("code"))){
//
//        }


        return detectResult;

    }

    @PostMapping("v1.0.0/animal/")
    public Object animalDetect(@RequestParam("file") MultipartFile file){

        Map<String, Object> detectResult = iDetectService.animalDetect(file);;
//        if (!("00").equals(detectResult.get("code"))){
//
//        }


        return detectResult;

    }

}
