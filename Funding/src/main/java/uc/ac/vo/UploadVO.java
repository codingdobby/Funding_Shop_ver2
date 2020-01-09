package uc.ac.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class UploadVO {

	private int project_num;
	private String ptitle;
	private String pcontent;
	private int pmoney;
	private int totMoney;
	private String id_fk;
	private String pdate;
	private int pVerify;
	private Timestamp regdate;
	private String ppic1;
	private String pDetail_img;
	private int phit;
	private String nickname;
	private String pCategory;
	
	
	
	public int getProject_num() {
		return project_num;
	}
	public void setProject_num(int project_num) {
		this.project_num = project_num;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPmoney() {
		return pmoney;
	}
	public void setPmoney(int pmoney) {
		this.pmoney = pmoney;
	}
	public int getTotMoney() {
		return totMoney;
	}
	public void setTotMoney(int totMoney) {
		this.totMoney = totMoney;
	}
	public String getId_fk() {
		return id_fk;
	}
	public void setId_fk(String id_fk) {
		this.id_fk = id_fk;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getpVerify() {
		return pVerify;
	}
	public void setpVerify(int pVerify) {
		this.pVerify = pVerify;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getPpic1() {
		return ppic1;
	}
	public void setPpic1(String ppic1) {
		this.ppic1 = ppic1;
	}
	public String getpDetail_img() {
		return pDetail_img;
	}
	public void setpDetail_img(String pDetail_img) {
		this.pDetail_img = pDetail_img;
	}
	public int getPhit() {
		return phit;
	}
	public void setPhit(int phit) {
		this.phit = phit;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	


}
