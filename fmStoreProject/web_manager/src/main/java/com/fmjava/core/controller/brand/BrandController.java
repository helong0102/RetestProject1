package com.fmjava.core.controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.entity.Result;
import com.fmjava.core.pojo.good.Brand;
import com.fmjava.core.service.brand.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
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
     *品牌分页
     * @author HeLong
     * @param page：当前页 pageSize：一次查询多少条记录 searchBrand:查询条件
     * @return 返回查询结果实体
     */
    @RequestMapping("/findPage")
    public PageResult findPage(Integer page, Integer pageSize,@RequestBody Brand searchBrand){
        System.out.println(searchBrand);
        PageResult pageResult =  brandService.findPage(page,pageSize,searchBrand);
        return pageResult;
    }

    /**
     *添加品牌
     * @author HeLong
     * @param brand：需要添加的品牌数据
     * @return 返回添加成功或失败结果
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Brand brand){
        System.out.println(brand);
        try{
            brandService.add(brand);
            return new Result(true,"保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"保存失败！");
        }
    }

    /**
     *根据ID查询品牌
     * @author HeLong
     * @param id：品牌Id
     * @return 查询的品牌实体
     */
    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        Brand brand = brandService.findBrandWithId(id);
        System.out.println(brand);
        return brand;
    }

    /**
     * 修改品牌信息
     * @author HeLong
     * @param brand：更新后的品牌实体
     * @return 更新结果信息
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(true,"修改失败！");
        }
    }

    /**
     * 批量删除品牌
     * @author HeLong
     * @param ids：待删除品牌id
     * @return 删除结果状态信息
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            System.out.println(ids);
            brandService.delete(ids);
            return new Result(true,"删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(true,"删除失败！");
        }
    }

}
