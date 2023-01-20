import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {
	ArrayList<T> list = new ArrayList<T>();
	public void push(T item)
	{
		list.add(item);
	}
	public T pop()
	{
		if(list.isEmpty())
		{
			return null;
		}
		T something = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return something;
	}
	public T peek()
	{
		if(list.isEmpty()) {
			return null;
		}
		return list.get(list.size()-1);
	}
	public boolean isEmpty()
	{
		if(list.size() == 0)
		{
			return true;
		}
		return false;
	}
}
