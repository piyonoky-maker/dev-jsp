package lab.common;

import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
/*
 * 컨트롤러 마다 중복적으로 넣기 싫은 공통기능 (로깅/인증/인코딩 등) 을 필터에서 한번에 처리
 * Fiilter는  JSP/서블릿 기반 웹서비스에서 최적화(성능/자원/응답크기/캐시/보안)을 위한 앞단 공통 도구로 활용
 * 
 *  DispatherServlet이전에서 모든 요청/응답을  가로챌 수 있다
 *  jsp가 실해오디지 전/후에 요청, 응답을 통제 할 수 있다
 *  최적화 포인트 넣기 좋다
 * */
@WebFilter("/*")	//모든요청에 대한 MyWebFilter적용 선언
public class MyWebFilter implements Filter {
	Logger log = Logger.getLogger(MyWebFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("init");
	}//end of init
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
		// 1. 전처리 작업
		long startTime = System.currentTimeMillis();
		try {
			HttpServletRequest httpReq = (HttpServletRequest) req;
			log.info("[IN]\t"+httpReq.getMethod()+", \t"+httpReq.getRequestURI());
			//다음 필터로 연결 -  다음 단계로 진행되어야 한다.
			//파라미터로 요청객체와 응답객체를 넘김 - 원본 - 하나의 스레드
			filterChain.doFilter(req, res);
		}catch(Exception e){
			log.info("Exception : "+e.toString());
		}finally {
			//예외가  발생하더라도 항상  실행되어 처리시간을 출력예정
			long endTime = System.currentTimeMillis();
			if(req instanceof HttpServletRequest httpReq) {
				String uri = httpReq.getRequestURI();
				long elapsed = endTime - startTime;
				log.info("[OUT]["+uri+"] time = "+elapsed+"ms");
			}else {
				log.info("[non-http-request] time="+(endTime-startTime)+"ms");
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("destroy");
	}//end of destroy
}
