package sopo.cn.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate.utils.HibernateUtils;
import sopo.cn.hibernate20191126.model.Student;

public class Test20191130 {
	@Test
	public void add1() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student(8, "小白", "男", 8, new Date(new java.util.Date().getTime()));
		session.save(student);
		session.evict(student);
		
		transaction.commit();
	}
	
	@Test
	public void doWorkTest() {
		Session session = HibernateUtils.getSessionFactory("hibernate.cfg.xml").openSession();
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println(connection);
				
				// 没啥锟矫ｏ拷锟斤拷锟斤拷锟斤拷
//				String sql = null;
//				PreparedStatement preparedStatement = connection.prepareStatement(sql);
//				preparedStatement.execute();
			}
		});
	}
	
}
