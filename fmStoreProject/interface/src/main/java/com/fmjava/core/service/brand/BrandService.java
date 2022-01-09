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
     * @param page：当前页码；pageSize:一次查询多少条记录
     * @return 返回查询结果实体
     */
    PageResult findPage(Integer page, Integer pageSize);

    /**
     *添加品牌
     * @author HeLong
     * @param brand：需要添加的品牌数据
     * @return void
     */
    public void add(Brand brand);
}
