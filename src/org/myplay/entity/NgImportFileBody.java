package org.myplay.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NgImportFileBody entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "ng_import_file_body")
public class NgImportFileBody implements java.io.Serializable {

	// Fields    

	private String id;
	private String v1;
	private String v2;
	private String v3;
	private String v4;
	private String v5;
	private String v6;
	private String v7;
	private String v8;
	private String v9;
	private String v10;
	private String v11;
	private String v12;
	private String v13;
	private String v14;
	private String v15;
	private String v16;
	private String v17;
	private String v18;
	private String v19;
	private String v20;
	private String v21;
	private String v22;
	private String v23;
	private String v24;
	private String v25;
	private String v26;
	private String v27;
	private String v28;
	private String v29;
	private String v30;
	private String v31;
	private String v32;
	private String v33;
	private String v34;
	private String v35;
	private String v36;
	private String v37;
	private String v38;
	private String v39;
	private String v40;
	private String v41;
	private String v42;
	private String v43;
	private String v44;
	private String v45;
	private String v46;
	private String v47;
	private String v48;
	private String v49;
	private String v50;
	private String v51;
	private String v52;
	private String v53;
	private String v54;
	private String v55;
	private String v56;
	private String v57;
	private String v58;
	private String v59;
	private String v60;
	private String v61;
	private String v62;
	private String v63;
	private String v64;
	private String v65;
	private String v66;
	private String v67;
	private String v68;
	private String v69;
	private String v70;
	private String v71;
	private String v72;
	private String v73;
	private String v74;
	private String v75;
	private String v76;
	private String v77;
	private String v78;
	private String v79;
	private String v80;
	private String fileId;
	private Integer seq;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public NgImportFileBody() {
	}

	/** minimal constructor */
	public NgImportFileBody(String id) {
		this.id = id;
	}

	/** full constructor */
	public NgImportFileBody(String id, String v1, String v2, String v3, String v4, String v5, String v6, String v7,
			String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15, String v16,
			String v17, String v18, String v19, String v20, String v21, String v22, String v23, String v24, String v25,
			String v26, String v27, String v28, String v29, String v30, String v31, String v32, String v33, String v34,
			String v35, String v36, String v37, String v38, String v39, String v40, String v41, String v42, String v43,
			String v44, String v45, String v46, String v47, String v48, String v49, String v50, String v51, String v52,
			String v53, String v54, String v55, String v56, String v57, String v58, String v59, String v60, String v61,
			String v62, String v63, String v64, String v65, String v66, String v67, String v68, String v69, String v70,
			String v71, String v72, String v73, String v74, String v75, String v76, String v77, String v78, String v79,
			String v80, String fileId, Integer seq, Timestamp createTime) {
		this.id = id;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
		this.v7 = v7;
		this.v8 = v8;
		this.v9 = v9;
		this.v10 = v10;
		this.v11 = v11;
		this.v12 = v12;
		this.v13 = v13;
		this.v14 = v14;
		this.v15 = v15;
		this.v16 = v16;
		this.v17 = v17;
		this.v18 = v18;
		this.v19 = v19;
		this.v20 = v20;
		this.v21 = v21;
		this.v22 = v22;
		this.v23 = v23;
		this.v24 = v24;
		this.v25 = v25;
		this.v26 = v26;
		this.v27 = v27;
		this.v28 = v28;
		this.v29 = v29;
		this.v30 = v30;
		this.v31 = v31;
		this.v32 = v32;
		this.v33 = v33;
		this.v34 = v34;
		this.v35 = v35;
		this.v36 = v36;
		this.v37 = v37;
		this.v38 = v38;
		this.v39 = v39;
		this.v40 = v40;
		this.v41 = v41;
		this.v42 = v42;
		this.v43 = v43;
		this.v44 = v44;
		this.v45 = v45;
		this.v46 = v46;
		this.v47 = v47;
		this.v48 = v48;
		this.v49 = v49;
		this.v50 = v50;
		this.v51 = v51;
		this.v52 = v52;
		this.v53 = v53;
		this.v54 = v54;
		this.v55 = v55;
		this.v56 = v56;
		this.v57 = v57;
		this.v58 = v58;
		this.v59 = v59;
		this.v60 = v60;
		this.v61 = v61;
		this.v62 = v62;
		this.v63 = v63;
		this.v64 = v64;
		this.v65 = v65;
		this.v66 = v66;
		this.v67 = v67;
		this.v68 = v68;
		this.v69 = v69;
		this.v70 = v70;
		this.v71 = v71;
		this.v72 = v72;
		this.v73 = v73;
		this.v74 = v74;
		this.v75 = v75;
		this.v76 = v76;
		this.v77 = v77;
		this.v78 = v78;
		this.v79 = v79;
		this.v80 = v80;
		this.fileId = fileId;
		this.seq = seq;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "v1")
	public String getV1() {
		return this.v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}

