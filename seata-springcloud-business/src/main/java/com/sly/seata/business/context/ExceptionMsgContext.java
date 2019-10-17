//package com.sly.seata.business.context;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExceptionMsgContext {
//    static ThreadLocal<Map> threadLocal = new ThreadLocal<>();
//    private static final String exceptionConstans = "exceptionMsg";
//
//    static {
//        Map map = threadLocal.get();
//        if(map == null){
//            map = new HashMap();
//        }
//        threadLocal.set(map);
//    }
//
//    public static String getExceptionMsg(){
//        Map map = threadLocal.get();
//        return (String) map.get(exceptionConstans);
//    }
//    public static void setExceptionMsg(String exceptionMsg){
//        Map map = threadLocal.get();
//        map.put(exceptionConstans,exceptionMsg);
//    }
//
//    public static void removeExceptionMsg(){
//        threadLocal.remove();
//    }
//}
