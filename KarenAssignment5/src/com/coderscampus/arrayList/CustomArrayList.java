package com.coderscampus.arrayList;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {

	Object[] items = new Object[10];
	int counter = 0;
	@Override
	public boolean add(T item) {

		items[counter] = item;
		if (item == null) {
			return false;
		}
		if (item != null) {
			counter++;
		}
		if (counter == items.length && items != null) {
			Object[] newItems = Arrays.copyOf(items, items.length * 2);
			items = newItems;
		}
		return true;
	}
	@Override
	public int getSize() {
 int count = 0;
    for ( int i = 0; i < items.length; i++) {
    	if (items [i] !=null) {
    		count++;
    	}
    }
		return count++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) items[index];
	}
	@Override
	public String toString() {
		return "CustomArrayList [items=" + Arrays.toString(items);
	}

}
