package Assignment2;

/**
 * A generic class that implements the methods from a generic interface, uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from the container.
 * @author Moe Diakite
 *
 * @param <T>
 */
public class Container<T> implements ContainerInterface<T> {
	private MyStack<T> donations;
	/**
	 * A no arg constructor that creates a container of default size
	 */
	
	/**
	 * A constructor that accepts an int argument, which represents the value that will determine the size
	 * of the stack in the container
	 * @param size
	 */
	public Container(int size) {
		@SuppressWarnings("unchecked")
		MyStack<T> copy = new MyStack<T>(size);
		donations = copy;
	}
	/**
	 * Stacks a new donation package  in to the container
	 * @param donationPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(T donationPackage) throws ContainerException{
		if(donations.push(donationPackage) == true) {
			return true;
		}
		else if(donations.push(donationPackage) == false) {
			throw new ContainerException("The container is full");
		}
		return true;
	};
	
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public  T removePackageFromContainer() throws ContainerException{
		T top = donations.pop();
		if(top == null) {
			throw new ContainerException("The container is currently empty");
		}
		return top;
		
	};
	/**
	 * A method that returns the size of the container 
	 * @return the size of the container stack
	 */
	public int getSize() {
		return donations.size();
	}
	
	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	public DonationPackage[] toArrayPackage() throws ContainerException{ 
		if(donations.size() >= 0) {
			@SuppressWarnings("unchecked")
			T[] copyArray =  donations.toArray();
			DonationPackage[] donationsArray = new DonationPackage[donations.size()];
			for(int i = 0; i < donationsArray.length; i++) {
				donationsArray[i] = (DonationPackage) copyArray[i];
			}
			return donationsArray;
		}
		else {
			throw new ContainerException("The container has no items");
		}
		
	};
}
