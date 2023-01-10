package generics;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
	private int capacity = 10;
	private ArrayList<T> genericArray;

	MyList() {
		genericArray = new ArrayList<T>(getCapacity());
	}

	public MyList(int capacity) {
		this.setCapacity(capacity);
		this.genericArray = new ArrayList<T>(getCapacity());
	}

	public ArrayList<T> getGenericArray() {
		return genericArray;
	}

	public void setGenericArray(ArrayList<T> genericArray) {
		this.genericArray = genericArray;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int size() {
		return this.getGenericArray().size();
	}

	public void add(T data) {
		if (this.size() == this.getCapacity()) {
			this.setCapacity(this.getCapacity() * 2);
		}

		this.genericArray.add(data);
	}

	public T get(int index) {
		T searchObject = null;
		if ((this.genericArray.get(index)) != null) {
			searchObject = this.genericArray.get(index);
		} else {
			searchObject = null;
		}
		return searchObject;
	}

	public void remove(int index) {
		if ((this.genericArray.get(index)) != null) {
			this.genericArray.remove(index);
		} else {
			System.out.println("Null");
		}
	}

	public void set(int index, T data) {
		if ((this.genericArray.get(index)) != null) {
			this.genericArray.set(index, data);
		} else {
			System.out.println("Null");
		}
	}

	@Override
	public String toString() {
		return genericArray.toString();
	}

	public int indexOf(T data) {
		return this.genericArray.contains(data) ? this.genericArray.indexOf(data) : -1;
	}

	public int lastIndexOf(T data) {
		if (this.genericArray.contains(data)) {
			return this.genericArray.lastIndexOf(data);
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.getGenericArray().isEmpty();
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) this.getGenericArray().toArray();
	}

	public void clear() {
		this.genericArray.clear();
	}

	public MyList<T> sublist(int start, int finish) {
		MyList<T> sub = new MyList<>((finish - start) + 1);
		for (int i = start; i <= finish; i++) {
			sub.add((T) this.genericArray.get(i));
		}

		return sub;
	}

	public boolean contains(T data) {
		return this.genericArray.contains(data);
	}
}
