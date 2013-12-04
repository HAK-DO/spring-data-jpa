package com.hedleyproctor.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity(name = "account")
@SecondaryTables({ @SecondaryTable(name = "signon", pkJoinColumns = @PrimaryKeyJoinColumn(name = "email", referencedColumnName = "email")), @SecondaryTable(name = "profile", pkJoinColumns = @PrimaryKeyJoinColumn(name = "email", referencedColumnName = "email")) })
@NamedQueries({ @NamedQuery(name = "Account.getAccountByUsername", query = "select a from account a where a.email = :email"), @NamedQuery(name = "Account.getAccountByUsernameAndPassword", query = "select a from account a where a.email = :email and a.password = :password") })
public class Account extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 5892174125806724316L;
	
	@Id
	@Column(name = "email",length = 80, unique = true, nullable = false)
	private String email;


	@Column(name = "firstname", length = 80)
	private String firstName;

	@Column(name = "lastname", length = 80)
	private String lastName;

	@Column(length = 2)
	private String status;

	@Column(name = "addr1", length = 80)
	private String address1;

	@Column(name = "addr2", length = 40)
	private String address2;

	@Column(length = 80)
	private String city;

	@Column(length = 80)
	private String state;

	@Column(length = 20)
	private String zip;

	@Column(length = 20)
	private String country;

	@Column(length = 80)
	private String phone;

	// signon table
	@Column(table = "signon", length = 25)
	private String password;

	// profile table
	@Column(table = "profile", name = "langpref", length = 80)
	private String languagePreference;

	@Column(table = "profile", name = "favcategory", length = 30)
	private String favouriteCategoryId;

	@Column(table = "profile", name = "mylistopt")
	private boolean listOption;

	@Column(table = "profile", name = "banneropt")
	private boolean bannerOption;

	// bannerdata table
	@Nullable
	@ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "favcategory", referencedColumnName = "favcategory")
	private BannerData bannerData;

	public Account() {
	}

	public Account(String username, String password, String firstName, String lastName) {
		checkNotNull(username, "Argument[username] must not be null");
		// this.username = username;
		this.email = username;
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getEmail() {
		return email;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		checkNotNull(firstName, "Argument[firstName] must not be null");
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		checkNotNull(lastName, "Argument[lastName] must not be null");
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	@Nonnull
	public String getPassword() {
		return password;
	}

	public void setPassword(@Nonnull final String password) {
		checkNotNull(password, "Argument[password] must not be null");
		this.password = password;
	}

	public String getLanguagePreference() {
		return languagePreference;
	}

	public void setLanguagePreference(final String languagePreference) {
		this.languagePreference = languagePreference;
	}

	@Nullable
	public String getFavouriteCategoryId() {
		return (bannerData != null) ? bannerData.getFavouriteCategoryId() : null;
	}

	public boolean isListOption() {
		return listOption;
	}

	public void setListOption(final boolean listOption) {
		this.listOption = listOption;
	}

	public boolean isBannerOption() {
		return bannerOption;
	}

	public void setBannerOption(final boolean bannerOption) {
		this.bannerOption = bannerOption;
	}

	@Nullable
	public BannerData getBannerData() {
		return (bannerData != null) ? new BannerData(bannerData.getFavouriteCategoryId(), bannerData.getBannerName()) : null;
	}

	public void setBannerData(@Nullable final BannerData bannerData) {
		if (bannerData != null) {
			this.bannerData = new BannerData(bannerData.getFavouriteCategoryId(), bannerData.getBannerName());
			this.favouriteCategoryId = this.bannerData.getFavouriteCategoryId();
		}
	}

	@Nullable
	public String getBannerName() {
		return (bannerData != null) ? bannerData.getBannerName() : null;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
