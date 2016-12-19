package hand.zjf.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter  implements Filter {
       
    /**
     * @see Filter#Filter()
     */
    public LoginFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");
		String path = req.getServletPath();
		System.out.println(path);
		if(path!=null&&(path.equals("/jsp/login.jsp")||path.equals("/index.jsp")||path.equals("/LoginServlet"))){
			chain.doFilter(req, resp);
		}else{
			if(flag!=null&&flag.equals("success")){
				chain.doFilter(req, resp);
			}else{
				req.setAttribute("path", path);
				req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
			}	
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
