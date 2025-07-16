<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <%@ include file="../parts/header_css.html" %>
</head>
<body>
<c:import url="tab.jsp"/>
<c:import url="message.jsp"/>
<form:form modelAttribute="registrationForm" id="regform" method="post">
    <div id="content">
        <fieldset>
            <legend>Personal Information</legend>
            <label for="title">Title</label>
            <form:select path="title" id="title">
                <form:option value="" label=""/>
                <form:option value="Dr" label="Dr"/>
                <form:option value="Miss" label="Miss"/>
                <form:option value="Mr" label="Mr"/>
                <form:option value="Mrs" label="Mrs"/>
                <form:option value="Prof" label="Prof"/>
            </form:select>
            <form:errors path="title" cssClass="fieldError"/>
            <label for="firstName">First Name <span class="required">*</span></label>
            <form:input id="firstName" path="firstName"/>
            <form:errors path="firstName" cssClass="fieldError"/>
            <label for="lastName">Last Name <span class="required">*</span></label>
            <form:input id="lastName" path="lastName"/>
            <form:errors path="lastName" cssClass="fieldError"/>
            <label for="dateOfBirth">Date of Birth (yyyy-mm-dd) <span class="required">*</span></label>
            <form:input id="dateOfBirth" path="dateOfBirth"/>
            <form:errors path="dateOfBirth" cssClass="fieldError"/>
            <label for="maritalStatus">Marital Status</label>
            <form:select path="maritalStatus" id="maritalStatus">
                <form:option value="OTHER" label=""/>
                <form:option value="MARRIED" label="Married"/>
                <form:option value="NOT_MARRIED" label="Not married"/>
                <form:option value="OTHER" label="Other"/>
            </form:select>
            <label for="numberOfChildren">Number of Children</label>
            <form:select path="numberOfChildren" id="numberOfChildren">
                <c:forEach begin="0" end="10" var="num">
                    <form:option value="${num}" label="${num}"/>
                </c:forEach>
            </form:select>
            <label for="occupation">Occupation <span class="required">*</span></label>
            <form:input id="occupation" path="occupation"/>
            <form:errors path="occupation" cssClass="fieldError"/>
            <label for="income">Annual Income ($)<span class="required">*</span></label>
            <form:input id="income" path="income"/>
            <form:errors path="income" cssClass="fieldError"/>
            <label for="lengthOfService">Length of Service (years)<span class="required">*</span></label>
            <form:select id="lengthOfService" path="lengthOfService">
                <form:option value="" label="Please select"/>
                <form:option value="0" label="Less than 1 year"/>
                <c:forEach begin="1" end="15" var="term">
                    <form:option value="${term}" label="${term}"/>
                </c:forEach>
                <form:option value="16" label="More than 15 years"/>
            </form:select>
            <form:errors path="lengthOfService" cssClass="fieldError"/>
        </fieldset>
        <fieldset>
            <legend>Contact Information</legend>
            <label for="street">Street and house number<span class="required">*</span></label>
            <form:input id="street" path="street"/>
            <form:errors path="street" cssClass="fieldError"/>
            <label for="city">City <span class="required">*</span></label>
            <form:input id="city" path="city"/>
            <form:errors path="city" cssClass="fieldError"/>
            <label for="state">State/Province/Region</label>
            <form:input id="state" path="state"/>
            <label for="zipcode">Postal / Zip Code <span class="required">*</span></label>
            <form:input id="zipcode" path="zipcode"/>
            <form:errors path="zipcode" cssClass="fieldError"/>
            <label for="country">Country <span class="required">*</span></label>
            <form:input id="country" path="country"/>
            <form:errors path="country" cssClass="fieldError"/>
            <label for="phone">Phone (inc. country code) <span class="required">*</span></label>
            <form:input path="phone" id="phone"/>
            <form:errors path="phone" cssClass="fieldError"/>
            <label for="mobilePhone">Mobile Phone (inc. country code)</label>
            <form:input path="mobilePhone" id="mobilePhone"/>
            <form:errors path="mobilePhone" cssClass="fieldError"/>
            <label for="email">Email <span class="required">*</span></label>
            <form:input path="email" id="email"/>
            <form:errors path="email" cssClass="fieldError"/>
        </fieldset>
        <fieldset>
            <legend>Set PIN</legend>
            <label for="newPin">PIN <span class="required">*</span></label>
            <form:password id="newPin" path="newPin"/>
            <label for="newPinAgain">PIN again <span class="required">*</span></label>
            <form:password id="newPinAgain" path="newPinAgain"/>
            <form:errors path="newPin" cssClass="fieldError"/>
        </fieldset>
        <fieldset>
            <div id="divsubmit">
                <div class="buttons">
                    <a onclick="$('#regform').submit();"><img src="images/tick.png" alt=""/>Register</a>
                    <a class="negative" onclick="$('#regform')[0].reset();"><img src="images/reset.png" alt=""/>Reset</a>
                </div>
            </div>
            <div id="disclaimer">By clicking the &#8220;Register&#8221; button, I agree to the WestBank's Terms of Services Agreement.</div>
        </fieldset>
    </div>
</form:form>
<%@ include file="../parts/footer_scripts.html" %>
<c:import url="doc-ready.jsp"/>
<script type="text/javascript">
    $(function () {
        $("#dateOfBirth").datepicker({
            yearRange: "-86:-16",
            changeMonth: true,
            changeYear: true,
            dateFormat: 'yy-mm-dd',
            showOn: 'both',
            buttonImage: 'images/calendar.gif',
            buttonImageOnly: true
        });
    });
</script>
</body>
</html> 