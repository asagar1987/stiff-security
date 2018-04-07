<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Level Up Lunch - Contact Listing</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"></head>
<body>

    <h2>Contact Listing</h2>

    <table class="data-contacts-js table table-striped" >
        <tr>
            <th>Name</th>
            <th>Telephone</th>
            <th>Email</th>
        </th>
    </table>

    <button id="fetchContacts" class="btn btn-default" type="submit">Button</button>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript">

        $("#fetchContacts").bind("click", function() {
		
		
			$.ajax({
  url : "http://localhost:8080/user/locations",
    dataType : "json",
    headers: { "Content-Type":"application/json","Accept": "application/json","Access-Control-Allow-Origin":"*" },
	data: '',
    type : 'GET',
    contentType: "application/json",
    
    success : function (data) {
      console.log(data);
      $.each(data, function(i, contact) {

          $(".data-contacts-js").append(
              "<tr><td>" + contact.name + "</td>" +
              "<td>" + contact.city + "</td>" +
              "<td>" + contact.address + "</td></tr>");
      });
    },
    error : function (data, errorThrown) {
      alert(3);
    }
});

            /*$.get("http://localhost:8080/user/locations", function(data) {

                $.each(data, function(i, contact) {

                    $(".data-contacts-js").append(
                        "<tr><td>" + contact.name + "</td>" +
                        "<td>" + contact.city + "</td>" +
                        "<td>" + contact.address + "</td></tr>");
                });

            });*/
        });
    </script>
</body>
</html>