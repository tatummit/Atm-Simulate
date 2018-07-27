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
        div.card-body > span {
            font-weight: bold;

        }
    </style>
</head>
<body>
<input id="atm_id" type="hidden" value="${atm.id}" />

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Welcome ATM #${atm.id}</h1>
    <p>available amount <a id="t_amount">${amount}</a> ฿.</p>
</div>

<div class="container" style="margin-top:30px">
    <div id="inputbox" class="row">
            <div class="col-sm-12">
                <input id="withdraw_text" type="number" min="0" value="0" class="form-control" />
                <br>
                <span id="withdraw_text_err" class="text-danger"></span>
            </div>

            <div class="col-sm-12">
                <button id="withdraw_action" type="button" class="btn btn-primary btn-block">Submit</button>
                <br>
            </div>

            <div class="col-sm-12">
                <button id="back_action" type="button" class="btn btn-primary btn-block" onclick="location.href='/atm/${atm.id}/view'">Back</button>
                <br>
            </div>
    </div>
    <div id="confirm" class="row" style="display:none">

        <div class="col-sm-12">
            <div class="card">
                <div class="card-body bg-info">Do you want to withdraw: XXXXXX ฿ ?</div>
            </div>
            <br>
        </div>

        <div class="col-sm-12">
            <button id="confirm_action" type="button" class="btn btn-primary btn-block">Confirm</button>
            <br>
        </div>

        <div class="col-sm-12">
            <button id="cancel_action" type="button" class="btn btn-primary btn-block">Back</button>
            <br>
        </div>
    </div>

    <div id="response" class="row" style="display:none">

        <div class="col-sm-12">
            <div class="card response">
                Hello
            </div>
            <br>
        </div>

        <div class="col-sm-12">
            <button id="ok_action" type="button" class="btn btn-primary btn-block">Back</button>
            <br>
        </div>
    </div>
</div>
</body>
<script src="/js/withdraw.js"></script>
</html>
