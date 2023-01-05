package com.ojas.bms.service;

import java.util.List;

import com.ojas.bms.model.Bus;

public interface BusService {
	public List<Bus> viewAllBuses();

	public Bus viewBus(int busId);

	public boolean createBus(Bus bus);

	public boolean updateBus(Bus bus, int busId);

	public boolean deleteBus(int busId);

}
