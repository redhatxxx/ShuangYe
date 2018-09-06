package org.fun.shuangye.interceptor;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fun.shuangye.base.bean.UserBaseBean;
import org.fun.shuangye.base.server.IUserBeanManager;
import org.fun.shuangye.common.CookieUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor {
	
	@Resource(name="usermanager")
	private IUserBeanManager usermanager;
	 /** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/**
		 * 自动登录拦截实现
		 *    1),获取用户的session中的AuthenToken
		 *        存在：不做任何操作
		 *   不存在：
		 *    2),获取Cookie中的用户ID，存在，获取该用户的详细信息，保存到session
		 *   Cookie不存在
		 *    3),获取当前访问url
		 *    4),获取web.xml中放行的地址
		 *    5),如果访问的url不是放行的地址，跳转到登录页面
		 */
		String parentPath=request.getContextPath();
		HttpSession httpSession=request.getSession();
		String authenToken=(String) httpSession.getAttribute("user_id");
		if(null==authenToken){
			Cookie[] cookies=request.getCookies();
			if(cookies!=null&&cookies.length>0){
				for (Cookie cookie : cookies) {
					if ("fun_u_uuid".equals(cookie.getName())) {
						String userId = cookie.getValue();
						UserBaseBean  user = usermanager.getUser(userId);
						if(user!=null){
							httpSession.setAttribute("flag", "1");
							httpSession.setAttribute("user_id", user.getUser_id());
							httpSession.setAttribute("showname", user.getUser_name());
							return true;
						}
					}
				}
				/**
				 * 如果以前登录没有选择记住密码
				 *   如果要访问的地址不是要放行的方法，那么拦截跳转到登录页面
				 *   是要放行的方法，放行
				 */
				String path = request.getRequestURI();
				path = path.substring(path.lastIndexOf("/"));
				String noLoginUrl = request.getSession().getServletContext().getInitParameter("noLoginUrl");
				if(noLoginUrl!=null&&!"".equals(noLoginUrl)){
					String[] noLoginUrlArr = noLoginUrl.split(",");
					List<String> list = Arrays.asList(noLoginUrlArr);
					if(list!=null&&list.contains(path)){
						return true;
					}
				}
				if(httpSession.getAttribute("flag")==null||"".equals((String)httpSession.getAttribute("flag")))
					return true;
			}
//			response.sendRedirect(parentPath+"/Note/getAllInfo");
			return true;
		}
		return true;
	}
	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	/** 
     * 在DispatcherServlet完全处理完请求后被调用  
     *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}