<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/plugins/jquery/jquery.js"></script> 

<html>
<head>
    <title>Spring MVC Hello World</title>
</head>
 
<script type="text/javascript">
	$.ajax({
		type:'get',
		url:'/user/getUser',
		success:function(data){
			//alert(JSON.stringify(data));
		}
	})
</script> 
 
<body>
    <h2>All users in System</h2>
 
    <table border="1">
        <tr>
            <th>user Id</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach items="${Users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
 
</body>
</html>