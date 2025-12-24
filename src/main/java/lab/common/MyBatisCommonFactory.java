package lab.common;

import java.io.FileNotFoundException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCommonFactory {
	Logger logger = Logger.getLogger(MyBatisCommonFactory.class);
	public SqlSessionFactory sqlSessionFactory = null;
	//생성자
	public MyBatisCommonFactory() {
		init();//초기화 메서드 호출
	}
	public void init() {
		try {
			String resource = "mybatis/MapperConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if(sqlSessionFactory==null) {
				logger.info("if sqlSessionFactory:"+sqlSessionFactory);
				sqlSessionFactory = 
						new SqlSessionFactoryBuilder().build(reader, "development");
			}//end of if
		} catch (FileNotFoundException ffe) {
			ffe.getMessage();
		} catch(Exception e) {
			e.getMessage();
		}///////////// try..catch
	}//end of init

	public static void main(String[] args) {
		MyBatisCommonFactory mcf = new MyBatisCommonFactory();
		System.out.println(mcf.sqlSessionFactory);
	}//end of main
	
}
