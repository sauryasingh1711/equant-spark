/*
 * @author Saurya Singh
 *
 */
package kfkproducer;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class CustomPartitioner implements Partitioner {
	public CustomPartitioner(VerifiableProperties props) {

	}

	public int partition(Object key, int a_numPartitions) {
		int partition = 0;
		String stringKey = (String) key;
		int offset = stringKey.lastIndexOf('.');
		if (offset > 0) {
			partition = Integer.parseInt(stringKey.substring(offset + 1))
					% a_numPartitions;
		}
		return partition;
	}

}

