package com.jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class testGeneric {

	/**
	 * 
	 * ���з��͡�������Course,��List��������
	 */
	public List<Course> courses;
	
	public testGeneric() {
		this.courses = new ArrayList<Course>();
		
	}
	/**
	 * ��������
	 * @param args
	 */
	public void testAdd() {
		Course cr1 = new Course("1","��ѧӢ��");
		courses.add(cr1);
		//courses.add("������������");//����������ӷ��͹涨�����ͼ�������������Ķ���
		Course cr2 = new Course("2","�ߵ���ѧ");
		courses.add(cr2);
	}
	/**
	 * ����ѭ������
	 * @param args
	 */
	public void testForEach() {
		for(Course cr : courses) {
			System.out.println("�γ��У�"+cr.id+":"+cr.name);
		}
		System.out.println("--------------------");
	}
	/**
	 * ������ȡֵ
	 */
	public void testIterator() {
		Iterator it = courses.iterator();
		System.out.println("�����¿γ̴�ѡ(ͨ��������)��");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
		}
	}
	
	/**
	 * 
	 * ���ͼ��Ͽ�����ӷ��������Ͷ���Ķ���ʵ��
	 * @param args
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id="3";
		ccr.name="���������͵Ŀγ̶���ʵ��";
		courses.add(ccr)
;	}
	
	//�����в���ʹ�û����������ͣ�����ʹ�����װ��
	public void testBasicType() {
		//List<int> list = new ArrayList<int>();
		List<Integer> list= new ArrayList<Integer>();
		list.add(1);
		System.out.println("�������ͱ���ʹ�����װ����Ϊ����!"+list.get(0));
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
