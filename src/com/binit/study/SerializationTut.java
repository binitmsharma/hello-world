package com.binit.study;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTut {

	public static void main(String args[])throws Exception{  
		CircleToRectangle s1 =new CircleToRectangle();  

		FileOutputStream fout=new FileOutputStream("f.txt");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  

		out.writeObject(s1);  
		out.flush();  
		System.out.println("success");  

		ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		CircleToRectangle s=(CircleToRectangle)in.readObject();  
		//System.out.println(s.id+" "+s.name);  

		in.close(); 
	}
}
