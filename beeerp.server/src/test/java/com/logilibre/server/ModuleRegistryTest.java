package com.logilibre.server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.logilibre.module.timesheet.Module;

public class ModuleRegistryTest {

	private ModuleRegistry moduleRegistry;

	@Before
	public void setup(){
		moduleRegistry = new ModuleRegistry();
		moduleRegistry.add(new Module());
	}
	
	@Test
	public void test() {
		assertEquals("timesheet", moduleRegistry.get("timesheet").getName());
	}

}
