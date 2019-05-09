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

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.jca.cci.core.support.CommAreaRecord;
import org.springframework.jca.cci.object.MappingCommAreaOperation;

import com.ibm.connector2.cics.ECIInteractionSpec;

/**
 * 
 * @author Thierry Templier
 */
public abstract class ECIMappingOperation extends MappingCommAreaOperation {

	public ECIMappingOperation(ConnectionFactory connectionFactory,
							String programName,int responseLength) {
		setConnectionFactory(connectionFactory);
		ECIInteractionSpec interactionSpec = new ECIInteractionSpec();
		interactionSpec.setFunctionName(programName);
		interactionSpec.setCommareaLength(responseLength);
		doSetInteractionVerb(interactionSpec);
		setInteractionSpec(interactionSpec);
		setOutputRecordCreator(new ECIOutputRecordCreator());
	}

	private void doSetInteractionVerb(ECIInteractionSpec interactionSpec) {
		try {
			interactionSpec.setInteractionVerb(
				ECIInteractionSpec.SYNC_SEND_RECEIVE);
		} catch (ResourceException ex) {
			ex.printStackTrace();
		}
	}

	private class ECIOutputRecordCreator implements RecordCreator {
		public Record createRecord(RecordFactory recordFactory)
			throws ResourceException, DataAccessException {
			return new CommAreaRecord();
		}
	}
}
