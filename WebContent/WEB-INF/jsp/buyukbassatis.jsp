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
<title>BÜYÜKBAŞ</title>
<link href="<c:url value="/resources/resim/simge.ico" />"
	rel="shortcut icon" type="image/vnd.microsoft.icon" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/genel.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/genel.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/buyukbassatis.css" />" />
</head>
<c:if test="${error==1}">

	<script type="text/javascript">
		alert("Hissedar Sayısı 7'ye Ulaşmış Durumda...");
	</script>
</c:if>
<body background="./resources/resimler/buyukbas.jpg"
	style="background-size: contain; background-position: top center; background-repeat: no-repeat; background-attachment: fixed;">
<jsp:include page="/WEB-INF/jsp/ustbaslik.jsp" />
	<table align="right">
		<tr>
			<td><a href="./girisedon">GİRİŞ</a></td>
			<td><a href="./kucukbasadon">KÜÇÜKBAŞ</a></td>
		</tr>
	</table>
	<form action="./hayvanGetir" method="post">
		<table>
			<tr>
				<td>Hayvan Numarası<br>Giriniz
				</td>
				<td><input type="text" name="hayvanNo"></td>
				<td><input type="submit" value="getir"></td>
		</table>
	</form>
	<form action="./fiyataGoreBuyukbasGetirme" method="post">
		<table>
			<tr>
				<td>Kurbanlık Fiyatı:</td>
				<!-- <td><input type="text" name="satisFiyati"></td> -->
				<td><select name="satisFiyati">
						<option value="">Seçiniz</option>
						<option value="7500">7.500,00 TRY</option>
						<option value="8000">8.000,00 TRY</option>
						<option value="9250">9.250,00 TRY</option>
						<option value="10000">10.000,00 TRY</option>
						<option value="17500">17.500,00 TRY</option>


				</select></td>
				<td><input type="submit" value="OK" tabindex="0" /></td>
			</tr>
		</table>
	</form>
	<table border="5" cellpadding="3" cellspacing="0" align=center>
		<tr>
			<td>Sıra</td>
			<td>Hayvan No</td>
			<td>Ekleme Yapmak İçin</td>
			<td>Satış Fiyatı</td>
			<td>Ağırlık</td>
			<td>Kesim Ucreti</td>
			<td>isim</td>
		</tr>

		<c:forEach items="${list}" var="buyukbas" varStatus="sira">
			<tr id="satirno${buyukbas.id}">
				<td class="td">${sira.count}</td>
				<td align="center"><a href="/kurban/hayvanGetir/${buyukbas.id}">${buyukbas.hayvanNo}</a>
				</td>
				<td align="center"><a
					href="/kurban/hayvanNoyaGöreHissedarGetir/${buyukbas.hayvanNo}">${buyukbas.hayvanNo}</a>
				</td>
				<td class="td"><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
						value="${buyukbas.satisFiyati}" type="currency" /></td>
				<td class="td">${buyukbas.agirlik}</td>
				<td class="td">${buyukbas.kesimUcreti}</td>
				<td class="td">${buykbas[sira.index.isim]}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>