package com.klfront.klblog.dataprovider.controller;

import com.klfront.klblog.common.entity.KnowledgeBase;
import com.klfront.klblog.dataprovider.service.KnowledgeBaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/knowledgeBase")
public class KnowledgeBaseController {
    @Resource
    private KnowledgeBaseService knowledgeBaseService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('knowledge_add')") //拥有knowledge_add权限方可访问
    public int add(@RequestBody KnowledgeBase item){
       return knowledgeBaseService.insertSelective(item);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('knowledge_edit')") //拥有knowledge_edit权限方可访
    public int update(@RequestBody KnowledgeBase item){
        return knowledgeBaseService.updateByPrimaryKeySelective(item);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('knowledge_view')") //拥有knowledge_view权限方可访问
    public KnowledgeBase get(@PathVariable Long id){
//        KnowledgeBase res =new KnowledgeBase();
//        res.setId(id);
//        return res;
        KnowledgeBase res = knowledgeBaseService.selectByPrimaryKey(id);
        return res;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('knowledge_view')") //拥有knowledge_view权限方可访问
    public Map<String, Object> list(String keyword, Integer pageNo, Integer pageSize) {
       return null;
    }

}
