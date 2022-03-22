package com.klfront.klblog.dataconsumer.feignclient;

import com.klfront.klblog.common.entity.KnowledgeBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import  com.netflix.loadbalancer.RoundRobinRule;

/** 
 * <p>Title: FeignClientService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: www.klfront.com</p>
 *
 * @author Lu Jinlong
 * @date 2019-07-25  
 * @version	1.0 
 */

@FeignClient(value = "DATA-PROVIDER",fallbackFactory=FeignClientServiceFallbackFactory.class)
@Service
public interface FeignClientService {

	/**
	 * 新增知识库
	 * @param item
	 * @return
	 */
	@PostMapping("/knowledgeBase/add")
	public int addKnowledgeBase(KnowledgeBase item);

	/**
	 * 更新知识库
	 * @param item
	 * @return
	 */
	@PostMapping("/knowledgeBase/update")
	public int updateKnowledgeBase(KnowledgeBase item);

	/**
	 * 根据id获取知识库
	 * @param id
	 * @return
	 */
	@GetMapping("/knowledgeBase/get/{id}")
	public KnowledgeBase getKnowledgeById(@PathVariable("id") Long id);
}
