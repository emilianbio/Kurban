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
@Table(name = "tahsilat", schema = "public")
public class Tahsilat implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "tahsilat_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "hissedar")
	private String isim;

	@Column(name = "toplamborc")
	private int satisFiyati;

	@Column(name = "odenen")
	private int odenen;

	@Column(name = "kalan")
	private int kalan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "odemezamani")
	private Date odemezamani;

	@Column(name = "tel_no")
	private String telNo;

	@Column(name = "hayvan_no")
	private Long hayvanNo;

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

	public int getSatisFiyati() {
		return satisFiyati;
	}

	public void setSatisFiyati(int satisFiyati) {
		this.satisFiyati = satisFiyati;
	}

	public int getOdenen() {
		return odenen;
	}

	public void setOdenen(int odenen) {
		this.odenen = odenen;
	}

	public int getKalan() {
		return kalan;
	}

	public void setKalan(int kalan) {
		this.kalan = kalan;
	}

	public Date getOdemezamani() {
		return odemezamani;
	}

	public void setOdemezamani(Date odemezamani) {
		this.odemezamani = odemezamani;
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

}
