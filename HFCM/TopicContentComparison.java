package HFCM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopicContentComparison {
	
	static String Address1 = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/fixed-four-domain-no-sio";
	static String Address2 = "/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/fixed-four-domain-sio";

	
	public static void main (String args[])
	{
		File folder = new File(Address1+"/clusters/");
		File folder2 = new File(Address2+"/clusters/");
		 for (final File fileEntry : folder.listFiles())
		 {
			 
			 System.out.println("=============================");
			  System.out.println();
			 
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
						}
						
					}
					
				//!	System.out.println("no-sio: "+fileEntry.getName()+":"+list.size());
					
					 for (final File fileEntry2 : folder2.listFiles())
					 {
						 List<String> list2 = new ArrayList<String>();
						 BufferedReader br2 = null;
						 
						 if(!fileEntry2.getName().contains("cluster"))
						 {
							 continue;
						 }
						 
						 if(fileEntry2.getName().contains("_2_"))
						 {
							 continue;
						 }
						 try{
						 
						 
						 String sCurrentLine2;

							br2 = new BufferedReader(new FileReader(fileEntry2.getAbsolutePath()));

							while ((sCurrentLine2 = br2.readLine()) != null) {
								
								if(sCurrentLine2.contains("Size:")||sCurrentLine2.equals(""))
								{
									continue;
								}
								
								if(!list2.contains(sCurrentLine2))
								{
									list2.add(sCurrentLine2);
								}
								
							}
							
						//!	System.out.println("sio: "+fileEntry2.getName()+":"+list2.size());
							
							  float ps = 0;
							  List<String> common = new ArrayList<String>(list);
				    		  common.retainAll(list2);

							  if(common.size()!=0)
							  {
						    		//!ps = ((float)common.size()/((float)list.size()+(float)list2.size())); //jaccard
						    		ps = ((float)common.size()/((float)list2.size())); //jaccard

							  }
							  
							  System.out.println("no-sio: "+fileEntry.getName()+" and " + "sio: "+fileEntry2.getName()+"====="+ps);
							
							  
						 } catch (IOException e) {
								e.printStackTrace();
							} finally {
								try {
									if (br2 != null)br2.close();
								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
						 
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
