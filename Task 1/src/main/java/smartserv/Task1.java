package smartserv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import smartserv.model.Product;

public class Task1 {
	
	public static void main(String[] args)
	{
			
			try {
				ObjectMapper Reader = new ObjectMapper();
				InputStream input = new FileInputStream(new File("/Users/trishagupta/Downloads/SmartServTask1.json"));
				TypeReference<List<Product>> typeref = new TypeReference<List<Product>>() {};
				int[] array=new int[1000];
				String[] sub = new String[1000];
				String[] t = new String[1000];
				int[] pr = new int[1000];
				int i=0, temp,temp2;
				String temp1, temp3;
				List<Product> products = Reader.readValue(input, typeref);
				for(Product p: products)
				{
					array[i]=p.getPopularity();
					sub[i]=p.getSubcategory();
					pr[i]=p.getPrice();
					t[i]=p.getTitle();
					i++;
				}
				for (int k = 0; k < array.length; k++) {     
		            for (int j = k+1; j < array.length; j++) {     
		               if(array[k] < array[j]) {    
		                   temp = array[k];
		                   temp1 = sub[k];
		                   temp2 = pr[k];
		                   temp3 = t[k];
		                   array[k] = array[j];
		                   sub[k] = sub[j];
		                   t[k] = t[j];
		                   pr[k] = pr[j];
		                   array[j] = temp;
		                   sub[j] = temp1;
		                   pr[j] = temp2;
		                   t[j] = temp3;
		                   
		               }     
		            }     
		        }    
				/*for(Product p: products) {
					System.out.println("Under subcategory "+p.getSubcategory()+", the price of "+p.getTitle()+" is "+p.getPrice()+" and its popularity is "+p.getPopularity());
				}*/
				for(int j=0;j<1000;j++)
				{
					System.out.print(sub[j]+" ");
					System.out.print(t[j]+" ");
					System.out.print(pr[j]+" ");
					System.out.println(array[j]);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


				
	}
	public static void Sorted(int popularity)
	{
		
	}
}