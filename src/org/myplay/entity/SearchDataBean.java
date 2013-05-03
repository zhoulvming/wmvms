package org.myplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.si.core.ui.GridColumn;

/**
 * @author elgs
 * 
 */
//@Entity
//@XmlRootElement
//@Table(name = "cls_pre_db_compact")
public class SearchDataBean {
	// HS CODE properties

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	private String id;
	@Column(name = "PRODUCT_CODE")
	@GridColumn(text = "料号", seq = 10)
	private String prodCode;
	@Column(name = "HSCODE")
	@GridColumn(text = "HSCODE", seq = 20)
	private String hsCode;
	@Column(name = "GNAME")
	@GridColumn(text = "GNAME", width = 200, seq = 30)
	private String gName;
	@Column(name = "GUNIT")
	@GridColumn(text = "申报单位", width = 80, seq = 40)
	private String gunit;
	@Column(name = "UNIT_1")
	@GridColumn(text = "第一单位", width = 80, seq = 40)
	private String unit1;
	@Column(name = "UNIT_2")
	@GridColumn(text = "第二单位", width = 80, seq = 50)
	private String unit2;
	@Column(name = "CONTROL_MA")
	@GridColumn(text = "涉证", width = 50, seq = 60)
	private String controlMa;
	@Column(name = "DECLARATION_ITEMS_VALUES")
	@GridColumn(text = "申报内容", width = 200, seq = 70)
	private String declarationItemsValues;
	@Column(name = "CODE_T")
	private String codeT;
	@Column(name = "CODE_S")
	private String codeS;
	@Column(name = "GOOD_NAME_CN")
	private String goodNameCn;
	@Column(name = "GOOD_NAME_EN")
	private String goodNameEn;
	@Column(name = "TRADE_NAME")
	private String tradeName;
	@Column(name = "OWNER_NAME")
	private String ownerName;
	
	@Column(name = "MATCH1")
	private String match1;
	@Column(name = "MATCH2")
	private String match2;
	@Column(name = "NAME1")
	private String name1;
	@Column(name = "NAME2")
	private String name2;
	@Column(name = "SIMILAR_PRODUCT_ID")
	private String similarProductId;
	
	transient private String suggestHscodes;

	transient private String matchType;
	
	transient private String goodModelCn;

	public String getSuggestHscodes() {
		return suggestHscodes;
	}

	public void setSuggestHscodes(String suggestHscodes) {
		this.suggestHscodes = suggestHscodes;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getGoodNameCn() {
		return goodNameCn;
	}

	public void setGoodNameCn(String goodNameCn) {
		this.goodNameCn = goodNameCn;
	}

	public String getGoodNameEn() {
		return goodNameEn;
	}

	public void setGoodNameEn(String goodNameEn) {
		this.goodNameEn = goodNameEn;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCodeT() {
		return codeT;
	}

	public void setCodeT(String codeT) {
		this.codeT = codeT;
	}

	public String getCodeS() {
		return codeS;
	}

	public void setCodeS(String codeS) {
		this.codeS = codeS;
	}

	public String getDeclarationItemsValues() {
		return declarationItemsValues;
	}

	public void setDeclarationItemsValues(String declarationItemsValues) {
		this.declarationItemsValues = declarationItemsValues;
	}

	public String getUnit1() {
		return unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public String getUnit2() {
		return unit2;
	}

	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}

	public String getControlMa() {
		return controlMa;
	}

	public void setControlMa(String controlMa) {
		this.controlMa = controlMa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getGunit() {
		return gunit;
	}

	public void setGunit(String gunit) {
		this.gunit = gunit;
	}

	public String getMatch1() {
		return match1;
	}

	public void setMatch1(String match1) {
		this.match1 = match1;
	}

	public String getMatch2() {
		return match2;
	}

	public void setMatch2(String match2) {
		this.match2 = match2;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getSimilarProductId() {
		return similarProductId;
	}

	public void setSimilarProductId(String similarProductId) {
		this.similarProductId = similarProductId;
	}

	public String getGoodModelCn() {
		return goodModelCn;
	}

	public void setGoodModelCn(String goodModelCn) {
		this.goodModelCn = goodModelCn;
	}

}
