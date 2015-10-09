/* CS-112 FINAL PROJECT
   File Name:          	Item.java
   Programmer:         	James Watkins
   Date Last Modified: 	May 19, 2012

   Problem Statement: Define a class to contain the specific details of items
   which will be used within an inventory management application.  Class must
   account for image files as well as text and numeric variables.  Enable
   binary I/O.
   
   Overall Plan:
   1. Define the constructors which will be used to create Item objects.
   2. Provide mutator and accessor methods for each of an Item's variables.
   3. Override equals.
   4. Override toString.
   5. Make the class serializable to support binary I/O operations.
  
   Classes needed and Purpose (Input, Processing, Output)
   NumberFormat - output
   String - input, output
*/
import java.text.NumberFormat;
import java.io.Serializable;
import java.io.*;

public class Item implements Serializable
{
	private String description, model, maker, serialNumber, pictureFileName;
	private int quantity, yearPurchased;
	private double price;
	
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	public Item()
	{
		description = null;
		model = null;
		maker = null;
		serialNumber = null;
		quantity = 0;
		yearPurchased = 1000;
		price = 0.0;
		pictureFileName = null;
	}
	public Item(String descr, String aModel, String make, String SN, int QTY,
				int datePurchase, double aPrice)
	{
		description = descr;
		model = aModel;
		maker = make;
		serialNumber = SN;
		quantity = QTY;
		yearPurchased = datePurchase;
		price = aPrice;
		pictureFileName = null;
	}
	public Item(String descr, String aModel, String make, String SN, int QTY,
				int datePurchase, double aPrice, String picFile)
	{
		description = descr;
		model = aModel;
		maker = make;
		serialNumber = SN;
		quantity = QTY;
		yearPurchased = datePurchase;
		price = aPrice;
		pictureFileName = picFile;
	}
	public void updateAll(String descr, String aModel, String make, 
	String SN, int QTY, int datePurchase, double aPrice, String picFile)
	{
		description = descr;
		model = aModel;
		maker = make;
		serialNumber = SN;
		quantity = QTY;
		yearPurchased = datePurchase;
		price = aPrice;
		pictureFileName = picFile;
	}
	public void setPic(String fileName)
	{
		pictureFileName = fileName;
	}
	public String getPic()
	{
		return pictureFileName;
	}			
	public void setDescription(String descr)
	{
		description = descr;
	}
	public String getDescription()
	{
		return description;
	} 
	public void setModel(String input)
	{
		model = input;
	}
	public String getModel()
	{
		return model;
	}
	public void setMake(String input)
	{
		maker = input;
	}
	public String getMake()
	{
		return maker;
	}
	public void setSerial(String SN)
	{
		serialNumber = SN;
	} 
	public String getSerial()
	{
		return serialNumber;
	}
	public void setQty(int QTY)
	{
		quantity = QTY;
	} 
	public int getQty()
	{
		return quantity;
	}
	public void setDate(int datePurchase)
	{
		yearPurchased = datePurchase;
	}
	public int getDate()
	{
		return yearPurchased;
	}
	public void setPrice(double aPrice) 
	{
		price = aPrice;
	}
	public double getPrice()
	{
		return price;
	}
	public boolean equals(Item other)
	{
		boolean flag;
		
		if (this == other)
			flag = true;
//assumes that purchase price, and purchase date do not make an item unique
		else if ((description.equalsIgnoreCase(other.description))&&
		(serialNumber.equalsIgnoreCase(other.serialNumber))&&
		(model.equalsIgnoreCase(other.model))&&
		(maker.equalsIgnoreCase(other.maker)))
			flag = true;
		else
		//items are not identical
			flag = false;
			
		return flag;	
	}
	public String toString()
	{
		return ("Description:\t"+description+"\nManufacturer:\t"+maker+
		"\nModel Number:\t"+model+"\nSerial Number:\t"+serialNumber+
		"\nYear Purchased:\t"+yearPurchased+"\nQuantity:\t"+quantity+
		"\t\tPurchase Price:\t"+ money.format(price) +
		"\nPicture file:\t" + pictureFileName + "\n");
	}
}