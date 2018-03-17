package GenericSort;
import java.util.ArrayList;
import java.util.List;

public class GenericSort {

	public static void main(String[] args) {
		List<String> str = new ArrayList<String>();
		str.add("hi");
		str.add("ac");
		str.add("call");
		str.add("by");
		System.out.println(str);
		str = HeapSort.heapSort(str);
		System.out.println(str);
		
		// TODO Auto-generated method stub

	}
}
