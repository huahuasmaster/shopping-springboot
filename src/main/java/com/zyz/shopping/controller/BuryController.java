package com.zyz.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyz.shopping.bury.BuryDTO;
import com.zyz.shopping.bury.KafkaUtil;
import com.zyz.shopping.http.DuangDuangResponse;
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

    @PostMapping("")
    public DuangDuangResponse bury(@RequestBody BuryDTO buryDTO) {
        String content = JSONObject.toJSONString(buryDTO);
        kafkaUtil.send(content);
        return DuangDuangResponse.success(1);
    }
}
