package com.sly.seata.account.service.u;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.exception.ExceptionHandler;
import com.sly.seata.common.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UAccountService {

    @Autowired
    @Qualifier("accountServiceHystrixImpl")
    private AccountService accountService;

    public Map<String, Object> insert(Account account) throws Exception {
        Map map = accountService.insert(account);
        ExceptionHandler.dealExceptions(map);
//        Integer code = (Integer) map.get("status");
//        if(!"200".equals(""+code)){
//            throw new RuntimeException("111");
//        }
        return map;
    }
}
