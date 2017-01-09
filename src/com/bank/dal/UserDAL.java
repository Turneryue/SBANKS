package com.bank.dal;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bank.idal.IUserDAL;
import com.bank.model.UserInfo;

public class UserDAL  implements IUserDAL {

	@Override
	public UserInfo getUserInfo(int id){
		//MyBatis�������ļ�
		String resource = "MyBatis.xml";
		// ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		InputStream is = UserDAL.class.getClassLoader().getResourceAsStream(
				resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		// ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		// Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ����� com.bank.mapper.userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getUserById��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "com.bank.mapper.userMapper.getUserById";// ӳ��sql�ı�ʶ�ַ���
		// ִ�в�ѯ����һ��Ψһuser�����sql
		UserInfo user = session.selectOne(statement, id);
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		session.close();
		return user;
	}
}
