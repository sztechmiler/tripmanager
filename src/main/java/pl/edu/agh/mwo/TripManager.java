package pl.edu.agh.mwo;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

	public Trip findTrip(String keyword) {
		if (keyword == "") { return tripList.entrySet().iterator().next().getValue();}
		else
		{
			for (Map.Entry<String,Trip>  t : tripList.entrySet())
			{
				if (t.getValue().getDescription().contains(keyword) || t.getKey().contains(keyword))
				{
					return t.getValue();
				} else
				{
					for (Photo photo: t.getValue().getPhotos()) {
						if (photo.getComment().contains(keyword)){
							return t.getValue();
						}
					}	
				}

			}
		}

		return null;
	}
}
