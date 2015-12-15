package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int size;

	@Column(name="room_number")
	private int roomNumber;

	@ManyToOne
	@JoinColumn(name = "renter_id")
	private Renters renter;

	@OneToMany(mappedBy="room")
	private List<Goods> goods;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Renters getRenter() {
		return renter;
	}

	public void setRenter(Renters renter) {
		this.renter = renter;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
}
