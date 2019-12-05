package sopo.cn.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Course;
import sopo.cn.hibernate20191126.model.MCourse;
import sopo.cn.hibernate20191126.model.Tcher;
import sopo.cn.hibernate20191126.model.Tcher2;

public class TestManyToMany191204 {

	@Test
	public void test() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Tcher tcher = new Tcher();
		tcher.setName("夜玫瑰");

		Course course = new Course();
		Course course2 = new Course();

		course.setName("hibernate");
		course2.setName("jdbc");

		Set<Course> set = new HashSet<>();
		set.add(course);
		set.add(course2);
		tcher.setCourses(set);

		session.save(tcher);
		session.save(course);
		session.save(course2);

		transaction.commit();
	}

	@Test
	public void testManyTcherManyCourses() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Tcher2 tcher = new Tcher2();
		tcher.setName("潘多拉");
		Tcher2 tcher2 = new Tcher2();
		tcher2.setName("奥摩");

		MCourse course = new MCourse();
		MCourse course2 = new MCourse();
		course.setName("spring");
		course2.setName("mysql");

		Set<Tcher2> setTchers = new HashSet<>();
		setTchers.add(tcher);
		setTchers.add(tcher2);

		Set<MCourse> setCourses = new HashSet<>();
		setCourses.add(course);
		setCourses.add(course2);

		tcher.setCourses(setCourses);
		tcher2.setCourses(setCourses);
		course.setSet(setTchers);
		course2.setSet(setTchers);

		session.save(tcher);
		session.save(tcher2);
		session.save(course);
		session.save(course2);

		transaction.commit();
	}

	@Test
	public void testManyTcherManyCourses2() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Tcher2 tcher = new Tcher2();
		tcher.setName("兰");
		Tcher2 tcher2 = new Tcher2();
		tcher2.setName("波塞冬");

		MCourse course = new MCourse();
		MCourse course2 = new MCourse();
		course.setName("jpa");
		course2.setName("spring");

		Set<Tcher2> setTchers = new HashSet<>();
		setTchers.add(tcher);
		setTchers.add(tcher2);

		Set<MCourse> setCourses = new HashSet<>();
		setCourses.add(course);
		setCourses.add(course2);

		tcher.setCourses(setCourses);
		tcher2.setCourses(setCourses);
		course.setSet(setTchers);
		course2.setSet(setTchers);

		session.save(tcher);
		session.save(tcher2);
		session.save(course);
		session.save(course2);

		transaction.commit();
	}
}
