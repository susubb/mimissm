package com.shuq.service;

import com.github.pagehelper.PageInfo;
import com.shuq.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    //显示全部商品(不分页)
    List<ProductInfo> getAll();

    //分页功能实现
    PageInfo splitPage(int pageNum,int pageSize);
}
