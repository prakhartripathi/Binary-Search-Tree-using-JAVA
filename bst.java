import java.util.Scanner;
class node{
	int data;
	node left;
	node right; 
}
class bst{
	static node root;
	static int flag=0;
	static Scanner input = new Scanner(System.in);
	
	static void insert(node curr,node a){       
		if(a.data<curr.data){
			if(curr.left==null){
				curr.left = a;
			}else{
				curr = curr.left;
				insert(curr,a);
			}
		}else{
			if(curr.right==null)
				curr.right = a;
			else{
				curr = curr.right;
				insert(curr,a);
			}
		}
	} 
	
	static void insertion(){
		node newnode = new node();
		newnode.data = input.nextInt();
		newnode.left = newnode.right = null;
		if(root==null){
			root = newnode;		
		}else{
			insert(root,newnode);
		}
	}  

	static void printInPre(node curr){			//printing in PREFIX order
		System.out.print(" "+curr.data);
		if(curr.left!=null){
			printInPre(curr.left);
		}
		if(curr.right!=null){
			printInPre(curr.right);
		}

	}

	static void printInInfix(node curr){		//printing in INFIX order
		if(curr.left!=null){
			printInInfix(curr.left);
		}
		System.out.print(" "+curr.data);
		if(curr.right!=null){
			printInInfix(curr.right);
		}
	}

	static void printInPost(node curr){			//printing in POSTFIX order
		if(curr.left!=null){
			printInPost(curr.left);
		}
		if(curr.right!=null){
			printInPost(curr.right);
		}
		System.out.print(" "+curr.data);
	}

	static void search(node curr,int a){					//searching element
		if(curr.data == a){
			flag=1;
		}else{
			if(a<curr.data){
				if(curr.left!=null){
					search(curr.left,a);
				}
			}
			else{
				if(curr.right!=null){
					search(curr.right,a);
				}
			}
	}
}

	public static void main(String args[]){
		char ch;
		int choice;
	
	do{
	System.out.println("1. Insert element\n2. Display\n3. Search");
	System.out.print("choice = ");
	choice = input.nextInt();
	switch(choice){
		case 1:
			System.out.print("Enter the number = ");
			insertion();
			break;
		case 2: if(root!=null){
					System.out.print(" \nPREFIX = ");
					printInPre(root);
					System.out.print(" \nINFIX  = ");
					printInInfix(root);
					System.out.print(" \nPOSTFIX= ");
					printInPost(root);
				}else{
					System.out.println("\n>>>> Empty tree <<<<");
				}
			break;
		case 3:
			if(root!=null){
					System.out.println("Enter the element you want to search=");
					int element = input.nextInt();
					search(root,element);
					if(flag==1){
						System.out.println(">>>>> element found <<<<");
					}else{
						System.out.println(">>> NOT FOUND <<<<");
					}
			}else{
				System.out.println("\n>>>> Empty tree <<<<");
			}
			break;
		default:
			System.out.println(">>> WRONG CHOICE <<<");
			break;
	}
	System.out.print("\n\nDo you want to perform more operation? = ");
		ch = input.next().charAt(0);
	}while(ch=='Y'||ch=='y');
}
}