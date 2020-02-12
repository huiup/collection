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
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);;
		//System.out.println("添加了课程："+temp.id+":"+temp.name);


		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(1, cr2);
		Course temp2 = (Course) coursesToSelect.get(1);
		//System.out.println("添加了课程："+temp2.id+":"+temp2.name);

//		Course cr3 = new Course("3", "test");
//		coursesToSelect.add(3,cr3);
//会越界
		Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
		//System.out.println("添加了课程："+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);
		
		
		Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		//System.out.println("添加了课程："+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
		
	}
	
	public void testForEach() {
		System.out.println("有如下课程待选(通过foreach)：");
		for(Object obj:coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("课程："+cr.id+":"+cr.name);
		}
		
	}
	public void testForEachForSet(Student student) {
		//打印输出所选的课程
				for (Course cr : student.courses) {
					System.out.println("选择了如下课程：");
					System.out.println(cr.id+":"+cr.name);
				}
	}
	/**
	 * 测试List的contains方法
	 * @param args
	 * 先遍历每个元素，再调用equals()方法进行比较
	 */
	public void testListContains() {
		Course course = coursesToSelect.get(0);
		System.out.println("取得课程："+course.name);
		System.out.println("备选课程中是否包含课程："+course.name+","+coursesToSelect.contains(course));
		//创建一个新的课程对象，ID和名称，与course对象完全一样
		//新的对象course2和course是两个不同的对象，所以不包含在序列中
		//重写equals方法后，为true
		System.out.println("请输入课程名称：");
		String scanName=scanner.next();
		Course course2 =new Course();
		course2.name=scanName;
		//System.out.println("新创建课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+coursesToSelect.contains(course2));
		//通过indexOf方法来获取某元素的索引位置
		if(coursesToSelect.contains(course2))
			System.out.println("课程："+course2.name+"的索引位置为："+coursesToSelect.indexOf(course2));
	}
	
	/**
	 * 创建学生对象并选课
	 */
	public void creatStudentAndSelectCourses() {
		//创建一个学生对象
		student = new Student("1","小明");
		System.out.println("欢迎学生："+student.name+"选课");
		//创建一个Scanner对象
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.println("请输入课程ID:");
			String courseId=scanner.next();
			for(Course cr: coursesToSelect) {
				if(cr.id.equals(courseId)) {
					student.courses.add(cr);
					/**
					 * set中，若重复添加同一个对象多次，最终也只会保留一个
					 * 该对象的引用，并且保留的是第一次添加的那个。
					 */
					//student.courses.add(cr);
					//student.courses.add(null);也可以添加null，但没意义
				}
			}
		}
	}
	/**
	 * 测试Set的contain方法
	 * @param args
	 * 先遍历元素，在调用hashCode()返回其哈希码进行比较，
	 * 若相等，则再用equals()方法进行比较。
	 * 即：Set区别对象是不是唯一的标准是，两个对象hashcode是不是一样，
	 * 再判定两个对象是否equals;
	 */
	public void testSetContain() {
		System.out.println("请输入学生已选课程的名称：");
		String name = scanner.next();
		Course course2 =new Course();
		course2.name=name;
		System.out.println("新创建课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+student.courses.contains(course2));
		
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
