package lab.ch01;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import lab.vo.DeptVO;


public class CrudDeptDao {
	Logger log = Logger.getLogger(CrudDeptDao.class);
	//오라클 드라이버 클래스 정보와 scott계정에 관한 정보들이 있다.
	//쿼리문을 가진 dept.xml문서의 물리적인 위치도 여기 있다.
	String resource = "mybatis/MapperConfig.xml";
	SqlSessionFactory sqlMapper = null;

	
	//부서수정 처리
	public int deptUpdate(DeptVO dvo) {
		int result = -1;		//1이면 수정성공, 0이면 수정실패
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);			
			sqlMapper = ssfb.build(reader);
			SqlSession sqlSession = sqlMapper.openSession();
			
			result = sqlSession.insert("deptUpdate",  dvo);
			System.out.println("\n결과값 = "+result);
			
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {}
		
		return result;
	}//end of 부서수정
	
	

	//부서수정 처리
	public int deptUpdate(Map<String, Object> pmap) {
		int result = -1;		//1이면 수정성공, 0이면 수정실패
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);			
			sqlMapper = ssfb.build(reader);
			SqlSession sqlSession = sqlMapper.openSession();
			
			result = sqlSession.insert("deptUpdate",  pmap);
			System.out.println("\n결과값 = "+result);
			
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {}
		
		return result;
	}//end of 부서수정
	
	//부서입력 처리
	public int deptInsert(DeptVO dvo) {
		int result = -1;		//1이면 입력성공, 0이면 입력실패
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);			
			sqlMapper = ssfb.build(reader);
			SqlSession sqlSession = sqlMapper.openSession();
			
			result = sqlSession.insert("deptInsert",  dvo);
			System.out.println("\n결과값 = "+result);
			
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {}
		
		return result;
	}//end of 부서등록

	//부서입력 처리
	public int deptInsert(Map<String, Object> pmp) {
		int result = -1;		//1이면 입력성공, 0이면 입력실패
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);			
			sqlMapper = ssfb.build(reader);
			SqlSession sqlSession = sqlMapper.openSession();
			
			result = sqlSession.insert("deptInsert",  pmp);
			System.out.println("\n결과값 = "+result);
			
			sqlSession.commit();
		}catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {}
		
		return result;
	}//end of 부서등록
	
	//부서 목록 조회
	public List<Map<String, Object>> deptList(){
		List<Map<String, Object>> list = null;
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		try {
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = ssfb.build(reader);
				SqlSession sqlSession = sqlMapper.openSession();
				
				DeptVO dvo = new DeptVO();
				dvo.setDname("운영");
				//dvo.setDname("OPERATIONS");
				
				list = sqlSession.selectList("deptList", dvo);
				log.info(list);//커넥션 얻기 성공 여부확인
				System.out.println(list);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//부서 목록 조회
	public List<Map<String, Object>> deptList(String dname){
		List<Map<String, Object>> list = null;
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		try {
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = ssfb.build(reader);
				SqlSession sqlSession = sqlMapper.openSession();
				
				DeptVO dvo = new DeptVO();
				dvo.setDname(dname);
				
				list = sqlSession.selectList("deptList", dvo);
				log.info(list);//커넥션 얻기 성공 여부확인
				System.out.println(list);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void testDB() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = ssfb.build(reader);
			SqlSession sqlSession = sqlMapper.openSession();
			log.info(sqlSession);//커넥션 얻기 성공 여부확인
			String currentDate = sqlSession.selectOne("currentDate");
			System.out.println(currentDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//end of testDB
	
	
	public static void main(String[] args) {
		CrudDeptDao deptDao = new CrudDeptDao();
		//deptDao.testDB();
		//deptDao.deptList();
		/*
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(50);
		dvo.setDname("개발부");
		dvo.setLoc("인천");
		deptDao.deptInsert(dvo);
		*/
		/*
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(50);
		dvo.setDname("운영부");
		dvo.setLoc("부산");
		deptDao.deptUpdate(dvo);
		*/
		
		deptDao.deptList("운영");
		
	}

}