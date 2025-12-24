package lab.vo;

import lab.ch01.DeptVOTest;

public class DeptVO {
//	접근제한자를 private올 하면 외부에서 접근불가
	private int deptno = 0;
	private String dname = null;
	private String loc = null;
	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int depno) {
		this.deptno = depno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public static void main(String[] args) {
		DeptVOTest dd = new DeptVOTest();
	}
}
