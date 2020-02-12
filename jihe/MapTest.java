package com.jihe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/**
	 * 用来承装学生类型对象
	 * @param args
	 */
	public Map<String,Student> students;
	
	/**
	 * 在构造器中初始化student属性
	 */
	public MapTest() {
		this.students=new HashMap<String, Student>();
	}
	/**
	 * 测试添加：输入学生ID，判断是否被占用
	 * 若未被占用，则输入姓名，创建新学生对象
	 * 并且添加到students中
	 */
	public void testPut() {
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while(i<3) {
			System.out.println("请输入学生ID：");
			String ID=scanner.next();
			Student st=students.get(ID);
			if(st==null) {
				System.out.println("请输入学生的姓名：");
				String name=scanner.next();
				//创建新的学生对象
				Student newStudent = new Student(ID,name);
				//通过调用students的put方法，添加ID-学生映射关系
				students.put(ID, newStudent);
				System.out.println("成功添加学生！"+students.get(ID).name);
				i++;
			}else {
				System.out.println("该学生ID已被占用！");
				continue;
			}
		}
	}
	/**
	 * 测试map的keySet方法
	 * @param args
	 */
	public void testKeySet() {
		//通过keySet方法，返回Map中的所有“键”的Set集合
		Set<String> keySet=students.keySet();
		//取得students的容量
		System.out.println("总共有："+students.size()+"个学生");
		for (String stuId : keySet) {
			Student st=students.get(stuId);
			if(st!=null) {
				System.out.println("学生："+st.name);
			}
		}
	}
	
	/**
	 * 测试删除Map中的映射
	 * 
	 * @param args
	 */
	
	public void testRemove() {
		//输入待删除的学生的ID
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("请输入要删除学生的ID：");
			String ID=scanner.next();
			Student st =students.get(ID);
			if(st==null) {
				System.out.println("该ID不存在！");
				continue;
			}
			students.remove(ID);
			System.out.println("成功删除学生:"+st.name);
			break;
		}
	}
	
	/**
	 * 通过entrySet方法来遍历Map
	 * @param args
	 */
	public void testEntrySet() {
		//通过entrySet方法，返回Map中的所有键值对
		Set<Map.Entry<String,Student>> entrySet=students.entrySet();
		for (Map.Entry<String, Student> entry : entrySet) {
			System.out.println("取得键："+entry.getKey());
			System.out.println("对应的值为："+entry.getValue().name);
		}
	}
	/**
	 * 利用put方法修改Map中的已有映射
	 * @param args
	 */
	public void testModify() {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("请输入要修改的学生ID：");
			//取得学生ID
			String stuID=scanner.next();
			Student student = students.get(stuID);
			if(student==null) {
				System.out.println("该学生ID不存在！！请重新输入！");
				continue;
			}
			System.out.println("当前学生id所对应的学生为："+student.name);
			System.out.println("请输入新的学生姓名：");
			String name =scanner.next();
			Student newStu=new Student(stuID,name);
			students.put(stuID, newStu);
			System.out.println("修改成功！");
			break;
		}
	}
	/**
	 * 测试Map中是否包含某个key值或者某个value值
	 * @param args
	 */
	public void testContainsKeyOrValue() {
		//查询id
		System.out.println("请输入要查询学生的ID：");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		//在Map中，用containsKey()方法，来判断是否包含某个key值
		System.out.println("你输入的学生ID为："+id+"，在学生映射表中是否存在："+students.containsKey(id));
		if(students.containsKey(id))
			System.out.println("对应的学生为："+students.get(id).name);
		//查询姓名
		System.out.println("请输入要查询学生的姓名：");
		String name = scanner.next();
		//在Map中，用containValue()方法，来判断是否包含某个value值
		if(students.containsValue(new Student(null,name)))
			System.out.println("存在学生："+name);
		else
			System.out.println("不存在该学生！");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MapTest mt = new MapTest();
		mt.testPut();//添加
		mt.testKeySet();//取key
//		mt.testRemove();//删除
//		mt.testEntrySet();//取键值对
//		mt.testModify();//通过put修改Map中的映射
//		mt.testEntrySet();//通过entrySet取得键值
		mt.testContainsKeyOrValue();
	}

}
