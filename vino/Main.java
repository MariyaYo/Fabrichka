package vino;

import java.util.ArrayList;

import vino.Bottle.BottleLine;

public class Main {
	public static void main(String[] args) {
		People.AddTasksForToday();
		ArrayList<People> workers = new ArrayList<>();
		int j = 1;
		for(int i =0; i < 25; i++){
			People p = new People(j++);
			if(j == 8){
				j =1;
			}
			workers.add(p);
		}
		for(People p : workers){
			p.start();
		}
		Thread t = new Thread(){
			@Override
			public void run() {
				BottleLine bl = new BottleLine();
				bl.start();
			}
		};
		t.start();
	}
}
