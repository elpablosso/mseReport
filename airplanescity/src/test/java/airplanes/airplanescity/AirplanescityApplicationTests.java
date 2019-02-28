package airplanes.airplanescity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AirlinesConfig.class)
@SpringBootTest
public class AirplanescityApplicationTests {

	@Autowired
	private Airplanes airplanes;
	@Autowired
	private Cities cities;

	@Test
	public void airplanesMustNotBeNull() {
		assertNotNull(airplanes.airplanes.get(1));
	}
	@Test
	public void citiesMustNotBeNull() {
		assertNotNull(airplanes.airplanes.get(1));
	}
	@Test
	public void airplaneShouldFlyToLocation() {
		airplanes.airplanes.get(1).flyToLocation(cities.cities.get(2));
		assertTrue(airplanes.airplanes.get(1).getLocationX()==cities.cities.get(2).getLocationX()
		&& airplanes.airplanes.get(1).getLocationY()==cities.cities.get(2).getLocationY());
	}
}
