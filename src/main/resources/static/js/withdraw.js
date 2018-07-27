$('#withdraw_action').click( () => {
  $('#inputbox').hide();
  var withdraw = $('#withdraw_text').val();
  if(!$.isNumeric(withdraw) || withdraw < 0) {
    $('#withdraw_text_err').html("invalid number, please insert number > 0.");
  } else {
    $('#withdraw_text_err').html("");
  }
  var msg = 'Do you want to withdraw: '+withdraw+' ฿ ?';
  $('.card-body.bg-info').html(msg);
  $('#confirm').show();
});

$('#cancel_action').click( () => {
  $('#inputbox').show();
  $('#confirm').hide();
})

$('#confirm_action').click( () => {
  var msg = 'Please wait ...';
  $('.card-body.bg-info').html(msg);
  $('#confirm_action').hide();
  $('#cancel_action').hide();
  $.ajax({
    type: "POST",
    url: "/api/v1/atm/" + $('#atm_id').val() + "/withdraw",
    data : JSON.stringify({amount : $('#withdraw_text').val()}),
    contentType: 'application/json'
  })
  .done( (data) => {
    displayResult(data);
  })
  .fail( (err) => {
    displayError(err.responseJSON);
  })
  .always( () => {
    $('#confirm_action').show()
    $('#cancel_action').show()
  });
})

$('#ok_action').click( () => {
  $('#response').hide();
  $('#inputbox').show();
})

function displayResult(data) {
    $('#confirm').hide();
    $('#response').show();
    var msg = '<div class="card-header bg-success">Success !!</div>';
    msg += '<div class="card-body">';
    msg += '<span>Withdraw Amount: </span>'+ data.withDrawAmount + "<br>";
    msg += '<span>Withdraw ฿20: </span>'+ data.withDrawBank20Bath + "<br>";
    msg += '<span>Withdraw ฿50: </span>'+ data.withDrawBank50Bath + "<br>";
    msg += '<span>Remain ฿20: </span>'+ data.remainBank20Bath + '<br>';
    msg += '<span>Remain ฿50: </span>'+ data.remainBank20Bath + '<br>';
    msg += '<span>Remain Amount: </span>'+ data.remainAmount + '<br>';
    msg += '</div>';
    $('.response').html(msg);
    $('#t_amount').html(data.remainAmount);
}

function displayError(data) {
    $('#confirm').hide();
    $('#response').show();
    var msg = '<div class="card-header bg-danger">Error !!</div>';
    msg += '<div class="card-body">'
    msg += '<span>Code: </span>'+ data.code + "<br>";
    msg += '<span>Message: </span>'+ data.message + "<br>";
    msg += '</div>';
    $('.response').html(msg);
}

