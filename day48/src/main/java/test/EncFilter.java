package test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
@WebFilter("*.jsp")
public class EncFilter extends HttpFilter implements Filter {
       private String encoding;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding); // 하드코딩 -> web.xml(환경설정파일)에 저장되어있던 초기화 매개변수로 교체
		System.out.println("doFilter() 동작완료");

		// pass the request along the filter chain
		chain.doFilter(request, response); // 아무것도 없었것처럼 니할일 해 라는 뜻
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 클래스 최초 초기화 완료");
		// 서버가 처음동작할 때 세팅되는 동작을 담당
		
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
	}

}
