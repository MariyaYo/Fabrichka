package vino;

import java.util.HashMap;

public class People extends Thread{
	private static HashMap<Integer, String> allTasks = new HashMap<>();
	
	private int job;
	
	People(int job){
		this.job = job;			
	}
	
	@Override
		public void run() {
			Bottle.workOnTask(job);	
	}
		
	public int getJob() {
		return job;
	}

	public static void AddTasksForToday(){
		allTasks.put(1, "mie");
		allTasks.put(2, "pulni");
		allTasks.put(3, "tapicki");
		allTasks.put(4, "stoplq");
		allTasks.put(5, "kapsulira");
		allTasks.put(6, "etikira");
		allTasks.put(7, "stekirova");
		allTasks.put(1, "paleti");	
	}
}
