import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		List<String> teams = new ArrayList<String>();
		Set<String> allMatches = new HashSet<>();
		Scanner s = new Scanner(System.in);
		System.out.print("Kaç Takým Var?");
		int j = s.nextInt();
		s.nextLine();
		for(int i = 0; i<j; i++) {
			System.out.print((i+1)+". takým:");
			String a = s.nextLine();
			teams.add(a);
		}
		if(teams.size()%2==1)
			teams.add("Bay");
		System.out.println(teams.toString());
		
		int week = (teams.size()-1)*2;
				
		for(int i=0; i<week; i++) {
			int[] matches = new int[teams.size()];
			Arrays.fill(matches, 1);
			System.out.println((i+1)+". hafta:");
			for(int x =0; x<(teams.size()/2);x++) {
				boolean firstChoosen = false, secondChoosen =  false;
				int first = -1, second = -1;
				while(!firstChoosen) {
					first = (int)(Math.random()*teams.size());
					if(matches[first] == 1)
						firstChoosen = true;
				}
				while(!secondChoosen) {
					second = (int)(Math.random()*teams.size());
					if(matches[second] == 1 && first != second)
						secondChoosen = true;
				}
				String matchup = ""+first+second;
				if(!allMatches.contains(matchup)) {
					allMatches.add(matchup);
					matches[first] = 0;
					matches[second] = 0;
					System.out.println(teams.get(first)+" vs. "+ teams.get(second));
				}else {
					x--;
				}
			}					
		}	
	}
	
	
}
