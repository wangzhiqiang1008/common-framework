package framework.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wzq
 * Created on 2022-04-13
 */

@Aspect // 1.代表这是一个切面类
@Component
public class MyLogAspect {

//    private static final Logger logger = LoggerFactory.getLogger(MyLogAspect.class);


    /** * 2. PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名 * 切面最主要的就是切点，全部的故事都围绕切点发生 * logPointCut()表明切点名称 */
    @Pointcut("@annotation(framework.annotation.MyLog)")
    public void logPointCut() {
    }

    // 3. 环绕通知
    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        // 获取入参
        Object[] param = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        for (Object o : param) {
            sb.append(o).append("; ");
        }


        Object object = null;
        // 继续执行方法
        try {
            //接受方法的返回值
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("进入[" + methodName + "]方法,参数为:" + sb.toString() + "结果为： " +object);
//        logger.info("进入[" + methodName + "]方法,参数为:" + sb.toString() + "结果为： " +object);
        return object;
    }
}
