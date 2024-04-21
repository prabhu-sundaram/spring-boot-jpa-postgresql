package com.dm.springbootjpapostgresql.example.collectionPkg;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class collection1 {

	public static void main(String[] args) {
		System.out.println("-------List Interface--------");
		System.out.println("-------ArrayList--------");
		ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
		list.add("Ravi");//Adding object in arraylist  
		list.add("Vijay");  
		list.add("Ravi");  
		list.add("Ajay");  
		//Traversing list through Iterator  
		Iterator itr=list.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}
		
		System.out.println("-------LinkedList--------");
		
		LinkedList<String> al=new LinkedList<String>();  
		al.add("Ravi");  
		al.add("Vijay");  
		al.add("Ravi");  
		al.add("Ajay");  
		Iterator<String> itr2=al.iterator();  
		while(itr2.hasNext()){  
		System.out.println(itr2.next());  
		}
		System.out.println("-------Vector--------");
		Vector<String> v=new Vector<String>();  
		v.add("Ayush");  
		v.add("Amit");  
		v.add("Ashish");  
		v.add("Garima");  
		Iterator<String> itr3=v.iterator();  
		while(itr3.hasNext()){  
		System.out.println(itr3.next());  
		}  		
		 		
		
		System.out.println("-------Stack--------");
		Stack<String> stack = new Stack<String>();  
		stack.push("Ayush");  
		stack.push("Garvit");  
		stack.push("Amit");  
		stack.push("Ashish");  
		stack.push("Garima");  
		stack.pop();  
		Iterator<String> itr4=stack.iterator();  
		while(itr4.hasNext()){  
		System.out.println(itr4.next());  
		}  
		
		System.out.println("-------Queue Interface--------");
		System.out.println("-------PriorityQueue--------");
		PriorityQueue<String> queue=new PriorityQueue<String>();  
		queue.add("Amit Sharma");  
		queue.add("Vijay Raj");  
		queue.add("JaiShankar");  
		queue.add("Raj");  
		System.out.println("head:"+queue.element());  
		System.out.println("head:"+queue.peek());  
		System.out.println("iterating the queue elements:");  
		Iterator itr5=queue.iterator();  
		while(itr5.hasNext()){  
		System.out.println(itr5.next());  
		}  
		queue.remove();  
		queue.poll();  
		System.out.println("after removing two elements:");  
		Iterator<String> itr6=queue.iterator();  
		while(itr6.hasNext()){  
		System.out.println(itr6.next());  
		}  
		
		System.out.println("-------Deque Interface--------");
		System.out.println("-------ArrayDeque--------");		
		//Creating Deque and adding elements  
		Deque<String> deque = new ArrayDeque<String>();  
		deque.add("Gautam");  
		deque.add("Karan");  
		deque.add("Ajay");  
		//Traversing elements  
		for (String str : deque) {  
		System.out.println(str);  
		} 		
		
		System.out.println("-------Set Interface--------");
		System.out.println("-------HashSet--------");
		//Creating HashSet and adding elements  
		HashSet<String> set=new HashSet<String>();  
		set.add("Ravi");  
		set.add("Vijay");  
		set.add("Ravi");  
		set.add("Ajay");  
		//Traversing elements  
		Iterator<String> itr7=set.iterator();  
		while(itr7.hasNext()){  
		System.out.println(itr7.next());  
		}  		
		
		System.out.println("-------LinkedHashSet--------");
		
		LinkedHashSet<String> set2=new LinkedHashSet<String>();  
		set2.add("Ravi");  
		set2.add("Vijay");  
		set2.add("Ravi");  
		set2.add("Ajay");  
		Iterator<String> itr8=set.iterator();  
		while(itr8.hasNext()){  
		System.out.println(itr8.next());  
		}  		
		
		System.out.println("-------SortedSet Interface--------");
		System.out.println("-------TreeSet--------");	
		
		//Creating and adding elements  
		TreeSet<String> set3=new TreeSet<String>();  
		set3.add("Ravi");  
		set3.add("Vijay");  
		set3.add("Ravi");  
		set3.add("Ajay");  
		//traversing elements  
		Iterator<String> itr9=set.iterator();  
		while(itr9.hasNext()){  
		System.out.println(itr9.next());  
		}
		
		
	}

}
