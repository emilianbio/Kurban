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
<title>GİDERLER</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src='<c:url  value="/resources/js/genel.js"  ></c:url>'></script>
</head>
<body><jsp:include page="/WEB-INF/jsp/ustbaslik.jsp" />
	<form:form method="post" action="giderKaydet" commandName="gider"
		name="myForm">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Hayvan Cinsi</td>
				<td><form:select path="cins" name="cinsSec" id="cinsSec">
						<form:option value="0">Seçiniz</form:option>
						<form:option value="1">Küçükbaş</form:option>
						<form:option value="2">Büyükbaş</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Yem</td>
				<td><form:input path="yem" /></td>
			</tr>
			<tr>
				<td>Saman</td>
				<td><form:input path="saman" /></td>
			</tr>
			<tr>
				<td>Kasap</td>
				<td><form:input path="kasap" /></td>
			</tr>
			<tr>
				<td>Demirbaş</td>
				<td><form:input path="demirbas" /></td>
			</tr>
			<tr>
				<td>Çoban</td>
				<td><form:input path="coban" /></td>
			</tr>
			<tr>
				<td>Diğer</td>
				<td><form:input path="muhtelif" /></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td align="right"><input type="button"
					onclick="return giderlerFormDogrulama()" value="Ekle"></td>
		</table>
	</form:form>
	<table border="1" cellspacing="0">
		<tr>
			<td>Sıra</td>
			<td>Hayvan Cinsi</td>
			<td>Yem Gideri</td>
			<td>Saman Gideri</td>
			<td>Kasap Gideri</td>
			<td>Demirbaş Gideri</td>
			<td>Çoban Gideri</td>
			<td>Diğer Giderler</td>
		</tr>
		<c:forEach items="${giderList}" var="gider" varStatus="sira">
			<tr>
				<td>${sira.count}</td>
				<c:if test="${gider.cins eq 1}">
					<td>Küçükbaş</td>
				</c:if>
				<c:if test="${gider.cins eq 2}">
					<td>Büyükbaş</td>
				</c:if>
				<c:if test="${gider.cins eq 0}">
					<td></td>
				</c:if>
				<td>${gider.yem}</td>
				<td>${gider.saman}</td>
				<td>${gider.kasap}</td>
				<td>${gider.demirbas}</td>
				<td>${gider.coban}</td>
				<td>${gider.muhtelif}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>