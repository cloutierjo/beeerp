<%@ taglib uri="http://taglib.beeerp.jc.net/1_0" prefix="beeerp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
	<a href="/beeerp.server/timesheet/wage_states/get/1">get</a>
	<a href="/beeerp.server/timesheet/wage_states/update/1">update</a>
	<a href="/beeerp.server/timesheet/wage_states/add">add</a>
	<a href="/beeerp.server/timesheet/wage_states/delete/1">delete</a>
		<beeerp:form entity="${value}">
			<beeerp:autoInput field="weeklyWage" />
			<beeerp:autoInput field="hollidayRate" />
			<beeerp:autoInput field="normalWeekTime" />
		</beeerp:form>
	<div id="footer"></div>
	</body>
</html>