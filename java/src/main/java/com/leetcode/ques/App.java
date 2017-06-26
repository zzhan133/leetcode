package com.leetcode.ques;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {
		String classpath = System.getProperty("user.dir");
		System.out.println(classpath);
		try (Stream<String> lines = Files.lines(Paths.get("leetcode.txt")); 
				PrintWriter pw = new PrintWriter("orderedByUserOpinions.txt", "UTF-8")){
			//List<Integer> orderedIds = 
					lines.map(str -> {
				String[] elems = str.split(" ");
				if(elems.length != 3) {
					System.out.println(elems);
				}
				int id = Integer.parseInt(elems[0]);
				int up = Integer.parseInt(elems[1]);
				int down = Integer.parseInt(elems[2]);
				return new Problem(id, up, down);
			}).sorted((e1, e2) -> Float.compare((float)e2.getThumbUp() / (float)(e2.getThumbUp() + e2.getThumbDown()), 
					(float)e1.getThumbUp() / (float)(e1.getThumbUp() + e1.getThumbDown())))
			.map(e -> e.getId())
			.forEach(pw::println);
			//.collect(Collectors.toList());
			
			//Files.write("", orderedIds.iterator());
			
			
		} finally {
		}
	}
}
