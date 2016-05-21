package OntologyParsePredicate;
import hierarchyclustering.AverageLinkageStrategy;
import hierarchyclustering.Cluster;
import hierarchyclustering.ClusteringAlgorithm;
import hierarchyclustering.DefaultClusteringAlgorithm;
import hierarchyclustering.visualization.DendrogramPanel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import jxl.write.WriteException;

import DBOperate.Insert;
import DBOperate.DBQuery;
import Draw.QueryGraph;
import ExcelCompose.ExcelWriter;
import GUI.QueryGUI;

import MatrixOp.MatrixPlus;
import Query.QueryGenerator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntTools;
import com.hp.hpl.jena.ontology.OntTools.Path;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.Filter;


public class NTripleMatrixBuilder2ConceptBased {
	
	

	//!	String owlFile = "E:/Dropbox/WWW2014/UBA/Schema/merged-obi-comments.owl";
	//!	String owlFile = "E:/Dropbox/WWW2014/UBA/Schema/sio.owl";
	//!String owlFile = "F:/Dropbox/WWW2014/UBA/Schema/drugbank.nt";
	
	//!String owlFile = "F:/Dropbox/WWW2014/UBA/Schema/hhpid.nt";
	//!String owlFile = "F:/Dropbox/WWW2014/UBA/Schema/hgnctab.nt";
	//!String owlFile = "F:/Dropbox/WWW2014/UBA/Schema/package.nt";
	//!String owlFile = "F:/Dropbox/WWW2014/UBA/Schema/biomodels.nt";
	String owlFile="";
	
	
	String predicateFile = "F:/Dropbox/WWW2014/UBA/Schema/drugbankPredicateFile.txt";
	
	//String myDirectoryPath0 = "G:/Bio2RDF datasets/affymetrix";
		//String myDirectoryPath1 = "G:/Bio2RDF datasets/atlas";
		String myDirectoryPath0 = "G:/Bio2RDF datasets/biomodels";
		String myDirectoryPath1 = "G:/Bio2RDF datasets/bioportal";
		String myDirectoryPath2 = "G:/Bio2RDF datasets/drugbank";
		String myDirectoryPath3 = "G:/Bio2RDF datasets/pharmgkb";///-
		String myDirectoryPath4 = "G:/Bio2RDF datasets/hgnc";
		//String myDirectoryPath6 = "G:/Bio2RDF datasets/hhpid";
		String myDirectoryPath5 = "G:/Bio2RDF datasets/geneontology";
		//String myDirectoryPath8 = "G:/Bio2RDF datasets/interpro";
		String myDirectoryPath6 = "G:/Bio2RDF datasets/mgi";///-
		String myDirectoryPath7 = "G:/Bio2RDF datasets/omim";
		//String myDirectoryPath8 = "G:/Bio2RDF datasets/kegg";
		//String myDirectoryPath10 = "G:/Bio2RDF datasets/mesh";
		//String myDirectoryPath9 = "G:/Bio2RDF datasets/mgi";
		//String myDirectoryPath10 = "G:/Bio2RDF datasets/ndc";
		//String myDirectoryPath11 = "G:/Bio2RDF datasets/sabiork";///-

/*	String myDirectoryPath13 = "G:/Bio2RDF datasets/omim";
	String myDirectoryPath14 = "G:/Bio2RDF datasets/sgd";
	String myDirectoryPath15 = "G:/Bio2RDF datasets/taxonomy";*/
	
	
	//String dataPreFile = "G:/Bio2RDFdataPre/affymetrix_dp.txt";
	
			
	//!String owlFile = "http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl";
	
	//!!!String activitypatternpath = "G:/test/activitypattern";
	
	SortedMap<String,String> PredicateDomainMap = new TreeMap<String,String>(); 		
	SortedMap<String,String> PredicateRangeMap = new TreeMap<String,String>(); 
	static SortedMap<String,List<String>> predicateObjMap = new TreeMap<String,List<String>>(); 
	static SortedMap<String,List<String>> predicateSubjMap = new TreeMap<String,List<String>>(); 
	SortedMap<String,List<String>> PredicatePredClassesMap = new TreeMap<String,List<String>>(); 
	
	static SortedMap<String,SortedMap<String,Integer>> ShareMap = new TreeMap<String,SortedMap<String,Integer>>(); 
    SortedMap<String,List<String>> ShareNameMap = new TreeMap<String,List<String>>();
    
    SortedMap<String,String> inverseMap = new TreeMap<String,String>(); 
    
    static SortedMap<String,String> labelMap = new TreeMap<String,String>(); 

    
	SortedMap<String,List<String>> neighbourMap = new TreeMap<String,List<String>>(); 

	SortedMap<String,List<String>> neighbourMap2nd = new TreeMap<String,List<String>>(); 
	SortedMap<String,List<String>> neighbourMap3rd = new TreeMap<String,List<String>>(); 
	
	
	ArrayList<String> builtinList = new ArrayList<String>();
	ArrayList<String> predicateFileList = new ArrayList<String>();

	
	
	Queue <String> distanceQ = new LinkedList();

	 static SortedMap<String,String> tripleMap = new TreeMap<String,String>(); 

	 ArrayList<String> storeList = new ArrayList<String>();
	 
	 int count=0;
	 
	 List<String> tempList = new ArrayList<String>();
	  
	 SortedMap<String,List<String>> Share_Probability_Map = new TreeMap<String,List<String>>();
	 
	 
	 long start0=0;
	 
	 ArrayList<String> dataPreList = new ArrayList<String>(); /// List to store dataproperty

	 List<String> sList= new ArrayList<String>();
	 List<String> pList= new ArrayList<String>();
	 List<String> oList= new ArrayList<String>();
	 
