//package com.sly.seata.storage.service.hystrix;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExceptionMsgContext {
//    static ThreadLocal<Map> threadLocal = new ThreadLocal<>();
//    private static final String exceptionConstans = "exceptionMsg";
//
//    private static Object get(String key){
//        Map map = threadLocal.get();
//        if(map == null){
//            map = new HashMap();
//            threadLocal.set(map);
//        }
//        return map.get(key);
//    }
//
//    private static void set(String key,Object value){
//        Map map = threadLocal.get();
//        if(map == null){
//            map = new HashMap();
//            threadLocal.set(map);
//        }
//        map.put(key,value);
//    }
//
//    public static String getExceptionMsg(){
//        return (String) get(exceptionConstans);
//    }
//    public static void setExceptionMsg(String exceptionMsg){
//        set(exceptionConstans,exceptionMsg);
//    }
//
//    public static void removeExceptionMsg(){
//        threadLocal.remove();
//    }
//}
