package com.zit.catdemo1.dao.mapper.user;

import com.zit.catdemo1.dao.domain.user.CdUser;
import com.zit.catdemo1.dao.domain.user.CdUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CdUserMapper {
    int countByExample(CdUserExample example);

    int deleteByExample(CdUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(CdUser record);

    int insertSelective(CdUser record);

    List<CdUser> selectByExample(CdUserExample example);

    CdUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") CdUser record, @Param("example") CdUserExample example);

    int updateByExample(@Param("record") CdUser record, @Param("example") CdUserExample example);

    int updateByPrimaryKeySelective(CdUser record);

    int updateByPrimaryKey(CdUser record);
}