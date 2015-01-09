 <%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<html>
	<head><title>cas test</title></head>
	<body>


<%
AttributePrincipal attribute = (AttributePrincipal) request.getUserPrincipal();


%>
<%-- <% if(null!=username){ %>
	<h2>Hello <%=username %> !</h2>
	<a href="http://www.cas.com/cas/logout">logout</a>
<% }%>
 --%>
	 
	</body>
</html>
