package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Biblioteca;
import biblioteca.Genero;
import biblioteca.Libro;

public class BibliotecaTest {
	Biblioteca b;
	Libro l0;
	Libro l1;
	Libro l2;
	Libro l3;
	
	@Before
	public void setup() {
		b = new Biblioteca(4);
		l0 = new Libro("Pepe", "Titulo1", 250, 2018, Genero.AUTOAYUDA);
		l1 = new Libro("Alfonsina", "AA", 200, 2015, Genero.INFANTIL);
		l2 = new Libro("Jose", "ZZ", 50, 2020, Genero.INFANTIL);
		l3 = new Libro("Camila", "Taaa", 350, 2008, Genero.FICCION);
	}
	
	@Test
	public void creacion() {
		assertNotNull(b);
		assertEquals(4, b.getLibros().length);
	}
	
	@Test
	public void agregarLibros() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		assertNotNull(b.getLibros()[0]);
		assertNotNull(b.getLibros()[1]);
		assertNull(b.getLibros()[2]);
	}
	
	@Test
	public void ordenarPorPagina() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		b.agregarLibro(l2);
		b.agregarLibro(l3);
		
		Libro[] esperado = {l3, l0, l1, l2};
		b.ordenarPorPagina();
		assertArrayEquals(esperado, b.getLibros());
	}

	@Test
	public void ordenarPorTitulo() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		b.agregarLibro(l2);
		b.agregarLibro(l3);
		
		Libro[] esperado = {l1, l3, l0, l2};
		b.ordenarPorTitulo();
		
		assertArrayEquals(esperado, b.getLibros());
	}
	
	@Test
	public void librosPorGenero() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		b.agregarLibro(l2);
		b.agregarLibro(l3);
		
		System.out.println(b.cantidadLibrosPorGenero());
		String esperado = "FICCION 1\n" + "DIVULGACION 0\n" + "AUTOAYUDA 1\n"+ "INFANTIL 2\n";
		assertEquals(esperado, b.cantidadLibrosPorGenero());		
	}
	
	@Test
	public void librosRepetido() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		b.agregarLibro(l2);
		
		assertTrue(b.libroRepetido(l1));
		assertFalse(b.libroRepetido(l3));	
	}
	
	@Test
	public void librosHashcode() {
		Libro libro1 = new Libro("El mismo autor", "El mismo titulo", 
				450, 2020, Genero.INFANTIL);
		Libro libro2 = new Libro("El mismo autor", "El mismo titulo",
				250, 2010, Genero.FICCION);
		
		assertEquals(libro1, libro2);		
		assertEquals(libro1.hashCode(), libro2.hashCode());		

		assertNotEquals(libro1, l2);
		assertNotEquals(libro1.hashCode(), l2.hashCode());		
	}
}
