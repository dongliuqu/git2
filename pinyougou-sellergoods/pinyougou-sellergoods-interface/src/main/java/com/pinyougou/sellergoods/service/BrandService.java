package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;

public interface
BrandService extends BaseService<TbBrand> {

    List<TbBrand> testPage(Integer pageNum,Integer pageSize);


    PageResult search(Integer page, Integer rows, TbBrand tbBrand);
}
