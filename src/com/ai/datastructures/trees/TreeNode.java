/**
 * 
 */
package com.ai.datastructures.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dinesh Appavoo
 *
 */
public class TreeNode<key, value> implements Iterable<key> {

	private Node root;
	private int N;
	class Node{
		public key key;
		public value value;
		boolean visited;
		ArrayList<Node> adjacencyList=null;

		public Node(key key, value value)
		{
			this.key=key;
			this.value=value;
			this.visited=false;
			this.adjacencyList=new ArrayList<Node>();
		}		

		public ArrayList<Node> getAdjacencyList()
		{
			return this.adjacencyList;
		}
	}

	public int getSize()
	{
		return N;
	}

	public void put(key key, value value, key parent)
	{
		if(parent==null)
		{
			root=new Node(null, null);
			root.adjacencyList.add(new Node(key, value));
			return;
		}
		Queue<Node> queue=new LinkedList<Node>();
		boolean keyExists=false;
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node n=queue.poll();
			if(n.key.equals(parent))
			{
				ArrayList<Node> adjacentList=n.getAdjacencyList();
				for(Node nd : adjacentList)
				{
					if(nd.equals(key))
					{
						nd.value=value;
						keyExists=true;
					}
				}
				if(!keyExists)
				{
					adjacentList.add(new Node(key, value));
				}
				break;
			}
			ArrayList<Node> adjList=n.getAdjacencyList();
			for(Node node : adjList)
			{
				queue.add(node);
			}
		}
	}

	public value get(key key)
	{
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node n=queue.poll();
			if(n.key.equals(key))
			{
				return n.value;
			}
			ArrayList<Node> adjList=n.getAdjacencyList();
			for(Node node : adjList)
			{
				queue.add(node);
			}
		}
		return null;
	}

	public value remove(key key)
	{
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		if(root.key.equals(key))
		{
			value tempValue=root.value;
			root=null;
			return tempValue;
		}
		while(!queue.isEmpty())
		{
			Node n=queue.poll();

			ArrayList<Node> adjList=n.getAdjacencyList();
			for(Node node : adjList)
			{
				if(node.key.equals(key))
				{
					value tempVal=node.value;
					n.adjacencyList.remove(node);
					return tempVal;
				}
				queue.add(node);
			}
		}
		return null;
	}

	public boolean contains(key key)
	{

		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		if(root.key.equals(key))
		{
			return true;
		}
		while(!queue.isEmpty())
		{
			Node n=queue.poll();

			ArrayList<Node> adjList=n.getAdjacencyList();
			for(Node node : adjList)
			{
				if(node.key.equals(key))
				{
					return true;
				}
				queue.add(node);
			}
		}

		return false;
	}

	@Override
	public Iterator<key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
