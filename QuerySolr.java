package Examples;

import java.io.IOException;
import java.util.Scanner;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

public class QuerySolr {
	

	private static final String urlString = "http://localhost:8983/solr"; //declaring the url on which Solr server is running 
	 private SolrServer solrServer; //creating a SolrServer Instance
	
	public QuerySolr() throws SolrServerException, IOException{ //creating the constructor
		 solrServer =  new HttpSolrServer(urlString); //creating the connection
	}
	
	public QueryResponse Getquery( String queryString) throws SolrServerException{
		SolrQuery query = new SolrQuery();//creating a object for SolrQuery class
		query.setQuery(queryString);//setting the query
		QueryResponse queryrepso = solrServer.query(query); //creating and using the object of QueryResponse class to get query response
		return queryrepso;
		
		
	}
	
	
	
	public static void main(String[] args) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		QuerySolr query = new QuerySolr(); //creating object of this class and calling the constructor
		System.out.println("Enter the query: ");
		QueryResponse qeryrespo = query.Getquery(in.next()); //taking input of the query
		System.out.println("The response is :- "+qeryrespo); 
	}

}
