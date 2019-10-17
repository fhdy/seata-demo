package cn.com.mcsca.exception.entity;

public class ExceptionEntity {
    private String ID;
    private String linkModel;
    private String stackMsg;
    private String exceptionMsg;
    private String exceptionCode;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLinkModel() {
        return linkModel;
    }

    public void setLinkModel(String linkModel) {
        this.linkModel = linkModel;
    }

    public String getStackMsg() {
        return stackMsg;
    }

    public void setStackMsg(String stackMsg) {
        this.stackMsg = stackMsg;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    @Override
    public String toString() {
        return "ExceptionEntity{" +
                "ID='" + ID + '\'' +
                "\n, linkModel='" + linkModel + '\'' +
                "\n, exceptionMsg='" + exceptionMsg + '\'' +
                "\n, exceptionCode='" + exceptionCode + '\'' +
                "\n, stackMsg='" + stackMsg + '\'' +
                '}';
    }
}
