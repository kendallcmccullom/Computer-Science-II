package Lists;

//implements a to-do list of tasks 
//Kendall McCullom

public class Organizer
{
	private List<String> toDoList;

//	public Organizer()
//	{
//		toDoList = new ArrayList<>();
//	}

	public void addTask (String e)
	{
		toDoList.add(e);
	}

	public void insertTask (int index, String t)
	{
		if (index < -1 || index >= toDoList.size())
		{
			throw new IllegalArgumentException("Item not added: there aren't "
				+ index + " errands on list!");
		}
		else
		{
			toDoList.add(index, t);
		}
	}

	public boolean removeTask (String t)
	{
		if(toDoList.remove(t))
		{
			return true;
		}
		return false;
	}

	public boolean switchTasks(String t1, String t2)
	{
		if (toDoList.contains(t1)&&toDoList.contains(t2))
		{
			int save1 = toDoList.indexOf(t1);
			int save2 = toDoList.indexOf(t2);
			toDoList.set(save1,t2);
			toDoList.set(save2, t1);
			return true;
		}
		return false;
		// add code
	}

	public int tasks()
	{
		return toDoList.size();
	}

	public String toString()
	{
		String list = "";
		for (int i = 0; i < toDoList.size(); i++)
		{
			list+= (i+1) + "  " + toDoList.get(i) + "\n";
		}
		return list;
	}
}
