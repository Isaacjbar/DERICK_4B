<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vista de tareas</title>
</head>
<body>
<ul class="nav nav-tabs mb-4" role="tablist">
    <li class="nav-item">
        <a class="nav-link active"  data-toggle="tab" href="#tareas_pendientes" role="tab">Tareas pendientes</a>
    </li>
</ul>

<div class="tab-content">
    <div class="tab-pane show active" id="tareas_pendientes" role="tabpanel">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="list-group" id="pendientes">

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
