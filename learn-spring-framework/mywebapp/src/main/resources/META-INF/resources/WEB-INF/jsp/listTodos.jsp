<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link rel="stylesheet" th:href="@{/webjars/bootstrap/css/bootstrap.min.css}" />
		<title>List Todos Page</title>
	</head>
	<body>
		<div class="container">
			<h1>Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
		<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
	</body>
</html>