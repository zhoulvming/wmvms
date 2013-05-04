package org.myplay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;
import com.itgodo.common.ConnHelper;

/**
 * author lighter date 2006-8-7
 */
public class PreClsIndexCreator {
	public static void main(String[] args) throws Exception {
		CreatePredefinedIndex();
	}

	public static String FileReaderAll(String FileName, String charset) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileName), charset));
		String line = new String();
		String temp = new String();

		while ((line = reader.readLine()) != null) {
			temp += line;
		}
		reader.close();
		return temp;
	}

	public static void CreatePredefinedIndex() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		File fileDir = new File("D:\\Projects\\TestCenter\\TestSearch\\filetoindex");
		IndexWriter indexWriter = null;
		try {
			Analyzer luceneAnalyzer = new ComplexAnalyzer();//(Version.LUCENE_34);
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_34, luceneAnalyzer);
			indexWriter = new IndexWriter(FSDirectory.open(fileDir), iwc);

			conn = ConnHelper.getConnection3();
			ps = conn.prepareStatement("select * from cls_pre_category_prod");
			rs = ps.executeQuery();
			while (rs.next()) {
				String ret = rs.getString("COMPOSITION") + " ";
				ret += rs.getString("CN_COMPOSITION") + " ";
				ret += rs.getString("STYLE_DESCRIPTION") + " ";
				ret += rs.getString("CN_DESCRIPTION") + " ";
				ret += rs.getString("PRODUCT_CODE") + " ";

				Document document = new Document();
				
				Field fContent = new Field("content", ret, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS);
				Field fType = new Field("MATCH_TYPE", "0", Field.Store.YES, Field.Index.NO);	// Ԥ����
				Field fCompanyName = new Field("COMPANY_NAME", rs.getString("COMPANY_NAME"), Field.Store.YES, Field.Index.NO);
				Field fProductCode = new Field("PRODUCT_CODE", rs.getString("COMMODITY_CODE"), Field.Store.YES, Field.Index.NO);
				Field fStyleDescription = new Field("STYLE_DESCRIPTION", rs.getString("STYLE_DESCRIPTION"), Field.Store.YES, Field.Index.NO);
				Field fCnDescription = new Field("CN_DESCRIPTION", rs.getString("CN_DESCRIPTION"), Field.Store.YES, Field.Index.NO);
				Field fComposition = new Field("COMPOSITION", rs.getString("COMPOSITION"), Field.Store.YES, Field.Index.NO);
				Field fCnComposition = new Field("CN_COMPOSITION", rs.getString("CN_COMPOSITION"), Field.Store.YES, Field.Index.NO);
				Field fCommodityCode = new Field("COMMODITY_CODE", rs.getString("COMMODITY_CODE"), Field.Store.YES, Field.Index.NO);
				Field fRates = new Field("RATES", rs.getString("RATES"), Field.Store.YES, Field.Index.NO);
				Field fCountryCode = new Field("COUNTRY_CODE", rs.getString("COUNTRY_CODE"), Field.Store.YES, Field.Index.NO);
				Field fCnCountryName = new Field("CN_COUNTRY_NAME", rs.getString("CN_COUNTRY_NAME"), Field.Store.YES, Field.Index.NO);
				Field fCertificates = new Field("CERTIFICATES", rs.getString("CERTIFICATES"), Field.Store.YES, Field.Index.NO);
				
				document.add(fContent);
				document.add(fType);
				document.add(fCompanyName);
				document.add(fProductCode);
				document.add(fStyleDescription);
				document.add(fCnDescription);
				document.add(fComposition);
				document.add(fCnComposition);
				document.add(fCommodityCode);
				document.add(fRates);
				document.add(fCountryCode);
				document.add(fCnCountryName);
				document.add(fCertificates);
				
				indexWriter.addDocument(document);
				System.out.println(ret);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				indexWriter.optimize();
				indexWriter.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}