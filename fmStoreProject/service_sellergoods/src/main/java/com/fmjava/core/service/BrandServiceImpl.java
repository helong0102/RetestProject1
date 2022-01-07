package com.fmjava.core.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/07/15:14
 * @Description:
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public String getName() {
        return "HeLong";
    }
}
