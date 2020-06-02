package org.service;


import org.po.BaseDict;
import java.util.List;

public interface BaseDictService {
    //根据类别代码查询数据字典
    public List<BaseDict> findBaseDictByTypeCode(String typecode);
}
