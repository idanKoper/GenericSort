package GenericSort;
import java.util.ArrayList;
import java.util.List;

public class HeapSort {

	private HeapSort() {}
// sorting method
	public static <T extends Comparable<T>> List<T> Sort(List<T> unsortedList) {
		if( unsortedList != null && unsortedList.size()>1) {
			List<T> sortedList = new ArrayList<T>(unsortedList);
			for (int i = 1; i < sortedList.size(); i++) {
				sortedList = siftUp(sortedList, i);
			}
			for (int i = sortedList.size() - 1; i >= 1; i--) {
				sortedList = swap(sortedList, 0, i);
				sortedList = siftDown(sortedList, i - 1);
			}
			System.out.println("Sorted!");
			return sortedList;
		}
		System.out.println("there`s nothing to sort");
		return unsortedList;
	}	

	private static <T extends Comparable<T>> List<T> siftUp(List<T> unsortedList, int n) {
		assert n>0;
		for (int i = n;;) {
			if (i == 0) {
				break;
			}
			int p = i / 2;
			if (unsortedList.get(p).compareTo(unsortedList.get(i)) >= 0) {
				break;
			}
			unsortedList = swap(unsortedList, i, p);
			i = p;
		}
		return unsortedList;
	}

	private static <T extends Comparable<T>> List<T> siftDown(List<T> unsortedList, int n) {
		for (int i = 0;;) {
			int c = 2 * (i + 1) - 1;
			if (c > n) {
				break;
			}
			if (c + 1 <= n) {
				if (unsortedList.get(c + 1).compareTo(unsortedList.get(c)) > 0) {
					c += 1;
				}
			}
			if (unsortedList.get(i).compareTo(unsortedList.get(c)) >= 0) {
				break;
			}
			unsortedList = swap(unsortedList, i, c);
			i = c;
		}
		return unsortedList;
	}

	private static <T> List<T> swap(List<T> list, int firstIndex, int secondIndex) {
		assert list != null;
		assert list.size() > 0;
		assert 0 <= firstIndex;
		assert firstIndex < list.size();
		assert 0 <= secondIndex;
		assert secondIndex < list.size();
		if (firstIndex == secondIndex) {
			return list;
		}
		T tmpT = list.get(secondIndex);
		list.set(secondIndex, list.get(firstIndex));
		list.set(firstIndex, tmpT);
		return list;
	}
}