	@Column(name = "v2")
	public String getV2() {
		return this.v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}

	@Column(name = "v3")
	public String getV3() {
		return this.v3;
	}

	public void setV3(String v3) {
		this.v3 = v3;
	}

	@Column(name = "v4")
	public String getV4() {
		return this.v4;
	}

	public void setV4(String v4) {
		this.v4 = v4;
	}

	@Column(name = "v5")
	public String getV5() {
		return this.v5;
	}

	public void setV5(String v5) {
		this.v5 = v5;
	}

	@Column(name = "v6")
	public String getV6() {
		return this.v6;
	}

	public void setV6(String v6) {
		this.v6 = v6;
	}

	@Column(name = "v7")
	public String getV7() {
		return this.v7;
	}

	public void setV7(String v7) {
		this.v7 = v7;
	}

	@Column(name = "v8")
	public String getV8() {
		return this.v8;
	}

	public void setV8(String v8) {
		this.v8 = v8;
	}

	@Column(name = "v9")
	public String getV9() {
		return this.v9;
	}

	public void setV9(String v9) {
		this.v9 = v9;
	}

	@Column(name = "v10")
	public String getV10() {
		return this.v10;
	}

	public void setV10(String v10) {
		this.v10 = v10;
	}

	@Column(name = "v11")
	public String getV11() {
		return this.v11;
	}

	public void setV11(String v11) {
		this.v11 = v11;
	}

	@Column(name = "v12")
	public String getV12() {
		return this.v12;
	}

	public void setV12(String v12) {
		this.v12 = v12;
	}

	@Column(name = "v13")
	public String getV13() {
		return this.v13;
	}

	public void setV13(String v13) {
		this.v13 = v13;
	}

	@Column(name = "v14")
	public String getV14() {
		return this.v14;
	}

	public void setV14(String v14) {
		this.v14 = v14;
	}

	@Column(name = "v15")
	public String getV15() {
		return this.v15;
	}

	public void setV15(String v15) {
		this.v15 = v15;
	}

	@Column(name = "v16")
	public String getV16() {
		return this.v16;
	}

	public void setV16(String v16) {
		this.v16 = v16;
	}

	@Column(name = "v17")
	public String getV17() {
		return this.v17;
	}

	public void setV17(String v17) {
		this.v17 = v17;
	}

	@Column(name = "v18")
	public String getV18() {
		return this.v18;
	}

	public void setV18(String v18) {
		this.v18 = v18;
	}

	@Column(name = "v19")
	public String getV19() {
		return this.v19;
	}

	public void setV19(String v19) {
		this.v19 = v19;
	}

	@Column(name = "v20")
	public String getV20() {
		return this.v20;
	}

	public void setV20(String v20) {
		this.v20 = v20;
	}

	@Column(name = "v21")
	public String getV21() {
		return this.v21;
	}

	public void setV21(String v21) {
		this.v21 = v21;
	}

	@Column(name = "v22")
	public String getV22() {
		return this.v22;
	}

	public void setV22(String v22) {
		this.v22 = v22;
	}

	@Column(name = "v23")
	public String getV23() {
		return this.v23;
	}

	public void setV23(String v23) {
		this.v23 = v23;
	}

	@Column(name = "v24")
	public String getV24() {
		return this.v24;
	}

	public void setV24(String v24) {
		this.v24 = v24;
	}

	@Column(name = "v25")
	public String getV25() {
		return this.v25;
	}

