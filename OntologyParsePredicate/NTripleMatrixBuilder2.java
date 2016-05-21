package OntologyParsePredicate;
import hierarchyclustering.visualization.DendrogramPanel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import DBOperate.DBQuery;
import DBOperate.Insert;
import GUI.QueryGUI;
import HFCM.HFCMClusterV2;
import MatrixOp.MatrixPlus;
import Query.QueryGenerator;
import cern.colt.matrix.DoubleMatrix2D;


public class NTripleMatrixBuilder2 {
	
	

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
	
	
		/*!!String myDirectoryPath0 = "G:/Bio2RDF datasets/biomodels";
		String myDirectoryPath1 = "G:/Bio2RDF datasets/bioportal";
		String myDirectoryPath2 = "G:/Bio2RDF datasets/drugbank";
		String myDirectoryPath3 = "G:/Bio2RDF datasets/pharmgkb";///-
		String myDirectoryPath4 = "G:/Bio2RDF datasets/hgnc";
		String myDirectoryPath5 = "G:/Bio2RDF datasets/geneontology";
		String myDirectoryPath6 = "G:/Bio2RDF datasets/mgi";///-
		String myDirectoryPath7 = "G:/Bio2RDF datasets/omim";
		
		String myDirectoryPath8 = "G:/Bio2RDF datasets/affymetrix";
		String myDirectoryPath9 = "G:/Bio2RDF datasets/chembl";
		String myDirectoryPath10 = "G:/Bio2RDF datasets/ctd";
		String myDirectoryPath11 = "G:/Bio2RDF datasets/kegg";
		String myDirectoryPath12 = "G:/Bio2RDF datasets/sgd";!!*/
	
	/*
	    String myDirectoryPath13 = "G:/Bio2RDF datasets/drugbank2";
	    String myDirectoryPath14 = "G:/Bio2RDF datasets/clinicaltrial";
	    String myDirectoryPath15 = "G:/Bio2RDF datasets/sider";///comment on 7/15/2015
		*/
	
	//!String myDirectoryPath1 =  "G:/Bio2RDF datasets/sio";
	
	//!	String myDirectoryPath1 = "G:/Bio2RDF datasets/fma";
	//! String myDirectoryPath1 = "G:/Bio2RDF datasets/obi";	
	//!	String myDirectoryPath1 = "G:/Bio2RDF datasets/NCIThesarrus";
	// String myDirectoryPath1 = "G:/Bio2RDF datasets/NCIBiomedGT";
	//! String myDirectoryPath1 = "G:/Bio2RDF datasets/omrse";
	
	//String myDirectoryPath1 = "G:/Bio2RDF datasets/clinicaltrial";
//	String myDirectoryPath1 = "G:/Bio2RDF datasets/drugbank";
//	String myDirectoryPath1 = "G:/Bio2RDF datasets/sider";
//	String myDirectoryPath1 = "G:/Bio2RDF datasets/pharmgkb";

	
	//String myDirectoryPath1 = "G:/Bio2RDF datasets/do";
	
	
	// 13 domain //
    String myDirectoryPath1 = "G:/Bio2RDF datasets/drugbanksio";
	String myDirectoryPath2 = "G:/Bio2RDF datasets/hgncsio";
	String myDirectoryPath3 = "G:/Bio2RDF datasets/mgisio";
	String myDirectoryPath4 = "G:/Bio2RDF datasets/sidersio";
	String myDirectoryPath5 = "G:/Bio2RDF datasets/omimsio";
	
	String myDirectoryPath7 = "G:/Bio2RDF datasets/keggsio";
	String myDirectoryPath8 = "G:/Bio2RDF datasets/ctdsio";
	String myDirectoryPath9 = "G:/Bio2RDF datasets/affymetrixsio";
	String myDirectoryPath10 = "G:/Bio2RDF datasets/biomodelsio";
	String myDirectoryPath11 = "G:/Bio2RDF datasets/irefindexsio";
	String myDirectoryPath12 = "G:/Bio2RDF datasets/pharmgkbsio";
	String myDirectoryPath13 = "G:/Bio2RDF datasets/sgdsio";
	String myDirectoryPath14 = "G:/Bio2RDF datasets/goasio";
	
	//String myDirectoryPath13 = "G:/Bio2RDF datasets/sidersio";

	
	String myDirectoryPath6 = "G:/Bio2RDF datasets/clinicaltrialsio";
	
	
	//!! 9 domain //
	/*!    String myDirectoryPath1 = "G:/Bio2RDF datasets/drugbanksio";
		String myDirectoryPath2 = "G:/Bio2RDF datasets/hgncsio";
		String myDirectoryPath3 = "G:/Bio2RDF datasets/mgisio";
		String myDirectoryPath4 = "G:/Bio2RDF datasets/sidersio";
		String myDirectoryPath5 = "G:/Bio2RDF datasets/omimsio";
		String myDirectoryPath6 = "G:/Bio2RDF datasets/clinicaltrialsio";
		String myDirectoryPath7 = "G:/Bio2RDF datasets/keggsio";
		String myDirectoryPath8 = "G:/Bio2RDF datasets/ctdsio";
		String myDirectoryPath12 = "G:/Bio2RDF datasets/pharmgkbsio";!*/

	
	
	
	

//!!!	String AMIAMayo1Path = "AMIAMayo1";
//!!!	String AMIAMayo2Path = "AMIAMayo2";

/*!!!	String AMIAMayo1 = "AMIA1_1";
	String AMIAMayo2 = "AMIA1_2";
	String AMIAMayo3 = "AMIA1_3";
	String AMIAMayo4 = "AMIA1_4";
	String AMIAMayo5 = "AMIA1_5";
	String AMIAMayo6 = "AMIA1_6";!!!*/

	
	/*String AMIAMayo1 = "abscesstable";
	String AMIAMayo2 = "bleedtable";
	String AMIAMayo3 = "dvtpetable";
	String AMIAMayo4 = "ileustable";
	String AMIAMayo5 = "infectiontable";
	String AMIAMayo6 = "mitable";*/
	
	/*String myDirectoryPath2 = "G:/Bio2RDF datasets/pharmgkbsio";
	String myDirectoryPath3 = "G:/Bio2RDF datasets/clinicaltrialsio";
	String myDirectoryPath4 = "G:/Bio2RDF datasets/sidersio";
	String myDirectoryPath5 = "G:/Bio2RDF datasets/omimsio";*/

	
	/*!String myDirectoryPath1 = "G:/Bio2RDF datasets/drugbank";
		String myDirectoryPath2 = "G:/Bio2RDF datasets/pharmgkb";
	String myDirectoryPath3 = "G:/Bio2RDF datasets/clinicaltrial";
	String myDirectoryPath4 = "G:/Bio2RDF datasets/sider";!*/
	
	
//	String myDirectoryPath1 = "G:/Bio2RDF datasets/ocre";
	
	//String myDirectoryPath1 = "G:/Bio2RDF datasets/chembl";
	//String myDirectoryPath2 = "G:/Bio2RDF datasets/ctd";
	//String myDirectoryPath3 = "G:/Bio2RDF datasets/kegg";
	//String myDirectoryPath4 = "G:/Bio2RDF datasets/pharmgkb";
	//String myDirectoryPath5 = "G:/Bio2RDF datasets/drugbank";
	//String myDirectoryPath6 = "G:/Bio2RDF datasets/clinicaltrial";
	//String myDirectoryPath7 = "G:/Bio2RDF datasets/drugbank";
//	String myDirectoryPath8 = "G:/Bio2RDF datasets/sider";
	
		//String myDirectoryPath10 = "G:/Bio2RDF datasets/mesh";
		//String myDirectoryPath9 = "G:/Bio2RDF datasets/mgi";
		//String myDirectoryPath10 = "G:/Bio2RDF datasets/ndc";
		//String myDirectoryPath11 = "G:/Bio2RDF datasets/sabiork";///
	
	 
	

/*	String myDirectoryPath13 = "G:/Bio2RDF datasets/omim";
	String myDirectoryPath14 = "G:/Bio2RDF datasets/sgd";
	String myDirectoryPath15 = "G:/Bio2RDF datasets/taxonomy";*/
	
	
	//String dataPreFile = "G:/Bio2RDFdataPre/affymetrix_dp.txt";
	
			
	//!String owlFile = "http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl";
	
	//!!!String activitypatternpath = "G:/test/activitypattern";
	
	SortedMap<String,String> PredicateDomainMap = new TreeMap<String,String>(); 		
	SortedMap<String,String> PredicateRangeMap = new TreeMap<String,String>(); 
	 SortedMap<String,List<String>> predicateObjMap = new TreeMap<String,List<String>>(); 
	 SortedMap<String,List<String>> predicateSubjMap = new TreeMap<String,List<String>>(); 
	 SortedMap<String,List<String>> predicateObjMapAlias = new TreeMap<String,List<String>>(); 
	 SortedMap<String,List<String>> predicateSubjMapAlias = new TreeMap<String,List<String>>(); 

	 
	 
	 
	 SortedMap<String,List<String>> subobjMap = new TreeMap<String,List<String>>(); 

	 
	SortedMap<String,List<String>> PredicatePredClassesMap = new TreeMap<String,List<String>>(); 
	
	static SortedMap<String,SortedMap<String,Integer>> ShareMap = new TreeMap<String,SortedMap<String,Integer>>(); 
    SortedMap<String,List<String>> ShareNameMap = new TreeMap<String,List<String>>();
    
    SortedMap<String,String> inverseMap = new TreeMap<String,String>(); 
    
    static SortedMap<String,String> labelMap = new TreeMap<String,String>(); 

    
	SortedMap<String,List<String>> neighbourMap = new TreeMap<String,List<String>>(); 
	SortedMap<String,List<String>> neighbourMapParent = new TreeMap<String,List<String>>(); 


	SortedMap<String,List<String>> neighbourMap2nd = new TreeMap<String,List<String>>(); 
	SortedMap<String,List<String>> neighbourMap3rd = new TreeMap<String,List<String>>(); 
	
	
	SortedMap<String,List<String>> PatternMapL1 = new TreeMap<String,List<String>>();
	SortedMap<String,String> PatternMapUp = new TreeMap<String,String>();
	  SortedMap<String,Integer> PredicateReachPatternMap = new TreeMap<String,Integer>();
	  SortedMap<String,Integer> PredicateConsumerPatternMap = new TreeMap<String,Integer>();
	  SortedMap<String,Integer> PredicateProviderPatternMap = new TreeMap<String,Integer>();
	  SortedMap<String,Integer> PredicateDirectedPatternMap = new TreeMap<String,Integer>();
	  SortedMap<String,Integer> PredicateNonDirectedPatternMap = new TreeMap<String,Integer>();
	  
		SortedMap<String,List<String>> PatternPredicateDomainMap = new TreeMap<String,List<String>>();

	    List<String> secondTriple = new ArrayList<String>();
	    List<String> level1triple = new ArrayList<String>();
	
	ArrayList<String> builtinList = new ArrayList<String>();
	ArrayList<String> predicateFileList = new ArrayList<String>();

	List<String> totalPredicateList = new ArrayList<String>();
	
	List<String> totalConceptList = new ArrayList<String>();
	
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

	 SortedMap<String,Integer> nameNumMap = new TreeMap<String,Integer>(); 
	 SortedMap<Integer,String> nameNumMapReverse = new TreeMap<Integer,String>(); 
	 
	 SortedMap<String,Integer> nameAliasNumMap = new TreeMap<String,Integer>(); 
	 SortedMap<Integer,String> nameAliasNumMapReverse = new TreeMap<Integer,String>(); 

	 
	 
	 static List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
	 	 
	

	static List<String> secondList = new ArrayList<String>();
	static List<String> thirdList = new ArrayList<String>();
	
	
	SortedMap<String,Integer> iodegreeMap = new TreeMap<String,Integer>();
	
	
	static SortedMap<String,List<String>> secondmap = new TreeMap<String,List<String>>();
	static SortedMap<String,List<String>> thirdmap = new TreeMap<String,List<String>>();

	static SortedMap<String,Float> recordMap1 = new TreeMap<String,Float>();
	static SortedMap<String,Float> recordMap2 = new TreeMap<String,Float>();
	static SortedMap<String,Float> recordMap3 = new TreeMap<String,Float>();

	
	static SortedMap<String,Integer> crossdomainMarkMap = new TreeMap<String,Integer>();
	
	static SortedMap<String,List<String>> crossdomainMarkMap2 = new TreeMap<String,List<String>>();

	static SortedMap<String,List<String>> crossdomainMarkMapTriple = new TreeMap<String,List<String>>();

	static SortedMap<String,List<String>> crossdomainMarkMapConcept = new TreeMap<String,List<String>>();

	static SortedMap<String,String> pCrossdomainMap = new TreeMap<String,String>();

	static SortedMap<String,List<String>> DirectedPathMap = new TreeMap<String,List<String>>();

	static SortedMap<String,List<String>> NonDirectedPathMap = new TreeMap<String,List<String>>();
	
	static SortedMap<String,List<String>> DirectedPathMap3 = new TreeMap<String,List<String>>();

	static SortedMap<String,List<String>> NonDirectedPathMap3 = new TreeMap<String,List<String>>();
	
	List<String> totalList = new ArrayList<String>();
	
	boolean cross = true;
	
	float weighDeduct = (float) 0.4;
	
	float weighEnhance = (float) 0.4;
	
	float weighEnhancePlus2 = (float) 0.5;
	
	float weighEnhancePlus3 = (float) 0.7;

	
	SortedMap<String,List<String>> secondConnectionMap = new TreeMap<String,List<String>>();

	SortedMap<String,List<String>> thirdConnectionMap = new TreeMap<String,List<String>>();


	List<String> totalTriple = new ArrayList<String>();
	
	static SortedMap<String,List<String>> predicateConceptMap = new TreeMap<String,List<String>>();

	static SortedMap<String,List<String>> conceptCrossInDegreeMap = new TreeMap<String,List<String>>();
	static SortedMap<String,List<String>> conceptCrossOutDegreeMap = new TreeMap<String,List<String>>();

	SortedMap<String,String> aliasrealmap = new TreeMap<String,String>();
	
	public void assgincross(boolean crossvalue)
	{
		cross = crossvalue;
	}
	
	 
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
		
	//	dirList.add(myDirectoryPath0);
	/*!!!!	dirList.add(myDirectoryPath1); // exclude on 6.23.2015
		dirList.add(myDirectoryPath2);
		dirList.add(myDirectoryPath3);
		dirList.add(myDirectoryPath4);
		dirList.add(myDirectoryPath5);
		dirList.add(myDirectoryPath7);
		dirList.add(myDirectoryPath8);
		dirList.add(myDirectoryPath9);
		dirList.add(myDirectoryPath10);
		dirList.add(myDirectoryPath11);
		dirList.add(myDirectoryPath12);!!!!*/
		
		//	dirList.add(myDirectoryPath6);

		
	//!!!	dirList.add(AMIAMayo1Path);
	//!!!	dirList.add(AMIAMayo2Path);
		
	/*!!!	dirList.add(AMIAMayo1);
		dirList.add(AMIAMayo2);
		dirList.add(AMIAMayo3);
		dirList.add(AMIAMayo4);
		dirList.add(AMIAMayo5);
		dirList.add(AMIAMayo6);!!!*/

		
		/*dirList.add(myDirectoryPath13);
		dirList.add(myDirectoryPath14);
		dirList.add(myDirectoryPath15);/// comment on 7/15/2015
*/
		
	
	//	dirList.add(myDirectoryPath4);
		/*!!!	dirList.add(myDirectoryPath5);!!!*/
	//	dirList.add(myDirectoryPath6);
		

		/*dirList.add(myDirectoryPath12);
		dirList.add(myDirectoryPath13);
		dirList.add(myDirectoryPath14);
		dirList.add(myDirectoryPath15);*/
	//!!!!	dirList.add(activitypatternpath);
		
		String dbpedia = "DBPedia";
		
		String yago = "Yago";
		
		
		//13 domains
	/*!    dirList.add(myDirectoryPath1);
		dirList.add(myDirectoryPath2);
		dirList.add(myDirectoryPath3);
		dirList.add(myDirectoryPath4);
		dirList.add(myDirectoryPath5);
		//!dirList.add(myDirectoryPath6);
		dirList.add(myDirectoryPath7);
		dirList.add(myDirectoryPath8);
		dirList.add(myDirectoryPath9);
		dirList.add(myDirectoryPath10);
		dirList.add(myDirectoryPath11);
		dirList.add(myDirectoryPath12);
		dirList.add(myDirectoryPath13);
		dirList.add(myDirectoryPath14);!*/
		
		//9 domains
		dirList.add(myDirectoryPath1);
		dirList.add(myDirectoryPath2);
		dirList.add(myDirectoryPath3);
		dirList.add(myDirectoryPath4);
		dirList.add(myDirectoryPath5);
		dirList.add(myDirectoryPath6);
		dirList.add(myDirectoryPath7);
		dirList.add(myDirectoryPath12);
		
		
		
		//sider test
//!	dirList.add(myDirectoryPath4);
		
	//!	dirList.add(yago);
	//!	dirList.add(dbpedia);
	
		List<String> PredicateList = new ArrayList<String>();
		
