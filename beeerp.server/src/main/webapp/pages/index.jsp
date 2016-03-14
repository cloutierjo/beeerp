<%@ taglib uri="http://taglib.beeerp.jc.net/1_0" prefix="beeerp" %>

<html>
	<body>
	<a href="/beeerp.server/timesheet/weekly_time/get/1">get</a>
	<a href="/beeerp.server/timesheet/weekly_time/update/1">update</a>
	<a href="/beeerp.server/timesheet/weekly_time/add">add</a>
	<a href="/beeerp.server/timesheet/weekly_time/delete/1">delete</a>
		<beeerp:form>
			<beeerp:input name="date" value="${value.date}" label="date"></beeerp:input>
			<beeerp:input name="time" value="${value.time}" label="time"></beeerp:input>
			<input type="submit">
		</beeerp:form>
	</body>
</html>