<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" description="the select name" required="true"%>
<%@ attribute name="label" description="the select label"%>
<%@ attribute name="value" description="the initialy selected value"%>

<label>${label} : <input name="${name}" value="${value}"></label><br>