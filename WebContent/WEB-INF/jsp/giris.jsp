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


<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
<script src='<c:url value="/resources/js/ajax.js"></c:url>'></script>
<script src="<c:url value="/resources/js/genel.js" />"></script>
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<%-- <script src="<c:url value="/resources/js/googlejquery.js" />"></script> --%>
<title>GİRİŞ</title>
</head>
<body onload="tarihFonksiyonu()">
	<a href="#" onclick="divGoster()" id="dıvGosterGizle"></a>
	<button onclick="divGoster()" id="dıvGosterGizle">BUTON</button>
	<div id="gosterDiv"
		style='border: 2px solid red; border-radius: 0.8px;'>
		<%-- <jsp:include page="/WEB-INF/jsp/ustbaslik.jsp" /> --%>
		<table width="100%" border="1">
			<tr>
				<td><a href="#" id="buyuk"><input type="image"
						src="<c:url value="/resources/resimler/buyukbas.jpg" />"
						width="50px" title="Büyükbaş Sayfasına Git" />Büyükbaş Ekleme </a></td>
				<td><a href="#" id="kucuk"><input type="image"
						src="<c:url value="/resources/resimler/kucukbas.jpg" />"
						width="50px" title="Küçükbaş Sayfasına Git" />Küçükbaş Ekleme </a></td>
				<td><a href="#" id="gider"><input type="image"
						src="<c:url value="/resources/resimler/cüzdan.jpg" />"
						width="50px" title="Gider Sayfasına Git" />GİDERLER</a></td>
			</tr>
			<tr>
				<td><a href="#" id="satis"><input type="image"
						src="<c:url value="/resources/resimler/buyukbas.jpg" />"
						width="50px" title="Büyükbaş Satış Sayfasına Git" />Büyükbaş
						Satış </a></td>
				<td><a href="#" id="satis2"><input type="image"
						src="<c:url value="/resources/resimler/kucukbas.jpg" />"
						width="50px" title="Küçükbaş Sayfasına Git" />Küçükbaş Satış </a></td>
				<td><a href="#" id="tahsilatyonlendirme"><input
						type="image" src="<c:url value="/resources/resimler/pos.jpg" />"
						width="50px" title="Tahsilat Sayfasına Git" />TAHSİLAT</a></td>

			</tr>



		</table>
	</div>



	<p id="demo"></p>
	<div id="mytable"></div>
	<script type="text/javascript">
		function divGizle() {
			$('#gosterDiv').hide();

			if ($('#gosterDiv').hide()) {
				$('#dıvGosterGizle').text("MENU GÖSTER/GİZLE");
			}
		};
		function divGoster() {
			$('#gosterDiv').toggle("fade");

		}
	</script>
	<%-- 

		<b><a href="./buyukbasEkleme" id="buyuk" class="pager-link"><input
				type="image"
				src="<c:url value="/resources/resimler/buyukbas.jpg" />"
				width="50px" title="Büyükbaş Sayfasına Git" />Büyükbaş Ekleme </a></b> <br>
		<br> <b> <a href="./kucukbasEkleme"><input type="image"
				src="<c:url value="/resources/resimler/kucukbas.jpg" />"
				width="50px" title="Küçükbaş Sayfasına Git" />Küçükbaş Ekleme </a>
		</b> <br> <br> <br> <b><a href="./satis"><input
				type="image"
				src="<c:url value="/resources/resimler/buyukbas.jpg" />"
				width="50px" title="Büyükbaş Satış Sayfasına Git" />Büyükbaş Satış
		</a></b> <br> <br> <br> <b> <a href="./tahsilatyonlendirme"><input
				type="image" src="<c:url value="/resources/resimler/pos.jpg" />"
				width="50px" title="Tahsilat Sayfasına Git" />TAHSİLAT</a>
		</b> <br> <br> <br> <b> <a href="./giderler" id="gider"><input
				type="image" src="<c:url value="/resources/resimler/cüzdan.jpg" />"
				width="50px" title="Gider Sayfasına Git" />GİDERLER</a>
		</b> --%>

	<form:form action="hesapla" method="get">
		<table>
			<tr>
				<td><input type="text" name="sayi" id="sayi"></td>
				<td><input type="button" onclick="showProgress()"
					value="Hesapla"></td>
				<td></td>
			</tr>
			<tr>
				<td>Girilen Sayı</td>
				<td id="girilenSayi">:${girilensayi}</td>
			</tr>
			<tr>
				<td>Girilen Sayının Toplamı</td>
				<td id="girilenSayiToplami">:${sayi}</td>
			</tr>
		</table>
	</form:form>
	<div id='progress' class="uyari"
		style='z-index: 300000; display: none; padding: 5px; align: center; border-radius: 5px; text-align: center; position: fixed; top: 50%; box-sizing: border-box; left: 50%; width: 100%; height: 100%; background-color: white; border: 2px solid red; -webkit-transform: translate(-50%, -50%); opacity: 0.5; filter: alpha(opacity = 90); font-size: 20px;'>
		<input type="image" style='width: 50%; top: 50%'
			src="<c:url value="/resources/resimler/loading_spinner.gif" />" />
	</div>
	<div id="progress"
		style="display: none; background-color: #b0c4de; cursor: default; opacity: 0.8; filter: progid:DXImageTransform.Microsoft.Alpha(opacity=10); position: fixed; z-index: 15000; left: 0; top: 0; width: 100%; height: 100%; border: none; zoom: 1;"></div>

</body>

</html>