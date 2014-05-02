<%@ page import="org.codetrials.shared.LayoutConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CodeTrials</title>

    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="css/main.css" rel="stylesheet"/>

    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script>
        window.trials = [
            { title: "Java", description: "Simple Java trial" },
            { title: "Python 3", description: "Simple Py3 trial" },
            { title: "JavaScript", description: "Simple JS trial" }
        ];
    </script>

    <script src="codetrials/codetrials.nocache.js"></script>
</head>
<body>
    <div class="container" id="<%=LayoutConstants.CONTAINER_ID%>">
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src='https://raw.githubusercontent.com/chrisdone/jquery-console/master/jquery.console.js'></script>
</body>
</html>
