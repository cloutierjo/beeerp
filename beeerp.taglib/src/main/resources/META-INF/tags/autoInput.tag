<%@tag import="javax.servlet.jsp.tagext.JspTag"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" description="the field name"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://taglib.beeerp.jc.net/1_0" prefix="beeerp" %>
<% 
// findAncestorWithClass(from, klass)
// JspTag parent = getParent();
// parent.

%>
<c:if test="${empty formEntity.errors[field]}">
	<beeerp:input	label="${field}" 
					name="${field}" 
					value="${formEntity.fields.getDataString(field)}" />
</c:if>
<c:if test="${not empty formEntity.errors[field]}">
	<beeerp:input	label="${field}" 
					name="${field}" 
					value="${formEntity.errors[field].invalidValue}" 
					error="${formEntity.errors[field].message}"/>
</c:if>