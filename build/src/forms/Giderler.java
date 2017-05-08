package forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "giderler", schema = "public")
public class Giderler implements java.io.Serializable {
	private static final long serialVersionUID = 4418029727139184238L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "tabloSequnce", sequenceName = "giderler_id_seq")
	@GeneratedValue(generator = "tabloSequnce")
	private long id;

	@Column(name = "yem")
	private Long yem;

	@Column(name = "saman")
	private Long saman;

	@Column(name = "kasap")
	private Long kasap;

	@Column(name = "demirbas")
	private Long demirbas;

	@Column(name = "coban")
	private Long coban;

	@Column(name = "muhtelif")
	private Long muhtelif;

	@Column(name = "hayvan_cinsi")
	private int cins;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getYem() {
		return yem;
	}

	public void setYem(Long yem) {
		this.yem = yem;
	}

	public Long getSaman() {
		return saman;
	}

	public void setSaman(Long saman) {
		this.saman = saman;
	}

	public Long getKasap() {
		return kasap;
	}

	public void setKasap(Long kasap) {
		this.kasap = kasap;
	}

	public Long getDemirbas() {
		return demirbas;
	}

	public void setDemirbas(Long demirbas) {
		this.demirbas = demirbas;
	}

	public Long getCoban() {
		return coban;
	}

	public void setCoban(Long coban) {
		this.coban = coban;
	}

	public Long getMuhtelif() {
		return muhtelif;
	}

	public void setMuhtelif(Long muhtelif) {
		this.muhtelif = muhtelif;
	}

	public int getCins() {
		return cins;
	}

	public void setCins(int cins) {


		this.cins = cins;
	}

}
