package cn.itwuyao.ssm.mapper;

import java.util.List;

import cn.itwuyao.ssm.pojo.BaseDict;

public interface BaseDictMapper {
	
	List<BaseDict> findBaseDictByDictTypeCode(String dictTypeCode);
}
