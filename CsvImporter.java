package Examples;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;

import com.csvreader.CsvReader;

public class CsvImporter {
	private static final String urlString = "http://localhost:8983/solr";
	private SolrServer solrServer;

	public  CsvImporter() throws SolrServerException, IOException {
		if (solrServer == null) {
			System.out.println("sahil");
			solrServer = new HttpSolrServer(urlString);
			solrServer.deleteByQuery("*:*");
		}
	}

	public void addDocument(String csvFileName) throws IOException, SolrServerException
	{
		CsvReader items = new CsvReader(csvFileName);
		items.readHeaders();
		while(items.readRecord()){
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", items.get(0));
			doc.addField("cname", items.get(1));
			doc.addField("fname", items.get(2));
		   solrServer.add(doc);

				 
		}
		   solrServer.commit();

		
	}
	
	
	public static void main(String[] args) throws IOException, SolrServerException {
		// TODO Auto-generated method stub
		CsvImporter csv = new CsvImporter();
		csv.addDocument(args[0]);
		System.out.println("File is dumped");
		


	}

}
