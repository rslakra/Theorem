/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.datastructure.queue;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-06 08:54:06 AM
 * @version 1.0.0
 * @since 1.0.0
 */
public class QueueDemo {

	/**
	 * 
	 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
	 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
	 * @created 2018-01-06 03:32:51 PM
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	static class TrainCoach implements Comparable<TrainCoach> {

		int id;
		String coachType;

		public TrainCoach(int id, String coachType) {
			this.id = id;
			this.coachType = coachType;
		}

		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(TrainCoach trainCoach) {
			if (trainCoach != null) {
				int result = id - trainCoach.id;
				if (result == 0) {
					return coachType.compareTo(trainCoach.coachType);
				} else {
					return result;
				}
			}

			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> queue = null;
		queue = QueueFactory.getQueueFor(QueueType.ARRAY_QUEUE);
		// queue = QueueFactory.getQueueFor(QueueType.LIST_QUEUE);
		// queue = QueueFactory.getQueueFor(QueueType.LINKED_LIST_QUEUE);
		System.out.println(queue);

		for (int i = 0; i < 16; i++) {
			queue.add((i + 1));
		}

		System.out.println(queue);
		System.out.println("size:" + queue.size());

		queue.offer(10);
		System.out.println(queue);
		System.out.println("size:" + queue.size());

		queue.remove();
		System.out.println(queue);
		System.out.println("size:" + queue.size());

		queue.poll();
		System.out.println(queue);
		System.out.println("size:" + queue.size());

		System.out.println(queue.element());
		System.out.println(queue);
		System.out.println("size:" + queue.size());

		System.out.println(queue.peek());
		System.out.println(queue);
		System.out.println("size:" + queue.size());

		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		System.out.println(queue);
		System.out.println("size:" + queue.size());

		queue.remove();
		System.out.println(queue);
		System.out.println("size:" + queue.size());

	}

}
