package HFCM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class identifyHierarchicalRelation {
	
	static SortedMap<String,List<String>> level1Map = new TreeMap<String,List<String>>();
	static SortedMap<String,List<String>> level2Map = new TreeMap<String,List<String>>();
	static SortedMap<String,List<String>> level3Map = new TreeMap<String,List<String>>();
	
	
	
	static float totalPredicateSize=0;

//!	String Address = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/fixed-four-domain-no-sio";
String Address = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Drugbank2";
//!	String Address = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Drugbank3";

//	String Address = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Pharmgkb2";

//	String Address = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/ClinicalTrial2";

//	String Address = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Sider2";


	public static void main(String args[])
	{
		identifyHierarchicalRelation obj = new identifyHierarchicalRelation();
		obj.level1Map();
		obj.level2Map();
		obj.level3Map();
		
		System.out.println(level1Map.size());
		System.out.println(level2Map.size());
		System.out.println(level3Map.size());
		System.out.println("total size: "+totalPredicateSize);
		
		
		Iterator<String> iterlevel1Map0 = level1Map.keySet().iterator(); 

		  while(iterlevel1Map0.hasNext()){
			  
			  String key1 = iterlevel1Map0.next();
	    	  List<String> list1 = level1Map.get(key1);
	    	   
	    	  float percentage = list1.size()/totalPredicateSize;
			  System.out.println("level1 percentage from original graph: "+percentage);
		  }
		
		
		Iterator<String> iterlevel1Map = level1Map.keySet().iterator(); 
		
	       
	       while(iterlevel1Map.hasNext()){
	    	   String key1 = iterlevel1Map.next();
	    	   List<String> list1 = level1Map.get(key1);
	    	   

	    	   for (Map.Entry<String, List<String>> entry : level2Map.entrySet()) {
	    		   
	    		   String key2 = entry.getKey();
		    	//   System.out.println("key2: "+key2);

	    		   
	    		   List<String> list2 = entry.getValue();
	    		   
	    		  //  System.out.println("list1 size: "+list1.size());
	    		 //   System.out.println("list2 size: "+list2.size());
	    		   float list1size = list1.size();
	    		    
	    		    List<String> common = new ArrayList<String>(list2);
	    		    common.retainAll(list1);
	    		    
	    		 //   System.out.println("common size: "+common.size());
	    		 //   System.out.println("list1 size: "+list1.size());
	    		 //   System.out.println("list2 size: "+list2.size());
	    		    if(common.size()!=0)
	    		    {
	    		    /*	System.out.println(common.size());
	    		    	System.out.println(list1size);
*/
	    		    	float percentage = common.size()/list1size;
	    		    	
	    		    	System.out.println("level1 "+ key1 + " -> " + "level2 "+key2 + " Percentage from level1: "+percentage);
	    		    }
	    		    	    		    
	    		}
  
	       }
	       
	       
	       
	       System.out.println();
	       
	       ////////// Level2 -> Level3 ////////////
	       
	   	Iterator<String> iterlevel2Map = level2Map.keySet().iterator(); 
		
	       
	       while(iterlevel2Map.hasNext()){
	    	   String key1 = iterlevel2Map.next();
	    	   List<String> list1 = level2Map.get(key1);
	    	   

	    	   for (Map.Entry<String, List<String>> entry : level3Map.entrySet()) {
	    		   
	    		   String key2 = entry.getKey();
		    	//   System.out.println("key2: "+key2);

	    		   
	    		   List<String> list2 = entry.getValue();
	    		   
	    		   float list1size = list1.size();

	    		   
	    		  //  System.out.println("list1 size: "+list1.size());
	    		 //   System.out.println("list2 size: "+list2.size());
	    		    
	    		    List<String> common = new ArrayList<String>(list2);
	    		    common.retainAll(list1);
	    		    
	    		 //   System.out.println("common size: "+common.size());
	    		 //   System.out.println("list1 size: "+list1.size());
	    		 //   System.out.println("list2 size: "+list2.size());
	    		    if(common.size()!=0)
	    		    {
	    		    	float percentage = common.size()/list1size;
	    		    	
	    		    	System.out.println("level2 "+ key1 + " -> " + "level3 "+key2+" Percentage from level2: "+percentage);
	    		    }
	    		    	    		    
	    		}

	       }
	       
		
		
	}
	
	
	public void level1Map()
	{
		File folder = new File(Address+"/clusters-upperLevels/");
		 for (final File fileEntry : folder.listFiles())
		 {
			 
			 if(!fileEntry.getName().contains("cluster"))
			 {
				 continue;
			 }
			 
			 if(fileEntry.getName().contains("_2_"))
			 {
				 continue;
			 }
			 
			 List<String> list = new ArrayList<String>();
			 BufferedReader br = null;

				try {

					String sCurrentLine;

					br = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()));

					while ((sCurrentLine = br.readLine()) != null) {
						
						if(sCurrentLine.contains("Size:")||sCurrentLine.equals(""))
						{
							continue;
						}
						
						
						
						if(!list.contains(sCurrentLine))
						{
							list.add(sCurrentLine);
							totalPredicateSize = totalPredicateSize+1;

						}
						
					}
					
					
					if(!level1Map.containsKey(fileEntry.getName()))
					{
						//List<List<String>> finalList = new ArrayList<List<String>>();
						//finalList.add(list);
						level1Map.put(fileEntry.getName(), list);
					}
					

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
		 }
		
	}
	
	
	
	public void level2Map()
	{
		File folder = new File(Address+"/clusters-upperLevels/");
		 for (final File fileEntry : folder.listFiles())
		 {
			 
			 if(!fileEntry.getName().contains("cluster"))
			 {
				 continue;
			 }
			 
			 if(!fileEntry.getName().contains("_2_"))
			 {
				 continue;
			 }
			 
			 List<String> list = new ArrayList<String>();
			 BufferedReader br = null;

				try {

					String sCurrentLine;

					br = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()));

					while ((sCurrentLine = br.readLine()) != null) {
						
						if(sCurrentLine.contains("Size:")||sCurrentLine.equals(""))
						{
							continue;
						}
						
						if(!list.contains(sCurrentLine))
						{
							list.add(sCurrentLine);
						}
						
					}
					
					
					if(!level2Map.containsKey(fileEntry.getName()))
					{
						//List<List<String>> finalList = new ArrayList<List<String>>();
						//finalList.add(list);
						level2Map.put(fileEntry.getName(), list);
					}
					

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
		 }
		
	}
	
	
	

	public void level3Map()
	{
		 File folder = new File(Address+"/clusters/");
		 for (final File fileEntry : folder.listFiles())
		 {
			 
			 if(!fileEntry.getName().contains("cluster"))
			 {
				 continue;
			 }
			 
			 List<String> list = new ArrayList<String>();
			 BufferedReader br = null;

				try {

					String sCurrentLine;

					br = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()));

					while ((sCurrentLine = br.readLine()) != null) {
						
						if(sCurrentLine.contains("Size:")||sCurrentLine.equals(""))
						{
							continue;
						}
						
						if(!list.contains(sCurrentLine))
						{
							list.add(sCurrentLine);
						}
						
					}
					
					
					if(!level3Map.containsKey(fileEntry.getName()))
					{
						//List<List<String>> finalList = new ArrayList<List<String>>();
						//finalList.add(list);
						level3Map.put(fileEntry.getName(), list);
					}
				

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
		 }
		
	}
	
	
}
