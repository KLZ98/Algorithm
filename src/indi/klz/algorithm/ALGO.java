package indi.klz.algorithm;

import indi.klz.util.Sort;

/**
 * <pre>
 * Algorithm integration tool
 * 
 * 
 * <br>
 * @label 1.0.0 mean: 1-grouping algorithm.0-Different types in the same group.0-The version of the current method
 * @1.-.-:Insertion sort of array
 * @2.-.-:heap sort of array
 * 
 * </pre>
 */
public class ALGO {
	
	/**
	 * <pre>
	 * Insertion sort of array
	 * 
	 * @param intArray
	 * @param type
	 * Choose DESC order or ASC order, the default not to sort
	 * @return int[]
	 *
	 * <br>
	 * @label 1.0.0
	 * </pre>
	 */
	public static int[] sortInsertion(int[] intArray,Sort type){
		int[] ints = intArray;
		String sort = type!=null?type.getName():"";
		switch (sort) {
		case "asc":
			for (int i = 1; i < ints.length; i++) {
				int before = i-1,after = ints[i];
				while (before>=0 && ints[before]>after) {
					ints[before+1] = ints[before];
					before--;
				}
				ints[before+1] = after;
			}
			break;
		case "desc":
			for (int i = 1; i < ints.length; i++) {
				int before = i-1,after = ints[i];
				while (before>=0 && ints[before]<after) {
					ints[before+1] = ints[before];
					before--;
				}
				ints[before+1] = after;
			}
			break;
		default:
			throw new RuntimeException("The sort type is not ASC or DESC, so it is not sorted by default");
		}
		return ints;
	}
	
	/**
	 * <pre>
	 * Insertion sort of array
	 * 
	 * @param longArray
	 * @param type
	 * Choose DESC order or ASC order, the default not to sort
	 * @return long[]
	 * 
	 * <br>
	 * @label 1.1.0
	 * </pre>
	 */
	public static long[] sortInsertion(long[] longArray,Sort type){
		long[] longs = longArray;
		String sort = type!=null?type.getName():"";
		switch (sort) {
		case "asc":
			for (int i = 1; i < longs.length; i++) {
				int before = i-1; long after = longs[i];
				while (before>=0 && longs[before]>after) {
					longs[before+1] = longs[before];
					before--;
				}
				longs[before+1] = after;
			}
			break;
		case "desc":
			for (int i = 1; i < longs.length; i++) {
				int before = i-1; long after = longs[i];
				while (before>=0 && longs[before]<after) {
					longs[before+1] = longs[before];
					before--;
				}
				longs[before+1] = after;
			}
			break;
		default:
			throw new RuntimeException("The sort type is not ASC or DESC, so it is not sorted by default");
		}
		return longs;
	}
	
	/**
	 * <pre>
	 * Insertion sort of array
	 * 
	 * @param doubleArray
	 * @param type
	 * Choose DESC order or ASC order, the default not to sort
	 * @return double[]
	 * 
	 * <br>
	 * @label 1.2.0
	 * </pre>
	 */
	public static double[] sortInsertion(double[] doubleArray,Sort type){
		double[] doubles = doubleArray;
		String sort = type!=null?type.getName():"";
		switch (sort) {
		case "asc":
			for (int i = 1; i < doubles.length; i++) {
				int before = i-1; double after = doubles[i];
				while (before>=0 && doubles[before]>after) {
					doubles[before+1] = doubles[before];
					before--;
				}
				doubles[before+1] = after;
			}
			break;
		case "desc":
			for (int i = 1; i < doubles.length; i++) {
				int before = i-1; double after = doubles[i];
				while (before>=0 && doubles[before]<after) {
					doubles[before+1] = doubles[before];
					before--;
				}
				doubles[before+1] = after;
			}
			break;
		default:
			throw new RuntimeException("The sort type is not ASC or DESC, so it is not sorted by default");
		}
		return doubles;
	}
	