		int crossMark = 1;
		
		
	for(int i=0;i<dirList.size();i++){ ////for mix
		
		 start0 = System.currentTimeMillis();
		
		 File dir = new File(dirList.get(i));
		  File[] directoryListing=null; //!= dir.listFiles();
		  tableName = dir.getName()+"table";
		  dirName = dir.getName();
		  dataPreFile = "G:/Bio2RDFdataPre/"+dirName + "_dp.txt";
		  DBQuery cobj = new DBQuery();
		  int rowcount=cobj.countDB(tableName);
			
		//  cobj.selectTripleandPrint(tableName);
		if(rowcount>0){	
		  
			
			
			storeList = cobj.selectstoreListDB(tableName);
			String s="",p="",o="";
			

        	
        
			
			for(int n=0;n<storeList.size();n++)
			{
				
				
				s = storeList.get(n).split(",")[0];
				p = storeList.get(n).split(",")[1];
				o = storeList.get(n).split(",")[2];
				
				String aliasP = mapPredicateToRformat(p);
				if(!totalList.contains(aliasP))
				{
					totalList.add(aliasP);
				}

				
				
				
				String p2 = mapPredicateToRformat(p);
				
				
			   if(!conceptCrossInDegreeMap.containsKey(o))
			   {
				   List<String> list = new ArrayList<String>();
				   list.add(p);
				   conceptCrossInDegreeMap.put(o,list);
			   }
			   else
			   {
				   List<String> list = conceptCrossInDegreeMap.get(o);
				   if(!list.contains(p))
				   {
					   list.add(p);
				   }
				   conceptCrossInDegreeMap.put(o,list);
			   }
				
			   
			   if(!conceptCrossOutDegreeMap.containsKey(s))
			   {
				   List<String> list = new ArrayList<String>();
				   list.add(p);
				   conceptCrossOutDegreeMap.put(s,list);
			   }
			   else
			   {
				   List<String> list = conceptCrossOutDegreeMap.get(s);
				   if(!list.contains(p))
				   {
					   list.add(p);
				   }
				   conceptCrossOutDegreeMap.put(s,list);
			   }
			   
				
			   if(!predicateConceptMap.containsKey(p2))
			   {
				   List<String> list = new ArrayList<String>();
				   if(!list.contains(s))
				   {
					   list.add(s);
				   }
				   if(!list.contains(o))
				   {
					   list.add(o);
				   }
				   predicateConceptMap.put(p2,list);
			   }
			   else
			   {
				   List<String> list = predicateConceptMap.get(p2);
				   
				   if(!list.contains(s))
				   {
					   list.add(s);
				   }
				   if(!list.contains(o))
				   {
					   list.add(o);
				   }
				   predicateConceptMap.put(p2,list);
			   }
					
				
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
				
				
			/*!!	if(!p.contains(":x-")) 
			  
				{
					
					continue;
				}
				else
				{
					if(p.equals("http://bio2rdf.org/obo_vocabulary:x-")||p.equals("http://bio2rdf.org/pharmgkb_vocabulary:x-)"))
					{
						continue;
					}
				}!!*/ /// comment on 8/7/2015
				
			/*		if(p.contains("http://www.w3.org/1999/02/22-rdf-syntax-ns")) 
				{
					continue;
				}				
				if(p.contains("http://www.w3.org/2000/01/rdf-schema"))
				{
					continue;
				}
				if(p.contains("http://rdfs.org/ns/void#inDataset"))
				{
					continue;
				}
				if(p.contains("http://bio2rdf.org/biopax_vocabulary:identical-to"))
				{
					continue;
				}
				if(p.contains("http://bio2rdf.org/biopax_vocabulary:publication"))
				{
					continue;
				}
				if(p.contains("http://www.biopax.org/release/biopax-level3.owl#left"))
				{
					continue;
				}
				if(p.contains("http://www.w3.org/2002/07/owl#sameAs"))
				{
					continue;
				}*/
				
				if(p.contains("#domain")||p.contains("#range")||p.contains("#import")||p.contains("#subPropertyOf")||p.contains("#isDefinedBy")||p.contains("#disjointWith")||p.contains("#inverseOf")||(p.contains("www.w3.org")&&!p.contains("seeAlso"))||(p.contains("www.w3.org")&&!p.contains("sameAs"))) // temp add for FMA data --- 8/21/2015
				{
					continue;
				}
				
				if(p.contains("purl")){
					
					continue;
					
				}
				
				if(p.contains("rdfs")){
					
					continue;
					
				}
				

				if(p.contains("x-)")){
					
					continue;
					
				}
				
				if(dirList.get(i).equals("DBPedia")){
					if(!p.contains("http://dbpedia.org/ontology/"))
					{
						continue;
					}
				}
				
				if(dirList.get(i).equals("Yago")){
					if(!p.contains("http://yago-knowledge.org"))
					{
						continue;
					}
				}
				
			/*	if(!p.contains("http://purl.obolibrary.org/obo")) // specific for obi
				{
					continue;
				}*/
				
				
					
	////////////////// ////////////////////	///////////////////	///////////////////	///////////////////	///////////////////	///////////////////
					
				if(!subobjMap.containsKey(p))
	        	{
	        		List<String> subobjList = new ArrayList<String>();
	        		subobjList.add(s+";"+o);
	        		subobjMap.put(p,subobjList);
	        	}
	        	else
	        	{
	        		List<String> subobjList = subobjMap.get(p);
	        		if(!subobjList.contains(s+";"+o))
	        		{
	        			subobjList.add(s+";"+o);
	        		}
	        		subobjMap.put(p,subobjList);
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
					
					String alias = mapPredicateToRformat(p);
					
					if(!predicateObjMapAlias.containsKey(alias))
		        	{
		        		List<String> objectList = new ArrayList<String>();
		        		objectList.add(o);
		        		predicateObjMapAlias.put(alias,objectList);
		        	}
		        	else
		        	{
		        		List<String> objectList = predicateObjMapAlias.get(alias);
		        		if(!objectList.contains(o))
		        		{
		        			objectList.add(o);
		        		}
		        		predicateObjMapAlias.put(alias,objectList);
		        	}
					
					
					
					if(!predicateSubjMapAlias.containsKey(alias))
		        	{
		        		List<String> subjList = new ArrayList<String>();
		        		subjList.add(s);
		        		predicateSubjMapAlias.put(alias,subjList);
		        	}
		        	else
		        	{
		        		List<String> subjList = predicateSubjMapAlias.get(alias);
		        		if(!subjList.contains(s))
		        		{
		        			subjList.add(s);
		        		}
		        		predicateSubjMapAlias.put(alias,subjList);
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
					
		        	
		        	if (!crossdomainMarkMap.containsKey(p))
		        	{
		        		crossdomainMarkMap.put(p,crossMark);
		        	}
		        	
		        	if (!crossdomainMarkMap2.containsKey(tableName))
		        	{
		        		List<String> list = new ArrayList<String>();
		        		list.add(p);
		        		crossdomainMarkMap2.put(tableName,list);
		        	}
		        	else
		        	{
		        		List<String> list = crossdomainMarkMap2.get(tableName);
		        		if(!list.contains(p))
		        		{
		        			list.add(p);
		        		}
		        		crossdomainMarkMap2.put(tableName,list);
		        	}
		        	
		        	
		        	if (!crossdomainMarkMapConcept.containsKey(tableName))
		        	{
		        		List<String> list = new ArrayList<String>();
		        		list.add(s);
		        		if(!list.contains(o))
		        		{
		        			list.add(o);
		        		}
		        		crossdomainMarkMapConcept.put(tableName,list);
		        	}
		        	else
		        	{		        		
		        		List<String> list = crossdomainMarkMapConcept.get(tableName);
		        		if(!list.contains(s))
		        		{
		        			list.add(s);
		        		}
		        		if(!list.contains(o))
		        		{
		        			list.add(o);
		        		}
		        		crossdomainMarkMapConcept.put(tableName,list);		        		
		        	}
		        	
		        	String domainS = s.split("_vocabulary")[0];
		        	String domainO = o.split("_vocabulary")[0];
		        	if(!domainS.equals(domainO))
		        	{
		        		if(!pCrossdomainMap.containsKey(mapPredicateToRformat(p)))
			        	{
		        			pCrossdomainMap.put(mapPredicateToRformat(p),domainS+"-"+domainO);
			        	}
		        	}
		        	
		        	
		        	if (!crossdomainMarkMapTriple.containsKey(tableName))
		        	{
		        		List<String> list = new ArrayList<String>();
		        		list.add(s+","+p+","+o);
		        		crossdomainMarkMapTriple.put(tableName,list);
		        	}
		        	else
		        	{		        		
		        		List<String> list = crossdomainMarkMapTriple.get(tableName);
		        		if(!list.contains(s+","+p+","+o))
		        		{
		        			list.add(s+","+p+","+o);
		        		}
		        		crossdomainMarkMapTriple.put(tableName,list);		        		
		        	}
			      
		        	if(!totalTriple.contains(s+","+p+","+o))
					{
						totalTriple.add(s+","+p+","+o);
					}
			}
			
			crossMark = crossMark+1;
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


	System.out.println("cross domain for concepts--Unit");
	List<String> crossconceptList = new ArrayList<String>();
	Iterator<String> iterconceptCrossInDegreeMap = conceptCrossInDegreeMap.keySet().iterator(); 

    while(iterconceptCrossInDegreeMap.hasNext()){
    
    	String key = iterconceptCrossInDegreeMap.next();
    	
    	List<String> inPList = conceptCrossInDegreeMap.get(key);
    	
    	if(conceptCrossOutDegreeMap.containsKey(key))
    	{
    		List<String> outPList = conceptCrossOutDegreeMap.get(key);
    		
    		for(int i=0;i<inPList.size();i++)
    		{
    			String inPDomain = inPList.get(i).split("_vocabulary")[0];
    			
    			for(int j=0;j<outPList.size();j++)
    			{
    				String outPDomain = outPList.get(j).split("_vocabulary")[0];
    				
    				if(!inPDomain.equals(outPDomain))
    				{
    					if(!crossconceptList.contains(key))
    					{
    						crossconceptList.add(key);
    					}
    				}
    			}
    		}
    	}
    	
    }
	
   System.out.println(crossconceptList.size());
	
	
	System.out.println("cross domain for predicates");
	Iterator<String> itercrossdomainMarkMap = crossdomainMarkMap2.keySet().iterator(); 
    
    while(itercrossdomainMarkMap.hasNext()){
    	
    	String key = itercrossdomainMarkMap.next();
    	System.out.println(key+":"+crossdomainMarkMap2.get(key).size());
    	for(int c=0;c<crossdomainMarkMap2.get(key).size();c++)
    	{
    		if(!totalPredicateList.contains(crossdomainMarkMap2.get(key).get(c)))
    		{
    			totalPredicateList.add(crossdomainMarkMap2.get(key).get(c));
    		}
    	}
    	
    }
	System.out.println();

	
	System.out.println("cross domain for triples");
	Iterator<String> itercrossdomainMarkMapTriple = crossdomainMarkMapTriple.keySet().iterator(); 
    
    while(itercrossdomainMarkMapTriple.hasNext()){
    	
    	String key = itercrossdomainMarkMapTriple.next();
    	System.out.println(key+":"+crossdomainMarkMapTriple.get(key).size());
    	
    }
	System.out.println();
	
	
	System.out.println("cross domain for Concepts");
	SortedMap<String,Integer> shareConceptmap = new TreeMap<String,Integer>();
	Iterator<String> itercrossdomainMarkMapConcept = crossdomainMarkMapConcept.keySet().iterator(); 
    
    while(itercrossdomainMarkMapConcept.hasNext()){
    	
    	String key = itercrossdomainMarkMapConcept.next();
    	System.out.println(key+":"+crossdomainMarkMapConcept.get(key).size());  
    	
    	for(int c=0;c<crossdomainMarkMapConcept.get(key).size();c++)
    	{
    		String concept = crossdomainMarkMapConcept.get(key).get(c);
    		if(!shareConceptmap.containsKey(concept))
    		{
    			int count = 1;
    			shareConceptmap.put(concept,count);
    		}
    		else
    		{
    			int count = shareConceptmap.get(concept);
    			count=count+1;
    			shareConceptmap.put(concept,count);
    		}
    		
    		//System.out.println(crossdomainMarkMapConcept.get(key).get(c));
    		if(!totalConceptList.contains(crossdomainMarkMapConcept.get(key).get(c)))
    		{
    			totalConceptList.add(crossdomainMarkMapConcept.get(key).get(c));
    		}
    	}
    }
    System.out.println("totalConceptList Size : "+totalConceptList.size());
	System.out.println();
	
	System.out.println("How many SIO out of all concepts");
	for(int i=0;i<totalConceptList.size();i++)
	{
		if(totalConceptList.get(i).contains("SIO"))
		{
			System.out.println(totalConceptList.get(i));
		}
		
	}
	
	
	System.out.println("shared concepts");
	DendrogramPanel obj = new DendrogramPanel();
	Map<String,Integer> shareConceptmap2 = sortByValue(shareConceptmap);
	Iterator<String> itershareConceptmap2 = shareConceptmap2.keySet().iterator(); 
    while(itershareConceptmap2.hasNext()){

    	String key = itershareConceptmap2.next();
    	
    	int count = shareConceptmap2.get(key);
    	
    	System.out.println(key+"\t"+count);
    }
	
	
	
	System.out.println("Check Fuzzyness of predicates across topics");
	 File folder = new File("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/CrossDomain-PLOS-Submission-2015/HC-clusters");

	  BufferedReader br = null;
	  String line = "";
	  
	  SortedMap<Integer,String> filenameMap = new TreeMap<Integer,String>();
			
			for (final File fileEntry : folder.listFiles()) {
				
			 if(fileEntry.getName().contains("DS_Store"))
		  {
			  continue;
		  }
		  
		  if(fileEntry.getName().contains("image"))
		  {
			  continue;
		  }
				
				int num = Integer.parseInt(fileEntry.getName().split("_")[1]);
				
				if(!filenameMap.containsKey(num))
				{
					filenameMap.put(num,fileEntry.getAbsolutePath());
				}   						
			}
	 
	for(int t=0;t<totalPredicateList.size();t++)
	{
		String predicate = mapPredicateToRformat(totalPredicateList.get(t));
		String matrixoutput=predicate;
		
		   if(matrixoutput.contains("hgnc_vocabulary")){
			   matrixoutput = "hv:"+matrixoutput.split("_vocabulary.")[1];
        	   }
        	   if(matrixoutput.contains("drugbank_vocabulary")){
        		   matrixoutput = "dv:"+matrixoutput.split("_vocabulary.")[1];
               }
        	   if(matrixoutput.contains("mgi_vocabulary")){
        		   matrixoutput = "mgv:"+matrixoutput.split("_vocabulary.")[1];
               }
        	   if(matrixoutput.contains("ctd_vocabulary")){
        		   matrixoutput = "ctdv:"+matrixoutput.split("_vocabulary.")[1];
               }
        	   if(matrixoutput.contains("kegg_vocabulary")){
        		   matrixoutput = "kv:"+matrixoutput.split("_vocabulary.")[1];
               }
        	   if(matrixoutput.contains("clinicaltrials_vocabulary")){
        		   matrixoutput = "clinv:"+matrixoutput.split("_vocabulary.")[1];
               }
        	   if(matrixoutput.contains("omim_vocabulary")){
        		   matrixoutput = "omimv:"+matrixoutput.split("_vocabulary.")[1];
               }
        	   if(matrixoutput.contains("pharmgkb_vocabulary")){
        		   matrixoutput = "phv:"+matrixoutput.split("_vocabulary.")[1];
               }
         	   if(matrixoutput.contains("sider_vocabulary")){
         		  matrixoutput = "siderv:"+matrixoutput.split("_vocabulary.")[1];
               }
		
				
   			int fuzzycount = 0;
   			   			
   			for (Map.Entry<Integer, String> entry : filenameMap.entrySet()) {
   			   			  		    	
			int key = entry.getKey();
			
			String filepath = entry.getValue();
   		    	
			int flag = 0;
			

			  try {
				  
					br = new BufferedReader(new FileReader(filepath));
										
					while ((line = br.readLine()) != null) {
						
						if(line.equals("")||line.contains("Size"))
						{
							continue;
						}
						
						if(line.trim().equals(predicate))
						{
							flag=1;
							break;
						}
						else
						{
							flag=0;
						}								
					}
					
					if(flag==1){
						
						if(matrixoutput.equals(""))
						{
							matrixoutput = "1";
							fuzzycount++;
						}
						else
						{
							matrixoutput = matrixoutput+"\t"+"1";
							fuzzycount++;
						}
						
					}
					else
					{
						if(matrixoutput.equals(""))
						{
							matrixoutput = "0";
						}
						else
						{
							matrixoutput = matrixoutput+"\t"+"0";
						}	
					}
					
					
					
					}catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

		}
		
	}
		
		matrixoutput = matrixoutput+"\t"+fuzzycount;
		System.out.println(matrixoutput);
	
	}
	
/*!!!	System.out.println();
	System.out.println("Check Fuzzyness of Concepts across topics");
	 File folder2 = new File("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/CrossDomain-PLOS-Submission-2015/HC-clusters");

	 SortedMap<String,String> siomap = getsiomap("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/CrossDomain-PLOS-Submission-2015/sio-release.nt");
	 
	  BufferedReader br2 = null;
	  String line2 = "";
	
	  for(int t=0;t<totalConceptList.size();t++)
		{
		   String concept = totalConceptList.get(t);
		   String outputConceptMatrix = maptoConcept(totalConceptList.get(t),siomap);
		   
		   int fuzzycount = 0;

		   for (Map.Entry<Integer, String> entry : filenameMap.entrySet()) {
		  		    	
				int key = entry.getKey();
				
				
				String filepath = entry.getValue();
	   		    	
				int flag = 0;
				
				  try {
					  
						br = new BufferedReader(new FileReader(filepath));
						
						
						while ((line = br.readLine()) != null) {
							
							if(line.equals("")||line.contains("Size"))
							{
								continue;
							}
							
							if(predicateConceptMap.get(line.trim()).contains(concept))
							{
								flag=1;
								break;
							}
							else
							{
								flag=0;
							}								
						}
						
						if(flag==1){
							
							if(outputConceptMatrix.equals(""))
							{
								outputConceptMatrix = "1";
								fuzzycount++;
							}
							else
							{
								outputConceptMatrix = outputConceptMatrix+"\t"+"1";
								fuzzycount++;
							}
							
						}
						else
						{
							if(outputConceptMatrix.equals(""))
							{
								outputConceptMatrix = "0";
							}
							else
							{
								outputConceptMatrix = outputConceptMatrix+"\t"+"0";
							}	
						}
						
						
						
						}catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							if (br != null) {
								try {
									br.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}

			}
			
		}
			
			outputConceptMatrix = outputConceptMatrix+"\t"+fuzzycount;
			System.out.println(outputConceptMatrix);
		}
	  !!!!*/
	
	
	
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
		 
		  
		  
		/*  Iterator<String> iterPredicateDomainMap = PredicateDomainMap.keySet().iterator(); 
	       
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
		       }*/
		  
	   
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
				  
				//  System.out.println(name);
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
		double matrixbuilderstarttime =System.currentTimeMillis();
		
	
		
		//!HFCMCluster hfcmobj = new HFCMCluster(); 
		HFCMClusterV2 hfcmobj = new HFCMClusterV2(); 
		
		 int row = columnList.size();
		 int column = columnList.size();
		 double matrix[][] = new double[row][column]; 
		 double matrixProbSim[][]= new double[row][column]; 
		 double matrixShareProbSim[][] = new double[row][column];
		 
		 
		 List<String> sbList1 = new ArrayList<String>();
		 List<String> obList1 = new ArrayList<String>();
		 List<String> sbList2 = new ArrayList<String>();
		 List<String> obList2 = new ArrayList<String>();
		 
		 
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
		  
		
        
	//	  Graph graph = new Graph();
		  
		//  Graph myGraph= new Graph(columnList.size());
		  
		  for(int i=0;i<columnList.size();i++)
		  {
			//  System.out.println(i+"::"+columnList.get(i));
			  
			  if(!nameNumMap.containsKey(columnList.get(i)))
			  {
				  nameNumMap.put(columnList.get(i),i);
			  }
			  if(!nameNumMapReverse.containsKey(i))
			  {
				  nameNumMapReverse.put(i,columnList.get(i));
			  }
			  String aliasP = mapPredicateToRformat(columnList.get(i));
			  
			  if(!nameAliasNumMap.containsKey(aliasP))
			  {
				  nameAliasNumMap.put(aliasP,i);
			  }
			  if(!nameAliasNumMapReverse.containsKey(i))
			  {
				  nameAliasNumMapReverse.put(i,aliasP);
			  }
			  
			  if(!aliasrealmap.containsKey(aliasP))
			  {
				  aliasrealmap.put(aliasP,columnList.get(i));
			  }
		  }
		  
		  
		  
		  
		  
	      
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
				 /* 
				  if(columnList.get(i).equals("http://bio2rdf.org/drugbank_vocabulary:x-dpd")&&columnList.get(j).equals("http://bio2rdf.org/drugbank_vocabulary:x-genecards"))
				  {
					  System.out.println("stop");
				  }*/
				//  System.out.println(predicateSubjMap.size());
				  if(predicateSubjMap.containsKey(columnList.get(i)))
				  {
					  sbList1 = predicateSubjMap.get(columnList.get(i));
					   //domain1=PredicateDomainMap.get(columnList.get(i));
					  // System.out.println("domain1 is: "+domain1);
				  }
				  if(predicateObjMap.containsKey(columnList.get(i)))
				  {
					  obList1 = predicateObjMap.get(columnList.get(i));
					  //   range1=PredicateRangeMap.get(columnList.get(i));
					  // System.out.println("range1 is: "+range1);
				  }
				  if(predicateSubjMap.containsKey(columnList.get(j)))
				  {
					  sbList2 = predicateSubjMap.get(columnList.get(j));
					 //  domain2=PredicateDomainMap.get(columnList.get(j));
					 //  System.out.println("domain2 is: "+domain2);
				  }
				  if(predicateObjMap.containsKey(columnList.get(j)))
				  {
					  obList2 = predicateObjMap.get(columnList.get(j));
					 //  range2=PredicateRangeMap.get(columnList.get(j));
					 //  System.out.println("range2 is: "+range2);
				  }
				  
	 
				//  System.out.println("******************"+ columnList.get(i)+":"+columnList.get(j));
				  
				 /* if(domain1.equals(domain2))
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
				  		 			*/
				  
				/*  
				  for(int a=0;a<sbList1.size();a++)
				  {
					  for(int b=0;b<sbList2.size();b++)
					  {
						  if(sbList1.get(a).equals(sbList2.get(b)))
						  {
							  count = count+1;
							  break;
						  }
					  }
				  }
				  
				  for(int a=0;a<sbList1.size();a++)
				  {
					  for(int b=0;b<obList2.size();b++)
					  {
						  if(sbList1.get(a).equals(obList2.get(b)))
						  {
							  count = count+1;
							  break;
						  }
					  }
				  }
				  
				  for(int a=0;a<obList1.size();a++)
				  {
					  for(int b=0;b<sbList2.size();b++)
					  {
						  if(obList1.get(a).equals(sbList2.get(b)))
						  {
							  count = count+1;
							  break;
						  }
					  }
				  }
				  
				  for(int a=0;a<obList1.size();a++)
				  {
					  for(int b=0;b<obList2.size();b++)
					  {
						  if(obList1.get(a).equals(obList2.get(b)))
						  {
							  count = count+1;
							  break;
						  }
					  }
				  }
				  */
				  
				  
			/////2 WAY DETERMINATION: 2 CONNECT
				/*!!  List<String> remove1 = new ArrayList<String>(sbList1);
				  List<String> remove2 = new ArrayList<String>(obList2);
			
				  int preSize1 = remove1.size();
				  remove1.removeAll(remove2);	  
				  
				  int postSize1 = remove1.size();
				  if(preSize1>postSize1)
				  {
					  count=count+1;
				  }
				  else
				  {
					  List<String> remove11 = new ArrayList<String>(obList1);
					  List<String> remove22 = new ArrayList<String>(sbList2);
					  int preSize11 = remove11.size();
					  remove11.removeAll(remove22);
					 
					  int postSize11 = remove11.size();
					  if(preSize11>postSize11)
					  {
						  count=count+1;
					  }
				  }
				!!  */
		     ////  4 WAY DETERMINATION:2 SHARE,2 CONNECT
				  
				  List<String> remove1 = new ArrayList<String>(sbList1);
				  List<String> remove2 = new ArrayList<String>(sbList2);
			
				  int preSize1 = remove1.size();
				  remove1.removeAll(remove2);
				 
				  int postSize1 = remove1.size();
				  if(preSize1>postSize1)
				  {
					  count=count+1;
				  }
				  else
				  {
					  List<String> remove11 = new ArrayList<String>(sbList1);
					  List<String> remove22 = new ArrayList<String>(obList2);
					  int preSize11 = remove11.size();
					  remove11.removeAll(remove22);
					 
					  int postSize11 = remove11.size();
					  if(preSize11>postSize11)
					  {
						  count=count+1;
					  }
					  else
					  {
						  List<String> remove111 = new ArrayList<String>(obList1);
						  List<String> remove222 = new ArrayList<String>(sbList2);
						  int preSize111 = remove111.size();
						  remove111.removeAll(remove222);
						 
						  int postSize111 = remove111.size();
						  if(preSize111>postSize111)
						  {
							  count=count+1;
						  }
						  else
						  {
							  List<String> remove1111 = new ArrayList<String>(obList1);
							  List<String> remove2222 = new ArrayList<String>(obList2);
							  int preSize1111 = remove1111.size();
							  remove1111.removeAll(remove2222);
							 
							  int postSize1111 = remove1111.size();
							  if(preSize1111>postSize1111)
							  {
								  count=count+1;
							  }
						  }
					  }
				
				  }
				  
			
				  
			/*	  if(sbList1.retainAll(sbList2))
				  {
					  count=count+1;
				  }
				  if(sbList1.retainAll(obList2))
				  {
					  count=count+1;
				  }
				  if(obList1.retainAll(sbList2))
				  {
					  count=count+1;
				  }
				  if(obList1.retainAll(obList2))
				  {
					  count=count+1;
				  }*/
				  		 			
				  
				 //! matrix[i][j]=count;
				 // System.out.println(columnList.get(i) + " and " + columnList.get(j)+":"+count);
				  
				  
				  if(count==0)
				  {
					  distance=0;
				  }
				  else
				  {
					  distance=1;
					  
				//	  graph.addEdge(columnList.get(i), columnList.get(j));

				//	  myGraph.addConnection(i, j);
					  /*List<String> objectList = predicateObjMap.get(columnList.get(i));
					   List<String> subjectList = predicateSubjMap.get(columnList.get(i));
					   System.out.println("#1:");
					   System.out.println("subject"+columnList.get(i));
					   for(int x=0;x<subjectList.size();x++)
					   {
						   System.out.println(subjectList.get(x));
					   }
					   System.out.println("object");
					   for(int x=0;x<objectList.size();x++)
					   {
						   System.out.println(objectList.get(x));
					   }
					   
					   
					   List<String> objectList2 = predicateObjMap.get(columnList.get(j));
					   List<String> subjectList2 = predicateSubjMap.get(columnList.get(j));
					   System.out.println("#2:");
					   System.out.println("subject"+columnList.get(j));
					   for(int x=0;x<subjectList2.size();x++)
					   {
						   System.out.println(subjectList2.get(x));
					   }
					   System.out.println("object");
					   for(int x=0;x<objectList2.size();x++)
					   {
						   System.out.println(objectList2.get(x));
					   }*/
					  
					  
					  
					  
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
					 
					  
					  
					  if(!neighbourMapParent.containsKey(columnList.get(j)))
					  {
						  List<String> neighbourListParent = new ArrayList<String>();
						  neighbourListParent.add(columnList.get(i));	
						  neighbourMapParent.put(columnList.get(j), neighbourListParent);
					  }
					  else
					  {
						  List<String> neighbourListParent = neighbourMapParent.get(columnList.get(j));
						  neighbourListParent.add(columnList.get(i));	
						  neighbourMapParent.put(columnList.get(j), neighbourListParent);
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
		
		

		 System.out.println("===== columnListsize ===="+":"+columnList.size());
		 
		 for(int s=0;s<columnList.size();s++){
			 
		//	 System.out.println(columnList.get(s)+" has "+predicateSubjMap.get(columnList.get(s)).size()+" in-degree");
	//		 System.out.println(columnList.get(s)+" has "+predicateObjMap.get(columnList.get(s)).size()+" out-degree");
		//	 System.out.println("===========================================================================");
			 
			 int sumdegree = predicateSubjMap.get(columnList.get(s)).size()+predicateObjMap.get(columnList.get(s)).size();
			 
			 		if(!iodegreeMap.containsKey(columnList.get(s)))
					 {
			 			iodegreeMap.put(columnList.get(s),sumdegree);
					 }
			 //System.out.println("Consider reduce 1st level chances. Only connection pattern/share pattern can be 1st level");
	    	   	    	   
	    	   if(neighbourMap.containsKey(columnList.get(s))){
			   List<String> value = neighbourMap.get(columnList.get(s));
	    	  
	    	   List<Integer> innerList = new ArrayList<Integer>();
	    	   
	    	   for(int v=0;v<value.size();v++)
	    	   {
	    		  int n = nameNumMap.get(value.get(v)); 
	    		  if(!innerList.contains(n))
	    		  {
	    			  innerList.add(n);
	    		  }
	    	   }
	    	   
	    	
	    	   listOfLists.add(innerList);
	    	   	    		    
		 }
	    	   else
	    	   {
	    		    List<Integer> innerList = new ArrayList<Integer>();
	    		    innerList.add(-1);
		    		listOfLists.add(innerList);
	    	   }
	    	      	    	   
	       }
		 
		  
		
		 
		 
		 
		 	hfcmobj.getSumDegree(iodegreeMap);
		 
		 	
		 
		 
		 /* Node[] node = new Node[listOfLists.size()*ARRSIZE];
			System.out.println("node[] length"+node.length);
			
			
			for(int ii=0;ii<listOfLists.size();ii++)
			{
	            node[ii] = new Node();
				node[ii].setName(Integer.toString(ii));
			}
			
	//		System.out.println(nodeRalation.length);
			
			for(int ii=0;ii<listOfLists.size();ii++)
			{
				ArrayList<Node> List = new ArrayList<Node>();
			//	System.out.println(nodeRalation[ii]);
				for(int jj=0;jj<listOfLists.get(ii).size();jj++)
				{
					//System.out.println("listofList ii size:"+listOfLists.get(ii).size());
					System.out.println(node[listOfLists.get(ii).get(jj)]);
					List.add(node[listOfLists.get(ii).get(jj)]);
				}
				node[ii].setRelationNodes(List);
				List = null; 
			}
		    
		 */
		 
	/*	 System.out.println("=======================listOfLists size: ======================="+listOfLists.size());
		 for(int l=0;l<listOfLists.size();l++)
		 {
			 System.out.println(l+":"+listOfLists.get(l));
		 }*/
		 
		 
		 
		 /////// Calculate 2nd level neighbour ///////
		   long time1= System.currentTimeMillis();
		 System.out.println(neighbourMap.size());
		 Iterator<String> iterFor2ndNeighbour = neighbourMap.keySet().iterator(); 
		   while(iterFor2ndNeighbour.hasNext()){
			   
			   String key = iterFor2ndNeighbour.next();
			   List<String> neighbourList = neighbourMap.get(key);
			   for(int n=0;n<neighbourList.size();n++)
			   {
				   if(!neighbourMap2nd.containsKey(key))
				   {
					  //! List<String> List = new ArrayList<String>();
					   
					   Set<String> hashSet = new HashSet<String>();
					   if(neighbourMap.containsKey(neighbourList.get(n)))
					   {
						   
						   List<String> objectList = predicateObjMap.get(key);
						   List<String> subjectList = predicateSubjMap.get(key);
					//	   System.out.println("#1:");
						//   System.out.println("subject"+":"+key);
						/*   for(int x=0;x<subjectList.size();x++)
						   {
							   System.out.println(subjectList.get(x));
						   }
						   System.out.println("object");
						   for(int x=0;x<objectList.size();x++)
						   {
							   System.out.println(objectList.get(x));
						   }*/
						   
						   
						   List<String> objectList2 = predicateObjMap.get(neighbourList.get(n));
						   List<String> subjectList2 = predicateSubjMap.get(neighbourList.get(n));
						//   System.out.println("#2:");
						 //  System.out.println("subject"+":"+neighbourList.get(n));
						   /*for(int x=0;x<subjectList2.size();x++)
						   {
							   System.out.println(subjectList2.get(x));
						   }
						   System.out.println("object");
						   for(int x=0;x<objectList2.size();x++)
						   {
							   System.out.println(objectList2.get(x));
						   }*/
						   
						   
						   
						   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
						   
						   
						   List<String> objectList3 = predicateObjMap.get(neighbourList2nd.get(0));
						   List<String> subjectList3 = predicateSubjMap.get(neighbourList2nd.get(0));
					/*	   System.out.println("#3:");
						   System.out.println("subject"+":"+neighbourList2nd.get(0));
						   for(int x=0;x<subjectList3.size();x++)
						   {
							   System.out.println(subjectList3.get(x));
						   }
						   System.out.println("object");
						   for(int x=0;x<objectList3.size();x++)
						   {
							   System.out.println(objectList3.get(x));
						   }*/
						   
						   
						   
						/*   for(int m=0;m<neighbourList2nd.size();m++){
						   pathMap2.put(key+","+neighbourList2nd.get(m),neighbourList.get(n));
						   }*/
						  /*! for(int x=0;x<neighbourList2nd.size();x++)
						   {
							   if(!List.contains(neighbourList2nd.get(x)))
							   List.add(neighbourList2nd.get(x));
						   }!*/
						   hashSet.addAll(neighbourList2nd);
						   List<String> List = new ArrayList<String>(hashSet);
						   if(List.contains(key))
						   {
							   List.remove(key);
						   }
						   
						   neighbourMap2nd.put(key,List);
					   }
				   }
				   else
				   {
					 //!  List<String> List = neighbourMap2nd.get(key);
					   
					   Set<String> hashSet = new HashSet<String>(neighbourMap2nd.get(key));
					   if(neighbourMap.containsKey(neighbourList.get(n)))
					   {
						   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
						  /*! for(int x=0;x<neighbourList2nd.size();x++)
						   {
							   if(!List.contains(neighbourList2nd.get(x)))
							   List.add(neighbourList2nd.get(x));
						   }!*/
						   hashSet.addAll(neighbourList2nd);
						   List<String> List = new ArrayList<String>(hashSet);
						   if(List.contains(key))
						   {
							   List.remove(key);
						   }
						   neighbourMap2nd.put(key,List);
					   }
				   }
				   
				 
			   }   
			   
			  // System.out.println(key+"========="+neighbourMap.get(key).size());
		   }
		 
		  /* System.out.println("in neighbourMap2nd:");
		   Iterator<String> iter2 = neighbourMap2nd.keySet().iterator(); 
		   while(iter2.hasNext()){
			   
			   String key = iter2.next();
			   
			   List<String> valueList = neighbourMap2nd.get(key);
			   
			//   System.out.println(subobjMap.get(key)+"========");
			   
			   for(int a =0; a<subobjMap.get(key).size();a++)
			   {
				   System.out.println(subobjMap.get(key).get(a)+"================");
			   }
			   
			   for(int v=0;v<valueList.size();v++)
			   {
				  for(int b=0;b<subobjMap.get(valueList.get(v)).size();b++)
				  {
					  System.out.println(subobjMap.get(valueList.get(v)).get(b));
				  }
				  
				  System.out.println("**********************************");
				  System.out.println();
			   }
			   
		   }*/
		   
		   
		 
		   long time2= System.currentTimeMillis();
			 
		   System.out.println("2nd :" + (time2-time1));
	 
		   
		   
		   long time3= System.currentTimeMillis();
		   
		   /////// Calculate 3rd level neighbour ///////
			 System.out.println(neighbourMap2nd.size());

			 Iterator<String> iterFor3rdNeighbour = neighbourMap2nd.keySet().iterator(); 
			   while(iterFor3rdNeighbour.hasNext()){
				   
				   String key = iterFor3rdNeighbour.next();
				   List<String> neighbourList = neighbourMap2nd.get(key);
				   for(int n=0;n<neighbourList.size();n++)
				   {
					   if(!neighbourMap3rd.containsKey(key))
					   {
						 //!  List<String> List = new ArrayList<String>();
						   Set<String> hashSet = new HashSet<String>();
						   if(neighbourMap.containsKey(neighbourList.get(n)))
						   {
							   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
							/*!   for(int x=0;x<neighbourList2nd.size();x++)
							   {
								   if(!List.contains(neighbourList2nd.get(x)))
								   List.add(neighbourList2nd.get(x));
							   }!*/
							   hashSet.addAll(neighbourList2nd);
							   List<String> List = new ArrayList<String>(hashSet);
							   
							   if(List.contains(key))
							   {
								   List.remove(key);
							   }
							   
							   neighbourMap3rd.put(key,List);
						   }
					   }
					   else
					   {
						//!   List<String> List = neighbourMap3rd.get(key);
						   Set<String> hashSet = new HashSet<String>(neighbourMap3rd.get(key));
						   if(neighbourMap.containsKey(neighbourList.get(n)))
						   {
							   List<String> neighbourList2nd = neighbourMap.get(neighbourList.get(n));
							 /*!  for(int x=0;x<neighbourList2nd.size();x++)
							   {
								   if(!List.contains(neighbourList2nd.get(x)))
								   List.add(neighbourList2nd.get(x));
							   }!*/
							   hashSet.addAll(neighbourList2nd);
							   List<String> List = new ArrayList<String>(hashSet);
							   
							   if(List.contains(key))
							   {
								   List.remove(key);
							   }
							   
							   neighbourMap3rd.put(key,List);
						   }
					   }
					   
				   }   
			   }
			   long time4= System.currentTimeMillis();
		 
			   System.out.println("3rd :" + (time4-time3));
			   
			   
			   hfcmobj.getMoreMap(neighbourMap,neighbourMap2nd,neighbourMap3rd,predicateSubjMap,predicateObjMap,nameNumMap,nameNumMapReverse,subobjMap,secondmap,thirdmap);
		 
		 
			   System.out.println("Predicate Ranking:=======================================");
			   
			   SortedMap<String,Integer> pRank = new TreeMap<String,Integer>();
			   
			    for(int i=0;i<columnList.size();i++)
			    {
			    	String pp = columnList.get(i);
			    	int size = 0;
			    	if(neighbourMap.containsKey(pp))
			    	{
			    		int neiSize = neighbourMap.get(pp).size();
			    		size = size+neiSize;
			    	}
			    	if(neighbourMap2nd.containsKey(pp))
			    	{
			    		int neiSize = neighbourMap2nd.get(pp).size();
			    		size = size+neiSize;
			    	}
			    	if(neighbourMap3rd.containsKey(pp))
			    	{
			    		int neiSize = neighbourMap3rd.get(pp).size();
			    		size = size+neiSize;
			    	}
			    	if(!pRank.containsKey(pp))
			    	{
			    		pRank.put(pp,size);
			    	}		    	
			    }
			   
   			    Map<String,Integer> sortpRank = sortByValue(pRank);
   			    
   			    
   			 Iterator<String> itermap = sortpRank.keySet().iterator(); 
		       
			   while(itermap.hasNext()){
				   
				   String key = itermap.next();
				   int value = sortpRank.get(key);
				   System.out.println(key+"\t"+value);
				   
			   }
				
				
			   
			   
				   System.out.println("=======================================");

			   
			   
			 /*  Map<String, LinkedHashSet<String>> map = graph.returnMap();
			   System.out.println("graph size is: "+map.size());
		 			   
			   Iterator<String> itermap = map.keySet().iterator(); 
		       
			   while(itermap.hasNext()){
		    	   
		    	   String key = itermap.next();
		    	   LinkedHashSet<String> value = map.get(key);
		    	   
		    	   System.out.println(key+"====="+value.size());	    	   
		    	   }*/
			   
		 
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
				DoubleMatrix2D[][] csvMatrix4 = new DoubleMatrix2D[columnList.size()+1][columnList.size()]; //// add by 7/18/2014

				
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
					  float ps = 0;
					  float ps2=0;
					  float ps3=0;
					  float ps3_a=0;
					  float psfinal = 0;
					  
					  if(columnList.get(i).equals(columnList.get(j)))
					  {	
						  ps=0;
						  matrixProbSim[i][j]=ps;
						  name = name + "\t"+ matrixProbSim[i][j];	
						  name2 = name2+ matrixProbSim[i][j] + "\t";
						  csvMatrix3[i+1][j] =Float.toString(ps); //// add by 7/18/2014
						  continue;
					  }
					  
					 // System.out.println(columnList.get(i) + " and " + columnList.get(j));
					  
					  int count=0;
					  int distance=0;
					  
					  
	
					  List<String> neighbourListA = new ArrayList<String>();
					  List<String> neighbourListB = new ArrayList<String>();
					  List<String> neighbourListC = new ArrayList<String>();
					  List<String> neighbourListD = new ArrayList<String>();



	    			
					  
					  
					  if(neighbourMap.containsKey(columnList.get(i)))
					  {
						  List<String> totalSub = predicateSubjMap.get(columnList.get(i));
						  List<String> totalObj = predicateObjMap.get(columnList.get(i));
						/*  Set<String> s = new HashSet<String>(totalSub);
						  Set<String> s2 = new HashSet<String>(totalObj);*/
						  
						   // totalObj.addAll(totalSub);
							
						    neighbourListA = new ArrayList<String>(totalSub);
						    neighbourListA.addAll(totalObj);
							
							Set<String> setList = new LinkedHashSet<String>(neighbourListA);
							neighbourListA.clear();
							neighbourListA.addAll(setList);
						  
						 
						 
						//!  neighbourList1 = neighbourMap .get(columnList.get(i));
					  }
					  if(neighbourMap.containsKey(columnList.get(j)))
					  {
						  
						  
						  if(columnList.get(i).equals("http://yago-knowledge.org/resource/directed")&&columnList.get(j).equals("http://yago-knowledge.org/resource/graduatedFrom"))
						  {
							  System.out.println("here");
						  }
						  
						
						  
						  
						  List<String> totalSub = predicateSubjMap.get(columnList.get(j));
						  List<String> totalObj = predicateObjMap.get(columnList.get(j));
						//  neighbourListB.addAll(totalSub);
						 // neighbourListB.addAll(totalObj);
						  
						  neighbourListB = new ArrayList<String>(totalSub);
						  neighbourListB.addAll(totalObj);
							
							Set<String> setList = new LinkedHashSet<String>(neighbourListB);
							neighbourListB.clear();
							neighbourListB.addAll(setList);

						//!  neighbourList2 = neighbourMap.get(columnList.get(j));
					  }

					  
					/*  if(columnList.get(i).contains("target")&&columnList.get(j).contains("transporter"))
			    		 {
			    			 System.out.println(neighbourListA);
			    			 System.out.println(neighbourListB);

			    		 }*/
					  
					  List<String> common = new ArrayList<String>(neighbourListA);
					
					  
		    		  common.retainAll(neighbourListB);
		    		  
		    		 
		    		  
		    		/*!  if(columnList.get(i).contains("mapping-result")&&columnList.get(j).contains("stitch-stereo-compound-id"))
	    			  {
	    				  System.out.println("here");
	    				  System.out.println(neighbourListA);
	    				  System.out.println(neighbourListB);
	    				  System.out.println(common);

	    			  }!*/
		    		  
		    		  
		    		  if(common.size()!=0){
		    			  
						  /*System.out.println("("+i+","+j+"): "+columnList.get(i)+","+columnList.get(j));
						
						  System.out.println(neighbourListA);
						  System.out.println(neighbourListB);
						  System.out.println(common);*/
		    			  
		    			/*  if(columnList.get(i).contains("drugbank_vocabulary:target"))
	  					  {
		  					  if(columnList.get(j).contains("drugbank_vocabulary:x-hgnc"))

		  					  {
		  						  System.out.println();
		  					  }
		  					  
	  					  }*/
		    			  
		    			  
		    			  
		    		 ps = ((float)common.size()/(float)neighbourListA.size())*((float)common.size()/(float)neighbourListB.size()); //probability based simi
		    		 
		    		    int mark1 =  crossdomainMarkMap.get(columnList.get(j));
		    			int mark2 =  crossdomainMarkMap.get(columnList.get(i));
		    		 
		    			
		    			String Rpred1 = mapPredicateToRformat(columnList.get(i));
		    			String Rpred2 = mapPredicateToRformat(columnList.get(j));

					 	///////Connection Enhancement /////////////
						  List<String> totalSubj1 = predicateSubjMap.get(columnList.get(i));
						  List<String> totalObj1 = predicateObjMap.get(columnList.get(i));
						  
						  List<String> totalSubj2 = predicateSubjMap.get(columnList.get(j));
						  List<String> totalObj2 = predicateObjMap.get(columnList.get(j));

						  List<String> commonsubobj12 = new ArrayList<String>(totalObj1);
						  commonsubobj12.retainAll(totalSubj2);
						  
						  List<String> commonsubsub12 = new ArrayList<String>(totalSubj1);
						  commonsubsub12.retainAll(totalSubj2);
						 
						  List<String> commonobjobj12 = new ArrayList<String>(totalObj1);
						  commonobjobj12.retainAll(totalObj2);
						 						  
						  
					/*!!	  if(mark1!=mark2)
						  {
							  if(commonsubobj12.size()!=0)
							  {
								for(int a=0;a<totalSubj1.size();a++)
								{
									for(int b=0;b<commonsubobj12.size();b++)
									{
										String triple = totalSubj1.get(a)+","+columnList.get(i)+","+commonsubobj12.get(b);
										
										if(!level1triple.contains(triple))
										{
											level1triple.add(triple);
										}
									}
								}
								
								for(int a=0;a<commonsubobj12.size();a++)
								{
									for(int b=0;b<totalObj2.size();b++)
									{
										String triple = commonsubobj12.get(a)+","+columnList.get(j)+","+totalObj2.get(b);
										if(!level1triple.contains(triple))
										{
											level1triple.add(triple);
										}
									}
								}
									
							  }
							  
							  if(commonsubsub12.size()!=0)
							  {
								  for(int a=0;a<commonsubsub12.size();a++)
									{
										for(int b=0;b<totalObj1.size();b++)
										{
											String triple = commonsubsub12.get(a)+","+columnList.get(i)+","+totalObj1.get(b);
											
											if(!level1triple.contains(triple))
											{
												level1triple.add(triple);
											}
										}
									}
									
									for(int a=0;a<commonsubsub12.size();a++)
									{
										for(int b=0;b<totalObj2.size();b++)
										{
											String triple = commonsubsub12.get(a)+","+columnList.get(j)+","+totalObj2.get(b);
											
											if(!level1triple.contains(triple))
											{
												level1triple.add(triple);
											}
										}
									}
							  }
							  
							  if(commonobjobj12.size()!=0)
							  {
								  for(int a=0;a<totalSubj1.size();a++)
									{
										for(int b=0;b<commonobjobj12.size();b++)
										{
											String triple = totalSubj1.get(a)+","+columnList.get(i)+","+commonobjobj12.get(b);
											
											if(!level1triple.contains(triple))
											{
												level1triple.add(triple);
											}
										}
									}
									
									for(int a=0;a<totalSubj2.size();a++)
									{
										for(int b=0;b<commonobjobj12.size();b++)
										{
											String triple = totalSubj2.get(a)+","+columnList.get(j)+","+commonobjobj12.get(b);
											
											if(!level1triple.contains(triple))
											{
												level1triple.add(triple);
											}
										}
									}
							  }
						  }!!!*/
						  
					
						  
						  if(commonsubobj12.size()!=0)
						  {
					
							  
							  
							if(mark1!=mark2){ 
								
								
								  if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Level1-Reach-Pattern"))
								  {								  
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];

									  List<String> list = new ArrayList<String>();

									  list.add(domainX+"->"+"r:"+Rpred1+"->"+domainY);

									  PatternPredicateDomainMap.put(Rpred1+"@"+"Level1-Reach-Pattern", list);

								  }
								  else
								  {
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];
									  
									  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Level1-Reach-Pattern");
									  if(!list.contains(domainX+"->"+"r:"+Rpred1+"->"+domainY))
									  {
										  list.add(domainX+"->"+"r:"+Rpred1+"->"+domainY);
									  }
									  
									  
									  PatternPredicateDomainMap.put(Rpred1+"@"+"Level1-Reach-Pattern", list);		

								  }
								  
								  
								  if(!PatternPredicateDomainMap.containsKey(Rpred2+"@"+"Level1-Reach-Pattern"))
								  {								  
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];

									  List<String> list = new ArrayList<String>();

									  list.add(domainX+"->"+"r:"+Rpred2+"->"+domainY);

									  PatternPredicateDomainMap.put(Rpred2+"@"+"Level1-Reach-Pattern", list);

								  }
								  else
								  {
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];
									  
									  List<String> list = PatternPredicateDomainMap.get(Rpred2+"@"+"Level1-Reach-Pattern");
									  if(!list.contains(domainX+"->"+"r:"+Rpred1+"->"+domainY))
									  {
										  list.add(domainX+"->"+"r:"+Rpred1+"->"+domainY);
									  }
									  
									  
									  PatternPredicateDomainMap.put(Rpred2+"@"+"Level1-Reach-Pattern", list);		

								  }
								
							  if(!PredicateReachPatternMap.containsKey(Rpred1))
							  {
								  PredicateReachPatternMap.put(Rpred1,1);
							  }
							  else
							  {
								  int total = PredicateReachPatternMap.get(Rpred1);
								  total = total + 1;
								  PredicateReachPatternMap.put(Rpred1,total);
							  }
							  
							  if(!PredicateReachPatternMap.containsKey(Rpred2))
							  {
								  PredicateReachPatternMap.put(Rpred2,1);
							  }
							  else
							  {
								  int total = PredicateReachPatternMap.get(Rpred2);
								  total = total + 1;
								  PredicateReachPatternMap.put(Rpred2,total);
							  }
							  
							  
							
							if(!PatternMapL1.containsKey(Rpred1+";"+Rpred2))
							{
								List<String> list = new ArrayList<String>();
								list.add("Level1-Reach-Pattern");
								PatternMapL1.put(Rpred1+";"+Rpred2,list);
							}
							else
							{
								List<String> list = PatternMapL1.get(Rpred1+";"+Rpred2);
								if(!list.contains("Level1-Reach-Pattern"))
								{
									list.add("Level1-Reach-Pattern");
								}
								PatternMapL1.put(Rpred1+";"+Rpred2,list);
							}
							
							
							if(!PatternMapL1.containsKey(Rpred2+";"+Rpred1))
							{
								List<String> list = new ArrayList<String>();
								list.add("Level1-Reach-Pattern");
								PatternMapL1.put(Rpred2+";"+Rpred1,list);
							}
							else
							{
								List<String> list = PatternMapL1.get(Rpred2+";"+Rpred1);
								if(!list.contains("Level1-Reach-Pattern"))
								{
									list.add("Level1-Reach-Pattern");
								}
								PatternMapL1.put(Rpred2+";"+Rpred1,list);
							}
							}
						
						  }
						  
						  
						  if(commonsubsub12.size()!=0)
						  {		
							  
							  if(mark1!=mark2){
								  
								  for(int c=0;c<commonsubsub12.size();c++){
									  
									  String ent = commonsubsub12.get(c);
									  String sharedomain = "";
									  if(ent.contains("_vocabulary"))
									  {
										  sharedomain = ent.split("_vocabulary")[0].split("\\/")[3];
									  }
									  else
									  {
										  sharedomain = ent;
									  }
									  								  
								  if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Level1-Consumer-Pattern"))
								  {	
									  
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];

									  List<String> list = new ArrayList<String>();
									  if(sharedomain.equals(domainX)){
									  list.add(domainX+"->"+"c:"+Rpred1+"->"+domainY);
									  }
									  else if(sharedomain.equals(domainY)){
										  list.add(domainY+"->"+"c:"+Rpred2+"->"+domainX);  
									  }
									  else
									  {
										  list.add(domainX+"->"+"c:"+Rpred1+"->"+domainY+":"+sharedomain);
									  }
										  
									  PatternPredicateDomainMap.put(Rpred1+"@"+"Level1-Consumer-Pattern", list);
								  }
								  else
								  {
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];
									  
									  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Level1-Consumer-Pattern");
									 
									  if(sharedomain.equals(domainX)){
										  if(!list.contains(domainX+"->"+"c:"+Rpred1+"->"+domainY))
										  list.add(domainX+"->"+"c:"+Rpred1+"->"+domainY);
										  }
										  else if(sharedomain.equals(domainY)){
											  if(!list.contains(domainY+"->"+"c:"+Rpred2+"->"+domainX))
												  list.add(domainY+"->"+"c:"+Rpred2+"->"+domainX);  
										  }
										  else
										  {
											  if(!list.contains(domainX+"->"+"c:"+Rpred1+"->"+domainY+":"+sharedomain))
											  list.add(domainX+"->"+"c:"+Rpred1+"->"+domainY+":"+sharedomain);
										  }
									  
									  PatternPredicateDomainMap.put(Rpred1+"@"+"Level1-Consumer-Pattern", list);								  
								  }
								  }
								  
							  
							  if(!PredicateConsumerPatternMap.containsKey(Rpred1))
							  {
								  PredicateConsumerPatternMap.put(Rpred1,1);
							  }
							  else
							  {
								  int total = PredicateConsumerPatternMap.get(Rpred1);
								  total = total + 1;
								  PredicateConsumerPatternMap.put(Rpred1,total);
							  }
							  
							  if(!PredicateConsumerPatternMap.containsKey(Rpred2))
							  {
								  PredicateConsumerPatternMap.put(Rpred2,1);
							  }
							  else
							  {
								  int total = PredicateConsumerPatternMap.get(Rpred2);
								  total = total + 1;
								  PredicateConsumerPatternMap.put(Rpred2,total);
							  }
							  
							  
							  if(!PatternMapL1.containsKey(Rpred1+";"+Rpred2))
								{
									List<String> list = new ArrayList<String>();
									list.add("Level1-Consumer-Pattern");
									PatternMapL1.put(Rpred1+";"+Rpred2,list);
								}
								else
								{
									List<String> list = PatternMapL1.get(Rpred1+";"+Rpred2);
									if(!list.contains("Level1-Consumer-Pattern"))
									{
										list.add("Level1-Consumer-Pattern");
									}
									PatternMapL1.put(Rpred1+";"+Rpred2,list);
								}
							  
							  
							  if(!PatternMapL1.containsKey(Rpred2+";"+Rpred1))
								{
									List<String> list = new ArrayList<String>();
									list.add("Level1-Consumer-Pattern");
									PatternMapL1.put(Rpred2+";"+Rpred1,list);
								}
								else
								{
									List<String> list = PatternMapL1.get(Rpred2+";"+Rpred1);
									if(!list.contains("Level1-Consumer-Pattern"))
									{
										list.add("Level1-Consumer-Pattern");
									}
									PatternMapL1.put(Rpred2+";"+Rpred1,list);
								}
							  }
							  
						  }
		    			
						  
						
						  
							  
