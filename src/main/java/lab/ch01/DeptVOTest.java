package lab.ch01;

import java.util.HashMap;
import java.util.Map;

import lab.vo.DeptVO;


public class DeptVOTest {
	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		
		Map<String, Object> map = new HashMap<>();
		map.put("deptno", 10);
		System.out.println(map.get("deptno"));
		//Map도 한번에 하나의 레코드만 기억이 가능
		System.out.println(map.get("deptno"));
	}
}
