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
@Table(name = "hissedar2", schema = "public")
public class Hissedarlar2 implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "hissedar2_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "isim")
	private String isim;

	@Column(name = "referans")
	private String referans;

	@Column(name = "tel_no")
	private String telNo;

	@Column(name = "hayvan_no")
	private Long hayvanNo;

	@Column(name = "fiyati")
	private int satisFiyati;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "islemzamani")
	private Date islamzamani;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getReferans() {
		return referans;
	}

	public void setReferans(String referans) {
		this.referans = referans;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Long getHayvanNo() {
		return hayvanNo;
	}

	public void setHayvanNo(Long hayvanNo) {
		this.hayvanNo = hayvanNo;
	}

	public int getSatisFiyati() {
		return satisFiyati;
	}

	public void setSatisFiyati(int satisFiyati) {
		this.satisFiyati = satisFiyati;
	}

	public Date getIslamzamani() {
		return islamzamani;
	}

	public void setIslamzamani(Date islamzamani) {
		this.islamzamani = islamzamani;
	}

}
