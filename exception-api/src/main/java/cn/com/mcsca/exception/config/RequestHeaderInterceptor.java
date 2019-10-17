package cn.com.mcsca.exception.config;

import cn.com.mcsca.exception.entity.ExceptionEntity;
import cn.com.mcsca.exception.service.ExceptionService;
import com.sly.seata.common.constant.SeataConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Feign拦截器，把RootContext中的XID（XID用于标识一个局部事务属于哪个全局事务，需要在调用链路的上下文中传递）传递到上层调用链路
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Component
public class RequestHeaderInterceptor implements RequestInterceptor {

	@Autowired
	private ExceptionService exceptionService;

	Logger logger = LoggerFactory.getLogger(RequestHeaderInterceptor.class);

	@Override
	public void apply(RequestTemplate template) {
		String xid = RootContext.getXID();
		if (StringUtils.isNotBlank(xid)) {
			template.header(SeataConstant.XID_HEADER, xid);

			String xxid = xid.replaceAll("\\pP","");
			ExceptionEntity exceptionEntity = null;
			try {
				exceptionEntity = exceptionService.getExceptionById(xxid);
			}catch (Exception e){
				//不作任何操作
				logger.info("获取异常信息异常");
			}
			if(exceptionEntity!=null){
				throw new RuntimeException("熔断");
			}
		}
	}

}
