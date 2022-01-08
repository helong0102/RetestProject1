package com.fmjava.core.controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fmjava.core.pojo.good.Brand;
import com.fmjava.core.service.brand.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/08/16:45
 * @Description:
 */
@RestController
public class BrandController {

    @Reference
    private BrandService brandService;


    @RequestMapping("/getAllBrands")
    public List<Brand> findAll(){
        List<Brand> allBrands = brandService.findAll();
        return allBrands;
    }
}
