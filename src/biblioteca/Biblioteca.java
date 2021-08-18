package biblioteca;

import java.util.Arrays;

public class Biblioteca {
	private Libro[] libros;
	private int cantLibros = 0;
	
	public Biblioteca(int tam) {
		this.libros = new Libro[tam];
	}

	public void agregarLibro(Libro nuevo) {
		if(cantLibros >= this.libros.length )
			throw new Error("La biblioteca esta llena");
		this.libros[cantLibros] = nuevo;
		cantLibros++;
	}
	
	
	
	public String cantidadLibrosPorGenero() {
		Genero[] generos = Genero.values();
		int[] cantidadLibrosPorGenero = new int[generos.length];
		
		for (Libro l : this.libros) {
			cantidadLibrosPorGenero[l.getGenero().ordinal()] += 1;
		}

		String liBrosPorGenero = "";
		for (Genero g : generos) {
			liBrosPorGenero += g.name() + " " + cantidadLibrosPorGenero[g.ordinal()] + "\n";
		}
		return liBrosPorGenero;
	}
	
	

	public boolean libroRepetido(Libro libro) {
		for(Libro l : this.libros) {
			if(l != null && libro.equals(l)) return true;
		}
		return false;
	}
	
	public Libro[] getLibros() {
		return this.libros;
	}
	
	public void ordenarPorPagina() {
		Arrays.sort(this.libros);
	}

	public void ordenarPorTitulo() {
		Arrays.sort(this.libros, new OrdenadorPorTitulo());
	}
}
