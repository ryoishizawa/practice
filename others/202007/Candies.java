// does not work..
public class Main {
	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 5, 4};
		// key: index, value: num of candies a child get
		Map<Integer, Integer> results = new HashMap<>();
		int prevScore = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if (i == 0) {
				results.put(i, 1);
			} else {
				int currScore = array[i];
				int prevCandy = results.get(i-1);
				if (currScore > prevScore) {
					results.put(i, prevCandy + 1);
				} else {
					results.put(i, 1);
					if (i >= 2 && prevScore > currScore && currScore > array[i-2]) {
						results.put(i - 1, prevCandy + 1);
					}
				}
			}
			prevScore = array[i];
		}
		int result = results.entrySet().stream()
				.reduce(0, (prev, curr) -> prev + curr.getValue(), Integer::sum);
		System.out.println(result);
	}
}
