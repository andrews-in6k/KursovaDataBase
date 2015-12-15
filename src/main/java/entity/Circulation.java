package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;

@Entity
@Table(name="circulation")
public class Circulation {
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="change_date")
	private Date changeDate;

	@Column(name="change_amount")
	private int changeAmount;

	@Column(name = "new_or_not")
	private int newOrNot;

	@ManyToOne
	@JoinColumn(name = "goods_id")
	private Goods goods;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getChangeDate() {
		return changeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public void setChangeDate(LocalDate changeDate) {
		this.changeDate = Date.from(changeDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public int getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(int changeAmount) {
		this.changeAmount = changeAmount;
	}

	public int getNewOrNot() {
		return newOrNot;
	}

	public void setNewOrNot(int newOrNot) {
		this.newOrNot = newOrNot;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
