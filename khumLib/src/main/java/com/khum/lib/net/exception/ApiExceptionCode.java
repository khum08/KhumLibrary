package com.khum.lib.net.exception;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : 网络请求相关的状态码
 *              服务器自定义的状态码应当不与客户端自定义的状态码冲突
 * </pre>
 */
public interface ApiExceptionCode {

    /**
     * Http相关状态码
     */
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int REQUEST_TIMEOUT = 408;
    int INTERNAL_SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    int SERVICE_UNAVAILABLE = 503;
    int GATEWAY_TIMEOUT = 504;
    /**
     * 其他自定义错误码
     */
    //未知错误
    int UNKNOWN = 1000;
    //数据解析错误
    int PARSE_ERROR = 1001;
    //超时
    int SOCKET_TIME_OUT_EXCEPTION = 1002;
}
