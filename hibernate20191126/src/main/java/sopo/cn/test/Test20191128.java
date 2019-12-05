package sopo.cn.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Student;

public class Test20191128 {

	@Test
	public void test1() {
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
		// Session session =
		// HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();

		Student s1 = session.load(Student.class, 1);
		System.out.println(s1);
		s1 = null;
		Student s2 = session.load(Student.class, 1);
		System.out.println(s2);

	}

	@Test
	public void test2() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Student s1 = session.load(Student.class, 1);
		s1.setName("ironMan");
		session.flush();
		transaction.commit();
	}

	@Test
	public void test3() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();

		Student student = session.load(Student.class, 1);
		student.setName("www");
		System.out.println(student);
		session.refresh(student);
		System.out.println(student);
	}

	@Test
	public void test4() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();

		Student student = session.load(Student.class, 1);
		System.out.println(student);
		session.clear();

		Student student2 = session.load(Student.class, 1);
		System.out.println(student2);
	}

	@Test
	public void test5() {
		Student student = new Student("hyok", "ÄÐ", 22, new Date(new java.util.Date().getTime()));

		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		session.save(student);
		transaction.commit();
	}

	// ÓÎÀë×´Ì¬²âÊÔ1£º
	@Test
	public void test6() {
		Student student = new Student();
		student.setId(2);
		student.setName("ÍõÎå");
		student.setSex("ÄÐ");
		student.setAge(20);
		student.setDate(new Date(new java.util.Date().getTime()));

		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		// session.save(student);
		session.update(student);
		transaction.commit();
	}

	@Test
	public void test7() {
		Student student = new Student();
		student.setId(2);
		student.setName("ÕÅÈý");
		student.setSex("ÄÐ");
		student.setAge(20);
		student.setDate(new Date(new java.util.Date().getTime()));

		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		// student.setId(77);
		transaction.commit();
	}

	@Test
	public void test8() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();

		Student student = new Student();
		student.setName("¶«¸ç");
		student.setSex("ÄÐ");
		student.setAge(20);
		student.setDate(new Date(new java.util.Date().getTime()));

		System.out.println(student);
		session.save(student);
		System.out.println(student);

		Transaction transaction = session.beginTransaction();
		System.out.println(student);
		transaction.commit();

	}

	@Test
	public void testGetLoad() {
		// Session session =
		// HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();

		// Student student = session.load(Student.class, 1);
		// System.out.println(student);

//		Student student2 = session.get(Student.class, 1);
//		System.out.println(student2);
	}

	@Test
	public void testUpdate() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Student student = session.get(Student.class, 1);
		session.save(student);
		session.close();

		Session session2 = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		student.setName("lhj");
		session2.update(student);

		Transaction transaction = session2.beginTransaction();
		transaction.commit();
	}

	@Test
	public void testDelete() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = session.load(Student.class, 8);
		session.delete(student);
		
		transaction.commit();
	}
}
