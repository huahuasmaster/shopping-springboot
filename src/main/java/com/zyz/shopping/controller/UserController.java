package com.zyz.shopping.controller;

import com.zyz.shopping.dao.AddressRepository;
import com.zyz.shopping.http.DuangDuangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("duangduang/api/users")
public class UserController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/test")
    public DuangDuangResponse<String> test() {
        return DuangDuangResponse.error("喵喵喵？");
    }

    @GetMapping("/{userId}/addresses")
    public DuangDuangResponse<List> listAddressByUserId(@PathVariable("userId") Integer userId) {
        return DuangDuangResponse.success(addressRepository.findByUserId(userId));
    }
}
