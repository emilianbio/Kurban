$(document).ready(function() {
	// set initial state.

	/* $('#isim').val(0); */

	/*
	 * $('#kutu1').change(function() { /*
	 * $('#isim').val($('#kutu1').is(':checked')); if (confirm("Are you sure?")) {
	 * $('#isim').val(""); $('#hissesi').val(0); $('#hisseFiyati').val(0);
	 * $('#telNo').val(""); $('#referans').val(""); } else return false;
	 * 
	 * });
	 */
	if (document.getElementById('isim').value == "") {

		$('#kutu1').click(function() {

			alert("kayıt yok");
			return false;
		})

	} else {

		$('#kutu1').click(function() {
			if ($('#kutu1').is(':checked'))
				if (confirm("Silmek istediğinizden emin misiniz?"))

				{
					$('#isim').val("");
					$('#hissesi').val(0);
					$('#hisseFiyati').val(0);
					$('#telNo').val("");
					$('#referans').val("");

				} else
					return false;

		});
	}

	$('#kutu2').click(function() {
		if ($('#kutu2').is(':checked'))
			if (confirm("Silmek istediğinizden emin misiniz?"))

			{
				$('#isim2').val("");
				$('#hissesi2').val(0);
				$('#hisseFiyati2').val(0);
				$('#telNo2').val("");
				$('#referans2').val("");

			} else
				return false;
	});

	$('#kutu3').click(function() {
		if ($('#kutu3').is(':checked'))
			if (confirm("Silmek istediğinizden emin misiniz?"))

			{
				$('#isim3').val("");
				$('#hissesi3').val(0);
				$('#hisseFiyati3').val(0);
				$('#telNo3').val("");
				$('#referans3').val("");

			} else
				return false;
	});
	$('#kutu4').click(function() {
		if ($('#kutu4').is(':checked'))
			if (confirm("Silmek istediğinizden emin misiniz?"))

			{
				$('#isim4').val("");
				$('#hissesi4').val(0);
				$('#hisseFiyati4').val(0);
				$('#telNo4').val("");
				$('#referans4').val("");

			} else
				return false;
	});
	$('#kutu5').click(function() {
		if ($('#kutu5').is(':checked'))
			if (confirm("Silmek istediğinizden emin misiniz?"))

			{
				$('#isim5').val("");
				$('#hissesi5').val(0);
				$('#hisseFiyati5').val(0);
				$('#telNo5').val("");
				$('#referans5').val("");

			} else
				return false;
	});
	$('#kutu6').click(function() {
		if ($('#kutu6').is(':checked'))
			if (confirm("Silmek istediğinizden emin misiniz?"))

			{
				$('#isim6').val("");
				$('#hissesi6').val(0);
				$('#hisseFiyati6').val(0);
				$('#telNo6').val("");
				$('#referans6').val("");

			} else
				return false;
	});
	$('#kutu7').click(function() {
		if ($('#kutu7').is(':checked'))
			if (confirm("Silmek istediğinizden emin misiniz?"))

			{
				$('#isim7').val("");
				$('#hissesi7').val(0);
				$('#hisseFiyati7').val(0);
				$('#telNo7').val("");
				$('#referans7').val("");

			} else
				return false;
	});
});

