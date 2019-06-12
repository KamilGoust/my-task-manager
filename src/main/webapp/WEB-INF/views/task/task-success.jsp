<jsp:include page="../header.jsp"/>

<h1>Task added</h1>
<table border="0">
    <tr>
        <td>User:</td>
        <td></td>
    </tr>
    <tr>
        <td>Task name:</td>
        <td>${task.name}</td>
    </tr>
    <tr>
        <td>Date:</td>
        <td>${task.endDate}</td>
    </tr>
    <tr>
        <td>Priority:</td>
        <td></td>
    </tr>
</table>

<table border="0">
    <tr>
        <td>
            <a href="add">Add next task</a>
        </td>
    </tr>

    <tr>
        <td>
            <a href="show">Show tasks</a>
        </td>
    </tr>
</table>

<jsp:include page="../footer.jsp"/>