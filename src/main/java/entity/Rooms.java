package entity;

import java.util.List;

import javax.persistence.*;

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy="room")
	private List<Goods> goods;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="room")
	private List<RentTerms> rentTerms;

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

	public List<RentTerms> getRentTerms() {
		return rentTerms;
	}

	public void setRentTerms(List<RentTerms> rentTerms) {
		this.rentTerms = rentTerms;
	}
}
