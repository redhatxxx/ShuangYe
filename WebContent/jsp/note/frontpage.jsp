<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	@import url("<c:url value="/css/treemenu.css"/>");
	</style>
	<script type="text/javascript" src="<c:url value="../js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/cookieoperation.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/treeoperation.js"/>"></script>
</head>
<body>
	<f:view>
		<div class="content">
			<c:forEach items="${notelist }" var="note">
				<div class="open" id="s${note.note_id }" onClick="two(${note.note_id})"
						style="background: url(../images/closed.gif) no-repeat">
						<a target="FrameRight" href="#">${note.note_name }</a>
				</div>	
					<c:forEach items="${note.titlelist }" var="title">
						<div class="ps" id="${note.note_id}" style="display: block">
							<div id="s${title.title_id }" class="open" onClick="three(${title.title_id})"
								style="background: url(../images/open.gif) no-repeat">
								<a target="FrameRight" href="#">${title.title_name }</a>
								<c:forEach items="${title.recordlist }" var="record">
									<div class="ps" id="${title.title_id}">
										<div class="dot">
											<a target="FrameRight" href="#"> ${record.record_name }</a>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
			</c:forEach>
		</div>
	</f:view>
</body>
</html>