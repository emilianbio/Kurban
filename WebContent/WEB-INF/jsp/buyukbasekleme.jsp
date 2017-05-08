<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src='<c:url value="/resources/js/ajax.js" ></c:url>'></script>
<title>BÜYÜKBAŞ</title>
</head>
<c:if test="${error==1}">
	<script type="text/javascript">
		alert("Hissedar Sayısı 7'ye Ulaşmış Durumda...");

		function buyukEkle() {
			buyukbas.submit();
		};
	</script>
</c:if>
<script type="text/javascript">
	$('#userdata').hide();
	$(document)
			.ready(
					$('#goster')
							.click(
									$(document)
											.ready(
													function() {
														setInterval(
																function() {
																	$
																			.ajax({
																				url : './list.json',
																				type : 'get',
																				contentType : "application/json",
																				dataType : 'json',
																				success : function(
																						data,
																						f) {
																					console
																							.log(data.length);
																					$(
																							'#userdata')
																							.empty();
																					for (var i = 0; i < data.length; i++) {
																						console
																								.log(data[i].kupeNo);
																						var tblRow = "<tr>"
																								+ "<td>"
																								+ data[i].kupeNo
																								+ "</td>"
																								+ "<td>"
																								+ data[i].hayvanNo
																								+ "</td>"
																								+ "<td>"
																								+ data[i].agirlik
																								+ "</td>"
																								+ "<td>"
																								+ data[i].alisFiyati
																								+ "</td>"
																								+ "<td>"
																								+ data[i].satisFiyati
																								+ "</td>"
																								+ "<td>"
																								+ data[i].kesimUcreti
																								+ "</td>"
																								+ "</tr>";
																						$(
																								tblRow)
																								.appendTo(
																										"#userdata ");
																					}
																					;
																					$(
																							'#userdata')
																							.show(
																									"fade",
																									function() {
																										$(
																												'#goster')
																												.hide(
																														"slow");
																									});
																				}
																			});
																}, 1000);
													})));

	$(document).ready(function() {
		setInterval(function() {

		}, 1000);
	})
</script>

<body background="./resources/resimler/simental2.jpg"
	style="background-size: contain; background-position: top center; background-repeat: no-repeat; background-attachment: fixed;">
	<%-- <img alt="" src="<c:url value="/resources/resimler/buyukbas.jpg" />  "
		width="800px" /> --%>
	<%-- <table align="right">
		<tr>
			<td><a href="./girisedon">GİRİŞ</a></td>
			<td><a href="./kucukbasadon">KÜÇÜKBAŞ</a></td>
		</tr>
	</table>

	<form:form method="post" action="/" commandName="buyukbas" id="myForm">
		<form:hidden path="id" />
		<table>
			<tr>
				<th colspan="2">BÜYÜKBAŞ KAYIT GİRİŞ</th>
			</tr>
			<tr>
				<td>Kulak Küpe No</td>
				<td><form:input path="kupeNo" reqired="true" id="kupeno" /></td>
			</tr>
			<tr>
				<td>Hayvan No</td>
				<td><form:input path="hayvanNo" required="true" id="hayvanno" /></td>
			</tr>
			<tr>
				<td>Ağırlık</td>
				<td><form:input path="agirlik" required="true" id="agirlik" /></td>
			</tr>
			<tr>
				<td>Alış Fiyatı</td>
				<td><form:input path="alisFiyati" required="true"
						id="alisfiyati" /></td>
			</tr>
			<tr>
				<td>Satış Fiyatı</td>
				<td><form:input path="satisFiyati" required="true"
						id="satisfiyati" /></td>
			</tr>
			<tr>
				<td>Kesim Fiyatı</td>
				<td><form:input path="kesimUcreti" value="0" required="true"
						id="kesimfiyati" /></td>
			</tr>
			<tr>
				<td colspan=2 align="right"><input type="button"
					onclick="buyukEkle();ekleBuyuk();" value="EKLE"></td>
				<!--  -->
			</tr>
		</table>
	</form:form> --%>
	<%-- <form action="./hissedarArama" method="post">
		<table>
			<tr>
				<td>Hissedar İsmi:</td>
				<td><input type="text" name="isim" onkeyup="kCap(this);"></td>
				<td><input type="submit" value="OK" tabindex="0" /></td>
			</tr>
		</table>
	</form> --%>

	<%-- <table border="5" cellpadding="3" cellspacing="0" id="buyukbasListesi">
		<tr>
			<td>Sıra</td>
			<td>Küpe No</td>
			<td>Hayvan No</td>
			<td>Ağırlık</td>
			<td>Alış Fiyatı</td>
			<td>Satış Fiyatı</td>
			<td>Kesim Ucreti</td>
		</tr>
		<tbody>

		</tbody>
		<c:forEach items="${list}" var="buyukbas" varStatus="sira">
			<tr id="satirno${buyukbas.id}">
				<td class="td">${sira.count}</td>
				<td class="td">${buyukbas.kupeNo}</td>
				<td class="td" align="center"><a
					href="./hissedarGetir/${buyukbas.id}">${buyukbas.hayvanNo}</a></td>
				<td class="td">${buyukbas.agirlik}</td>
				<td class="td">${buyukbas.alisFiyati}</td>
				<td class="td">${buyukbas.satisFiyati}</td>
				<td class="td">${buyukbas.kesimUcreti}</td>
			</tr>

		</c:forEach>

	</table>
 --%>
	<a href="#" id="goster">GÖSTER</a>
	<table id="userdata" border="1" width="50%">

		<tr>
			<td>Küpe No</td>
			<td>Hayvan No</td>
			<td>Ağırlık</td>
			<td>Alış Fiyatı</td>
			<td>Satış Fiyatı</td>
			<td>Kesim Ücreti</td>
		</tr>

	</table>
</body>
</html>