	/**
	 * <pre>
	 * Maintains the maximum heap, reordering the values at the specified location
	 * @param intArray
	 * @param subscript 
	 * The coordinates of the values to be sorted
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.0.0
	 * </pre>
	 */
	public static int[] maxHeapify(int[] intArray,int subscript){
		int[] ints = intArray;
		int left = subscript*2+1,right = left+1,maxSubscript,maxNum;
		maxSubscript = left <ints.length && ints[left]>ints[subscript]?left:subscript;
		maxSubscript = right <ints.length && ints[right]>ints[maxSubscript]?right:maxSubscript;
		if(maxSubscript!=subscript){
			/*
			 * If the current root node is smaller than the child node 
			 * need to swap positions
			 */
			maxNum = ints[maxSubscript];
			ints[maxSubscript] = ints[subscript];
			ints[subscript] = maxNum;
			// recursion 
			maxHeapify(ints,maxSubscript);
		}
		return ints;
	}
	
	/**
	 * <pre>
	 * Maintains the minimum heap, reordering the values at the specified location
	 * @param intArray
	 * @param subscript 
	 * The coordinates of the values to be sorted
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.1.0
	 * </pre>
	 */
	public static int[] minHeapify(int[] intArray,int subscript){
		int[] ints = intArray;
		int left = subscript*2+1,right = left+1,minSubscript,minNum;
		minSubscript = left <ints.length && ints[left]<ints[subscript]?left:subscript;
		minSubscript = right <ints.length && ints[right]<ints[minSubscript]?right:minSubscript;
		if(minSubscript!=subscript){
			/*
			 *  If the current root node is larger than the child node
			 *	the position needs to be swapped
			 */
			minNum = ints[minSubscript];
			ints[minSubscript] = ints[subscript];
			ints[subscript] = minNum;
			// recursion 
			minHeapify(ints,minSubscript);
		}
		return ints;
	}
	
	/**
	 * <pre>
	 * Converts an array to the maximum or minimum heap
	 * @param intArray
	 * @param type 
	 * DESC:maximum heap; ASC:minimum heap
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.2.0
	 * <pre>
	 */
	public static int[] buildHeapify(int[] intArray, Sort type){
		int[] ints = intArray;
		String sort = type!=null?type.getName():"";
		switch (sort) {
		case "desc":
			// maximum heap
			for (int i = ints.length/2; i >=0; i--) {
				ints = maxHeapify(ints, i);
			}
			break;
		case "asc":
			// minimum heap
			for (int i = ints.length/2; i >=0; i--) {
				ints = minHeapify(ints, i);
			}
			break;
		default:
			throw new RuntimeException("The sort type is not ASC or DESC, so it is not sorted by default");
		}
		return ints;
	}
	
	/**
	 * <pre>
	 * Maintains the maximum heap, reordering the values at the specified location
	 * @param longArray
	 * @param subscript 
	 * The coordinates of the values to be sorted
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.3.0
	 * </pre>
	 */
	public static long[] maxHeapify(long[] longArray,int subscript){
		long[] longs = longArray;
		int left = subscript*2+1,right = left+1,maxSubscript; long maxNum;
		maxSubscript = left <longs.length && longs[left]>longs[subscript]?left:subscript;
		maxSubscript = right <longs.length && longs[right]>longs[maxSubscript]?right:maxSubscript;
		if(maxSubscript!=subscript){
			/*
			 * If the current root node is smaller than the child node 
			 * need to swap positions
			 */
			maxNum = longs[maxSubscript];
			longs[maxSubscript] = longs[subscript];
			longs[subscript] = maxNum;
			// recursion 
			maxHeapify(longs,maxSubscript);
		}
		return longs;
	}
	
	/**
	 * <pre>
	 * Maintains the minimum heap, reordering the values at the specified location
	 * @param longArray
	 * @param subscript 
	 * The coordinates of the values to be sorted
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.4.0
	 * </pre>
	 */
	public static long[] minHeapify(long[] longArray,int subscript){
		long[] longs = longArray;
		int left = subscript*2+1,right = left+1,minSubscript; long minNum;
		minSubscript = left <longs.length && longs[left]<longs[subscript]?left:subscript;
		minSubscript = right <longs.length && longs[right]<longs[minSubscript]?right:minSubscript;
		if(minSubscript!=subscript){
			/*
			 *  If the current root node is larger than the child node
			 *	the position needs to be swapped
			 */
			minNum = longs[minSubscript];
			longs[minSubscript] = longs[subscript];
			longs[subscript] = minNum;
			// recursion 
			minHeapify(longs,minSubscript);
		}
		return longs;
	}
	
