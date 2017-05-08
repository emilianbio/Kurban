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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>GİRİŞ</title>
</head>
<body>
	<b><a href="buyukbasEkleme" id="buyuk"><input type="image"
			src="<c:url value="/resources/resimler/buyukbas.jpg" />" width="50px"
			title="Büyükbaş Sayfasına Git" />Büyükbaş Ekleme </a></b>
	<br>
	<br>
	<b> <a href="./kucukbasEkleme"><input type="image"
			src="<c:url value="/resources/resimler/kucukbas.jpg" />" width="50px"
			title="Küçükbaş Sayfasına Git" />Küçükbaş Ekleme </a>
	</b>
	<br>
	<br>
	<br>
	<b><a href="./satis"><input type="image"
			src="<c:url value="/resources/resimler/buyukbas.jpg" />" width="50px"
			title="Büyükbaş Satış Sayfasına Git" />Büyükbaş Satış </a></b>
	<br>
	<br>
	<br>
	<b> <a href="./tahsilatyonlendirme"><input type="image"
			src="<c:url value="/resources/resimler/pos.jpg" />" width="50px"
			title="Tahsilat Sayfasına Git" />TAHSİLAT</a>
	</b>
	<br>
	<br>
	<br>
	<b> <a href="./giderler"><input type="image"
			src="<c:url value="/resources/resimler/cüzdan.jpg" />" width="50px"
			title="Gider Sayfasına Git" />GİDERLER</a>
	</b>
</body>
</html>