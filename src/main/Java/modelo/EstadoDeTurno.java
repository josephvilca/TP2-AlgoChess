package modelo;

public interface EstadoDeTurno {



	public void seleccionarDelTablero(int x, int y);
	
	
	public void posicionarUnidad(int x, int y);

	public void terminarTurno();
	
	public void accionar(int x, int y);

	public void moverPiezaSeleccionada(int x, int y);	
	
	public void comprarUnidad(int indice, int x, int y);
}
