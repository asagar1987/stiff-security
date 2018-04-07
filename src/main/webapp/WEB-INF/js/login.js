jQuery(document).ready(function ($) {
	$('#loginform').submit(function (event) {
		event.preventDefault();

		//showMeYourCookies('At loginform submission');

		//var cookie = JSON.parse($.cookie('helloween'));
		var data = 'j_username=' + $('#username').val() + '&j_password=' + $('#password').val();
		$.ajax({
			data: data,
			//headers: {'X-CSRF-TOKEN': cookie.csrf},
			timeout: 1000,
			type: 'POST',
			url: '/stiff/users/login'

		}).done(function(data, textStatus, jqXHR) {
			//showMeYourJqXHR('When loginform is done', jqXHR);
			//showMeYourCookies('When loginform is done');
			console.log(data);
			window.location = '/user/dashboard';

		}).fail(function(jqXHR, textStatus, errorThrown) {
			//showMeYourJqXHR('When loginform fails', jqXHR);
			//showMeYourCookies('When loginform fails');
			alert('1');
			console.error('Booh! Wrong credentials, try again!');
		});
	});
});
