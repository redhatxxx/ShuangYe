<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	@import url("<c:url value="/css/SimpleTree.css"/>");
	</style>
	<script type="text/javascript" src="<c:url value="../js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/useroperation.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/cookieoperation.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/SimpleTree.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/wangEditor.min.js"/>"></script>
	<script type="text/javascript">
		window.onload = function(){
			alrt(1);
			var flag = "${sessionScope.flag }";
			if(flag!="1"){
				var cookievalue = getCookie("fun_u_uuid");
				if(cookievalue!=null)
					loginwithcookie(cookievalue);
			}else{
				addcookie("fun_u_uuid","${sessionScope.user_id }",0);
			}
		}
		$(function(){
			$(".st_tree").SimpleTree({
				/* 可无视代码部分*/
				click:function(a){
					if($(a).attr("hasChild")){
						//alert($(a).attr("ref"));
						var tagref = $(a).attr("ref");
						if(tagref=="record"){
							loadrecord($(a).attr("id"));
						}
						if(tagref=="note"){
							setlocatenote($(a).attr("id"));
						}
						if(tagref=="title"){
							setlocatetitle($(a).attr("id"));
						}
					}
				}
			});
		});
	</script>
</head>
<body>
	<div align="right">
		<c:if test="${sessionScope.flag!=1 }">
			<a id="usertitle" href="javascript:void(0)" onclick="jumptouserinfo()">游客</a> 
			<a id="jumplogin" href="javascript:void(0)" onclick="jumptologin()">登录</a> 
			<a id="jumpregiste" href="javascript:void(0)" onclick="jumptoregister()">注册</a> 
		</c:if>
		<c:if test="${sessionScope.flag==1 }">
			<a id="usertitle" href="javascript:void(0)" onclick="jumptouserinfo()">${sessionScope.showname }</a> 
			<a id="logout" href="javascript:void(0)" onclick="userlogout()">注销</a> 
			<c:if test="${sessionScope.managerflag==1 }">
				<a id="manager"	href="javascript:void(0)" onclick="jumpmanager()">管理员入口</a>
			</c:if>
		</c:if>
		
	</div>
	<br>
	<f:view>
		<div class="st_tree" style="width:400px;margin:0 left;">
			<ul>
				<c:forEach items="${notelist }" var="note">
					<li><a href="#" ref="note" id = ${note.note_id }>${note.note_name }</a></li>
						<ul>
							<c:forEach items="${note.titlelist }" var="title">
								<li><a href="#" ref="title" id =${title.title_id }>${title.title_name }</a></li>
									<ul>
										<c:forEach items="${title.recordlist }" var="record">
											<li><a href="#" ref="record" id=${record.record_id }>${record.record_name }</a></li>
										</c:forEach>
									</ul>
							</c:forEach>
						</ul>
				</c:forEach>
			</ul>
		</div>
		<div>
			<label>当前位置:</label>
			<a href="#" id="locatenote"> </a>			
			<label style="visibility:hidden" id="totitle">>>></label><a href="#" id="locatetitle"> </a>
			<label style="visibility:hidden" id="torecord">>>></label><a href="#" id = "locaterecord"> </a>
		</div>
		<div>
		    <div id="editor">
		        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
		    </div>
		    <script type="text/javascript">
		        var E = window.wangEditor
		        var editor = new E('#editor')
		        // 或者 var editor = new E( document.getElementById('editor') )
		        editor.create()
		        function geteditorinfo(){
		        	return editor.txt.html();
		        }
		        
		        function seteditorinfo(info){
		        	editor.txt.html(info);
		        }
		    </script>
		</div>
	</f:view>
</body>
</html>