function kCap(iO) {
	iO.value = iO.value.replace(/([\wöçşğüıİ])/gi, function(a, b) {
		return b.replace("I", "ı").toLowerCase()
	}).replace(/(^[a-zöçşğüı]|[\s][a-zöçşğüı])/g, function(c, d) {
		return d.replace("i", "İ").toUpperCase()
	});
}
function tahsilatKalan() {
	var hisseFiyati = parseInt(document.getElementById('hisseFiyati').value);
	var kalan = parseInt(document.getElementById('kalan').value);
	var odenen = parseInt(document.getElementById('odenen').value);
	if (kalan == 0) {

		document.getElementById('kalan').value = (hisseFiyati - odenen);
	} else {
		document.getElementById('kalan').value = (kalan - odenen);
	}

}
function bolme() {
	var degerSatisFiyati = parseInt(document.getElementById('satisFiyati').value);
	var degerkesimFiyati = parseInt(document.getElementById('kesimFiyati').value);

	var deger1 = parseFloat(document.getElementById('hissesi').value);
	var deger2 = parseFloat(document.getElementById('hissesi2').value);
	var deger3 = parseFloat(document.getElementById('hissesi3').value);
	var deger4 = parseFloat(document.getElementById('hissesi4').value);
	var deger5 = parseFloat(document.getElementById('hissesi5').value);
	var deger6 = parseFloat(document.getElementById('hissesi6').value);
	var deger7 = parseFloat(document.getElementById('hissesi7').value);

	var toplam = deger1 + deger2 + deger3 + deger4 + deger5 + deger6 + deger7;

	if (document.getElementById('hissesi').value == 0) {

		document.getElementById('hisseFiyati').value = "0";
	} else {

		document.getElementById('hisseFiyati').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger1);
	}

	if (document.getElementById('hissesi2').value == 0) {

		document.getElementById('hisseFiyati2').value = "0";
	} else {

		document.getElementById('hisseFiyati2').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger2);
	}

	if (document.getElementById('hissesi3').value == 0) {

		document.getElementById('hisseFiyati3').value = "0";
	} else {

		document.getElementById('hisseFiyati3').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger3);
	}

	if (document.getElementById('hissesi4').value == 0) {

		document.getElementById('hisseFiyati4').value = "0";
	} else {

		document.getElementById('hisseFiyati4').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger4);
	}

	if (document.getElementById('hissesi5').value == 0) {

		document.getElementById('hisseFiyati5').value = "0";
	} else {

		document.getElementById('hisseFiyati5').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger5);
	}

	if (document.getElementById('hissesi6').value == 0) {

		document.getElementById('hisseFiyati6').value = "0";
	} else {

		document.getElementById('hisseFiyati6').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger6);
	}

	if (document.getElementById('hissesi7').value == 0) {

		document.getElementById('hisseFiyati7').value = "0";
	} else {

		document.getElementById('hisseFiyati7').value = Math
				.ceil((degerSatisFiyati + degerkesimFiyati) / toplam * deger7);
	}

	var elem = document.getElementById("giristablosu");
	if (document.getElementById("hayvanNo").value != ""
			&& document.getElementById("kesimSirasi").value != ""
			&& document.getElementById("satisFiyati").value != ""
			&& document.getElementById("kesimSirasi").value != 0
			&& document.getElementById("satisFiyati").value != 0
			&& document.getElementById("kesimFiyati").value != "") {

		elem.style.display = "table";

	} else {
		elem.style.display = "none";
	}

}

function kontrol() {
	var deger1 = parseInt(document.getElementById('satisFiyati').value);
	var deger1 = parseInt(document.getElementById('kesimSirasi').value);
	var deger2 = parseInt(document.getElementById('hissesi').value);

	if (deger1 == null || deger1 == 0 || deger2 == null || deger2 == 0)

		alert("\n" + "Lütfen Girdiğiniz Değerleri Kontrol Ediniz" + "\n")

}
function kontrol2(texstring) {
	var deger1 = parseFloat(document.getElementById('hissesi').value);
	var deger2 = parseFloat(document.getElementById('hissesi2').value);
	var deger3 = parseFloat(document.getElementById('hissesi3').value);
	var deger4 = parseFloat(document.getElementById('hissesi4').value);
	var deger5 = parseFloat(document.getElementById('hissesi5').value);
	var deger6 = parseFloat(document.getElementById('hissesi6').value);
	var deger7 = parseFloat(document.getElementById('hissesi7').value);

	var toplam = deger1 + deger2 + deger3 + deger4 + deger5 + deger6 + deger7;
	if (toplam > 7 || toplam == 0 || toplam < 0 || toplam == ''
			|| toplam == null) {

		document.all("uyari").style.display = "inline";
		document.all("bg").style.display = "inline";

	} else {
		hissedar.submit();

	}
}

function Kapat() {

	document.all("uyari").style.display = "none";
	document.all("bg").style.display = "none";
}

function giderlerFormDogrulama() {
	var x = document.forms["myForm"]["cinsSec"].value;
	if (x == 0) {
		alert("Hayvan Cinsi Seçmediniz!!");
		return false;
	} else {

		gider.submit();
	}
}

var jq = jQuery.noConflict();

function demirbassil(id) {// hem veritabanından hem de görüntülenen sayfadan
	// silmek için gereklidir.
	if (confirm("Sileyim mi " + id))
		;
	{
		jq('#satirno' + id).add()// jsp sayfasından siler veritabanından
		// silmez
		jq.ajax({
			type : "POST",
			url : "./demirbassil",// veritabanından siler jspden silmez

			dataType : "JSON",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			data : {
				id : id
			},
			success : function(gelen) { // vtden silmesi için ne yaptın
				// alert("buraya kadar hata olacaK mı?");
				jq('#satirno' + id).remove();
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus);
			}
		});
	}
}