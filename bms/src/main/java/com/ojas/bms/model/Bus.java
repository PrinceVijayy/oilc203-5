package com.ojas.bms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BUS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
	
	private int busId;
	private String busName;
	private int noOfSeats;
	private double ticketPrice;

}
