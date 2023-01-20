import java.util.ArrayList;

public class ListQueue<T> implements Queue<T> {
	private ArrayList<T> list = new ArrayList<T>();
	
	public void add(T item)
	{
		list.add(item);
	}
	
	public T remove()
	{
		if(isEmpty())
		{
			return null;
		}
		T something = list.get(0);
		list.remove(0);
		return something;
	}
	
	public boolean isEmpty()
	{
		if(list.size() == 0)
		{
			return true;
		}
		return false;
	}
	
	public int size()
	{
		return list.size();
	}
	
}
