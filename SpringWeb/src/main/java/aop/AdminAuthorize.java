package aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD})//타겟을 메소드로 정한다.
@Retention(value=RetentionPolicy.RUNTIME)
public @interface AdminAuthorize {
	
}
