package org.service.impl;

import org.dao.BaseDictMapper;
import org.po.BaseDict;
import org.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;
    @Override
    public List<BaseDict> findBaseDictByTypeCode(String typecode) {
        return baseDictMapper.selectBaseDictByTypeCode(typecode);
    }
}
