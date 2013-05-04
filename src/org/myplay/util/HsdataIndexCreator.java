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
public class HsdataIndexCreator {
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
			ps = conn.prepareStatement("select * from cls_hscodes");
			rs = ps.executeQuery();
			while (rs.next()) {
				String ret = rs.getString("GNAME") + " ";
				ret += rs.getString("PRODUCT_DESCRIPTION") + " ";
				
				Document document = new Document();
				
				Field fContent = new Field("content", ret, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS);
				Field fType = new Field("MATCH_TYPE", "1", Field.Store.YES, Field.Index.NO);	// ģ���ѯ
				Field fProductCode = new Field("CHAPTER", rs.getString("CHAPTER"), Field.Store.YES, Field.Index.NO);
				Field fHsCode = new Field("HSCODE", rs.getString("HSCODE"), Field.Store.YES, Field.Index.NO);
				Field fLegalExamine = new Field("LEGAL_EXAMINE", rs.getString("LEGAL_EXAMINE"), Field.Store.YES, Field.Index.NO);
				Field fTaxcode = new Field("TAXCODE", rs.getString("TAXCODE"), Field.Store.YES, Field.Index.NO);
				Field fSubTaxcode = new Field("SUB_TAXCODE", rs.getString("SUB_TAXCODE"), Field.Store.YES, Field.Index.NO);
				Field fGname = new Field("GNAME", rs.getString("GNAME"), Field.Store.YES, Field.Index.NO);
				Field fBestTaxrate = new Field("BEST_TAXRATE", rs.getString("BEST_TAXRATE"), Field.Store.YES, Field.Index.NO);
				Field fCommonTaxrate = new Field("COMMON_TAX_RATE", rs.getString("COMMON_TAX_RATE"), Field.Store.YES, Field.Index.NO);
				Field fValueAddTaxrate = new Field("VALUE_ADD_TAXRATE", rs.getString("VALUE_ADD_TAXRATE"), Field.Store.YES, Field.Index.NO);
				Field fFirstLaw = new Field("FIRST_LAW", rs.getString("FIRST_LAW"), Field.Store.YES, Field.Index.NO);
				Field fSecondLaw = new Field("SECOND_LAW", rs.getString("SECOND_LAW"), Field.Store.YES, Field.Index.NO);
				Field fControlCondition = new Field("CONTROL_CONDITION", rs.getString("CONTROL_CONDITION"), Field.Store.YES, Field.Index.NO);
				Field fProductDescription = new Field("PRODUCT_DESCRIPTION", rs.getString("PRODUCT_DESCRIPTION"), Field.Store.YES, Field.Index.NO);
				Field fDeclareationItems = new Field("DECLAREATION_ITEMS", rs.getString("DECLAREATION_ITEMS"), Field.Store.YES, Field.Index.NO);
				Field fProductSampleCheck = new Field("PRODUCT_SAMPLE_CHECK", rs.getString("PRODUCT_SAMPLE_CHECK"), Field.Store.YES, Field.Index.NO);
				
				document.add(fContent);
				document.add(fType);
				document.add(fProductCode);
				document.add(fHsCode);
				document.add(fLegalExamine);
				document.add(fTaxcode);
				document.add(fSubTaxcode);
				document.add(fGname);
				document.add(fBestTaxrate);
				document.add(fCommonTaxrate);
				document.add(fValueAddTaxrate);
				document.add(fFirstLaw);
				document.add(fSecondLaw);
				document.add(fControlCondition);
				document.add(fProductDescription);
				document.add(fDeclareationItems);
				document.add(fProductSampleCheck);
				
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