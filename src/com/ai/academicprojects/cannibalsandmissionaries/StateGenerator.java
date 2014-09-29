/**
 * 
 */
package com.ai.academicprojects.cannibalsandmissionaries;

import java.util.ArrayList;

/**
 * @author Dinesh Appvoo
 *
 */
public class StateGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}	

	/**
	 * Method to verify whether the new state is valid
	 * @param s
	 * @return
	 */
	public static boolean isValidState(State s) {
		if (
				s.noOfMissionariesLeft < 0 || s.noOfMissionariesRight < 0
				|| s.noOfCannibalsLeft < 0 || s.noOfCannibalsRight < 0
				
			) {
			return false;
		}
		
		
		if (
				(s.noOfCannibalsLeft > s.noOfMissionariesLeft && s.noOfMissionariesLeft > 0)
				|| (s.noOfCannibalsRight > s.noOfMissionariesRight && s.noOfMissionariesRight > 0)
				
			) {
			return false;
		}

		return true;
	}
	
	/**
	 * Method to generate successor states
	 * @param s
	 * @return
	 */
	public static ArrayList<State> generateNextLevelStates(State s)
	{
		State newState;
		ArrayList<State> successors = new ArrayList<State>();
		if (s.isBoatInLeft == true) {
			// Two missionaries cross left to right.
			newState = new State(s.noOfCannibalsLeft, s.noOfMissionariesLeft - 2,
					s.noOfCannibalsRight, s.noOfMissionariesRight + 2, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// Two cannibals cross left to right.
			newState = new State(s.noOfCannibalsLeft - 2, s.noOfMissionariesLeft,
					s.noOfCannibalsRight + 2, s.noOfMissionariesRight, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary and one cannibal cross left to right.
			newState = new State(s.noOfCannibalsLeft - 1,
					s.noOfMissionariesLeft - 1, s.noOfCannibalsRight + 1,
					s.noOfMissionariesRight + 1, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary crosses left to right.
			newState = new State(s.noOfCannibalsLeft, s.noOfMissionariesLeft - 1,
					s.noOfCannibalsRight, s.noOfMissionariesRight + 1, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One cannibal crosses left to right.
			newState = new State(s.noOfCannibalsLeft - 1, s.noOfMissionariesLeft,
					s.noOfCannibalsRight + 1, s.noOfMissionariesRight, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
		} else {
			// Two missionaries cross right to left.
			newState = new State(s.noOfCannibalsLeft, s.noOfMissionariesLeft + 2,
					s.noOfCannibalsRight, s.noOfMissionariesRight - 2, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// Two cannibals cross right to left.
			newState = new State(s.noOfCannibalsLeft + 2, s.noOfMissionariesLeft,
					s.noOfCannibalsRight - 2, s.noOfMissionariesRight, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary and one cannibal cross right to left.
			newState = new State(s.noOfCannibalsLeft + 1,
					s.noOfMissionariesLeft + 1, s.noOfCannibalsRight - 1,
					s.noOfMissionariesRight - 1, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary crosses right to left.
			newState = new State(s.noOfCannibalsLeft, s.noOfMissionariesLeft + 1,
					s.noOfCannibalsRight, s.noOfMissionariesRight - 1, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One cannibal crosses right to left.
			newState = new State(s.noOfCannibalsLeft + 1, s.noOfMissionariesLeft,
					s.noOfCannibalsRight - 1, s.noOfMissionariesRight, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
		}
		return successors;
	}

}
