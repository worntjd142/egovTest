package member.service;

public class MemberVO {

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", pass=" + pass + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", tel=" + tel + ", address=" + address + "]";
	}
	private String userid;
	private String pass;
	private String name;
	private String gender;
	private String birth;
	private String tel;
	private String address;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