	/**
	 * <pre>
	 * Converts an array to the maximum or minimum heap
	 * @param longArray
	 * @param type 
	 * DESC:maximum heap; ASC:minimum heap
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.5.0
	 * <pre>
	 */
	public static long[] buildHeapify(long[] longArray, Sort type){
		long[] longs = longArray;
		String sort = type!=null?type.getName():"";
		switch (sort) {
		case "desc":
			// maximum heap
			for (int i = longs.length/2; i >=0; i--) {
				longs = maxHeapify(longs, i);
			}
			break;
		case "asc":
			// minimum heap
			for (int i = longs.length/2; i >=0; i--) {
				longs = minHeapify(longs, i);
			}
			break;
		default:
			throw new RuntimeException("The sort type is not ASC or DESC, so it is not sorted by default");
		}
		return longs;
	}
	
	/**
	 * <pre>
	 * Maintains the maximum heap, reordering the values at the specified location
	 * @param doubleArray
	 * @param subscript 
	 * The coordinates of the values to be sorted
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.6.0
	 * </pre>
	 */
	public static double[] maxHeapify(double[] doubleArray,int subscript){
		double[] doubles = doubleArray;
		int left = subscript*2+1,right = left+1,maxSubscript; double maxNum;
		maxSubscript = left <doubles.length && doubles[left]>doubles[subscript]?left:subscript;
		maxSubscript = right <doubles.length && doubles[right]>doubles[maxSubscript]?right:maxSubscript;
		if(maxSubscript!=subscript){
			/*
			 * If the current root node is smaller than the child node 
			 * need to swap positions
			 */
			maxNum = doubles[maxSubscript];
			doubles[maxSubscript] = doubles[subscript];
			doubles[subscript] = maxNum;
			// recursion 
			maxHeapify(doubles,maxSubscript);
		}
		return doubles;
	}
	
	/**
	 * <pre>
	 * Maintains the minimum heap, reordering the values at the specified location
	 * @param doubleArray
	 * @param subscript 
	 * The coordinates of the values to be sorted
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.7.0
	 * </pre>
	 */
	public static double[] minHeapify(double[] doubleArray,int subscript){
		double[] doubles = doubleArray;
		int left = subscript*2+1,right = left+1,minSubscript; double minNum;
		minSubscript = left <doubles.length && doubles[left]<doubles[subscript]?left:subscript;
		minSubscript = right <doubles.length && doubles[right]<doubles[minSubscript]?right:minSubscript;
		if(minSubscript!=subscript){
			/*
			 *  If the current root node is larger than the child node
			 *	the position needs to be swapped
			 */
			minNum = doubles[minSubscript];
			doubles[minSubscript] = doubles[subscript];
			doubles[subscript] = minNum;
			// recursion 
			minHeapify(doubles,minSubscript);
		}
		return doubles;
	}
	
	/**
	 * <pre>
	 * Converts an array to the maximum or minimum heap
	 * @param doubleArray
	 * @param type 
	 * DESC:maximum heap; ASC:minimum heap
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.8.0
	 * </pre>
	 */
	public static double[] buildHeapify(double[] doubleArray, Sort type){
		double[] doubles = doubleArray;
		String sort = type!=null?type.getName():"";
		switch (sort) {
		case "desc":
			// maximum heap
			for (int i = doubles.length/2; i >=0; i--) {
				doubles = maxHeapify(doubles, i);
			}
			break;
		case "asc":
			// minimum heap
			for (int i = doubles.length/2; i >=0; i--) {
				doubles = minHeapify(doubles, i);
			}
			break;
		default:
			throw new RuntimeException("The sort type is not ASC or DESC, so it is not sorted by default");
		}
		return doubles;
	}
	
	/**
	 * <pre>
	 * Deletes data with index 0 and updates the array in maximum heap sort
	 * 
	 * @param intArray
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.9.0
	 * </pre>
	 */
	public static int[] maxHeapHeadRemove(int[] intArray){
		int[] ints = new int[intArray.length-1];
		ints[0] = intArray[intArray.length-1];
		for (int i = 1; i < ints.length; i++) {
			ints[i] = intArray[i];
		}
		ints = maxHeapify(ints, 0);
		return ints;
	}
	
