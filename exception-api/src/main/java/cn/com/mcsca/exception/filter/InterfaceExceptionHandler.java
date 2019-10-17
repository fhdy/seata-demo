package cn.com.mcsca.exception.filter;

import cn.com.mcsca.exception.entity.BusinessException;
import cn.com.mcsca.exception.entity.ExceptionEntity;
import cn.com.mcsca.exception.service.ExceptionService;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.sly.seata.common.utils.JsonUtil;
import io.seata.core.context.RootContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器
 *
 * @author ieflex
 */
@RestControllerAdvice
public class InterfaceExceptionHandler {
    @Autowired
    private ExceptionService exceptionService;

    @Value("${spring.application.name}")
    private String pn;

    Logger logger = LoggerFactory.getLogger(InterfaceExceptionHandler.class);

    /**
     * 接口 业务异常
     */
	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	public JSON businessInterfaceException(BusinessException e) {
	    String code = e.getCode();
	    String msg = e.getMsg();
        String xid = RootContext.getXID();
	    if(StringUtils.isNotBlank(xid)){
            saveExceptionMsg(code,msg,e);
        }
        return JSONUtil.parse(e.toString());
	}

    /**
     * 拦截所有运行时的全局异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map runtimeException(RuntimeException e) {
        return saveSysException(e);
    }

    /**
     * 系统异常捕获处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map exception(Exception e) {
        return saveSysException(e);
    }

    private Map saveSysException(Exception e){
        saveExceptionMsg("error","系统异常，请稍后再试",e);
        Map map = new HashMap();
        map.put("code","error");
        map.put("msg","系统异常，请稍后再试");
        return map;
    }

    private void saveExceptionMsg(String code,String msg,Exception e){
        String xid = RootContext.getXID();
        if(StringUtils.isBlank(xid)){
            return;
        }
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        xid = xid.replaceAll("\\pP","");
        exceptionEntity.setID(xid);
        exceptionEntity.setLinkModel(pn);
        exceptionEntity.setExceptionCode(code);
        exceptionEntity.setExceptionMsg(msg);
        exceptionEntity.setStackMsg(ExceptionUtil.stacktraceToString(e));
        try{
            exceptionService.saveException(exceptionEntity);
        }catch (Exception e1){
            e1.printStackTrace();
            logger.info("记录异常信息失败");
//            System.out.println("记录异常信息失败");
        }
    }
}