package sopo.cn.test;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.IDCard;
import sopo.cn.hibernate20191126.model.IdCard2;
import sopo.cn.hibernate20191126.model.Person;
import sopo.cn.hibernate20191126.model.Person2;

public class TestOneToOne {
	
	
	@Test
	public void test1() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Person person = new Person();
		person.setName("救世主");
		
		IDCard idCard = new IDCard();
		idCard.setCardNo("349873788931");
		
		person.setIdcard(idCard);
		idCard.setPerson(person);
		
		session.save(person);
		session.save(idCard);
		
		transaction.commit();
	}
	
	@Test
	public void test2() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.getTransaction();
		
		Person2 person2 = new Person2();
		person2.setName("妖姬");
		
		IdCard2 idCard2 = new IdCard2();
		idCard2.setCardNo("49871697943");
		
		idCard2.setPerson(person2);
		person2.setIdCard(idCard2);
		
		session.save(idCard2);
		session.save(person2);
		
		transaction.commit();
	}
}
