
public class TransportOffice {

	private static TransportOffice instance;

	private TransportOffice() {
	}

	public static TransportOffice getInstance() {

		// TODO
		// START YOUR CODE

		// YOU ARE ALLOWED TO CHANGE THIS RETURNED VALUE
		if (instance == null){
			instance = new TransportOffice();
		}
		return instance;

		// END YOUR CODE
	}

	public Transport transitBy(Parcel parcel) {

		// TODO
		// START YOUR CODE
		int days = parcel.getAllowedDays();
		int weight = parcel.getWeight();
		if (days >= 8 && weight <= 40){
			parcel.setStatus(State.IN_TRANSIT);
			return Transport.VAN;
		}
		if (days >= 6){
			parcel.setStatus(State.IN_TRANSIT);
			return Transport.TRAIN;
		}
		if (days >= 3 && weight <= 22){
			parcel.setStatus(State.IN_TRANSIT);
			return Transport.AIR_CARRIER;
		}
		parcel.setStatus(State.RETURNED);
		// YOU ARE ALLOWED TO CHANGE THIS RETURNED VALUE
		return null;
		// END YOUR CODE
	}
}
