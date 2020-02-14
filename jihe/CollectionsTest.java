package com.jihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class CollectionsTest {

/**
 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
 * @param args
 */
	
	public void testSort1() {
		List<Integer> integerList=new ArrayList<Integer>();
		Random random =new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数："+k);
		}

		System.out.println("");
		for (Integer integer : integerList) {
			System.out.println("元素："+integer);
		}
		Collections.sort(integerList);
		System.out.println("------------排序后----------------");
		for (Integer integer : integerList) {
			System.out.println("元素："+integer);
		}

	}
	/**
	 * 2.对String泛型的List进行排序
	 * 先比较第一个字符（先数字，而后大写字母，最后小写字母），
	 * 若相同，则比较下一个字符（规则相同）
	 * @param args
	 */
	public void testSort2() {
		List<String> stringList=new ArrayList<String>();
		Random random =new Random();
		StringBuilder s=new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
		int num;//一串字符的长度
		for (int i = 0; i < 10; i++) {
			StringBuilder sb=new StringBuilder();
			num= random.nextInt(10)+1;
			do {
				for (int j = 0; j < num; j++) {
					int num2=random.nextInt(s.length());//取s字符串大小的随机整数
					char randomChar=s.charAt(num2);//通过索引取值
					sb.append(randomChar);
				}
			}while(stringList.contains(sb.toString()));
			
			stringList.add(sb.toString());
			System.out.println("添加字符串成功："+sb.toString());
		}

		System.out.println("------------排序前----------------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringList);
		System.out.println("------------排序后----------------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
	}
	/**
	 * 3.对其他类型泛型的List进行排序，以Student为例。
	 * @param args
	 */
	public void testSort3() {
		List<Student> studentList =new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000)+"","Jack"));
		studentList.add(new Student(random.nextInt(1000)+"","Anna"));
		studentList.add(new Student(random.nextInt(1000)+"","Tom"));
		studentList.add(new Student(10000+"","BUG"));
		//System.out.println("按照id排序:");
		System.out.println("按照name排序:");
		System.out.println("------------排序前----------------");
		for (Student student : studentList) {
			System.out.println("学生："+student.id+":"+student.name);
		}
		Collections.sort(studentList);
//		Collections.sort(studentList, new StudentComparator());;
		System.out.println("------------排序后----------------");
		for (Student student : studentList) {
			System.out.println("学生："+student.id+":"+student.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct =new CollectionsTest();
//		ct.testSort1()；	
//		ct.testSort2();
		ct.testSort3();
	}

}
