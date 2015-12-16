package entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="renters")
public class Renters {
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String surname;

	@Column(name="phone_number")
	private int phoneNumber;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="renter")
	private List<Rooms> rooms;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "renter")
	private List<RentTerms> rentTerms;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}

	public List<RentTerms> getRentTerms() {
		return rentTerms;
	}

	public void setRentTerms(List<RentTerms> rentTerms) {
		this.rentTerms = rentTerms;
	}
}
