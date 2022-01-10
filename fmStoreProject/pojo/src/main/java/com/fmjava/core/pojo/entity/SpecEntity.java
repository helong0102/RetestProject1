package com.fmjava.core.pojo.entity;

import com.fmjava.core.pojo.specification.Specification;
import com.fmjava.core.pojo.specification.SpecificationOption;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeLong
 * @Date: 2022/01/10/14:25
 * @Description:
 */
@Getter@Setter
public class SpecEntity implements Serializable {
    //规格对象
    private Specification specification;
    //规格选项集合
    private List<SpecificationOption> specOptionList;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getSpecOptionList() {
        return specOptionList;
    }

    public void setSpecOptionList(List<SpecificationOption> specOptionList) {
        this.specOptionList = specOptionList;
    }
}