	public void setV25(String v25) {
		this.v25 = v25;
	}

	@Column(name = "v26")
	public String getV26() {
		return this.v26;
	}

	public void setV26(String v26) {
		this.v26 = v26;
	}

	@Column(name = "v27")
	public String getV27() {
		return this.v27;
	}

	public void setV27(String v27) {
		this.v27 = v27;
	}

	@Column(name = "v28")
	public String getV28() {
		return this.v28;
	}

	public void setV28(String v28) {
		this.v28 = v28;
	}

	@Column(name = "v29")
	public String getV29() {
		return this.v29;
	}

	public void setV29(String v29) {
		this.v29 = v29;
	}

	@Column(name = "v30")
	public String getV30() {
		return this.v30;
	}

	public void setV30(String v30) {
		this.v30 = v30;
	}

	@Column(name = "v31")
	public String getV31() {
		return this.v31;
	}

	public void setV31(String v31) {
		this.v31 = v31;
	}

	@Column(name = "v32")
	public String getV32() {
		return this.v32;
	}

	public void setV32(String v32) {
		this.v32 = v32;
	}

	@Column(name = "v33")
	public String getV33() {
		return this.v33;
	}

	public void setV33(String v33) {
		this.v33 = v33;
	}

	@Column(name = "v34")
	public String getV34() {
		return this.v34;
	}

	public void setV34(String v34) {
		this.v34 = v34;
	}

	@Column(name = "v35")
	public String getV35() {
		return this.v35;
	}

	public void setV35(String v35) {
		this.v35 = v35;
	}

	@Column(name = "v36")
	public String getV36() {
		return this.v36;
	}

	public void setV36(String v36) {
		this.v36 = v36;
	}

	@Column(name = "v37")
	public String getV37() {
		return this.v37;
	}

	public void setV37(String v37) {
		this.v37 = v37;
	}

	@Column(name = "v38")
	public String getV38() {
		return this.v38;
	}

	public void setV38(String v38) {
		this.v38 = v38;
	}

	@Column(name = "v39")
	public String getV39() {
		return this.v39;
	}

	public void setV39(String v39) {
		this.v39 = v39;
	}

	@Column(name = "v40")
	public String getV40() {
		return this.v40;
	}

	public void setV40(String v40) {
		this.v40 = v40;
	}

	@Column(name = "v41")
	public String getV41() {
		return this.v41;
	}

	public void setV41(String v41) {
		this.v41 = v41;
	}

	@Column(name = "v42")
	public String getV42() {
		return this.v42;
	}

	public void setV42(String v42) {
		this.v42 = v42;
	}

	@Column(name = "v43")
	public String getV43() {
		return this.v43;
	}

	public void setV43(String v43) {
		this.v43 = v43;
	}

	@Column(name = "v44")
	public String getV44() {
		return this.v44;
	}

	public void setV44(String v44) {
		this.v44 = v44;
	}

	@Column(name = "v45")
	public String getV45() {
		return this.v45;
	}

	public void setV45(String v45) {
		this.v45 = v45;
	}

	@Column(name = "v46")
	public String getV46() {
		return this.v46;
	}

	public void setV46(String v46) {
		this.v46 = v46;
	}

	@Column(name = "v47")
	public String getV47() {
		return this.v47;
	}

	public void setV47(String v47) {
		this.v47 = v47;
	}

	@Column(name = "v48")
	public String getV48() {
		return this.v48;
	}

	public void setV48(String v48) {
		this.v48 = v48;
	}

	@Column(name = "v49")
	public String getV49() {
		return this.v49;
	}

	public void setV49(String v49) {
		this.v49 = v49;
	}

	@Column(name = "v50")
	public String getV50() {
		return this.v50;
	}

	public void setV50(String v50) {
		this.v50 = v50;
	}

	@Column(name = "v51")
	public String getV51() {
		return this.v51;
	}

	public void setV51(String v51) {
		this.v51 = v51;
	}

	@Column(name = "v52")
	public String getV52() {
		return this.v52;
	}

	public void setV52(String v52) {
		this.v52 = v52;
	}

	@Column(name = "v53")
	public String getV53() {
		return this.v53;
	}

