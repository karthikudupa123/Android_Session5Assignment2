//package mypack;
import java.util.Arrays;
interface Stack
{
	void push(int i);
	int pop();
	void display();
}

class FixedStack implements Stack
{
	private int stack[];
	private int tos;
	
	//parameterized constructor
	FixedStack(int size)
	{
		stack=new int[size];
		tos=-1;
	}
	
	public void push(int i)
	{
		if(tos==stack.length-1)
			System.out.println("Stack Overflow");
		else
			stack[++tos]=i;
	}
	public int pop()
	{
		if(tos<0)
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else
			return stack[tos--];
	}

	public void display()
	{
		for(int i=stack.length-1;i>=0;i--)
			System.out.println(stack[i]);
	}
}

class VariableStack implements Stack
{
	private int stack[];
	private int tos;

	VariableStack(int size)
	{
		stack=new int[size];
		tos=-1;
	}

	public void push(int i)
	{

		if(tos==stack.length-1)
			extendStack();
		stack[++tos]=i;
	}
	public int pop()
	{
			if(tos<0)
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else
			return stack[tos--];
	}

	public void extendStack()
	{
	
		//creating new temporary array with double size to avoid multiple expansion
		int[] newArray = new int[stack.length*2];
    		System.arraycopy(stack, 0, newArray, 0, stack.length);

   		 stack = newArray;
	}

	public void display()
	{
		for(int i=stack.length-1;i>=0;i--)
			System.out.println(stack[i]);
	}

}


public class Assgn5_2
{
	public static void main(String [] args)
	{
		FixedStack fs 	=new FixedStack(5);
		VariableStack vs=new VariableStack(5);
		for(int i=0;i<10;i++)
		{
			fs.push(i);
			vs.push(i);
		}
		System.out.println("Printing FixedStack");
		fs.display();
		System.out.println("Printing VariableStack");
		vs.display();

	}
}
