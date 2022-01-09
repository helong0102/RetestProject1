package com.fmjava.core.service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.fmjava.core.dao.good.BrandDao;
import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.good.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/08/16:41
 * @Description:
 */
@Service
public class BrandServiceImpl implements BrandService {

    /*注入BrandDao*/
    @Autowired
    private BrandDao brandDao;


    @Override
    public List<Brand> findAll() {
        List<Brand> brands = brandDao.selectByExample(null);
        return brands;
    }

    /**
     *分页查询
     * @author HeLong
     * @param page：总记录数；pageSize:当前页结果
     * @return 返回查询结果实体
     */
    @Override
    public PageResult findPage(Integer page, Integer pageSize) {
        // 利用分页助手实现分页，第一个参数：当前页面，每页展示数据条数
        PageHelper.startPage(page,pageSize);
        Page<Brand> brands = (Page<Brand>)brandDao.selectByExample(null);
        PageResult pageResult = new PageResult(brands.getTotal(), brands.getResult());
        return pageResult;
    }

    /**
     *添加品牌
     * @author HeLong
     * @param brand：需要添加的品牌数据
     * @return void
     */
    @Override
    public void add(Brand brand) {
        brandDao.insertSelective(brand);
    }

    /**
     *根据ID查询品牌
     * @author HeLong
     * @param id：品牌Id
     * @return 查询的品牌实体
     */
    @Override
    public Brand findBrandWithId(Long id) {
        System.out.println(id+"dao");
        return brandDao.selectByPrimaryKey(id);
    }
}
