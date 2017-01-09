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
		//MyBatis的配置文件
		String resource = "MyBatis.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = UserDAL.class.getClassLoader().getResourceAsStream(
				resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		/**
		 * 映射sql的标识字符串， com.bank.mapper.userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUserById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.bank.mapper.userMapper.getUserById";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		UserInfo user = session.selectOne(statement, id);
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		session.close();
		return user;
	}
}
