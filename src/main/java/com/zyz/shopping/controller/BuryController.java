package com.zyz.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyz.shopping.bury.BuryDTO;
import com.zyz.shopping.bury.KafkaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/duangduang/api/buries")
public class BuryController {

    @Autowired
    private KafkaUtil kafkaUtil;

    @PostMapping("/")
    public Integer bury(@RequestBody BuryDTO buryDTO) {
        String content = JSONObject.toJSONString(buryDTO);
        kafkaUtil.send(content);
        return 1;
    }
}
