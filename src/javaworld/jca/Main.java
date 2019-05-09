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

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class is the entry point of the example. It executes a CICS operation
 * basing a DAO.
 * 
 * @author Thierry Templier
 */
public class Main {

	/**
	 * Entry point to execute the CICS operation.
	 */
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
			CustomersCciEciDao customersCciEciDao = (CustomersCciEciDao)context.getBean("customersCciEciDao");
			Customer customer = customersCciEciDao.getCustomer(1);
			showCustomerInformations(customer);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method to show the informations of a customer.
	 * 
	 * @param customer the customer
	 */
	private static void showCustomerInformations(Customer customer) {
		System.out.println("Show the customer informations:");
		System.out.println("  Identifier: "+customer.getCustomerId());
		System.out.println("  First name: "+customer.getCustomerFirstName());
		System.out.println("  Last name: "+customer.getCustomerLastName());
	}
}
