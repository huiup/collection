package com.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//��ű�ѡ�γ�
public class ListTest {

	public List coursesToSelect;
	public ListTest() {
		this.coursesToSelect = new ArrayList();
		
	}
	public void testAdd(){
		Course cr1 = new Course("1", "���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);;
		System.out.println("����˿γ̣�"+temp.id+":"+temp.name);

		Course cr0 = new Course("1", "���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp0 = (Course) coursesToSelect.get(0);;
		System.out.println("����˿γ̣�"+temp0.id+":"+temp0.name);
		
		Course cr2 = new Course("2", "C����");
		coursesToSelect.add(2, cr2);
		Course temp2 = (Course) coursesToSelect.get(2);
		System.out.println("����˿γ̣�"+temp2.id+":"+temp2.name);

//		Course cr3 = new Course("3", "test");
//		coursesToSelect.add(3,cr3);
//��Խ��
		Course[] course = {new Course("3","��ɢ��ѧ"),new Course("4","�������")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(3);
		Course temp4 = (Course) coursesToSelect.get(4);
		System.out.println("����˿γ̣�"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		
		Course[] course2 = {new Course("5","�ߵ���ѧ"),new Course("6","��ѧӢ��")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		System.out.println("����˿γ̣�"+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
		
	}
	
	/**
	 * 
	 * ȡ��list�е�Ԫ�صķ���
	 */
	
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("�����¿γ̴�ѡ��");
		for (int i = 0; i < size; i++) {
		Course cr = (Course) coursesToSelect.get(i);
		System.out.println("�γ̣�"+cr.id+":"+cr.name);
		
		}
	}
	
	/**
	 * ͨ������������List�е�Ԫ��
	 * @param agrs
	 */
	public void testIterator() {
		Iterator it = coursesToSelect.iterator();
		System.out.println("�����¿γ̴�ѡ(ͨ��������)��");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
		}
	}
	
	public void testForEach() {
		System.out.println("�����¿γ̴�ѡ(ͨ��foreach)��");
		for(Object obj:coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
		}
		
	}
	/**
	 * �޸�List�е�Ԫ��
	 * @param agrs
	 */
	
	public void testModify() {
		coursesToSelect.set(1,new Course("7","ë��"));
		
	}
	
	/**
	 * ɾ��List�е�Ԫ��
	 * @param agrs
	 */
	public void testRemove() {
		System.out.println("ִ��ɾ��������ɾ��4��5λ���ϵĿγ�");
		//Course cr =(Course) coursesToSelect.get(4);
		//System.out.println("���ǿγ̣�"+cr.id+":"+cr.name+"�Ҿ�ҪGG��");
		//������ɾ��
		//coursesToSelect.remove(cr);
		//������ɾ��
		//coursesToSelect.remove(4);
		//������ɾ�����
		Course[] courses = {(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("�ɹ�ɾ���γ̣�");
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
