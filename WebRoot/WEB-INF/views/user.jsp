<html>
<head>
    <title>Spring MVC Hello World</title>
</head>
 <script type="text/javascript" src="/plugins/jquery/jquery.js"></script> 
<script type="text/javascript">
	/* $.ajax({
		type:'get',
		url:'/user/getUser',
		success:function(data){
			//alert(JSON.stringify(data));
		}
	})  */
	
    $(document).ready(function(){  
        var data1={"userName":"test","address":"gz"};  
        $.ajax({ 
            type:"POST", 
            url:"/user/getLogInfo", 
            dataType:"json",      
            contentType:"application/json",               
            data:data1, 
            success:function(data){ 
                                       
            } 
         }); 
    });
	
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