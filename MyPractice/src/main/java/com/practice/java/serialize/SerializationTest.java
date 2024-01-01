package com.practice.java.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {

	public static void main(String[] args) {
		 try{    
			  //Creating the object    
			 Employee e1 =new Employee();
			 e1.setId(12);
			 Address a = new Address();
			 a.setCity("bng");
			 e1.setAddress(a);
			  //Creating stream and writing the object    
			  FileOutputStream fout=new FileOutputStream("f.txt");    
			  ObjectOutputStream out=new ObjectOutputStream(fout);    
			  out.writeObject(e1);    
			  out.flush();    
			  //closing the stream    
			  out.close();    
			  System.out.println("success");    
			  }catch(Exception e){System.out.println(e);}    
			   
	
	 try{  
		  //Creating stream to read the object  
		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		  Employee e=(Employee)in.readObject();  
		  //printing the data of the serialized object  
		  System.out.println(e.id+" "+e.getAddress().city);  
		  //closing the stream  
		  in.close();  
		  }catch(Exception e){
			  System.out.println(e);
		  }  
		 }  
	
}	
	class Employee implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int id;
		
		transient Address address;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		
	}
	
	class Address {
		String city;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
	}

