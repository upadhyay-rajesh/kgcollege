package com.springcore1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("b1")
public class Trainees {
	//if @Autowired will be used then
	//1. will create setter method automatically
	//2. from abc.xml file remove <property> tag
	//3. inside abc.xml we have to enable annotation using <ctx:annotation-config></ctx:annotation-config>
	
	
	@Autowired
	TrainerInterface ti;
	
	//adapter
	/*public void setTi(TrainerInterface ti) {
		this.ti = ti;
	}*/

	public void print() {
		ti.teach();
	}
	
	public static void main(String[] args) {
		//calling BeanFactory class and loading abc.xml inside BeanFactory
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("abc.xml");
		Trainees tt=(Trainees)ctx.getBean("b1");
		
		/*will do by spring
		Trainees tt=new Trainees();
		
		TrainerInterface t1=new Trainer();
		tt.setTi(t1);    //dependency injection
		*/
		tt.print();

	}

}
