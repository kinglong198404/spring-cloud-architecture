package com.klfront.klblog.dataprovider.service;

import com.klfront.klblog.common.entity.KnowledgeBase;
public interface KnowledgeBaseService{


    int insertSelective(KnowledgeBase record);

    KnowledgeBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KnowledgeBase record);

    int insertOrUpdate(KnowledgeBase record);

    int insertOrUpdateSelective(KnowledgeBase record);

}
