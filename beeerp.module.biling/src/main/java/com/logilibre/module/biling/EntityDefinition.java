package com.logilibre.module.biling;

import java.util.List;

public class EntityDefinition {

	static protected class Client {
		String name;
		String email;


	}

	static protected class Bill {
		Client client;
		List<BillItem> billItems;
		//@Calculated(TotalCalcule.class)
		double total;
		boolean sent;
		boolean paid;

	}

	static protected class BillItem {
		String name;
		//@Min(0)
		double price;
	}
}
