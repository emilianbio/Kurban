<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>KÜÇÜKBAŞ</title>
</head>
<body background="./resources/resimler/kucukbas.jpg"
	style="background-size: contain; background-position: top center; background-repeat: no-repeat; background-attachment: fixed;">
<jsp:include page="/WEB-INF/jsp/ustbaslik.jsp" />	<table align="right">
		<tr>
			<td><a href="./girisedon">GİRİŞ</a></td>
			<td><a href="./buyukbasadon">BÜYÜKBAŞ</a></td>
		</tr>
	</table>
	<form:form method="post" action="ekleKucuk" commandName="kucukbas">
		<form:hidden path="id" />
		<table>
			<tr>
				<th>KÜÇÜKBAŞ KAYIT GİRİŞ</th>
			</tr>
			
			<tr>
				<td>Hayvan No</td>
				<td><form:input path="hayvanNo" /></td>
			</tr>
			<tr>
				<td>Ağırlık</td>
				<td><form:input path="agirlik" /></td>
			</tr>

			<tr>
				<td>Alış Fiyatı</td>
				<td><form:input path="alisFiyati" /></td>
			</tr>
			<tr>
				<td>Satış Fiyatı</td>
				<td><form:input path="satisFiyati" /></td>
			</tr>
			<tr>
				<td>Kesim Fiyatı</td>
				<td><form:input path="kesimUcreti" /></td>
			</tr>

			
			<tr>
				<td colspan=2 align="right"><input type="submit" value="EKLE"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>