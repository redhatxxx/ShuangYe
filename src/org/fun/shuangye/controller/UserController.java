package org.fun.shuangye.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fun.shuangye.base.bean.UserBaseBean;
import org.fun.shuangye.base.server.IUserBeanManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/user")
public class UserController{

//	@Autowired(required=true)
//	private UserAcionMethod usermethod;
	
	@Resource(name="usermanager")
	private IUserBeanManager usermanager;
	
	//注册用户
	@RequestMapping(value="/user_register")
	public String addUser(UserBaseBean user,Model model,HttpSession httpSession){
		if(usermanager.checkUserName(user.getUser_name())){
			httpSession.setAttribute("unique_user_flag", "0");
			httpSession.setAttribute("errormsg", "用户名已存在！");
			return "/jsp/user/userregister";
		}
		usermanager.addUser(user);
		return "redirect:/index";
	}
	
	//用户登录
	@RequestMapping(value="/user_login")
	public String userLogin(UserBaseBean dao,Model model,HttpSession httpSession){
		String username = dao.getUser_name();
		String password = dao.getUser_password();
		Map loginresult = usermanager.findUserByNameAndPassWord(username,password);
		
		Object errormsg = loginresult.get("errormsg");
		if(errormsg!=null&&!errormsg.toString().equals("")){
			httpSession.setAttribute("flag", "0");
			httpSession.setAttribute("errormsg", errormsg.toString());
			return "/jsp/user/userlogin";
		}else{
			String showname = username;
			if(loginresult.get("nickname")!=null&&
					!loginresult.get("nickname").toString().equals(""))
				showname = loginresult.get("nickname").toString();
			String user_id = loginresult.get("user_id").toString();
			httpSession.setAttribute("flag", "1");
			httpSession.setAttribute("user_id", user_id);
			httpSession.setAttribute("showname", showname);
			if(username.equals("redhat")){
				httpSession.setAttribute("managerflag", "1");
			}
			return "redirect:/index";
		}


	} 

	//用户登录
	@RequestMapping(value="/loginwithuuid")
	public String loginwithuuid(String uuid,Model model,HttpSession httpSession){
		System.out.println("uuid:"+uuid);
		UserBaseBean userbean = usermanager.getUser(uuid);
		
		if(userbean==null){
			
		}else{
			String showname = userbean.getUser_name();
			String nickname = userbean.getUser_nickname();
			if(nickname!=null&&!nickname.equals(""))
				showname = nickname;
			String user_id = userbean.getUser_id();
			httpSession.setAttribute("flag", "1");
			httpSession.setAttribute("user_id", user_id);
			httpSession.setAttribute("showname", showname);
		}
		return "redirect:/index";
	} 
	//用户登出
	@RequestMapping(value="/user_logout")
	public String userLogout(Model model,HttpSession httpSession){
		httpSession.setAttribute("flag", "0");
		httpSession.removeAttribute("flag");
		httpSession.removeAttribute("user_id");
		httpSession.removeAttribute("showname");
		System.out.println("1");
		return "redirect:/index";
	} 
	//保存编辑用户信息
	@RequestMapping(value="/upload_sculpture")
	public String uploadUserSculpture(@RequestParam("usersculpture") MultipartFile usersculpture,Model model,HttpServletRequest request,HttpSession httpSession){
		String imagename = usersculpture.getOriginalFilename();
		File savefile = new File(request.getServletContext().getRealPath("/images"), "upload" + imagename);
		try {
			usersculpture.transferTo(savefile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		UserBaseBean user = usermethod.addUser(dao);
		Object user_id = httpSession.getAttribute("user_id");
		if(user_id==null){
			
		}else{
			boolean flag = usermanager.updateUsersculpture(user_id.toString(),"upload" + imagename);
			if(flag){
				model.addAttribute("userinfo",usermanager.getUser(user_id.toString()));
			}
		}

		return "/jsp/user/userinfo";
	}
	
	//保存编辑用户信息
	@RequestMapping(value="/save_userinfo")
	public String saveUserInfo(UserBaseBean dao,Model model,HttpSession httpSession){
		boolean flag = usermanager.updateUser(dao);
		if(flag){
			return "redirect:/user/s_userinfo";
		}else{
			httpSession.setAttribute("errormsg", "保存失败！");
			return "redirect:/user/edit_userinfo";
		}
	}	
	//用户列表
	@RequestMapping(value="/deleteuser")
	public void deleteUserById(String userId,HttpServletResponse response){
		boolean flag =  usermanager.delUser(userId);
		PrintWriter out = null;
		response.setContentType("application/json");
		String result = "{\"flag\":\"1\"}";
		if(!flag)
			result="{\"flag\":\"0\"}";
		try{
			out = response.getWriter();
			out.write(result);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	//用户列表
	@RequestMapping(value="/userlist")
	public String userListShow(Model model){
		List userlist = usermanager.getUserList(null);
		model.addAttribute("userlist", userlist);
		return "/jsp/user/userlist";
	}
	
	//用户信息编辑页面
	@RequestMapping(value="/edit_userinfo")
	public String editUserInfo(Model model,HttpSession httpSession){
		Object user_id = httpSession.getAttribute("user_id");
		if(user_id==null){
			
		}else{
			//编辑用户信息保存出错的报错信息
			Object msg = httpSession.getAttribute("errormsg");
			if(msg!=null){
				model.addAttribute("editerrormsg", msg.toString());	
			}
			UserBaseBean userbean = this.usermanager.getUser(user_id.toString());
			model.addAttribute("userinfo", userbean);	
		}
		return "/jsp/user/edituserinfo";
	}
	//用户登录页面
	@RequestMapping(value="/login")
	public String loginView(){
		return "/jsp/user/userlogin";
	}
	//用户注册页面
	@RequestMapping(value="/s_userinfo")
	public String showUserInfoView(Model model,HttpSession httpSession){
		Object user_id = httpSession.getAttribute("user_id");
		if(user_id==null){
			
		}else{
			UserBaseBean userbean = this.usermanager.getUser(user_id.toString());
			model.addAttribute("userinfo", userbean);	
		}
		return "/jsp/user/userinfo";
	}
	
	//用户注册页面
	@RequestMapping(value="/register")
	public String registerView(){
		return "/jsp/user/userregister";
	}
	//用户选择图片页面
	@RequestMapping(value="/jumpuserpic")
	public String jumpToEidtUserPic(Model model,HttpSession httpSession){
		Object user_id = httpSession.getAttribute("user_id");
		if(user_id==null){
			
		}else{
			UserBaseBean userbean = usermanager.getUser(user_id.toString());
			model.addAttribute("userinfo", userbean);
		}
		return "/jsp/user/uploadusersculpture";
	}
	//登录成功
	@RequestMapping(value="/welcome")
	public String loginSuccess(){
		return "/jsp/user/welcomeuser";
	} 
	@RequestMapping(value="/testspring")
	public String testSpring(Model model){
		UserBaseBean user = new UserBaseBean();
		user.setUser_name("Spring");
		user.setUser_password("mvc");
		usermanager.addUser(user);
		model.addAttribute("username", user.getUser_name());
		model.addAttribute("userid", user.getUser_id());
		return "/jsp/user/welcomeuser";
	}
}
