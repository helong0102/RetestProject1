package com.fmjava.core.service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.fmjava.core.dao.good.BrandDao;
import com.fmjava.core.pojo.good.Brand;
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
}
