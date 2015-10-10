package com.zakoraio.reviews.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

@Controller
public class SearchController {
	
	@RequestMapping(value = "/searchResult.htm",method = RequestMethod.GET)
	public @ResponseBody String search(@RequestParam String query) throws InterruptedException 
	{
		 String hostname = "user.palmetto.clemson.edu";
		/* 
         String username = "lmuthu";

         String password = "Breeze!24";*/

         
         String username = "saurabr";

         String password = "Raggirsauaji2@";
         
         String result = "";

         String stemmedQuery ="";
         
         String token="";
         try

         {
        	     StringTokenizer tokens = new StringTokenizer(query);
        	     while(tokens.hasMoreTokens()){
        	    	 token = stemIt(tokens.nextToken());
        	    	 stemmedQuery+= token+" ";
        	     }
                 Connection conn = new Connection(hostname);

                 conn.connect();

                 boolean isAuthenticated = conn.authenticateWithPassword(username, password);

                 if (isAuthenticated == false)

                         throw new IOException("Authentication failed.");


                 Session sess = conn.openSession();

                sess.execCommand("cd myHadoopJob1/extract;java QueryWriter \""+stemmedQuery.trim()+"\";cd ..;qsub runHadoopSearch.pbs");

                 InputStream stdout = new StreamGobbler(sess.getStdout());

                 BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
                 while (true)
                 {
                         String line = br.readLine();
                         if (line == null)
                                 break;
                         System.out.println(line);

                 }
                 System.out.println("ExitCode: " + sess.getExitStatus());
                 sess.close();
                 conn.close();
                 boolean created = false;
                 Thread.sleep(120000);
                 while(true){
                 	conn = new Connection(hostname);
                 	 
                     conn.connect();

                     isAuthenticated = conn.authenticateWithPassword(username, password);

                     if (isAuthenticated == false)

                             throw new IOException("Authentication failed.");

                 	sess = conn.openSession();
                 	sess.execCommand("cd myHadoopJob1/search;ls");
                 	stdout = new StreamGobbler(sess.getStdout());
                 	 
                     br = new BufferedReader(new InputStreamReader(stdout));
                             String line = br.readLine();
                             if(line == null){
                             	created = false;
                             }
                             else{
                             created = true;
                             }
                     if( created == true){
                     	break;
                     }
                     else{
                     	Thread.sleep(5000);
                     }
                 	sess.close();
                 	conn.close();
                 }
                 conn.close();
                 sess.close();
                 Thread.sleep(1000);
                 conn = new Connection(hostname);
            	 
                 conn.connect();

                 isAuthenticated = conn.authenticateWithPassword(username, password);

                 if (isAuthenticated == false)

                         throw new IOException("Authentication failed.");

                 sess = conn.openSession();
                 
                 sess.execCommand("cd myHadoopJob1/extract;ls;java FileDataExtractor ../search/result.txt " +
                 		"/newscratch/saurabrHadoop/txtdata/");

                 stdout = new StreamGobbler(sess.getStdout());

                 br = new BufferedReader(new InputStreamReader(stdout));
                 while (true)
                 {
                         String line = br.readLine();
                         if (line == null)
                                 break;
                        result+=line;

                 }
                 sess.close();
                 
                 conn.close();



         }

         catch (IOException e)

         {

                 e.printStackTrace(System.err);

                 System.exit(2);

         }
         return result;

	}

	
	@RequestMapping(value = "/search.htm",method=RequestMethod.GET)
	public ModelAndView search() 
	{
		return new ModelAndView("search","command", "nothing");
	}
	
	private static String stemIt(String word){
		 char[] w = new char[501];
	     Stemmer s = new Stemmer();
		 char arr[] = word.toCharArray();
		 String stemmedWord = null;
		 for(int i=0;i<arr.length;)

	    {  int ch = arr[i];i++;
	       if (Character.isLetter((char) ch))
	       {
	          int j = 0;
	          while(true)
	          {  ch = Character.toLowerCase((char) ch);
	             w[j] = (char) ch;
	             if (j < 500) j++;
	             if(i<arr.length){
	             ch = arr[i];i++;
	             }
	             else
	             {
	            	
	                for (int c = 0; c < j; c++) s.add(w[c]);


	                s.stem();
	                {  String u;

	                   u = s.toString();

	                   stemmedWord =  u;
	                }
	                break;
	             }
	          }
	       }
	       if (ch < 0) break;
	    }
		 return stemmedWord;
	}
	 

}
