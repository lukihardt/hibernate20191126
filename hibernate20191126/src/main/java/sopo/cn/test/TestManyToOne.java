package sopo.cn.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Student;
import sopo.cn.hibernate20191126.model.Teacher;

public class TestManyToOne {
	//先增加一的这端
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName("钟浩");
		session.save(teacher);
		
		Student student = new Student();
		student.setName("王五");
		student.setTeacher(teacher);
		session.save(student);
		
		transaction.commit();
	}
	
	//先增加多的这端
	@Test
	public void test2() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setName("影武者");
		session.save(student);
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName("兰");
		session.save(teacher);
		
		student.setTeacher(teacher);
		session.save(student);
		
		transaction.commit();
	}
	
	@Test
	public void test3() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		// Transaction transaction = session.beginTransaction();
		
		Student student = session.load(Student.class, 10);
		
		session.close();
		System.out.println(student.getName());
	}
	
	@Test
	public void testDelete2() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = session.load(Student.class, 9);
		session.delete(student);
		
		transaction.commit();
	}
}
