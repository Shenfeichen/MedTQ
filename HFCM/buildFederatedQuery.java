package HFCM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class buildFederatedQuery {
	
	static SortedMap<String,SortedMap<String,List<String>>> queryMap = new TreeMap<String,SortedMap<String,List<String>>>();
	static SortedMap<String, List<String>> concepmap = new TreeMap<String,List<String>>();
	static List<String> relevantList = new ArrayList<String>();
	
	
	public static void main(String args[])
	{
		BufferedReader br0 = null;
		
		int counter=1;

		try {

			String sCurrentLine0;

			br0 = new BufferedReader(new FileReader("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Drugbank2/querygen/ThreeLevel1-35-7564.txt"));

			String temp = "";
			
			while ((sCurrentLine0 = br0.readLine()) != null) {
				
				if(sCurrentLine0.equals("")||sCurrentLine0.contains("="))
				{
					counter=0;
					if(!relevantList.contains(temp))
					{
						relevantList.add(temp);
					}
					temp="";
					continue;
				}
				
				counter=1;
				if(counter!=0)
				{
					temp = temp+","+sCurrentLine0;
				}

			}
				
			}catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br0 != null)br0.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
		
		for(int i=0;i<relevantList.size();i++)
		{
			//System.out.println(relevantList.get(i));
		}
		
		
		
		for(int j=0;j<relevantList.size();j++)
		{
			
			String sCurrentLine = relevantList.get(j);
			if(!sCurrentLine.equals("")){
		//	System.out.println(sCurrentLine+"?");
			String subject = sCurrentLine.split(",")[1];
			String predicate = sCurrentLine.split(",")[2];
			String object = sCurrentLine.split(",")[3];
			
			String subject2 = sCurrentLine.split(",")[4];
			String predicate2 = sCurrentLine.split(",")[5];
			String object2 = sCurrentLine.split(",")[6];
			
			
			 if(!concepmap.containsKey(subject))
		        {
		        	List<String> list = new ArrayList<String>();
		        	list.add(sCurrentLine);
		        	concepmap.put(subject, list);
		        }
		        else
		        {
		        	List<String> list = concepmap.get(subject);
		        	if(!list.contains(sCurrentLine))
		            {  
		        		list.add(sCurrentLine);
		            }
		        	concepmap.put(subject,list);
		        }
		        
		        
		        if(!concepmap.containsKey(object))
		        {
		        	List<String> list = new ArrayList<String>();
		        	list.add(sCurrentLine);
		        	concepmap.put(object,list);
		        }
		        else
		        {
		        	List<String> list = concepmap.get(object);
		        	if(!list.contains(sCurrentLine))
		            {  
		        		list.add(sCurrentLine);
		            }
		        	concepmap.put(object,list);
		        }
		        
		        
		        
		        
		        
		        if(!concepmap.containsKey(subject2))
		        {
		        	List<String> list = new ArrayList<String>();
		        	list.add(sCurrentLine);
		        	concepmap.put(subject2, list);
		        }
		        else
		        {
		        	List<String> list = concepmap.get(subject2);
		        	if(!list.contains(sCurrentLine))
		            {  
		        		list.add(sCurrentLine);
		            }
		        	concepmap.put(subject2,list);
		        }
		        
		        
		        if(!concepmap.containsKey(object2))
		        {
		        	List<String> list = new ArrayList<String>();
		        	list.add(sCurrentLine);
		        	concepmap.put(object2,list);
		        }
		        else
		        {
		        	List<String> list = concepmap.get(object2);
		        	if(!list.contains(sCurrentLine))
		            {  
		        		list.add(sCurrentLine);
		            }
		        	concepmap.put(object2,list);
		        }
			}
		}
		
	
		/*BufferedReader br = null;
		
	//	int counter=0;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Drugbank2/querygen/ThreeLevel0-4-92.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				counter = counter+1;

				if(sCurrentLine.equals("")||sCurrentLine.contains("="))
				{
					counter=0;
					continue;
				}
				
			    String subject = sCurrentLine.split(",")[0];
			    String predicate = sCurrentLine.split(",")[1];
			    String object = sCurrentLine.split(",")[2];
			    
			 //   if(!queryMap.containsKey(predicate))
			   // {
			        if(!concepmap.containsKey(subject))
			        {
			        	List<String> list = new ArrayList<String>();
			        	list.add(sCurrentLine);
			        	concepmap.put(subject, list);
			        }
			        else
			        {
			        	List<String> list = concepmap.get(subject);
			        	if(!list.contains(sCurrentLine))
			            {  
			        		list.add(sCurrentLine);
			            }
			        	concepmap.put(subject,list);
			        }
			        
			        
			        if(!concepmap.containsKey(object))
			        {
			        	List<String> list = new ArrayList<String>();
			        	list.add(sCurrentLine);
			        	concepmap.put(object,list);
			        }
			        else
			        {
			        	List<String> list = concepmap.get(object);
			        	if(!list.contains(sCurrentLine))
			            {  
			        		list.add(sCurrentLine);
			            }
			        	concepmap.put(object,list);
			        }
			        
				//    queryMap.put(predicate, concepmap);

			//    }

			}*/
			List<String> checklist = new ArrayList<String>();
			
			Iterator<String> iterconcepmap = concepmap.keySet().iterator(); 

			  while(iterconcepmap.hasNext()){
				  
				  String c = iterconcepmap.next();
				  checklist.clear();
				  System.out.println("Concept: "+c);
				  List<String> statementList = concepmap.get(c);
				  for(int i=0;i<statementList.size();i++)
					{
					  if(statementList.get(i).split(",").length==7){
						if(!checklist.contains(statementList.get(i).split(",")[1]+","+statementList.get(i).split(",")[2]+","+statementList.get(i).split(",")[3]))
						{	
						  System.out.println(statementList.get(i).split(",")[1]+","+statementList.get(i).split(",")[2]+","+statementList.get(i).split(",")[3]);
						  checklist.add(statementList.get(i).split(",")[1]+","+statementList.get(i).split(",")[2]+","+statementList.get(i).split(",")[3]);
						}
						
						if(!checklist.contains(statementList.get(i).split(",")[4]+","+statementList.get(i).split(",")[5]+","+statementList.get(i).split(",")[6]))
						  System.out.println(statementList.get(i).split(",")[4]+","+statementList.get(i).split(",")[5]+","+statementList.get(i).split(",")[6]);
						 checklist.add(statementList.get(i).split(",")[4]+","+statementList.get(i).split(",")[5]+","+statementList.get(i).split(",")[6]);
					  }
					}
				  System.out.println();
			  }
			

	/*	} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}*/
		
	}
	

}
