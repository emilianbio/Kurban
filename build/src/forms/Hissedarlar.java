package forms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hissedar", schema = "public", indexes = { @Index(name = "xxx", columnList = "hayvan_no") })
public class Hissedarlar implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "hissedar_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "isim")
	private String isim;

	@Column(name = "isim2")
	private String isim2;
	@Column(name = "isim3")
	private String isim3;
	@Column(name = "isim4")
	private String isim4;
	@Column(name = "isim5")
	private String isim5;
	@Column(name = "isim6")
	private String isim6;
	@Column(name = "isim7")
	private String isim7;
	@Column(name = "referans")
	private String referans;
	@Column(name = "referans2")
	private String referans2;
	@Column(name = "referans3")
	private String referans3;
	@Column(name = "referans4")
	private String referans4;
	@Column(name = "referans5")
	private String referans5;
	@Column(name = "referans6")
	private String referans6;
	@Column(name = "referans7")
	private String referans7;

	@Column(name = "tel_no")
	private String telNo;
	@Column(name = "tel_no2")
	private String telNo2;
	@Column(name = "tel_no3")
	private String telNo3;
	@Column(name = "tel_no4")
	private String telNo4;
	@Column(name = "tel_no5")
	private String telNo5;
	@Column(name = "tel_no6")
	private String telNo6;
	@Column(name = "tel_no7")
	private String telNo7;

	@Column(name = "hisse")
	private int hissesi;
	@Column(name = "hisse2")
	private int hissesi2;
	@Column(name = "hisse3")
	private int hissesi3;
	@Column(name = "hisse4")
	private int hissesi4;
	@Column(name = "hisse5")
	private int hissesi5;
	@Column(name = "hisse6")
	private int hissesi6;
	@Column(name = "hisse7")
	private int hissesi7;

	@Column(name = "hayvan_no")
	private Long hayvanNo;

	@Column(name = "fiyati")
	private int satisFiyati;

	@Column(name = "hisseye_dusen_miktar")
	private int hisseFiyati;
	@Column(name = "hisseye_dusen_miktar2")
	private int hisseFiyati2;
	@Column(name = "hisseye_dusen_miktar3")
	private int hisseFiyati3;
	@Column(name = "hisseye_dusen_miktar4")
	private int hisseFiyati4;
	@Column(name = "hisseye_dusen_miktar5")
	private int hisseFiyati5;
	@Column(name = "hisseye_dusen_miktar6")
	private int hisseFiyati6;
	@Column(name = "hisseye_dusen_miktar7")
	private int hisseFiyati7;

	@Column(name = "kesimsirasi")
	private int sira;

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

	public String getIsim2() {
		return isim2;
	}

	public void setIsim2(String isim2) {
		this.isim2 = isim2;
	}

	public String getIsim3() {
		return isim3;
	}

	public void setIsim3(String isim3) {
		this.isim3 = isim3;
	}

	public String getIsim4() {
		return isim4;
	}

	public void setIsim4(String isim4) {
		this.isim4 = isim4;
	}

	public String getIsim5() {
		return isim5;
	}

	public void setIsim5(String isim5) {
		this.isim5 = isim5;
	}

	public String getIsim6() {
		return isim6;
	}

	public void setIsim6(String isim6) {
		this.isim6 = isim6;
	}

	public String getIsim7() {
		return isim7;
	}

	public void setIsim7(String isim7) {
		this.isim7 = isim7;
	}

	public String getReferans() {
		return referans;
	}

	public void setReferans(String referans) {
		this.referans = referans;
	}

	public String getReferans2() {
		return referans2;
	}

	public void setReferans2(String referans2) {
		this.referans2 = referans2;
	}

	public String getReferans3() {
		return referans3;
	}

	public void setReferans3(String referans3) {
		this.referans3 = referans3;
	}

	public String getReferans4() {
		return referans4;
	}

	public void setReferans4(String referans4) {
		this.referans4 = referans4;
	}

	public String getReferans5() {
		return referans5;
	}

	public void setReferans5(String referans5) {
		this.referans5 = referans5;
	}

	public String getReferans6() {
		return referans6;
	}

	public void setReferans6(String referans6) {
		this.referans6 = referans6;
	}

	public String getReferans7() {
		return referans7;
	}

	public void setReferans7(String referans7) {
		this.referans7 = referans7;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getTelNo2() {
		return telNo2;
	}

	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
	}

	public String getTelNo3() {
		return telNo3;
	}

	public void setTelNo3(String telNo3) {
		this.telNo3 = telNo3;
	}

	public String getTelNo4() {
		return telNo4;
	}

	public void setTelNo4(String telNo4) {
		this.telNo4 = telNo4;
	}

	public String getTelNo5() {
		return telNo5;
	}

	public void setTelNo5(String telNo5) {
		this.telNo5 = telNo5;
	}

	public String getTelNo6() {
		return telNo6;
	}

	public void setTelNo6(String telNo6) {
		this.telNo6 = telNo6;
	}

	public String getTelNo7() {
		return telNo7;
	}

	public void setTelNo7(String telNo7) {
		this.telNo7 = telNo7;
	}

	public int getHissesi() {
		return hissesi;
	}

	public void setHissesi(int hissesi) {
		this.hissesi = hissesi;
	}

	public int getHissesi2() {
		return hissesi2;
	}

	public void setHissesi2(int hissesi2) {
		this.hissesi2 = hissesi2;
	}

	public int getHissesi3() {
		return hissesi3;
	}

	public void setHissesi3(int hissesi3) {
		this.hissesi3 = hissesi3;
	}

	public int getHissesi4() {
		return hissesi4;
	}

	public void setHissesi4(int hissesi4) {
		this.hissesi4 = hissesi4;
	}

	public int getHissesi5() {
		return hissesi5;
	}

	public void setHissesi5(int hissesi5) {
		this.hissesi5 = hissesi5;
	}

	public int getHissesi6() {
		return hissesi6;
	}

	public void setHissesi6(int hissesi6) {
		this.hissesi6 = hissesi6;
	}

	public int getHissesi7() {
		return hissesi7;
	}

	public void setHissesi7(int hissesi7) {
		this.hissesi7 = hissesi7;
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

	public int getHisseFiyati() {
		return hisseFiyati;
	}

	public void setHisseFiyati(int hisseFiyati) {
		this.hisseFiyati = hisseFiyati;
	}

	public int getHisseFiyati2() {
		return hisseFiyati2;
	}

	public void setHisseFiyati2(int hisseFiyati2) {
		this.hisseFiyati2 = hisseFiyati2;
	}

	public int getHisseFiyati3() {
		return hisseFiyati3;
	}

	public void setHisseFiyati3(int hisseFiyati3) {
		this.hisseFiyati3 = hisseFiyati3;
	}

	public int getHisseFiyati4() {
		return hisseFiyati4;
	}

	public void setHisseFiyati4(int hisseFiyati4) {
		this.hisseFiyati4 = hisseFiyati4;
	}

	public int getHisseFiyati5() {
		return hisseFiyati5;
	}

	public void setHisseFiyati5(int hisseFiyati5) {
		this.hisseFiyati5 = hisseFiyati5;
	}

	public int getHisseFiyati6() {
		return hisseFiyati6;
	}

	public void setHisseFiyati6(int hisseFiyati6) {
		this.hisseFiyati6 = hisseFiyati6;
	}

	public int getHisseFiyati7() {
		return hisseFiyati7;
	}

	public void setHisseFiyati7(int hisseFiyati7) {
		this.hisseFiyati7 = hisseFiyati7;
	}

	public int getSira() {
		return sira;
	}

	public void setSira(int sira) {
		this.sira = sira;
	}

	public Date getIslamzamani() {
		return islamzamani;
	}

	public void setIslamzamani(Date islamzamani) {
		this.islamzamani = islamzamani;
	}

}
