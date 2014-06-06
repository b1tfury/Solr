package Examples;

import java.io.IOException;
import java.util.Scanner;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class InputSolr {

	private static final String urlString = "http://localhost:8983/solr"; //declaring the url on which Solr server is running 
	 private SolrServer solrServer; //creating a SolrServer Instance
	 
	 /**
	  * making the constructor for creating the connection for solar server 
	  * and I'm also deleting everything on the server.
	 * @throws IOException 
	 * @throws SolrServerException 
	  */
	 public InputSolr() throws SolrServerException, IOException{
		 solrServer =  new HttpSolrServer(urlString); //creating the connection
		 solrServer.deleteByQuery("*:*"); // deleting everything on the server 
		 
	 }
	 
	 public void addInput() throws SolrServerException, IOException{
		 Scanner in = new Scanner(System.in);
		 SolrInputDocument doc = new SolrInputDocument();//creating the instance of input document for solr
		 System.out.print("id: ");
		 doc.addField("id", in.next());//adding the 'id' field (it the the required field so you must add
		 System.out.println("\n Country name: ");
		 doc.addField("cname", in.next());//adding the 'cname' field 
		 solrServer.add(doc); // adding the doc in the Solr Server
		 solrServer.commit();// flushing the values
		 
	 }
	
	public static void main(String[] args) throws SolrServerException, IOException {
		
		InputSolr input = new InputSolr(); // creating the object for the class and also instantiating the constructor
		input.addInput();
	}

}
