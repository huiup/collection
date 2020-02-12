package com.jihe;

class student1{
    String name;
    int age;
    public student1(){
        this("小明",18);//构造方法调用构造方法
    }
    public student1(String name,int age){
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    public student1 AgeIncrement(){
        age+=2;
        return this;
    }
    public void print(){
        System.out.println("age="+age);
    }
}

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student1 s=new student1();
        s.AgeIncrement().AgeIncrement().print();   //age=23
        System.out.println("---"+s.name);
	}

}
