package myentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account 
{
	@Id
	@Column(name="id")
	private int acnumber;
	
	@Column(name="accnm")
	private String acname;
	
	@Column(name="acctype")
	private String actype;
	
	@Column(name="balance")
	private String balamount;
	
	public int getAcnumber() {
		return acnumber;
	}
	public void setAcnumber(int acnumber) {
		this.acnumber = acnumber;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getActype() {
		return actype;
	}
	public void setActype(String actype) {
		this.actype = actype;
	}
	public String getBalamount() {
		return balamount;
	}
	public void setBalamount(String balamount) {
		this.balamount = balamount;
	}
	
	

}
