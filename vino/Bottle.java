package vino;

import java.util.concurrent.ArrayBlockingQueue;

public class Bottle {
	
	private boolean izmita;
	private boolean pulna;
	private boolean sTapa;
	private boolean stoplena;
	private boolean kapsulirana;
	private boolean etikirana;
	
	private static ArrayBlockingQueue<Bottle> bottles = new ArrayBlockingQueue<>(100);
	private static ArrayBlockingQueue<Stek> pale = new ArrayBlockingQueue<>(75);
	private static Stek stek = new Stek();
	
	Bottle(){
		this.izmita = false;
		this.pulna = false;
		this.sTapa = false;
		this.stoplena = false;
		this.kapsulirana = false;
		this.etikirana = false;
	}
	
	public void placeBottle(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Cant sleep");
		}
		Bottle b = new Bottle();
		System.out.println("New bottle is placed");
		try {
			bottles.put(b);
		} catch (InterruptedException e) {
			System.out.println("cant put bottle in line");
		}
	}

	public static void workOnTask(int job) {
		while(true){
			switch (job) {
			case 1:
				Bottle a = null;
				a = bottles.peek();
				if(a !=  null){
					if(a.izmita == false){
						a.izmita = true;
						System.out.println("izmih butilka");
					}
				}
				break;
			case 2:
				Bottle b = null;
				b = bottles.peek();
				if(b !=  null){
					if(b.pulna == false && b.izmita == true){
						b.pulna = true;
						System.out.println("napulnih butilka");
					}
				}
				break;
			case 3:
				Bottle c = null;
				c = bottles.peek();
				if(c !=  null){
					if(c.sTapa == false && c.izmita == true && c.pulna){
						c.sTapa = true;
						System.out.println("slojih tapa na butilka");
					}
				}
				break;
			case 4:
				Bottle d = null;
				d = bottles.peek();
				if(d !=  null){
					if(d.stoplena == false && d.izmita == true && d.pulna && d.sTapa){
						d.stoplena = true;
						System.out.println("stoplih butilka");
					}
				}
				break;
			case 5:
				Bottle e = null;
				e = bottles.peek();
				if(e !=  null){
					if(e.kapsulirana == false && e.izmita == true && e.pulna && e.sTapa && e.stoplena){
						e.kapsulirana = true;
						System.out.println("iStegnah kapa4kata na butilkata butilka");
					}
				}
				break;
			case 6:
				Bottle f = null;
				f = bottles.peek();
				if(f !=  null){
					if(f.etikirana == false  && f.izmita == true && f.pulna && f.sTapa && f.stoplena && f.kapsulirana){
						f.etikirana = true;
						System.out.println("etikirah butilka");
					}
				}
				break;
			case 7:			
				Bottle j = null;
				try {
					j = bottles.take();
				} catch (InterruptedException e1) {
					System.out.println("cant take bottle");
				}	
				if(j.etikirana == false  && j.izmita == true && j.pulna && j.sTapa && j.stoplena && j.kapsulirana && j.etikirana){
					stek.add(j);
					System.out.println("slojih butilka v stek");
					BottleLine.b = new Bottle();
				}
				break;
			case 8:
				if(stek.size() == 6){
					System.out.println("slojih stek v pale");
					try {
						pale.put(stek);
					} catch (InterruptedException ex) {
						System.out.println("cant do that");
					}
					stek = new Stek();
				}
				break;
			}	
		}
	}
	
	public static class BottleLine extends Thread{
		private static Bottle b = new Bottle();
		
		@Override
		public void run() {
			while(true){
				b.placeBottle();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("cant sleep i'm a bottle");
				}
			}
		}	
	}
	
	private static class Stek {
	private ArrayBlockingQueue<Bottle> stek = new ArrayBlockingQueue<>(6);
	
		public void add(Bottle b){
			this.stek.add(b);
		}
		
		public int size(){
			return this.stek.size();
		}
	}
}
