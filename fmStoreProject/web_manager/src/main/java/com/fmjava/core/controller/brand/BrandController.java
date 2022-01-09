package com.fmjava.core.controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fmjava.core.pojo.entity.PageResult;
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
 * @Description: 品牌前端控制类
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;


    @RequestMapping("/getAllBrands")
    public List<Brand> findAll(){
        List<Brand> allBrands = brandService.findAll();
        return allBrands;
    }

    /**
     *功能描述
     * @author HeLong
     * @param page：当前页 pageSize：一次查询多少条记录
     * @return 返回查询结果实体
     */
    @RequestMapping("/findPage")
    public PageResult findPage(Integer page, Integer pageSize){
        PageResult pageResult =  brandService.findPage(page,pageSize);
        return pageResult;
    }



}
