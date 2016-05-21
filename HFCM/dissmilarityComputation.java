package HFCM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 public class dissmilarityComputation {
	
	 static public void main (String args[])
	{
		BufferedReader br = null;

		try {

			String sCurrentLine;
			
			int count=0;

			
			//1:0.61, 2:0.52, 3:0.3, 4:0.67, 5:0.34, 6: 0.84
			//order: 3,5,2,1,4,6
		//!!	br = new BufferedReader(new FileReader("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Drugbank2/Confusion Matrix for each topic/out6-Special3level.csv"));

			br = new BufferedReader(new FileReader("/Users/feichenshen/Dropbox/Feichen -- Research/PhD/0-Dissertation Material/JBS 2015/Results/Drugbank2/K-means results/csv/out8.csv"));

			
			double temp = 0;
			int size = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				
				if(count==0)
				{
					count=count+1;
					continue;
				}
				else
				{
					
					String arr[] = sCurrentLine.split(",");
					size = arr.length-1;
					for(int i=0;i<arr.length;i++)
					{
						if(arr[i].contains("http"))
						{
							continue;
						}
						else
						{	//System.out.println(arr[i]);
							temp = temp+Double.parseDouble(arr[i]);
						}
						//System.out.println(arr[i]);
					}
				}
				
				
			}
			
			System.out.println("temp: "+temp);
			System.out.println("size: "+size);

			
			double dissmilarityScore = temp/(size*size-size);
			System.out.println("dis score: "+dissmilarityScore);
			

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
