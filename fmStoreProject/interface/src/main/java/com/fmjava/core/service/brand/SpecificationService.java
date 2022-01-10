package com.fmjava.core.service.brand;

import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.specification.Specification;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/10/11:52
 * @Description: 规格处理接口
 */
public interface SpecificationService{

    /**
     * 规格分页查询
     * @author HeLong
     * @param spec：规格实体查询条件 page：当前页码 row：每页显示数据条数
     * @return 查询结果实体封装结果类
     */
    public PageResult findPage(Specification spec, Integer page, Integer rows);
}
