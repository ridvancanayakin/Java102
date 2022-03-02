import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		MyList<Integer> mlist = new MyList<>();
		System.out.println(mlist.isEmpty());
		System.out.println("1 eklenecek");
		mlist.add(1);
		System.out.println("2 eklenecek");
		mlist.add(2);
		mlist.add(3);
		System.out.println(mlist.toString());
		mlist.set(2,17);
		mlist.add(3);
		mlist.add(3);
		mlist.add(3);
		mlist.add(3);
		
		System.out.println(mlist.toString());
		System.out.println(mlist.indexOf(3));
		System.out.println(mlist.lastIndexOf(9));
		System.out.println(mlist.isEmpty());
		System.out.println(Arrays.toString(mlist.toArray()));
		System.out.println("cont "+mlist.contains(100));
		System.out.println("cont "+mlist.contains(1));
		
	}

}
