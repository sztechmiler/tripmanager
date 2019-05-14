package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TripTest {

	@Test
	public void testConstructor() {
		Trip trip = new Trip("nazwa", "opis");
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

	@Test
	public void testAddingPhoto() {
		Trip trip = new Trip("nazwa", "opis");
		Photo photo = new Photo();
		trip.addPhotoo(photo);
		assertEquals(1, trip.getPhotos().size());
		assertEquals(photo, trip.getPhotos().get(0));
	}

}
