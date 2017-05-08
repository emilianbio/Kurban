package forms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "buyukbas", schema = "public")
public class Buyukbas implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "buyukbas_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "agirlik")
	private Long agirlik;

	@Column(name = "hayvan_no")
	private Long hayvanNo;

	@Column(name = "alis_fiyati")
	private int alisFiyati;

	@Column(name = "satis_fiyati")
	private int satisFiyati;

	@Column(name = "kesim_ucreti")
	private int kesimUcreti;

	@Column(name = "isim")
	private String isim;

	@Column(name = "hissesi")
	private Long hissesi;

	// @Column(name = "referans")
	// private String referans;

	@Column(name = "tel_no")
	private String telNo;

	@Column(name = "hisseye_dusen_miktar")
	private int hisseFiyati;

	@Column(name = "odenen")
	private Long odenen;

	@Column(name = "kalan")
	private Long kalan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "odemezamani")
	private Date odemezamani;

	@Column(name = "kupeno")
	private String kupeNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getAgirlik() {
		return agirlik;
	}

	public void setAgirlik(Long agirlik) {
		this.agirlik = agirlik;
	}

	public Long getHayvanNo() {
		return hayvanNo;
	}

	public void setHayvanNo(Long hayvanNo) {
		this.hayvanNo = hayvanNo;
	}

	public int getAlisFiyati() {
		return alisFiyati;
	}

	public void setAlisFiyati(int alisFiyati) {
		this.alisFiyati = alisFiyati;
	}

	public int getSatisFiyati() {
		return satisFiyati;
	}

	public void setSatisFiyati(int satisFiyati) {
		this.satisFiyati = satisFiyati;
	}

	public int getKesimUcreti() {
		return kesimUcreti;
	}

	public void setKesimUcreti(int kesimUcreti) {
		this.kesimUcreti = kesimUcreti;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public Long getHissesi() {
		return hissesi;
	}

	public void setHissesi(Long hissesi) {
		this.hissesi = hissesi;
	}

	// public String getReferans() {
	// return referans;
	// }
	//
	// public void setReferans(String referans) {
	// this.referans = referans;
	// }

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public int getHisseFiyati() {
		return hisseFiyati;
	}

	public void setHisseFiyati(int hisseFiyati) {
		this.hisseFiyati = hisseFiyati;
	}

	public Long getOdenen() {
		return odenen;
	}

	public void setOdenen(Long odenen) {
		this.odenen = odenen;
	}

	public Long getKalan() {
		return kalan;
	}

	public void setKalan(Long kalan) {
		this.kalan = kalan;
	}

	public Date getOdemezamani() {
		return odemezamani;
	}

	public void setOdemezamani(Date odemezamani) {
		this.odemezamani = odemezamani;
	}

	public String getKupeNo() {
		return kupeNo;
	}

	public void setKupeNo(String kupeNo) {
		this.kupeNo = kupeNo;
	}

}
