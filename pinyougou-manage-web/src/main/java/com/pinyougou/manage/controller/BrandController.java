package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/brand")
//controller+responseBody
@RestController
public class BrandController {
    @Reference
    private BrandService brandService;

    //get+requestMapping
    @GetMapping("/findAll")
    public List<TbBrand> findAllBrands() {
        return brandService.findAllBrands();
    }
}
