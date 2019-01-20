package com.pinyougou.dao;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandDao {

    List<TbBrand> findAllBrands();
}
