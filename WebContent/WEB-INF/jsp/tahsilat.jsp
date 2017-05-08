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
<title>BÜYÜKBAŞ TAHSİLAT</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/yukleniyor.css" />" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/genel.js" />"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#isim").autocomplete({
			source : './hissedarOtomatikTamamlama',
			minLength : 0,
			delay : 10,
			focus : function() {
				// prevent value inserted on focus
				return false;
			},
		})
	})
	$(document).ready(function() {
		$("#hayvanNo").autocomplete({
			source : './hayvanNoOtomatikTamamlama',
			minLength : 0,
			delay : 10,
			focus : function() {
				// prevent value inserted on focus
				return false;
			},
		})
	})
	function kCap(iO) {
		iO.value = iO.value.replace(/([\wöçşğüıİ])/gi, function(a, b) {
			return b.replace("I", "ı").toLowerCase()
		}).replace("i̇", "İ").replace(/(^[a-zöçşğüı]|[\s][a-zöçşğüı])/g,
				function(c, d) {
					return d.replace("i", "I").toUpperCase()
				});
	}
	function tahsilatKalan1() {
		var deger1 = parseInt(document.getElementById('kalan').value);
		var deger2 = parseInt(document.getElementById('odenen').value);
		document.getElementById('kalan').value = (deger1 - deger2);
	}

	function showProgress() {
		document.getElementById('progress').style.display = 'block';
	}
</script>
<style>
</style>
</head>
<body><jsp:include page="/WEB-INF/jsp/ustbaslik.jsp" />
	<form action="hissedarArama" method="post">
		<table>
			<tr>
				<td>Hissedar İsmi:</td>
				<td><input type="text" name="isim" id="isim"
					onkeyup="kCap(thi);showProgress();"></td>
				<td><input type="image" style="width: 20px;" id="progress"
					src="<c:url value="/resources/resimler/loading_spinner.gif" />"></td>
				<!-- onkeyup="kCap(this);showProgress()" -->
				<td><input type="submit" value="OK" tabindex="0" id="isimb" /></td>
			</tr>
		</table>
	</form>
	<form action="./hayvanNoArama" method="post">
		<table>
			<tr>
				<td>Hayvan No:</td>
				<td><input type="text" name="hayvanNo" id="hayvanNo"
					onkeyup="kCap(this);"></td>
				<td><input type="submit" value="OK" tabindex="0" /></td>
			</tr>
		</table>
	</form>

	<table border="5" cellpadding="3" cellspacing="0" style="float: left;">
		<tr>
			<td>Sıra</td>
			<td>İsim</td>
			<td>Hayvan No</td>
			<td>Hisse Fiyatı</td>
			<td>Son Ödeme</td>
			<td>Kalan</td>
			<td>Ödeme Zamani</td>
			<td>Makbuz Yazdir</td>
		</tr>
		<c:forEach items="${list}" var="hissedar" varStatus="sira">
			<tr id="satirno${hissedar.id}">
				<td class="td">${sira.count }</td>
				<td class="td"><input type="image"
					src="<c:url value="/resources/resimler/semerkand.png" />"
					width="21px" onclick="tahsilaticinhissedargetir(${hissedar.id})">${hissedar.isim}
				</td>
				<td class="td" align="center">${hissedar.hayvanNo}</td>
				<td class="td" align="center">${hissedar.satisFiyati}</td>
				<td class="td" align="center">${hissedar.odenen}</td>
				<td class="td" align="center">${hissedar.kalan}</td>
				<td class="td" align="center">${hissedar.odemezamani}</td>
				<td class="td"><a
					href="./makbuzicinHissedarGetir/${hissedar.id}"
					onclick="javascript:printDiv('box2')"> Makbuz Yazdir </a></td>
			</tr>

		</c:forEach>
	</table>
		<c:if test="${!empty tahsilat }">
			<form:form action="./tahsilatGiris" method="post"
				commandName="tahsilat">
				<form:hidden path="id" />
				<table cellpadding="0" border="1" cellspacing="0"  id="mytable">
					<tr>
						<td>Ödenen</td>
						<td><form:input path="odenen" required="true" id="odenen"
								value="0" /></td>
					</tr>
					<tr>
						<td>Kalan</td>
						<td><form:input path="kalan" id="kalan"
								onclick="tahsilatKalan()" value="${tahsilat.kalan}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="Ekle"></td>
					</tr>
					<tr>
						<td>Hissedar</td>
						<td><form:input path="isim" readonly="true" /></td>
					</tr>
					<tr>
						<td>Hayvan No</td>
						<td><form:input path="hayvanNo" /></td>
					</tr>
					<tr>
						<td>Hisse Fiyatı</td>
						<td><form:input path="satisFiyati" readonly="true"
								id="hisseFiyati" /></td>
					</tr>
					<tr>
						<td>Tel No</td>
						<td><form:input path="telNo" readonly="true" /></td>
					</tr>
					<tr>
						<td>SONUÇ</td>
						<td><input name="sonuc" id="sonuc" onclick="kalan()" /></td>
					</tr>
				</table>
			</form:form>
		</c:if>
</body>
</html>