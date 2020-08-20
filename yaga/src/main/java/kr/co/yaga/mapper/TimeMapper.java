package kr.co.yaga.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT now()")
	public String getTime();
	
	public String getTime2();
}
