//package com.sly.seata.account.advice;
//
//import ExceptionService;
//import ExceptionEntity;
//import cn.hutool.core.exceptions.ExceptionUtil;
//import com.sly.seata.common.constant.ExceptionConstant;
//import io.seata.core.context.RootContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 自定义异常处理器
// *
// * @author ieflex
// */
//@RestControllerAdvice
////@Slf4j
//public class InterfaceExceptionHandler {
//
////	@Autowired
////	private JsonUtil jsonUtil;
//
//    @Autowired
//    private ExceptionService exceptionService;
//
//	/**
//	 * 接口 业务异常
//	 */
////	@ResponseBody
////	@ExceptionHandler(BusinessInterfaceException.class)
////	public String businessInterfaceException(BusinessInterfaceException e) {
////		log.error(e.getMessage(), e);
////		ErrorBean error = e.getError();
////		ResultBean resultBean = new ResultBean(error.hashCode(), error.getErrorMsg());
////		return resultBean.toString();
////	}
//
//	/**
//	 * 拦截所有运行时的全局异常
//	 */
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public Map runtimeException(RuntimeException e) {
////		log.error(e.getMessage(), e);
//		// 返回 JOSN
////		ResultBean resultBean = new ResultBean(Constants.INTERFACE_MSG_301, Constants.INTERFACE_MSG_301_TEXT);
//        String xid = RootContext.getXID();
//
//        ExceptionEntity exceptionEntity = new ExceptionEntity();
//		xid = xid.replaceAll("\\pP","");
//        exceptionEntity.setID(xid);
//        exceptionEntity.setLinkModel("");
//        exceptionEntity.setExceptionCode("");
//        exceptionEntity.setExceptionMsg(e.getMessage());
//        exceptionEntity.setStackMsg(ExceptionUtil.stacktraceToString(e));
//        try{
//            exceptionService.saveException(exceptionEntity);
//        }catch (Exception e1){
//            System.out.println("记录异常信息失败");
//        }
////		exceptionService.saveException(exceptionEntity);
//        Map map = new HashMap();
//        setExceptionMsg(map,e);
//        return map;
//	}
//
//	/**
//	 * 系统异常捕获处理
//	 */
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public Map exception(Exception e) {
//
//		Map map = new HashMap();
//		setExceptionMsg(map,e);
//		return map;
//	}
//
//	private void setExceptionMsg(Map map,Exception e){
//		map.put(ExceptionConstant.throwExceptionMsgCode,e.getMessage());
//		map.put(ExceptionConstant.throwExceptionCodeKey,ExceptionConstant.throwExceptionCodeValue);
//		map.put(ExceptionConstant.throwExceptionStackMsgKey, ExceptionUtil.stacktraceToString(e));
//	}
//}