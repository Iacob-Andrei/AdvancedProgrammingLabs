<html>
<head>
    <title>Report</title>
</head>

<style>
    table, th, td{
        border: 3px solid black;
    }
</style>

<body>

    <h1>HTML Report for '${catalog_name}'</h1>
    <h2>Reference for catalog is:</h2>

    <table>
        <tr>
            <th>Title</th>
            <th>ID</th>
            <th>Location</th>
        </tr>
        <#list catalog as item>
            <tr>
                <td>${item.title}</td>
                <td>${item.id}</td>
                <td>${item.location}</td>
            </tr>
        </#list>
    </table>

</body>

</html>