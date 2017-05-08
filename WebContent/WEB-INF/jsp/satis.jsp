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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<script src="<c:url value="/resources/js/googlejquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"></c:url>"></script>
<script src="<c:url value="/resources/js/genel.js"></c:url>"></script>
<script src="<c:url value="/resources/js/googlejquery.js" />"></script>

</head>
<body onload="bolme()">
	<script type="text/javascript">
		function update(j) {
			var n = parseInt(j.text(), 10);
			j.text(n + 1);
		}
		var tık = $("#add").click(function() {
			update($("span:first"));
		});
		$form = $('#personas');
		$rows = $form.find('#giristablosu');
		if (parseInt($("span:first").text()) == '6') {
			$('#add').hide();
		}
		var j = 1;
		$('#add').click(
				function() {
					$rows.find('tr:nth-child(3) ').clone().insertAfter(
							$rows.find('tr:last-child').prev());
					$justInserted = $rows.find('tr:last-child').prev().attr(
							"id", "satir" + ++j).fadeIn(6000);

					//$justInserted.hide();
					//	$justInserted.find('input').val(''); // it may copy values from first one

					$justInserted.slideDown(2000);

					//$justInserted.find('input:last-child').attr("path", "telNo" + j);
					$("#satir" + j + " td:nth-child(2) input").attr("name",
							"isim" + (j));
					$("#satir" + j + " td:nth-child(3) input").attr("name",
							"hissesi" + (j));
					$("#satir" + j + " td:nth-child(4) input").attr("name",
							"hisseFiyati" + (j));
					$("#satir" + j + " td:nth-child(5) input").attr("name",
							"telNo" + (j));
					$("#satir" + j + " td:nth-child(6) input").attr("name",
							"referans" + (j));

					$("#satir" + j + " td:nth-child(3) input").attr("id",
							"hissesi" + (j));
					$("#satir" + j + " td:nth-child(4) input").attr("id",
							"hisseFiyati" + (j));

					if (j == 7) {
						$('#add').hide();

					}
				});
	</script>
	<script type="text/javascript">
		$("form").on("submit", function(event) {
			event.preventDefault();
			console.log($(this).serialize());
		});

		$(document).ready(function() {

		});
	</script>


	<div id='uyari' class="uyari"
		style='z-index: 300000; display: none; padding: 5px; align: center; border-radius: 5px; text-align: center; position: fixed; top: 50%; box-sizing: border-box; left: 50%; width: auto; height: auto; background-color: white; border: 2px solid #2DAAE4; -webkit-transform: translate(-50%, -50%); opacity: 0.9; filter: alpha(opacity = 90); font-size: 20px;'>

		HİSSELERİ KONTROL EDİNİZ!!! <br> <br> <input type='button'
			value='Kapat' class="btn btn-success" onclick='Kapat()'>
	</div>
	<table width="100%">
		<tr>
			<td>BÜYÜKBAŞ SATIŞ EKRANI</td>
		</tr>
	</table>

	<form:form method="post" action="/" commandName="hissedar"
		id="personas">
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
				<td><input name="kesimUcreti" id="kesimFiyati" value="350" /></td>
			</tr>
			<tr>
				<td>Kesim Sırası</td>
				<td><form:input type="number" path="sira" id="kesimSirasi"
						min="1" max="250" onkeypress="bolme()" /></td>
				<c:if test="${hissedar.sira==0}">
					<td><label style="color: red"> Kesim Sırasını Seçmeyi
							Unutma!!! </label></td>
				</c:if>
			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<table id="giristablosu" border="1" cellspacing="0" cellpadding="0"
			width="100%" onclick="bolme();">
			<tr>
				<td colspan="6" style="font-size: 20px"><a href="#" id="add">
						+ </a> Satır Sayısı: <span>1</span></td>
			</tr>
			<tr id="satir0">

				<td>Seçim</td>
				<td>İsim</td>
				<td>Hisse Miktarı</td>
				<td>Hisse Düşen Miktar</td>
				<td>Telefon Numarası</td>
				<td>Referans</td>
			</tr>
			<tr id="satir1">

				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu1"></td>
				<td><form:input path="isim" id="isim0" /></td>
				<td><form:input type="number" path="hissesi" id="hissesi"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati" id="hisseFiyati" /></td>
				<td><form:input path="telNo" /></td>
				<td><form:input path="referans" id="referans" /></td>

			</tr>
			<tr id="satir2">
				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu2" value="t"></td>
				<td><form:input path="isim2" id="isim2" /></td>
				<td><form:input type="number" path="hissesi2" id="hissesi2"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati2" id="hisseFiyati2" /></td>
				<td><form:input type="tel" path="telNo2" /></td>
				<td><form:input path="referans2" /></td>
			</tr>
			<tr id="satir3">
				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu3" value="t"></td>
				<td><form:input path="isim3" id="isim3" /></td>
				<td><form:input type="number" path="hissesi3" id="hissesi3"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati3" id="hisseFiyati3" /></td>
				<td><form:input path="telNo3" /></td>
				<td><form:input path="referans3" /></td>
			</tr>
			<tr>

				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu4" value="t"></td>
				<td><form:input path="isim4" id="isim4" /></td>
				<td><form:input type="number" path="hissesi4" id="hissesi4"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati4" id="hisseFiyati4" /></td>
				<td><form:input path="telNo4" /></td>
				<td><form:input path="referans4" /></td>
			</tr>
			<tr>

				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu5" value="t"></td>
				<td><form:input path="isim5" id="isim5" /></td>
				<td><form:input type="number" path="hissesi5" id="hissesi5"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati5" id="hisseFiyati5" /></td>
				<td><form:input path="telNo5" /></td>
				<td><form:input path="referans5" /></td>
			</tr>
			<tr>

				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu6" value="t"></td>
				<td><form:input path="isim6" id="isim6" /></td>
				<td><form:input type="number" path="hissesi6" id="hissesi6"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati6" id="hisseFiyati6" /></td>
				<td><form:input path="telNo6" /></td>
				<td><form:input path="referans6" /></td>
			</tr>
			<tr>

				<td style="width: 1em"><input type="checkbox" name="checkbox1"
					id="kutu7" value="t"></td>
				<td><form:input path="isim7" id="isim7" /></td>
				<td><form:input type="number" path="hissesi7" id="hissesi7"
						onkeypress="bolme()" /></td>
				<td><form:input path="hisseFiyati7" id="hisseFiyati7" /></td>
				<td><form:input path="telNo7" /></td>
				<td><form:input path="referans7" /></td>
			</tr>
			<tr id="sonSatir">
				<td id="sonSatir" colspan=7 align="right"><input type="button"
					value="VAZGEÇ" style="width: 20em; height: 5em"
					onclick="javascript:location.href='./hissedarVazgec'" /> <input
					id="click" type="submit" value="EKLE"
					style="width: 20em; height: 5em"></td>
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
	<table border="2" cellpadding="0" cellspacing="0"
		id="buyukbasSatisListesi" style="text-align: center" width="100%">
		<tr class="tablosatir">
			<td>Sıra</td>
			<td>Hayvan No</td>
			<td width="100px">Fiyatı</td>
			<td width="300px">İsim</td>
			<td>Hisse Miktarı</td>
			<!-- 	<td align="center" width="95px">Satış Fiyatı</td> -->
			<td>Hisse Fiyatı</td>
			<td>Kesim Sırası</td>
			<td>Telefon No</td>
			<td>Referans</td>
		</tr>
		<c:forEach items="${list}" var="hissedar" varStatus="sira">
			<c:if test="${!empty hissedar.isim}">
				<tr id="satirno${hissedar.id}">
					<td>${sira.count}</td>
					<td class="tablosatir"><a
						href="./hissedarGetir/${hissedar.id}"> ${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim}</td>
					<td>${hissedar.hissesi}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo}</td>
					<td>${hissedar.referans}</td>
				</tr>
			</c:if>
			<c:if test="${!empty hissedar.isim2}">
				<tr id="satirno${hissedar.id}" class="tablosatir">
					<td>${sira.count}</td>
					<td><a href="./hissedarGetir/${hissedar.id}">
							${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim2}</td>
					<td>${hissedar.hissesi2}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati2}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo2}</td>
					<td>${hissedar.referans2}</td>
				</tr>
			</c:if>
			<c:if test="${!empty hissedar.isim3}">
				<tr id="satirno${hissedar.id}" class="tablosatir">
					<td>${sira.count}</td>
					<td><a href="./hissedarGetir/${hissedar.id}">
							${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>

					<td>${hissedar.isim3}</td>
					<td>${hissedar.hissesi3}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati3}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo3}</td>
					<td>${hissedar.referans3}</td>
			</c:if>
			<c:if test="${!empty hissedar.isim4}">
				<tr id="satirno${hissedar.id}" class="tablosatir">
					<td>${sira.count}</td>
					<td><a href="./hissedarGetir/${hissedar.id}">
							${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim4}</td>
					<td>${hissedar.hissesi4}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati4}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo4}</td>
					<td>${hissedar.referans4}</td>
				</tr>
			</c:if>
			<c:if test="${!empty hissedar.isim5}">
				<tr id="satirno${hissedar.id}" class="tablosatir">
					<td>${sira.count}</td>
					<td><a href="./hissedarGetir/${hissedar.id}">
							${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim5}</td>
					<td>${hissedar.hissesi5}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati5}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo5}</td>
					<td>${hissedar.referans5}</td>
				</tr>
			</c:if>
			<c:if test="${!empty hissedar.isim6}">
				<tr id="satirno${hissedar.id}" class="tablosatir">
					<td>${sira.count}</td>
					<td><a href="./hissedarGetir/${hissedar.id}">
							${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim6}</td>
					<td>${hissedar.hissesi6}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati6}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo6}</td>
					<td>${hissedar.referans6}</td>
				</tr>
			</c:if>
			<c:if test="${!empty hissedar.isim7}">
				<tr id="satirno${hissedar.id}" class="tablosatir">
					<td>${sira.count}</td>
					<td><a href="./hissedarGetir/${hissedar.id}">
							${hissedar.hayvanNo}</a></td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.satisFiyati}" type="currency" /></td>
					<td>${hissedar.isim7}</td>
					<td>${hissedar.hissesi7}</td>
					<td><fmt:setLocale value="tr_TR" /> <fmt:formatNumber
							value="${hissedar.hisseFiyati7}" type="currency" /></td>
					<td>${hissedar.sira}</td>
					<td>${hissedar.telNo7}</td>
					<td>${hissedar.referans7}</td>
				</tr>
			</c:if>
		</c:forEach>

	</table>
</body>
</html>