<%@tag import="javax.servlet.jsp.tagext.JspTag"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" description="the field name"%>

<%@ taglib uri="http://taglib.beeerp.jc.net/1_0" prefix="beeerp" %>
<% 
// findAncestorWithClass(from, klass)
// JspTag parent = getParent();
// parent.

%>
<beeerp:input label="${field}" name="${field}" value="${formEntity.fields.getDataString(field)}"/>
