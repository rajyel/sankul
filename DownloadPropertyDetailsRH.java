package com.sankul.ptax;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloadPropertyDetailsRH {

	public static void main(String[] args) {
		int x = 998000;

	for (int i = 0; i < 100 ; i++)
		{
		 try {
		      int str = ++x;
			  String tmp = "https://propertytax.punecorporation.org/PropPaidDetail.aspx?property_type=O&section_id=4&peth_id=03&property_acct_no=00"+str+"&Flag=1";
		   //   Document doc = Jsoup.connect("https://propertytax.punecorporation.org/PropPaidDetail.aspx?property_type=O&section_id=4&peth_id=02&property_acct_no=02149001&Flag=1").get();
			  Document doc = Jsoup.connect(tmp).get();
		      Elements documents = doc.select("span");
		      for (Element docd : documents) {
		        String localstr = (String) docd.id();
		        if(localstr != null && localstr.equals("ContentPlaceHolder1_lblPid") )
		        {
		        	System.out.print((String) docd.text());
		        }
		       	if(localstr != null && localstr.equals("ContentPlaceHolder1_lblcurrName") )
		       	{
		       		System.out.print("^" +(String) docd.text());
		       	}
		       	if(localstr != null && localstr.equals("ContentPlaceHolder1_lblAddress") )
		       	{
		       		System.out.print("^" +(String) docd.text());
		       	}
		   
		      }
		       Elements links = doc.select("a[href]");
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
		       
		    
		    } catch (IOException e) {
		    e.printStackTrace();
		    }
		 
	}

	}

}