	/**
	 * <pre>
	 * Deletes data with index 0 and updates the array in maximum heap sort
	 * 
	 * @param intArray
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.10.0
	 * </pre>
	 */
	public static double[] maxHeapHeadRemove(double[] doubleArray){
		double[] doubles = new double[doubleArray.length-1];
		doubles[0] = doubleArray[doubleArray.length-1];
		for (int i = 1; i < doubles.length; i++) {
			doubles[i] = doubleArray[i];
		}
		doubles = maxHeapify(doubles, 0);
		return doubles;
	}
	
	/**
	 * <pre>
	 * Deletes data with index 0 and updates the array in maximum heap sort
	 * 
	 * @param intArray
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.11.0
	 * </pre>
	 */
	public static long[] maxHeapHeadRemove(long[] longArray){
		long[] longs = new long[longArray.length-1];
		longs[0] = longArray[longArray.length-1];
		for (int i = 1; i < longs.length; i++) {
			longs[i] = longArray[i];
		}
		longs = maxHeapify(longs, 0);
		return longs;
	}
	
	/**
	 * <pre>
	 * Deletes data with index 0 and updates the array in minimum heap sort
	 * 
	 * @param intArray
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.12.0
	 * </pre>
	 */
	public static int[] minHeapHeadRemove(int[] intArray){
		int[] ints = new int[intArray.length-1];
		ints[0] = intArray[intArray.length-1];
		for (int i = 1; i < ints.length; i++) {
			ints[i] = intArray[i];
		}
		ints = minHeapify(ints, 0);
		return ints;
	}
	
	/**
	 * <pre>
	 * Deletes data with index 0 and updates the array in minimum heap sort
	 * 
	 * @param intArray
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.13.0
	 * </pre>
	 */
	public static double[] minHeapHeadRemove(double[] doubleArray){
		double[] doubles = new double[doubleArray.length-1];
		doubles[0] = doubleArray[doubleArray.length-1];
		for (int i = 1; i < doubles.length; i++) {
			doubles[i] = doubleArray[i];
		}
		doubles = minHeapify(doubles, 0);
		return doubles;
	}
	
	/**
	 * <pre>
	 * Deletes data with index 0 and updates the array in minimum heap sort
	 * 
	 * @param intArray
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.14.0
	 * </pre>
	 */
	public static long[] minHeapHeadRemove(long[] longArray){
		long[] longs = new long[longArray.length-1];
		longs[0] = longArray[longArray.length-1];
		for (int i = 1; i < longs.length; i++) {
			longs[i] = longArray[i];
		}
		longs = minHeapify(longs, 0);
		return longs;
	}
	
	/**
	 * <pre>
	 * Replaces the contents of the specified index and reorders it by the maximum heap.
	 * Note that the replacement content should not be smaller than the current content.
	 * @param intArray
	 * @param index
	 * @param value
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.15.0
	 * </pre>
	 */
	public static int[] maxHeapIncreaseKey(int[] intArray,int index,int value){
		int[] ints = intArray;
		if(value<ints[index]){
			throw new RuntimeException("new value is smaller than current value, not conforming to the maximum heap rule");
		}else{
			ints[index] = value;
			int parent = index%2==0?index/2-1:index/2, smaller;
			while (index>0 && ints[parent]<ints[index]) {
				smaller = ints[parent];
				ints[parent] = ints[index];
				ints[index] = smaller;
				index = parent;
				parent = index%2==0?index/2-1:index/2;
			}
		}
		return ints;
	}
	
	/**
	 * <pre>
	 * Replaces the contents of the specified index and reorders it by the maximum heap.
	 * Note that the replacement content should not be smaller than the current content.
	 * @param doubleArray
	 * @param index
	 * @param value
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.16.0
	 * </pre>
	 */
	public static double[] maxHeapIncreaseKey(double[] doubleArray,int index,double value){
		double[] doubles = doubleArray;
		if(value<doubles[index]){
			throw new RuntimeException("new value is smaller than current value, not conforming to the maximum heap rule");
		}else{
			doubles[index] = value;
			int parent = index%2==0?index/2-1:index/2; double smaller;
			while (index>0 && doubles[parent]<doubles[index]) {
				smaller = doubles[parent];
				doubles[parent] = doubles[index];
				doubles[index] = smaller;
				index = parent;
				parent = index%2==0?index/2-1:index/2;
			}
		}
		return doubles;
	}
	
