<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><%@taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tahsilat Makbuzu</title>
</head>
<body>
	<script type="text/javascript">
		function printDiv(box2) {
			//Get the HTML of div
			var divElements = document.getElementById(box2).innerHTML;
			//Get the HTML of whole page
			var oldPage = document.body.innerHTML;
			//Reset the page's HTML with div's HTML only
			document.body.innerHTML = "<html><head><title></title></head><body>"
					+ divElements + "</body>";
			//Print Page
			window.print();
			//Restore orignal HTML
			document.body.innerHTML = oldPage;
		}
	</script>
	<div id="box2">
		<!--       
		style='z-index: 300000; display: none; padding: 5px; align: center; 
		border-radius: 5px; text-align: center; position: fixed; top: 50%; box-sizing: border-box; 
		left: 50%; width: auto; height: auto; background-color: white; border: 2px solid #2DAAE4; 
		-webkit-transform: translate(-50%, -50%); opacity: 0.9; filter: alpha(opacity = 90); font-size: 20px;' 
		-->
		<table width=800 border=0 cellspacing=0 cellpadding=0>
			<tr>
				<td align=center height=50></td>
			</tr>
			<tr id="satirno${makbuzyazdirma.id}">
			<tr>
				<td align=left colspan=2>K</td>
				<td align=right colspan=3 style="font-weight: bold;">TARİH:<fmt:formatDate
						value="${makbuzyazdirma.odemezamani}" pattern="dd.MM.yyyy " /> <%-- ${z.baslamatarihi} --%>
				</td>
			</tr>
			<tr>
				<td colspan=5 align=center
					style="border: 1px solid #000000; font-weight:; text-align: center; width: 80px;">ÖDEME
					DETAYLARI</td>
			</tr>
			<tr>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 80px;">Makbuz
					No</td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 200px;">Toplam
					Borç</td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 200px;">Ödenen</td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 200px;">Kalan</td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 100px;">Ödeme
					Sayısı</td>
			</tr>
			<tr>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 80px;">${odemeSayisi}</td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 200px;"><fmt:setLocale
						value="tr_TR" /> <fmt:formatNumber
						value="${makbuzyazdirma.satisFiyati}" type="currency" /></td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 200px;"><fmt:setLocale
						value="tr_TR" /> <fmt:formatNumber
						value="${makbuzyazdirma.odenen}" type="currency" /></td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 200px;"><fmt:setLocale
						value="tr_TR" /> <fmt:formatNumber
						value="${makbuzyazdirma.kalan}" type="currency" /> <%-- ${z.tutar} --%>
				</td>
				<td
					style="border: 1px solid #000000; font-weight: bold; text-align: center; width: 100px;">${odemeSayisi}</td>
			</tr>
			<tr>
				<td style="border: 1px solid #000000; height: 150px;" valign=top
					colspan=5>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan=2 height=50></td>
						</tr>
						<tr>
							<td align=center height=30>Teslim Eden</td>
							<td align=center height=30>Tahsil Eden</td>
						</tr>
						<tr>
							<td align=center height=30><b>Adı Soyadı:</b></td>
							<td align=center height=30><b>Adı Soyadı:</b></td>
						</tr>
						<tr></tr>
						<tr>
							<td align=center height=30><b>İmzası:.........</b></td>
							<td align=center height=30><b>İmzası:.........</b></td>
						</tr>
						<tr>
							<td align=center height=100><b></b></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<table>
		<tr>
			<td colspan="5"
				style="border: 0px solid #000000; font-weight: bold; text-align: center;">
				<input type="image"
				src="<c:url value="/resources/resimler/printer-icon.png" />"
				width="100px" onclick="javascript:printDiv('box2')">
			</td>
		</tr>
	</table>
</body>
</html>