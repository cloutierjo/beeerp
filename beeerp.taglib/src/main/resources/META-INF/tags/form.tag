<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="entity" description="the model entity" type="net.jc.beeerp.module.Entity"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="formEntity" value="${entity}" scope="request"  />
<form method="post">
	<jsp:doBody />
	<input type="submit">
</form>
<c:set var="formEntity" value="" scope="request"  />