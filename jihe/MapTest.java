package com.jihe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/**
	 * ������װѧ�����Ͷ���
	 * @param args
	 */
	public Map<String,Student> students;
	
	/**
	 * �ڹ������г�ʼ��student����
	 */
	public MapTest() {
		this.students=new HashMap<String, Student>();
	}
	/**
	 * ������ӣ�����ѧ��ID���ж��Ƿ�ռ��
	 * ��δ��ռ�ã�������������������ѧ������
	 * ������ӵ�students��
	 */
	public void testPut() {
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while(i<3) {
			System.out.println("������ѧ��ID��");
			String ID=scanner.next();
			Student st=students.get(ID);
			if(st==null) {
				System.out.println("������ѧ����������");
				String name=scanner.next();
				//�����µ�ѧ������
				Student newStudent = new Student(ID,name);
				//ͨ������students��put���������ID-ѧ��ӳ���ϵ
				students.put(ID, newStudent);
				System.out.println("�ɹ����ѧ����"+students.get(ID).name);
				i++;
			}else {
				System.out.println("��ѧ��ID�ѱ�ռ�ã�");
				continue;
			}
		}
	}
	/**
	 * ����map��keySet����
	 * @param args
	 */
	public void testKeySet() {
		//ͨ��keySet����������Map�е����С�������Set����
		Set<String> keySet=students.keySet();
		//ȡ��students������
		System.out.println("�ܹ��У�"+students.size()+"��ѧ��");
		for (String stuId : keySet) {
			Student st=students.get(stuId);
			if(st!=null) {
				System.out.println("ѧ����"+st.name);
			}
		}
	}
	
	/**
	 * ����ɾ��Map�е�ӳ��
	 * 
	 * @param args
	 */
	
	public void testRemove() {
		//�����ɾ����ѧ����ID
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("������Ҫɾ��ѧ����ID��");
			String ID=scanner.next();
			Student st =students.get(ID);
			if(st==null) {
				System.out.println("��ID�����ڣ�");
				continue;
			}
			students.remove(ID);
			System.out.println("�ɹ�ɾ��ѧ��:"+st.name);
			break;
		}
	}
	
	/**
	 * ͨ��entrySet����������Map
	 * @param args
	 */
	public void testEntrySet() {
		//ͨ��entrySet����������Map�е����м�ֵ��
		Set<Map.Entry<String,Student>> entrySet=students.entrySet();
		for (Map.Entry<String, Student> entry : entrySet) {
			System.out.println("ȡ�ü���"+entry.getKey());
			System.out.println("��Ӧ��ֵΪ��"+entry.getValue().name);
		}
	}
	/**
	 * ����put�����޸�Map�е�����ӳ��
	 * @param args
	 */
	public void testModify() {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("������Ҫ�޸ĵ�ѧ��ID��");
			//ȡ��ѧ��ID
			String stuID=scanner.next();
			Student student = students.get(stuID);
			if(student==null) {
				System.out.println("��ѧ��ID�����ڣ������������룡");
				continue;
			}
			System.out.println("��ǰѧ��id����Ӧ��ѧ��Ϊ��"+student.name);
			System.out.println("�������µ�ѧ��������");
			String name =scanner.next();
			Student newStu=new Student(stuID,name);
			students.put(stuID, newStu);
			System.out.println("�޸ĳɹ���");
			break;
		}
	}
	/**
	 * ����Map���Ƿ����ĳ��keyֵ����ĳ��valueֵ
	 * @param args
	 */
	public void testContainsKeyOrValue() {
		//��ѯid
		System.out.println("������Ҫ��ѯѧ����ID��");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		//��Map�У���containsKey()���������ж��Ƿ����ĳ��keyֵ
		System.out.println("�������ѧ��IDΪ��"+id+"����ѧ��ӳ������Ƿ���ڣ�"+students.containsKey(id));
		if(students.containsKey(id))
			System.out.println("��Ӧ��ѧ��Ϊ��"+students.get(id).name);
		//��ѯ����
		System.out.println("������Ҫ��ѯѧ����������");
		String name = scanner.next();
		//��Map�У���containValue()���������ж��Ƿ����ĳ��valueֵ
		if(students.containsValue(new Student(null,name)))
			System.out.println("����ѧ����"+name);
		else
			System.out.println("�����ڸ�ѧ����");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MapTest mt = new MapTest();
		mt.testPut();//���
		mt.testKeySet();//ȡkey
//		mt.testRemove();//ɾ��
//		mt.testEntrySet();//ȡ��ֵ��
//		mt.testModify();//ͨ��put�޸�Map�е�ӳ��
//		mt.testEntrySet();//ͨ��entrySetȡ�ü�ֵ
		mt.testContainsKeyOrValue();
	}

}
