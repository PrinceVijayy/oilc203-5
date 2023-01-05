package com.ojas.bms.dao;

import java.util.List;

import com.ojas.bms.model.Bus;

public interface BusDAO {
	
	public List<Bus> viewAllBuses();
	public Bus viewBus(int busId);
	
	public boolean createBus(Bus bus) ;
	public boolean updateBus(Bus bus, int busId);
	public boolean deleteBus(int busId);

}
