package com.mv.leetCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Staircase {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\tmzha_000\\Documents\\workspaces\\java\\designPatterns\\leetCode\\src\\main\\resources\\input000.txt");
		List<Map<String, Object>> coupons = new LinkedList<>();
		List<ProductItem> products = new LinkedList<>();
		Comparator<ProductItem> byPercentageOff = (ProductItem o1, ProductItem	o2) -> ( new Float(o1.getCouponAmount() / o1.getItemPrice())
						.compareTo(new Float(o2.getCouponAmount() / o2.getItemPrice())));
		
		PriorityQueue<ProductItem> selectedItems = new PriorityQueue<>(10, byPercentageOff);
		
		
		Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String i = sc.nextLine();
            Map<String, Object> coupon = readCoupon(i, selectedItems);
            if(coupon != null) {
            	coupons.add(coupon);
            }
        } 
        
		
		clearAndPrintQueue(selectedItems);
		
				
		String[] Categories = {"Baby", "Gift Cards", "Sporting Goods", "Photo Shop", "Deli",
				"Baking Goods", "International"};
		List<String> preferredCategories = Arrays.asList(Categories);
		
		List<Map<String, Object>> results = personalizeCoupons(coupons, preferredCategories);
		
		System.out.println("Done");
	}
	
	private static void clearAndPrintQueue(PriorityQueue<ProductItem> selectedItems) {
		while(!selectedItems.isEmpty()) {
			ProductItem item = selectedItems.remove();
			System.out.println(item);
			
		}
	}

	static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons,
			List<String> preferredCategories) {

		Comparator<Map<String, Object>> byPercentageOff = (Map<String, Object> o1,
				Map<String, Object> o2) -> (new Float((Float)o2.get("couponAmount") / (Float)o2.get("itemPrice")))
						.compareTo(new Float((Float)o1.get("couponAmount") / (Float)(o1.get("itemPrice"))));
				
		Set<String> categories = new HashSet<String>(preferredCategories);

		List<Map<String, Object>> filteredCoupons = coupons.stream()
				.filter(item -> categories.contains((String)item.get("category")))
				.sorted(byPercentageOff)
				.limit(10)
				.collect(Collectors.toList());
		
		filteredCoupons.forEach(elem -> elem.remove("code"));;
				
		return filteredCoupons;
	}
	
    public static Map<String, Object> readCoupon(String input, PriorityQueue<ProductItem> selectedItems) {
        String[] couponItems = input.split(",");
        if (couponItems.length < 4 ) {
			return null;
		}
        Map<String,Object> coupon = new HashMap<>();
        coupon.put("upc", couponItems[0]);
        coupon.put("code", couponItems[1]);
        coupon.put("category", couponItems[2]);
        coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
        coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
        
        ProductItem item = new ProductItem(couponItems[0], couponItems[1], couponItems[2], Float.parseFloat(couponItems[3]), Float.parseFloat(couponItems[4]));
        if (selectedItems.size() >= 10) {
        	ProductItem minItem = selectedItems.peek();
        	Float minPercentage = minItem.getCouponAmount() / minItem.getItemPrice();
			Float curPercentage = Float.parseFloat(couponItems[4]) / Float.parseFloat(couponItems[3]);
			if(curPercentage > minPercentage) {
				selectedItems.remove();
				selectedItems.add(item);
			}
		} else {
				selectedItems.add(item);
		}
        return coupon;
    }
	
	
	static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {
		
		List<Map<String, Object>> results = new LinkedList<>();
		
		for (int i = 0; i < cardsToValidate.length; i++) {
			Map<String, Object> cardItemresult = validateItem(cardsToValidate[i], bannedPrefixes);
			results.add(cardItemresult);
		}
		
		return results;
	}

	private static Map<String, Object> validateItem(String card, String[] bannedPrefixes) {
		
		Map<String, Object> resultItem = new HashMap<>();
		resultItem.put("card", card);
		
		Boolean isValid = isValid(card);		
		resultItem.put("isValid", isValid);
		
		Boolean isAllowed = true;
		for (int i = 0; i < bannedPrefixes.length; i++) {
			if(card.startsWith(bannedPrefixes[i])) {
				isAllowed = false;
			}
		}
		resultItem.put("isAllowed", isAllowed);
		return resultItem;
	}
	
	static void leftBlank(int n, int N) {
		int numberOfBlank = N - n;
		while(numberOfBlank-- > 0) {
			System.out.print(' ');
		}
		while(n-- > 0) {
			System.out.print('#');
		}
		
	}
	
	static void StairCase(int n) {
		for (int i = 1; i < n; i++) {
			leftBlank(i, n);
			System.out.println();
		}
		leftBlank(n, n);
	}


	static int summation(int[] numbers) {
		if(numbers.length < 1) {
			throw new IllegalArgumentException();
		}
		
		int sum = 0;
		for (int i = 1; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	private static Boolean isValid(String card) {
		Integer[] numbers = new Integer[card.length() - 1];
		for (int i = 0; i < card.length() - 1; i++) {
			numbers[i] = (int) card.charAt(i) - 48;
		}
		List<Integer> nums = Arrays.asList(numbers);
		int total = nums.stream().map(elem -> elem * 2).reduce(0, (a, b) -> a + b);
		Boolean isValid = total % 10 == (int)card.charAt(card.length() - 1);
		return isValid;
	}
	
}
