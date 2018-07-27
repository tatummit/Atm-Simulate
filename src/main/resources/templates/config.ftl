<#import "/spring.ftl" as spring />
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
    <p>Please insert configuration parameter.</p>
</div>

<div class="container" style="margin-top:30px">
    <form method="post" action="/atm/${atm.id}/config" onsubmit="return validateForm()">
    <div class="row">
        <div class="col-sm-12">
            <label>NumberOf20฿</label>
            <@spring.formInput "atm.numOfBath20" "class='form-control'"/>
            <span id="num20" class="text-danger"></span>
            <br>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <label>NumberOf50฿</label>
            <@spring.formInput "atm.numOfBath50" "class='form-control'"/>
            <span id="num50" class="text-danger" ></span>
            <br>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <input type="submit" class="btn btn-primary btn-block"/>
            <br>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <button type="button" class="btn btn-primary btn-block"
                    onclick="location.href='/atm/${atm.id}/view'">Back</button>
            <br>
        </div>
    </div>
    </form>
</div>

</body>
<script>
function validateForm() {
    var x = $('#numOfBath20').val();
    var y = $('#numOfBath50').val();
    var validate = true;
    if (x <= 0 ||  !$.isNumeric(x) ) {
        $('#num20').html('Invalid number, please insert number > 0');
        validate = false;
    } else {
        $('#num20').html('');
    }

    if (y <= 0 ||  !$.isNumeric(y) ) {
        $('#num50').html('Invalid number, please insert number > 0');
        validate = false;
    } else {
        $('#num50').html('');
    }

    return validate;
}
</script>
</html>
