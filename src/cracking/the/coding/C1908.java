package cracking.the.coding;

import java.util.ArrayList;
import java.util.LinkedList;

public class C1908 {
	
	public static class Tuple<K, V> {
		final K key;
		V value;
		
		public Tuple(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	
	public static class HashTable<K, V> {
		
		int BUCKET_SIZE = 20;
		
		ArrayList<LinkedList<Tuple<K, V>>> buckets = new ArrayList<LinkedList<Tuple<K, V>>> (BUCKET_SIZE);
		
		public HashTable() {
			for (int i = 0; i < BUCKET_SIZE; i++)
				buckets.add(new LinkedList<Tuple<K, V>> ());
		}
		
		public void put(K key, V value) {
			int index = hash(key);
			LinkedList<Tuple<K, V>> bucket = buckets.get(index);

			boolean existing = false;
			for (Tuple<K, V> tuple : bucket)
				if (tuple.key.equals(key)) {
					tuple.value = value;
					existing = true;
				}

			if (!existing) bucket.add(new Tuple<K, V>(key, value));
		}
		
		public V get(K key) {
			int index = hash(key);
			LinkedList<Tuple<K, V>> bucket = buckets.get(index);
			
			for (Tuple<K, V> tuple : bucket)
				if (tuple.key.equals(key))
					return tuple.value;
			
			return null;
		}
		
		public int hash(K key) {
			return key.hashCode() % BUCKET_SIZE;
		}
		
	}
	

	public static void main(String[] args) {
		
		HashTable<String, Integer> wordCount = new HashTable<String, Integer> ();

		String[] words = {"word", "more", "more", "word", "word", "bar"};
		
		for (String word : words) {
			Integer count = wordCount.get(word);
			
			if (count == null)
				wordCount.put(word, 1);
			else
				wordCount.put(word, ++count);
		}

		System.out.println(wordCount.get("word"));
		System.out.println(wordCount.get("more"));
		System.out.println(wordCount.get("bar"));
	}

}
