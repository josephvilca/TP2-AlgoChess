package modelo;

import java.util.HashMap;

public class Juego {
	
	public Tablero tablero;
	Tienda tienda;
	Jugador jugador1, jugador2, turnoActual;
	UnidadDeJuego unidadSeleccionada;
	EstadoDeTurno enTurno, estadoSeleccionado, faseInicial, faseInicial2, turnoTerminado, finDelJuego;
	
	EstadoDeTurno estadoActual;
	
	private int turno;
	
	
	// TURNOS IMPARES JUGADOR 1, TURNOS PARES JUGADOR 2
	public Juego() {
		this.turno = 1;
		this.tablero = new Tablero();
		this.jugador1 = new Jugador(20);
		jugador1.setearTipoDeUnidades(new UJugador1());
		
		this.jugador2 = new Jugador(20);
		jugador2.setearTipoDeUnidades(new UJugador2());
		this.tienda = new Tienda();
		turnoActual = jugador1;
		
		enTurno = new EnTurno(this);
		estadoSeleccionado = new UnidadSeleccionada(this);
		turnoTerminado = new TurnoTerminado(this);
		faseInicial = new FaseInicial(this);
		faseInicial2 = new FaseInicial2(this);
		finDelJuego = new FinDelJuego(this);
		
		estadoActual = faseInicial;
		
		tablero.actualizarUnidadesDeJugadores(jugador1.unidades(), jugador2.unidades());
		
	}

	
	public boolean faseInicalTerminada(){
		return turno == 2;
	}
	
	public String getNombreJugadorTurnoActual(){
		return this.turnoActual.getNombre();
	}
	
	public void setNombreJugador1(String nombre){
		this.jugador1.setNombre(nombre);
	}

	public void setNombreJugador2(String nombre){
		this.jugador2.setNombre(nombre);
	}

	public void seleccionarDelTablero(int x, int y) {
		estadoActual.seleccionarDelTablero(x, y);
	}
	
	public UnidadDeJuego obtenerUnidadDelTablero(int x, int y){
		Posicion posicionUnidad= new Posicion(x,y);
		return this.tablero.obtenerUnidad(posicionUnidad);	
	}
	
	
	public void posicionarUnidad(int x, int y){
		Posicion posicionSeleccionada = new Posicion(x,y);
		if(this.tablero.unidadAliada(this.unidadSeleccionada))
			this.tablero.posicionarUnidad(posicionSeleccionada, unidadSeleccionada);
		
	}

	public void terminarTurno(){
		this.turno++;
		if(this.turno % 2 == 0 ) {
			this.turnoActual = this.jugador2;
			this.tablero.actualizarUnidadesDeJugadores(this.jugador2.unidades(), this.jugador1.unidades());
		}else{
			this.turnoActual = this.jugador1;
			this.tablero.actualizarUnidadesDeJugadores(this.jugador1.unidades(), this.jugador2.unidades());
			
		}	
	}
	
	public void concluirTurno(){
		estadoActual.terminarTurno();
	}
	
	public void accionar(int x, int y){
		estadoActual.accionar(x, y);

	}
	
	public boolean finDelJuego(){
		return jugador1.derrotado() || jugador2.derrotado();
	}
	
	public void moverPiezaSeleccionada(int x, int y){
		estadoActual.moverPiezaSeleccionada(x, y);
	}
	
	
	public void comprarUnidad(int indice, int x, int y){
		estadoActual.comprarUnidad(indice, x, y);
	}
	
	public void cambiarEstado(EstadoDeTurno estado){
		
		estadoActual = estado;
	}
	
	public void aumentarNumeroDeTurno(){
		this.turno++;
	}
	
	public boolean esTurnoDeJugador2(){
		return this.turno % 2 == 0;
	}
	
	public HashMap<Posicion, UnidadDeJuego> casillas(){
		return tablero.casillas();
	}
	
	public int monedasDelJugador(){
		return turnoActual.monedas();
	}
}
