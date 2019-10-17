package cn.com.mcsca.exception.service.impl;

import cn.com.mcsca.exception.entity.ExceptionEntity;
import cn.com.mcsca.exception.service.ExceptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ExceptionServiceImpl implements ExceptionService {
    Map<String, ExceptionEntity> temp = new HashMap();
    Logger logger = LoggerFactory.getLogger(ExceptionServiceImpl.class);

    @Override
    public void saveException(ExceptionEntity exceptionEntity) throws Exception {
        String id = exceptionEntity.getID();
        ExceptionEntity memoryExceptionEntity = temp.get(id);
        if(memoryExceptionEntity == null){
            temp.put(id,exceptionEntity);
        }else{
            return;
        }
        saveExceptionFile(exceptionEntity);
    }

    @Override
    public ExceptionEntity getExceptionById(String id) throws Exception {
        return temp.get(id);
    }

    private void saveExceptionFile(ExceptionEntity exceptionEntity){
//        String path = System.getProperty("user.dir");
        String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
        if(path.startsWith("jar")){
            path = path.substring(4);
        }
        if(path.startsWith("file")){
            path = path.substring(5);
        }
        if(path.contains(".jar")){
            path = path.substring(0,path.indexOf(".jar"));
        }
        File temp = new File(path);
        path = temp.getParent();
        if(!path.endsWith(File.separator)){
            path += File.separator;
        }

        path = path + "exceptionLog" + File.separator + exceptionEntity.getID() + ".log";
        saveAsFileWriter(path,exceptionEntity.toString());
    }

    private void saveAsFileWriter(String path,String content) {
        FileWriter fwriter = null;
        File file = new File(path);
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(path);
            fwriter.write(content);
        } catch (IOException ex) {
            logger.error("保存异常信息失败！");
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                logger.error("保存异常信息时，关闭流失败！");
                ex.printStackTrace();
            }
        }
    }
}
