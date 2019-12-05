package sopo.cn.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Bird;
import sopo.cn.hibernate20191126.model.Pig;

public class SubMappingTest {
	
	@Test
	public void test1() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Pig pig = new Pig();
		pig.setId(18);
		pig.setName("ll");
		pig.setWeight(108.1);
		
		Bird bird = new Bird();
		bird.setId(20);
		bird.setName("flyer");
		bird.setHeight(14.1);
		
		session.save(pig);
		session.save(bird);
		
		transaction.commit();
	}
}
