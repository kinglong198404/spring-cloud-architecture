package com.klfront.klblog.dataprovider2.controller;

import com.klfront.klblog.common.entity.KnowledgeBase;
import com.klfront.klblog.dataprovider2.service.KnowledgeBaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeBaseController {
    @Resource
    private KnowledgeBaseService knowledgeBaseService;

    @PostMapping("/add")
    public int add(@RequestBody KnowledgeBase item){
       return knowledgeBaseService.insertSelective(item);
    }

    @PostMapping("/update")
    public int update(@RequestBody KnowledgeBase item){
        return knowledgeBaseService.updateByPrimaryKeySelective(item);
    }

    @GetMapping("/get/{id}")
    public KnowledgeBase get(@PathVariable Long id){
        return knowledgeBaseService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public Map<String, Object> list(String keyword, Integer pageNo, Integer pageSize) {
       return null;
    }

}
