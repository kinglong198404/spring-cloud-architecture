package com.klfront.klblog.dataconsumer.controller;

import com.klfront.klblog.common.entity.KnowledgeBase;
import com.klfront.klblog.dataconsumer.feignclient.FeignClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/knowledgeBase")
public class KnowledgeBaseConsumerController {
    @Resource
    private FeignClientService service;

    @PostMapping("/add")
    public int add(@RequestBody KnowledgeBase item){
        return service.addKnowledgeBase(item);
    }

    @PostMapping("/update")
    public int update(@RequestBody KnowledgeBase item){
        return service.updateKnowledgeBase(item);
    }

    @GetMapping("/get/{id}")
    public KnowledgeBase get(@PathVariable Long id){
        return service.getKnowledgeById(id);
    }
}
