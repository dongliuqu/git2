package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.pinyougou.dao.BrandDao;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.service.Impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl extends BaseServiceImpl<TbBrand> implements BrandService  {
    @Autowired
    private BrandDao brandDao;



    @Override
    public List<TbBrand> testPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return brandDao.selectAll();
    }
}
