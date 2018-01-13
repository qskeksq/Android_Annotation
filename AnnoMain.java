import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 어노테이션은 라이브러리를 만들거나 공동 작업을 할 때 사용한다.
 * 어노테이션은 만드는 주체가 개발자는 아니고, 공동 파트 개발팀이나 오픈소스 개발자들이
 * 라이브러리를 조금 더 쉽게 사용하게 하기 위해서 만들어서 제공한다.
 * ButterKnife, ORM, Retrofit
 * 
 * 어노테이션을 씀으로써 코드에 대한 통제력이 강화되고, 코드가 소스 내부로 들어가지 않게 된다.
 */
public class AnnoMain {

	// main은 런타임에서
	public static void main(String[] args) {
		UseAnnotation use = new UseAnnotation();
		
		String key = use.getClass().getAnnotation(CustomAnnotation.class).key();
		if(key.equals("Student")) {
			// 런타임시에 해줄 행동을 정의 - 소스 간의 커플링이 낮아진다.
		}
	}
	
}

/**
 * 어노테이션 만들기
 * 1. Target : 적용할 대상(생성자, 멤버변수, 타입(클래스), 파라미터, 메소드), 실무에서는 주로 Target을 만들어 사용
 * 2. Retention : 어노테이션 정보의 유지 단계(소스코드인지, 클래스인지, 컴파일인지, 런타임인지)
 * 3. Documented = javadoc에 문서와 되어져야 하는 엘리먼트
 * 4. Inherited = 상속되는 오너테이션
 */
@Target(ElementType.TYPE)			// 
@Retention(RetentionPolicy.RUNTIME)	// 런타임시 실행한다.
@interface CustomAnnotation {
	public String value() default "값";
	public String key();
}

@CustomAnnotation(key = "Student")
class UseAnnotation {
	
}

@CustomAnnotation(key = "Manager")
class UseAnnotation2 {
	
}


@Target(ElementType.METHOD)			// 
@Retention(RetentionPolicy.RUNTIME)	// 런타임시 실행한다.
@interface GetConnection {
	public String value() default "값";
	public String key();
}


class UseAnnotation3 {
	
}



