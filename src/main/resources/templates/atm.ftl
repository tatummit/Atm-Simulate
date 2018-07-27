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
    <style>

    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Welcome ATM #${atm.id}</h1>
    <p>Please select available command.</p>
</div>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-12">
            <button type="button" class="btn btn-primary btn-block"
                    onclick="location.href='/atm/${atm.id}/withdraw'" >Withdraw</button>
            <br>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <button type="button" class="btn btn-primary btn-block"
                    onclick="location.href='/atm/${atm.id}/config'">Config</button>
            <br>
        </div>
    </div>
</div>

</body>
</html>
