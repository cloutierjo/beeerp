<html>
	<body>
	<a href="/beeerp.server/timesheet/weekly_time/get/1">get</a>
	<a href="/beeerp.server/timesheet/weekly_time/update/1">update</a>
	<a href="/beeerp.server/timesheet/weekly_time/add">add</a>
	<a href="/beeerp.server/timesheet/weekly_time/delete/1">delete</a>
		<form method="post">
			<label>date : <input name="date" value="${value.date}"></label><br>
			<label>time : <input name="time" value="${value.time}"></label><br>
			<input type="submit">
		</form>
	</body>
</html>