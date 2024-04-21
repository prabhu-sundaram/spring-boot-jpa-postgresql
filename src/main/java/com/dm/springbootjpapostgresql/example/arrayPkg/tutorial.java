package com.dm.springbootjpapostgresql.example.arrayPkg;

public class tutorial {

	static void printArray(int arr[]) {
		
		for(int j=0;j<arr.length;j++)
		{
		System.out.println(j+" "+arr[j]);
		}
	}
	static int[] getArray()
	{
		
	return new int []{1,3,5};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("ytest");
int b[]=new int[3];//declaration and instantiation  
b[0]=22;//initialization  
b[1]=343;
b[2]=2343;

for(int i=0;i<b.length;i++)
{
System.out.println(i +" " + b[i]);	
}
System.out.println("--------------");	

int a[]={1,3,4,6};//declaration, instantiation and initialization  

for(int i=0;i<a.length;i++)
{
System.out.println(i +" " + a[i]);	
}
System.out.println("--------------");
printArray(a);
System.out.println("--------------");

printArray(new int[]{10,22,44,66});//passing anonymous array to method  

	
	System.out.println("--------------");

	int c[]=getArray();
	for(int i=0;i<c.length;i++)
	{
	System.out.println(i +" " + c[i]);	
	}
	System.out.println("--------------");
}}
