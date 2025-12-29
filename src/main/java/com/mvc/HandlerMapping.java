package com.mvc;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static	Logger log = Logger.getLogger(HandlerMapping.class);
	/***********************************************************
	 * 
	 * @param command - dept/deptInsert , emp/empDelete
	 *               , member/memberUpdate,,,
	 * @return
	 **********************************************************/
	public static Controller getController(String command) {
		Controller controller = null;
		Object obj = null;
		String commands[] = command.split("/");
		//commands[0] => emp, dept, member
		//commands[1] => empInsert, deptUpdate, memberDelete
		if(commands.length == 2) {
			String work = commands[0];
			String methodName = commands[1];
			//부서관리인가?
			//개발자가 직접 코드로 인스턴스화를 하였다. 
			//- 객체관리 책임이 개발자에게 있다.: 의존성 주입이 아니다
			if("deptInsert".equals(work)) {
				controller = new DeptController();
				if("deptInsert".equals(methodName)) {
					log.info("deptInsert-부서등록");
					//사용자가 입력한 값을  전달 하기 위해서 req, res가 필요함
					//obj = controller.deptInsert(req, res);
				}
			}
			else if("deptUpdate".equals(work)) {
				controller = new EmpController();
				if("deptUpdate".equals(methodName)) {
					log.info("deptInsert-부서1건 수정");
				}
			}
			else if("deptDelete".equals(work)) {
				controller = new MemberController();
				if("deptDelete".equals(methodName)) {
					log.info("deptDelete-부서 삭제");
				}
			}
			else if("deptDetail".equals(work)) {
				controller = new MemberController();
				if("deptDetail".equals(methodName)) {
					log.info("deptInsert-부서조회 한건");
				}
			}
			else if("deptList".equals(work)) {
				controller = new MemberController();
				if("deptList".equals(methodName)) {
					log.info("deptInsert-부서목록 n건 조회");
				}
			}
		}
		return controller;
	}
}