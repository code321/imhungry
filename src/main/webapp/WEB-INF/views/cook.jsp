<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>I'm hungry</title>
</head>
<body>
<div class="container"> 
<div class="page-header">
<h1>
    Add a cook
</h1>
</div>
 
<c:url var="addAction" value="/cook/add" ></c:url>

<form:form action="${addAction}" commandName="cook" class="form">
    <c:if test="${!empty cook.name}">
    <div class="form-group" >        
           <div class="col-md-9">
           
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
           
                    
            <form:input class="form-control" path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />  
            </div>       
    </div>
    </c:if>
    
    <div class="form-group">           
            <div class="col-md-9">
        
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        
            <form:input class="form-control" path="name" />
            
            </div>
    </div>
    <div class="form-group">
       
       <div class="col-md-9">
       
            <form:label path="email">
                <spring:message text="Email"/>
            </form:label>
       
            <form:input class="form-control" path="email" />
        </div>
    </div>  
    
    <div class="row"> 
     <div class="col-md-9">
     &nbsp;
     </div>
    </div>
    
     <div class="form-group"> 
   
      <div class="col-md-9">
      
            <c:if test="${!empty cook.name}">
                <button type="submit" class="btn btn-primary"><spring:message text="Edit cook"/></button>                    
            </c:if>
            
            <c:if test="${empty cook.name}">
                <button type="submit" class="btn btn-primary"><spring:message text="Add cook"/></button>               
            </c:if>
        </div>
        
     </div>
 
</form:form>
</div>
</body>
</html>