<%@ taglib uri="http://taglib.beeerp.jc.net/1_0" prefix="beeerp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
	<a href="/beeerp.server/timesheet/weekly_time/get/1">get</a>
	<a href="/beeerp.server/timesheet/weekly_time/update/1">update</a>
	<a href="/beeerp.server/timesheet/weekly_time/add">add</a>
	<a href="/beeerp.server/timesheet/weekly_time/delete/1">delete</a>
		<beeerp:form entity="${value}">
			<beeerp:autoInput field="date" />
			<beeerp:autoInput field="time" />
			<beeerp:autoInput field="sickTime" />
		</beeerp:form>
	<div id="footer"></div>
	</body>
</html>