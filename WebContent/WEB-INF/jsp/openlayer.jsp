<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu4zw676ueJ7UbHjlrRnXhsqRZ9ZEl02I&libraries=geometry&callback=initMap"
	defer></script>
<script src='<c:url value="/resources/js/jquery-3.1.1.min.js" ></c:url>'></script>
<title>Insert title here</title>

<script type="text/javascript">
	function initMap() {
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 14,
			center : {
				lat : 34.366,
				lng : -89.519
			}
		});
	};
</script>
<script type="text/javascript">
	function basla() {
		$.ajax({
			url : './json',
			success : function(data) {

				$('#sonuc').html(data);// replace
			}
		});
	};

	function basla2() {
		$.ajax({
			url : './json1',
			dataType : 'json',
			success : function(data, x) {
				var sonuc = "";
				console.log(data);
				for (var i = 0; i < data.liste.length; i++) {

					sonuc += data.liste[i].agirlik + "<br> ";
					alert(sonuc);
				}

				$('#sonuc2').html(sonuc);// replace
			}
		});
	};

	$(document).ready(function() {
		setInterval(function() {
			basla();
			
		}, 1000);
	})
</script>
</head>
<body>
	<div id="map"></div>

	<div id="sonuc"></div>
	<div id="sonuc2"></div>
</body>
</html>