	public void setV53(String v53) {
		this.v53 = v53;
	}

	@Column(name = "v54")
	public String getV54() {
		return this.v54;
	}

	public void setV54(String v54) {
		this.v54 = v54;
	}

	@Column(name = "v55")
	public String getV55() {
		return this.v55;
	}

	public void setV55(String v55) {
		this.v55 = v55;
	}

	@Column(name = "v56")
	public String getV56() {
		return this.v56;
	}

	public void setV56(String v56) {
		this.v56 = v56;
	}

	@Column(name = "v57")
	public String getV57() {
		return this.v57;
	}

	public void setV57(String v57) {
		this.v57 = v57;
	}

	@Column(name = "v58")
	public String getV58() {
		return this.v58;
	}

	public void setV58(String v58) {
		this.v58 = v58;
	}

	@Column(name = "v59")
	public String getV59() {
		return this.v59;
	}

	public void setV59(String v59) {
		this.v59 = v59;
	}

	@Column(name = "v60")
	public String getV60() {
		return this.v60;
	}

	public void setV60(String v60) {
		this.v60 = v60;
	}

	@Column(name = "v61")
	public String getV61() {
		return this.v61;
	}

	public void setV61(String v61) {
		this.v61 = v61;
	}

	@Column(name = "v62")
	public String getV62() {
		return this.v62;
	}

	public void setV62(String v62) {
		this.v62 = v62;
	}

	@Column(name = "v63")
	public String getV63() {
		return this.v63;
	}

	public void setV63(String v63) {
		this.v63 = v63;
	}

	@Column(name = "v64")
	public String getV64() {
		return this.v64;
	}

	public void setV64(String v64) {
		this.v64 = v64;
	}

	@Column(name = "v65")
	public String getV65() {
		return this.v65;
	}

	public void setV65(String v65) {
		this.v65 = v65;
	}

	@Column(name = "v66")
	public String getV66() {
		return this.v66;
	}

	public void setV66(String v66) {
		this.v66 = v66;
	}

	@Column(name = "v67")
	public String getV67() {
		return this.v67;
	}

	public void setV67(String v67) {
		this.v67 = v67;
	}

	@Column(name = "v68")
	public String getV68() {
		return this.v68;
	}

	public void setV68(String v68) {
		this.v68 = v68;
	}

	@Column(name = "v69")
	public String getV69() {
		return this.v69;
	}

	public void setV69(String v69) {
		this.v69 = v69;
	}

	@Column(name = "v70")
	public String getV70() {
		return this.v70;
	}

	public void setV70(String v70) {
		this.v70 = v70;
	}

	@Column(name = "v71")
	public String getV71() {
		return this.v71;
	}

	public void setV71(String v71) {
		this.v71 = v71;
	}

	@Column(name = "v72")
	public String getV72() {
		return this.v72;
	}

	public void setV72(String v72) {
		this.v72 = v72;
	}

	@Column(name = "v73")
	public String getV73() {
		return this.v73;
	}

	public void setV73(String v73) {
		this.v73 = v73;
	}

	@Column(name = "v74")
	public String getV74() {
		return this.v74;
	}

	public void setV74(String v74) {
		this.v74 = v74;
	}

	@Column(name = "v75")
	public String getV75() {
		return this.v75;
	}

	public void setV75(String v75) {
		this.v75 = v75;
	}

	@Column(name = "v76")
	public String getV76() {
		return this.v76;
	}

	public void setV76(String v76) {
		this.v76 = v76;
	}

	@Column(name = "v77")
	public String getV77() {
		return this.v77;
	}

	public void setV77(String v77) {
		this.v77 = v77;
	}

	@Column(name = "v78")
	public String getV78() {
		return this.v78;
	}

	public void setV78(String v78) {
		this.v78 = v78;
	}

	@Column(name = "v79")
	public String getV79() {
		return this.v79;
	}

	public void setV79(String v79) {
		this.v79 = v79;
	}

	@Column(name = "v80")
	public String getV80() {
		return this.v80;
	}

	public void setV80(String v80) {
		this.v80 = v80;
	}

	@Column(name = "file_id", length = 36)
	public String getFileId() {
		return this.fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Column(name = "seq")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}