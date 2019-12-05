package sopo.cn.test;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import sopo.cn.hibernate20191126.model.CarBrand;

public class CarBrandTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		CarBrand carBrand = new CarBrand( "º·Âíhx", 291, 6.3);
		session.save(carBrand);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
