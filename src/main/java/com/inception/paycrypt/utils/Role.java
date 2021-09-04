package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum class for users roles
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum Role {

	/**
	 * Administration Role
	 */
	ADMIN("Administrator"),

	/**
	 * User role
	 */
	USER("User");

	/**
	 * Description of the roles
	 */
	private final String description;
}
