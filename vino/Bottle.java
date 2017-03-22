package vino;

import java.util.concurrent.ArrayBlockingQueue;

public class Bottle {
	
	private boolean izmita;
	private boolean pulna;
	private boolean sTapa;
	private boolean stoplena;
	private boolean kapsulirana;
	private boolean etikirana;
	
	static ArrayBlockingQueue<Bottle> bottles = new ArrayBlockingQueue<>(100);
	static ArrayBlockingQueue<Stek> pale = new ArrayBlockingQueue<>(75);
	static Stek stek = new Stek();
	
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
	
	public static class BottleLine extends Thread{
		static Bottle b = new Bottle();
		
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
	
	static class Stek {
	private ArrayBlockingQueue<Bottle> stek = new ArrayBlockingQueue<>(6);
	
		public void add(Bottle b){
			this.stek.add(b);
		}
		
		public int size(){
			return this.stek.size();
		}
	}

	public boolean isIzmita() {
		return izmita;
	}

	public boolean isPulna() {
		return pulna;
	}

	public boolean issTapa() {
		return sTapa;
	}

	public boolean isStoplena() {
		return stoplena;
	}

	public boolean isKapsulirana() {
		return kapsulirana;
	}

	public boolean isEtikirana() {
		return etikirana;
	}

	public static Stek getStek() {
		return stek;
	}

	public void setIzmita(boolean izmita) {
		this.izmita = izmita;
	}

	public void setPulna(boolean pulna) {
		this.pulna = pulna;
	}

	public void setsTapa(boolean sTapa) {
		this.sTapa = sTapa;
	}

	public void setStoplena(boolean stoplena) {
		this.stoplena = stoplena;
	}

	public void setKapsulirana(boolean kapsulirana) {
		this.kapsulirana = kapsulirana;
	}

	public void setEtikirana(boolean etikirana) {
		this.etikirana = etikirana;
	}

	public static void setStek(Stek stek) {
		Bottle.stek = stek;
	}
	
	
}
