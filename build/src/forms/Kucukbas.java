package forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kucukbas", schema = "public")
public class Kucukbas implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "kucukbas_id_seq")
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

	public String getKupeNo() {
		return kupeNo;
	}

	public void setKupeNo(String kupeNo) {
		this.kupeNo = kupeNo;
	}

}
