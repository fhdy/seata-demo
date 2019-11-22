package com.sly.seata.account.service.hystrix;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.model.account.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Account熔断
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Component
public class AccountServiceHystrixImpl implements AccountService {

	/**
	 * 新增失败熔断返回
	 * 
	 * @param account
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(Account account) throws Exception{
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 400);
		result.put("message", "调用账户新增服务失败！");
		return result;
	}

	@Override
	public void update() {
	}

	@Override
	public void delete() {

	}
}
