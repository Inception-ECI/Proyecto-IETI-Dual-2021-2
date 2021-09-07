package com.inception.paycrypt.model;

import java.util.Date;

import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.utils.Country;
import com.inception.paycrypt.utils.DocumentType;
import com.inception.paycrypt.utils.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User class - That is used as Document for MongoDB
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Document
@NoArgsConstructor
public class User {

	/**
	 * The user identifier
	 */
	@Id
	private String id;

	/**
	 * The user document type
	 */
	private DocumentType documentType;

	/**
	 * The user document number
	 */
	private int documentNumber;

	/**
	 * The user email
	 */
	@Indexed(unique = true)
	private String email;

	/**
	 * The user password hashed
	 */
	private String password;

	/**
	 * The user state
	 */
	private State state;

	/**
	 * The user phone
	 */
	private String phone;

	/**
	 * The user country
	 */
	private Country country;

	/**
	 * The user creation date
	 */
	private Date creationDate;

	/**
	 * The user modification date
	 */
	private Date modificationDate;

	/**
	 * Constructor used to map a UserDto to a User class
	 *
	 * @param userDto The {@link UserDto} to be mapped
	 */
	public User(UserDto userDto) {

		this.documentType = userDto.getDocumentType();
		this.documentNumber = userDto.getDocumentNumber();
		this.email = userDto.getEmail();
		this.password = userDto.getPassword();
		this.phone = userDto.getPhone();
		this.country = userDto.getCountry();
		this.creationDate = new Date();
		this.modificationDate = new Date();
	}

	/**
	 * Update the information of the user
	 *
	 * @param userDto The {@link UserDto} that contains the new information
	 */
	public void updateUserInfo(UserDto userDto) {

		this.documentType = userDto.getDocumentType();
		this.documentNumber = userDto.getDocumentNumber();
		this.email = userDto.getEmail();
		this.phone = userDto.getPhone();
		this.country = userDto.getCountry();
		this.modificationDate = new Date();
	}

	/**
	 * Update the user password
	 *
	 * @param newPassword The old User password
	 * @param oldPassword The new password to be set
	 * @return if the change was made
	 */
	public boolean updatePassword(String newPassword, String oldPassword) {

		boolean canChangePassword = false;

		if (this.password.equals(oldPassword)) {
			this.password = newPassword;
			canChangePassword = true;
		}

		return canChangePassword;
	}

}