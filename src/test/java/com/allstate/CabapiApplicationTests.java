package com.allstate;

import com.allstate.services.CarServiceTest;
import com.allstate.services.CityServiceTest;
import com.allstate.services.DriverServiceTest;
import com.allstate.services.PassengerServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		CityServiceTest.class,
        CarServiceTest.class,
        DriverServiceTest.class,
        PassengerServiceTest.class
})
public class CabapiApplicationTests {

	@Test
	public void contextLoads() {
	}
}
