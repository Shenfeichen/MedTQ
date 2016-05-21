package HFCM;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import OntologyParsePredicate.NTripleMatrixBuilder2;

import org.apache.commons.io.FileUtils;

public class HFCMClusterEntity2{
	

	private static final Logger log = Logger.getLogger( HFCMCluster.class.getName() );
	
		    static String path = "";
		    
		    int levelSelect;
		    
		    int DBSelect;
		    
		    int clusteringThreshold = 0;
		    int clusteringThreshold2 = 0;
		    
		    SortedMap<String, ArrayList<String>> tripleMap = new TreeMap<String, ArrayList<String>>();
		    
		    ArrayList<String> ScuiList = new ArrayList<String>();
		    ArrayList<String> IdList = new ArrayList<String>();
		    ArrayList<String> OcuiList = new ArrayList<String>();
		    
		    static String path2="out.csv";
		    
		 //!  double hfcmthreshold = 0.2;//Yago entity based


			  double hfcmthreshold = 0.4;//13 domain entity based
			//!   double hfcmthreshold = 0.178;//DBpedia entity based

		  //!  double hfcmthreshold = 0.40;//Yago
		 //!   double hfcmthreshold = 0.49;//DBpedia
		    
		  //!  double hfcmthreshold = 0.45; //JBS paper
		    
		//!    double hfcmthreshold = 0.38; //AMIA II paper
		    
		//!    double hfcmthreshold = 0.05; //AMIA I paper
		    
		    static String path_1="outCSV/out1.csv";
		    static String path_2="outCSV/out2.csv";
		    static String path_3="outCSV/out3.csv";
		    static String path_4="outCSV/out4.csv";
		    static String path_5="outCSV/out5.csv";
		    static String path_6="outCSV/out6.csv";
		    static String path_7="outCSV/out7.csv";
		    static String path_8="outCSV/out8.csv";
		    static String path_9="outCSV/out9.csv";
		    static String path_10="outCSV/out10.csv";
		    static String path_11="outCSV/out11.csv";
		    static String path_12="outCSV/out12.csv";
		    static String path_13="outCSV/out13.csv";
		    static String path_14="outCSV/out14.csv";
		    static String path_15="outCSV/out15.csv";
		    static String path_16="outCSV/out16.csv";
		    static String path_17="outCSV/out17.csv";
		    static String path_18="outCSV/out18.csv";
		    static String path_19="outCSV/out19.csv";
		    static String path_20="outCSV/out20.csv";
		    static String path_21="outCSV/out21.csv";
		    static String path_22="outCSV/out22.csv";
		    static String path_23="outCSV/out23.csv";
		    static String path_24="outCSV/out24.csv";
		    static String path_25="outCSV/out25.csv";
		    static String path_26="outCSV/out26.csv";
		    static String path_27="outCSV/out27.csv";
		    static String path_28="outCSV/out28.csv";
		    static String path_29="outCSV/out29.csv";
		    static String path_30="outCSV/out30.csv";
		    static String path_31="outCSV/out31.csv";
		    static String path_32="outCSV/out32.csv";
		    static String path_33="outCSV/out33.csv";
		    static String path_34="outCSV/out34.csv";
		    static String path_35="outCSV/out35.csv";
		    static String path_36="outCSV/out36.csv";
		    static String path_37="outCSV/out37.csv";
		    static String path_38="outCSV/out38.csv";
		    static String path_39="outCSV/out39.csv";
		    static String path_40="outCSV/out40.csv";
		    static String path_41="/outCSV/out41.csv";
		    static String path_42="/outCSV/out42.csv";
		    static String path_43="/outCSV/out43.csv";
		    static String path_44="E:/outCSV/out44.csv";
		    static String path_45="E:/outCSV/out45.csv";
		    static String path_46="E:/outCSV/out46.csv";
		    static String path_47="E:/outCSV/out47.csv";
		    static String path_48="E:/outCSV/out48.csv";
		    static String path_49="E:/outCSV/out49.csv";
		    static String path_50="E:/outCSV/out50.csv";
		    static String path_51="E:/outCSV/out51.csv";
		    static String path_52="E:/outCSV/out52.csv";
		    static String path_53="E:/outCSV/out53.csv";
		    static String path_54="E:/outCSV/out54.csv";
		    static String path_55="E:/outCSV/out55.csv";
		    static String path_56="E:/outCSV/out56.csv";
		    static String path_57="E:/outCSV/out57.csv";
		    static String path_58="E:/outCSV/out58.csv";
		    static String path_59="E:/outCSV/out59.csv";
		    static String path_60="E:/outCSV/out60.csv";
		    static String path_61="E:/outCSV/out61.csv";
		    static String path_62="E:/outCSV/out62.csv";
		    static String path_63="E:/outCSV/out63.csv";
		    static String path_64="E:/outCSV/out64.csv";
		    static String path_65="E:/outCSV/out65.csv";
		    static String path_66="E:/outCSV/out66.csv";
		    static String path_67="E:/outCSV/out67.csv";
		    static String path_68="E:/outCSV/out68.csv";
		    static String path_69="E:/outCSV/out69.csv";
		    static String path_70="E:/outCSV/out70.csv";
		    static String path_71="E:/outCSV/out71.csv";
		    static String path_72="E:/outCSV/out72.csv";
		    
		    
		    
		    static ArrayList<String> csvList = new ArrayList<String>();
		    
		    static ArrayList<String> runningList = new ArrayList<String>();
		    
			/*private final CyNetworkFactory cnf;
			private final CyNetworkViewFactory cnvf;
			private final CyNetworkViewManager networkViewManager;
			private final CyNetworkManager networkManager;
			private final CyNetworkNaming cyNetworkNaming;*/

	//!	    static SortedMap<String,List<String>> membershipMap = new TreeMap<String,List<String>>();
	//!	    static SortedMap<String,List<String>> FuzzyMap = new TreeMap<String,List<String>>();
		    

	//!	    static SortedMap<String,List<String>> membershipMap2 = new TreeMap<String,List<String>>();
	//!	    static SortedMap<String,List<String>> FuzzyMap2 = new TreeMap<String,List<String>>();
		    

	//!	    static SortedMap<String,List<String>> membershipMap3 = new TreeMap<String,List<String>>();
	//!	    static SortedMap<String,List<String>> FuzzyMap3 = new TreeMap<String,List<String>>();
		    
		    static double membershipthreshold = 0.3;
		    
		   static  SortedMap<String,Integer> sumDegreeMap = new TreeMap<String,Integer>();
		   
		   static SortedMap<String,List<String>> neighbourMap1st = new TreeMap<String,List<String>>(); 

		   static SortedMap<String,List<String>> neighbourMap2nd = new TreeMap<String,List<String>>(); 
		   static SortedMap<String,List<String>> neighbourMap3rd = new TreeMap<String,List<String>>(); 
		   
		   static SortedMap<String,List<String>> predicateObjMap = new TreeMap<String,List<String>>(); 
		   static SortedMap<String,List<String>> predicateSubjMap = new TreeMap<String,List<String>>(); 
		   
		   static SortedMap<String,Integer> nameNumMap = new TreeMap<String,Integer>(); 
		   static SortedMap<Integer,String> nameNumMapReverse = new TreeMap<Integer,String>(); 
		   
		   static List<List<Entry<Integer,Double>>> simList = new ArrayList<List<Entry<Integer,Double>>>(); 
		   
		   
		   static SortedMap<String,List<String>> subobjMap = new TreeMap<String,List<String>>();
		   
			static SortedMap<String,List<String>> secondmap = new TreeMap<String,List<String>>();
			static SortedMap<String,List<String>> thirdmap = new TreeMap<String,List<String>>();

			static int clusterLevel2=0;
			static int cluster=0;
			
