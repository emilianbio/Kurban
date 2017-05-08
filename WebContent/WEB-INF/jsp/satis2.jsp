<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SATIŞ</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<%-- <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/buyukbassatis.css" />" /> --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/genel.js" />"></script>
</head>
<c:if test="${error == '1' }">
	<script type="text/javascript">
		function c() {
			if (confirm("\n\nFarklı Bir Telefon Numarası Giriniz!!!!\n\n")) {
				return 0;
			} else
				return false;
		}
	</script>

</c:if>
<body onload="c()">
	<jsp:include page="/WEB-INF/jsp/ustbaslik.jsp" />
	<div id='uyari' class="uyari"
		style='z-index: 300000; display: none; padding: 5px; align: center; border-radius: 5px; text-align: center; position: fixed; top: 50%; box-sizing: border-box; left: 50%; width: auto; height: auto; background-color: white; border: 2px solid #2DAAE4; -webkit-transform: translate(-50%, -50%); opacity: 0.9; filter: alpha(opacity = 90); font-size: 20px;'>

		HİSSELERİ KONTROL EDİNİZ!!! <br> <br> <input type='button'
			value='Kapat' class="btn btn-success" onclick='Kapat()'>
	</div>
	<table width="100%">
		<tr>
			<td>KÜÇÜKBAŞ SATIŞ EKRANI</td>
		</tr>
		<tr>
			<td>${sayi}</td>
		</tr>
	</table>

	<form:form method="post" action="./ekleKucukSatis"
		commandName="hissedar2">
		<form:hidden path="id" />
		<table style="">
			<tr>
				<td>Hayvan No</td>
				<td><form:input path="hayvanNo" required="true" id="hayvanNo" /></td>
			</tr>
			<tr>
				<td>Satış Fiyatı</td>
				<td><form:input path="satisFiyati" id="satisFiyati"
						required="true" /></td>
			</tr>
			<tr>
				<td>Kesim Fiyatı</td>
				<td><input name="kesimUcreti" id="kesimFiyati" value="40" /></td>
			</tr>
			<tr>

			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<table id="giristablosu" border="1" cellspacing="0" cellpadding="0">
			<tr id="satir1">

				<td>Seçim</td>
				<td>İsim</td>
				<td>Telefon Numarası</td>
				<td>Referans</td>
			</tr>
			<tr>

				<td><input type="checkbox" name="checkbox1" id="kutu1"
					value="t"></td>
				<td><form:input path="isim" id="isim" /></td>
				<td><form:input path="telNo" /></td>
				<td><form:input path="referans" id="referans" /></td>
			</tr>

			<tr>
				<td colspan=4 align="right"><input type="submit" value="EKLE"
					onclick="kontrol2()" style="width: 44em; height: 2em"></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br />
	<br />
	<br />
	<%-- <c:if test="${!empty list }">
		<form action="./hissedarArama" method="post">
			<table style="position: fixed; top: 8px; left: 350px;">
				<tr>
					<td>Hissedar İsmi:</td>
					<td><input type="text" name="isim" onkeyup="kCap(this);"></td>
					<td><input type="submit" value="OK" tabindex="0" /></td>
				</tr>
			</table>
		</form>
	</c:if>
	<br>
	--%>
	<table border="2" cellpadding="0" cellspacing="0" id="satistablosu"
		style="text-align: center" width="100%">
		<tr class="tablosatir">
			<td>Sıra</td>
			<td>Hayvan No</td>
			<td>Fiyatı</td>
			<td width="300px">İsim</td>
			<td>Telefon No</td>
			<td>Referans</td>
		</tr>
		<c:forEach items="${list}" var="hissedar" varStatus="sira">
			<c:if test="${hissedar.isim ==''}">
				<tr id="satirno${hissedar.id}">
					<td>${sira.count}</td>
					<td class="tablosatir"><a
						href="./hissedar2Getir/${hissedar.id}"> ${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim}</td>
					<td>${hissedar.telNo}</td>
					<td>${hissedar.referans}</td>
				</tr>
			</c:if>
		</c:forEach>

	</table>
	<br />
	<br />
	<br />
	<br />
	<table border="2" cellpadding="0" cellspacing="0" id="satistablosu"
		style="text-align: center" width="100%">
		<tr class="tablosatir">
			<td>Sıra</td>
			<td>Hayvan No</td>
			<td>Fiyatı</td>
			<td width="300px">İsim</td>
			<td>Telefon No</td>
			<td>Referans</td>
		</tr>
		<c:forEach items="${list}" var="hissedar" varStatus="sira">
			<tr id="satirno${hissedar.id}">
				<td>${sira.count}</td>
				<td class="tablosatir"><a
					href="./hissedar2Getir/${hissedar.id}"> ${hissedar.hayvanNo}</a></td>
				<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
						value="${hissedar.satisFiyati}" type="currency" /></td>
				<td>${hissedar.isim}</td>
				<td>${hissedar.telNo}</td>
				<td>${hissedar.referans}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>