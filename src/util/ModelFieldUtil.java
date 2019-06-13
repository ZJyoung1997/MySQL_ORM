package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ModelFieldUtil {
	
	/**
	 * Ϊ����ָ����Ա������ֵ������˽�г�Ա������
	 * @author JZ
	 * @param values keyΪ��Ա��������valueΪ��Ա������ֵ
	 * @param clazz ��Ҫӳ���class����
	 * @return Object ��̬ʵ�ֵ���
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Object setFieldValue(Map<String, Object> values, Type type) {
		
		Class clazz = null;
		
		try {
			clazz = Class.forName(type.getTypeName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		
		try {
			obj = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			
			for(Field field : fields) {
				field.setAccessible(true);
				field.set(obj, values.get(field.getName()));
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	/**
	 * �����������г�Ա����(����˽�г�Ա����)��ֵ
	 * @author JZ
	 * @param obj
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> getAllFieldValue(Object obj){
		Map<String, Object> map = new HashMap<String, Object>();
		
		Field[] fields = obj.getClass().getDeclaredFields();
		
		for(Field f : fields) {
			try {
				f.setAccessible(true);
				map.put(f.getName(), f.get(obj));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
}
