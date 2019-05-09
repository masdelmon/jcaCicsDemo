/*
 * Copyright 2002-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javaworld.jca;

/**
 * Class representing the datas of a customer.
 * 
 * @author Thierry Templier
 */
public class Customer {
	private int customerId;
	private String customerLastName;
	private String customerFirstName;

	/**
	 * Constructor of the class.
	 */
	public Customer(int customerId,String customerLastName,String customerFirstName) {
		this.customerId=customerId;
		this.customerLastName=customerLastName;
		this.customerFirstName=customerFirstName;
	}

	/**
	 * Return the first name of the customer
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * Return the identifier of the customer
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Return the last name of the customer
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * Specify the first name of the customer
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * Specify the identifier of the customer
	 */
	public void setCustomerId(int customerId ) {
		this.customerId = customerId ;
	}

	/**
	 * Specify the last name of the customer
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

}
