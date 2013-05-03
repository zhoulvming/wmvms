package org.myplay.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.myplay.util.EncryptUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the user_ database table.
 * 
 */
@Entity
@Table(name = "user_")
public class User extends BaseEntityBean implements Serializable {
	private static final String DEFAULT_PASSWORD = "111111";

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(// 关联表
	name = "users_roles", // 关联表名
	inverseJoinColumns = @JoinColumn(name = "roleId"),// 被维护端外键
	joinColumns = @JoinColumn(name = "userId"))
	private Set<Role> roles = new HashSet<Role>();
	// 维护端外键
	private String userId;
	private int agreedToTermsOfUse;

	@Lob
	private String comments;

	private BigInteger companyId;

	private BigInteger contactId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte defaultUser;

	private String digest;
	@GridColumn(text = "E-MAIL", seq = 3, hidden = false, searchable = true)
	private String emailAddress;
	private byte emailAddressVerified;

	private BigInteger facebookId;
	private int failedLoginAttempts;
	@GridColumn(text = "姓名", seq = 4, hidden = false, searchable = true)
	private String firstName;
	private int graceLoginCount;

	private String greeting;

	private String jobTitle;

	private String languageId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastFailedLoginDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;
	private String lastLoginIP;

	private String lastName;

	private byte lockout;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lockoutDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date loginDate;

	private String loginIP;

	private String middleName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	private String openId;

	
	private String password;

	private byte passwordEncrypted;

	@Temporal(TemporalType.TIMESTAMP)
	private Date passwordModifiedDate;

	private byte passwordReset;

	private BigInteger portraitId;
	private String reminderQueryAnswer;
	private String reminderQueryQuestion;
	@GridColumn(text = "用户名称", seq = 2, hidden = false, searchable = true)
	private String screenName;

	private int status;
	private String timeZoneId;

	@Transient
	private String plainPassword;
	@Transient
	private String salt;

	// 不持久化到数据库，也不显示在Restful接口的属性.
	@Transient
	@JsonIgnore
	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	// @Id
	// @Column(name="uuid_")
	// private String id;

	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAgreedToTermsOfUse() {
		return this.agreedToTermsOfUse;
	}

	public void setAgreedToTermsOfUse(int agreedToTermsOfUse) {
		this.agreedToTermsOfUse = agreedToTermsOfUse;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigInteger getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(BigInteger companyId) {
		this.companyId = companyId;
	}

	public BigInteger getContactId() {
		return this.contactId;
	}

	public void setContactId(BigInteger contactId) {
		this.contactId = contactId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getDefaultUser() {
		return this.defaultUser;
	}

	public void setDefaultUser(byte defaultUser) {
		this.defaultUser = defaultUser;
	}

	public String getDigest() {
		return this.digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public byte getEmailAddressVerified() {
		return this.emailAddressVerified;
	}

	public void setEmailAddressVerified(byte emailAddressVerified) {
		this.emailAddressVerified = emailAddressVerified;
	}

	public BigInteger getFacebookId() {
		return this.facebookId;
	}

	public void setFacebookId(BigInteger facebookId) {
		this.facebookId = facebookId;
	}

	public int getFailedLoginAttempts() {
		return this.failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGraceLoginCount() {
		return this.graceLoginCount;
	}

	public void setGraceLoginCount(int graceLoginCount) {
		this.graceLoginCount = graceLoginCount;
	}

	public String getGreeting() {
		return this.greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public Date getLastFailedLoginDate() {
		return this.lastFailedLoginDate;
	}

	public void setLastFailedLoginDate(Date lastFailedLoginDate) {
		this.lastFailedLoginDate = lastFailedLoginDate;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIP() {
		return this.lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getLockout() {
		return this.lockout;
	}

	public void setLockout(byte lockout) {
		this.lockout = lockout;
	}

	public Date getLockoutDate() {
		return this.lockoutDate;
	}

	public void setLockoutDate(Date lockoutDate) {
		this.lockoutDate = lockoutDate;
	}

	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIP() {
		return this.loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Access(AccessType.PROPERTY)
	@Column(name = "password_")
	public String getPassword() {
		if (this.password==null||this.password.equals("")) {
			return EncryptUtils.encryptMD5(DEFAULT_PASSWORD);

		} else {

			return this.password;
		}
		//

	}

	public void setPassword(String password) {
		// password=EncryptUtils.encryptMD5(DEFAULT_PASSWORD);
		this.password = password;
	}

	public byte getPasswordEncrypted() {
		return this.passwordEncrypted;
	}

	public void setPasswordEncrypted(byte passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public Date getPasswordModifiedDate() {
		return this.passwordModifiedDate;
	}

	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		this.passwordModifiedDate = passwordModifiedDate;
	}

	public byte getPasswordReset() {
		return this.passwordReset;
	}

	public void setPasswordReset(byte passwordReset) {
		this.passwordReset = passwordReset;
	}

	public BigInteger getPortraitId() {
		return this.portraitId;
	}

	public void setPortraitId(BigInteger portraitId) {
		this.portraitId = portraitId;
	}

	public String getReminderQueryAnswer() {
		return this.reminderQueryAnswer;
	}

	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		this.reminderQueryAnswer = reminderQueryAnswer;
	}

	public String getReminderQueryQuestion() {
		return this.reminderQueryQuestion;
	}

	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		this.reminderQueryQuestion = reminderQueryQuestion;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTimeZoneId() {
		return this.timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}