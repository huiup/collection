package com.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class setTest {

	public List<Course> coursesToSelect;
	private Scanner scanner;
	public Student student;
	public setTest() {
		this.coursesToSelect=new ArrayList<Course>();
		scanner=new Scanner(System.in);
	}
	
	public void testAdd(){
		Course cr1 = new Course("1", "���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);;
		//System.out.println("����˿γ̣�"+temp.id+":"+temp.name);


		Course cr2 = new Course("2", "C����");
		coursesToSelect.add(1, cr2);
		Course temp2 = (Course) coursesToSelect.get(1);
		//System.out.println("����˿γ̣�"+temp2.id+":"+temp2.name);

//		Course cr3 = new Course("3", "test");
//		coursesToSelect.add(3,cr3);
//��Խ��
		Course[] course = {new Course("3","��ɢ��ѧ"),new Course("4","�������")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
		//System.out.println("����˿γ̣�"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		
		Course[] course2 = {new Course("5","�ߵ���ѧ"),new Course("6","��ѧӢ��")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		//System.out.println("����˿γ̣�"+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
		
	}
	
	public void testForEach() {
		System.out.println("�����¿γ̴�ѡ(ͨ��foreach)��");
		for(Object obj:coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
		}
		
	}
	public void testForEachForSet(Student student) {
		//��ӡ�����ѡ�Ŀγ�
				for (Course cr : student.courses) {
					System.out.println("ѡ�������¿γ̣�");
					System.out.println(cr.id+":"+cr.name);
				}
	}
	/**
	 * ����List��contains����
	 * @param args
	 * �ȱ���ÿ��Ԫ�أ��ٵ���equals()�������бȽ�
	 */
	public void testListContains() {
		Course course = coursesToSelect.get(0);
		System.out.println("ȡ�ÿγ̣�"+course.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�"+course.name+","+coursesToSelect.contains(course));
		//����һ���µĿγ̶���ID�����ƣ���course������ȫһ��
		//�µĶ���course2��course��������ͬ�Ķ������Բ�������������
		//��дequals������Ϊtrue
		System.out.println("������γ����ƣ�");
		String scanName=scanner.next();
		Course course2 =new Course();
		course2.name=scanName;
		//System.out.println("�´����γ̣�"+course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�"+course2.name+","+coursesToSelect.contains(course2));
		//ͨ��indexOf��������ȡĳԪ�ص�����λ��
		if(coursesToSelect.contains(course2))
			System.out.println("�γ̣�"+course2.name+"������λ��Ϊ��"+coursesToSelect.indexOf(course2));
	}
	
	/**
	 * ����ѧ������ѡ��
	 */
	public void creatStudentAndSelectCourses() {
		//����һ��ѧ������
		student = new Student("1","С��");
		System.out.println("��ӭѧ����"+student.name+"ѡ��");
		//����һ��Scanner����
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.println("������γ�ID:");
			String courseId=scanner.next();
			for(Course cr: coursesToSelect) {
				if(cr.id.equals(courseId)) {
					student.courses.add(cr);
					/**
					 * set�У����ظ����ͬһ�������Σ�����Ҳֻ�ᱣ��һ��
					 * �ö�������ã����ұ������ǵ�һ����ӵ��Ǹ���
					 */
					//student.courses.add(cr);
					//student.courses.add(null);Ҳ�������null����û����
				}
			}
		}
	}
	/**
	 * ����Set��contain����
	 * @param args
	 * �ȱ���Ԫ�أ��ڵ���hashCode()�������ϣ����бȽϣ�
	 * ����ȣ�������equals()�������бȽϡ�
	 * ����Set��������ǲ���Ψһ�ı�׼�ǣ���������hashcode�ǲ���һ����
	 * ���ж����������Ƿ�equals;
	 */
	public void testSetContain() {
		System.out.println("������ѧ����ѡ�γ̵����ƣ�");
		String name = scanner.next();
		Course course2 =new Course();
		course2.name=name;
		System.out.println("�´����γ̣�"+course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�"+course2.name+","+student.courses.contains(course2));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		setTest st = new setTest();
		st.testAdd();
		st.testListContains();
 		st.testForEach();
//		st.creatStudentAndSelectCourses();
//		st.testSetContain();
	}
	

}
