//Single Linked List
package ass4;
import java.util.Scanner;
class Node{
	protected int regd_no;
	protected float mark;
	protected Node next;
}
class InputMismatchException extends Exception{
	InputMismatchException(String msg){
		super(msg);
	}
}
class LinkedList{
	public Scanner sc = new Scanner(System.in);
	void create(Node start) {
		Node p = start;
		System.out.println("Enter Registration No:");
		p.regd_no = sc.nextInt();
		System.out.println("Enter mark:");
		p.mark = sc.nextFloat();
		p.next = null;
		Node q = p;
		char ch = 'y';
		l1:while(true) {
			System.out.println("Do you want to continue?(y/n)");
			ch = sc.next().charAt(0);
			if(ch=='n') {
				System.out.println("Data uploaded Successfuly!");
				break;
			}
			if(ch!='y'&&ch!='n') {
				try {
				throw new InputMismatchException("Enter only 'y' or 'n'!");
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Try Again!");
				continue l1;
			}
		  }
			p = new Node();
			System.out.println("Enter Registration No:");
			p.regd_no = sc.nextInt();
			System.out.println("Enter mark:");
			p.mark = sc.nextFloat();
			q.next = p;
			q = p;
			
		}
	}
	void display(Node start) {
		Node p = start;
		while(p!=null) {
			System.out.print("["+p.mark+"]->");
			p = p.next;
		}
		System.out.println("END");
	}
	Node InsBeg(Node start) {
		Node p = new Node();
		System.out.println("Enter Registration No:");
		p.regd_no = sc.nextInt();
		System.out.println("Enter mark:");
		p.mark = sc.nextFloat();
		p.next = start;
		start = p;
		return start;
	}
	Node InsEnd(Node start) {
		Node p = start;
		while(p.next!=null) {
			p = p.next; //For going to next node
		}
		Node q = new Node();
		System.out.println("Enter Registration No:");
		q.regd_no = sc.nextInt();
		System.out.println("Enter mark:");
		q.mark = sc.nextFloat();
		q.next = null;
		p.next = q;
		return start;
	}
	Node InsAny(Node start) {
		Node p = start;
		System.out.println("Enter the position of the node:");
		int n = sc.nextInt();
		for(int i = 1; i<n-1; i++) {
			p = p.next;
		}
		Node q = new Node();
		System.out.println("Enter Registration No:");
		q.regd_no = sc.nextInt();
		System.out.println("Enter mark:");
		q.mark = sc.nextFloat();
		q.next = p.next;
		p.next = q;
		return start;
	}
	Node DelBeg(Node start) {
		start = start.next;
		return start;
	}
	Node DelEnd(Node start) {
		Node p = start;
		while(p.next.next!=null) {
			p = p.next;
		}
		p.next = null;
		return start;
	}
	Node DelAny(Node start) {
		Node p = start;
		System.out.println("Enter the position of the node:");
		int n = sc.nextInt();
		for(int i = 1; i<n-1; i++) {
			p = p.next;
		}
		p.next = p.next.next;
		return start;
	}
	Node DelReg(Node start){
		Node p = start;
		System.out.println("Enter Registration No to Delete:");
		int regd = sc.nextInt();
		while(p!=null) {
			if(p.next.regd_no==regd) {
				p.next = p.next.next;
				break;
			}
			p = p.next;
		}
		return start;
	}
	void search(Node start) { 
		Node p = start;

		System.out.println("Enter Registration No. to Search:");
		int regd = sc.nextInt();
		while(p!=null) {
			if(p.regd_no==regd) {
				System.out.println("Enter Mark to Update:");
				p.mark = sc.nextFloat();
				return;
			}
			p = p.next;
		}
		System.out.println("Registration No. not found in the given data!");
	}
	 void sort(Node start) { 
		Node temp1 = start;
		while(temp1.next!=null) {
			Node temp2 = temp1.next;
			while(temp2!=null) {
				if(temp1.mark<temp2.mark) { //change  '<' or '>' sign to make it Decreasing(Increasing)
					float temp = temp1.mark;
					temp1.mark = temp2.mark;
					temp2.mark = temp;
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
		
	 }
	int count(Node start) {
		int c = 0;
		Node p = start;
		while(p!=null) {
			c++;
			p = p.next;
		}
		return c;
	}
    Node reverse(Node start) {
		Node prev = null;
		Node curr = start;
		Node nextNode;
		while(curr!=null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		start = prev;
		return start;
	}
}
public class SinglyLinkedList {
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Node head = new Node();
	LinkedList list = new LinkedList();
	byte choice = Byte.MAX_VALUE;
	while(true) {
		System.out.println("****MENU*****"
	    					+"\n0:Exit"
	    					+"\n1:Creation"
	    					+"\n2:Display"
	    					+"\n3:Insert at Beginning"
	    					+"\n4:Insert at End"
	    					+"\n5:Insert at any Position"
	    					+"\n6:Delete at Beginning"
	    					+"\n7:Delete at End"
	    					+"\n8:Delete at Any Position"
	    					+"\n9:Delete using Registration No. Searching"
	    					+"\n10:Search and Update Mark using Registration No."
	    					+"\n11:Sort data in decreasing order"
	    					+"\n12:Get number of Students"
	    					+"\n13:Reverse data"
	    					+"\nEnter the choice:");
	    if(sc.hasNextByte()) {
	    	choice = sc.nextByte();
	    }else{
	    	System.out.println("Enter values from 0-13 in digits only!");
	    	sc.next();
	    }
	    switch(choice) {
	    	case 0:	System.out.println("Program exiting! Thanks for using!");
	    			System.exit(0);
	    	case 1:	list.create(head);
	    			break;
	    	case 2:	list.display(head); 
	    			System.out.println();
	    			break;
	    	case 3: head = list.InsBeg(head);
	    			break;
	    	case 4: head = list.InsEnd(head);
	    			break;
	    	case 5: head = list.InsAny(head);
	    			break;
	    	case 6: head = list.DelBeg(head);
	    			break;
	    	case 7: head = list.DelEnd(head);
	    			break;
	    	case 8: head = list.DelAny(head);
	    			break;
	    	case 9: head = list.DelReg(head);
	    			break;
	    	case 10:list.search(head);
	    			break;
	    	case 11:list.sort(head);
	    			break;
	    	case 12:System.out.println("Number of Students:"+list.count(head));
	    	        break;
	    	case 13:head = list.reverse(head);
	    			break;
	    	default: System.out.println("Wrong Choice!");
	    			 System.out.println("Enter values from 0-13 in digits only!");
	    }  
	}
}
}
 