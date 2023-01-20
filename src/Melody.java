
public class Melody {
	private Queue<Note> song = new ListQueue<Note>();
	private Queue<Note> repeated = new ListQueue<Note>();
	private int length = 0;
	
	public Melody(Queue<Note> song)
	{
		this.song = song;
		this.length = song.size();
	}
	
	public double getTotalDuration()
	{
		Note copy;
		double duration = 0;
		for(int i = 0; i < song.size(); i++)
		{
			copy = song.remove();
			duration += copy.getDuration();
			song.add(copy);
		}
		return duration;
	}
	
	public String toString()
	{
		Note copy;
		String bigString = "";
		for(int i = 0; i < song.size(); i++)
		{
			copy = song.remove();
			bigString += copy.toString() + "\n";
			song.add(copy);
		}
		return bigString;
	}
	
	public void changeTempo(double tempo)
	{
		Note copy;
		for(int i = 0; i < song.size(); i++)
		{
			copy = song.remove();
			copy.setDuration(copy.getDuration()*tempo);
			song.add(copy);
		}
	}
	
	public void reverse()
	{
		Stack<Note> stack = new ListStack<Note>();
		while(!song.isEmpty())
		{
			stack.push(song.remove());
		}
		while(!stack.isEmpty())
		{
			song.add(stack.pop());
		}
	}
	
	public void append(Melody other)
	{
		Note copy;
		for(int i = 0; i < other.song.size(); i++)
		{
			copy = other.song.remove();
			song.add(copy);
			other.song.add(copy);
		}
	}
	
	public void play()
	{
		Note copy;
		Queue<Note> repeat = new ListQueue<Note>();
		boolean reap = false;
		
		for(int i = 0; i < song.size(); i++)
		{
			copy = song.remove();
			
			if(copy.isRepeat()&&!reap)
			{
				repeat.add(copy);
				song.add(copy);
				copy.play();
				reap = true;
				continue;
			}
			
			if(copy.isRepeat()&&reap)
			{
				repeat.add(copy);
				reap = false;
				song.add(copy);
				copy.play();
				while(!repeat.isEmpty())
				{
					copy = repeat.remove();
					copy.play();
				}
				continue;
			}
			
			if(reap)
			{
				repeat.add(copy);
				song.add(copy);
				copy.play();
				continue;
			}
			
			if(!reap&&!copy.isRepeat())
			{
				song.add(copy);
				copy.play();
			}
		}
	}
}
