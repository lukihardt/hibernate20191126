package sopo.cn.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Test191205;

public class Run191205 {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Test191205 test191205 = new Test191205();
		test191205.setName("test");
		
		session.save(test191205);
		transaction.commit();
	}
}
