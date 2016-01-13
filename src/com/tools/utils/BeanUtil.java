package com.tools.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author Lee.J.Eric
 *
 */
public class BeanUtil {

	/**
	 * 取Bean的属性和set对应的值
	 * @param beans
	 * @param set
	 * @return
	 * Lee.J.Eric
	 * 2014年6月17日 下午4:45:36
	 */
	public static <T> List<T> getFieldValueForList(List<T> beans, Set<String> set){
		List<T> list = new ArrayList<T>();
		for (T bean : beans) {
			list.add(getFieldValue(bean, set));
		}
		return list;
	}

	/**
	 * 取Bean的属性和set对应的值
	 * @param beans
	 * @param set
	 * @return
	 * Lee.J.Eric
	 * 2014年9月9日 下午2:09:28
	 */
	public static <T> Set<T> getFieldValueForSet(Set<T> beans, Set<String> set) {
		Set<T> value = new HashSet<T>();
		for (T bean : beans) {
			value.add(getFieldValue(bean, set));
		}
		return value;
	}

	/**
	 * 取Bean的属性和set对应的值
	 * @param bean
	 * @param set
	 * @return
	 * Lee.J.Eric
	 * 2014年6月17日 下午4:40:33
	 */
	public static <T> T getFieldValue(T bean, Set<String> set){
		Set<String> beanFields = new HashSet<String>();
		Class<?> clazz = bean.getClass();
		beanFields = getBeanFieldName(clazz,beanFields);
		bean = getFieldValue(bean, set, beanFields);
		return bean;
	}

	/**
	 * 获取calzz中所有的属性字段
	 * @param clazz
	 * @param set
	 * @return
	 */
	protected static Set<String> getBeanFieldName(Class clazz,Set<String> set){
		if(!clazz.getSimpleName().equals("Object")){
			Field[] fields = clazz.getDeclaredFields();
			for (Field field:fields) {
				set.add(field.getName());
			}
			getBeanFieldName(clazz.getSuperclass(),set);
		}
		return set;
	}

	/**
	 * 获取bean中keySet属性值
	 * @param bean
	 * @param keySet
	 * @param beanFields
	 * @return
	 * Lee.J.Eric
	 * 2014年6月18日 下午1:05:04
	 */
	private static <T> T getFieldValue(T bean, Set<String> keySet, Set<String> beanFields){
		try {
			if(bean!=null){
				for (String key:keySet){
					if(key.indexOf(".")==-1){//没有下一级
						beanFields.remove(key);
					}else{//有下一级
						Class<?> clazz = bean.getClass();
						String key0 = key.substring(0, key.indexOf("."));
						PropertyDescriptor pd = new PropertyDescriptor(key0, clazz);
						Method readMethod = pd.getReadMethod();//获得读方法
						Method writeMethod = pd.getWriteMethod();
						Object fieldVal = readMethod.invoke(bean);//获取bean中此属性的值
						Set<String> set = new HashSet<String>();
						for (String string : keySet) {
							if(string.startsWith(key0)&&string.length()>key0.length()&&string.contains("."))//所有此属性下的子属性
								set.add(string.substring(key0.length()+1));
						}
						if(fieldVal instanceof List) {//list
							writeMethod.invoke(bean, getFieldValueForList((List) fieldVal, set));
						}else if (fieldVal instanceof Set) {//set
							writeMethod.invoke(bean, getFieldValueForSet((Set) fieldVal, set));
						}else {//非集合形式
							writeMethod.invoke(bean, getFieldValue(fieldVal, set));
						}
						beanFields.remove(key0);
					}
				}
				Class<?> clazz = bean.getClass();
				for (String key:beanFields) {
					try{
						PropertyDescriptor pd = new PropertyDescriptor(key, clazz);
						Method writeMethod = pd.getWriteMethod();
						Object o = null;
						writeMethod.invoke(bean,o);
					}catch (Exception e){
						continue;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}
	
}
