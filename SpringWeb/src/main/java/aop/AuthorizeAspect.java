package aop;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import pbean.UserInfo;

@Aspect
public class AuthorizeAspect {
   @Pointcut("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))") // 경로와 파일이름을 *로 잡겠다는건가?
   private void handlerMethod(){}
   
   @Before("handlerMethod()") // 핸들러 메소드와 연결
   public void interceptMethod(JoinPoint jp) throws Exception{
	   MethodSignature ms = (MethodSignature)jp.getSignature();
	   
	   Method me = ms.getMethod();
	   
	   //메서드에서 해당어노테이션 취득
	   Authrorize au = me.getAnnotation(Authrorize.class);
	   AdminAuthorize ad = me.getAnnotation(AdminAuthorize.class);
	   
	   if( au != null && ad != null ){
		   //권한 체크가 필요
		   RequestAttributes ra = RequestContextHolder.getRequestAttributes(); 
		   UserInfo loginUser = (UserInfo)ra.getAttribute("user", RequestAttributes.SCOPE_SESSION);

		   if(loginUser == null){
			   System.out.println("로그인 해주시기 바랍니다.");
			   throw new InvalidloginException();
		   }else if(loginUser.getRole().equals("admin")){
			   System.out.println("어드민으로 접속 완료");
		   }else{
			   System.out.println("로그인 감사합니다.");
		   }
	   }
   }
}