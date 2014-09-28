/**
 * 
 */
package com.ai.academicprojects.cannibalsandmissionaries;

/**
 * @author Dinesh Appavoo
 *
 */
public class State {

	public int noOfCannibalsLeft;
	public int noOfCannibalsRight;
	public int noOfMissionariesLeft;
	public int noOfMissionariesRight;
	public boolean isBoatInLeft;
	public State parent;
	public boolean visited;

	public State(int noOfCannibalsLeft,int noOfMissionariesLeft, int noOfCannibalsRight,  int noOfMissionariesRight, boolean isBoatInLeft,State parent)
	{
		this.noOfCannibalsLeft=noOfCannibalsLeft;
		this.noOfCannibalsRight=noOfCannibalsRight;
		this.noOfMissionariesLeft=noOfMissionariesLeft;
		this.noOfMissionariesRight=noOfMissionariesRight;
		this.isBoatInLeft=true;
		this.parent=parent;
		this.visited=false;
	}
	
	/**
	 * Method to verify whether the goal state is reached
	 * @param state
	 * @return
	 */
	public boolean isFinalStateReached()
	{
		return(		this.noOfCannibalsLeft==0
				&& this.noOfCannibalsRight==3
				&& this.noOfMissionariesLeft==0
				&& this.noOfMissionariesRight==3
			);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
