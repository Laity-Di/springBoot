package com.example.demo.controller;

import com.example.demo.service.detect.IDetectService;
import com.example.demo.utils.BaiduImage;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DetectController {

    @Autowired
    private IDetectService iDetectService;


    @PostMapping("v1.0.0/plant/")
    public Object plantDetect(@RequestParam("file") MultipartFile file){

        Map<String, Object> detectResult = iDetectService.imageDetect(file);;
//        if (!("00").equals(detectResult.get("code"))){
//
//        }


        return detectResult;

    }

}
