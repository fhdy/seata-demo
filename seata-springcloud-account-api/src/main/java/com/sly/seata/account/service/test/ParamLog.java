package com.sly.seata.account.service.test;

import java.lang.annotation.*;

@Target({ ElementType.TYPE,ElementType.METHOD  })

@Retention(RetentionPolicy.RUNTIME)

@Documented

public @interface ParamLog {

}