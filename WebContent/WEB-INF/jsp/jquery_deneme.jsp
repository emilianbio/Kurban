<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQUERY Uygulaması</title>
<script
	src='<c:url value="/resources/js/ajax.js"></c:url>'></script>
</head>
<script type="text/javascript">
	$(document).ready(
			function() {
				alert("sdfsdf");
				//var jsonObj = jQuery.parseJSON('${list}');
				// jsonObj variable now contains the data structure and can
				// be accessed as jsonObj.name and jsonObj.country.
				//console.log(jsonObj);
				$.ajax({
					url : './list.json',
					type : 'get',
					contentType : "application/json",
					dataType : 'json',
					success : function(data) {

						console.log(data);
						$.each(data, function(v,f) {
							var tblRow = "<tr>" + "<td>" + f.kupeNo + "</td>"
									+ "<td>" + f.hayvanNo + "</td>" + "<td>"
									+ f.agirlik + "</td>" + "<td>"
									+ f.alisFiyati + "</td>" + "<td>"
									+ f.satisFiyati + "</td>" + "<td>"
									+ f.kesimUcreti + "</td>" + "</tr>";
							$(tblRow).appendTo("#userdata tbody");

						});

					}
				});
				$('#getdatasatir').hide();
			});
</script>
</head>
<body>
	<table id="userdata" border="2">
		<tr id="getdatasatir">
			<th colspan="6"><input type="button" id="getData"
				value="Get Data" style="width: 100%;" /></th>
		</tr>
		<tr>
			<td>Küpe No</td>
			<td>Hayvan No</td>
			<td>Ağırlık</td>
			<td>Alış Fiyatı</td>
			<td>Satış Fiyatı</td>
			<td>Kesim Ücreti</td>
		</tr>
		<tbody>
		</tbody>
	</table>
</body>
</html>