package lab.ch01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//서블릿도 브라우저의 URL요청으로 호출을 할 수 있다
@WebServlet("/crudDept")		//@Controller+ @RequestMappting
public class CrudDeptServlet extends HttpServlet {
	Logger log = Logger.getLogger(CrudDeptServlet.class);
	
	/************************************************************************************************************************
	 * DELETE FROM DEPT WHERE DEPTNO = ?
	 * @param deptno 10,  20,  30
	 * @return int  1이면 삭제 성공, 0이면 실패
	 *************************************************************************************************************************/
	//삭제하기 구현
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doDelete(req, resp);
		log.info("doDelete");
		resp.sendRedirect("/dept/deptDeleteOk.jsp");
	}

	/************************************************************************************************************************
	 * SELECT DEPTNO, DNAME, LOC FROM DEPT
	 * @return List<Map>, List<DeptVO> 
	 *************************************************************************************************************************/
	//조회, 상세조회 - 주문조회, 로그인
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		log.info("doGet");
		
		
		
		// insert here - 조회결과를 가지고 있다
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("deptno",10);
		map.put("dname","총무부");
		map.put("loc","서울");
		list.add(map);
		map = new HashMap<>();
		map.put("deptno",20);
		map.put("dname","개발부");
		map.put("loc","부산");
		list.add(map);
		map = new HashMap<>();
		map.put("deptno",30);
		map.put("dname","운영부");
		map.put("loc","제주");
		list.add(map);
		
		//요청이 유지되는 동안에는 이 주소번지로 공유 가능함
		//공유가 안되면 NullPointerException -> 500 -> Runtime에러
		req.setAttribute("list", list);
		
		//jsp페이지 호출하기 - forward로 해야 한다
		//왜냐면 servlet  과 jsp가 요청이 계속 유지되고 있다 라고 생각
		//비상태 프로토콜 이란 요청URL이 바뀌면  기존에 요청이 끊어 지고 새로운요청이 발생함
		//유지가 안됨
		RequestDispatcher view = req.getRequestDispatcher("/dept/deptList.jsp");
		view.forward(req, resp);
		
	}
	/************************************************************************************************************************
	 * INSERT INTO DEPT(
	 * 		DEPTNO, DNAME, LOC
	 * 	) VALUES(
	 *   	:DEPTNO, :DNAME, :LOC
	 * )
	 *   
	 * @param 사용자가 입력한 부서명 - dname
	 * @param 사용자가 입력한 지역명 - loc
	 * @param 사용자가 선택한 부서번호 - deptno
	 * @return int  1이면 삭제 성공, 0이면 실패
	 * !!! 브라우저의 URL을 통해서는 POST 방식을 테스트 할 수 없다
	 * 		postman, swagger, javascript등의 툴로 사용해야 함
	 *************************************************************************************************************************/
	//입력, 저장, 파일 업로드, 조회인데 보안상 값이 노축되지 않도록 할 때
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		log.info("doPost");
		
		resp.sendRedirect("/dept/deptInsertOk.jsp");
	}
	//수정하기 구현

	/************************************************************************************************************************
	 * UPDATE DEPT SET
	 *   	DNAME = '수정할 부서명'
	 * 	 	, LOC='수정할  지역명'
	 * WHERE 
	 *		DEPTNO = 수정할 부서번호(pk)
	 * @param 사용자가 입력한 부서명 - dname
	 * @param 사용자가 입력한 지역명 - loc
	 * @param 사용자가 선택한 부서번호 - deptno
	 * @return int  1이면 삭제 성공, 0이면 실패
	 * @question: doPut메서드의 리턴 타입이 void인데 1또는 0인데 어떻게 jsp페이지에 전달 할 수 있을까?
	 *************************************************************************************************************************/
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPut");
		/*
			req.getParameter("dname");
			req.getParameter("loc");
			req.getParameter("deptno");
		 * */
		resp.sendRedirect("/dept/deptUpdateOk.jsp");
 	}

}
