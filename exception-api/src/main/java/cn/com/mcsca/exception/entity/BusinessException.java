package cn.com.mcsca.exception.entity;

import io.seata.core.context.RootContext;

public class BusinessException extends RuntimeException{
    private String code;
    private String msg;
    private String exceptionSealNo;

    public BusinessException(){}
    public BusinessException(String code,String msg){
        this.code = code;
        this.msg = msg;
        String xid = RootContext.getXID();
        if(xid != null){
            this.exceptionSealNo = xid.replaceAll("\\pP","");
        }
    }

    public BusinessException(String msg){
        this.code = "error";
        this.msg = msg;
        String xid = RootContext.getXID();
        if(xid != null){
            this.exceptionSealNo = xid.replaceAll("\\pP","");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExceptionSealNo() {
        return exceptionSealNo;
    }

    public void setExceptionSealNo(String exceptionSealNo) {
        this.exceptionSealNo = exceptionSealNo;
    }

    @Override
    public String toString() {
        String str = "{" +
                "\"code\":" + this.code + "," +
                "\"msg\":" + this.msg + "," +
                "\"exceptionSealNo\":" + this.exceptionSealNo +
                "}";
        return str;
    }
}
