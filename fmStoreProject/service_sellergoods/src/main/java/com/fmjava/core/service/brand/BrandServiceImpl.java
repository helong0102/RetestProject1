package com.fmjava.core.service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.fmjava.core.dao.good.BrandDao;
import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.good.Brand;
import com.fmjava.core.pojo.good.BrandQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
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
     * @param page：总记录数；pageSize:当前页结果 searchBrand:查询条件
     * @return 返回查询结果实体
     */
    @Override
    public PageResult findPage(Integer page, Integer pageSize, Brand searchBrand) {
        // 利用分页助手实现分页，第一个参数：当前页面，每页展示数据条数
        PageHelper.startPage(page,pageSize);
        BrandQuery brandQuery = new BrandQuery();
        BrandQuery.Criteria criteria = brandQuery.createCriteria();
        if (searchBrand!=null){
            if (searchBrand.getName() != null && !"".equals(searchBrand.getName())){
                criteria.andNameLike("%"+searchBrand.getName()+"%");
            }
            if (searchBrand.getFirstChar() != null && !"".equals(searchBrand.getFirstChar()+"%")){
                criteria.andFirstCharLike("%"+searchBrand.getFirstChar()+"%");
            }
        }
        Page<Brand> brands = (Page<Brand>)brandDao.selectByExample(brandQuery);
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

    /**
     * 修改品牌信息
     * @author HeLong
     * @param brand：更新后的品牌实体
     * @return void
     */
    @Override
    public void update(Brand brand) {
        brandDao.updateByPrimaryKeySelective(brand);
    }

    /**
     * 批量删除品牌
     * @author HeLong
     * @param ids：待删除品牌id
     * @return void
     */
    @Override
    public void delete(Long[] ids) {
        if (ids != null){
            for (Long id : ids) {
                System.out.println(id);
            }
            BrandQuery brandQuery = new BrandQuery();
            BrandQuery.Criteria criteria = brandQuery.createCriteria();
            criteria.andIdIn(Arrays.asList(ids));
            brandDao.deleteByExample(brandQuery);
        }
    }
}
