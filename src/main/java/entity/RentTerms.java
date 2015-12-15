package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name="rent_terms")
public class RentTerms {
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="start_date")
	private Date startDate;

	@Column(name="finish_date")
	private Date finishDate;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Rooms room;

	@ManyToOne
	@JoinColumn(name = "renter_id")
	private Renters renter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public LocalDate getFinishDate() {
		return finishDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = Date.from(finishDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public Renters getRenter() {
		return renter;
	}

	public void setRenter(Renters renter) {
		this.renter = renter;
	}
}
