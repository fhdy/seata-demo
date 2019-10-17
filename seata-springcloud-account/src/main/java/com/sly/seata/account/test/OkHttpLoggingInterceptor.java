//package com.sly.seata.account.test;
//
//import com.sly.seata.common.constant.ExceptionConstant;
//import com.sly.seata.common.context.ExceptionMsgContext;
//import com.sly.seata.common.utils.JsonUtil;
//import okhttp3.*;
//import okio.Buffer;
//import okio.BufferedSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.io.EOFException;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.Map;
//
//@Component
//public class OkHttpLoggingInterceptor implements Interceptor {
//    private static final Charset UTF8 = Charset.forName("UTF-8");
//    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpLoggingInterceptor.class);
//
//    private JsonUtil jsonUtil = new JsonUtil();
//
//    @Override
//    public okhttp3.Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        try {
//
//            Response response = chain.proceed(request);
//            Map respMap;
//            try {
//                String result = getContentString(response);
//                respMap = jsonUtil.toMap(result);
//            }catch (Exception e){
//                return response;
//            }
//
//            String code = (String)respMap.get(ExceptionConstant.throwExceptionCodeKey);
//            if(code==null || !ExceptionConstant.throwExceptionCodeValue.equals(code)){//异常码为空或者异常码不相等正常返回值
//                return response;
//            }
//            String throwExceptionStackMsg = (String) respMap.get(ExceptionConstant.throwExceptionStackMsgKey);
//            String throwExceptionMsg = (String) respMap.get(ExceptionConstant.throwExceptionMsgCode);
//
//            ExceptionMsgContext.setExceptionMsg(throwExceptionMsg);
//            ExceptionMsgContext.setExceptionStackMsg(throwExceptionStackMsg);
//            return response;
////            throw new IOException(throwExceptionMsg);
//        } catch (IOException e) {
//            //log error
//            throw e;
//        } finally {
//            //clean up
//        }
//    }
//
//    private String getContentString(Response response) throws IOException{
//        ResponseBody responseBody = response.body();
//        long contentLength = responseBody.contentLength();
//        if (!bodyEncoded(response.headers())) {
//            BufferedSource source = responseBody.source();
//            source.request(Long.MAX_VALUE); // Buffer the entire body.
//            Buffer buffer = source.buffer();
//            Charset charset = UTF8;
//            MediaType contentType = responseBody.contentType();
//            if (contentType != null) {
//                charset = contentType.charset(UTF8);
//            }
//
//            if (!isPlaintext(buffer)) {//正常返回response
////                return response;
//                throw new IOException("正常返回");
//            }
//
//            if (contentLength != 0) {
//                String result = buffer.clone().readString(charset);
//                return result;
//            }
//        }
//        return null;
//    }
//
//    private boolean bodyEncoded(Headers headers) {
//        String contentEncoding = headers.get("Content-Encoding");
//        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
//    }
//
//    private boolean isPlaintext(Buffer buffer) throws EOFException {
//        try {
//            Buffer prefix = new Buffer();
//            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
//            buffer.copyTo(prefix, 0, byteCount);
//            for (int i = 0; i < 16; i++) {
//                if (prefix.exhausted()) {
//                    break;
//                }
//                int codePoint = prefix.readUtf8CodePoint();
//                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
//                    return false;
//                }
//            }
//            return true;
//        } catch (EOFException e) {
//            return false; // Truncated UTF-8 sequence.
//        }
//    }
//
//
//}