			static SortedMap<String, String> varMap0 = new TreeMap<String,String>();
			SortedMap<String, String> varMap = new TreeMap<String,String>();
			
			
			Queue<String> q = new LinkedList<String>();
			
			
		/*	 List<String >writeRecord = new ArrayList<String>();
    		 List<String >writeRecord2 = new ArrayList<String>();
    		 List<String >writeRecord3 = new ArrayList<String>();*/
			
			
		    public void hfcm()
		    {
		    	
		       double starttime = System.currentTimeMillis();
		       final LinkedHashMap<String,List<String>> level1Map = new LinkedHashMap<String,List<String>>();
		       final LinkedHashMap<String,List<String>> level2Map = new LinkedHashMap<String,List<String>>();
		       final LinkedHashMap<String,List<String>> level3Map = new LinkedHashMap<String,List<String>>();

		       final LinkedHashMap<String,List<String>> level2Map2 = new LinkedHashMap<String,List<String>>();

		       final LinkedHashMap<String,List<String>> levelMap = new LinkedHashMap<String,List<String>>();
		       final LinkedHashMap<String,String> levelMapCheck = new LinkedHashMap<String,String>();
		       
		       
		       final LinkedHashMap<String,String> level1MapCheck = new LinkedHashMap<String,String>();
		       
		       final LinkedHashMap<String,String> level2MapCheck = new LinkedHashMap<String,String>();
		       
		       final LinkedHashMap<String,String> level3MapCheck = new LinkedHashMap<String,String>();
		  
		       
		       
		       File file2 = new File("NeiborCSV/neighborCsv3_entity.csv");
	    		String line = "";
	    		String cvsSplitBy = ",";
	    		int count=0;
	    		
	    		BufferedReader br0 = null;
	    		try {
					br0 = new BufferedReader(new FileReader(file2));
				
	    		while ((line = br0.readLine()) != null) {
	    			
	    			if(line.contains("http")||line.contains(":"))
	    			{
	    				continue;
	    			}
	    			
	    			String[] arr = line.split(cvsSplitBy);
	    			SortedMap<Integer,Double> map = new TreeMap<Integer,Double>();
	     
	    			for(int a=0;a<arr.length;a++)
	    			{
	    				
	    				if(!map.containsKey(a))
	    				{
	    					if(Double.parseDouble(arr[a])!=0&&Double.parseDouble(arr[a])!=1)
	    					map.put(a, Double.parseDouble(arr[a]));
	    				}
	    			}
	    			
	    			List<Entry<Integer,Double>> sortedmap = entriesSortedByValues(map);
	    			simList.add(count,sortedmap);
	    			
	    			count=count+1;
	     
	    		}
	    		
	    		br0.close();
	    		} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
	    	
	    		for(int s=0;s<simList.size();s++)
	    		{
	    			//System.out.println(s+":"+simList.get(s));
	    		}
	    		
	    		
		       
		        
			    if (!Rengine.versionCheck()) {
					 System.out.println("** Version mismatch - Java files don't match library version.");
					   
					}
				 
				 //JOptionPane.showMessageDialog(null, "Creating Rengine (with arguments)");
						
			    Rengine re = new Rengine(new String[] { "--no-save" }, false, new TextConsole5());
			    
				 // Rengine re=new Rengine(null,false, new TextConsole());
						
					//	 JOptionPane.showMessageDialog(null, "Rengine created, waiting for R");	
						// the engine creates R is a new thread, so we should wait until it's ready
				        if (!re.waitForR()) {
							 System.out.println("Cannot load R");	 
				        }


			    	level1Map.clear();
			    	level2Map.clear();
			    	level3Map.clear();
			    //	FuzzyMap.clear();	
			    //	membershipMap.clear();
			   // 	FuzzyMap2.clear();	
			   // 	membershipMap2.clear();
			   // 	FuzzyMap3.clear();	
			   // 	membershipMap3.clear();
			    	runningList.clear();
			    	level1MapCheck.clear();
			    	level2MapCheck.clear();
			    	level3MapCheck.clear();
			    	csvList.clear();
			    	level2Map2.clear();
				     
			    	
			    		csvList.add(path_1);
				    	csvList.add(path_2);
				    	csvList.add(path_3);
				    	csvList.add(path_4);
				    	csvList.add(path_5);
				    	csvList.add(path_6);
				    	csvList.add(path_7);
				    	csvList.add(path_8);
				    	csvList.add(path_9);
				    	csvList.add(path_10);
				    	csvList.add(path_11);
				    	csvList.add(path_12);
				    	csvList.add(path_13);
				    	csvList.add(path_14);
				    	csvList.add(path_15);
				    	csvList.add(path_16);
				    	csvList.add(path_17);
				    	csvList.add(path_18);
				    	csvList.add(path_19);
				    	csvList.add(path_20);
				    	csvList.add(path_21);
				    	csvList.add(path_22);
				    	csvList.add(path_23);
				    	csvList.add(path_24);
				    	csvList.add(path_25);
				    	csvList.add(path_26);
				    	csvList.add(path_27);
				    	csvList.add(path_28);
				    	csvList.add(path_29);
				    	csvList.add(path_30);
				    	csvList.add(path_31);
				    	csvList.add(path_32);
				    	csvList.add(path_33);
				    	csvList.add(path_34);
				    	csvList.add(path_35);
				    	csvList.add(path_36);
				    	csvList.add(path_37);
				    	csvList.add(path_38);
				    	csvList.add(path_39);
				    	csvList.add(path_40);
				    	csvList.add(path_41);
				    	csvList.add(path_42);
				    	csvList.add(path_43);
				    	csvList.add(path_44);
				    	csvList.add(path_45);
				    	csvList.add(path_46);
				    	csvList.add(path_47);
				    	csvList.add(path_48);
				    	csvList.add(path_49);
				    	csvList.add(path_50);
				    	csvList.add(path_51);
				    	csvList.add(path_52);
				    	csvList.add(path_53);
				    	csvList.add(path_54);
				    	csvList.add(path_55);
				    	csvList.add(path_56);
				    	csvList.add(path_57);
				    	csvList.add(path_58);
				    	csvList.add(path_59);
				    	csvList.add(path_60);
				    	csvList.add(path_61);
				    	csvList.add(path_62);
				    	csvList.add(path_63);
				    	csvList.add(path_64);
				    	csvList.add(path_65);
				    	csvList.add(path_66);
			    		
				       int levelnum = 1;
				    	
			    	   int level1=1;
			  	       int level2=1;
			  	       int level3=1;
			    		
			    		
			    		ArrayList<String> clusterList = new ArrayList<String>();
			    		ArrayList<String> clusterList2 = new ArrayList<String>();
			    		ArrayList<String> clusterList3 = new ArrayList<String>();
			    		ArrayList<String> clusterListTemp = new ArrayList<String>();

			    		
			    	    SortedMap<String,ArrayList<String>> clusterMap = new TreeMap<String,ArrayList<String>>(); 
			    	    SortedMap<String,ArrayList<String>> clusterMap2 = new TreeMap<String,ArrayList<String>>(); 
			    	    SortedMap<String,ArrayList<String>> clusterMap3 = new TreeMap<String,ArrayList<String>>(); 
			    	    SortedMap<String,ArrayList<String>> clusterMap4 = new TreeMap<String,ArrayList<String>>(); 
			    	    
			    		SortedMap<String,ArrayList<String>> clusterMapTemp2 = new TreeMap<String,ArrayList<String>>(); 
			    		SortedMap<String,ArrayList<String>> clusterMapTemp3 = new TreeMap<String,ArrayList<String>>(); 

			    		File file = new File("NeiborCSV/neighborCsv3_entity.csv");
			    		
			    		
			    		q.add(file.getAbsolutePath());
			    		
			    		int level = 1;
			    		
			    	     List<List<String>> listoflist = new ArrayList<List<String>>();

			    	     levelnum=1;
					   		
			    		
			   	while(q.size()!=0){
			    			
			   		
			    			String dir = q.poll();
			    			log.info(dir);
			    			
			    		if(level>1){
			    			int currentdirlevel = Integer.parseInt(dir.split("levelResults/matrix_")[1].split("_")[0]);
			    			log.info("curr:"+currentdirlevel);
			    			//if(currentdirlevel<level)
			    			//{
			    				level = currentdirlevel+1;
			    			//}
			    		}
			    			
			    			
				    		List<String> list = new ArrayList<String>();
				    		levelMapCheck.clear();
				    		//levelMap.clear();
				    		
			    			BufferedReader br00 = null;
			    			
			    			log.info("Start clustering for level-"+ level);
			    			log.info("dir: "+dir);
			    			if(dir.equals("levelResults/matrix_4_24.csv"))
			    			{
			    				log.info("level:"+level);
			    				
			    			}
			    			
			    			
			    			NTripleMatrixBuilder2 ntb2 = new NTripleMatrixBuilder2();
			    			ntb2.csvToXLSX(dir, dir.split(".csv")[0]+".xlsx");

			    			try {

			    				String sCurrentLine;

			    				br00 = new BufferedReader(new FileReader(dir));
			    				
			    				int lineNum = 0;

			    				while ((sCurrentLine = br00.readLine()) != null) {
			    					
			    					if(lineNum==0){
			    						
			    						String currentLineArray[] = sCurrentLine.split(",");
			    						list = Arrays.asList(currentLineArray);
			    						
			    					}
			    					else
			    					{
			    						break;
			    					}
			    					
			    					lineNum=lineNum+1;
			    				}
	
			    			} catch (IOException e) {
			    				e.printStackTrace();
			    			} finally {
			    				try {
			    					if (br00 != null)br00.close();
			    				} catch (IOException ex) {
			    					ex.printStackTrace();
			    				}
			    			}	
			    					
		    		//!	path = "C:/"+file.getName();
		    			path = dir;
		    			path = path.replace("\\", "/");
		    			
		    			log.info(file.getAbsolutePath()+";"+path);
		    			
		    			//!delobj.removeLineFromFile(path);
		    		
		    			System.out.println("Done");
		    			
				        System.out.println("OK load R");	

				     
				        re.eval("neighfile = read.csv(\""+path+"\")");
				    
				      //  re.eval("neighfile = read.csv(\""+path+"\")");
				     	re.eval("x<-rbind(neighfile)");
				     	re.eval("x<-t(x)");
				    	re.eval("library(cluster)");
				     	re.eval("library(fpc)");
				    	//re.eval("library(e1071)");
				     	re.eval("dissE <- daisy(neighfile)");	   
				     	re.eval("dE2 <- dissE^2 ");
				     	re.eval("asw <- numeric(10)");   
				    	re.eval("for (k in 2:10){"+ "\n" +
				     	" set.seed(2) "+ "\n"+
					     		   " result2<-kmeans(x,k) "+ "\n" +
					     		  " sk2 <- silhouette(result2$cluster, dE2) " + "\n" +
					     		  " asw[[k]]<-summary(sk2,Fun=mean)$avg.width" +"\n"+
					     		  " print(asw[[k]])}");
				     	
				     	
				     	
				     	re.eval("k.best<-which.max(asw)");
				     	
				    	String kbest = re.eval("print(k.best)").toString();
				     	
				     	String bestClusterNum = kbest.split("\\*")[1].split("\\(")[1].split("\\)")[0];
				     	
				     	String bestkvalue0 = re.eval("print(asw[["+bestClusterNum+"]])").toString();
				     	
				        bestkvalue0 = bestkvalue0.split("\\*")[1].split("\\(")[1].split("\\)")[0];

				    	
				    	log.info("best sw value: "+bestkvalue0);
				     	
				    	log.info(level+"-level clustering best: "+bestClusterNum);

				     	
				    //	re.eval(" result2<-kmeans(x,"+bestClusterNum+") ");
				     
				    	
				    	
				    	if(Double.parseDouble(bestkvalue0)<hfcmthreshold)
				    	{
				    		bestClusterNum="1";
				    	}
				    				
				    	
				    	
			    	  if(bestClusterNum.equals("1"))
					     {
								  Collections.sort(list); 
						    	   
						    	   String test = "";
						    	   
						    	   for(int v=0;v<list.size();v++)
						    	   {
						    		   test = test + "," + list.get(v);
						    	   }
																
								  if(!levelMapCheck.containsKey(test)){
									  levelMap.put(level+"_"+levelnum+":"+list.size(), list);
										
									//	level2Map2.put(Integer.toString(levelnum), list);
									
										
										levelMapCheck.put(test, test);
										
										log.info("best cluster num is: "+bestClusterNum);

										List<String> bList = new ArrayList<String>();
					    	    		
					    	    			
					    	    			for(int li=0;li<list.size();li++){
					    	    				
					    	    			  String predicate = list.get(li);
					    	    			//  list.remove(predicate);
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
							    	           
							    	           bList.add(newpredicate3);
							    	           
					    	    			}
				    							
					    	    			if(!listoflist.contains(bList)){	
										listoflist.add(bList);
										
					    	    		}

					    	    		// log.info(path); 
					    	    		
					    	    	//	 outcsvGeneration(path, levelMap,"one");
								    	  
								    	// levelMatrixGeneration(path, levelMap,"one");
					    	    		
					    	    		
					    	    		
					    	    		File filematrix = new File(path);
					    	    		File destfilematrix = new File("levelResults/matrix_"+level+"_"+levelnum+"_end"+".csv");
					    	    		try {
											FileUtils.copyFile(filematrix,destfilematrix);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					    	    						    			
						    			ntb2.csvToXLSX(destfilematrix.getAbsolutePath(), destfilematrix.getAbsolutePath().split(".csv")[0]+".xlsx");
						    			
						    			log.info(path);
						    			File fileoutcsv = new File("outCSV/out_"+path.split("levelResults/matrix_")[1]);
						    			File destfileoutcsv = new File("outCSV/out_"+level+"_"+levelnum+"_end"+".csv");
						    			try {
											FileUtils.copyFile(fileoutcsv,destfileoutcsv);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					    	    		
						    			
						    		 	 FileWriter fw0 = null;
					    	    		 BufferedWriter bw0 = null;
										 String content0 = "Size:"+list.size()+"\n\n";
										// clusterLevel2=clusterLevel2+1;
										// log.info("clusters/cluster_"+level+"_"+levelnum+":"+list);
					    	    		 for(int f=0;f<list.size();f++)
					    	    		 {
					    	    			 try {
					    	    					File clusterfile = new File("clusters/cluster_"+level+"_"+levelnum+"_end");
					    	    		 
					    	    					// if file doesnt exists, then create it
					    	    					if (!clusterfile.exists()) {
					    	    						clusterfile.createNewFile();
					    	    					}
					    	    		 
					    	    					String predicate = list.get(f);
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
					    	    					
					    	    					
					    	    					 fw0 = new FileWriter(clusterfile.getAbsoluteFile());
					    	    					 bw0 = new BufferedWriter(fw0);
					    	    					 content0 = content0 + newpredicate3+"\n";
					    	    					
					    	    		 
					    	    					System.out.println("Done");
					    	    		 
					    	    				} catch (IOException e) {
					    	    					e.printStackTrace();
					    	    				}
					    	    		 }
					    	    		 try {
											bw0.write(content0);
											bw0.close();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
			 	    				
											levelnum = levelnum+1;

						    			
											
					    	    		
										continue;
								  }
								  else
								  {
									  continue;
								  }					     									     							     									    	
					     }			    	  	
				     	
				    else{
				    	re.eval(" result2<-kmeans(x,"+bestClusterNum+")");
				    	
				    	log.info("best cluster num is: "+bestClusterNum);
				    
				     	
				    	
				    	File filesample = new File("sample.txt");
				    	if(filesample.exists())
				    	{
				    		filesample.delete();
				    	}
				    	
				    	PrintStream ps2;
				     	
						try {
							ps2 = new PrintStream("sample.txt");
							System.setOut(ps2);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
											
						re.eval("print(result2$cluster)");

			//////////// Read file into Text Area ////////////////////////////////////////
									
									clusterList.clear();
									levelMap.clear();
									clusterMap.clear();
						
					//!	FuzzyclusterSummary.setText("Level 1 Clustering:\n");
						
						BufferedReader br = null;
						 
						try {
				 
							String sCurrentLine;
				 
							br = new BufferedReader(new FileReader("sample.txt"));
				 
							while ((sCurrentLine = br.readLine()) != null) {
								
								//FuzzyclusterSummary.append(sCurrentLine+"\n");
								//log.info("sCurrentLine: "+sCurrentLine);
								clusterList.add(sCurrentLine);																
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
						
						
		                
						
						for(int i=0;i<clusterList.size();i++)
						{
							if(i%2!=0){
							String clusternumber = clusterList.get(i);
							//log.info("clusterNumber: "+clusternumber);
							clusternumber = clusternumber.trim();
								if(clusterMap.containsKey(clusternumber))
								{
									ArrayList<String> ElementList = clusterMap.get(clusternumber);
									if(!ElementList.contains(clusterList.get(i-1).trim()))
									{
										ElementList.add(clusterList.get(i-1).trim());
										
									}
																									
									clusterMap.put(clusternumber,ElementList);
									
								}
								else
								{
									ArrayList<String> ElementList = new ArrayList<String>();
									ElementList.add(clusterList.get(i-1).trim());															
									clusterMap.put(clusternumber,ElementList);		
								}
							}
							else
							{
								continue;
							}
						}
						
						
						Iterator<String> iterclusterMap = clusterMap.keySet().iterator(); 
				       
					       while(iterclusterMap.hasNext()){
					    	   
					    	   String key = iterclusterMap.next();
					    	   
					    	   ArrayList<String> valuelist = clusterMap.get(key);
					    	   
					    	//   log.info("valueList: "+valuelist.size());
					    	   					    	 					    					    	   
					    	   Collections.sort(valuelist); 
					    	   
					    	   String test = "";
					    	   
					    	   for(int v=0;v<valuelist.size();v++)
					    	   {
					    		   test = test + "," + valuelist.get(v);
					    	   }
					    	   
					    	   
					     if(!levelMapCheck.containsKey(test)){					    	    
					    	 
					    	   levelMap.put(level+"_"+levelnum+":"+valuelist.size(), valuelist);					    	   					    	
					    	   
					    	   
					    	   levelMapCheck.put(test, test);
					    	   
					    	   q.add("levelResults/matrix_"+level+"_"+levelnum+".csv");
					    	   
					    	   if(level==4&&levelnum==24)
					    	   {
					    		   log.info("levelResults/matrix_4_24.csv");
					    	   }
					    	   
					    	   levelnum=levelnum+1;

					     }

					    }
						  
			   	}
				
			    	  
			    	  outcsvGeneration(path, levelMap,"morethanone");
			    	  
			    	  levelMatrixGeneration(path, levelMap,"morethanone");
						
					   
					    
					/*	if(level==1)
						{
							level=level+1;
						}
						else if(level>1){
						int state = 0;
					
						for (String e : q) {
							if(e.contains("levelResults/matrix_"+level+"_")){						
								
								state = 1;
								break;
							}							
						
						}
						
						if(state==0)
						{
							level = level + 1;
						}
						}*/
						
			    	  if(level==1){
						level = level+1;
			    	  }
			    		}
			       double endtime = System.currentTimeMillis();
			       double kmeansinterval = endtime-starttime;
				   log.info("topdown time: "+kmeansinterval);

						
			 //  	log.info("listofList: "+listoflist.size());
			   	
					   
	    	      int filecount = 0;
	    	      						try{
							    	    	for(int l=0;l<listoflist.size();l++){	
							    	    		
							    	    		//log.info("listoflist: "+listoflist.get(l).toString());
							    	    		
							    	    		
							    	    		 List<String >writeRecord = new ArrayList<String>();
							    	    		 List<String >writeRecord2 = new ArrayList<String>();
							    	    		 List<String >writeRecord3 = new ArrayList<String>();
							    	    		
							    	    		
							    	    		List<String> firstlist = listoflist.get(l);
							    	    	//	 log.info("sumDegreeMap: "+sumDegreeMap.size());
							    	    		 List<String> queryList = new ArrayList<String>();

							    	    		 List<Entry<String,Integer>> sortedEntries = entriesSortedByValues(sumDegreeMap);
							    	    		 
							    	    		 for(int s=0;s<sortedEntries.size();s++)
							    	    		 {
							    	    			 String ab = sortedEntries.get(s).getKey();
							    	    			 
							    	    			 String newpredicate="";
									    	          String newpredicate1="";
									    	          String newpredicate2="";
									    	          String newpredicate4="";
									    	          String newpredicate3 ="";

									    	           if(ab.contains(":")){
						    							 newpredicate = ab.replaceAll(":", ".");
									    	           }
									    	           else
									    	           {
									    	        	   newpredicate =   ab;
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
							    	    			 
							    	    			 if(firstlist.contains(newpredicate3))
							    	    			 {
							    	    				 if(!queryList.contains(sortedEntries.get(s).getKey()))
							    	    				 {
							    	    					 queryList.add(sortedEntries.get(s).getKey());
							    	    				 }
							    	    			 }
							    	    		 }
							    	    		 
							    	    		 String content ="";
							    	    		 FileWriter fw = null;
							    	    		 BufferedWriter bw = null;
							    	    		 File filequery = new File("queryGen/ThreeLevel"+filecount+"-"+firstlist.size()+".txt");
						    	    			 
				    	    						// if file doesnt exists, then create it
				    	    						if (!filequery.exists()) {
				    	    							filequery.createNewFile();
				    	    						}
				    	    						
				    	    						 fw = new FileWriter(filequery.getAbsoluteFile());
				    	    						 bw = new BufferedWriter(fw);
				    	    					
				    	    						 int queryCount = 0;
							    	    		 
							    	    		 for(int q=0;q<queryList.size();q++)
							    	    		 {
							    	    			 List<String> solist0 = new ArrayList<String>();
				    	    							
						    	    					if(subobjMap.containsKey(queryList.get(q)))
						    	    					{
						    	    						solist0 = subobjMap.get(queryList.get(q));
						    	    					}
						    	    					
						    	    					
						    	    					if(solist0.size()!=0){
							    	    					for(int s=0;s<solist0.size();s++)
							    	    					{						
							    	    						String subject = solist0.get(s).split(";")[0];
							    	    						String object = solist0.get(s).split(";")[1];				
							    	    						//bw.append("("+subject+","+queryList.get(q)+","+object+"):"+"\n");
							    	    			
							    	    					
							    	    			 
							    	    			/// log.info(queryList.get(q)+":"+sumDegreeMap.get(queryList.get(q)));
							    	    			int num = nameNumMap.get(queryList.get(q));
							    	    			List<Entry<Integer,Double>> entrylist = simList.get(num);
							    	    			
							    	    			for(int e=0;e<entrylist.size();e++)
							    	    			{
							    	    				String stringName = nameNumMapReverse.get(entrylist.get(e).getKey());
		
							    	    				Double simScore = entrylist.get(e).getValue();
							    	    				
							    	    				if(simScore==0||simScore==1)
							    	    				{
							    	    					continue;
							    	    				}
										    	           
							    	    				if(!queryList.contains(stringName))
							    	    				{
							    	    					continue;
							    	    				}
							    	    				else
							    	    				{
							    	    					List<String> solist = new ArrayList<String>();
							    	    							
							    	    					if(subobjMap.containsKey(stringName))
							    	    					{
							    	    						solist = subobjMap.get(stringName);
							    	    					}
							    	    					
							    	    			 		int num2 = nameNumMap.get(stringName);
							    	    					
							    	    			 		List<String> firstlevelquery = new ArrayList<String>();
							    	    			 		
							    	    					if(solist.size()!=0){
							    	    					for(int s2=0;s2<solist.size();s2++)
							    	    					{						
							    	    						String subject2 = solist.get(s2).split(";")[0];
							    	    						String object2 = solist.get(s2).split(";")[1];							    	    						
							    	    						//content = content+"("+subject+","+stringName+","+object+")"+"\n";	

							    	    						//log.info(Double.toString(simScore));
							    	    					
							    	    						
							    	    						
							    	    						
							    	    						if(!secondmap.containsKey(Integer.toString(num)+";"+Integer.toString(num2))&&!thirdmap.containsKey(Integer.toString(num)+";"+Integer.toString(num2))){
							    	    							
							    	    							
							    	    							
							    	    						//bw.append("("+subject2+","+stringName+","+object2+")"+"\n");
							    	    						if(subject.equals(subject2))
							    	    						{
							    	    							String varSub="";
							    	    							
							    	    							//varSub = "?"+subject.split("/")[3];
							    	    							//varSub = "?"+subject.split("/")[4];//for OBI
							    	    							//varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							//varSub = "?"+subject.split(":")[2];//for bio2rdf clinicaltrial
							    	    							
							    	    							if(subject.contains("#"))
							    	    							{
							    	    							  varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							}
							    	    							else if(!subject.contains("#")&&subject.split(":").length==3)
							    	    							{
							    	    								varSub = "?"+subject.split("/")[3];//for bio2rdf clinicaltrial,drugbank
							    	    							}
							    	    							else if(!subject.contains("#")&&subject.split(":").length==2)
							    	    							{
							    	    								//varSub = "?"+object.split("/")[3];
								    	    							varSub = "?"+subject.split("/")[4];//for OBI,DO
							    	    							}
							    	    							
							    	    							
							    	    							
							    	    							if(!firstlevelquery.contains(varSub+","+queryList.get(q)+","+object+"\n"+varSub+","+stringName+","+object2+"\n"))
							    	    							{
							    	    								firstlevelquery.add(varSub+","+queryList.get(q)+","+object+"\n"+varSub+","+stringName+","+object2+"\n");
							    	    							}
							    	    						/*	bw.append(varSub+","+queryList.get(q)+","+object+"\n");
							    	    							bw.append(varSub+","+stringName+","+object2+"\n");
							    	    							bw.append("\n\n");*/
							    	    						}
							    	    						else if(subject.equals(object2))
							    	    						{
							    	    							String varSub="";
							    	    							//varSub = "?"+subject.split("/")[3];
							    	    							//varSub = "?"+subject.split("/")[4];//for OBI
							    	    							//varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							//varSub = "?"+subject.split(":")[2];//for bio2rdf clinicaltrial	
							    	    							
							    	    							
							    	    							if(subject.contains("#"))
							    	    							{
							    	    							  varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							}
							    	    							else if(!subject.contains("#")&&subject.split(":").length==3)
							    	    							{
							    	    								varSub = "?"+subject.split("/")[3];//for bio2rdf clinicaltrial,drugbank
							    	    							}
							    	    							else if(!subject.contains("#")&&subject.split(":").length==2)
							    	    							{
							    	    								//varSub = "?"+object.split("/")[3];
								    	    							varSub = "?"+subject.split("/")[4];//for OBI,DO
							    	    							}
							    	    							
							    	    							
							    	    							if(!firstlevelquery.contains(varSub+","+queryList.get(q)+","+object+"\n"+subject2+","+stringName+","+varSub+"\n"))
							    	    							{
							    	    								firstlevelquery.add(varSub+","+queryList.get(q)+","+object+"\n"+subject2+","+stringName+","+varSub+"\n");
							    	    							}
							    	    							
							    	    							/*bw.append(varSub+","+queryList.get(q)+","+object+"\n");
							    	    							bw.append(subject2+","+stringName+","+varSub+"\n");
							    	    							bw.append("\n\n");*/
							    	    						}
							    	    						else if(subject2.equals(object))
							    	    						{
							    	    							String varSub="";
							    	    							
							    	    							//varSub = "?"+subject2.split("/")[3];
							    	    							//varSub = "?"+subject2.split("/")[4];//for OBI
							    	    							//varSub = "?"+subject2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							//varSub = "?"+subject2.split(":")[2];//for bio2rdf clinicaltrial
							    	    							
							    	    							

							    	    							if(subject2.contains("#"))
							    	    							{
							    	    							  varSub = "?"+subject2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							}
							    	    							else if(!subject2.contains("#")&&subject2.split(":").length==3)
							    	    							{
							    	    								varSub = "?"+subject2.split("/")[3];//for bio2rdf clinicaltrial,drugbank
							    	    							}
							    	    							else if(!subject2.contains("#")&&subject2.split(":").length==2)
							    	    							{
							    	    								//varSub = "?"+object.split("/")[3];
								    	    							varSub = "?"+subject2.split("/")[4];//for OBI,DO
							    	    							}
							    	    							
							    	    							
							    	    							if(!firstlevelquery.contains(subject+","+queryList.get(q)+","+varSub+"\n"+varSub+","+stringName+","+object2+"\n"))
							    	    							{
							    	    								firstlevelquery.add(subject+","+queryList.get(q)+","+varSub+"\n"+varSub+","+stringName+","+object2+"\n");
							    	    							}
							    	    							
							    	    							/*bw.append(subject+","+queryList.get(q)+","+varSub+"\n");
							    	    							bw.append(varSub+","+stringName+","+object2+"\n");
							    	    							bw.append("\n\n");*/
							    	    						}
							    	    						else if(object.equals(object2))
							    	    						{
							    	    							String varSub="";
							    	    							

							    	    							if(object.contains("#"))
							    	    							{
							    	    							  varSub = "?"+object.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
							    	    							}
							    	    							else if(!object.contains("#")&&object.split(":").length==3)
							    	    							{
							    	    								varSub = "?"+object.split("/")[3];//for bio2rdf clinicaltrial,drugbank
							    	    							}
							    	    							else if(!object.contains("#")&&object.split(":").length==2)
							    	    							{
							    	    								//varSub = "?"+object.split("/")[3];
								    	    							varSub = "?"+object.split("/")[4];//for OBI,DO
							    	    							}
							    	    							
							    	    							if(!firstlevelquery.contains(subject+","+queryList.get(q)+","+varSub+"\n"+subject2+","+stringName+","+varSub+"\n"))
							    	    							{
							    	    								firstlevelquery.add(subject+","+queryList.get(q)+","+varSub+"\n"+subject2+","+stringName+","+varSub+"\n");
							    	    							}
							    	    							
							    	    						/*	bw.append(subject+","+queryList.get(q)+","+varSub+"\n");
							    	    							bw.append(subject2+","+stringName+","+varSub+"\n");
							    	    							bw.append("\n\n");    		*/					
							    	    						}
							    	    						}
							    	    						
							    	    						for(int f=0;f<firstlevelquery.size();f++)
							    	    						{
							    	    							 if(!writeRecord.contains(firstlevelquery.get(f))){
							    	    							bw.append(firstlevelquery.get(f));
					    	    									bw.append("\n\n");
					    	    									queryCount = queryCount+1;
					    	    									writeRecord.add(firstlevelquery.get(f));
							    	    							 }
							    	    						}
							    	    						
							    	    						
							    	    						
							    	    						if(secondmap.containsKey(Integer.toString(num)+";"+Integer.toString(num2)))
							    	    						{					
							    	    							
							    	    							//log.info("");
							    	    							List<String> middleNodeList = secondmap.get(Integer.toString(num)+";"+Integer.toString(num2)); 
							    	    							
							    	    							for(int m=0;m<middleNodeList.size();m++)
							    	    							{
							    	    								
							    	    								List<String> intermedicate1 = new ArrayList<String>();
								    	    							List<String> intermedicate2 = new ArrayList<String>();
							    	    								
							    	    								String middle1 = nameNumMapReverse.get(Integer.parseInt(middleNodeList.get(m)));
							    	    								
							    	    								List<String> solist2nd = new ArrayList<String>();
								    	    							
										    	    					if(subobjMap.containsKey(middle1))
										    	    					{
										    	    						solist2nd = subobjMap.get(middle1);
										    	    					}

										    	    					if(solist2nd.size()!=0){
										    	    						for(int sm2=0;sm2<solist2nd.size();sm2++)
											    	    					{
										    	    							intermedicate1.clear();
										    	    							intermedicate2.clear();
										    	    							
										    	    							varMap.clear();
										    	    							String subjectmiddle1 = solist2nd.get(sm2).split(";")[0];
											    	    						String objectmiddle1 = solist2nd.get(sm2).split(";")[1];	
											    	    				
											    	    						//log.info(subjectmiddle1);
											    	    					
											    	    						
											    	    				/////////// For P1->P2 ////////////////
											    	    						if(subjectmiddle1.equals(subject))
											    	    						{
											    	    							String varSub="";
											    	    							
											    	    							//varSub = "?"+subjectmiddle1.split("/")[3];
											    	    							//varSub = "?"+subjectmiddle1.split("/")[4];//for OBI
											    	    							//varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+subjectmiddle1.split(":")[2];//for bio2rdf clinicaltrial	
											    	    							

											    	    							if(subjectmiddle1.contains("#"))
											    	    							{
											    	    							  varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+subjectmiddle1.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+subjectmiddle1.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							if(!intermedicate1.contains(varSub+","+queryList.get(q)+","+object+"\n"+varSub+","+middle1+","+objectmiddle1+"\n"))
											    	    							{
											    	    								intermedicate1.add(varSub+","+queryList.get(q)+","+object+"\n"+varSub+","+middle1+","+objectmiddle1+"\n");
											    	    							}
											    	    						if(!varMap.containsKey(subjectmiddle1)){
											    	    							varMap.put(subjectmiddle1,varSub);
											    	    						}
											    	    						}
											    	    						else if(subject.equals(objectmiddle1))
											    	    						{
											    	    							String varSub="";
											    	    							//varSub = "?"+subject.split("/")[3];
											    	    							//varSub = "?"+subject.split("/")[4];//for OBI
											    	    							//varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+subject.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							
											    	    							if(subject.contains("#"))
											    	    							{
											    	    							  varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!subject.contains("#")&&subject.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+subject.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!subject.contains("#")&&subject.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+subject.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							
											    	    							if(!intermedicate1.contains(varSub+","+queryList.get(q)+","+object+"\n"+subjectmiddle1+","+middle1+","+varSub+"\n"))
											    	    							{
											    	    								intermedicate1.add(varSub+","+queryList.get(q)+","+object+"\n"+subjectmiddle1+","+middle1+","+varSub+"\n");
											    	    							}	
											    	    						if(!varMap.containsKey(subject)){
											    	    							varMap.put(subject,varSub);
											    	    						}
											    	    						}
											    	    						else if(subjectmiddle1.equals(object))
											    	    						{
											    	    							String varSub="";
											    	    							//varSub = "?"+subjectmiddle1.split("/")[3];
											    	    							//varSub = "?"+subjectmiddle1.split("/")[4];//for OBI
											    	    							//varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+subjectmiddle1.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							if(subjectmiddle1.contains("#"))
											    	    							{
											    	    							  varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+subjectmiddle1.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+subjectmiddle1.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							if(!intermedicate1.contains(subject+","+queryList.get(q)+","+varSub+"\n"+varSub+","+middle1+","+objectmiddle1+"\n"))
											    	    							{
											    	    								intermedicate1.add(subject+","+queryList.get(q)+","+varSub+"\n"+varSub+","+middle1+","+objectmiddle1+"\n");
											    	    							}	
											    	    							if(!varMap.containsKey(subjectmiddle1)){
											    	    							varMap.put(subjectmiddle1,varSub);
											    	    							}
											    	    					
											    	    						}
											    	    						else if(object.equals(objectmiddle1))
											    	    						{
											    	    							String varSub="";
											    	    						//	varSub = "?"+object.split("/")[3];
											    	    						//	varSub = "?"+object.split("/")[4];//for OBI
											    	    						//	varSub = "?"+object.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    						//	varSub = "?"+object.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							if(object.contains("#"))
											    	    							{
											    	    							  varSub = "?"+object.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!object.contains("#")&&object.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+object.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!object.contains("#")&&object.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+object.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							if(!intermedicate1.contains(subject+","+queryList.get(q)+","+varSub+"\n"+subjectmiddle1+","+middle1+","+varSub+"\n"))
											    	    							{
											    	    								intermedicate1.add(subject+","+queryList.get(q)+","+varSub+"\n"+subjectmiddle1+","+middle1+","+varSub+"\n");
											    	    							}	
											    	    							
											    	    							if(!varMap.containsKey(object)){
											    	    							varMap.put(object,varSub);
											    	    							}
											    	    							
											    	    						}
											    	    						
											    	    						
											    	    						
											    	    						
											    	    						/////////// For P2->P3 ////////////////
											    	    						
											    	    						if(subjectmiddle1.equals(subject2))
											    	    						{
											    	    							String varSub="";
											    	    							
											    	    							//varSub = "?"+subjectmiddle1.split("/")[3];
											    	    							//varSub = "?"+subjectmiddle1.split("/")[4];//for OBI
											    	    							//varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+subjectmiddle1.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							if(subjectmiddle1.contains("#"))
											    	    							{
											    	    							  varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+subjectmiddle1.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+subjectmiddle1.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							if(!intermedicate2.contains(varSub+","+middle1+","+objectmiddle1+"\n"+varSub+","+stringName+","+object2+"\n"))
											    	    							{
											    	    								intermedicate2.add(varSub+","+middle1+","+objectmiddle1+"\n"+varSub+","+stringName+","+object2+"\n");
											    	    							}
											    	    						
											    	    							if(!varMap.containsKey(subjectmiddle1)){
											    	    							varMap.put(subjectmiddle1,varSub);
											    	    							}
											    	    						}
											    	    						else if(subjectmiddle1.equals(object2))
											    	    						{
											    	    							String varSub="";
											    	    							
											    	    							//varSub = "?"+subjectmiddle1.split("/")[3];
											    	    							//varSub = "?"+subjectmiddle1.split("/")[4];//for OBI
											    	    							//varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+subjectmiddle1.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							if(subjectmiddle1.contains("#"))
											    	    							{
											    	    							  varSub = "?"+subjectmiddle1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+subjectmiddle1.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!subjectmiddle1.contains("#")&&subjectmiddle1.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+subjectmiddle1.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							
											    	    							if(!intermedicate2.contains(varSub+","+middle1+","+objectmiddle1+"\n"+subject2+","+stringName+","+varSub+"\n"))
											    	    							{
											    	    								intermedicate2.add(varSub+","+middle1+","+objectmiddle1+"\n"+subject2+","+stringName+","+varSub+"\n");
											    	    							}
											    	    							
											    	    							if(!varMap.containsKey(subjectmiddle1)){
												    	    							varMap.put(subjectmiddle1,varSub);
												    	    							}
											    	    						
											    	    						}
											    	    						else if(subject2.equals(objectmiddle1))
											    	    						{
											    	    							String varSub="";
											    	    							
											    	    							//varSub = "?"+subject2.split("/")[3];
											    	    							//varSub = "?"+subject2.split("/")[4];//for OBI
											    	    							//varSub = "?"+subject2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+subject2.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							
											    	    							if(subject2.contains("#"))
											    	    							{
											    	    							  varSub = "?"+subject2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!subject2.contains("#")&&subject2.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+subject2.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!subject2.contains("#")&&subject2.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+subject2.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							if(!intermedicate2.contains(subjectmiddle1+","+middle1+","+varSub+"\n"+varSub+","+stringName+","+object2+"\n"))
											    	    							{
											    	    								intermedicate2.add(subjectmiddle1+","+middle1+","+varSub+"\n"+varSub+","+stringName+","+object2+"\n");
											    	    							}	
											    	    					
											    	    							if(!varMap.containsKey(subject2)){
												    	    							varMap.put(subject2,varSub);
												    	    							}
											    	    						}
											    	    						else if(object2.equals(objectmiddle1))
											    	    						{
											    	    							String varSub="";
											    	    							//varSub = "?"+object2.split("/")[3];
											    	    							//varSub = "?"+object2.split("/")[4];//for OBI
											    	    							//varSub = "?"+object2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							//varSub = "?"+object2.split(":")[2];//for bio2rdf clinicaltrial
											    	    							
											    	    							if(object2.contains("#"))
											    	    							{
											    	    							  varSub = "?"+object2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
											    	    							}
											    	    							else if(!object2.contains("#")&&object2.split(":").length==3)
											    	    							{
											    	    								varSub = "?"+object2.split("/")[3];//for bio2rdf clinicaltrial,drugbank
											    	    							}
											    	    							else if(!object2.contains("#")&&object2.split(":").length==2)
											    	    							{
											    	    								//varSub = "?"+object.split("/")[3];
												    	    							varSub = "?"+object2.split("/")[4];//for OBI,DO
											    	    							}
											    	    							
											    	    							
											    	    							if(!intermedicate2.contains(subjectmiddle1+","+middle1+","+varSub+"\n"+subject2+","+stringName+","+varSub+"\n"))
											    	    							{
											    	    								intermedicate2.add(subjectmiddle1+","+middle1+","+varSub+"\n"+subject2+","+stringName+","+varSub+"\n");
											    	    							}	
											    	    							
											    	    							if(!varMap.containsKey(object2)){
												    	    							varMap.put(object2,varSub);
												    	    							}
											    	    						}
											    	    						
											    	    						
											    	    						
											    	    					}
										    	    					}
										    	    					else
										    	    					{
										    	    						
										    	    					}
										    	    					
										    	    						for(int i1=0;i1<intermedicate1.size();i1++)
									    	    							{
									    	    								String final1 = "";
									    	    								String out[] = intermedicate1.get(i1).split("\n");
								    	    									for(int h=0;h<out.length;h++)
								    	    									{
								    	    										String st[] = out[h].split(",");
								    	    										for(int k=0;k<st.length;k++)
								    	    										{
								    	    											if(varMap.containsKey(st[k]))
									    	    										{
								    	    												final1 = intermedicate1.get(i1).replace(st[k],varMap.get(st[k]));	
								    	    												intermedicate1.set(i1,final1);  
									    	    										}
								    	    											else
								    	    											{
								    	    												final1 = intermedicate1.get(i1);
								    	    											}
								    	    										}
								    	    									}
								    	    									
									    	    								for(int i2=0;i2<intermedicate2.size();i2++)
									    	    								{							    	    									
									    	    									String final2 = "";
									    	    									String out2[] = intermedicate2.get(i2).split("\n");
									    	    									for(int h=0;h<out2.length;h++)
									    	    									{
									    	    										String st[] = out2[h].split(",");
									    	    										for(int k=0;k<st.length;k++)
									    	    										{
									    	    											if(varMap.containsKey(st[k]))
										    	    										{
									    	    												final2 = intermedicate2.get(i2).replace(st[k],varMap.get(st[k]));		
									    	    												intermedicate2.set(i2,final2);  
										    	    										}
									    	    											else
									    	    											{
									    	    												final2 = intermedicate2.get(i2);
									    	    											}
									    	    										}
									    	    									}
									    	    									
									    	    									String insert1 = final1;
									    	    									String insert2 = final2;
									    	    									
									    	    							  if(!writeRecord2.contains(insert1+insert2)){
									    	    									bw.append(insert1+insert2);
									    	    									bw.append("\n\n");
									    	    									queryCount = queryCount+1;
									    	    									writeRecord2.add(insert1+insert2);
									    	    							  }
									    	    									//String insert0 = final1.replace("http://mayoclinic.healthscienceresearch.bmi.edu", "");
									    	    											//bw.append(insert0);					    	    																    	    									
									    	    									//bw.append("\n\n");							    	    									
									    	    								}
									    	    							}
										    	    					
										    	    					
							    	    							}
							    	    							
							    	    							
							    	    							
							    	    							
							    	    							
							    	    						
							    	    							//log.info(secondmap.get(Integer.toString(num)+";"+Integer.toString(num2)));
							    	    						}
							    	    						
							    	    						if(thirdmap.containsKey(Integer.toString(num)+";"+Integer.toString(num2)))
							    	    						{
							    	    						//	log.info("");
							    	    							List<String> middleNodeList3 = thirdmap.get(Integer.toString(num)+";"+Integer.toString(num2)); 
							    	    							
							    	    							for(int m=0;m<middleNodeList3.size();m++)
							    	    							{
							    	    								List<String> intermedicate1 = new ArrayList<String>();
							    	    								List<String> intermedicate2 = new ArrayList<String>();
							    	    								List<String> intermedicate3 = new ArrayList<String>();

							    	    								
							    	    								String arr[] = middleNodeList3.get(m).split(";");
							    	    								
							    	    								String middlenode3_1 = nameNumMapReverse.get(Integer.parseInt(arr[0]));
							    	    								String middlenode3_2 = nameNumMapReverse.get(Integer.parseInt(arr[1]));
							    	    								
								    	    								List<String> solist2nd = new ArrayList<String>();
									    	    							
											    	    					if(subobjMap.containsKey(middlenode3_1))
											    	    					{
											    	    						solist2nd = subobjMap.get(middlenode3_1);
											    	    					}

											    	    					if(solist2nd.size()!=0){
											    	    						for(int sm2=0;sm2<solist2nd.size();sm2++)
												    	    					{
											    	    						
											    	    							intermedicate1.clear();
											    	    							
											    	    							varMap0.clear();
											    	    							
											    	    							String subjectmiddle3_1 = solist2nd.get(sm2).split(";")[0];
												    	    						String objectmiddle3_1 = solist2nd.get(sm2).split(";")[1];	
												    	    				
												    	    						//log.info(subjectmiddle1);
												    	    					
												    	    						
												    	    				/////////// For P1->P2 (queryList(q)->middlenode3_1)////////////////
												    	    						if(subjectmiddle3_1.equals(subject))
												    	    						{
												    	    							String varSub="";
												    	    							//varSub = "?"+subjectmiddle3_1.split("/")[3];
												    	    							//varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI	
												    	    							//varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    							//varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial
												    	    							
												    	    							if(subjectmiddle3_1.contains("#"))
												    	    							{
												    	    							  varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    							}
												    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==3)
												    	    							{
												    	    								varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial	
												    	    							}
												    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==2)
												    	    							{
												    	    								//varSub = "?"+object.split("/")[3];
													    	    							varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
												    	    							}
												    	    							
												    	    							
												    	    							if(!intermedicate1.contains(varSub+","+queryList.get(q)+","+object+"\n"+varSub+","+middlenode3_1+","+objectmiddle3_1+"\n"))
												    	    							{
												    	    								intermedicate1.add(varSub+","+queryList.get(q)+","+object+"\n"+varSub+","+middlenode3_1+","+objectmiddle3_1+"\n");
												    	    							}
												    	    						
												    	    							if(!varMap.containsKey(subjectmiddle3_1)){
													    	    							varMap.put(subjectmiddle3_1,varSub);
													    	    						}
												    	    							
												    	    						}
												    	    						else if(subject.equals(objectmiddle3_1))
												    	    						{
												    	    							String varSub="";
												    	    							//varSub = "?"+subject.split("/")[3];
												    	    							//varSub = "?"+subject.split("/")[4];//for OBI
												    	    							//varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    							//varSub = "?"+subject.split(":")[2];//for bio2rdf clinicaltrial
												    	    							
												    	    							if(subject.contains("#"))
												    	    							{
												    	    							  varSub = "?"+subject.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    							}
												    	    							else if(!subject.contains("#")&&subject.split(":").length==3)
												    	    							{
												    	    								varSub = "?"+subject.split(":")[2];//for bio2rdf clinicaltrial	
												    	    							}
												    	    							else if(!subject.contains("#")&&subject.split(":").length==2)
												    	    							{
												    	    								//varSub = "?"+object.split("/")[3];
													    	    							varSub = "?"+subject.split("/")[4];//for OBI
												    	    							}
												    	    							
												    	    							
												    	    							if(!intermedicate1.contains(varSub+","+queryList.get(q)+","+object+"\n"+subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n"))
												    	    							{
												    	    								intermedicate1.add(varSub+","+queryList.get(q)+","+object+"\n"+subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n");
												    	    							}
												    	    							
												    	    							if(!varMap.containsKey(subject)){
													    	    							varMap.put(subject,varSub);
													    	    						}
												    	    						
												    	    						}
												    	    						else if(subjectmiddle3_1.equals(object))
												    	    						{
												    	    							String varSub="";
												    	    						//	varSub = "?"+subjectmiddle3_1.split("/")[3];
												    	    						//	varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
												    	    						//	varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    						//	varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial
												    	    							
												    	    							if(subjectmiddle3_1.contains("#"))
												    	    							{
												    	    							  varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    							}
												    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==3)
												    	    							{
												    	    								varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial	
												    	    							}
												    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==2)
												    	    							{
												    	    								//varSub = "?"+object.split("/")[3];
													    	    							varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
												    	    							}
												    	    							
												    	    							
												    	    							if(!intermedicate1.contains(subject+","+queryList.get(q)+","+varSub+"\n"+varSub+","+middlenode3_1+","+objectmiddle3_1+"\n"))
												    	    							{
												    	    								intermedicate1.add(subject+","+queryList.get(q)+","+varSub+"\n"+varSub+","+middlenode3_1+","+objectmiddle3_1+"\n");
												    	    							}	
												    	    							
												    	    							if(!varMap.containsKey(subjectmiddle3_1)){
													    	    							varMap.put(subjectmiddle3_1,varSub);
													    	    							}
												    	    					
												    	    						}
												    	    						else if(object.equals(objectmiddle3_1))
												    	    						{
												    	    							String varSub="";
												    	    							
												    	    							//varSub = "?"+object.split("/")[3];
												    	    						//	varSub = "?"+object.split("/")[4];//for OBI	
												    	    						//	varSub = "?"+object.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    						//	varSub = "?"+object.split(":")[2];//for bio2rdf clinicaltrial
												    	    							
												    	    							
												    	    							
												    	    							if(object.contains("#"))
												    	    							{
												    	    							  varSub = "?"+object.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
												    	    							}
												    	    							else if(!object.contains("#")&&object.split(":").length==3)
												    	    							{
												    	    								varSub = "?"+object.split(":")[2];//for bio2rdf clinicaltrial	
												    	    							}
												    	    							else if(!object.contains("#")&&object.split(":").length==2)
												    	    							{
												    	    								//varSub = "?"+object.split("/")[3];
													    	    							varSub = "?"+object.split("/")[4];//for OBI
												    	    							}
												    	    							
												    	    							if(!intermedicate1.contains(subject+","+queryList.get(q)+","+varSub+"\n"+subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n"))
												    	    							{
												    	    								intermedicate1.add(subject+","+queryList.get(q)+","+varSub+"\n"+subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n");
												    	    							}	
												    	    							
												    	    							if(!varMap.containsKey(object)){
													    	    							varMap.put(object,varSub);
													    	    							}
													    	    							
												    	    							
												    	    						}
												    	    						
												    	    						////// For P2->P3 (middlenode3_1->middlenode3_2) //////////
												    	    						List<String> solist2nd_2 = new ArrayList<String>();
											    	    							
													    	    					if(subobjMap.containsKey(middlenode3_2))
													    	    					{
													    	    						solist2nd_2 = subobjMap.get(middlenode3_2);
													    	    					}

													    	    					if(solist2nd_2.size()!=0){
													    	    						
													    	    						for(int sm3=0;sm3<solist2nd_2.size();sm3++)
													    	    						{
													    	    							intermedicate2.clear();
													    	    							intermedicate3.clear();
													    	    							varMap.clear();
													    	    							
													    	    							String subjectmiddle3_2 = solist2nd_2.get(sm3).split(";")[0];
													    	    							String objectmiddle3_2 = solist2nd_2.get(sm3).split(";")[1];
													    	    							
													    	    							if(subjectmiddle3_1.equals(subjectmiddle3_2))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+subjectmiddle3_1.split("/")[3];
														    	    						//	varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
														    	    						//	varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							
														    	    							if(subjectmiddle3_1.contains("#"))
														    	    							{
														    	    							  varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate2.contains(varSub+","+middlenode3_1+","+objectmiddle3_1+"\n"+varSub+","+middlenode3_2+","+objectmiddle3_2+"\n"))
														    	    							{
														    	    								intermedicate2.add(varSub+","+middlenode3_1+","+objectmiddle3_1+"\n"+varSub+","+middlenode3_2+","+objectmiddle3_2+"\n");
														    	    							}
														    	    							
														    	    							if(!varMap.containsKey(subjectmiddle3_1)){
															    	    							varMap.put(subjectmiddle3_1,varSub);
															    	    							}
														    	    						}
													    	    							
													    	    							else if(subjectmiddle3_1.equals(objectmiddle3_2))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+subjectmiddle3_1.split("/")[3];
														    	    						//	varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
														    	    						//	varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							if(subjectmiddle3_1.contains("#"))
														    	    							{
														    	    							  varSub = "?"+subjectmiddle3_1.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+subjectmiddle3_1.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!subjectmiddle3_1.contains("#")&&subjectmiddle3_1.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+subjectmiddle3_1.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate2.contains(varSub+","+middlenode3_1+","+objectmiddle3_1+"\n"+subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n"))
														    	    							{
														    	    								intermedicate2.add(varSub+","+middlenode3_1+","+objectmiddle3_1+"\n"+subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n");
														    	    							}	
														    	    							
														    	    							if(!varMap.containsKey(subjectmiddle3_1)){
															    	    							varMap.put(subjectmiddle3_1,varSub);
															    	    							}
														    	    						
														    	    						}
													    	    							
													    	    							else if(subjectmiddle3_2.equals(objectmiddle3_1))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+subjectmiddle3_2.split("/")[3];
														    	    						//	varSub = "?"+subjectmiddle3_2.split("/")[4];//for OBI
														    	    						//	varSub = "?"+subjectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+subjectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							if(subjectmiddle3_2.contains("#"))
														    	    							{
														    	    							  varSub = "?"+subjectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!subjectmiddle3_2.contains("#")&&subjectmiddle3_2.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+subjectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!subjectmiddle3_2.contains("#")&&subjectmiddle3_2.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+subjectmiddle3_2.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate2.contains(subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n"+varSub+","+middlenode3_2+","+objectmiddle3_2+"\n"))
														    	    							{
														    	    								intermedicate2.add(subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n"+varSub+","+middlenode3_2+","+objectmiddle3_2+"\n");
														    	    							}	
														    	    							
														    	    							if(!varMap.containsKey(subjectmiddle3_2)){
															    	    							varMap.put(subjectmiddle3_2,varSub);
															    	    							}
														    	    					
														    	    						}
													    	    							
													    	    							else if(objectmiddle3_2.equals(objectmiddle3_1))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+objectmiddle3_2.split("/")[3];
														    	    							
														    	    						//	varSub = "?"+objectmiddle3_2.split("/")[4];//for OBI
														    	    						//	varSub = "?"+objectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+objectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							if(objectmiddle3_2.contains("#"))
														    	    							{
														    	    							  varSub = "?"+objectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!objectmiddle3_2.contains("#")&&objectmiddle3_2.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+objectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!objectmiddle3_2.contains("#")&&objectmiddle3_2.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+objectmiddle3_2.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							
														    	    							if(!intermedicate2.contains(subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n"+subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n"))
														    	    							{
														    	    								intermedicate2.add(subjectmiddle3_1+","+middlenode3_1+","+varSub+"\n"+subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n");
														    	    							}	
														    	    							
														    	    							if(!varMap.containsKey(objectmiddle3_2)){
															    	    							varMap.put(objectmiddle3_2,varSub);
															    	    							}
														    	    						}
													    	    							
													    	    							
													    	    							
													    	    							///////// For P3-P4 (middlenode3_2 -> StringName)
													    	    							
													    	    							if(subjectmiddle3_2.equals(subject2))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+subjectmiddle3_2.split("/")[3];														    	    							
														    	    						//	varSub = "?"+subjectmiddle3_2.split("/")[4];//for OBI
														    	    						//	varSub = "?"+subjectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+subjectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							
														    	    							if(subjectmiddle3_2.contains("#"))
														    	    							{
														    	    							  varSub = "?"+subjectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!subjectmiddle3_2.contains("#")&&subjectmiddle3_2.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+subjectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!subjectmiddle3_2.contains("#")&&subjectmiddle3_2.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+subjectmiddle3_2.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate3.contains(varSub+","+middlenode3_2+","+objectmiddle3_2+"\n"+varSub+","+stringName+","+object2+"\n"))
														    	    							{
														    	    								intermedicate3.add(varSub+","+middlenode3_2+","+objectmiddle3_2+"\n"+varSub+","+stringName+","+object2+"\n");
														    	    							}
														    	    							
														    	    							if(!varMap.containsKey(subjectmiddle3_2)){
															    	    							varMap.put(subjectmiddle3_2,varSub);
															    	    							}
														    	    						}
													    	    							
													    	    							else if(subjectmiddle3_2.equals(object2))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+subjectmiddle3_2.split("/")[3];													    	    							
														    	    						//	varSub = "?"+subjectmiddle3_2.split("/")[4];//for OBI
														    	    						//	varSub = "?"+subjectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+subjectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							
														    	    							if(subjectmiddle3_2.contains("#"))
														    	    							{
														    	    							  varSub = "?"+subjectmiddle3_2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!subjectmiddle3_2.contains("#")&&subjectmiddle3_2.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+subjectmiddle3_2.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!subjectmiddle3_2.contains("#")&&subjectmiddle3_2.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+subjectmiddle3_2.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate3.contains(varSub+","+middlenode3_2+","+objectmiddle3_2+"\n"+subject2+","+stringName+","+varSub+"\n"))
														    	    							{
														    	    								intermedicate3.add(varSub+","+middlenode3_2+","+objectmiddle3_2+"\n"+subject2+","+stringName+","+varSub+"\n");
														    	    							}	
														    	    							
														    	    							if(!varMap.containsKey(subjectmiddle3_2)){
															    	    							varMap.put(subjectmiddle3_2,varSub);
															    	    							}
														    	    						
														    	    						}
													    	    							
													    	    							else if(subject2.equals(objectmiddle3_2))
														    	    						{
														    	    							String varSub="";
														    	    							//varSub = "?"+subject2.split("/")[3];														    	    							
														    	    						//	varSub = "?"+subject2.split("/")[4];//for OBI
														    	    						//	varSub = "?"+subject2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+subject2.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							
														    	    							if(subject2.contains("#"))
														    	    							{
														    	    							  varSub = "?"+subject2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!subject2.contains("#")&&subject2.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+subject2.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!subject2.contains("#")&&subject2.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+subject2.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate3.contains(subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n"+varSub+","+stringName+","+object2+"\n"))
														    	    							{
														    	    								intermedicate3.add(subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n"+varSub+","+stringName+","+object2+"\n");
														    	    							}	
														    	    							
														    	    							if(!varMap.containsKey(objectmiddle3_2)){
															    	    							varMap.put(objectmiddle3_2,varSub);
															    	    							}
														    	    					
														    	    						}
													    	    							
													    	    							else if(object2.equals(objectmiddle3_2))
														    	    						{
														    	    							String varSub="";
														    	    						//	varSub = "?"+object2.split("/")[3];
														    	    							
														    	    						//	varSub = "?"+object2.split("/")[4];//for OBI
														    	    						//	varSub = "?"+object2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    						//	varSub = "?"+object2.split(":")[2];//for bio2rdf clinicaltrial
														    	    							
														    	    							
														    	    							if(object2.contains("#"))
														    	    							{
														    	    							  varSub = "?"+object2.split("#")[1];//for FMA,NCIThesarrustable,NCIBiomedGT
														    	    							}
														    	    							else if(!object2.contains("#")&&object2.split(":").length==3)
														    	    							{
														    	    								varSub = "?"+object2.split(":")[2];//for bio2rdf clinicaltrial	
														    	    							}
														    	    							else if(!object2.contains("#")&&object2.split(":").length==2)
														    	    							{
														    	    								//varSub = "?"+object.split("/")[3];
															    	    							varSub = "?"+object2.split("/")[4];//for OBI
														    	    							}
														    	    							
														    	    							
														    	    							if(!intermedicate3.contains(subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n"+subject2+","+stringName+","+varSub+"\n"))
														    	    							{
														    	    								intermedicate3.add(subjectmiddle3_2+","+middlenode3_2+","+varSub+"\n"+subject2+","+stringName+","+varSub+"\n");
														    	    							}	
														    	    							
														    	    							if(!varMap.containsKey(object2)){
															    	    							varMap.put(object2,varSub);
															    	    							}
														    	    					
														    	    						}
													    	    						}
													    	    						
													    	    					}
													    	    					else
													    	    					{
													    	    						
													    	    					}
													    	    					
													    	    					
													    	    					for(int i1=0;i1<intermedicate1.size();i1++)
											    	    							{
											    	    								String final1 = "";
											    	    								String out[] = intermedicate1.get(i1).split("\n");
										    	    									for(int h=0;h<out.length;h++)
										    	    									{
										    	    										String st[] = out[h].split(",");
										    	    										for(int k=0;k<st.length;k++)
										    	    										{
										    	    											if(varMap0.containsKey(st[k]))
											    	    										{
										    	    												final1 = intermedicate1.get(i1).replace(st[k],varMap0.get(st[k]));	
										    	    												intermedicate1.set(i1,final1);  
											    	    										}
										    	    											else if(varMap.containsKey(st[k]))
										    	    											{
										    	    												final1 = intermedicate1.get(i1).replace(st[k],varMap.get(st[k]));	
										    	    												intermedicate1.set(i1,final1);  
										    	    											}
										    	    											else
										    	    											{
										    	    												final1 = intermedicate1.get(i1);
										    	    											}
										    	    										}
										    	    									}
										    	    									
											    	    								for(int i2=0;i2<intermedicate2.size();i2++)
											    	    								{							    	    									
											    	    									String final2 = "";
											    	    									String out2[] = intermedicate2.get(i2).split("\n");
											    	    									for(int h=0;h<out2.length;h++)
											    	    									{
											    	    										String st[] = out2[h].split(",");
											    	    										for(int k=0;k<st.length;k++)
											    	    										{
											    	    											if(varMap.containsKey(st[k]))
												    	    										{
											    	    												final2 = intermedicate2.get(i2).replace(st[k],varMap.get(st[k]));
											    	    												intermedicate2.set(i2,final2);  
												    	    										}
											    	    											else if(varMap0.containsKey(st[k]))
												    	    										{
											    	    												final2 = intermedicate2.get(i2).replace(st[k],varMap0.get(st[k]));
											    	    												intermedicate2.set(i2,final2);  
												    	    										}
											    	    											else
											    	    											{
											    	    												final2 = intermedicate2.get(i2);
											    	    											}
											    	    										}
											    	    									}
											    	    									
											    	    									

											    	    									
											    	    									for(int i3=0;i3<intermedicate3.size();i3++){
											    	    									
											    	    										String final3 = "";
												    	    									String out3[] = intermedicate3.get(i3).split("\n");
												    	    									for(int h=0;h<out3.length;h++)
												    	    									{
												    	    										String st[] = out3[h].split(",");
												    	    										for(int k=0;k<st.length;k++)
												    	    										{
												    	    											if(varMap.containsKey(st[k]))
													    	    										{
												    	    												final3 = intermedicate3.get(i3).replace(st[k],varMap.get(st[k]));
												    	    												intermedicate3.set(i3,final3);  
													    	    										}
												    	    											else if(varMap0.containsKey(st[k]))
													    	    										{
												    	    												final3 = intermedicate3.get(i3).replace(st[k],varMap0.get(st[k]));
												    	    												intermedicate3.set(i3,final3);  
													    	    										}
												    	    											else
												    	    											{
												    	    												final3 = intermedicate3.get(i3);
												    	    											}
												    	    										}
												    	    									}
												    	    									
												    	    									String insert1 = final1;
												    	    									String insert2 = final2;
												    	    									String insert3 = final3;

												    	    							    if(!writeRecord3.contains(insert1+insert2+insert3)){
											    	    									bw.append(insert1+insert2+insert3);
											    	    									bw.append("\n\n");
											    	    									queryCount = queryCount+1;
											    	    									writeRecord3.add(insert1+insert2+insert3);
												    	    							    }
											    	    									//log.info("Query number: "+ (writeRecord.size()+writeRecord2.size()+writeRecord3.size()));

											    	    									}
											    	    									//String insert0 = final1.replace("http://mayoclinic.healthscienceresearch.bmi.edu", "");
											    	    											//bw.append(insert0);					    	    																    	    									
											    	    									//bw.append("\n\n");
											    	    								}
											    	    							}
												    	    						///////////  ///////////////////
												    	    					}
											    	    					}
											    	    					else
											    	    					{
											    	    						
											    	    					}											    	    																    	    					
							    	    							}		
							    	    							}
							    	    					}
										    	    		 

							    	    					
							    	    					}
							    	    					else
							    	    					{
							    	    						content = content+"("+stringName+")"+"\n";
							    	    					}
							    	    					
							    	    					//log.info("Hi: "+stringName); 	
							    	    				}
							    	    			}
							    	    					}
						    	    					}
					    	    					else
					    	    					{
					    	    						//!bw.append("("+queryList.get(q)+"):"+"\n");
					    	    					}
							    	    		 
							    	    			//!bw.append(content);
							    	    			bw.append("\n"+"\n"+"\n"+"==========================================="+"\n");
							    	    			content="";
							    	    			
							    	    					//simList
							    	    			 
							    	    			 
							    	    		 }
							    	    		 
							    	    		 bw.close();
							    	    		 log.info("Count of Queries: "+queryCount);
							    	    		 filequery.renameTo(new File("queryGen/ThreeLevel"+filecount+"-"+firstlist.size()+"-"+queryCount+".txt"));
							    	    		 
						    	      //!       JOptionPane.showMessageDialog(null, "Finish Matrix");	

						    	     if(level==3){ 
						    	    	 log.info("csvList size: "+csvList.size());
						    	      	  String fileString = csvList.get(0);
						    	    	  csvList.remove(fileString);
						    	          
						    	    //  writeCsv2(csvMatrix,fileString);
						    	     }
			 
						    	     filecount = filecount+1;
						    	     
						    	    }
						       }  catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (Exception e)
						        {
						            e.printStackTrace();
						        }
					       
					       
					   
					       
					//   JOptionPane.showMessageDialog(null, "Finish Matrix");	
					   re.end();
		
			    	
					   
       
					       
				/*	   SortedMap<Integer,ArrayList<String>> triplemap = new TreeMap<Integer,ArrayList<String>>();
					   
					   
					   
					   
					   
					   
					   
					       ArrayList<String> runningList = new ArrayList<String>();
					       

					       runningList.add("geneontologytable");
					       runningList.add("omimtable");
					       runningList.add("pharmgkbtable");
					       runningList.add("bioportaltable");
					       runningList.add("biomodelstable");
					       runningList.add("drugbanktable");
					       runningList.add("hgnctable");
					       runningList.add("mgitable");					   
					      runningList.add("keggtable");
					      runningList.add("ctdtable");
					      runningList.add("sgdtable");
					      runningList.add("chembltable");
					      runningList.add("affymetrixtable");
					       
					   	try {
					        Class.forName("com.mysql.jdbc.Driver");
					    } catch (ClassNotFoundException e) {
					        // TODO Auto-generated catch block
					        e.printStackTrace();
					    } 

						Connection con = null;
				        Statement st = null;
				        ResultSet rs = null;
				        
				        

				        String url = "jdbc:mysql://127.0.0.1:3306/test";
				        String user = "root";
				        String password = "root";
				        
				        try {
							con = DriverManager.getConnection(url, user, password);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

				        try {
							st = con.createStatement();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					       
					       
				        int count2 =0;
					       
				        Iterator<String> iterclusterMap3 = clusterMap2.keySet().iterator(); 
				        
				        
				        while(iterclusterMap3.hasNext()){
				        	
				        		
				        		ArrayList<String> tripleList = new ArrayList<String>();
				        	   String key = iterclusterMap3.next();
					    	   
					    	   List<String> finallist = clusterMap2.get(key);
				        	
				      for(int m=0;m<finallist.size();m++){
				    	  
					       for(int i=0;i<runningList.size();i++) {
					    	   
					    	   String sql = "SELECT triple FROM " + runningList.get(i) + " WHERE alias = "+ "'" + finallist.get(m)+"'";
			
					    	 
					           try {
					        	   
					   		   ResultSet results = st.executeQuery(sql);
					   		
					   	
					   		 
					           while(results.next()){				              	
					            String triple = results.getString("triple");		
					          
					            	tripleList.add(triple);
					           }
					           
					           results.close();
					           
					           } catch (SQLException e) {
					   			// TODO Auto-generated catch block
					   			e.printStackTrace();
					   		}
					           
					   	}
				        }
				      
				      count2 = count2 + 1;
				      triplemap.put(count2, tripleList);
			    	}
				       
				        
				       
				        SortedMap<String, ArrayList<String>> templist = new TreeMap<String, ArrayList<String>>();
				    */    
					   
					   re.end();
				
			    	}	  
	     	        
		    
		    
		    
		 private static void writeCsv(String[][] csvMatrix,int indication,String filelocation) {

			 if(indication==0){
		        ICsvListWriter csvWriter = null;
		        try {
		            csvWriter = new CsvListWriter(new FileWriter(filelocation), 
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
			 else
			 {
				 ICsvListWriter csvWriter = null;
			        try {
			            csvWriter = new CsvListWriter(new FileWriter(filelocation), 
			                CsvPreference.STANDARD_PREFERENCE);

			            for (int i = 0; i < csvMatrix.length-1; i++) {
			           // 	log.info("csvMatrix: "+csvMatrix[i][1]);
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

		    }
		 
		 
		 
		 
		 
		 private static void writeCsv2(String[][] csvMatrix,String path) {

			 
		        ICsvListWriter csvWriter = null;
		        try {
		            csvWriter = new CsvListWriter(new FileWriter(path), 
		                CsvPreference.STANDARD_PREFERENCE);

		            
		            for (int i = 0; i < csvMatrix.length; i++) {
		            	//if(csvMatrix[i]!=null)
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
	   



	public void getSumDegree(SortedMap<String,Integer> iodegreeMap)
	{
		sumDegreeMap = iodegreeMap;
	}
	
	
	public void getMoreMap(SortedMap<String,List<String>> neighbourMap,SortedMap<String,List<String>> neighbourMap2,SortedMap<String,List<String>> neighbourMap3,SortedMap<String,List<String>> subMap,SortedMap<String,List<String>> objMap,SortedMap<String,Integer> nameNumMap1, SortedMap<Integer,String> nameNumMapReverse1,SortedMap<String,List<String>> soMap,SortedMap<String,List<String>> secondmap1, SortedMap<String,List<String>> thirdmap1)
	{
		neighbourMap1st = neighbourMap;
		neighbourMap2nd = neighbourMap2;
		neighbourMap3rd = neighbourMap3;
		predicateSubjMap = subMap;
		predicateObjMap = objMap;		
		nameNumMap = nameNumMap1;
		nameNumMapReverse = nameNumMapReverse1;
		subobjMap = soMap;
		secondmap = secondmap1;
		thirdmap = thirdmap1;
	}
	
	
	public void outcsvGeneration(String path, LinkedHashMap<String,List<String>> levelMap,String mark)
	{
		 //  String xlspath = path.split(".")[0]+".xls";
		String xlspath2 = path.replace(".csv", ".xlsx");
	    
     //  File inputWorkbook22 = new File(xlspath2);
     
	try {
		 FileInputStream inputWorkbook22 = new FileInputStream(new File(xlspath2));
		 XSSFWorkbook workbook = new XSSFWorkbook(inputWorkbook22);
		 XSSFSheet sheet = workbook.getSheetAt(0);
	
    	      int flag2=0;
    	      
    	      
    	   //   log.info("Size of clusterMap :"+level1Map.size() );
    	      
    	     // JOptionPane.showMessageDialog(null,"Size of clusterMap :"+level1Map.size());
    	   //  System.out.println("Size of clusterMap :"+level1Map.size());	
    	     Iterator<String> iterclusterMap4 = levelMap.keySet().iterator(); 
    	 	 while(iterclusterMap4.hasNext()){
    	 		 									    	 	
    	 		 List<Integer> absentList2 = new ArrayList<Integer>();
				 String key22 = iterclusterMap4.next();
					
		    	List<String> firstlist = levelMap.get(key22);
    	 		 
		    	Row row = sheet.getRow(0);
		    	
		    	log.info("cell:"+row.getPhysicalNumberOfCells());
		    	
		    	 for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) 
		                {
		                    Cell cell = row.getCell(j);					
		              
		                    String predicate = cell.getStringCellValue();  
		                  //  JOptionPane.showMessageDialog(null,"predicate :"+predicate);	
		                    String newpredicate="";
			    	          String newpredicate1="";
			    	          String newpredicate2="";
			    	          String newpredicate4="";
			    	          String newpredicate5="";
			    	          String newpredicate3 ="";
			    	          String newpredicate6 ="";
			    	          String newpredicate7 = "";


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
			    	           
			    	           if(newpredicate4.contains("(")){
	    							 newpredicate5 = newpredicate4.replaceAll("\\(", ".");
				    	           }
				    	           else
				    	           {
				    	        	   newpredicate5 =  newpredicate4;
				    	           }
			    	           
			    	           
			    	           if(newpredicate5.contains(")")){
	    							 newpredicate6 = newpredicate5.replaceAll("\\)", ".");

				    	           }
				    	           else
				    	           {
				    	        	   newpredicate6 =  newpredicate5;
				    	        	   
				    	           }
			    	           
			    	           if(newpredicate6.contains("%")){
	    							 newpredicate7 = newpredicate6.replaceAll("%", ".");

				    	           }
				    	           else
				    	           {
				    	        	   newpredicate7 =  newpredicate6;
				    	        	   
				    	           }
			    	           
			    	           if(newpredicate7.contains("~")){
			    	        	   newpredicate3 = newpredicate7.replaceAll("~", ".");
				    	           }
			    	           else
			    	           {
			    	        	   newpredicate3 = newpredicate7;
			    	           }
    							

    							
    						/*	for(int l=0;l<firstlist.size();l++)
    							{
    								JOptionPane.showMessageDialog(null,"predicate : "+firstlist.get(l));
    							}*/
    							
    						if(mark.equals("morethanone"))	{
    							if(!firstlist.contains(newpredicate3))
    							{
    								if(!absentList2.contains(j))
    								absentList2.add(j); 
    							}
    						}
    						
    							 

    							//j = j+1;
		                }
		            
		    	 
		    	 
		    	
		    	 
		    	// inputWorkbook22.close();
		   
    	      int a=1,b=1;
    	      String[][] csvMatrix = new String[firstlist.size()+1][firstlist.size()+1];
    	      
    	      log.info("firstlist size: "+firstlist.size());
    	      log.info("absent size: "+absentList2.size());
    	   //   log.info("csvMatrix Size: "+csvMatrix.length);
    	      
    	     // JOptionPane.showMessageDialog(null, "firstlist.size(): "+firstlist.size());
    	 //     JOptionPane.showMessageDialog(null, "sheet2.getColumns() " + sheet2.getColumns());	
    	   //   JOptionPane.showMessageDialog(null, "sheet2.getRows() " + sheet2.getRows());
    	      				    	 
    	    	 Row row2 = sheet.getRow(0);
    	    	 
    	    	 
    	    	//   JOptionPane.showMessageDialog(null, "row2: " + row2);
    	 //   	 JOptionPane.showMessageDialog(null,"row: " + sheet.getLastRowNum());		 
    	    //     JOptionPane.showMessageDialog(null,"col :"+row2.getPhysicalNumberOfCells());	
    	    	 
    	    		 for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
    	    			 
    	    		//	  JOptionPane.showMessageDialog(null,"col: " + row2.getPhysicalNumberOfCells());	
    	    			//  JOptionPane.showMessageDialog(null,"row: " + sheet.getLastRowNum());	
    	    			 b=1;
    	    			// log.info("absent: "+absentList2);
    	    			  if(absentList2.contains(j))
	    	    		  {
	    	    			  continue;							    	    			
	    	    		  }
    	    			  else
    	    			  {
    	    				  for (int i = 1; i <= sheet.getLastRowNum(); i++) {
    	    				  
    	    					  if(!absentList2.contains(i-1)){
    	    						  
    	    					
    	    						  
    	    						  switch (sheet.getRow(0).getCell(j).getCellType())
    	    						  {
    	    						    case Cell.CELL_TYPE_NUMERIC:
    	    						    	csvMatrix[0][a] = Double.toString(sheet.getRow(0).getCell(j).getNumericCellValue());
    	    						  //  	JOptionPane.showMessageDialog(null,"1.1: " + csvMatrix[0][a]);	
    	    						    	break;
    	    		                    case Cell.CELL_TYPE_STRING:
    	    		                    	  csvMatrix[0][a] = sheet.getRow(0).getCell(j).getStringCellValue();
    	    		                    		//JOptionPane.showMessageDialog(null,"1.2: " + csvMatrix[0][a]);	
    	    		                        break;
    	    						  }
    	    						  
    	    						  
    	    						  switch (sheet.getRow(0).getCell(i-1).getCellType())
    	    						  {
    	    						    case Cell.CELL_TYPE_NUMERIC:
    	    						    	 csvMatrix[b][0] = Double.toString(sheet.getRow(0).getCell(i-1).getNumericCellValue());   
    	    						    	//	JOptionPane.showMessageDialog(null,"2.1: " + csvMatrix[b][0]);	
    	    		                        break;
    	    		                    case Cell.CELL_TYPE_STRING:
    	    		                    	 csvMatrix[b][0] = sheet.getRow(0).getCell(i-1).getStringCellValue();   
    	    		                    	// JOptionPane.showMessageDialog(null,"2.2: " + csvMatrix[b][0]);	
    	    		                    	// log.info("2.2: " + csvMatrix[b][0]+"======"+(i-1));
    	    		                        break;
    	    						  }
    	    						  
    	    						  switch (sheet.getRow(i).getCell(j).getCellType())
    	    						  {
    	    						    case Cell.CELL_TYPE_NUMERIC:
    	    						    	 csvMatrix[b][a] = Double.toString(sheet.getRow(i).getCell(j).getNumericCellValue());
    	    						    //	 JOptionPane.showMessageDialog(null,"3.1: " + csvMatrix[b][a]);	
    	    		                        break;
    	    		                    case Cell.CELL_TYPE_STRING:
    	    		                    	csvMatrix[b][a] =  sheet.getRow(i).getCell(j).getStringCellValue(); 
    	    		                    	// JOptionPane.showMessageDialog(null,"3.2: " + csvMatrix[b][a]);	
    	    		                    //	log.info("3.2: " + csvMatrix[b][a]);
    	    		                        break;
    	    						  }
    	    						  
    	    						/*  csvMatrix[0][a] = Double.toString(sheet.getRow(0).getCell(j).getNumericCellValue());
					    	    	  csvMatrix[b][0] = Double.toString(sheet.getRow(0).getCell(i-1).getNumericCellValue());   
					    	    	  csvMatrix[b][a] = Double.toString(sheet.getRow(i).getCell(j).getNumericCellValue());*/
					    	    	  
					    	    	//  JOptionPane.showMessageDialog(null, csvMatrix[0][a]);
					    	    	//  JOptionPane.showMessageDialog(null, csvMatrix[b][0]);
					    	    	  //JOptionPane.showMessageDialog(null, csvMatrix[b][a]);
					    	    	  b=b+1;
					    	    	 
    	    					  }  
    	    				  }
    	    				  a=a+1;
    	    			  }
    	    			  
    	    			  
    	    		 }
    	    		 
    	    		

    	    		
    	    		 
    	    	//	 JOptionPane.showMessageDialog(null,"a: " + a);	

    	     // JOptionPane.showMessageDialog(null, "Finish Matrix");	
    	      
    	    
    	      
    	  //!    if(level==1){
    	      
//    	      	  String fileString = csvList.get(0);
//    	    	  csvList.remove(fileString);
//    	          
    	   //   log.info("csvMatrix: "+csvMatrix.length+"*********outCSV/out_"+key22.split(":")[0]+".csv");
    	    
    	    		// log.info("outCSV/out_"+key22.split(":")[0]+".csv");
    	    		 log.info("name:"+"outCSV/out_"+key22.split(":")[0]+".csv");
    	      writeCsv2(csvMatrix,"outCSV/out_"+key22.split(":")[0]+".csv");
    	  //!    }

    	      }
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
System.out.println( "Error1: "+e.toString());	
} catch (Exception e)
{
System.out.println("Error2: "+e.toString());	
e.printStackTrace();
}		

	}
	
	
	public void levelMatrixGeneration(String path, LinkedHashMap<String,List<String>> levelMap,String mark)
	{
	    int flag=0;					    	   
	       String xlspath = path.replace(".csv", ".xlsx");
	     
	       
		try {
			FileInputStream inputWorkbook22 = new FileInputStream(new File(xlspath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputWorkbook22);
			 XSSFSheet sheet = workbook.getSheetAt(0);

	    	      int flag2=0;
	    	      				    	   	
	    	     Iterator<String> iterclusterMap4 = levelMap.keySet().iterator(); 
	    	 	 while(iterclusterMap4.hasNext()){
	    	 		 				
	    	 		  	
	    	 	
	    	 		 List<Integer> absentList2 = new ArrayList<Integer>();
					 String key22 = iterclusterMap4.next();
						

			    	List<String> firstlist = levelMap.get(key22);
	    	 		 
			    	Row row = sheet.getRow(0);
			    	
			       
			    	 for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) 
			                {
			                    Cell cell = row.getCell(j);					                  
			                    String predicate = cell.getStringCellValue();  
			                    String newpredicate="";
				    	          String newpredicate1="";
				    	          String newpredicate2="";
				    	          String newpredicate4="";
				    	          String newpredicate5="";
				    	          String newpredicate6="";
				    	          String newpredicate3 ="";
				    	          String newpredicate7 = "";

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
				    	           
				    	           if(newpredicate4.contains("(")){
		    							 newpredicate5 = newpredicate4.replaceAll("\\(", ".");
					    	           }
					    	           else
					    	           {
					    	        	   newpredicate5 =  newpredicate4;
					    	           }
				    	           
				    	           
				    	           if(newpredicate5.contains(")")){
		    							 newpredicate6 = newpredicate5.replaceAll("\\)", ".");
					    	        	   log.info(newpredicate6);

					    	           }
					    	           else
					    	           {
					    	        	   newpredicate6 =  newpredicate5;
					    	        	   
					    	           }
				    	           
				    	           if(newpredicate6.contains("%")){
		    							 newpredicate7 = newpredicate6.replaceAll("%", ".");

					    	           }
					    	           else
					    	           {
					    	        	   newpredicate7 =  newpredicate6;
					    	        	   
					    	           }
				    	           
				    	           if(newpredicate7.contains("~")){
				    	        	   newpredicate3 = newpredicate7.replaceAll("~", ".");
					    	           }
				    	           else
				    	           {
				    	        	   newpredicate3 = newpredicate7;
				    	           }
	    					
	    							
	    							
				    	           if(mark.equals("morethanone"))	{
		    							if(!firstlist.contains(newpredicate3))
		    							{
		    								absentList2.add(j); 
		    							}
		    						}
	    						
			                }
			            
			    	 
	    	      int a=0,b=0;
	    	      
	    	      if(firstlist.contains("http...bio2rdf.org.pharmgkb_vocabulary.x.."))
	    	      {
	    	    	  firstlist.remove("http...bio2rdf.org.pharmgkb_vocabulary.x..");
	    	      }
	    	      
	    	      String[][] csvMatrix = new String[firstlist.size()+1][firstlist.size()];
	    	      					   				    	     
	    	 
	    	    	 Row row2 = sheet.getRow(0);
	    	    		 
	    	    		 for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
	    	    			  b=1;
	    	    			  if(absentList2.contains(j))
		    	    		  {
		    	    			  continue;
		    	    		  }
	    	    			  else
	    	    			  {
	    	    				  for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	    	    				  
	    	    					  
	    	    					  if(!absentList2.contains(i-1)){
	    	    						  
	    	    						  switch (sheet.getRow(0).getCell(j).getCellType())
	    	    						  {
	    	    						    case Cell.CELL_TYPE_NUMERIC:
	    	    						    	csvMatrix[0][a] = Double.toString(sheet.getRow(0).getCell(j).getNumericCellValue());
	    	    		                        break;
	    	    		                    case Cell.CELL_TYPE_STRING:
	    	    		                    	  csvMatrix[0][a] = sheet.getRow(0).getCell(j).getStringCellValue();
	    	    		                        break;
	    	    						  }
	    	    						  					    	    						  					    	    						
	    	    						  
	    	    						  switch (sheet.getRow(i).getCell(j).getCellType())
	    	    						  {
	    	    						    case Cell.CELL_TYPE_NUMERIC:
	    	    						    	 csvMatrix[b][a] = Double.toString(sheet.getRow(i).getCell(j).getNumericCellValue());
	    	    		                        break;
	    	    		                    case Cell.CELL_TYPE_STRING:
	    	    		                    	csvMatrix[b][a] =  sheet.getRow(i).getCell(j).getStringCellValue();   
	    	    		                        break;
	    	    						  }
						    	    	  b=b+1;
	    	    					  }  
	    	    				  }
	    	    				  a=a+1;
	    	    			  }
	    	    		 }
	    	      
			    	      log.info("firstlist : "+firstlist.size());
			    	      
			    	      	 FileWriter fw0 = null;
		    	    		 BufferedWriter bw0 = null;
							 String content0 = "Size:"+firstlist.size()+"\n\n";
							// clusterLevel2=clusterLevel2+1;
		    	    		 for(int f=0;f<firstlist.size();f++)
		    	    		 {
		    	    			 try {
		    	    					File clusterfile = new File("clusters/cluster_"+key22.split(":")[0]);
		    	    		 
		    	    					// if file doesnt exists, then create it
		    	    					if (!clusterfile.exists()) {
		    	    						clusterfile.createNewFile();
		    	    					}
		    	    		 
		    	    					 fw0 = new FileWriter(clusterfile.getAbsoluteFile());
		    	    					 bw0 = new BufferedWriter(fw0);
		    	    					 content0 = content0 + firstlist.get(f)+"\n";
		    	    					
		    	    		 
		    	    					System.out.println("Done");
		    	    		 
		    	    				} catch (IOException e) {
		    	    					e.printStackTrace();
		    	    				}
		    	    		 }
		    	    		 bw0.write(content0);
 	    				 bw0.close();
			    	      
			    	      

			    	   //   JOptionPane.showMessageDialog(null,"level 2 firstlist : "+firstlist.size());

	    	    		// System.out.println("level 2 firstlist : "+firstlist.size());

			    	      int indication = 0;
			    	      log.info("levelResults/matrix_"+key22.split(":")[0]+".csv");
			    	      writeCsv(csvMatrix,indication,"levelResults/matrix_"+key22.split(":")[0]+".csv");
			    	      
		    	    	/*!!	 if(null==csvMatrix[csvMatrix.length-1][1])
		    	    		 {
		    	    			 log.info("MLGB:"+csvMatrix[csvMatrix.length-1][1]);
		    	    			 indication=1;
		    	    		 }!!*/

	    	      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( e.toString());	
		} catch (Exception e)
     {
         e.printStackTrace();
         System.out.println(e.toString());	
     }
	}
	
	
	
	static <K,V extends Comparable<? super V>> 
    List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {
List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

Collections.sort(sortedEntries, 
    new Comparator<Entry<K,V>>() {
        public int compare(Entry<K,V> e1, Entry<K,V> e2) {
            return e2.getValue().compareTo(e1.getValue());
        }
    }
);

return sortedEntries;
}
	

	}



	class TextConsole5 implements RMainLoopCallbacks
	{
	    public void rWriteConsole(Rengine re, String text, int oType) {
	        System.out.print(text);
	    }
	    
	    public void rBusy(Rengine re, int which) {
	        System.out.println("rBusy("+which+")");
	    }
	    
	    public String rReadConsole(Rengine re, String prompt, int addToHistory) {
	        System.out.print(prompt);
	        try {
	            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            String s=br.readLine();
	            return (s==null||s.length()==0)?s:s+"\n";
	        } catch (Exception e) {
	            System.out.println("jriReadConsole exception: "+e.getMessage());
	        }
	        return null;
	    }
	    
	    public void rShowMessage(Rengine re, String message) {
	        System.out.println("rShowMessage \""+message+"\"");
	    }
		
	    public String rChooseFile(Rengine re, int newFile) {
//		FileDialog fd = new FileDialog(new Frame(), (newFile==0)?"Select a file":"Select a new file", (newFile==0)?FileDialog.LOAD:FileDialog.SAVE);
//		fd.show();
		String res=null;
//		if (fd.getDirectory()!=null) res=fd.getDirectory();
//		if (fd.getFile()!=null) res=(res==null)?fd.getFile():(res+fd.getFile());
		return res;
	    }
	    
	    public void   rFlushConsole (Rengine re) {
	    }
		
	    public void   rLoadHistory  (Rengine re, String filename) {
	    }			
	    
	    public void   rSaveHistory  (Rengine re, String filename) {
	    }			
	}


