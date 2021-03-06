	//Librerias importo
	import java.awt.*;
	import java.applet.*;
	import java.text.SimpleDateFormat;
	import java.util.*;
	
	public class Reloj extends Applet implements Runnable {
	
		//propiedades
		private Thread hilo=null; //hilo
		private Font fuente;  //tipo de letra de la hora
		private String horaActual="";
	
	
	//método init
	public void init(){
		fuente=new Font("Verdana",Font.BOLD,26);

	}

	public void start(){
		if (hilo==null){
				hilo=new Thread(this);	//creo el hilo
				hilo.start(); //lanzo hilo
			}
	}


	public void run(){
		Thread hiloActual=Thread.currentThread();
		while (hilo==hiloActual) //vble hilo apunta a hilo en ejecución
			{ 
				//actualizo vble horaActual
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				Calendar cal=Calendar.getInstance();
				horaActual=sdf.format(cal.getTime());
				
				repaint(); //actualiza contenido applet
				
				//espero un segundo
				try {
					Thread.sleep(3000);
				}catch (InterruptedException e){}
			}
	}
	
	public void stop(){
		hilo=null;
	}
	
	int x,y;
	int sumadorx=10;
	int sumadory=10;
	public void paint(Graphics g){
		
		g.clearRect(1,1, getSize().width,getSize().height);
		setBackground(Color.BLUE); //color de fondo
		g.setFont (fuente); //fuente
		x +=sumadorx;
		y +=sumadory;
		if(x>80 || x<0){
			sumadorx=-sumadorx;
		}
		if(y>200 || y<0){
			sumadory=-sumadory;
		}
		g.drawString(horaActual,x,y); // muestra la hora
	}

}
	
