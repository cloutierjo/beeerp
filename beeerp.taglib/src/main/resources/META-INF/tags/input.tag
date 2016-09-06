<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" description="the select name"%>
<%@ attribute name="label" description="the select label"%>
<%@ attribute name="value" description="the initial value"%>
<%@ attribute name="error" description="the error to display"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<label>${label} : <input name="${name}" value="${value}">

<c:if test="${not empty error}">
	<strong class="error">${error}</strong>
</c:if>
</label><br>