package vino;

import java.util.HashMap;

import vino.Bottle.BottleLine;
import vino.Bottle.Stek;

public class People extends Thread{
	private static HashMap<Integer, String> allTasks = new HashMap<>();
	
	private int job;
	
	People(int job){
		this.job = job;			
	}
	
	@Override
		public void run() {
			workOnTask(job);	
	}
		
	public int getJob() {
		return job;
	}

	public void AddTasksForToday(){
		allTasks.put(1, "mie");
		allTasks.put(2, "pulni");
		allTasks.put(3, "tapicki");
		allTasks.put(4, "stoplq");
		allTasks.put(5, "kapsulira");
		allTasks.put(6, "etikira");
		allTasks.put(7, "stekirova");
		allTasks.put(8, "paleti");	
	}
	
	public void workOnTask(int job) {
		AddTasksForToday();
		while(true){
			switch (job) {
			case 1:
				Bottle a = null;
				a = Bottle.bottles.peek();
				if(a !=  null){
					if(!a.isIzmita()){
						a.setIzmita(true);
						System.out.println("izmih butilka");
					}
				}
				break;
			case 2:
				Bottle b = null;
				b = Bottle.bottles.peek();
				if(b !=  null){
					if(!b.isPulna() && b.isIzmita()){
						b.setPulna(true);
						System.out.println("napulnih butilka");
					}
				}
				break;
			case 3:
				Bottle c = null;
				c = Bottle.bottles.peek();
				if(c !=  null){
					if(!c.issTapa() && c.isIzmita() && c.isPulna()){
						c.setsTapa(true);
						System.out.println("slojih tapa na butilka");
					}
				}
				break;
			case 4:
				Bottle d = null;
				d = Bottle.bottles.peek();
				if(d !=  null){
					if(!d.isStoplena() && d.isIzmita() && d.isPulna() && d.issTapa()){
						d.setStoplena(true);
						System.out.println("stoplih butilka");
					}
				}
				break;
			case 5:
				Bottle e = null;
				e = Bottle.bottles.peek();
				if(e !=  null){
					if(!e.isKapsulirana() && e.isIzmita() && e.isPulna() && e.issTapa() && e.isStoplena()){
						e.setKapsulirana(true);
						System.out.println("Stegnah kapa4kata na butilkata");
					}
				}
				break;
			case 6:
				Bottle f = null;
				f = Bottle.bottles.peek();
				if(f !=  null){
					if(!f.isEtikirana() && f.isIzmita() && f.isPulna() && f.issTapa() && f.isStoplena() && f.isKapsulirana()){
						f.setEtikirana(true);
						System.out.println("etikirah butilka");
					}
				}
				break;
			case 7:			
				Bottle j = null;
				try {
					j = Bottle.bottles.take();
				} catch (InterruptedException e1) {
					System.out.println("cant take bottle");
				}	
				if(j.isEtikirana() && j.isIzmita() && j.isPulna() && j.issTapa() && j.isStoplena() && j.isKapsulirana()){
					Bottle.stek.add(j);
					System.out.println("slojih butilka v stek");
					BottleLine.b = new Bottle();
				}
				break;
			case 8:
				if(Bottle.stek.size() == 6){
					System.out.println("slojih stek v pale");
					try {
						Bottle.pale.put(Bottle.stek);
					} catch (InterruptedException ex) {
						System.out.println("cant do that");
					}
					Bottle.stek = new Stek();
				}
				break;
			}	
		}
	}
}
