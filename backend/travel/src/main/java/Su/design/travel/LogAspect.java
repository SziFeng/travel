package Su.design.travel;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Szifeng
 * @date 2020/3/27 0:03
 */
@Component
@Aspect
@Slf4j
public class LogAspect{
    String methodName;      // 方法名
    long startTime;         // 开始时间

    /**
     * 定义一个切入点.
     * 解释下：
     *
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 定义在web包或者子包
     * ~ 第三个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Pointcut("execution( public * Su.design.travel.Controller..*.*(..))")
    public void aopPointCut() {
    }

    @Before("aopPointCut()")
    public void doBefore(JoinPoint joinPoint) {

        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        startTime = System.currentTimeMillis();
        //获取需要打印的参数信息
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        //这里使用的是阿里的fastjson
        String jsonString = JSON.toJSONString(joinPoint.getArgs());
        log.info("------------------------访问开始----------------------------------");
        log.info("请求时间 ：{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        log.info("remoteAddr: {} ",remoteAddr);
        log.info("请求URI : {}",requestURI);
        log.info("Controller控制器 : {}",  joinPoint.getTarget().getClass());
        log.info("method type: {}" ,method);
        log.info("req paras: {}",jsonString);
    }

    @After("aopPointCut()")
    public void doAfter() {
        long E_time = System.currentTimeMillis() - startTime;
        log.info("执行 " + methodName + " 耗时为：" + E_time + "ms");
    }

    @AfterReturning(returning = "object", pointcut = "aopPointCut()")
    public void doAfterReturning(JoinPoint joinPoint,Object object) {
        log.info("response: {}", JSON.toJSONString(object));
//        log.info(UserShiroUtil.getCurrentUserLoginName()); // 请求用户ID
//        log.info(UserShiroUtil.getCurrentUserName()); // 请求用户名称
        log.info("------------------------访问结束----------------------------------");
    }

    @Around("aopPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.error("+++++around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.error("+++++around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }

    }
}
