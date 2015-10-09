public class testRun
{
	public static void main(String [] args)
	{
		String file = "binary.dat";
		
		PropertyList list = new PropertyList();
//		list.readFromFile(file);
//		list.listAllRecords();

//		ItemGui window = new ItemGui();
//		
		
		Item one = new Item("Automobile", "SL-350", "Mercedes", "1235",
		1, 2008, 40000, "mercedes.jpg");
		Item two = new Item("Camera", "ABC-200", "Nikon", "1236", 1, 2010, 300, "nikon.jpg");
		Item three = new Item("Refrigerator", "Cool-One", "LG", "AB1234", 1, 2009, 1600,
		"refrigerator.jpg");
		Item four = new Item("Television", "Viao", "Sony", "GF89X", 1, 2010, 700,
		"television.jpg"); 
	
		list.addToDataBase(one);
		list.addToDataBase(two);
		list.addToDataBase(three);
		list.addToDataBase(four);
	
		list.writeToFile(file);
		
/*		list.clearDataBase();
		list.listAllRecords();
		
		
//		list.openFile(file);
//		list.addRecords();
//		list.closeFile();


		


		
//		list.printTextFile("List.txt");
//		list.writeToFile(file);
		
	//	list.removeItem("Camera");
		
	//	System.out.println(list.getDataBaseSize());
	//	System.out.println(list.getTotalValue());
	//	list.searchByName("Camera");
		
	//	list.listAllRecords();*/
	}
}
