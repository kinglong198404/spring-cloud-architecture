package com.klfront.klblog.dataprovider.mapper;

import com.klfront.klblog.common.entity.KnowledgeBase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface KnowledgeBaseMapper {
    int insertSelective(KnowledgeBase record);

    KnowledgeBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KnowledgeBase record);

    int insertOrUpdate(KnowledgeBase record);

    int insertOrUpdateSelective(KnowledgeBase record);
}