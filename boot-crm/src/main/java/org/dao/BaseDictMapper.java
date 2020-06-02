package org.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.po.BaseDict;
import org.po.BaseDictExample;

public interface BaseDictMapper {
    public List<BaseDict>selectBaseDictByTypeCode(String typecode);
}