package com.jihe;

/**
 * 知识点：Comparable接口（重写compareTo方法）、equals的重写、hashCode的重写
 * 
 */
import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student>{
//实现Comparable接口，则必须实现其compareTo方法
	public String id;
	public String name;
	public Set<Course> courses;
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses=new HashSet<Course>();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
//this对象大于o时，返回1,；等于时，返回0；小于时，返回-1		
//		return 0;
//		return this.name.compareTo(o.name);按name排序
		return this.id.compareTo(o.id);//按id排序
	}
	
	
}
