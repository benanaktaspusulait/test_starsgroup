package com.thestarsgroup.test.controller;

import com.thestarsgroup.test.Constants;
import com.thestarsgroup.test.model.base.BaseType;
import com.thestarsgroup.test.referencedata.BaseTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(Constants.API_PREFIX + "/types")
public class TypeController {

    @Autowired
    private BaseTypeService baseTypeService;

    @GetMapping
    public Page<BaseType> findAll(Pageable pageable) {
        return baseTypeService.findAll(pageable);
    }



}