	public List<String> prepareLUBMMatrixColumn ()
	{
		String dirName = "";
		String tableName="";
		String dataPreFile = "";
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
		
		//// Mix all nt data
		List<String> dirList = new ArrayList<String>();
		dirList.add(myDirectoryPath0);
		dirList.add(myDirectoryPath1);
		dirList.add(myDirectoryPath2);
		dirList.add(myDirectoryPath3);
		dirList.add(myDirectoryPath4);
		dirList.add(myDirectoryPath5);
		dirList.add(myDirectoryPath6);
		dirList.add(myDirectoryPath7);
		//!dirList.add(myDirectoryPath8);
		//!dirList.add(myDirectoryPath9);
		//!dirList.add(myDirectoryPath10);
		//!dirList.add(myDirectoryPath11);
		/*dirList.add(myDirectoryPath11);
		dirList.add(myDirectoryPath12);
		dirList.add(myDirectoryPath13);
		dirList.add(myDirectoryPath14);
		dirList.add(myDirectoryPath15);*/
	//!!!!	dirList.add(activitypatternpath);
		
		List<String> PredicateList = new ArrayList<String>();
		
	for(int i=0;i<dirList.size();i++){ ////for mix
		
		 start0 = System.currentTimeMillis();
		
		 File dir = new File(dirList.get(i));
		  File[] directoryListing=null; //!= dir.listFiles();
		  tableName = dir.getName()+"table";
		  dirName = dir.getName();
		  dataPreFile = "G:/Bio2RDFdataPre/"+dirName + "_dp.txt";
		  DBQuery cobj = new DBQuery();
		  int rowcount=cobj.countDB(tableName);
			
			
		if(rowcount>0){	
		  
			
			
			storeList = cobj.selectstoreListDB(tableName);
			String s="",p="",o="";
			for(int n=0;n<storeList.size();n++)
			{
				s = storeList.get(n).split(",")[0];
				p = storeList.get(n).split(",")[1];
				o = storeList.get(n).split(",")[2];
				
				if(!sList.contains(s))
				{
					sList.add(s);
				}
				if(!pList.contains(p))
				{
					pList.add(p);
				}
				if(!oList.contains(o))
				{
					oList.add(o);
				}
				
				
				if(p.contains("http://www.w3.org/1999/02/22-rdf-syntax-ns"))
				{
					continue;
				}
				
				if(p.contains("http://www.w3.org/2000/01/rdf-schema"))
				{
					continue;
				}
				
				
			     if(!tripleMap.containsKey("s:"+s))
			      {
			    	  tripleMap.put("s:"+s,"s:"+s);
			      }
			      if(!tripleMap.containsKey("p:"+p))
			      {
			    	  tripleMap.put("p:"+p,"p:"+p);
			      }
			      if(!tripleMap.containsKey("o:"+o))
			      {
			    	  tripleMap.put("o:"+o,"o:"+o);
			      }
			      
			      
			    	if(!labelMap.containsKey(s))
		        	{
		        		labelMap.put(s, s);
		        	}
				      
				  	if(!labelMap.containsKey(p))
		        	{
		        		labelMap.put(p, p);
		        	}
				        
					if(!labelMap.containsKey(o))
		        	{
		        		labelMap.put(o, o);
		        	}
					
					if(!predicateObjMap.containsKey(p))
		        	{
		        		List<String> objectList = new ArrayList<String>();
		        		objectList.add(o);
		        		predicateObjMap.put(p,objectList);
		        	}
		        	else
		        	{
		        		List<String> objectList = predicateObjMap.get(p);
		        		if(!objectList.contains(o))
		        		{
		        			objectList.add(o);
		        		}
		        		predicateObjMap.put(p,objectList);
		        	}
		        	
		    
		        	
		        	if(!PredicateRangeMap.containsKey(p))
		        	{
		        		PredicateRangeMap.put(p,o);
		        	}
		        
		        
		       
		        	if(!predicateSubjMap.containsKey(p))
		        	{
		        		List<String> subjectList = new ArrayList<String>();
		        		subjectList.add(s);
		        		predicateSubjMap.put(p,subjectList);
		        	}
		        	else
		        	{
		        		List<String> subjectList = predicateSubjMap.get(p);
		        		if(!subjectList.contains(s))
		        		{
		        			subjectList.add(s);
		        		}
		        		predicateSubjMap.put(p,subjectList);
		        	}
		        	
		        	
		        	if(!PredicatePredClassesMap.containsKey(p))
		        	{
		        		List<String> PredClassList = new ArrayList<String>();
		        		PredClassList.add(s);
		        		PredicatePredClassesMap.put(p,PredClassList);
		        	}
		        	else
		        	{
		        		List<String> PredClassList = PredicatePredClassesMap.get(p);
		        		if(!PredClassList.contains(s))
		        		{
		        			PredClassList.add(s);
		        		}
		        		PredicatePredClassesMap.put(p,PredClassList);
		        	}
		        	
		        	if(!PredicateDomainMap.containsKey(p))
		        	{
		        		PredicateDomainMap.put(p,s);
		        	}
		        	
		        	
		              
		        	if(!PredicateList.contains(p))
		        	{
		        		PredicateList.add(p);
		        	}	
					
			      
			}
		}
		
		else if (rowcount==0){
			
			long start = System.currentTimeMillis();
			
			/// load dataPreList
/*!!!!			BufferedReader br0 = null;
			try {
				
				String sCurrentLine0;
				
				br0 = new BufferedReader(new FileReader(dataPreFile));
				
				while ((sCurrentLine0 = br0.readLine()) != null) {
					
					 dataPreList.add(sCurrentLine0.split("\t")[1]);					
				}
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			!!!!*/
			
			
			
			
			
			List<String> existingStringList = new ArrayList<String>();
			
			
		BufferedReader br = null;
		
		  if (directoryListing != null) {
			    for (File child : directoryListing) {
			      // Do something with child
			   
			    	owlFile = child.getAbsolutePath();
			    
			    	
			    	System.out.println("owlFile is: " + owlFile);
		
				
		try {
			 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(owlFile));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				int flag=0;
				
			
				if(sCurrentLine.contains(" ")&&sCurrentLine.contains("http://"))
				{
					//System.out.println("***"+sCurrentLine);
					String p0 = sCurrentLine.split(" ")[1];
					if(p0.contains("<")){
						p0 = p0.split("<")[1].split(">")[0];
					}
					
						if(!tempList.contains(p0)){
						tempList.add(p0);
						count=count+1;	
						}
				}
				else
				{
					continue;
				}
		
				
				String s = "";
				String p = "";
				String o = "";
			
				if(sCurrentLine.contains("\""))
				{
					flag=1;
					
		/*!!!			if(dataPreList.size()>0){

					   s = "";
					   p = "";
					   o = "Literal";
					   
					   int stop=0;
					   for(int l=0;l<dataPreList.size();l++)
					   {
						   if(sCurrentLine.contains("<"+dataPreList.get(l)+">"))
						   {
							   stop=1;
							   break;
						   }
					   }
					
					  if(stop==1){
						  
						if(sCurrentLine.contains("\t"))
						{
							s = sCurrentLine.split("\t")[0];
							p = sCurrentLine.split("\t")[1];
							
							
							if(!s.contains(":")||!p.contains(":"))
							{
								continue;
							}
						
							s = "http:"+sCurrentLine.split("\t")[0].split(":")[1];
							p = sCurrentLine.split("\t")[1].split("<")[1].split(">")[0];	
							
							if(!storeList.contains(s+ ";"+p + ";"+o))
							{
								if(!s.equals("")&&!p.equals("")&&!o.equals(""))
								storeList.add(s+ ";"+p + ";"+o);
							}		
								
							dataPreList.remove(p);
						}
						else if(sCurrentLine.contains(" "))
						{
							s = sCurrentLine.split(" ")[0];
							p = sCurrentLine.split(" ")[1];
							if(!s.contains(":")||!p.contains(":"))
							{
								continue;
							}
						
							s = "http:"+sCurrentLine.split(" ")[0].split(":")[1];
							p = sCurrentLine.split(" ")[1].split("<")[1].split(">")[0];	
							
						
							if(!storeList.contains(s+ ";"+p + ";"+o))
							{
								if(!s.equals("")&&!p.equals("")&&!o.equals(""))
								storeList.add(s+ ";"+p + ";"+o);
							}		
								
							dataPreList.remove(p);
						}
					}
					 else
					  {
						  continue;
					  }
									
				}
				else
				{
					System.out.println("dataPreList size is 0");
				}!!!*/
			}

				
			
	
			
			if(flag==0){
				
				if(sCurrentLine.contains("\t"))
				{
					 s = "http:"+sCurrentLine.split("\t")[0].split(":")[1];
					 p = sCurrentLine.split("\t")[1].split("<")[1].split(">")[0];	
					 /*if(sCurrentLine.split(" ")[2].contains(":")){
					 o = "http:"+sCurrentLine.split(" ")[2].split(":")[1];
					
					 }*/
					  if (sCurrentLine.split("\t")[2].contains(">")&&sCurrentLine.split("\t")[2].contains("<")&&sCurrentLine.split("\t")[2].contains(":"))
					 {
						  o = "http:"+sCurrentLine.split("\t")[2].split(":")[1];
						  if(o.contains(">"))
						  {
							  o = o.split(">")[0];
						  }
					 }
					 if(!sCurrentLine.split("\t")[2].contains(">")||!sCurrentLine.split("\t")[2].contains("<")||!sCurrentLine.split("\t")[2].contains(":"))
					 {
						 continue;
					 }	
				}
				
				else if(sCurrentLine.contains(" ")){
					 s = "http:"+sCurrentLine.split(" ")[0].split(":")[1];
					 p = sCurrentLine.split(" ")[1].split("<")[1].split(">")[0];	
					 /*if(sCurrentLine.split(" ")[2].contains(":")){
					 o = "http:"+sCurrentLine.split(" ")[2].split(":")[1];
					
					 }*/
					  if (sCurrentLine.split(" ")[2].contains(">")&&sCurrentLine.split(" ")[2].contains("<")&&sCurrentLine.split(" ")[2].contains(":"))
					 {
						  o = "http:"+sCurrentLine.split(" ")[2].split(":")[1];
						  if(o.contains(">"))
						  {
							  o = o.split(">")[0];
						  }
					 }
					 if(!sCurrentLine.split(" ")[2].contains(">")||!sCurrentLine.split(" ")[2].contains("<")||!sCurrentLine.split(" ")[2].contains(":"))
					 {
						 continue;
					 }
				}
			}
		/*	else
			{
				 s = "http:"+sCurrentLine.split(" ")[0].split(":")[1];
				 p = sCurrentLine.split(" ")[1].split("<")[1].split(">")[0];	
				 o = sCurrentLine.split(sCurrentLine.split(" ")[1])[1];
			}*/

		
		if(flag==0){
			
			//System.out.println(s+" "+p+" "+o);
			
			if(!storeList.contains(s+ ";"+p + ";"+o))
			{
				if(!s.equals("")&&!p.equals("")&&!o.equals(""))
				storeList.add(s+ ";"+p + ";"+o);
				//System.out.println(s+ " "+p + " "+o);
				//count=count+1;
				//System.out.println(count);
				// System.out.println("****"+sCurrentLine);
			}
		}
			

			      if(!tripleMap.containsKey("s:"+s))
			      {
			    	  tripleMap.put("s:"+s,"s:"+s);
			      }
			      if(!tripleMap.containsKey("p:"+p))
			      {
			    	  tripleMap.put("p:"+p,"p:"+p);
			      }
			      if(!tripleMap.containsKey("o:"+o))
			      {
			    	  tripleMap.put("o:"+o,"o:"+o);
			      }
			      
			
			  	if(!labelMap.containsKey(s))
	        	{
	        		labelMap.put(s, s);
	        	}
			      
			  	if(!labelMap.containsKey(p))
	        	{
	        		labelMap.put(p, p);
	        	}
			        
				if(!labelMap.containsKey(o))
	        	{
	        		labelMap.put(o, o);
	        	}

			       			
			           
			      
			        	if(!predicateObjMap.containsKey(p))
			        	{
			        		List<String> objectList = new ArrayList<String>();
			        		objectList.add(o);
			        		predicateObjMap.put(p,objectList);
			        	}
			        	else
			        	{
			        		List<String> objectList = predicateObjMap.get(p);
			        		if(!objectList.contains(o))
			        		{
			        			objectList.add(o);
			        		}
			        		predicateObjMap.put(p,objectList);
			        	}
			        	
			    
			        	
			        	if(!PredicateRangeMap.containsKey(p))
			        	{
			        		PredicateRangeMap.put(p,o);
			        	}
			        
			        
			       
			        	if(!predicateSubjMap.containsKey(p))
			        	{
			        		List<String> subjectList = new ArrayList<String>();
			        		subjectList.add(s);
			        		predicateSubjMap.put(p,subjectList);
			        	}
			        	else
			        	{
			        		List<String> subjectList = predicateSubjMap.get(p);
			        		if(!subjectList.contains(s))
			        		{
			        			subjectList.add(s);
			        		}
			        		predicateSubjMap.put(p,subjectList);
			        	}
			        	
			        	
			        	if(!PredicatePredClassesMap.containsKey(p))
			        	{
			        		List<String> PredClassList = new ArrayList<String>();
			        		PredClassList.add(s);
			        		PredicatePredClassesMap.put(p,PredClassList);
			        	}
			        	else
			        	{
			        		List<String> PredClassList = PredicatePredClassesMap.get(p);
			        		if(!PredClassList.contains(s))
			        		{
			        			PredClassList.add(s);
			        		}
			        		PredicatePredClassesMap.put(p,PredClassList);
			        	}
			        	
			        	if(!PredicateDomainMap.containsKey(p))
			        	{
			        		PredicateDomainMap.put(p,s);
			        	}
			        	
			        	
			              
			        	if(!PredicateList.contains(p))
			        	{
			        		PredicateList.add(p);
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
		
			    } /// end for loop folder for
			}///end for loop foder if
		  
		  	Insert in = new Insert();
			in.insertbasic(owlFile,storeList,tableName);
			
			long end = System.currentTimeMillis();
			
			System.out.println("data preprocessing time is: " + (end-start));
	}
		    
	} //// for mix
	
	
	System.out.println("unique Subject: "+ sList.size());
	System.out.println("unique Predicate: "+ pList.size());
	System.out.println("unique Object: " + oList.size());
		
	       QueryGenerator qobj = new QueryGenerator();
	       
	       qobj.receivePredicateDomainMap(PredicateDomainMap);
	       qobj.receivePredicateRangeMap(PredicateRangeMap);
	       
	       
	       QueryGUI sg = new QueryGUI();
	       
	       sg.receivePredicateDomainMap(PredicateDomainMap);
	       sg.receivePredicateRangeMap(PredicateRangeMap);
	       sg.receiveLabelMap(labelMap);
	       sg.receivebuiltinMap(builtinList);
	      
		  
		  
	/*	  System.out.print("\t");
		  for(int i=0;i<PredicateList.size();i++)
		  {
			  String name = PredicateList.get(i).split("#")[1];
			  System.out.print(name+"\t");
			  
		  }
		  
		  System.out.println();
		  for(int i=0;i<PredicateList.size();i++)
		  {
			  String name =  PredicateList.get(i).split("#")[1];
			  
			 // System.out.println(name);
			  for(int j=0;j<PredicateList.size();j++)
			  {
				  //System.out.println(m.getOntClass(PredicateList.get(i)));
				  //System.out.println(m.getOntClass(PredicateList.get(j)));
				  Path shortestPath= OntTools.findShortestPath(m, m.getOntProperty(PredicateList.get(i)), m.getOntProperty(PredicateList.get(j)), Filter.any) ; 
				  if(null!=shortestPath){
				       // System.out.println(shortestPath.size()+"\t");
				     //!   name = name + "\t"+shortestPath.size();
				        name = name + "\t"+shortestPath.toString();
				        }
				  else
				  {
					 //System.out.println("0"+"\t");
					 name = name + "\t"+"0";
				  }
			  }
			  
			  System.out.println(name);
		  }*/
		  
		 /* for(int i=0;i<PredicateList.size();i++)
		  {
			  String name = PredicateList.get(i).split("#")[1];
			  FinishList.add(name);
			  
		  }*/
		 
		 /* Iterator<String> iterPredicatePredClassesMap = PredicatePredClassesMap.keySet().iterator(); 
	       
	       while(iterPredicatePredClassesMap.hasNext()){
	    	   
	    	   String key = iterPredicatePredClassesMap.next();
	    	   List<String> value = PredicatePredClassesMap.get(key);
	    	  
	    	   System.out.println(key+":");
	    	 //  System.out.println(value.size());
	    	   for(int i=0;i<value.size();i++)
	    	   {
	    		   System.out.println(value.get(i));
	    	   } 	   
	    	   
	    	   System.out.println("==========================");
	       }*/
		 
		  
		  
		  Iterator<String> iterPredicateDomainMap = PredicateDomainMap.keySet().iterator(); 
	       
	       while(iterPredicateDomainMap.hasNext()){
	    	   
	    	   String key = iterPredicateDomainMap.next();
	    	   String value = PredicateDomainMap.get(key);
	    	  
	    	   System.out.println(key+":"+value);
	    	   //System.out.println(value);
	    	      
	       }
		  
	       
	       System.out.println("==========================");
	       
			  Iterator<String> iterPredicateRangeMap = PredicateRangeMap.keySet().iterator(); 
		       
		       while(iterPredicateRangeMap.hasNext()){
		    	   
		    	   String key = iterPredicateRangeMap.next();
		    	   String value = PredicateRangeMap.get(key);
		    	  
		    	   System.out.println(key+":"+value);
		    	  // System.out.println(value);
		       }
		  
		  
		    DendrogramPanel dpobj = new DendrogramPanel();
		    dpobj.receiveLabelMap(labelMap);
		    dpobj.transferDomainMap(PredicateDomainMap);
		    dpobj.transferRangeMap(PredicateRangeMap);
		    
		    
		    MatrixPlus mpobj = new MatrixPlus();
		    mpobj.receiveLabelMap(labelMap);
		    
		    
		  //!  QueryGraph qg = new QueryGraph();
		  //!  qg.drawQueryGraph(PredicateDomainMap,PredicateRangeMap,PredicateList);
		      
		    
		    System.out.println("tempList size is: " + tempList.size());
		    System.out.println("count is: " + count);
		 
	       return PredicateList;
		  
	}

	
	

	
	
	public double[][] prepareLUBMDistanceMatrixData(List<String> columnList)
	{
		List<String> qList = new ArrayList<String>();
		
		int row = columnList.size();
		int column = columnList.size();
		double matrix[][] = new double[row][column]; 
		
		  System.out.println("ShareMap: "+ShareMap.size());
	       System.out.println("columnList: "+columnList.size());
		
		  Iterator<String> iterShareMap = ShareMap.keySet().iterator(); 
	       
	       while(iterShareMap.hasNext()){
	    	   
	    	   qList.clear();
	    	   
	    	   String key = iterShareMap.next();
	    	   
	    	  
	    	   SortedMap<String,Integer> valueMap = ShareMap.get(key);
	    	   int initialvalue = 0;

	    	   for (Map.Entry<String, Integer> entry : valueMap.entrySet()) {	
	    		   initialvalue = entry.getValue();    		
	    		   if(initialvalue==0)
	    		   {
	    			   continue;
	    		   }

	    		  if(!qList.contains(entry.getKey())){
	    		   distanceQ.add( entry.getKey() );
	    		   qList.add(entry.getKey());
	    		   
	    		   }
	    		   
	    		}
	    	   
	    	   while(distanceQ.size()!=0)
	    	   {
	    		   String predicate = distanceQ.remove();
	    		   
	    		   if(key.equals(predicate))
	    		   {
	    			   continue;
	    		   }
	    		   SortedMap<String,Integer> sonvalueMap = ShareMap.get(predicate);
	    		  
	    		   Iterator<String> itersonvalueMap = sonvalueMap.keySet().iterator(); 
	    	       
	    	       while(itersonvalueMap.hasNext()){
	    	    	   
	    	    	   String subkey = itersonvalueMap.next();
	    	    	   
	    	    	   if(key.equals(subkey))
		    		   {
		    			   continue;
		    		   }
	    	    	   
	    	    	   int subvalue = sonvalueMap.get(subkey);
	    	    	   if(subvalue==0)
	    	    	   {
	    	    		   continue;
	    	    	   }
	    	    	   
		    		  

	    	    	   if(!qList.contains(subkey)){
	    	    		   distanceQ.add( subkey );
	    	    		   qList.add(subkey);   
	    	    		   }
	    	    	   
	    	    	   if(valueMap.containsKey(subkey))
	    	    	   {  
	    	    		   int currentvalue = valueMap.get(subkey);
	    	    	/*	   System.out.println("0: "+key);
	    	    		   System.out.println("1: "+subkey);
	    	    		   System.out.println("2: "+ShareMap.get(key));
	    	    		   System.out.println("4: "+predicate);
	    	    		   System.out.println("3: "+ShareMap.get(key).get(predicate));
	    	    		   System.out.println(ShareMap.get(key).get(predicate)+subvalue);
	    	    		  */
	    	    		   
	    	    		 /*  if(currentvalue!=1){
	    	    		   valueMap.put(subkey, ShareMap.get(key).get(predicate)+subvalue);   
	    	    		   }*/
	    	    		   
	    	    		 
	    	    		   if(((currentvalue>subvalue+ShareMap.get(key).get(predicate))&&(currentvalue!=1))||(currentvalue==0))
	    	    		   {
	    	    			   valueMap.put(subkey, ShareMap.get(key).get(predicate)+subvalue);  
	    	    		   }
	    	    		   
	    	    	   }   
	    	       }
	    		   
	    	       
	    	   }
	    	   	    	   
	       }
	       
	     
	       
	       System.out.println("Following is Distance Matrix: ");
	       
	       System.out.print("\t");
			  for(int i=0;i<columnList.size();i++)
			  {
				//!  String name = columnList.get(i).split("#")[1];
				 //!--new String name = labelMap.get(columnList.get(i));
					
		    		 String name = "";
		    		if(labelMap.containsKey(columnList.get(i))){
					  if(labelMap.get(columnList.get(i)).contains("@")){
					    	name = labelMap.get(columnList.get(i)).split("@")[0];
					    	}
					    	else if(labelMap.get(columnList.get(i)).contains("^^"))
					    	{
					    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
					    	}
					    	else
					    	{
					    		name = labelMap.get(columnList.get(i));
					    	}
		    		}
		    		else
		    		{
		    			name = columnList.get(i);
		    		}
				  System.out.print(name+"\t");				  
			  }
	       
	       System.out.println();
			  for(int i=0;i<columnList.size();i++)
			  {
				//!  String name =  columnList.get(i).split("#")[1];
				 //!-new String name =  labelMap.get(columnList.get(i));
				  
				  
				  String name = "";
				if(labelMap.containsKey(columnList.get(i))){ 
				  if(labelMap.get(columnList.get(i)).contains("@")){
				    	name = labelMap.get(columnList.get(i)).split("@")[0];
				    	}
				    	else if(labelMap.get(columnList.get(i)).contains("^^"))
				    	{
				    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
				    	}
				    	else
				    	{
				    	name = labelMap.get(columnList.get(i));
				    	}
				}
				else
				{
					name = columnList.get(i);
				}
				  
				 // System.out.println(name);
				  for(int j=0;j<columnList.size();j++)
				  {
					  if(columnList.get(i).equals(columnList.get(j)))
					  {
						  matrix[i][j]=1;
						  name = name + "\t"+ matrix[i][j];
						  continue;
					  }
	    		      else
	    		      {
	    			      matrix[i][j]=ShareMap.get(columnList.get(i)).get(columnList.get(j));
	    			      name = name + "\t"+ matrix[i][j];
	    		      }
				  }
				  
				  System.out.println(name);
			  }
	       
	       
	       
	     
	       
	       for(int i=0;i<columnList.size();i++)
	       {
	    	   for(int j=0;j<columnList.size();j++)
	    	   {
	    		   if(columnList.get(i).equals(columnList.get(j)))
					  {
						  matrix[i][j]=1;
						  continue;
					  }
	    		   else
	    		      {
	    			      matrix[i][j]=ShareMap.get(columnList.get(i)).get(columnList.get(j));
	    			   
	    		      }
	    	   }
	       }
	       
	       
/*   Iterator<String> iterShareMap2 = ShareMap.keySet().iterator(); 
	       
	       while(iterShareMap2.hasNext()){
	    	   
	    	   String key = iterShareMap2.next();
	    	   SortedMap<String,Integer> valueMap = ShareMap.get(key);
	    	  
	    	   System.out.println(key+":");
	    	  
	    	   Iterator<String> itervalueMap3 = valueMap.keySet().iterator(); 
		       
		       while(itervalueMap3.hasNext()){
		    	   
		    	   String key2 = itervalueMap3.next();
		    	   int distance = valueMap.get(key2);
		    	   System.out.println(key2+":"+distance);
		    	   
		       }
	    	      
	    	   
	    	   System.out.println("==========================");
	       }*/
	       
	       
		
		 return matrix;
	}
	
	public double[][] prepareLUBMShareMatrixData(List<String> columnList)
	{
		
		 
		 int row = columnList.size();
		 int column = columnList.size();
		 double matrix[][] = new double[row][column]; 
		 double matrixProbSim[][]= new double[row][column]; 
		 double matrixShareProbSim[][] = new double[row][column];
		 
		 String domain1="";
		 String range1="";
		 String domain2="";
		 String range2="";
		 
		 System.out.println("Following is Sharing Matrix based on number of Sharing class between two nodes: ");
		 
		  System.out.print("\t");
		  for(int i=0;i<columnList.size();i++)
		  {
			//!  String name = columnList.get(i).split("#")[1];
			//!-new  String name = labelMap.get(columnList.get(i));
			  
			  String name = "";
			
			if(labelMap.containsKey(columnList.get(i))){
			  if(labelMap.get(columnList.get(i)).contains("@")){
			    	name = labelMap.get(columnList.get(i)).split("@")[0];
			    	}
			    	else if(labelMap.get(columnList.get(i)).contains("^^"))
			    	{
			    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
			    	}
			    	else
			    	{
			    	name = labelMap.get(columnList.get(i));
			    	}
			}
			else
			{
				name = columnList.get(i);
			}
			  
			  System.out.print(name+"\t");				  
		  }
		  System.out.println();
		  
		
        
		  
		 for(int i=0;i<columnList.size();i++)
		  {
			 //! String name =  columnList.get(i).split("#")[1];
			  
			//!-new String name = labelMap.get(columnList.get(i));
			 
			 String name = "";
			 if(labelMap.containsKey(columnList.get(i))){
			  if(labelMap.get(columnList.get(i)).contains("@")){
			    	name = labelMap.get(columnList.get(i)).split("@")[0];
			    	}
			    	else if(labelMap.get(columnList.get(i)).contains("^^"))
			    	{
			    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
			    	}
			    	else
			    	{
			    	name = labelMap.get(columnList.get(i));
			    	}
			    }
				else
				{
					name = columnList.get(i);
				}
			/*  if(columnList.get(i).contains("subClassOf"))
			  {
				  System.out.println();
			  }*/
			  
			  
			  for(int j=0;j<columnList.size();j++)
			  {
				 /* if(columnList.get(j).contains("subClassOf"))
				  {
					  System.out.println();
				  }*/
				  
				  
				  if(columnList.get(i).equals(columnList.get(j)))
				  {					 
					  matrix[i][j]=1;
					  name = name + "\t"+ matrix[i][j];	
					  continue;
				  }
				  
				 // System.out.println(columnList.get(i) + " and " + columnList.get(j));
				  
				  int count=0;
				  int distance=0;
				  
				  if(PredicateDomainMap.containsKey(columnList.get(i)))
				  {
					   domain1=PredicateDomainMap.get(columnList.get(i));
					  // System.out.println("domain1 is: "+domain1);
				  }
				  if(PredicateRangeMap.containsKey(columnList.get(i)))
				  {
					   range1=PredicateRangeMap.get(columnList.get(i));
					  // System.out.println("range1 is: "+range1);
				  }
				  if(PredicateDomainMap.containsKey(columnList.get(j)))
				  {
					   domain2=PredicateDomainMap.get(columnList.get(j));
					 //  System.out.println("domain2 is: "+domain2);
				  }
				  if(PredicateDomainMap.containsKey(columnList.get(j)))
				  {
					   range2=PredicateRangeMap.get(columnList.get(j));
					 //  System.out.println("range2 is: "+range2);
				  }
				  
	 
				//  System.out.println("******************"+ columnList.get(i)+":"+columnList.get(j));
				  
				  if(domain1.equals(domain2))
				  {
					  count=count+1;
				  }
				  if(domain1.equals(range2))
				  {
					  count=count+1;
				  }
				  if(range1.equals(domain2))
				  {
					  count=count+1;
				  }
				  if(range1.equals(range2))
				  {
					  count=count+1;
				  }
				  		 			
				  
				  matrix[i][j]=count;
				 // System.out.println(columnList.get(i) + " and " + columnList.get(j)+":"+count);
				  
				  
				  if(count==0)
				  {
					  distance=0;
				  }
				  else
				  {
					  distance=1;
					  
					  if(!neighbourMap.containsKey(columnList.get(i)))
					  {
						  List<String> neighbourList = new ArrayList<String>();
						  neighbourList.add(columnList.get(j));	
						  neighbourMap.put(columnList.get(i), neighbourList);
					  }
					  else
					  {
						  List<String> neighbourList = neighbourMap.get(columnList.get(i));
						  neighbourList.add(columnList.get(j));	
						  neighbourMap.put(columnList.get(i), neighbourList);
					  }
					  
				  }
				  
				  if(!ShareMap.containsKey(columnList.get(i))){  
				  SortedMap<String,Integer> nextMap = new TreeMap<String,Integer>();
				  if(!nextMap.containsKey(columnList.get(j)))
				  {
					  nextMap.put(columnList.get(j),distance );
				  }
				  
				  ShareMap.put(columnList.get(i), nextMap);
				  }
				  else
				  {
					  SortedMap<String,Integer> nextMap = ShareMap.get(columnList.get(i));
					  if(!nextMap.containsKey(columnList.get(j)))
					  {
						  nextMap.put(columnList.get(j),distance );
					  }
					  ShareMap.put(columnList.get(i), nextMap);
				  }
				  
				  
				  if(!ShareMap.containsKey(columnList.get(j))){  
					  SortedMap<String,Integer> nextMap = new TreeMap<String,Integer>();
					  if(!nextMap.containsKey(columnList.get(i)))
					  {
						  nextMap.put(columnList.get(i),distance );
					  }
					  
					  ShareMap.put(columnList.get(j), nextMap);
				  }
				  else
				  {
					  SortedMap<String,Integer> nextMap = ShareMap.get(columnList.get(j));
					  if(!nextMap.containsKey(columnList.get(i)))
					  {
						  nextMap.put(columnList.get(i),distance );
					  }
					  ShareMap.put(columnList.get(j), nextMap);
				  }
				    
				  name = name + "\t"+ matrix[i][j];	
			  }		
			  
			 //! System.out.println(name);
		  }
		
		 
		/* Iterator<String> iterShareMap = ShareMap.keySet().iterator(); 
	       
	       while(iterShareMap.hasNext()){
	    	   
	    	   String key = iterShareMap.next();
	    	   SortedMap<String,Integer> valueMap = ShareMap.get(key);
	    	  
	    	   //System.out.println(key+":");
	    	  
	    	   Iterator<String> itervalueMap = valueMap.keySet().iterator(); 
		       
		       while(itervalueMap.hasNext()){
		    	   
		    	   String key2 = itervalueMap.next();
		    	   int distance = valueMap.get(key2);
		    	   //System.out.println(key2+":"+distance);
		    	   
		       }
	    	      
	    	   
	    	   System.out.println("==========================");
	       }
		 */
		 
		 
		 /////// Calculate 2nd level neighbour ///////
		 Iterator<String> iterFor2ndNeighbour = neighbourMap.keySet().iterator(); 
		   while(iterFor2ndNeighbour.hasNext()){
			   
			   String key = iterFor2ndNeighbour.next();
			   List<String> neighbourList = neighbourMap.get(key);
			   for(int n=0;n<neighbourList.size();n++)
			   {
				   if(!neighbourMap2nd.containsKey(key))
				   {
					   List<String> List = new ArrayList<String>();
					   if(neighbourMap.containsKey(neighbourList.get(n)))
					   {
						   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
						   for(int x=0;x<neighbourList2nd.size();x++)
						   {
							   if(!List.contains(neighbourList2nd.get(x)))
							   List.add(neighbourList2nd.get(x));
						   }
						   
						   neighbourMap2nd.put(key,List);
					   }
				   }
				   else
				   {
					   List<String> List = neighbourMap2nd.get(key);
					   if(neighbourMap.containsKey(neighbourList.get(n)))
					   {
						   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
						   for(int x=0;x<neighbourList2nd.size();x++)
						   {
							   if(!List.contains(neighbourList2nd.get(x)))
							   List.add(neighbourList2nd.get(x));
						   }
						   
						   neighbourMap2nd.put(key,List);
					   }
				   }
			   }   
		   }
		 
		 
		   
		   
		   
		   
		   /////// Calculate 3rd level neighbour ///////
			 Iterator<String> iterFor3rdNeighbour = neighbourMap2nd.keySet().iterator(); 
			   while(iterFor3rdNeighbour.hasNext()){
				   
				   String key = iterFor3rdNeighbour.next();
				   List<String> neighbourList = neighbourMap2nd.get(key);
				   for(int n=0;n<neighbourList.size();n++)
				   {
					   if(!neighbourMap3rd.containsKey(key))
					   {
						   List<String> List = new ArrayList<String>();
						   if(neighbourMap.containsKey(neighbourList.get(n)))
						   {
							   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
							   for(int x=0;x<neighbourList2nd.size();x++)
							   {
								   if(!List.contains(neighbourList2nd.get(x)))
								   List.add(neighbourList2nd.get(x));
							   }
							   
							   neighbourMap3rd.put(key,List);
						   }
					   }
					   else
					   {
						   List<String> List = neighbourMap3rd.get(key);
						   if(neighbourMap.containsKey(neighbourList.get(n)))
						   {
							   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
							   for(int x=0;x<neighbourList2nd.size();x++)
							   {
								   if(!List.contains(neighbourList2nd.get(x)))
								   List.add(neighbourList2nd.get(x));
							   }
							   
							   neighbourMap3rd.put(key,List);
						   }
					   }
				   }   
			   }
		 
		 
		 
		 
		 
		 
		 
		 
		//************************** 1 level Neighbor*****************************//
		 
		/*!!		 System.out.println();
				 
				 System.out.println("Following is Sharing Matrix based on probability similarity between neighbours --- 1 level: ");
				 
				  System.out.print("\t");
				  

					String[][] csvMatrix = new String[columnList.size()+1][columnList.size()]; //// add by 7/18/2014
					
				  for(int i=0;i<columnList.size();i++)
				  {
					//!  String name = columnList.get(i).split("#")[1];
					//!-new  String name = labelMap.get(columnList.get(i));
					  
					  String name = "";
					if(labelMap.containsKey(columnList.get(i))){
					  if(labelMap.get(columnList.get(i)).contains("@")){
					    	name = labelMap.get(columnList.get(i)).split("@")[0];
					    	}
					    	else if(labelMap.get(columnList.get(i)).contains("^^"))
					    	{
					    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
					    	}
					    	else
					    	{
					    	name = labelMap.get(columnList.get(i));
					    	}
					}
					else
					{
						name = columnList.get(i);
					}
					  
				
					csvMatrix[0][i] =name; //// add by 7/18/2014
					
					
				    System.out.print(name+"\t");		
					  
					  
				  }
				  
				 
				  
				  System.out.println();

				  for(int i=0;i<columnList.size();i++)
				  {
					  float ps = 0;
					  float ps2=0;
					  float ps3=0;
					  
					  String name = "";
					  String name2="";
						 if(labelMap.containsKey(columnList.get(i))){
						  if(labelMap.get(columnList.get(i)).contains("@")){
						    	name = labelMap.get(columnList.get(i)).split("@")[0];
						    	}
						    	else if(labelMap.get(columnList.get(i)).contains("^^"))
						    	{
						    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
						    	}
						    	else
						    	{
						    	name = labelMap.get(columnList.get(i));
						    	}
						    }
							else
							{
								name = columnList.get(i);
							}
					  
						 
						//!  csvMatrix3[i+1][0] =name; //// add by 7/18/2014
			
					  
					  for(int j=0;j<columnList.size();j++)
					  {
						  if(columnList.get(i).equals(columnList.get(j)))
						  {	
							  ps=1;
							  matrixProbSim[i][j]=ps;
							  name = name + "\t"+ matrixProbSim[i][j];	
							  name2 = name2+ matrixProbSim[i][j] + "\t";
							  csvMatrix[i+1][j] =Float.toString(ps); //// add by 7/18/2014
							  continue;
						  }
						  
						 // System.out.println(columnList.get(i) + " and " + columnList.get(j));
						  
						  int count=0;
						  int distance=0;
						  
						  List<String> neighbourList1 = new ArrayList<String>();
						  List<String> neighbourList2 = new ArrayList<String>();
						  
						  if(neighbourMap.containsKey(columnList.get(i)))
						  {
							  neighbourList1 = neighbourMap.get(columnList.get(i));
						  }
						  if(neighbourMap.containsKey(columnList.get(j)))
						  {
							  neighbourList2 = neighbourMap.get(columnList.get(j));
						  }
					
						  List<String> common = new ArrayList<String>(neighbourList1);
			    		  common.retainAll(neighbourList2);
			    		  
			    		 
			    		  if(common.size()!=0){
			    		  ps = ((float)common.size()/(float)neighbourList1.size())*((float)common.size()/(float)neighbourList2.size());
			    		  ps=ps*(float)1.0;
			    		  }
			    		  else
			    		  {
			    		  ps=0;
			    		  }
			    		  
			    	
			    		
			    		if(neighbourMap2nd.containsKey(columnList.get(j)))
			    		 {
			    			neighbourList2 = neighbourMap2nd.get(columnList.get(j)); 
			    		 }
			    		  List<String> common2 = new ArrayList<String>(neighbourList1);
			    	      common2.retainAll(neighbourList2);
			    	    		  
			    	    		 
		    		    		 
			    	      if(common2.size()!=0){
			    	    	ps2 = ((float)common2.size()/(float)neighbourList1.size())*((float)common2.size()/(float)neighbourList2.size());
			    		    ps2=ps2*(float)0;
			    	      }
			    	      else
			    	      {
			    	    	ps2=0;
			    	      }
			    	    		  

			    	    		  
			    	     if(neighbourMap3rd.containsKey(columnList.get(j)))
			    	      {
			    	    	neighbourList2 = neighbourMap3rd.get(columnList.get(j)); 
			    	      }
			    	    	  
			    	     List<String> common3 = new ArrayList<String>(neighbourList1);
			    	     common3.retainAll(neighbourList2);
			    	    			
			    	     if(common3.size()!=0){
			    	    	ps3 = ((float)common3.size()/(float)neighbourList1.size())*((float)common3.size()/(float)neighbourList2.size());
		    				ps3=ps3*(float)0;
			    	     }
			    	      else
			    	      {
			    	    	ps3=0;
			    	      }

		    	    		ps = ps+ps2+ps3;
		    	    		matrixProbSim[i][j]=ps;
		    	    		name = name + "\t"+ ps;
		    	    		name2 = name2+ps+"\t";
			    	    
		    	    		csvMatrix[i+1][j] =Float.toString(ps); //// add by 7/18/2014
			    		//  System.out.println(ps);
			    		  //System.out.println(csvMatrix[1][2] );
					  }
					  
					  System.out.println(name);
				  }
				 
				  
				  writeCsv2(csvMatrix,"E:/NeiborCSV/neighborCsv.csv");
				
				  long end = System.currentTimeMillis();
				 
				 System.out.println("It takes " + (end-start0) + " ms to finish neighbour matrix");
			  
				 csvToXLSX("E:/NeiborCSV/neighborCsv.csv","E:/NeiborCSV/neighborCsv.xls");
		 
		 !!*/
		 
		 
		 
		 
		//************************** 2 level Neighbor*****************************//
		 
		 
	/*!!	 System.out.println();
			 
			 System.out.println("Following is Sharing Matrix based on probability similarity between neighbours --- 2 level: ");
			 
			  System.out.print("\t");
			  

				String[][] csvMatrix2 = new String[columnList.size()+1][columnList.size()]; //// add by 7/18/2014
				
			  for(int i=0;i<columnList.size();i++)
			  {
				//!  String name = columnList.get(i).split("#")[1];
				//!-new  String name = labelMap.get(columnList.get(i));
				  
				  String name = "";
				if(labelMap.containsKey(columnList.get(i))){
				  if(labelMap.get(columnList.get(i)).contains("@")){
				    	name = labelMap.get(columnList.get(i)).split("@")[0];
				    	}
				    	else if(labelMap.get(columnList.get(i)).contains("^^"))
				    	{
				    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
				    	}
				    	else
				    	{
				    	name = labelMap.get(columnList.get(i));
				    	}
				}
				else
				{
					name = columnList.get(i);
				}
				  
			
				csvMatrix2[0][i] =name; //// add by 7/18/2014
				
				
			    System.out.print(name+"\t");		
				  
				  
			  }
			  
			 
			  
			  System.out.println();

			  for(int i=0;i<columnList.size();i++)
			  {
				  float ps = 0;
				  float ps2=0;
				  float ps3=0;
				  
				  String name = "";
				  String name2="";
					 if(labelMap.containsKey(columnList.get(i))){
					  if(labelMap.get(columnList.get(i)).contains("@")){
					    	name = labelMap.get(columnList.get(i)).split("@")[0];
					    	}
					    	else if(labelMap.get(columnList.get(i)).contains("^^"))
					    	{
					    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
					    	}
					    	else
					    	{
					    	name = labelMap.get(columnList.get(i));
					    	}
					    }
						else
						{
							name = columnList.get(i);
						}
				  
					 
					//!  csvMatrix3[i+1][0] =name; //// add by 7/18/2014
		
				  
				  for(int j=0;j<columnList.size();j++)
				  {
					  if(columnList.get(i).equals(columnList.get(j)))
					  {	
						  ps=1;
						  matrixProbSim[i][j]=ps;
						  name = name + "\t"+ matrixProbSim[i][j];	
						  name2 = name2+ matrixProbSim[i][j] + "\t";
						  csvMatrix2[i+1][j] =Float.toString(ps); //// add by 7/18/2014
						  continue;
					  }
					  
					 // System.out.println(columnList.get(i) + " and " + columnList.get(j));
					  
					  int count=0;
					  int distance=0;
					  
					  List<String> neighbourList1 = new ArrayList<String>();
					  List<String> neighbourList2 = new ArrayList<String>();
					  
					  if(neighbourMap.containsKey(columnList.get(i)))
					  {
						  neighbourList1 = neighbourMap.get(columnList.get(i));
					  }
					  if(neighbourMap.containsKey(columnList.get(j)))
					  {
						  neighbourList2 = neighbourMap.get(columnList.get(j));
					  }
				
					  List<String> common = new ArrayList<String>(neighbourList1);
		    		  common.retainAll(neighbourList2);
		    		  
		    		 
		    		  if(common.size()!=0){
		    		  ps = ((float)common.size()/(float)neighbourList1.size())*((float)common.size()/(float)neighbourList2.size());
		    		  ps=ps*(float)0.6;
		    		  }
		    		  else
		    		  {
		    		  ps=0;
		    		  }
		    		  
		    	
		    		
		    		if(neighbourMap2nd.containsKey(columnList.get(j)))
		    		 {
		    			neighbourList2 = neighbourMap2nd.get(columnList.get(j)); 
		    		 }
		    		  List<String> common2 = new ArrayList<String>(neighbourList1);
		    	      common2.retainAll(neighbourList2);
		    	    		  
		    	    		 
	    		    		 
		    	      if(common2.size()!=0){
		    	    	ps2 = ((float)common2.size()/(float)neighbourList1.size())*((float)common2.size()/(float)neighbourList2.size());
		    		    ps2=ps2*(float)0.4;
		    	      }
		    	      else
		    	      {
		    	    	ps2=0;
		    	      }
		    	    		  

		    	    		  
		    	     if(neighbourMap3rd.containsKey(columnList.get(j)))
		    	      {
		    	    	neighbourList2 = neighbourMap3rd.get(columnList.get(j)); 
		    	      }
		    	    	  
		    	     List<String> common3 = new ArrayList<String>(neighbourList1);
		    	     common3.retainAll(neighbourList2);
		    	    			
		    	     if(common3.size()!=0){
		    	    	ps3 = ((float)common3.size()/(float)neighbourList1.size())*((float)common3.size()/(float)neighbourList2.size());
	    				ps3=ps3*(float)0;
		    	     }
		    	      else
		    	      {
		    	    	ps3=0;
		    	      }

	    	    		ps = ps+ps2+ps3;
	    	    		matrixProbSim[i][j]=ps;
	    	    		name = name + "\t"+ ps;
	    	    		name2 = name2+ps+"\t";
		    	    
	    	    		csvMatrix2[i+1][j] =Float.toString(ps); //// add by 7/18/2014
		    		//  System.out.println(ps);
		    		  //System.out.println(csvMatrix[1][2] );
				  }
				  
				  System.out.println(name);
			  }
			 
			  
			  writeCsv2(csvMatrix2,"E:/NeiborCSV/neighborCsv2.csv");
			
			  long end2 = System.currentTimeMillis();
			 
			 System.out.println("It takes " + (end2-start0) + " ms to finish neighbour matrix");
		  
			 csvToXLSX("E:/NeiborCSV/neighborCsv2.csv","E:/NeiborCSV/neighborCsv2.xls");
		 !!*/
		 
		 
		//************************** 3 level Neighbor*****************************//
		 
			
		 
			  System.out.println();
			 
			  System.out.println("Following is Sharing Matrix based on probability similarity between neighbours --- 3 level: ");
			 
			  System.out.print("\t");
			  
				 
				
				String[][] csvMatrix3 = new String[columnList.size()+1][columnList.size()]; //// add by 7/18/2014
				
			  for(int i=0;i<columnList.size();i++)
			  {
				//!  String name = columnList.get(i).split("#")[1];
				//!-new  String name = labelMap.get(columnList.get(i));
				  
				  String name = "";
				if(labelMap.containsKey(columnList.get(i))){
				  if(labelMap.get(columnList.get(i)).contains("@")){
				    	name = labelMap.get(columnList.get(i)).split("@")[0];
				    	}
				    	else if(labelMap.get(columnList.get(i)).contains("^^"))
				    	{
				    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
				    	}
				    	else
				    	{
				    	name = labelMap.get(columnList.get(i));
				    	}
				}
				else
				{
					name = columnList.get(i);
				}
				  
			
				csvMatrix3[0][i] =name; //// add by 7/18/2014
				
				
			    System.out.print(name+"\t");		
				  
				  
			  }
			  
			 
			  
			  System.out.println();

			  for(int i=0;i<columnList.size();i++)
			  {
				  float ps = 0;
				  float ps2=0;
				  float ps3=0;
				  
				  String name = "";
				  String name2="";
					 if(labelMap.containsKey(columnList.get(i))){
					  if(labelMap.get(columnList.get(i)).contains("@")){
					    	name = labelMap.get(columnList.get(i)).split("@")[0];
					    	}
					    	else if(labelMap.get(columnList.get(i)).contains("^^"))
					    	{
					    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
					    	}
					    	else
					    	{
					    	name = labelMap.get(columnList.get(i));
					    	}
					    }
						else
						{
							name = columnList.get(i);
						}
				  
					 
					//!  csvMatrix3[i+1][0] =name; //// add by 7/18/2014
		
				  
				  for(int j=0;j<columnList.size();j++)
				  {
					  if(columnList.get(i).equals(columnList.get(j)))
					  {	
						  ps=1;
						  matrixProbSim[i][j]=ps;
						  name = name + "\t"+ matrixProbSim[i][j];	
						  name2 = name2+ matrixProbSim[i][j] + "\t";
						  csvMatrix3[i+1][j] =Float.toString(ps); //// add by 7/18/2014
						  continue;
					  }
					  
					 // System.out.println(columnList.get(i) + " and " + columnList.get(j));
					  
					  int count=0;
					  int distance=0;
					  
					  List<String> neighbourList1 = new ArrayList<String>();
					  List<String> neighbourList2 = new ArrayList<String>();
					  
					  if(neighbourMap.containsKey(columnList.get(i)))
					  {
						  neighbourList1 = neighbourMap.get(columnList.get(i));
					  }
					  if(neighbourMap.containsKey(columnList.get(j)))
					  {
						  neighbourList2 = neighbourMap.get(columnList.get(j));
					  }
				
					  List<String> common = new ArrayList<String>(neighbourList1);
		    		  common.retainAll(neighbourList2);
		    		  
		    		 
		    		  if(common.size()!=0){
		    		//!  ps = ((float)common.size()/(float)neighbourList1.size())*((float)common.size()/(float)neighbourList2.size()); //probability based simi
		    		//!	  ps = ((float)common.size()/((float)neighbourList1.size()+(float)neighbourList2.size())); //jaccard
		    			  
		    			  ps = (2*(float)common.size()/((float)neighbourList1.size()+(float)neighbourList2.size())); //Sorensen-Dice coefficient
		    			  
		    		//	  ps = 1-ps;
		    		//  ps=ps*10;//!!! temp add 4.21.2015
		    		  }
		    		  else
		    		  {
		    		  ps=0;
		    		  }
		    		  
		    	
		    		
		    		if(neighbourMap2nd.containsKey(columnList.get(j)))
		    		 {
		    			neighbourList2 = neighbourMap2nd.get(columnList.get(j)); 
		    		 }
		    		
		    		
		    		//// If (A,C) are second level, (A,B) and (B,C) are first level, then P(A,C) = P(A,B)*P(B,C) ---- add by 9/2/2014
		    		 List<String> neighbourListMiddle2 = new ArrayList<String>();
		    		 if(neighbourMap.containsKey(columnList.get(j))){
		    		 neighbourListMiddle2 = neighbourMap.get(columnList.get(j));
		    		 }
		    		 List<String> commonMiddle2 = new ArrayList<String>(neighbourListMiddle2);	
		    		commonMiddle2.retainAll(neighbourList2);
		    	//!	float wps2 = ((float)commonMiddle2.size()/(float)neighbourListMiddle2.size())*((float)commonMiddle2.size()/(float)neighbourList2.size()); //probability based simi
		    		
		    	//!	float wps2 = ((float)commonMiddle2.size()/((float)neighbourListMiddle2.size()+(float)neighbourList2.size()));//jaccard
		    		
		    		float wps2 = (2*(float)commonMiddle2.size()/((float)neighbourListMiddle2.size()+(float)neighbourList2.size()));//Sorensen-Dice coefficient
		    		
		    	//	wps2=1-wps2;
		    		
		    		List<String> neighbourListMiddle3 = new ArrayList<String>();
		    		 if(neighbourMap2nd.containsKey(columnList.get(j))){
		    		neighbourListMiddle3 = neighbourMap2nd.get(columnList.get(j));
		    		 }
		    		List<String> commonMiddle3 = new ArrayList<String>(neighbourListMiddle3);	
		    		commonMiddle3.retainAll(neighbourListMiddle2);
		    		//!float wps3 = ((float)commonMiddle3.size()/(float)neighbourListMiddle3.size())*((float)commonMiddle3.size()/(float)neighbourListMiddle2.size()); ///probability based simi
		    		//!float wps3 = ((float)commonMiddle3.size()/((float)neighbourListMiddle3.size()+(float)neighbourListMiddle2.size()));//jaccard
		    		
		    		float wps3 = (2*(float)commonMiddle3.size()/((float)neighbourListMiddle3.size()+(float)neighbourListMiddle2.size()));//Sorensen-Dice coefficient
		    		
		    		///
		    	//	wps3 = 1-wps3;
		    		
		    		
		    		
		    		  List<String> common2 = new ArrayList<String>(neighbourList1);
		    	      common2.retainAll(neighbourList2);
		    	    		  
		    	    		 
	    		    		 
		    	      if(common2.size()!=0){
		    	    //!	ps2 = ((float)common2.size()/(float)neighbourList1.size())*((float)common2.size()/(float)neighbourList2.size());//probability based simi
		    		//    ps2=ps2*wps2*10;///!! temp comment 4.21.2015
		    		 //   ps2 = ps2*5;/// temp add by 4.21.2015
		    		    //ps = ps2; //temp add by 4.22.2015
		    		    //!ps2 = ((float)common2.size()/((float)neighbourList1.size()+(float)neighbourList2.size())); // jaccard
		    	    	  
		    	    	  ps2 = (2*(float)common2.size()/((float)neighbourList1.size()+(float)neighbourList2.size()));//Sorensen-Dice coefficient
		    		    ps2=ps2*wps2*5;
		    		 //   ps2=1-ps2;
		    	      }
		    	      else
		    	      {
		    	    	ps2=0;
		    	      }
		    	    		  

		    	    		  
		    	     if(neighbourMap3rd.containsKey(columnList.get(j)))
		    	      {
		    	    	neighbourList2 = neighbourMap3rd.get(columnList.get(j)); 
		    	      }
		    	    	  
		    	     List<String> common3 = new ArrayList<String>(neighbourList1);
		    	     common3.retainAll(neighbourList2);
		    	    			
		    	     if(common3.size()!=0){
		    	   //! 	ps3 = ((float)common3.size()/(float)neighbourList1.size())*((float)common3.size()/(float)neighbourList2.size());//probability based simi
	    			//!	ps3=ps3*wps2*wps3*5;///!! temp comment 4.21.2015
	    				 //ps3 = ps3*3;/// temp add by 4.21.2015
	    			//!	ps = ps3; //temp add by 4.22.2015
		    	    	//!	ps3 = ((float)common3.size()/((float)neighbourList1.size()+(float)neighbourList2.size()));//jaccard
		    	    	 
		    	    	 ps3 = (2*(float)common3.size()/((float)neighbourList1.size()+(float)neighbourList2.size()));//Sorensen-Dice coefficient
		    	    		ps3=ps3*wps2*wps3*3;
		    	    		//ps3 = 1-ps3;
		    	     }
		    	      else
		    	      {
		    	    	ps3=0;
		    	      }

	    	    		ps = ps+ps2+ps3; // comment by 4.22.2015
	    	    		matrixProbSim[i][j]=ps;
	    	    		name = name + "\t"+ ps;
	    	    		name2 = name2+ps+"\t";
		    	    
		    		  csvMatrix3[i+1][j] =Float.toString(ps); //// add by 7/18/2014
		    		//  System.out.println(ps);
		    		  //System.out.println(csvMatrix[1][2] );
				  }
				  
				  System.out.println(name);
			  }
			 
			  
			//!  writeCsv2(csvMatrix3,"E:/NeiborCSV/neighborCsv3.csv");
			  writeCsv2(csvMatrix3,"/home/user/NeiborCSV/neighborCsv3.csv");
			
			  long end3 = System.currentTimeMillis();
			 
			 System.out.println("It takes " + (end3-start0) + " ms to finish neighbour matrix");
		  
			//! csvToXLSX("E:/NeiborCSV/neighborCsv3.csv","E:/NeiborCSV/neighborCsv3.xls");
		  
			 csvToXLSX("/home/user/NeiborCSV/neighborCsv3.csv","/home/user/NeiborCSV/neighborCsv3.xls");
			  
		  
		  
		  
		  
		  
		  
	/*!!	  System.out.println();
			 
			 System.out.println("Following is Sharing Matrix based on probability similarity between sharing classes: ");
			 
			  System.out.print("\t");
			  for(int i=0;i<columnList.size();i++)
			  {
				//!  String name = columnList.get(i).split("#")[1];
				//!-new  String name = labelMap.get(columnList.get(i));
				  
				  String name = "";
				if(labelMap.containsKey(columnList.get(i))){
				  if(labelMap.get(columnList.get(i)).contains("@")){
				    	name = labelMap.get(columnList.get(i)).split("@")[0];
				    	}
				    	else if(labelMap.get(columnList.get(i)).contains("^^"))
				    	{
				    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
				    	}
				    	else
				    	{
				    	name = labelMap.get(columnList.get(i));
				    	}
				}
				else
				{
					name = columnList.get(i);
				}
				  
				  System.out.print(name+"\t");				  
			  }
			  System.out.println();
			 
			 
			  
			  for(int i=0;i<columnList.size();i++)
			  {
				  String name = "";
					 if(labelMap.containsKey(columnList.get(i))){
					  if(labelMap.get(columnList.get(i)).contains("@")){
					    	name = labelMap.get(columnList.get(i)).split("@")[0];
					    	}
					    	else if(labelMap.get(columnList.get(i)).contains("^^"))
					    	{
					    	name = labelMap.get(columnList.get(i)).split(Pattern.quote("^^"))[0];
					    	}
					    	else
					    	{
					    	name = labelMap.get(columnList.get(i));
					    	}
					    }
						else
						{
							name = columnList.get(i);
						}
				  
				  
				  for(int j=0;j<columnList.size();j++)
				  {
					  if(columnList.get(i).equals(columnList.get(j)))
					  {					 
						  matrixShareProbSim[i][j]=1;
						  name = name + "\t"+ matrixShareProbSim[i][j];	
						  continue;
					  }
					  
					 // System.out.println(columnList.get(i) + " and " + columnList.get(j));
					  
					  int count=0;
					  int distance=0;
					  
					  List<String> shareList1 = new ArrayList<String>();
					  List<String> shareList2 = new ArrayList<String>();
					  
					  if(Share_Probability_Map.containsKey(columnList.get(i)))
					  {
						  shareList1 = Share_Probability_Map.get(columnList.get(i));
					  }
					  if(Share_Probability_Map.containsKey(columnList.get(j)))
					  {
						  shareList2 = Share_Probability_Map.get(columnList.get(j));
					  }
				
					  List<String> common2 = new ArrayList<String>(shareList1);
		    		  common2.retainAll(shareList2);
		    		  
		    		  if(common2.size()==0)
		    		  {
		    			  matrixShareProbSim[i][j]=0;
		    			  name = name + "\t" + "0";
		    		  }
		    		  else{
			    		  float ps = ((float)common2.size()/(float)shareList1.size())*((float)common2.size()/(float)shareList2.size());
			    		  
			    		  matrixShareProbSim[i][j]=ps;
			    		  name = name + "\t"+ ps;
			    		  }  
				  }
				  
				  System.out.println(name);
				  
			  }
		  

	       
		 ExcelWriter ew = new ExcelWriter();
		 ew.receiveNeighbourMap(neighbourMap);
		 ew.receivePredicateDomainMap(PredicateDomainMap);
		 ew.receivePredicateRangeMap(PredicateRangeMap);
		 
		 QueryGUI qg = new QueryGUI();
		 qg.receiveNeighbourMap(neighbourMap); !!*/  //comment by 4.21.2015
		 
		 
		 return matrix;
	}
	
	
	public  void prepareLUBMInDegreeMatrixData(List<String> listnames)
	{
		 /*OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM); // comment by 11.14.2013
		 m.read("file:///"+owlFile);*/
	/*	 int row = columnList.size();
		 int column = columnList.size();
		 double matrix[][] = new double[row][column]; 
		 */

		
		for(int i =0;i<listnames.size();i++){
			
			String key = listnames.get(i);
			 String predicatename = "";
			 List<String> realIndegreeList = new ArrayList<String>();
			if(predicateSubjMap.containsKey(key))
			{
				 List<String> value = predicateSubjMap.get(key);
		    	  
		    	  
		    	   for(int x=0;x<value.size();x++)
		    	   {
		    		   if(tripleMap.containsKey("o:"+value.get(x)))
		    		   {
		    			   if(!realIndegreeList.contains(value.get(x)))
		    			   {
		    				   realIndegreeList.add(value.get(x));
		    			   }
		    		   }
		    	   }
		    	   
		    	  
		    	   
		    		 if(labelMap.containsKey(key)){
		   			  if(labelMap.get(key).contains("@")){
		   				predicatename = labelMap.get(key).split("@")[0];
		   			    	}
		   			    	else if(labelMap.get(key).contains("^^"))
		   			    	{
		   			    		predicatename = labelMap.get(key).split(Pattern.quote("^^"))[0];
		   			    	}
		   			    	else
		   			    	{
		   			    		predicatename = labelMap.get(key);
		   			    	}
		       	}
		      		 else
		      		 {
		      			predicatename = key;
		      		 }
		    		 System.out.println(predicatename+"	"+realIndegreeList.size());
			}
			else
			{
				predicatename = key;
				 System.out.println(predicatename+"	"+realIndegreeList.size());
			}
		}
		
		 /* Iterator<String> iterpredicateSubjMap = predicateSubjMap.keySet().iterator(); 
	       
	       while(iterpredicateSubjMap.hasNext()){
	    	   
	    	   String key = iterpredicateSubjMap.next();
	    	   List<String> value = predicateSubjMap.get(key);
	    	   List<String> realIndegreeList = new ArrayList<String>();
	    	   
	    	   for(int x=0;x<value.size();x++)
	    	   {
	    		   if(tripleMap.containsKey("o:"+value.get(x)))
	    		   {
	    			   if(!realIndegreeList.contains(value.get(x)))
	    			   {
	    				   realIndegreeList.add(value.get(x));
	    			   }
	    		   }
	    	   }
	    	   
	    	   String predicatename = "";
	    	   
	    		 if(labelMap.containsKey(key)){
	   			  if(labelMap.get(key).contains("@")){
	   				predicatename = labelMap.get(key).split("@")[0];
	   			    	}
	   			    	else if(labelMap.get(key).contains("^^"))
	   			    	{
	   			    		predicatename = labelMap.get(key).split(Pattern.quote("^^"))[0];
	   			    	}
	   			    	else
	   			    	{
	   			    		predicatename = labelMap.get(key);
	   			    	}
	       	}
	      		 else
	      		 {
	      			predicatename = key;
	      		 }
	    	   
	    	   
	    	   System.out.println(predicatename+"	"+realIndegreeList.size());
	   
	       }	 */
		// return matrix;

	}
	
	
	public  void prepareLUBMOutDegreeMatrixData(List<String> listnames)
	{
		/* OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM); // comment by 11.14.2013
		 m.read("file:///"+owlFile);*/
	/*	 int row = columnList.size();
		 int column = columnList.size();
		 double matrix[][] = new double[row][column]; 
		 */

		
		for(int i =0;i<listnames.size();i++){
			
			String key = listnames.get(i);
			 String predicatename = "";
			 List<String> realIndegreeList = new ArrayList<String>();
			
			 if(predicateObjMap.containsKey(key))
				{
					 List<String> value = predicateObjMap.get(key);
			    	  
			    	  
			    	   for(int x=0;x<value.size();x++)
			    	   {
			    		   if(tripleMap.containsKey("s:"+value.get(x)))
			    		   {
			    			   if(!realIndegreeList.contains(value.get(x)))
			    			   {
			    				   realIndegreeList.add(value.get(x));
			    			   }
			    		   }
			    	   }
			    	   
			    	  
			    	   
			    		 if(labelMap.containsKey(key)){
			   			  if(labelMap.get(key).contains("@")){
			   				predicatename = labelMap.get(key).split("@")[0];
			   			    	}
			   			    	else if(labelMap.get(key).contains("^^"))
			   			    	{
			   			    		predicatename = labelMap.get(key).split(Pattern.quote("^^"))[0];
			   			    	}
			   			    	else
			   			    	{
			   			    		predicatename = labelMap.get(key);
			   			    	}
			       	}
			      		 else
			      		 {
			      			predicatename = key;
			      		 }
			    		 System.out.println(predicatename+"	"+realIndegreeList.size());
				}
				else
				{
					predicatename = key;
					 System.out.println(predicatename+"	"+realIndegreeList.size());
				}
		}
		
		
		/*  Iterator<String> iterpredicateObjMap= predicateObjMap.keySet().iterator(); 
	       
	       while(iterpredicateObjMap.hasNext()){
	    	   
	    	   String key = iterpredicateObjMap.next();
	    	   List<String> value = predicateObjMap.get(key);
	    	   
	    	   List<String> realoutdegreeList = new ArrayList<String>();
	    	   
	    	   for(int x=0;x<value.size();x++)
	    	   {
	    		   if(tripleMap.containsKey("s:"+value.get(x)))
	    		   {
	    			   if(!realoutdegreeList.contains(value.get(x)))
	    			   {
	    				   realoutdegreeList.add(value.get(x));
	    			   }
	    		   }
	    	   }
	    	   
	    	   String predicatename = "";
	    	   
	    		 if(labelMap.containsKey(key)){
	   			  if(labelMap.get(key).contains("@")){
	   				predicatename = labelMap.get(key).split("@")[0];
	   			    	}
	   			    	else if(labelMap.get(key).contains("^^"))
	   			    	{
	   			    		predicatename = labelMap.get(key).split(Pattern.quote("^^"))[0];
	   			    	}
	   			    	else
	   			    	{
	   			    		predicatename = labelMap.get(key);
	   			    	}
	       	}
	      		 else
	      		 {
	      			predicatename = key;
	      		 }
	    	   
	    	   
	    	   System.out.println(predicatename+"	"+realoutdegreeList.size());
	    	
	       }*/
		 
		 
		 
		 
		// return matrix;
		 
		 
		 
		
	}


	
	 
	 public static void writeCsv2(String[][] csvMatrix,String path) {

	        ICsvListWriter csvWriter = null;
	        try {
	            csvWriter = new CsvListWriter(new FileWriter(path), 
	                CsvPreference.STANDARD_PREFERENCE);

	            for (int i = 0; i < csvMatrix.length; i++) {
	                csvWriter.write(csvMatrix[i]);
	            }

	        } catch (IOException e) {
	            e.printStackTrace(); // TODO handle exception properly
	        } finally {
	            try {
	                csvWriter.close();
	            } catch (IOException e) {
	            }
	        }

	    }
	 
	 
	 
	 public static void csvToXLSX(String csvfile,String xlsfile) {
		    try {
		        String csvFileAddress = csvfile; //csv file address
		        String xlsxFileAddress = xlsfile; //xlsx file address
		        HSSFWorkbook workBook = new HSSFWorkbook();
		        HSSFSheet sheet = workBook.createSheet("sheet1");
		        String currentLine=null;
		        int RowNum=-1;
		        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
		        while ((currentLine = br.readLine()) != null) {
		            String str[] = currentLine.split(",");
		            RowNum++;
		            HSSFRow currentRow=sheet.createRow(RowNum);
		            for(int i=0;i<str.length;i++){
		            	if(!str[i].equals("")||str[i]!=null){
		                currentRow.createCell(i).setCellValue(str[i]);
		            	}
		            	//System.out.println("++++++++"+currentRow.getCell(i));
		            }
		        }

		        FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
		        workBook.write(fileOutputStream);
		        fileOutputStream.close();
		        System.out.println("Done");
		    } catch (Exception ex) {
		        System.out.println(ex.getMessage()+"Exception in try");
		    }
		}
	
	
}
