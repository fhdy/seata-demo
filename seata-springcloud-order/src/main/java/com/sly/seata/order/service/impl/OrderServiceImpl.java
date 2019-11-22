package com.sly.seata.order.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.model.account.Account;
import com.sly.seata.common.model.storage.Storage;
import com.sly.seata.common.utils.CommonUtils;
import com.sly.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.common.model.order.Order;
import com.sly.seata.order.mapper.OrderMapper;
import com.sly.seata.order.service.OrderService;

import io.seata.core.context.RootContext;

/**
 * 订单service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private AccountService accountService;

	@Autowired
	private StorageService storageService;

	/**
	 * 新增
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(@RequestBody Order order) {
		System.out.println(RootContext.getXID());

		orderMapper.insert(order);

		Storage storage = new Storage();
		storage.setStorageId(CommonUtils.genUUID());
		storage.setStorageName("name");
		storage.setStorageCount(20);
		storage.setRemark("备注");
		storage.setLogicDel("N");
		try {
			storageService.insert(storage);
		}catch (Exception e){
			System.out.println("新增order时新增account失败");
		}


		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}

	@Override
	public void update() {
		orderMapper.update();
//		if(true){
//			throw new RuntimeException("updateException");
//		}
	}

	@Override
	public void delete() {
		orderMapper.delete();
//		if(true){
//			throw new RuntimeException("deleteException");
//		}
	}
}