						  if(commonobjobj12.size()!=0)
						  {	
							  
							  if(mark1!=mark2){
								  
							
								  for(int c=0;c<commonobjobj12.size();c++){
									  
									  String ent = commonobjobj12.get(c);
									  String sharedomain = "";
									  if(ent.contains("_vocabulary"))
									  {
										  sharedomain = ent.split("_vocabulary")[0].split("\\/")[3];
									  }
									  								  
								  if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Level1-Provider-Pattern"))
								  {	
									  
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];

									  List<String> list = new ArrayList<String>();
									  if(sharedomain.equals(domainX)){
									  list.add(domainY+"->"+"p:"+Rpred1+"->"+domainX);
									  }
									  else if(sharedomain.equals(domainY)){
										  list.add(domainX+"->"+"p:"+Rpred2+"->"+domainY);  
									  }
									  else
									  {
										  list.add(domainX+"->"+"r:"+Rpred1+"->"+domainY+":"+sharedomain);
									  }
										  
									  PatternPredicateDomainMap.put(Rpred1+"@"+"Level1-Provider-Pattern", list);
								  }
								  else
								  {
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred2.split("_vocabulary")[0].split("org.")[1];
									  
									  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Level1-Provider-Pattern");
									 
									  if(sharedomain.equals(domainX)){
										  if(!list.contains(domainY+"->"+"p:"+Rpred1+"->"+domainX))
										  list.add(domainY+"->"+"p:"+Rpred1+"->"+domainX);
										  }
										  else if(sharedomain.equals(domainY)){
											  if(!list.contains(domainX+"->"+"p:"+Rpred2+"->"+domainY))
											  list.add(domainX+"->"+"p:"+Rpred2+"->"+domainY);  
										  }
										  else
										  {
											  if(!list.contains(domainX+"->"+"p:"+Rpred1+"->"+domainY+":"+sharedomain))
											  list.add(domainX+"->"+"p:"+Rpred1+"->"+domainY+":"+sharedomain);
										  }
									  
									  PatternPredicateDomainMap.put(Rpred1+"@"+"Level1-Provider-Pattern", list);								  
								  }
								  }
							 
								  
								  
								 
							  if(!PredicateProviderPatternMap.containsKey(Rpred1))
							  {
								  PredicateProviderPatternMap.put(Rpred1,1);
							  }
							  else
							  {
								  int total = PredicateProviderPatternMap.get(Rpred1);
								  total = total + 1;
								  PredicateProviderPatternMap.put(Rpred1,total);
							  }
							  
							  if(!PredicateProviderPatternMap.containsKey(Rpred2))
							  {
								  PredicateProviderPatternMap.put(Rpred2,1);
							  }
							  else
							  {
								  int total = PredicateProviderPatternMap.get(Rpred2);
								  total = total + 1;
								  PredicateProviderPatternMap.put(Rpred2,total);
							  }
							  
							  
							  
							  if(!PatternMapL1.containsKey(Rpred1+";"+Rpred2))
								{
									List<String> list = new ArrayList<String>();
									list.add("Level1-Provider-Pattern");
									PatternMapL1.put(Rpred1+";"+Rpred2,list);
								}
								else
								{
									List<String> list = PatternMapL1.get(Rpred1+";"+Rpred2);
									if(!list.contains("Level1-Provider-Pattern"))
									{
										list.add("Level1-Provider-Pattern");
									}
									PatternMapL1.put(Rpred1+";"+Rpred2,list);
								}
							  
							  
							  if(!PatternMapL1.containsKey(Rpred2+";"+Rpred1))
								{
									List<String> list = new ArrayList<String>();
									list.add("Level1-Provider-Pattern");
									PatternMapL1.put(Rpred2+";"+Rpred1,list);
								}
								else
								{
									List<String> list = PatternMapL1.get(Rpred2+";"+Rpred1);
									if(!list.contains("Level1-Provider-Pattern"))
									{
										list.add("Level1-Provider-Pattern");
									}
									PatternMapL1.put(Rpred2+";"+Rpred1,list);
								} 
							  }
						  }
		    		 
						  
		    		 
		    		 if(cross)
		    		 {
		    			
		    			 if(mark1==mark2&&ps!=0)
			    		 {
			    			 if(ps-weighDeduct>0)
			    			 {
			    				 ps = ps-weighDeduct;
			    			 }
			    			 else
			    			 {
			    				 ps = (float)0.1;
			    			 }
			    		 }
		    			 
		    			
		    			if(mark1!=mark2)
		    			{
		    				if(ps+weighEnhance<0.8){
		    				ps = ps+weighEnhance;
		    				}
		    				else
		    				{
		    					ps = (float) 0.8;
		    					//ps = (float) 10;

		    				}
		    				
		    				//System.out.println(columnList.get(j)+","+columnList.get(i)+":"+ps);
		    			}

		    		 }
		    		 //!  	  ps = ((float)common.size()/((float)neighbourListA.size()+(float)neighbourListB.size())); //jaccard
		    			  
		    		//!	  ps = (2*(float)common.size()/((float)neighbourListA.size()+(float)neighbourListB.size())); //Sorensen-Dice coefficient
		    			  
		    		//	  ps = 1-ps;
		    		 //! ps=ps*100;//!!! temp add 4.21.2015
		    		  }
		    		  else
		    		  {
		    		  ps=0;
		    		  }
		    		  
		    		  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		    	
		    		
	
		    		  if(ps==0){
		    			  
		    			  if(columnList.get(i).equals("http://bio2rdf.org/clinicaltrials_vocabulary:lead-sponsor")&&columnList.get(j).equals("http://bio2rdf.org/pharmgkb_vocabulary:drug"))
						  {
							  System.out.println("there");
						  }
		    			  
		    			  secondList.clear();
		    				
		    				getPathsfor2ndTest(i,j);
		    				
		    			
		    			SortedMap<String,List<String>> ps2SecondMap = new TreeMap<String,List<String>>();
		    						    	
		    			String finalpred1 = "";
		    			String finalpred2 = "";
		    			String finalpred3="";
		    			
		    			for(int u=0;u<secondList.size();u++){			    						    		
		    					
		    				int connectionflag = 0;
		    				
		    					String pred1 = nameNumMapReverse.get(Integer.parseInt(secondList.get(u).split("->")[0]));
		    					String pred2 = nameNumMapReverse.get(Integer.parseInt(secondList.get(u).split("->")[1]));
		    					String pred3 = nameNumMapReverse.get(Integer.parseInt(secondList.get(u).split("->")[2]));
		    					
		    					  
		    					
		    					/*if(pred1.contains("drugbank_vocabulary:form")&&pred3.contains("pharmgkb_vocabulary:x-MeSH"))
		    					{
		    						System.out.println(secondList.get(u));
		    					}*/
		    					
		    					finalpred1 = pred1;
		    					finalpred3 = pred3;

		    					String Rpred1 = mapPredicateToRformat(pred1);
		    					String Rpred2 = mapPredicateToRformat(pred2);
		    					String Rpred3 = mapPredicateToRformat(pred3);
		    					
		    					int markX =  crossdomainMarkMap.get(pred1);
				    			int markY =  crossdomainMarkMap.get(pred3);
				    		 
		    					
		    			/*!!		if(!secondConnectionMap.containsKey(pred1+":"+pred3)){
		    						List<String> predList = new ArrayList<String>();
		    						predList.add(pred2);
		    					    secondConnectionMap.put(pred1+":"+pred3,predList);
		    					}
		    					else
		    					{
		    						List<String> predList = secondConnectionMap.get(pred1+":"+pred3);
		    						if(!predList.contains(pred2))
		    						{
		    							predList.add(pred2);
		    						}
			    					secondConnectionMap.put(pred1+":"+pred3,predList);
		    					}
		    					
		    					
		    					if(!secondConnectionMap.containsKey(pred3+":"+pred1)){
		    						List<String> predList = new ArrayList<String>();
		    						predList.add(pred2);
		    					    secondConnectionMap.put(pred3+":"+pred1,predList);
		    					}
		    					else
		    					{
		    						List<String> predList = secondConnectionMap.get(pred3+":"+pred1);
		    						if(!predList.contains(pred2))
		    						{
		    							predList.add(pred2);
		    						}
			    					secondConnectionMap.put(pred3+":"+pred1,predList);
		    					}!!*/

  						        

  							  
  							/* if(pred1.contains("target")||pred1.contains("transporter"))
		  					  {
			  					  if(pred3.contains("target")||pred3.contains("transporter"))

			  					  {
			  						  System.out.println(pred2);
			  					  }
			  					  
		  					  }*/

		    					

  							  
  							 	///////Connection Enhancement /////////////
	  					//!!		  List<String> totalSubj1 = predicateSubjMap.get(pred1);
  							  List<String> totalObj1 = predicateObjMap.get(pred1);
  							  List<String> totalSubj2_1 = predicateSubjMap.get(pred2);

  							  List<String> totalObj2 = predicateObjMap.get(pred2);
  							  List<String> totalObj3 = predicateObjMap.get(pred3);
  							  List<String> totalSubj2 = predicateSubjMap.get(pred2);
  							  List<String> totalSubj3 = predicateSubjMap.get(pred3);
  							  

  							 
  							  List<String> commonobj23 = new ArrayList<String>(totalObj2);
  							  commonobj23.retainAll(totalObj3);
  							 
  							  List<String> commonsubobj23 = new ArrayList<String>(totalObj2);
  							  commonsubobj23.retainAll(totalSubj3);

  							  List<String> commonsubobj12 = new ArrayList<String>(totalObj1);
  							  commonsubobj12.retainAll(totalSubj2);
  							  
  							 /*!!	  List<String> commonobj12 = new ArrayList<String>(totalObj1);
  							  commonsubobj12.retainAll(totalObj2);

  							  
  						  if(markX!=markY)
  						   {
  							  if(commonsubobj23.size()!=0)
	  							  {
	  								for(int a =0;a<totalSubj2.size();a++)
									  {
										  for(int b=0;b<commonobj23.size();b++)
										  {
											  String triple = totalSubj2.get(a)+","+pred2+","+commonobj23.get(b);
											  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
										  }
									  } 
	  								for(int a =0;a<commonobj23.size();a++)
									  {
										  for(int b=0;b<totalObj3.size();b++)
										  {
											  String triple = commonobj23.get(a)+","+pred3+","+totalObj3.get(b);
											  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
										  }
									  }
	  								
	  							  }
	  							  
	  							  if(commonsubobj12.size()!=0)
	  							  {
	  								for(int a =0;a<totalSubj1.size();a++)
									  {
										  for(int b=0;b<commonsubobj12.size();b++)
										  {
											  String triple = totalSubj1.get(a)+","+pred1+","+commonsubobj12.get(b);
											  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
										  }
									  } 
	  								for(int a =0;a<commonsubobj12.size();a++)
									  {
										  for(int b=0;b<totalObj2.size();b++)
										  {
											  String triple = commonsubobj12.get(a)+","+pred2+","+totalObj2.get(b);
											  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
										  }
									  }
	  								
	  							  }
	  							  
	  							  
	  							  if(commonobj23.size()!=0)
	  							  {
	  								  for(int a =0;a<totalSubj2.size();a++)
	  								  {
	  									  for(int b=0;b<commonobj23.size();b++)
	  									  {
	  										  String triple = totalSubj2.get(a)+","+pred2+","+commonobj23.get(b);
	  										  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
	  									  }
	  								  }
	  								for(int a =0;a<totalSubj3.size();a++)
									  {
										  for(int b=0;b<commonobj23.size();b++)
										  {
											  String triple = totalSubj3.get(a)+","+pred3+","+commonobj23.get(b);
											  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
										  }
									  }		
	  							  }
	  							  
	  							  if(commonobj12.size()!=0)
								  {
	  								  for(int a =0;a<totalSubj1.size();a++)
	  								  {
	  									  for(int b=0;b<commonobj12.size();b++)
	  									  {
	  										  String triple = totalSubj1.get(a)+","+pred1+","+commonobj12.get(b);
	  										  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
	  									  }
	  								  }
	  								  
	  								for(int a =0;a<totalSubj2.size();a++)
									  {
										  for(int b=0;b<commonobj12.size();b++)
										  {
											  String triple = totalSubj2.get(a)+","+pred2+","+commonobj12.get(b);
											  if(!secondTriple.contains(triple))
											  {
												  secondTriple.add(triple);
											  }
										  }
									  }							  
	  								}
							
  						   }*/
  							  
  							  
  							  
  							  if(commonsubobj23.size()!=0&&commonsubobj12.size()!=0)
  							  {
  								  System.out.println(pred1);
  								  System.out.println(pred2);
  								  System.out.println(pred3);

  								connectionflag = 1;
  							
  								if(markX!=markY){
  									
  									if(!DirectedPathMap.containsKey(Rpred1+";"+Rpred3))
  									{
  										List<String> list = new ArrayList<String>();
  										list.add(Rpred1+"->"+Rpred2+"->"+Rpred3);
  										DirectedPathMap.put(Rpred1+";"+Rpred3,list);
  									}
  									else
  									{
  										List<String> list = DirectedPathMap.get(Rpred1+";"+Rpred3);
  										if(!list.contains(Rpred1+"->"+Rpred2+"->"+Rpred3))
  										{
  											list.add(Rpred1+"->"+Rpred2+"->"+Rpred3);
  										}
  										DirectedPathMap.put(Rpred1+";"+Rpred3,list);
  									}
  								
  								  if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Directed-Connection-Pattern"))
								  {								  
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];

									  List<String> list = new ArrayList<String>();

									  list.add(domainX+"->"+"dc:"+Rpred1+"->"+domainY);

									  PatternPredicateDomainMap.put(Rpred1+"@"+"Directed-Connection-Pattern", list);

								  }
								  else
								  {
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];
									  
									  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Directed-Connection-Pattern");
									  if(!list.contains(domainX+"->"+"dc:"+Rpred1+"->"+domainY))
									  {
										  list.add(domainX+"->"+"dc:"+Rpred1+"->"+domainY);
									  }
									  
									  
									  
									  PatternPredicateDomainMap.put(Rpred1+"@"+"Directed-Connection-Pattern", list);	

								  }
								  

  								  if(!PatternPredicateDomainMap.containsKey(Rpred3+"@"+"Directed-Connection-Pattern"))
								  {								  
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];

									  List<String> list = new ArrayList<String>();

									  list.add(domainX+"->"+"dc:"+Rpred3+"->"+domainY);

									  PatternPredicateDomainMap.put(Rpred3+"@"+"Directed-Connection-Pattern", list);

								  }
								  else
								  {
									  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
									  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];
									  
									  List<String> list = PatternPredicateDomainMap.get(Rpred3+"@"+"Directed-Connection-Pattern");
									  if(!list.contains(domainX+"->"+"dc:"+Rpred3+"->"+domainY))
									  {
										  list.add(domainX+"->"+"dc:"+Rpred3+"->"+domainY);
									  }
									  
									  
									  
									  PatternPredicateDomainMap.put(Rpred3+"@"+"Directed-Connection-Pattern", list);	

								  }
  									
  									
  								if(!PatternMapUp.containsKey(Rpred1+";"+Rpred3))
  								{
  									PatternMapUp.put(Rpred1+";"+Rpred3,"Directed-Connection-Pattern");
  								}
  								
  								if(!PatternMapUp.containsKey(Rpred3+";"+Rpred1))
  								{
  									PatternMapUp.put(Rpred3+";"+Rpred1,"Directed-Connection-Pattern");
  								}
  								
  								
  							  if(!PredicateDirectedPatternMap.containsKey(Rpred1))
  							  {
  								PredicateDirectedPatternMap.put(Rpred1,1);
  							  }
  							  else
  							  {
  								  int total = PredicateDirectedPatternMap.get(Rpred1);
  								  total = total + 1;
  								PredicateDirectedPatternMap.put(Rpred1,total);
  							  }
  							  
  							if(!PredicateDirectedPatternMap.containsKey(Rpred3))
							  {
								PredicateDirectedPatternMap.put(Rpred3,1);
							  }
							  else
							  {
								  int total = PredicateDirectedPatternMap.get(Rpred3);
								  total = total + 1;
								PredicateDirectedPatternMap.put(Rpred3,total);
							  }
  								
  							  }
  							  }
		    					
  							  
  							  if(connectionflag==0)
  							  {
  								  
  								
  								  
  								if(markX!=markY){
  									
  									if(!NonDirectedPathMap.containsKey(Rpred1+";"+Rpred3))
									{
										List<String> list = new ArrayList<String>();
										list.add(Rpred1+"->"+Rpred2+"->"+Rpred3);
										NonDirectedPathMap.put(Rpred1+";"+Rpred3,list);
									}
									else
									{
										List<String> list = NonDirectedPathMap.get(Rpred1+";"+Rpred3);
										if(!list.contains(Rpred1+"->"+Rpred2+"->"+Rpred3))
										{
											list.add(Rpred1+"->"+Rpred2+"->"+Rpred3);
										}
										NonDirectedPathMap.put(Rpred1+";"+Rpred3,list);
									}
  									
  									 if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Non-Directed-Connection-Pattern"))
  									  {								  
  										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
  										  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];

  										  List<String> list = new ArrayList<String>();

  										  list.add(domainX+"->"+"ndc:"+Rpred1+"->"+domainY);

  										  PatternPredicateDomainMap.put(Rpred1+"@"+"Non-Directed-Connection-Pattern", list);

  									  }
  									  else
  									  {
  										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
  										  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];
  										  
  										  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Non-Directed-Connection-Pattern");
  										  if(!list.contains(domainX+"->"+"ndc:"+Rpred1+"->"+domainY))
  										  {
  											  list.add(domainX+"->"+"ndc:"+Rpred1+"->"+domainY);
  										  }
  										  
  										 
  										  PatternPredicateDomainMap.put(Rpred1+"@"+"Non-Directed-Connection-Pattern", list);

  									  }
  									 
  									 
  									if(!PatternPredicateDomainMap.containsKey(Rpred3+"@"+"Non-Directed-Connection-Pattern"))
									  {								  
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];

										  List<String> list = new ArrayList<String>();

										  list.add(domainX+"->"+"ndc:"+Rpred3+"->"+domainY);

										  PatternPredicateDomainMap.put(Rpred3+"@"+"Non-Directed-Connection-Pattern", list);

									  }
									  else
									  {
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred3.split("_vocabulary")[0].split("org.")[1];
										  
										  List<String> list = PatternPredicateDomainMap.get(Rpred3+"@"+"Non-Directed-Connection-Pattern");
										  if(!list.contains(domainX+"->"+"ndc:"+Rpred3+"->"+domainY))
										  {
											  list.add(domainX+"->"+"ndc:"+Rpred3+"->"+domainY);
										  }
										  
										 
										  PatternPredicateDomainMap.put(Rpred3+"@"+"Non-Directed-Connection-Pattern", list);

									  }
  									
  								if(!PatternMapUp.containsKey(Rpred1+";"+Rpred3))
  								{
  									PatternMapUp.put(Rpred1+";"+Rpred3,"Non-Directed-Connection-Pattern");
  								}
  								
  								if(!PatternMapUp.containsKey(Rpred3+";"+Rpred1))
  								{
  									PatternMapUp.put(Rpred3+";"+Rpred1,"Non-Directed-Connection-Pattern");
  								} 
  								
  								
  								 if(!PredicateNonDirectedPatternMap.containsKey(Rpred1))
  	  							  {
  									PredicateNonDirectedPatternMap.put(Rpred1,1);
  	  							  }
  	  							  else
  	  							  {
  	  								  int total = PredicateNonDirectedPatternMap.get(Rpred1);
  	  								  total = total + 1;
  	  								PredicateNonDirectedPatternMap.put(Rpred1,total);
  	  							  }
  								 
  								 if(!PredicateNonDirectedPatternMap.containsKey(Rpred3))
 	  							  {
 									PredicateNonDirectedPatternMap.put(Rpred3,1);
 	  							  }
 	  							  else
 	  							  {
 	  								  int total = PredicateNonDirectedPatternMap.get(Rpred3);
 	  								  total = total + 1;
 	  								PredicateNonDirectedPatternMap.put(Rpred3,total);
 	  							  }
  								}
  	  							  
  							  }
  							  
		    					
		  					 
		    					
		    					
		    					neighbourListA.clear();
    			    			neighbourListB.clear();
    			    			neighbourListC.clear();
    			    			neighbourListD.clear();
    			    			
    			    			  List<String> totalSubA = predicateSubjMap.get(pred1);
    							  List<String> totalObjA = predicateObjMap.get(pred1);
    							  //neighbourListA.addAll(totalSubA);
    							  //neighbourListA.addAll(totalObjA);
    							  
    							  neighbourListA = new ArrayList<String>(totalSubA);
    							    neighbourListA.addAll(totalObjA);
    								
    								Set<String> setList = new LinkedHashSet<String>(neighbourListA);
    								neighbourListA.clear();
    								neighbourListA.addAll(setList);
    							  
	    						 //AB
	    						  List<String> SubB = predicateSubjMap.get(pred2);
	    						  List<String> ObjB = predicateObjMap.get(pred2);
	    						//  neighbourListB.addAll(SubB);
	    						//  neighbourListB.addAll(ObjB);
	    						  
	    						  neighbourListB = new ArrayList<String>(SubB);
	    						  neighbourListB.addAll(ObjB);
  								
  								Set<String> setList2 = new LinkedHashSet<String>(neighbourListB);
  								neighbourListB.clear();
  								neighbourListB.addAll(setList2);
	    						  
	    						  List<String> commonB = new ArrayList<String>(neighbourListA);
	    			    		  commonB.retainAll(neighbourListB);
	    						  float AB = ((float)commonB.size()/(float)neighbourListA.size())*((float)commonB.size()/(float)neighbourListB.size());
	    						//!float AB = ((float)commonB.size()/((float)neighbourListA.size()+(float)neighbourListB.size()));//jaccard
	        					//!float AB = (2*(float)commonB.size()/((float)neighbourListA.size()+(float)neighbourListB.size()));//Sorensen-Dice coefficient
	    						  
	    						//  System.out.println(commonB);
	    						  
	    						 //BC
	    						  List<String> SubC = predicateSubjMap.get(pred3);
	    						  List<String> ObjC = predicateObjMap.get(pred3);
	    						 // neighbourListC.addAll(SubC);
	    						//  neighbourListC.addAll(ObjC);
	    						 
	    						  neighbourListC = new ArrayList<String>(SubC);
	    						  neighbourListC.addAll(ObjC);
  								
  								Set<String> setList3 = new LinkedHashSet<String>(neighbourListC);
  								neighbourListC.clear();
  								neighbourListC.addAll(setList3);
	    						  
	    						  
	    						  
	    						  List<String> commonC = new ArrayList<String>(neighbourListB);
	    			    		  commonC.retainAll(neighbourListC);		    						 		    			    		 
		    					  float BC = ((float)commonC.size()/(float)neighbourListB.size())*((float)commonC.size()/(float)neighbourListC.size());
		    					//!float BC = ((float)commonC.size()/((float)neighbourListB.size()+(float)neighbourListC.size()));//jaccard
			    				//!float BC = (2*(float)commonC.size()/((float)neighbourListB.size()+(float)neighbourListC.size()));//Sorensen-Dice coefficient
		    					

		    				  if(pred1.contains("glycomedb"))
			  					  {
		    	     			   if(pred3.contains("omim_vocabulary:mapping-method")||pred3.contains("omim_vocabulary:mapping-method"))

				  					  {
				  						  System.out.println(pred2);
				  						System.out.println(SubC);
					  					System.out.println(ObjC);
				  					  }
				  					  
				  				//	System.out.println(commonB);
				  					

				  					  
			  					  }
	    						//  System.out.println(commonC);

		    					/*  if(recordMap2.containsKey(Integer.toString(i)+","+Integer.toString(j)))
		    					  {
		    						  ps2=recordMap2.get(Integer.toString(i)+","+Integer.toString(j));
		    						  
		    						  if(AB*BC<ps2)
				    					 {
				    						 ps2 = AB*BC;
				    						  recordMap2.put(Integer.toString(i)+","+Integer.toString(j),AB*BC);

				    					 }

		    					  }
		    					  else
		    					  {
		    						  ps2=AB*BC;
		    						  recordMap2.put(Integer.toString(i)+","+Integer.toString(j),AB*BC);
		    					  }*/
		    					  
		    					
		    					  /*	System.out.println(i+","+j);
		    						System.out.println(columnList.get(i)+columnList.get(j));
		    						System.out.println("^^^^^^"+AB*BC);*/
		    					  
		    					  
		    					  
		    					     if(ps2<AB*BC)
			    					 {
			    						 ps2 = AB*BC;
			    						 
			    						 finalpred2 = pred2;
			    					 }
		    					  
		    						 float ps2_2 = 0;
		    						 
		    						 
		    						
		    						 
		    						 
			    					 
				    					
			    					 if(!recordMap2.containsKey(Integer.toString(i)+","+Integer.toString(j)))
			    					  {
			    						 if(recordMap2.containsKey(Integer.toString(j)+","+Integer.toString(i)))
			    						 {
			    							 ps2_2 = recordMap2.get(Integer.toString(j)+","+Integer.toString(i));
			    							 if(ps2<ps2_2)
			    							 {
			    								 ps2 = ps2_2;
			    								 recordMap2.put(Integer.toString(i)+","+Integer.toString(j),ps2);
			    							 }
			    							 else
			    							 {
					    						 recordMap2.put(Integer.toString(i)+","+Integer.toString(j),ps2);  
			    							 }
			    						 }
			    						 else
			    						 {
				    						 recordMap2.put(Integer.toString(i)+","+Integer.toString(j),ps2); 

			    						 }
			    						 
			    					  }
			    					 
			    					 if(cross&&ps2!=0)
			    		    		// if(cross)
			    					 {
			    		    			int mark1 =  crossdomainMarkMap.get(columnList.get(j));
			    		    			int mark2 =  crossdomainMarkMap.get(columnList.get(i));
			    		    			
			    		    			if(mark1!=mark2)
			    		    			{
			    		    				if(connectionflag==1){
			    		    					if(ps2+weighEnhancePlus2<0.7){
					    		    				ps2 = ps2+weighEnhancePlus2;
					    		    				}
					    		    				else
					    		    				{
					    		    					ps2 = (float) 0.7;
					    		    					//ps2 = (float) 10;
		
					    		    				}
			    		    					
			    		    				/*	csvMatrix3[columnList.indexOf(pred1)+1][columnList.indexOf(pred2)] =Float.toString(1-ps2);
			    		    					csvMatrix3[columnList.indexOf(pred2)+1][columnList.indexOf(pred1)] =Float.toString(1-ps2);

			    		    					
			    		    					csvMatrix3[columnList.indexOf(pred2)+1][columnList.indexOf(pred3)] =Float.toString(1-ps2);
			    		    					csvMatrix3[columnList.indexOf(pred3)+1][columnList.indexOf(pred2)] =Float.toString(1-ps2);*/		    		    					
			    		    				}
			    		    				
			    		    				else{
				    		    				if(ps2+weighEnhance<0.6){
				    		    				ps2 = ps2+weighEnhance;
				    		    				}
				    		    				else
				    		    				{
				    		    					ps2 = (float) 0.6;
				    		    					//ps2 = (float) 10;
	
				    		    				}
			    		    				}
			    		    				
			    		    			//	System.out.println(columnList.get(j)+","+columnList.get(i)+":"+ps2);

			    		    			}

			    		    		 }
		    			
		    			
		    			}
		    			
		    			
		    			 if(!secondConnectionMap.containsKey(finalpred1+":"+finalpred3)){
	    						List<String> predList = new ArrayList<String>();
	    						predList.add(finalpred2);
	    					    secondConnectionMap.put(finalpred1+":"+finalpred3,predList);
	    					}
	    					else
	    					{
	    						List<String> predList = secondConnectionMap.get(finalpred1+":"+finalpred3);
	    						if(!predList.contains(finalpred2))
	    						{
	    							predList.add(finalpred2);
	    						}
		    					secondConnectionMap.put(finalpred1+":"+finalpred3,predList);
	    					}
	    					
	    					
	    					if(!secondConnectionMap.containsKey(finalpred3+":"+finalpred1)){
	    						List<String> predList = new ArrayList<String>();
	    						predList.add(finalpred2);
	    					    secondConnectionMap.put(finalpred3+":"+finalpred1,predList);
	    					}
	    					else
	    					{
	    						List<String> predList = secondConnectionMap.get(finalpred3+":"+finalpred1);
	    						if(!predList.contains(finalpred2))
	    						{
	    							predList.add(finalpred2);
	    						}
		    					secondConnectionMap.put(finalpred3+":"+finalpred1,predList);
	    					}
		    			
		    			
		    			
		    		  }
		    				
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		    			
		    			long m1 = System.currentTimeMillis();
		    	//		if(neighbourMap3rd.get(columnList.get(i)).contains(columnList.get(j)))
		    			//{
		    			
		    			if(ps==0&&ps2==0){
		    			
		    				
		    				  
		    				
		    				//System.out.println("in 3rd");
		    				
		    				thirdList.clear();
	    				
	    			//!	getPathsfor3rd(node[i], null, node[i], node[j]);
						getPathsfor3rdTest(i,j);;
	    			//	System.out.println("=======sers=======");
	    				
					String finalpred31 = "";
					String finalpred32 = "";
					String finalpred33 = "";
					String finalpred34 = "";
				    
	    			for(int u=0;u<thirdList.size();u++){
	    				int connectionflag = 0;

	    			//	System.out.println();
	    				//for (int item = 0; item < sers.get(u).length; item++) {
	    				
	    					String pred1 = nameNumMapReverse.get(Integer.parseInt(thirdList.get(u).split("->")[0]));
	    					String pred2 = nameNumMapReverse.get(Integer.parseInt(thirdList.get(u).split("->")[1]));
	    					String pred3 = nameNumMapReverse.get(Integer.parseInt(thirdList.get(u).split("->")[2]));
	    					String pred4 = nameNumMapReverse.get(Integer.parseInt(thirdList.get(u).split("->")[3]));
	    					
	    					
	    					if(pred1.contains("drugbank_vocabulary:form")&&pred4.contains("pharmgkb_vocabulary:x-MeSH"))
	    					{
	    						System.out.println(thirdList.get(u));
	    					}
	    					
	    					finalpred31 = pred1;
	    					finalpred34 = pred4;
	    					
	    					String Rpred1 = mapPredicateToRformat(pred1);
	    					String Rpred2 = mapPredicateToRformat(pred2);
	    					String Rpred3 = mapPredicateToRformat(pred3);
	    					String Rpred4 = mapPredicateToRformat(pred4);
	    					
	    					int markX =  crossdomainMarkMap.get(pred1);
			    			int markY =  crossdomainMarkMap.get(pred4);
	    					
	    			/*		
	    					if(!thirdConnectionMap.containsKey(pred1+":"+pred4)){
	    						List<String> predList = new ArrayList<String>();
	    						predList.add(pred2);
	    						predList.add(pred3);
	    						thirdConnectionMap.put(pred1+":"+pred4,predList);
	    					}
	    					else
	    					{
	    						List<String> predList = thirdConnectionMap.get(pred1+":"+pred4);
	    						if(!predList.contains(pred2))
	    						{
	    							predList.add(pred2);
	    						}
	    						if(!predList.contains(pred3))
	    						{
	    							predList.add(pred3);
	    						}
	    						thirdConnectionMap.put(pred1+":"+pred4,predList);
	    					}
	    					
	    					
	    					if(!thirdConnectionMap.containsKey(pred4+":"+pred1)){
	    						List<String> predList = new ArrayList<String>();
	    						predList.add(pred2);
	    						predList.add(pred3);
	    						thirdConnectionMap.put(pred4+":"+pred1,predList);
	    					}
	    					else
	    					{
	    						List<String> predList = thirdConnectionMap.get(pred4+":"+pred1);
	    						if(!predList.contains(pred2))
	    						{
	    							predList.add(pred2);
	    						}
	    						if(!predList.contains(pred3))
	    						{
	    							predList.add(pred3);
	    						}
	    						thirdConnectionMap.put(pred4+":"+pred1,predList);
	    					}
*/
	    					
	    					
	    					////////////// Connection Enhance /////////////////
	    					
	    					 if(pred1.contains("drugbank_vocabulary:target"))
		  					  {
			  					  if(pred4.contains("allele"))

			  					  {
			  						  
			  						  if(pred2.contains("x-hgnc")){

			  						  System.out.println(pred3);
			  						  }
			  					  }
			  					  
		  					  }

	    					
	    					
	    					
	    					  List<String> totalObj1 = predicateObjMap.get(pred1);

	    					  List<String> totalObj2 = predicateObjMap.get(pred2);
  							  List<String> totalSubj2 = predicateSubjMap.get(pred2);
  							  List<String> totalObj3 = predicateObjMap.get(pred3);
  							  List<String> totalSubj3 = predicateSubjMap.get(pred3);
  							  
  							  List<String> totalObj4 = predicateObjMap.get(pred4);
  							  List<String> totalSubj4 = predicateSubjMap.get(pred4);


  							 List<String> commonsubobj12 = new ArrayList<String>(totalObj1);
  							 commonsubobj12.retainAll(totalSubj2);
  							  
  							 List<String> commonobj23 = new ArrayList<String>(totalObj2);
  							 commonobj23.retainAll(totalObj3);
  							 
  							 List<String> commonsubobj23 = new ArrayList<String>(totalObj2);
  							 commonsubobj23.retainAll(totalSubj3);

  							  if(commonobj23.size()!=0&&commonsubobj23.size()==0)
  							  {
  								  continue;
  							  }
  							  
  							  
  							 List<String> commonobj34 = new ArrayList<String>(totalObj3);
  							 commonobj34.retainAll(totalObj4);
  							 
  							 List<String> commonsubobj34 = new ArrayList<String>(totalObj3);
  							commonsubobj34.retainAll(totalSubj4);
	    					
	    					
  							/*if(commonobj34.size()!=0&&commonsubobj34.size()==0)
							  {
								  continue;
							  }*/
  							
  							
  							
  							 if(commonsubobj12.size()!=0&&commonsubobj23.size()!=0&&commonsubobj34.size()!=0)
 							  {
 								  System.out.println(pred1);
 								  System.out.println(pred2);
 								  System.out.println(pred3);
 								  System.out.println(pred4);


 								connectionflag = 1;
 								
 								if(markX!=markY){
 									
 									
 									if(!DirectedPathMap3.containsKey(Rpred1+";"+Rpred4))
									{
										List<String> list = new ArrayList<String>();
										list.add(Rpred1+"->"+Rpred2+"->"+Rpred3+"->"+Rpred4);
										DirectedPathMap3.put(Rpred1+";"+Rpred4,list);
									}
									else
									{
										List<String> list = DirectedPathMap3.get(Rpred1+";"+Rpred4);
										if(!list.contains(Rpred1+"->"+Rpred2+"->"+Rpred3+"->"+Rpred4))
										{
											list.add(Rpred1+"->"+Rpred2+"->"+Rpred3+"->"+Rpred4);
										}
										DirectedPathMap3.put(Rpred1+";"+Rpred4,list);
									}
 									
 									
 									if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Directed-Connection-Pattern"))
									  {								  
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];

										  List<String> list = new ArrayList<String>();

										  list.add(domainX+"->"+"dc:"+Rpred1+"->"+domainY);

										  PatternPredicateDomainMap.put(Rpred1+"@"+"Directed-Connection-Pattern", list);

									  }
									  else
									  {
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];
										  
										  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Directed-Connection-Pattern");

										  if(!list.contains(domainX+"->"+"dc:"+Rpred1+"->"+domainY))
										  {
											  list.add(domainX+"->"+"dc:"+Rpred1+"->"+domainY);
										  }
										  
										 
										  PatternPredicateDomainMap.put(Rpred1+"@"+"Directed-Connection-Pattern", list);

									  }
 									
 									
 									if(!PatternPredicateDomainMap.containsKey(Rpred4+"@"+"Directed-Connection-Pattern"))
									  {								  
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];

										  List<String> list = new ArrayList<String>();

										  list.add(domainX+"->"+"dc:"+Rpred4+"->"+domainY);

										  PatternPredicateDomainMap.put(Rpred4+"@"+"Directed-Connection-Pattern", list);

									  }
									  else
									  {
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];
										  
										  List<String> list = PatternPredicateDomainMap.get(Rpred4+"@"+"Directed-Connection-Pattern");

										  if(!list.contains(domainX+"->"+"dc:"+Rpred4+"->"+domainY))
										  {
											  list.add(domainX+"->"+"dc:"+Rpred4+"->"+domainY);
										  }
										  
										 
										  PatternPredicateDomainMap.put(Rpred4+"@"+"Directed-Connection-Pattern", list);

									  }
 									
 								if(!PatternMapUp.containsKey(Rpred1+";"+Rpred4))
  								{
 									PatternMapUp.put(Rpred1+";"+Rpred4,"Directed-Connection-Pattern");
  								}
  								
  								if(!PatternMapUp.containsKey(Rpred4+";"+Rpred1))
  								{
  									PatternMapUp.put(Rpred4+";"+Rpred1,"Directed-Connection-Pattern");
  								}
  								
  							  if(!PredicateDirectedPatternMap.containsKey(Rpred1))
  							  {
  								PredicateDirectedPatternMap.put(Rpred1,1);
  							  }
  							  else
  							  {
  								  int total = PredicateDirectedPatternMap.get(Rpred1);
  								  total = total + 1;
  								PredicateDirectedPatternMap.put(Rpred1,total);
  							  }
  							  
  							if(!PredicateDirectedPatternMap.containsKey(Rpred4))
							  {
								PredicateDirectedPatternMap.put(Rpred4,1);
							  }
							  else
							  {
								  int total = PredicateDirectedPatternMap.get(Rpred4);
								  total = total + 1;
								PredicateDirectedPatternMap.put(Rpred4,total);
							  }
 								}
 								
 							  }
  							
  							 
  							 if(connectionflag==0)
  							 {
  								 if(markX!=markY){
  									 
  									 
  									if(!NonDirectedPathMap3.containsKey(Rpred1+";"+Rpred4))
									{
										List<String> list = new ArrayList<String>();
										list.add(Rpred1+"->"+Rpred2+"->"+Rpred3+"->"+Rpred4);
										NonDirectedPathMap3.put(Rpred1+";"+Rpred4,list);
									}
									else
									{
										List<String> list = NonDirectedPathMap3.get(Rpred1+";"+Rpred4);
										if(!list.contains(Rpred1+"->"+Rpred2+"->"+Rpred3+"->"+Rpred4))
										{
											list.add(Rpred1+"->"+Rpred2+"->"+Rpred3+"->"+Rpred4);
										}
										NonDirectedPathMap3.put(Rpred1+";"+Rpred4,list);
									}
  									 
  									if(!PatternPredicateDomainMap.containsKey(Rpred1+"@"+"Non-Directed-Connection-Pattern"))
									  {								  
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];

										  List<String> list = new ArrayList<String>();

										  list.add(domainX+"->"+"ndc:"+Rpred1+"->"+domainY);

										  PatternPredicateDomainMap.put(Rpred1+"@"+"Non-Directed-Connection-Pattern", list);

									  }
									  else
									  {
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];
										  
										  List<String> list = PatternPredicateDomainMap.get(Rpred1+"@"+"Non-Directed-Connection-Pattern");
										  if(!list.contains(domainX+"->"+"ndc:"+Rpred1+"->"+domainY))
										  {
											  list.add(domainX+"->"+"ndc:"+Rpred1+"->"+domainY);
										  }
										  
										  
										  PatternPredicateDomainMap.put(Rpred1+"@"+"Non-Directed-Connection-Pattern", list);		

									  }
  									
  									if(!PatternPredicateDomainMap.containsKey(Rpred4+"@"+"Non-Directed-Connection-Pattern"))
									  {								  
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];

										  List<String> list = new ArrayList<String>();

										  list.add(domainX+"->"+"ndc:"+Rpred4+"->"+domainY);

										  PatternPredicateDomainMap.put(Rpred4+"@"+"Non-Directed-Connection-Pattern", list);

									  }
									  else
									  {
										  String domainX = Rpred1.split("_vocabulary")[0].split("org.")[1];
										  String domainY = Rpred4.split("_vocabulary")[0].split("org.")[1];
										  
										  List<String> list = PatternPredicateDomainMap.get(Rpred4+"@"+"Non-Directed-Connection-Pattern");
										  if(!list.contains(domainX+"->"+"ndc:"+Rpred4+"->"+domainY))
										  {
											  list.add(domainX+"->"+"ndc:"+Rpred4+"->"+domainY);
										  }
										  
										  
										  PatternPredicateDomainMap.put(Rpred4+"@"+"Non-Directed-Connection-Pattern", list);		

									  }
  									 
  								if(!PatternMapUp.containsKey(Rpred1+";"+Rpred4))
  								{
  									PatternMapUp.put(Rpred1+";"+Rpred4,"Non-Directed-Connection-Pattern");
  								}
  								
  								if(!PatternMapUp.containsKey(Rpred4+";"+Rpred1))
  								{
  									PatternMapUp.put(Rpred4+";"+Rpred1,"Non-Directed-Connection-Pattern");
  								}
  								
  								
  								if(!PredicateNonDirectedPatternMap.containsKey(Rpred1))
    							  {
  									PredicateNonDirectedPatternMap.put(Rpred1,1);
    							  }
    							  else
    							  {
    								  int total = PredicateNonDirectedPatternMap.get(Rpred1);
    								  total = total + 1;
    								  PredicateNonDirectedPatternMap.put(Rpred1,total);
    							  }
  								
  								
  								if(!PredicateNonDirectedPatternMap.containsKey(Rpred4))
    							  {
  									PredicateNonDirectedPatternMap.put(Rpred4,1);
    							  }
    							  else
    							  {
    								  int total = PredicateNonDirectedPatternMap.get(Rpred4);
    								  total = total + 1;
    								  PredicateNonDirectedPatternMap.put(Rpred4,total);
    							  }
  								 }
   								
  							 }
	    					
	    					neighbourListA.clear();
			    			neighbourListB.clear();
			    			neighbourListC.clear();
			    			neighbourListD.clear();
			    			
			    			  List<String> totalSubA = predicateSubjMap.get(pred1);
							  List<String> totalObjA = predicateObjMap.get(pred1);
							//  neighbourListA.addAll(totalSubA);
							//  neighbourListA.addAll(totalObjA);
    							
							  neighbourListA = new ArrayList<String>(totalSubA);
							  neighbourListA.addAll(totalObjA);
								
								Set<String> setList = new LinkedHashSet<String>(neighbourListA);
								neighbourListA.clear();
								neighbourListA.addAll(setList);
    						  
							  
							 							  
	    						//AC = AB*BC
							  List<String> SubB = predicateSubjMap.get(pred2);
    						  List<String> ObjB = predicateObjMap.get(pred2);
    						//  neighbourListB.addAll(SubB);
    						//  neighbourListB.addAll(ObjB);
    						  
    						  
    						  neighbourListB = new ArrayList<String>(SubB);
    						  neighbourListB.addAll(ObjB);
								
								Set<String> setList2 = new LinkedHashSet<String>(neighbourListB);
								neighbourListB.clear();
								neighbourListB.addAll(setList2);
    						  
								
    						  List<String> commonB = new ArrayList<String>(neighbourListA);
    			    		  commonB.retainAll(neighbourListB);
    						  float AB = ((float)commonB.size()/(float)neighbourListA.size())*((float)commonB.size()/(float)neighbourListB.size());
    						//!  float AB = ((float)commonB.size()/((float)neighbourListA.size()+(float)neighbourListB.size()));//jaccard
      						//!  float AB = (2*(float)commonB.size()/((float)neighbourListA.size()+(float)neighbourListB.size()));//Sorensen-Dice coefficient

    						  
    						  List<String> SubC = predicateSubjMap.get(pred3);
    						  List<String> ObjC = predicateObjMap.get(pred3);
    					//	  neighbourListC.addAll(SubC);
    						//  neighbourListC.addAll(ObjC);
    						  
    						  neighbourListC = new ArrayList<String>(SubC);
    						  neighbourListC.addAll(ObjC);
								
								Set<String> setList3 = new LinkedHashSet<String>(neighbourListC);
								neighbourListC.clear();
								neighbourListC.addAll(setList3);
    						  
    						  
    						  List<String> commonC = new ArrayList<String>(neighbourListB);
    			    		  commonC.retainAll(neighbourListC);		    						 		    			    		 
	    					  float BC = ((float)commonC.size()/(float)neighbourListB.size())*((float)commonC.size()/(float)neighbourListC.size());
	    					//! float BC = ((float)commonC.size()/((float)neighbourListB.size()+(float)neighbourListC.size()));//jaccard
	    					 //! float BC = (2*(float)commonC.size()/((float)neighbourListB.size()+(float)neighbourListC.size()));//Sorensen-Dice coefficient

	    					  
	    					  float AC = AB*BC;
	    					  
	    						 //CD
	    						  List<String> SubD = predicateSubjMap.get(pred4);
	    						  List<String> ObjD = predicateObjMap.get(pred4);
	    						//  neighbourListD.addAll(SubD);
	    						//  neighbourListD.addAll(ObjD);
	    						  
	    						  
	    						  neighbourListD = new ArrayList<String>(SubD);
	    						  neighbourListD.addAll(ObjD);
									
									Set<String> setList4 = new LinkedHashSet<String>(neighbourListD);
									neighbourListD.clear();
									neighbourListD.addAll(setList4);
	    						  
	    						  List<String> commonCD = new ArrayList<String>(neighbourListC);
	    						  commonCD.retainAll(neighbourListD);		    						 		    			    		 
		    					  float CD = ((float)commonCD.size()/(float)neighbourListC.size())*((float)commonCD.size()/(float)neighbourListD.size());
		    					//!  float CD = ((float)commonCD.size()/((float)neighbourListC.size()+(float)neighbourListD.size()));//jaccard
		    					 //! float CD = (2*(float)commonCD.size()/((float)neighbourListC.size()+(float)neighbourListD.size()));//Sorensen-Dice coefficient

    					
		    					  //AB already calculated
		    					
		    					  //BD=BC*CD (already calculated)
	    						
		    					  float BD = BC*CD;
	    						 
		    					  
		    					 
		    					  
		    					  if(AC*CD>AB*BD)
	    						  {
	    							  ps3_a = AC*CD;
	    						  }
	    						  else
	    						  {
	    							  ps3_a = AB*BD;
	    						  }
	    					
		    					 if(ps3_a>ps3)
		    					 {
		    						 ps3 = ps3_a;
		    						 finalpred32 = pred2;
		    						 finalpred33 = pred3;
		    					 }
	    					
		    					 float ps3_1 = 0;
		    					 float ps3_2 = 0;
		    					 
		    					
		    					 if(!recordMap3.containsKey(Integer.toString(i)+","+Integer.toString(j)))
		    					  {
		    						 if(recordMap3.containsKey(Integer.toString(j)+","+Integer.toString(i)))
		    						 {
		    							 ps3_2 = recordMap3.get(Integer.toString(j)+","+Integer.toString(i));
		    							 if(ps3<ps3_2)
		    							 {
		    								 ps3 = ps3_2;
		    								 recordMap3.put(Integer.toString(i)+","+Integer.toString(j),ps3);
		    							 }
		    							 else
		    							 {
				    						 recordMap3.put(Integer.toString(i)+","+Integer.toString(j),ps3);  
		    							 }
		    						 }
		    						 else
		    						 {
			    						 recordMap3.put(Integer.toString(i)+","+Integer.toString(j),ps3); 

		    						 }
		    						 
		    					  }
		    					  
		    					 if(cross&&ps3!=0)
		    					 //if(cross)
		    		    		 {
		    		    			int mark1 =  crossdomainMarkMap.get(columnList.get(j));
		    		    			int mark2 =  crossdomainMarkMap.get(columnList.get(i));
		    		    			
		    		    			if(mark1!=mark2)
		    		    			{
		    		    				if(connectionflag==1){
		    		    					if(ps3+weighEnhancePlus3<0.9999){
				    		    				ps3 = ps3+weighEnhancePlus3;
				    		    				}
				    		    				else
				    		    				{
				    		    					ps3 = (float) 0.9999;
				    		    					//ps2 = (float) 10;	
				    		    				}
		    		    				}
		    		    				
		    		    				else{
			    		    				if(ps3+weighEnhance<0.6){
			    		    				ps3 = ps3+weighEnhance;
			    		    				}
			    		    				else
			    		    				{
			    		    					ps3 = (float) 0.6;
			    		    					//ps2 = (float) 10;
			    		    				}
		    		    				}
		    		    			//	System.out.println(columnList.get(j)+","+columnList.get(i)+":"+ps3);

		    		    			}

		    		    		 }
		    					 
		    					 
		    					/* 	System.out.println(i+","+j);
		    						System.out.println(columnList.get(i)+columnList.get(j));
		    						System.out.println("^^^^^^"+ps3);*/
	    					
	    					/*String pred1 = nNode1.getName();
	    					String pred2 = nNode2.getName();
	    					String pred3 = nNode3.getName();*/

	    				//	System.out.println(pred1+"->"+pred2+"->"+pred3+"->"+pred4);
	    					/*if(item < (sers.get(u).length - 1)){
	    						
	    						System.out.print(nNode.getName() + "->");
	    					}
	    					else{
	    						
	    						System.out.print(nNode.getName());
	    					}*/
	    				
	    			//	}
	    				
	    			//	System.out.println();
	    			
	    			}

	    			
	    			
	    			if(!thirdConnectionMap.containsKey(finalpred31+":"+finalpred34)){
						List<String> predList = new ArrayList<String>();
						predList.add(finalpred32);
						predList.add(finalpred33);
						thirdConnectionMap.put(finalpred31+":"+finalpred34,predList);
					}
					else
					{
						List<String> predList = thirdConnectionMap.get(finalpred31+":"+finalpred34);
						if(!predList.contains(finalpred32))
						{
							predList.add(finalpred32);
						}
						if(!predList.contains(finalpred33))
						{
							predList.add(finalpred33);
						}
						thirdConnectionMap.put(finalpred31+":"+finalpred34,predList);
					}
					
					
					if(!thirdConnectionMap.containsKey(finalpred34+":"+finalpred31)){
						List<String> predList = new ArrayList<String>();
						predList.add(finalpred32);
						predList.add(finalpred33);
						thirdConnectionMap.put(finalpred34+":"+finalpred31,predList);
					}
					else
					{
						List<String> predList = thirdConnectionMap.get(finalpred34+":"+finalpred31);
						if(!predList.contains(finalpred32))
						{
							predList.add(finalpred32);
						}
						if(!predList.contains(finalpred33))
						{
							predList.add(finalpred33);
						}
						thirdConnectionMap.put(finalpred34+":"+finalpred31,predList);
					}
	    			
	    			
	    			
	    			
		    			}	
		    			
		    			long m2 = System.currentTimeMillis();
		    			
		    			
		    			if(ps!=0)
		    			{
		    			//	psfinal =(float) Math.pow((1-ps),2);
		    				psfinal = (float)(1-ps);
		    			//	psfinal = (float)ps;
		    				
		    			}
		    		else
		    			{
		    				if(ps2!=0)
		    				{
		    					//psfinal = (float) Math.pow((1-ps2),2);
		    					psfinal = (float)(1-ps2);
		    				
		    					//psfinal = (float)ps2;
		    				}
		    						else
		    				{
		    					if(ps3!=0)
		    					{
		    					//	psfinal=(float)Math.pow((1-ps3),2);
		    					//!	psfinal = (float)(1-ps3);
		    					//	psfinal=psfinal+1000;
		    						//psfinal = (float)ps3;
		    						psfinal = (float)(1-ps3);

		    						
		    						
		    					//!	psfinal = (float)(1-ps3+0.1);//radius 4
		    					//!	psfinal = (float)(1-ps3+0.3);//radius 5
		    						
		    					if(psfinal>1)
		    						{
		    							psfinal=1;
		    						}
		    					}
		    					
		    					
		    				}
		    			}
		    			
		    			
		    	    // ps = ps;
		    				
		    			
		    			if(psfinal==0)
		    			{
		    				psfinal=1;
		    			}
		    			
	    	    		matrixProbSim[i][j]=psfinal;
	    	    		name = name + "\t"+ psfinal;
	    	    		name2 = name2+psfinal+"\t";
		    	    
		    		  csvMatrix3[i+1][j] =Float.toString(psfinal); //// add by 7/18/2014		    						  
				  }
				  
				  System.out.println(name);
				
				  
			  }
			  
			  
			
		/*	  for(int i=1;i<csvMatrix3.length;i++)
			  {
				  for(int j=0;j<csvMatrix3.length-1;j++)
				  {
					  String element = csvMatrix3[i][j];
					  DoubleMatrix2D elementFloat = Float.parseFloat(element);
					  csvMatrix4[i][j]= elementFloat;
				  }
			  }
			  
			  
	          FCMTest fcmt = new FCMTest();
	          fcmt.cluster(csvMatrix4, 3);*/
			 
			 
			  writeCsv2(csvMatrix3,"NeiborCSV/neighborCsv3.csv");
			//!  writeCsv2(csvMatrix3,"/home/user/NeiborCSV/neighborCsv3.csv");
			
			  long end3 = System.currentTimeMillis();
			 
			 System.out.println("It takes " + (end3-start0) + " ms to finish neighbour matrix");
		  
			 csvToXLSX("NeiborCSV/neighborCsv3.csv","NeiborCSV/neighborCsv3.xlsx");
		  
		//!	 csvToXLSX("/home/user/NeiborCSV/neighborCsv3.csv","/home/user/NeiborCSV/neighborCsv3.xls");
			  
		  /*
			 System.out.println(secondmap.size());
			 
			 System.out.println(secondmap);
		  
			 System.out.println(thirdmap.size());
			 
			 System.out.println(thirdmap);
		  */
		  
		  
		  
		  
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
		 
			 double[][] finalmatrix = new double[csvMatrix3.length-1][csvMatrix3.length-1];
			 
		//	 System.out.println("csvMatrix3[0][1]:"+csvMatrix3[0][1]);
		//	 System.out.println("csvMatrix3[1][0]:"+csvMatrix3[1][0]);
		//	 System.out.println("csvMatrix3[1][1]:"+csvMatrix3[2][0]);

			 
			 for(int i = 1; i < csvMatrix3.length; i++)
			 {
				 for(int j=0;j<csvMatrix3.length-1;j++){
					 
				//	 System.out.println(i+":"+j+"***"+csvMatrix3[i][j]);
			     finalmatrix[i-1][j]= Double.parseDouble(csvMatrix3[i][j]);
				 }
			 }	 
			 
			 
				double matrixbuilderendtime = System.currentTimeMillis();
				
				double matrixBuildtime = matrixbuilderendtime - matrixbuilderstarttime;
				System.out.println("matrix building time: "+matrixBuildtime);
			
			 
		 return finalmatrix;
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
		
	}
	
	
	public  void prepareLUBMOutDegreeMatrixData(List<String> listnames)
	{		
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
			    		// System.out.println(predicatename+"	"+realIndegreeList.size());
				}
				else
				{
					predicatename = key;
					// System.out.println(predicatename+"	"+realIndegreeList.size());
				}
		}
		
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
		        XSSFWorkbook workBook = new XSSFWorkbook();
		        XSSFSheet sheet = workBook.createSheet("sheet1");
		        String currentLine=null;
		        int RowNum=-1;
		        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
		        while ((currentLine = br.readLine()) != null) {
		            Object str[] = currentLine.split(",");
		            RowNum++;
		            Row currentRow=sheet.createRow(RowNum);
		            for(int i=0;i<str.length;i++){
		            	if(!str[i].equals("")||str[i]!=null){
		            		if(str[i] instanceof String)
		            		{
		            			 currentRow.createCell(i).setCellValue((String)str[i]);
		            		}
		            		else if(str[i] instanceof Double)
		            		{
		            			 currentRow.createCell(i).setCellValue((Double)str[i]);
		            		}
		               
		            	}
		            //	System.out.println("++++++++"+currentRow.getCell(i));
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
	
	 
		

		public static SortedMap<String,List<String>> getPathsfor2ndTest(int cNode,int eNode)
		{
			int nNode = 0;
			for(int i=0;i<listOfLists.get(cNode).size();i++){
			     nNode = listOfLists.get(cNode).get(i);
			     if(nNode!=-1){
			     if(listOfLists.get(nNode).contains(eNode))
			     {
			    	// System.out.println(cNode+"->"+nNode+"->"+eNode);
			    	 
			    	 if(!secondList.contains(cNode+"->"+nNode+"->"+eNode))
			    		 secondList.add(cNode+"->"+nNode+"->"+eNode);
			    
			    	 if(!secondmap.containsKey(Integer.toString(cNode)+";"+Integer.toString(eNode)))
			    	 {
			    		 List<String> middlelist = new ArrayList<String>();
			    		 middlelist.add(Integer.toString(nNode));
			    		 secondmap.put(Integer.toString(cNode)+";"+Integer.toString(eNode), middlelist);
			    	 }
			    	 else
			    	 {
			    		 List<String> middlelist  = secondmap.get(Integer.toString(cNode)+";"+Integer.toString(eNode));
			    		 if(!middlelist.contains(Integer.toString(nNode)))
			    		 {
			    			 middlelist.add(Integer.toString(nNode));
			    		 }
			    		 secondmap.put(Integer.toString(cNode)+";"+Integer.toString(eNode), middlelist);

			    	 }
			    	 
			    	 
			    	 if(!secondmap.containsKey(Integer.toString(eNode)+";"+Integer.toString(cNode)))
			    	 {
			    		 List<String> middlelist = new ArrayList<String>();
			    		 middlelist.add(Integer.toString(nNode));
			    		 secondmap.put(Integer.toString(eNode)+";"+Integer.toString(cNode), middlelist);
			    	 }
			    	 else
			    	 {
			    		 List<String> middlelist  = secondmap.get(Integer.toString(eNode)+";"+Integer.toString(cNode));
			    		 if(!middlelist.contains(Integer.toString(nNode)))
			    		 {
			    			 middlelist.add(Integer.toString(nNode));
			    		 }
			    		 secondmap.put(Integer.toString(eNode)+";"+Integer.toString(cNode), middlelist);

			    	 }
			     }
			     }
			}
			
			return secondmap;
		}
		
		
		public static SortedMap<String,List<String>> getPathsfor3rdTest(int cNode, int eNode)
		{
			int nNode = 0;
			for(int i=0;i<listOfLists.get(cNode).size();i++){
			     nNode = listOfLists.get(cNode).get(i);
			     if(nNode!=-1){
			     for(int j=0;j<listOfLists.get(nNode).size();j++)
			     {
			    	 int xNode = listOfLists.get(nNode).get(j);
			    	     if(xNode!=-1){
					     if(listOfLists.get(xNode).contains(eNode))
					     {
					    	// System.out.println(cNode+"->"+nNode+"->"+xNode+"->"+eNode);
					    	
					    	 if(!thirdList.contains(cNode+"->"+nNode+"->"+xNode+"->"+eNode))
					    		 thirdList.add(cNode+"->"+nNode+"->"+xNode+"->"+eNode);
					    	 
					    	 
					    	 
					    	 if(!thirdmap.containsKey(Integer.toString(cNode)+";"+Integer.toString(eNode)))
					    	 {
					    		 List<String> middlelist = new ArrayList<String>();
					    		 middlelist.add(Integer.toString(nNode)+";"+Integer.toString(xNode));
					    		 thirdmap.put(Integer.toString(cNode)+";"+Integer.toString(eNode), middlelist);
					    	 }
					    	 else
					    	 {
					    		 List<String> middlelist  = thirdmap.get(Integer.toString(cNode)+";"+Integer.toString(eNode));
					    		 if(!middlelist.contains(Integer.toString(nNode)+";"+Integer.toString(xNode)))
					    		 {
					    			 middlelist.add(Integer.toString(nNode)+";"+Integer.toString(xNode));
					    		 }
					    		 thirdmap.put(Integer.toString(cNode)+";"+Integer.toString(eNode), middlelist);

					    	 }
					    	 
					    	 
					    	 if(!thirdmap.containsKey(Integer.toString(eNode)+";"+Integer.toString(cNode)))
					    	 {
					    		 List<String> middlelist = new ArrayList<String>();
					    		 middlelist.add(Integer.toString(xNode)+";"+Integer.toString(nNode));
					    		 thirdmap.put(Integer.toString(eNode)+";"+Integer.toString(cNode), middlelist);
					    	 }
					    	 else
					    	 {
					    		 List<String> middlelist  = thirdmap.get(Integer.toString(eNode)+";"+Integer.toString(cNode));
					    		 if(!middlelist.contains(Integer.toString(xNode)+";"+Integer.toString(nNode)))
					    		 {
					    			 middlelist.add(Integer.toString(xNode)+";"+Integer.toString(nNode));
					    		 }
					    		 thirdmap.put(Integer.toString(eNode)+";"+Integer.toString(cNode), middlelist);

					    	 }
					     }
			    	     }
			}
			}
			}
		
		return thirdmap;
		}
		
		
		
		public SortedMap<String, List<String>> getsecondConnectionMap()
		{
			return secondConnectionMap;
		}
	
		public SortedMap<String, List<String>> getthirdConnectionMap()
		{
			return thirdConnectionMap;
		}
		
		public String mapPredicateToRformat (String p)
		{
			String predicate = p;
			 String newpredicate="";
	          String newpredicate1="";
	          String newpredicate2="";
	          String newpredicate4="";
	          String newpredicate3 ="";

	           if(predicate.contains(":")){
				 newpredicate = predicate.replaceAll(":", ".");
	           }
	           else
	           {
	        	   newpredicate =   predicate;
	           }
	           
	           if(newpredicate.contains("/")){
				 newpredicate1 = newpredicate.replaceAll("/", ".");
	           }
	           else
	           {
	        	   newpredicate1 = newpredicate;   
	           }
	           
	           if(newpredicate1.contains("#")){
				 newpredicate2 = newpredicate1.replaceAll("#", ".");
	           }
	           else
	           {
	        	   newpredicate2 = newpredicate1;  
	           }
	           
	           if(newpredicate2.contains("-")){
				 newpredicate4 = newpredicate2.replaceAll("-", ".");
	           }
	           else
	           {
	        	   newpredicate4 =  newpredicate2;
	           }
	           
	           if(newpredicate4.contains("~")){
	        	   newpredicate3 = newpredicate4.replaceAll("~", ".");
   	           }
	           else
	           {
	        	   newpredicate3 = newpredicate4;
	           }
		
	           return newpredicate3;
		}
		
		
		public String maptoConcept(String concept,SortedMap<String,String> siomap)
		{
			if(concept.contains("http://bio2rdf.org/drugbank_vocabulary:")){
    			concept="dv:"+concept.split(":")[2];
    			}
    			if(concept.contains("http://bio2rdf.org/ahfs_vocabulary:")){
	    			concept="ahv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/kegg_vocabulary:")){
	    			concept="kv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/atc_vocabulary:")){
	    			concept="av:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/bindingdb_vocabulary:")){
	    			concept="bv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/pubchem.compound_vocabulary:")){
	    			concept="pcv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/chemspider_vocabulary:")){
	    			concept="cv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/pdb_vocabulary:")){
	    			concept="pdv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/pubchem.substance_vocabulary:")){
	    			concept="psv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/dpd_vocabulary:")){
	    			concept="dpv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/pubmed_vocabulary:")){
	    			concept="pv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/genbank_vocabulary:")){
	    			concept="gv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/uspto_vocabulary:")){
	    			concept="uv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/genatlas_vocabulary:")){
	    			concept="gav:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/chebi_vocabulary:")){
	    			concept="chv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/genecards_vocabulary:")){
	    			concept="gcv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/ndc_vocabulary:")){
	    			concept="nv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/gi_vocabulary:")){
	    			concept="giv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/pharmgkb_vocabulary:")){
	    			concept="phv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/gtp_vocabulary:")){
	    			concept="gtv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/uniprot_vocabulary:")){
	    			concept="unv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/hgnc_vocabulary:")){
	    			concept="hv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/wikipedia_vocabulary:")){
	    			concept="wv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/iuphar_vocabulary:")){
	    			concept="iv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/mgi_vocabulary:")){
	    			concept="mgv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/mp_vocabulary:")){
	    			concept="mpv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/hgnc.symbol_vocabulary:")){
	    			concept="hsv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/refseq_vocabulary:")){
	    			concept="refv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/ncbigene_vocabulary:")){
	    			concept="ncbiv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/omim_vocabulary:")){
	    			concept="omimv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/ccds_vocabulary:")){
	    			concept="ccdsv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/vega_vocabulary:")){
	    			concept="vegav:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/ucsc_vocabulary:")){
	    			concept="ucscv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/rgd_vocabulary:")){
	    			concept="rgdv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/ensembl_vocabulary:")){
	    			concept="ensev:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/trembl_vocabulary:")){
	    			concept="tremv:"+concept.split(":")[2];
	    			}
    			if(concept.contains("http://bio2rdf.org/clinicaltrials_vocabulary:")){
	    			concept="clinv:"+concept.split(":")[2];
	    			}
    			else{
    				
    				
    				if(concept.contains("_vocabulary"))
					{
						String mapname = concept.split("_vocabulary")[0].split("\\/")[3]+"v:";
						
						String conceptname = concept.split(":")[2];
						
						concept = mapname+conceptname;
					}
    				
    			}
    			
    			if(concept.contains("SIO_"))
				{
					if(siomap.containsKey(concept)){
		    		
						String realname = siomap.get(concept);
						realname = Character.toUpperCase(realname.charAt(0)) + realname.substring(1);
						concept = "SIO_"+concept.split("SIO_")[1]+":"+realname;
					}
				}
    			
    			return concept;
    			
		}
		
		public SortedMap<String,List<String>> getSecondMap()
		{
			return secondmap;
		}
		
		public SortedMap<String,List<String>> getThirdMap()
		{
			return thirdmap;
		}
		
		public SortedMap<String,String> getPatternMapUp()
		{
			return PatternMapUp;
		}
		
		public SortedMap<String,List<String>> getPatternMapLevel1()
		{
			return PatternMapL1;
		}
		
		public SortedMap<String,Integer> getPredicateReachPattern()
		{
			return PredicateReachPatternMap;
		}
		
		public SortedMap<String,Integer> getPredicateConsumerPattern()
		{
			return PredicateConsumerPatternMap;
		}
		
		public SortedMap<String,Integer> getPredicateProviderPattern()
		{
			return PredicateProviderPatternMap;
		}
		
		public SortedMap<String,Integer> getPredicateNonDirectionPattern()
		{
			return PredicateNonDirectedPatternMap;
		}
		
		public SortedMap<String,Integer> getPredicateDirectionPattern()
		{
			return PredicateDirectedPatternMap;
		}
		
		
		public SortedMap<String,List<String>> getPatternPredicateDomainMap()
		{
			return PatternPredicateDomainMap;
		}
		
		public List<String> getSecondList()
		{
			return secondList;
		}
		
		public List<String> getThirdList()
		{
			return thirdList;
		}
		
		public SortedMap<String,String> getpCrossdomainMap()
		{
			return pCrossdomainMap;
		}
		
		public SortedMap<Integer,String> getnameNumMapReverse()
		{
			return nameNumMapReverse;
		}
		
		public List<String> getfirstTriple()
		{
			return level1triple;
		}
		
		public List<String> getsecondTriple()
		{
			return secondTriple;
		}
		
		public List<String> getstoreList()
		{
			return totalTriple;
		}
		
		public SortedMap<String,List<String>> getDirectedPathMap()
		{
			return DirectedPathMap;
		}
		
		public SortedMap<String,List<String>> getNonDirectedPathMap()
		{
			return NonDirectedPathMap;
		}
		
		public SortedMap<String,List<String>> getDirectedPathMap3()
		{
			return DirectedPathMap3;
		}
		
		public SortedMap<String,List<String>> getNonDirectedPathMap3()
		{
			return NonDirectedPathMap3;
		}
		
		public List<String> gettotalPredicateList()
		{
			return totalPredicateList;
		}
		
		public List<String> gettotalConceptList()
		{
			return totalConceptList;
		}
		
		
		public SortedMap<String,String> getsiomap(String dir)
		{
			SortedMap<String,String> siomap = new TreeMap<String,String>();
			BufferedReader br = null;

			try {

				String sCurrentLine;

				br = new BufferedReader(new FileReader(dir));
//"F:/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/CrossDomain-PLOS-Submission-2015/sio-release.nt
				

				while ((sCurrentLine = br.readLine()) != null) {
					
				
				if(sCurrentLine.contains("<"))
					{
						String subject = sCurrentLine.split(" ")[0];
						String predicate = sCurrentLine.split(" ")[1];
						String object = sCurrentLine.split(" ")[2];
						
						if(subject.contains("<")){
						subject = subject.split("<")[1].split(">")[0];
						}
						
					 if(predicate.contains("#label")){

						 if(object.contains("en"))
						 {
							 String newobject = object.split("\"")[1].split("\"")[0].toLowerCase().trim();
							 
							 if(!siomap.containsKey(newobject))
							{
								siomap.put(subject,newobject);
								
								
							}
						 }
						
						}
					}
					//System.out.println(sCurrentLine);
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
			return siomap;
		}
		
		
		
		public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map )
		{
		List<Map.Entry<K, V>> list = new LinkedList<>( map.entrySet() );
		Collections.sort( list, new Comparator<Map.Entry<K, V>>()
		{
		    @Override
		    public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
		    {
		        return (o1.getValue()).compareTo( o2.getValue() );
		    }
		} );

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list)
		{
		    result.put( entry.getKey(), entry.getValue() );
		}
		return result;
		}	
		
		
		public SortedMap<String,List<String>> getneighbourMap()
		{
			return neighbourMap;
		}
		
		public SortedMap<String,List<String>> getneighbourMap2()
		{
			return neighbourMap2nd;
		}
		
		public SortedMap<String,List<String>> getneighbourMap3()
		{
			return neighbourMap3rd;
		}
		
				 
		 public SortedMap<String,Integer> getnamenummap()
		 {
			 return nameNumMap;
		 }
		 
		 public SortedMap<Integer,String> getnamenumreversemap()
		 {
			 return nameNumMapReverse;
		 }
		 
		 public SortedMap<String,Integer> getnameAliasnummap()
		 {
			 return nameAliasNumMap;
		 }
		 
		 public SortedMap<Integer,String> getnameAliasnumreversemap()
		 {
			 return nameAliasNumMapReverse;
		 }
		 
		 public List<String> gettotalList()
		 {
			 return totalList;
		 }
		 
		 public SortedMap<String,String> getaliasrealmap()
		 {
			 return aliasrealmap;
		 }
		 
		 public SortedMap<String,List<String>> getpredicateObjMapAlias()
		 {
			 return predicateObjMapAlias;
		 }
		 
		 public SortedMap<String,List<String>> getpredicateSubjMapAlias()
		 {
			 return predicateSubjMapAlias;
		 }
		 
		 
		 
		 
}

