<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Welcome ATM Simulator</h1>
    <p>Please select available atm machines.</p>
</div>

<div class="container" style="margin-top:30px">
    <div class="row">
        <#list atms as atm>
        <div class="col-sm-3">
            <button type="button" class="btn btn-primary btn-block" onclick="location.href='/atm/${atm.id}/view'">${atm.id}</button>
            <br>
        </div>
        <#else>
        <div class="col-sm-3">
            NOT FOUND ANY MACHINES. PLEASE INSERT ATM_DETAIL FIRST.
            <br>
        </div>
        </#list>
    </div>
</div>

</body>
</html>
