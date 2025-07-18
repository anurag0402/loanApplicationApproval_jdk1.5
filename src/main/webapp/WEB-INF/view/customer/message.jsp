<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${not empty processStatus}">  
  <div id="dialog" title="Status">
    <p>
      <c:choose>
         <c:when test='${processStatus == "OK"}'>
            <span 
              class="ui-icon ui-icon-circle-check" 
              style="float:left; margin:0 7px 50px 0">
            </span>
         </c:when>
         <c:when test='${processStatus == "ERROR"}'>
            <span 
              class="ui-icon ui-icon-circle-minus" 
              style="float:left; margin:0 7px 50px 0">
            </span>
         </c:when>
      </c:choose>          
      <b><spring:message code="${processStatusKey}" text="" /></b>
    </p>
  </div>
</c:if>

<c:if test="${not empty param.registered}">
    <div class="info">Registration successful! Please log in.</div>
</c:if>
