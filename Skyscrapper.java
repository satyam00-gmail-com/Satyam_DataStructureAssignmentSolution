package com.greatlearning.main;


import java.util.*;

public class Skyscrapper {
	// Driver code
	static Scanner sc=new Scanner(System.in);		
	static Map<String, String> floorsbyDays=new LinkedHashMap<>();
	static List<Integer> floorsList = new ArrayList<>();
	static Set<Integer> inputSet = new HashSet<>();
	static int floorSize=0;
	static int day =1;	
	static List<String> arrivedList=new ArrayList<String>();
	static List<String> printableFloorList=new ArrayList<String>();
	
	
	static Integer acceptedFloor;
	
	public static void main(String args[])
	  {   
		    QueueUsingArray inputFloorQueue;
		    final int totalFloors;

// Getting max floors input from User	       
		    System.out.println("enter the total no of floors in the building ");
	    	totalFloors=sc.nextInt();
	    	acceptedFloor=totalFloors;
	    	Integer wantedFloor=totalFloors;
	    	
// creating floorslist ds
	    for (int i=1; i<=totalFloors; i++) {floorsList.add(i);}    
	   
// storing the floorsizes provided on  days 
// queue to store user input	    
	    inputFloorQueue= new QueueUsingArray(totalFloors);
	    
	    for (int i=1;i<=totalFloors;i++) 
	    	{
	    		System.out.println("\n Enter the floor size on given day : "+ i);
	    		floorSize=sc.nextInt();
	    		if (!inputSet.add(floorSize) || floorSize> totalFloors )
				{
	    			System.out.println("Please enter valid floor value ");	    			
				} 		
	    		else
	    		{
	    			inputSet.add(floorSize);	
		    		inputFloorQueue.queueEnqueue(floorSize);		    		
	    		}
	    	} 

	    //if its present then print it on day arrival of wanted floor
	    // if u dont get wanted floor add it to arrival queue and decrement accepted floor on each retrival
	    	
	    while (!floorsList.isEmpty()){  
	    		
	    	    Integer l= inputFloorQueue.queueDequeue();
	    	    arrivedList.add(l.toString());
	    	   
	    	    if (l==Collections.max(floorsList))
	    	    	 // whenever u get a wanted floor check if accepted floor is present in the arrived queue
	    	    {
	    	    	for (Integer i=Collections.max(floorsList);(arrivedList.contains(i.toString()) && i>=acceptedFloor);i--) 
	    	    	{
	    					printableFloorList.add(i.toString());
	    					arrivedList.remove(i.toString());
	    					floorsList.remove(i);	    					    					
	    			}	
	    	    	floorsbyDays.put("Day " + day, printableFloorList.toString());
	    	    	// System.out.println("Day "+ day + "WantedFloor "+Collections.max(floorsList)+ "acceptedFloor "+ acceptedFloor + " Input "+ l + " PrintableFloorList"+ printableFloorList.toString() ) ;
    				printableFloorList.clear();
	    	    	acceptedFloor--;	    	    	
					day++;		
	    	    }
	    	    else {
	    	    floorsbyDays.put("Day " + day, "\t \n ");
	    	    acceptedFloor--;
	    	    day++;
	    	    }
	  }

//Printing the stored values now 
	    	System.out.println("\nThe order of construction is as follows ");
	    	System.out.println(floorsbyDays.toString());
// Getting an iterator
	        Iterator hmIterator = floorsbyDays.entrySet().iterator();
	        while (hmIterator.hasNext())
	        {
	            Map.Entry mapElement = (Map.Entry)hmIterator.next();
	           //	System.out.println(mapElement.getKey().toString() + mapElement.getValue());
	    	}
	        sc.close();
	  }
	
}

