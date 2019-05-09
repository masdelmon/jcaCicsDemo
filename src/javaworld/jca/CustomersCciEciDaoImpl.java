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

import java.io.IOException;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jca.cci.core.support.CciDaoSupport;

/**
 * 
 * @author Thierry Templier
 */
public class CustomersCciEciDaoImpl extends CciDaoSupport implements CustomersCciEciDao {

	public Customer getCustomer(final int customerId) {
		ECIMappingOperation operation =
			new ECIMappingOperation(getConnectionFactory(), "CUSTPROG", 55) {
			protected byte[] objectToBytes(Object customerId)
							throws IOException, DataRetrievalFailureException {
				String tmp = (String.valueOf((Integer) customerId));
				return tmp.getBytes();
			}

			protected Object bytesToObject(byte[] bytes)
							throws IOException, DataRetrievalFailureException {
				String chaine = new String(bytes);
				int customerId = Integer.parseInt(chaine.substring(0, 5));
				String customerLastName=chaine.substring(5, 30);
				customerLastName=customerLastName.trim();
				String customerFirstName=chaine.substring(30, 55);
				customerFirstName=customerFirstName.trim();
				Customer customer = new Customer(customerId,
									customerLastName,customerFirstName);
				return customer;
			}
		};
		return (Customer) operation.execute(new Integer(customerId));
	}
}
