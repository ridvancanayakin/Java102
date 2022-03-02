import java.util.Arrays;

public class MyList<T> {
	private T[] datas ;
	private int numberOfElements = 0 ;
	
	@SuppressWarnings("unchecked")
	public MyList() {
		datas = (T[]) new Object[10];
	}
	
	public MyList(int capacity) {
		if(capacity<1)
			capacity = 10;
		datas = (T[]) new Object[capacity];
	}
	
	public int size() {
		return numberOfElements;
	} 
	
	public int getCapacity() {
		return datas.length;
	}
	
	public void add(T data) {
		if(numberOfElements < getCapacity()) {
			datas[numberOfElements] = data;
			numberOfElements++;
		}else {
			doubleTheCapacity();
			add(data);
		}
	}
	@SuppressWarnings("unchecked")
	private void doubleTheCapacity() {
		T[] newDatas = (T[]) new Object[2*getCapacity()];
		for(int i=0 ;i<getCapacity();i++) {
			newDatas[i] = datas[i];
		}
		datas = newDatas;
	}
	
	public T get(int index) {
		T result = null;
		if(index < numberOfElements && index >= 0)
			result = datas[index];
		return result;
		
	}
	
	public T set(int index, T data) {
		T result = null;
		if(index < numberOfElements && index >= 0) {
			result = datas[index];
			datas[index] = data;
		}
		return result;
		
	}
	
	public T remove(int index){
		T result = null;
		if(index < numberOfElements && index >= 0) {
			result = datas[index];
			for(int i=index ; i<numberOfElements-1; i++) {
				datas[i] =datas[i+1];
			}
			numberOfElements --;
		}
		return result;
	}
	
	public String toString() {
		String result = "[";
		for(int i=0; i<numberOfElements; i++) {
			result = result+datas[i].toString();
			if(i<numberOfElements-1)
				result = result+",";
			else
				result = result+"]";
		}
		return result;
	}
	
	public int indexOf(T data) {
		int result = -1;
		for(int i=0; i< numberOfElements; i++) {
			if(datas[i].equals(data)) {
				result = i;
				break;
			}
		}
		return result;
	}
	public int lastIndexOf(T data) {
		int result = -1;
		for(int i=0; i< numberOfElements; i++) {
			if(datas[i].equals(data)) {
				result = i;
			}
		}
		return result;
	}
	
	public boolean isEmpty() {
		return numberOfElements==0;
	}
	
	public void clear() {
		numberOfElements = 0;
	}
	
	public T[] toArray() {
		//return Arrays.copyOfRange(datas, 0, numberOfElements);
		return sublist(0, numberOfElements);
	}
	
	public T[] sublist(int start, int finish) {
		finish = Math.min(finish, numberOfElements);
		T[] result = (T[]) new Object[finish-start];
		for(int i = 0; i < finish-start; i++) {
			result[i] = datas[start+i];
		}
		return result;
	}

	public boolean contains(T data) {
		return indexOf(data)==-1? false:true;
	}
}
