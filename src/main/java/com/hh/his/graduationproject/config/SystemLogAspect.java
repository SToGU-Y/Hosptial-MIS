package com.hh.his.graduationproject.config;

import com.hh.his.graduationproject.config.auth.SysUser;
import com.hh.his.graduationproject.model.entity.SysLog;
import com.hh.his.graduationproject.service.SysLogService;
import com.hh.his.graduationproject.utils.JsonUtils;
import com.hh.his.graduationproject.utils.JwtTokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@SuppressWarnings("all")
public class SystemLogAspect {
    @Autowired
    private SysLogService sysLogService;


    //Service层切点
    @Pointcut("@annotation(com.hh.his.graduationproject.config.SystemLogService)")
    public void serviceAspect(){
    }

    //Controller层切点
    @Pointcut("@annotation(com.hh.his.graduationproject.config.SystemLogController)")
    public void controllerAspect(){
    }

    /**
     * @Description  前置通知  用于拦截Controller层记录用户的操作
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //读取用户
        String  name;
        try {
            name = SecurityContextHolder.getContext().getAuthentication().getName();
        }catch (Exception e){
            name = "游客";
        }
        //获取ip
        String ip = request.getRemoteAddr();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            //*========数据库日志=========*//
            SysLog sysLog=new SysLog();
            sysLog.setUri(request.getRequestURI().toString());//请求接口
            sysLog.setMethod(request.getMethod());//请求方式
            sysLog.setMethodDescribe(getControllerMethodDescription(joinPoint));//描述
            sysLog.setParams(Arrays.toString(joinPoint.getArgs()));//参数信息
            sysLog.setUsername(name);//请求人
            sysLog.setIp(ip);//ip
            sysLog.setCreateDate(df.format(new Date()));//请求时间
            sysLogService.insertSysLog(sysLog);

        }catch (Exception e){
            //记录本地异常日志
            System.out.println("异常:"+e.getMessage());

        }
    }


    @AfterReturning(returning = "ret", pointcut = "controllerAspect()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("处理完成:"+ret);

    }



    /**
     * @Description  异常通知 用于拦截service层记录异常日志
     */
    @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable e){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER).replace(JwtTokenUtils.TOKEN_PREFIX,"");
        String username = JwtTokenUtils.getUsername(token);
        if (username == null){
            username = "游客";
        }
        //获取请求ip
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs()!=null&&joinPoint.getArgs().length>0){
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params+= JsonUtils.objectToJson(joinPoint.getArgs()[i])+";";
            }
        }
        try{
            /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMethodDescription(joinPoint));
            System.out.println("请求人:" + username);
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
            /*==========数据库日志=========*/

        }catch (Exception ex){
            System.out.println("异常2:"+e.getMessage());
        }
    }


    /**
     * @Description  获取注解中对方法的描述信息 用于service层注解
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint)throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemLogService.class).description();
                    break;
                }
            }
        }
        return description;
    }



    /**
     * @Description  获取注解中对方法的描述信息 用于Controller层注解
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemLogController.class).description();
                    break;
                }
            }
        }
        return description;
    }
}


