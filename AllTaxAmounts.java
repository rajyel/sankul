package com.sankul.ptax;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AllTaxAmounts {

	public static void main(String[] args) {
		int x = 2149000;

		for (int i = 0; i < 269 ; i++)
		{
		 try {
		      int str = ++x;
			//  String tmp = "https://propertytax.punecorporation.org/PropPaidDetail.aspx?property_type=O&section_id=4&peth_id=02&property_acct_no=0"+str+"&Flag=1";
		      String tmp = "https://propertytax.punecorporation.org/prop_tax_bill_print_all.aspx?strPropID=O/4/02/0"+str;
		    //  System.out.println(tmp);
		      //https://propertytax.punecorporation.org/prop_tax_bill_print_all.aspx?strPropID=O/4/02/02149268
		      //   Document doc = Jsoup.connect("https://propertytax.punecorporation.org/PropPaidDetail.aspx?property_type=O&section_id=4&peth_id=02&property_acct_no=02149001&Flag=1").get();
			  Document doc = Jsoup.connect(tmp).get();
		      Elements documents = doc.select("span");
		      for (Element docd : documents) {
		        String localstr = (String) docd.id();
		    	if(localstr != null && localstr.equals("lbl_propertytaxno") )
		       	{
		       		System.out.print("^" +(String) docd.text());
		       	}
		        if(localstr != null && localstr.equals("lbl_name") )
		        {
		        	System.out.print("^" +(String) docd.text());
		        }
		       	if(localstr != null && localstr.equals("lbl_address") )
		       	{
		       		System.out.print("^" +(String) docd.text());
		       	}
		       
		       	
		       	if(localstr != null && localstr.equals("lbl_Cur_Dmd") )
		       	{
		       		System.out.println("^" +(String) docd.text());
		       	}
		       	
		      }
		 /*      Elements links = doc.select("a[href]");
               String paidStatus = "NOT PAID";
		       for (Element link : links) {
		        //  System.out.println("Href: " + link.attr("href"));
		    	   String mystr = link.attr("href");
		    	  // System.out.println(mystr);
		    	   if(mystr.contains("PaidDetails.aspx?Year=2020_2"))
		    	   {
		    		   paidStatus ="PAID";
		          //System.out.println("Text: " + mystr);
		    	   }
		       }
		       System.out.println("^" +paidStatus);
		   */    
		    
		    } catch (IOException e) {
		    e.printStackTrace();
		    }
		 
	}

	}

}
