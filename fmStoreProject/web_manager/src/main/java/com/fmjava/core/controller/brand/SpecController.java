package com.fmjava.core.controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.entity.Result;
import com.fmjava.core.pojo.entity.SpecEntity;
import com.fmjava.core.pojo.specification.Specification;
import com.fmjava.core.service.brand.SpecificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/10/11:50
 * @Description: 规格控制器
 */
@RestController
@RequestMapping("/spec")
public class SpecController {

    @Reference
    private SpecificationService specificationService;

    /**
     * 规格分页查询
     * @author HeLong
     * @param spec：规格实体查询条件 page：当前页码 row：每页显示数据条数
     * @return 查询结果实体封装结果类
     */
    @RequestMapping("/search")
    public PageResult search( Integer page, Integer rows, @RequestBody Specification spec){
        PageResult result = specificationService.findPage(spec,page,rows);
        return result;
    }

    /**
     * 增加规格实体
     * @author HeLong
     * @param specEntity：规格封装实体
     * @return Result：保存结果状态信息
     */

    @RequestMapping("/add")
    public Result add(@RequestBody SpecEntity specEntity){
        try {
            specificationService.add(specEntity);
            return new Result(true,"保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"保存失败！");
        }
    }



}
