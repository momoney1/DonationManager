package Assignment2;

/**
 * DonationManager class contains the operation of adding a new package to the container stack, adding a new volunteer to the
 * volunteer line, adding a new recipient to the recipient line and donating a package from the container by the volunteer to the recipient
 * @author Moe Diakite
 *
 * @param <T>
 */
public class DonationManager<T> implements DonationManagerInterface{
	@SuppressWarnings("unchecked")
	private VolunteerLine<Volunteer> volunteers = (VolunteerLine)new VolunteerLine(5);
	private RecipientLine<Recipient> recipients = (RecipientLine)new RecipientLine(5);
	private Container<DonationPackage> donations = (Container)new Container(5);
	private DonationPackage donationObject;
	private Volunteer volunteerObject;
	private Recipient recipientObject;
	
	private Volunteer[] volunteerArray;
	private Recipient[] recipientsArray;
	private DonationPackage[] donationsArray;
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked
	 * @throws ContainerException if container is full
	 */
	public boolean managerLoadContainer(DonationPackage dPackage) throws  ContainerException{
		donations.loadContainer(dPackage);
		return true;
	}
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	public  boolean  managerQueueVolunteer(Volunteer  v) throws  VolunteerException{
		volunteers.addNewVolunteer(v);
		return true;
	}
	
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully 
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	public boolean managerQueueRecipient(Recipient r) throws  RecipientException{
		recipients.addNewRecipient(r);
		return true;
	}
	
	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
	public  int donatePackage() {
	   donationObject = donations.removePackageFromContainer();
	   volunteerObject = volunteers.volunteerTurn();
	   recipientObject = recipients.recipientTurn();
		return 0;
	}
	
	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	public DonationPackage[] managerArrayPackage() {
		DonationPackage[] container = donations.toArrayPackage(); //temp is a Container
		return container;
	}
	
	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	public Volunteer[] managerArrayVolunteer() {
		Volunteer[] volunteerArray = volunteers.toArrayVolunteer();
		return volunteerArray;
	}
	
	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	public Recipient[] managerArrayRecipient() {
		Recipient[] recipientArray = recipients.toArrayRecipient();
		return recipientArray;
	}
	/**
	 * A method that returns a message containing the name of the recently removed volunteer object and the
	 * name of the recipient it delivered the package to
	 */
	public String toString() {
		return volunteerObject.toString() + " Delivered " + donationObject.toString() + " package to "+ recipientObject.toString(); // connect this with the removed recipient.tostring
	}
}
