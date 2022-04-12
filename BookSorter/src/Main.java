import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Set<Book> set = new TreeSet<>();
		Book a = new Book("aook1","author1", "date1", 100);
		Book b = new Book("book2","author2", "date2", 200);
		Book c = new Book("cook3","author3", "date3", 300);
		Book d = new Book("dook4","author4", "date4", 400);
		Book e = new Book("eook5","author5", "date5", 500);
		System.out.println("Order By Book Name:");
		System.out.println("##################################");
		set.add(e);
		set.add(b);
		set.add(d);
		set.add(c);
		set.add(a);
		
		for(Book x:set) {
			System.out.println("book name: "+x.getBookName()+" page count: "+x.getPageCount());
		}
		
		Set<Book> tSet = new TreeSet<>(new Comparator<Book>() {
			public int compare (Book b1, Book b2) {
				return b1.getPageCount()-b2.getPageCount();
			}
		}.reversed());
		tSet.add(e);
		tSet.add(b);
		tSet.add(d);
		tSet.add(c);
		tSet.add(a);
		System.out.println("Order By Page Count: ");
		System.out.println("##################################");
		
		for(Book x:tSet) {
			System.out.println("book name: "+x.getBookName()+" page count: "+x.getPageCount());
		}
	}
}
