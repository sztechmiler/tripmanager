package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
		}

	@Test
	public void testFindByEmptyKeyWord() throws Exception {
		tripManager.add(trip);
		assertSame(trip, tripManager.findTrip(""));
		//		asser(tripManager.search("");
	}


	@Test
	public void testFindByKeyWord() throws Exception {
		Trip trip2 = new Trip("", "opis");
		tripManager.add(trip2);
		tripManager.add(trip);
		assertSame(trip, tripManager.findTrip("nazwa"));
		//		asser(tripManager.search("");
	}


	@Test
	public void testFindByDescriptionContain() throws Exception {
		Trip trip2 = new Trip("", "great trip description");
		tripManager.add(trip2);
		tripManager.add(trip);
		assertSame(trip2, tripManager.findTrip("trip"));
		//		asser(tripManager.search("");
	}

	@Test
	public void testFindByCommentDescription() throws Exception {
		Trip trip2 = new Trip("", "great trip description");
		Photo photo1 = new Photo("awsome comment");
		Photo photo2 = new Photo("awsome more comment");
		Photo photo3 = new Photo("awsomeest comment");
		trip.addPhotoo(photo3);
		tripManager.add(trip);
		trip2.addPhotoo(photo1);
		trip2.addPhotoo(photo2);
		tripManager.add(trip2);
		assertSame(trip2, tripManager.findTrip("more"));
		//		asser(tripManager.search("");
	}

	@Test
	public void testNotFindByCommentDescription() throws Exception {
		Trip trip2 = new Trip("", "great trip description");
		Photo photo1 = new Photo("awsome comment");
		Photo photo2 = new Photo("awsome more comment");
		Photo photo3 = new Photo("awsomeest comment");
		trip.addPhotoo(photo3);
		tripManager.add(trip);
		trip2.addPhotoo(photo1);
		trip2.addPhotoo(photo2);
		tripManager.add(trip2);
		assertNull(tripManager.findTrip("moree"));
		//		asser(tripManager.search("");
	}
}
