package com.shuq.service.impl;

import com.shuq.mapper.ProductTypeMapper;
import com.shuq.pojo.ProductType;
import com.shuq.pojo.ProductTypeExample;
import com.shuq.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {
    //业务逻辑层一定有数据访问层对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
