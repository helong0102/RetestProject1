package com.fmjava.core.service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.fmjava.core.dao.specification.SpecificationDao;
import com.fmjava.core.dao.specification.SpecificationOptionDao;
import com.fmjava.core.pojo.entity.PageResult;
import com.fmjava.core.pojo.entity.Result;
import com.fmjava.core.pojo.entity.SpecEntity;
import com.fmjava.core.pojo.specification.Specification;
import com.fmjava.core.pojo.specification.SpecificationOption;
import com.fmjava.core.pojo.specification.SpecificationQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/10/11:52
 * @Description: 规格处理接口实现类
 */
@Service
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationDao specificationDao;
    @Autowired
    private SpecificationOptionDao specificationOptionDao;


    /**
     * 规格分页查询
     * @author HeLong
     * @param spec：规格实体查询条件 page：当前页码 row：每页显示数据条数
     * @return 查询结果实体封装结果类
     */
    @Override
    public PageResult findPage(Specification spec, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        SpecificationQuery query = new SpecificationQuery();
        SpecificationQuery.Criteria criteria = query.createCriteria();
        if (spec != null){
            if (spec.getSpecName() != null && !"".equals(spec.getSpecName())){
                criteria.andSpecNameLike("%"+spec.getSpecName()+"%");
            }
        }
        Page<Specification> specList = (Page<Specification>)specificationDao.selectByExample(query);
        return new PageResult(specList.getTotal(),specList.getResult());
    }

    /**
     * 增加规格实体
     * @author HeLong
     * @param specEntity：规格封装实体
     * @return void
     */
    @Override
    public void add(SpecEntity specEntity) {
        // 1.添加规格对象
        specificationDao.insertSelective(specEntity.getSpecification());
        // 2.添加规格对象
        if (specEntity.getSpecification() != null){
            for (SpecificationOption option : specEntity.getSpecOptionList()) {
                // 设置规格选项外键
                option.setSpecId(specEntity.getSpecification().getId());
                specificationOptionDao.insertSelective(option);
            }
        }
    }
}
