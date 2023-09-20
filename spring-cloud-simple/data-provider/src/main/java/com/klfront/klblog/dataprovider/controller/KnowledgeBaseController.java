package com.klfront.klblog.dataprovider.controller;

import com.klfront.klblog.common.entity.KnowledgeBase;
import com.klfront.klblog.dataprovider.service.KnowledgeBaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/knowledgeBase")
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
//        KnowledgeBase res =new KnowledgeBase();
//        res.setId(id);
//        return res;
        KnowledgeBase res = knowledgeBaseService.selectByPrimaryKey(id);
        return res;
    }

    @GetMapping("/list")
    public Map<String, Object> list(String keyword, Integer pageNo, Integer pageSize) {
       return null;
    }

}
