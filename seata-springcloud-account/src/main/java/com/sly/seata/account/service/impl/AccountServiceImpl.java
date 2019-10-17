package com.sly.seata.account.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.account.mapper.AccountMapper;
import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.model.account.Account;

import io.seata.core.context.RootContext;

/**
 * 账户service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 新增
	 * 
	 * @param account
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(Account account) throws Exception{
		System.out.println(RootContext.getXID());
		accountMapper.insert(account);
//		int a = 1/0;
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}

	@Override
	public List insert1(Account account) throws Exception {
		int a = 1/0;
		return new ArrayList();
	}
}
