package biblioteca;

import java.util.Objects;

public class Libro implements Comparable<Libro>{
	private String autor;
	private String titulo;
	private String editorial;
	private int anio;
	private int paginas;
	private Genero genero;
	
	static final int LIMITE_DE_TITULO = 200;
	
	public Libro(String autor, String titulo,
			int paginas, int anio, Genero genero) {
		
		this.autor = autor;
		this.setTitulo(titulo);
		this.setPaginas(paginas);
		this.anio = anio;
		this.genero = genero;
	}
	
	public void setPaginas(int paginas) {
		if(paginas > 0)
			this.paginas = paginas;
		else throw new Error("Numero de paginas invalido");
	}
	
	public void setTitulo(String titulo) {
		this.titulo = (titulo.length() > LIMITE_DE_TITULO) ? 
				titulo.substring(0, LIMITE_DE_TITULO) 
				: titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public Genero getGenero() {
		return this.genero;
	}

	@Override
	public int compareTo(Libro o) {
		if(this.paginas > o.paginas) return -1;
		else if (this.paginas < o.paginas) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return this.autor + " (" + this.anio + "). " + this.genero.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		
		return Objects.equals(autor, other.autor) && 
				Objects.equals(titulo, other.titulo);
	}
}
