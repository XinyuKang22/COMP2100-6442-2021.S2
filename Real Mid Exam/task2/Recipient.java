
public class Recipient {

	public Recipient() {
	}

	public void receive(Parcel parcel) {
		// TODO
		// START YOUR CODE
		if (!parcel.getRecipient().equals(this)){
			parcel.setStatus(State.RETURNED);
		}else {
			parcel.setStatus(State.DELIVERED);
		}
		// END YOUR CODE
	}
}
