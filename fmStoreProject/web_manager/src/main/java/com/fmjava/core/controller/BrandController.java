package com.fmjava.core.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fmjava.core.pojo.good.Brand;
import com.fmjava.core.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/08/9:46
 * @Description:
 */
@RestController
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/getname")
    public List<Brand> getName() {
        return brandService.getName();
    }
}
