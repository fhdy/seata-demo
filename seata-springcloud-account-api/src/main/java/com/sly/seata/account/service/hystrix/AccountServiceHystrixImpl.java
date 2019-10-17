package com.sly.seata.account.service.hystrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sly.seata.account.service.test.ParamLog;
import com.sly.seata.common.context.ExceptionMsgContext;
import com.sly.seata.common.exception.ExceptionHandler;
import io.seata.core.context.RootContext;
import org.springframework.stereotype.Component;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.model.account.Account;

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
	public List insert1(Account account) throws Exception {
		return new ArrayList();
	}

}
