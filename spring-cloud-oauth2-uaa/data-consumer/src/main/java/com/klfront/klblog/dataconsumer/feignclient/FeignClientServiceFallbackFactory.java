package com.klfront.klblog.dataconsumer.feignclient;

import com.klfront.klblog.common.entity.KnowledgeBase;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author LuJinlong
 * @date 2022-03-22
 * @version	1.0 
 */
@Component // 不要忘记添加
public class FeignClientServiceFallbackFactory implements FallbackFactory<com.klfront.klblog.dataconsumer.feignclient.FeignClientService>{

	@Override
	public com.klfront.klblog.dataconsumer.feignclient.FeignClientService create(Throwable cause) {
		//统一处理FeignClientService中各接口的异常
		return new com.klfront.klblog.dataconsumer.feignclient.FeignClientService() {

			@Override
			public int addKnowledgeBase(KnowledgeBase item) {
				return 0;
			}

			@Override
			public int updateKnowledgeBase(KnowledgeBase item) {
				return 0;
			}

			@Override
			public Object getKnowledgeById(Long id) {
				System.out.println(cause.getMessage());
				return null;
			}
		};
	}

}
