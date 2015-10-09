/* CS-112 FINAL PROJECT
   File Name:          	PropertyList.java
   Programmer:         	James Watkins
   Date Last Modified: 	May 19, 2012

   Problem Statement: Define a class which uses ArrayList objects to
   manage multiple objects of class Item.  This class must be serializable
   and should also support text I/O operations.  This class will interface
   with a gui.
   
   Overall Plan:
   1. Provide constructors for creating ArrayLists of type Item.
   2. Include a means of copying one propertyList to another (included for
   good measure, not required for objectives).
   2. Define class specific methods which invoke ArrayList's methods add(),
   remove(), isEmpty(), clear(), get(), and size(). Overload the get() method
   so that it can be called with parameters int or Item.
   3. Create a method to calculate the total value of all assets using an
   enhanced for loop and invocations of Item's getPrice() and getQty().
   4. Override toString.
   5. Make the class serializable to support binary I/O operations.
  
   Classes needed and Purpose (Input, Processing, Output)
   NumberFormat - output
   String - input, output
*/
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.NumberFormat;
import java.io.Serializable;

public class PropertyList implements Serializable
{
	Scanner keyboard = new Scanner(System.in);
	ArrayList <Item> dataBase;
	PrintWriter textOutput;
	private ObjectOutputStream output;
	private ObjectInputStream inputStream = null;
	
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	public PropertyList()
	{
		dataBase = new ArrayList <Item>();
	}
	public PropertyList(int size)
	{
		dataBase = new ArrayList <Item>(size);
	}
	public void copyDataBase()
	{
		ArrayList<Item> newArrayList = new ArrayList<Item>(getDataBaseSize());
		
		for (Item element : dataBase)
		{
			newArrayList.add(element);
		}
	}
	//provide access to required ArrayList methods.
	public void addToDataBase(Item anItem)
	{
		dataBase.add(anItem);
	}
	public void removeFromDataBase(int theLocation)
	{
			dataBase.remove(theLocation);
	}
	public boolean listIsEmpty()
	{
		return dataBase.isEmpty();
	}
	public void clearDataBase()
	{
		dataBase.clear();
	}
	public int getDataBaseSize()
	{
		return dataBase.size();
	}
	public Item getItem(int location)
	{
		return dataBase.get(location);
	}
//	public Item getItem(Item anItem)
//	{
//		return anItem;
//	}
	public double getTotalValue()
	{
		double totalValue = 0;
	//method to calculate the current value of all assets	
		for (Item element : dataBase)
		{
			int aQuantity = element.getQty();
			if(aQuantity == 1)
				totalValue += element.getPrice();
			else
				totalValue += (element.getPrice() * aQuantity);
			
		}
		return totalValue;	
	}
	public int searchDataBase(String query)
	{
	//search by description, serialnumber, make and model
		int itemLocation = -1, i = 0;
		
		for(Item element : dataBase)
		{
			if (query.equalsIgnoreCase(element.getDescription())||
				query.equalsIgnoreCase(element.getSerial())||
				query.equalsIgnoreCase(element.getModel())||
				query.equalsIgnoreCase(element.getMake()))
			{
				itemLocation = i;
				break;
			}
			i++;	
		}
		//if query not found, a negative returned value can be filtered out
		return itemLocation;	
	}
	public void listAllRecords()
	{
		for(int i = 0; i < dataBase.size(); i++)
		{
			System.out.println(dataBase.get(i).toString());
		}
	}
	public void printTextFile(String fileName)
	{
		int item = 1;
		
		try
		{
			textOutput = new PrintWriter(new FileOutputStream(fileName));
	
			for(Item element : dataBase)
			{
//Item's toString didn't preserve formatting when passed through PrintWriter
				textOutput.println("Item Number "+item);
				textOutput.println("Description\t"+element.getDescription());
				textOutput.println("Manufacturer\t"+element.getMake());
				textOutput.println("Model Number\t"+element.getModel());
				textOutput.println("Serial Number\t"+element.getSerial());
				textOutput.println("Purchase Date\t"+element.getDate());
				textOutput.println("Purchase Price\t"+
										money.format(element.getPrice()));
				textOutput.println("Quantity Avail.\t"+element.getQty());
				textOutput.println("Picture File\t" + element.getPic());
				textOutput.println("");
				item++;
			}
			textOutput.println("Total Inventory:\t"+
											 money.format(getTotalValue()));
			textOutput.close();
			System.out.println("File " + fileName + " created.");
		}
		catch(IOException e)
		{
			System.out.println("Couldn't write to file " + fileName);
		}
			
	}
	public void writeToFile(String fileName)
	{
		//removes any unused elements prior to writing to file.
		dataBase.trimToSize();
		try
		{
			ObjectOutputStream outputStream = new ObjectOutputStream
										(new FileOutputStream(fileName));
		//write file only if dataBase isn't empty
			if (!dataBase.isEmpty())
			{
				outputStream.writeObject((ArrayList<Item>)dataBase);
				outputStream.close();
				System.out.println("Attempting to write.");
			}
			System.out.println("WriteToFile complete.");	
		}
		catch(IOException e)
		{
			System.err.println("(IO)Error creating binary file " + fileName);
		}	
	}
	public void readFromFile(String fileName)
	{
		try
		{
			ObjectInputStream inputStream = 
					new ObjectInputStream(new FileInputStream(fileName));
			
		 	dataBase	= (ArrayList<Item>)inputStream.readObject();
	
			inputStream.close();
			System.out.println("Read from file complete");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Can not find binary file " + fileName);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Can not find class specified.");
		}
		catch(IOException e)
		{
			System.out.println("(IO)Can not find binary file " + fileName);
		}
	}
}