package com.atguigu.crowd.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aguigu.crowd.beam.User;



/**
 * 鐧婚檰鎷︽埅鍣�
 * @author 18801
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 鍦ㄦ帶鍒跺櫒鎵ц涔嬪墠瀹屾垚涓氬姟閫昏緫鎿嶄綔
	 * 鏂规硶鐨勮繑鍥炲�煎喅瀹氶�昏緫鏄惁缁х画鎵ц锛� true锛岃〃绀虹户缁墽琛岋紝 false, 琛ㄧず涓嶅啀缁х画鎵ц銆�
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 鍒ゆ柇褰撳墠鐢ㄦ埛鏄惁宸茬粡鐧婚檰
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if ( loginUser == null ) {
			String path = session.getServletContext().getContextPath();
			response.sendRedirect(path + "/login");
			return false;	
		} else {
			return true;
		}
	}

	/**
	 * 鍦ㄦ帶鍒跺櫒鎵ц瀹屾瘯涔嬪悗鎵ц鐨勯�昏緫鎿嶄綔
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 鍦ㄥ畬鎴愯鍥炬覆鏌撲箣鍚庯紝鎵ц姝ゆ柟娉曘��
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