	/**
	 * <pre>
	 * Replaces the contents of the specified index and reorders it by the maximum heap.
	 * Note that the replacement content should not be smaller than the current content.
	 * @param longArray
	 * @param index
	 * @param value
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.17.0
	 * </pre>
	 */
	public static long[] maxHeapIncreaseKey(long[] longArray,int index,long value){
		long[] longs = longArray;
		if(value<longs[index]){
			throw new RuntimeException("new value is smaller than current value, not conforming to the maximum heap rule");
		}else{
			longs[index] = value;
			int parent = index%2==0?index/2-1:index/2; long smaller;
			while (index>0 && longs[parent]<longs[index]) {
				smaller = longs[parent];
				longs[parent] = longs[index];
				longs[index] = smaller;
				index = parent;
				parent = index%2==0?index/2-1:index/2;
			}
		}
		return longs;
	}
	
	/**
	 * <pre>
	 * Replaces the contents of the specified index and reorders it by the minimum heap.
	 * Note that the replacement content should not be bigger than the current content.
	 * @param intArray
	 * @param index
	 * @param value
	 * @return int[]
	 * 
	 * <br>
	 * @label 2.18.0
	 * </pre>
	 */
	public static int[] minHeapIncreaseKey(int[] intArray,int index,int value){
		int[] ints = intArray;
		if(value>ints[index]){
			throw new RuntimeException("new value is bigger than current value, not conforming to the minimum heap rule");
		}else{
			ints[index] = value;
			int parent = index%2==0?index/2-1:index/2, bigger;
			while (index>0 && ints[parent]>ints[index]) {
				bigger = ints[parent];
				ints[parent] = ints[index];
				ints[index] = bigger;
				index = parent;
				parent = index%2==0?index/2-1:index/2;
			}
		}
		return ints;
	}
	
	/**
	 * <pre>
	 * Replaces the contents of the specified index and reorders it by the minimum heap.
	 * Note that the replacement content should not be bigger than the current content.
	 * @param doubleArray
	 * @param index
	 * @param value
	 * @return double[]
	 * 
	 * <br>
	 * @label 2.19.0
	 * </pre>
	 */
	public static double[] minHeapIncreaseKey(double[] doubleArray,int index,double value){
		double[] doubles = doubleArray;
		if(value>doubles[index]){
			throw new RuntimeException("new value is bigger than current value, not conforming to the minimum heap rule");
		}else{
			doubles[index] = value;
			int parent = index%2==0?index/2-1:index/2; double bigger;
			while (index>0 && doubles[parent]>doubles[index]) {
				bigger = doubles[parent];
				doubles[parent] = doubles[index];
				doubles[index] = bigger;
				index = parent;
				parent = index%2==0?index/2-1:index/2;
			}
		}
		return doubles;
	}
	
	/**
	 * <pre>
	 * Replaces the contents of the specified index and reorders it by the minimum heap.
	 * Note that the replacement content should not be bigger than the current content.
	 * @param longArray
	 * @param index
	 * @param value
	 * @return long[]
	 * 
	 * <br>
	 * @label 2.20.0
	 * </pre>
	 */
	public static long[] minHeapIncreaseKey(long[] longArray,int index,long value){
		long[] longs = longArray;
		if(value>longs[index]){
			throw new RuntimeException("new value is bigger than current value, not conforming to the minimum heap rule");
		}else{
			longs[index] = value;
			int parent = index%2==0?index/2-1:index/2; long bigger;
			while (index>0 && longs[parent]>longs[index]) {
				bigger = longs[parent];
				longs[parent] = longs[index];
				longs[index] = bigger;
				index = parent;
				parent = index%2==0?index/2-1:index/2;
			}
		}
		return longs;
	}
	
}
