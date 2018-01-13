import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * ������̼��� ���̺귯���� ����ų� ���� �۾��� �� �� ����Ѵ�.
 * ������̼��� ����� ��ü�� �����ڴ� �ƴϰ�, ���� ��Ʈ �������̳� ���¼ҽ� �����ڵ���
 * ���̺귯���� ���� �� ���� ����ϰ� �ϱ� ���ؼ� ���� �����Ѵ�.
 * ButterKnife, ORM, Retrofit
 * 
 * ������̼��� �����ν� �ڵ忡 ���� �������� ��ȭ�ǰ�, �ڵ尡 �ҽ� ���η� ���� �ʰ� �ȴ�.
 */
public class AnnoMain {

	// main�� ��Ÿ�ӿ���
	public static void main(String[] args) {
		UseAnnotation use = new UseAnnotation();
		
		String key = use.getClass().getAnnotation(CustomAnnotation.class).key();
		if(key.equals("Student")) {
			// ��Ÿ�ӽÿ� ���� �ൿ�� ���� - �ҽ� ���� Ŀ�ø��� ��������.
		}
	}
	
}

/**
 * ������̼� �����
 * 1. Target : ������ ���(������, �������, Ÿ��(Ŭ����), �Ķ����, �޼ҵ�), �ǹ������� �ַ� Target�� ����� ���
 * 2. Retention : ������̼� ������ ���� �ܰ�(�ҽ��ڵ�����, Ŭ��������, ����������, ��Ÿ������)
 * 3. Documented = javadoc�� ������ �Ǿ����� �ϴ� ������Ʈ
 * 4. Inherited = ��ӵǴ� �������̼�
 */
@Target(ElementType.TYPE)			// 
@Retention(RetentionPolicy.RUNTIME)	// ��Ÿ�ӽ� �����Ѵ�.
@interface CustomAnnotation {
	public String value() default "��";
	public String key();
}

@CustomAnnotation(key = "Student")
class UseAnnotation {
	
}

@CustomAnnotation(key = "Manager")
class UseAnnotation2 {
	
}


@Target(ElementType.METHOD)			// 
@Retention(RetentionPolicy.RUNTIME)	// ��Ÿ�ӽ� �����Ѵ�.
@interface GetConnection {
	public String value() default "��";
	public String key();
}


class UseAnnotation3 {
	
}



