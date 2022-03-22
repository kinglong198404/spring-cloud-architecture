package com.klfront.klblog.dataprovider.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.klfront.klblog.dataprovider.mapper.KnowledgeBaseMapper;
import com.klfront.klblog.common.entity.KnowledgeBase;
import com.klfront.klblog.dataprovider.service.KnowledgeBaseService;
@Service
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService{

    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;

    @Override
    public int insertSelective(KnowledgeBase record) {
        return knowledgeBaseMapper.insertSelective(record);
    }

    @Override
    public KnowledgeBase selectByPrimaryKey(Long id) {
        return knowledgeBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(KnowledgeBase record) {
        return knowledgeBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertOrUpdate(KnowledgeBase record) {
        return knowledgeBaseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(KnowledgeBase record) {
        return knowledgeBaseMapper.insertOrUpdateSelective(record);
    }

}
