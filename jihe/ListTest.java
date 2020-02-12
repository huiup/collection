package com.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//存放备选课程
public class ListTest {

	public List coursesToSelect;
	public ListTest() {
		this.coursesToSelect = new ArrayList();
		
	}
	public void testAdd(){
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);;
		System.out.println("添加了课程："+temp.id+":"+temp.name);

		Course cr0 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp0 = (Course) coursesToSelect.get(0);;
		System.out.println("添加了课程："+temp0.id+":"+temp0.name);
		
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(2, cr2);
		Course temp2 = (Course) coursesToSelect.get(2);
		System.out.println("添加了课程："+temp2.id+":"+temp2.name);

//		Course cr3 = new Course("3", "test");
//		coursesToSelect.add(3,cr3);
//会越界
		Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(3);
		Course temp4 = (Course) coursesToSelect.get(4);
		System.out.println("添加了课程："+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		
		Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		System.out.println("添加了课程："+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
		
	}
	
	/**
	 * 
	 * 取得list中的元素的方法
	 */
	
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("有如下课程待选：");
		for (int i = 0; i < size; i++) {
		Course cr = (Course) coursesToSelect.get(i);
		System.out.println("课程："+cr.id+":"+cr.name);
		
		}
	}
	
	/**
	 * 通过迭代器遍历List中的元素
	 * @param agrs
	 */
	public void testIterator() {
		Iterator it = coursesToSelect.iterator();
		System.out.println("有如下课程待选(通过迭代器)：");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			
			System.out.println("课程："+cr.id+":"+cr.name);
		}
	}
	
	public void testForEach() {
		System.out.println("有如下课程待选(通过foreach)：");
		for(Object obj:coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("课程："+cr.id+":"+cr.name);
		}
		
	}
	/**
	 * 修改List中的元素
	 * @param agrs
	 */
	
	public void testModify() {
		coursesToSelect.set(1,new Course("7","毛概"));
		
	}
	
	/**
	 * 删除List中的元素
	 * @param agrs
	 */
	public void testRemove() {
		System.out.println("执行删除操作！删除4、5位置上的课程");
		//Course cr =(Course) coursesToSelect.get(4);
		//System.out.println("我是课程："+cr.id+":"+cr.name+"我就要GG了");
		//按内容删除
		//coursesToSelect.remove(cr);
		//按索引删除
		//coursesToSelect.remove(4);
		//用数组删除多个
		Course[] courses = {(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("成功删除课程！");
		testForEach();
	}
	
	public static void main(String agrs[]) {
		ListTest lt = new ListTest();
		lt.testAdd();
		System.out.println("--------------------------");
		lt.testGet();
		System.out.println("--------------------------");
		lt.testIterator();
		System.out.println("--------------------------");
		lt.testForEach();
		System.out.println("--------------------------");
		lt.testModify();
		System.out.println("--------------------------");
		lt.testForEach();
		System.out.println("--------------------------");
		lt.testRemove();
		
		
	}
}
