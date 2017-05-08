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
@Table(name = "odemegecmisi2", schema = "public")
public class OdemeGecmisi2 implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "odemegecmisi2_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "isim")
	private String isim;

	@Column(name = "odeme_tutari")
	private int odenen;

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

	public int getOdenen() {
		return odenen;
	}

	public void setOdenen(int odenen) {
		this.odenen = odenen;
	}

	public Date getOdemezamani() {
		return odemezamani;
	}

	public void setOdemezamani(Date odemezamani) {
		this.odemezamani = odemezamani;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "odemezamani")
	private Date odemezamani;
}
