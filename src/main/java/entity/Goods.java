package entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="goods")
public class Goods {
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private int amount;

	@Column(name="measure_value")
	private String measureValue;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Rooms room;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="goods")
	private List<Circulation> circulations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMeasureValue() {
		return measureValue;
	}

	public void setMeasureValue(String measureValue) {
		this.measureValue = measureValue;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public List<Circulation> getCirculations() {
		return circulations;
	}

	public void setCirculations(List<Circulation> circulations) {
		this.circulations = circulations;
	}

}
