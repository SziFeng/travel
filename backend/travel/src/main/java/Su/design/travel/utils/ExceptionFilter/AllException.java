package Su.design.travel.utils.ExceptionFilter;

import Su.design.travel.utils.result.Result;
import com.alibaba.druid.wall.violation.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Szifeng
 * @date 2020/3/29 14:37
 */
@RestControllerAdvice
public class AllException {

    private final static Logger logger = LoggerFactory.getLogger("ERROR");

    @ExceptionHandler(Exception.class)
    private Result handlerErrorInfo(HttpServletRequest request) {
        logger.error("【系统异常报错】全局异常拦截，请求为: {}", request.getRequestURI());
        return Result.setInfo(500, "系统异常", null);
    }
}
