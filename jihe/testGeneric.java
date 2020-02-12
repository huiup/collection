package com.jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class testGeneric {

	/**
	 * 
	 * 带有泛型————Course,的List类型属性
	 */
	public List<Course> courses;
	
	public testGeneric() {
		this.courses = new ArrayList<Course>();
		
	}
	/**
	 * 测试增加
	 * @param args
	 */
	public void testAdd() {
		Course cr1 = new Course("1","大学英语");
		courses.add(cr1);
		//courses.add("我来辣！！！");//报错，不能添加泛型规定的类型及其子类型以外的对象
		Course cr2 = new Course("2","高等数学");
		courses.add(cr2);
	}
	/**
	 * 测试循环遍历
	 * @param args
	 */
	public void testForEach() {
		for(Course cr : courses) {
			System.out.println("课程有："+cr.id+":"+cr.name);
		}
		System.out.println("--------------------");
	}
	/**
	 * 迭代器取值
	 */
	public void testIterator() {
		Iterator it = courses.iterator();
		System.out.println("有如下课程待选(通过迭代器)：");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			
			System.out.println("课程："+cr.id+":"+cr.name);
		}
	}
	
	/**
	 * 
	 * 泛型集合可以添加泛型子类型对象的对象实例
	 * @param args
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id="3";
		ccr.name="我是子类型的课程对象实例";
		courses.add(ccr)
;	}
	
	//泛型中不能使用基本数据类型，可以使用其包装类
	public void testBasicType() {
		//List<int> list = new ArrayList<int>();
		List<Integer> list= new ArrayList<Integer>();
		list.add(1);
		System.out.println("基本类型必须使用其包装类作为泛型!"+list.get(0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGeneric tg = new testGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();
	}

}
