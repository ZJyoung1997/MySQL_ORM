package annotation.handler;

import java.lang.reflect.Method;

public interface AnnotationHandler {
	
	
	/**
	 * ��ȡ���������в�����ֵ
	 */
	public String getResult(Method method, Object[] args);
	
	
}
