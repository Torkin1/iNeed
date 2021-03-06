<%@ include file="components/TitleSetter.jsp"%>
<%@ include file="components/AuthChecker.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="logic.beans.ViewAdBean"
	import="java.text.DateFormat"%>

<!DOCTYPE html>
<html>
<head>

<title><%=String.format("%s#%d by %s", ((ViewAdBean) request.getAttribute("viewAdBean")).getType(),
					((ViewAdBean) request.getAttribute("viewAdBean")).getId(),
					((ViewAdBean) request.getAttribute("viewAdBean")).getAuthor())%></title>
</head>
<body>
	<div>
		<jsp:include page="/components/ToolBar.jsp"></jsp:include>
	</div>
	<div class="container bg-light border border-info">
		<div>
			<span id="titleText"> <%=((ViewAdBean) request.getAttribute("viewAdBean")).getTitle()%>
			</span>
		</div>
		<div>
			<span id="bodyText"> <%=((ViewAdBean) request.getAttribute("viewAdBean")).getBody()%>
			</span>
		</div>
		<div class="row">

			<div class=col-sm>
				<div class="row">
					<div class="col-sm-2">
						<span> Ad by: </span>
					</div>
					<div class="col-sm-2">
						<span> <%=((ViewAdBean) request.getAttribute("viewAdBean")).getAuthor()%>
						</span>
					</div>
				</div>
			</div>

			<div class="col-sm">
				<span> Posted in <%=DateFormat.getDateInstance()
					.format(((ViewAdBean) request.getAttribute("viewAdBean")).getDateOfPublication().getTime())%>
				</span>

			</div>

		</div>
		<div id="actionOnAdArea">
			<%
				if (session.getAttribute("username").toString()
						.compareTo(((ViewAdBean) request.getAttribute("viewAdBean")).getAuthor()) == 0) {
			%>
			<a
				href="CheckAnswers.jsp?adType=<%=((ViewAdBean) request.getAttribute("viewAdBean")).getType()%>&adId=<%=((ViewAdBean) request.getAttribute("viewAdBean")).getId()%>">
				<button class="btn-primary" name="bCheckAnswers">Check
					Answers</button>
			</a>
			<%
				} else {
			%>
			<a
				href="AnswerAnAd.jsp?adType=<%=((ViewAdBean) request.getAttribute("viewAdBean")).getType()%>&adId=<%=((ViewAdBean) request.getAttribute("viewAdBean")).getId()%>&answererUsername=<%=session.getAttribute("username").toString()%>">
				<button class="btn-primary" name="bAnswerAd">Answer</button>
			</a>
			<%
				}
			%>
		</div>
		<div class="row">
			<div class="col-sm-5"></div>
			<div class="col-sm-2">
				<img alt="red-logomark" src="image/Red-Logomark.png" heigth="100"
					width="100">
			</div>

			<div class="col-sm-5"></div>

		</div>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
