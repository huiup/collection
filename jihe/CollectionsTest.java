package com.jihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class CollectionsTest {

/**
 * 1.ͨ��Collections.sort()��������Integer���͵�List��������
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
			System.out.println("�ɹ����������"+k);
		}

		System.out.println("");
		for (Integer integer : integerList) {
			System.out.println("Ԫ�أ�"+integer);
		}
		Collections.sort(integerList);
		System.out.println("------------�����----------------");
		for (Integer integer : integerList) {
			System.out.println("Ԫ�أ�"+integer);
		}

	}
	/**
	 * 2.��String���͵�List��������
	 * �ȱȽϵ�һ���ַ��������֣������д��ĸ�����Сд��ĸ����
	 * ����ͬ����Ƚ���һ���ַ���������ͬ��
	 * @param args
	 */
	public void testSort2() {
		List<String> stringList=new ArrayList<String>();
		Random random =new Random();
		StringBuilder s=new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
		int num;//һ���ַ��ĳ���
		for (int i = 0; i < 10; i++) {
			StringBuilder sb=new StringBuilder();
			num= random.nextInt(10)+1;
			do {
				for (int j = 0; j < num; j++) {
					int num2=random.nextInt(s.length());//ȡs�ַ�����С���������
					char randomChar=s.charAt(num2);//ͨ������ȡֵ
					sb.append(randomChar);
				}
			}while(stringList.contains(sb.toString()));
			
			stringList.add(sb.toString());
			System.out.println("����ַ����ɹ���"+sb.toString());
		}

		System.out.println("------------����ǰ----------------");
		for (String string : stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
		Collections.sort(stringList);
		System.out.println("------------�����----------------");
		for (String string : stringList) {
			System.out.println("Ԫ�أ�"+string);
		}
	}
	/**
	 * 3.���������ͷ��͵�List����������StudentΪ����
	 * @param args
	 */
	public void testSort3() {
		List<Student> studentList =new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000)+"","Jack"));
		studentList.add(new Student(random.nextInt(1000)+"","Anna"));
		studentList.add(new Student(random.nextInt(1000)+"","Tom"));
		studentList.add(new Student(10000+"","BUG"));
		//System.out.println("����id����:");
		System.out.println("����name����:");
		System.out.println("------------����ǰ----------------");
		for (Student student : studentList) {
			System.out.println("ѧ����"+student.id+":"+student.name);
		}
		Collections.sort(studentList);
//		Collections.sort(studentList, new StudentComparator());;
		System.out.println("------------�����----------------");
		for (Student student : studentList) {
			System.out.println("ѧ����"+student.id+":"+student.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct =new CollectionsTest();
//		ct.testSort1()��	
//		ct.testSort2();
		ct.testSort3();
	}

}
