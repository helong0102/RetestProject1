package com.fmjava.core.service.brand;

import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.good.Brand;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/08/16:40
 * @Description:
 */
public interface BrandService {

    public List<Brand> findAll();

    /**
     *分页查询
     * @author HeLong
     * @param page：当前页码；pageSize:一次查询多少条记录 searchBrand:查询条件
     * @return 返回查询结果实体
     */
    PageResult findPage(Integer page, Integer pageSize, Brand searchBrand);

    /**
     *添加品牌
     * @author HeLong
     * @param brand：需要添加的品牌数据
     * @return void
     */
    public void add(Brand brand);

    /**
     *根据ID查询品牌
     * @author HeLong
     * @param id：品牌Id
     * @return 查询的品牌实体
     */
    public Brand findBrandWithId(Long id);

    /**
     * 修改品牌信息
     * @author HeLong
     * @param brand：更新后的品牌实体
     * @return void
     */
    public void update(Brand brand);

    /**
     * 批量删除品牌
     * @author HeLong
     * @param ids：待删除品牌id
     * @return void
     */
    public void delete(Long[] ids);
}
