package com.xiuye.util.test.cls;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xiuye.util.cls.TypeUtil;
import com.xiuye.util.log.LogUtil;

public class TypeUtilTest {

	public static void main(String[] args) {
		TypeUtil.newInstance(A::new);
		TypeUtil.newInstance(A::new, "ABC");
		TypeUtil.newInstance(A::new, 1);
		TypeUtil.newInstance(A::new, 1,1,2,3,4,5,6);
		//Now , T[]  <=> T...t  
//		TypeUtil.newInstance(A::new, new Integer[]{1,2});
		TypeUtil.newInstance(A::new, new int[]{1,2});
		TypeUtil.newInstance(A::new, new Integer[]{1,2},new Integer[]{1,2});
		TypeUtil.newInstance(A::new, 1,"abc",1L);
		TypeUtil.newInstance(A::new, "GGGGGG","abc");
		Object o = "ABC";
		String s = TypeUtil.dynamic_cast(o);
		s = TypeUtil.dynamic_cast("JJJJJJJJJJJJJJJJJJJ");
		LogUtil.log(s);
//		LogUtil.log(TypeUtil.dynamic_cast(o));//error
		o = TypeUtil.dynamic_cast(s);
		LogUtil.log(o);
		LogUtil.log(TypeUtil.<String,Object>dynamic_cast(o));
		LogUtil.log("ABC",1,2,3,4,5,6,"GGGG",7L);
		TypeUtil.newInstance(B::new, 1,"abc",1L);
		LogUtil.log(TypeUtil.createMap());
		LogUtil.log(TypeUtil.createList());
		LogUtil.log(TypeUtil.createSet());
		Map<String,String> m = TypeUtil.createMap();
		m.put("A", "A");
		List<String> l = TypeUtil.createList();
		l.add("123");
		l.add("123");
		Set<String> se = TypeUtil.createSet();
		se.add("OK");
		se.add("OK");
		LogUtil.log(m,l,se);
	}

	static class B{
		B(Integer i,String s,Long l){
			LogUtil.log("A(int i,String s,Long l)");
		}
	}
	static class A{
		A(){
			LogUtil.log("A()");
		}
		A(int i){
			LogUtil.log("A(int i)");
		}
		A(String s){
			LogUtil.log("A(String s)");
		}
		A(String s1,String s2){
			LogUtil.log("A(String s1,String s2)");
		}
//		A(Integer []s){
//			LogUtil.log("A(Integer []s)");
//		}
		A(Integer ...s){
			LogUtil.log("A(Integer ...s)");
		}
		A(String ... s){
			LogUtil.log("A(String ... s)");
		}
//		A(int...i){
//			LogUtil.log("A(int ... i)");
//		}
		A(int[]i){
			LogUtil.log("A(int ... i)");
		}
		A(int i,String s,Long l){
			LogUtil.log("A(int i,String s,Long l)");
		}
//		A(T...t){
//			LogUtil.log("A(T...t)");
//		}
		A(Object...t){
			LogUtil.log("A(T...t)");
		}
	}
}
