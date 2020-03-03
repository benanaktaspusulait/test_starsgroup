package com.thestarsgroup.test.referencedata;

import com.thestarsgroup.test.model.base.BaseType;
import com.thestarsgroup.test.repository.BaseClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseTypeService {

    @Autowired
    private BaseClassRepository baseClassRepository;

    public Page<BaseType> findAll(Pageable pageable) {
        log.debug("findAll datas");
        return baseClassRepository.findAll(pageable);
    }
}
