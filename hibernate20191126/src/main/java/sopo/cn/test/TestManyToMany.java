package sopo.cn.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Student;
import sopo.cn.hibernate20191126.model.Teacher;

public class TestManyToMany {

	@Test
	public void test1() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName("猎狐者");
		
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setName("夜玫瑰");
		student2.setName("灵狐者");
		
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);
		
		session.save(teacher);
		session.save(student1);
		session.save(student2);
		
		transaction.commit();
	}
	
	@Test
	public void test2() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName("T1.3");
		
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setName("S1.3");
		student2.setName("S2.3");
		
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);
		
		session.save(teacher);
		session.save(student1);
		session.save(student2);
		
		transaction.commit();
	}
}
