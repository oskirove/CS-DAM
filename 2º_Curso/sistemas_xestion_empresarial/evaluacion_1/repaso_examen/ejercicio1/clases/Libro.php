<?php
class Libro
{
    private string $autor;
    private string $titulo;
    private int $paginas;
    private int $refLibro;

    public function __construct(string $autor, string $titulo, int $paginas, )
    {
        $refLibro = random_int(0, 10000);
        $this->autor = $autor;
        $this->titulo = $titulo;
        $this->paginas = $paginas;
    }

    //setters
    public function setAutor(string $autor)
    {
        $this->autor = $autor;
    }

    public function setTitulo(string $titulo)
    {
        $this->titulo = $titulo;
    }

    public function setPaginas(int $paginas)
    {   
        $this->paginas = $paginas;
    }

    //getters
    public function getAutor(): string
    {
        return $this->autor;
    }

    public function getTitulo(): string
    {
        return $this->titulo;
    }

    public function getPaginas(): int
    {
        return $this->paginas;
    }

    //metodos
    public function printAutor()
    {
        echo "Autor: ", $this->autor, "\n";
    }

    public function printTitulo()
    {
        echo "Titulo: ", $this->titulo, "\n";
    }

    public function printLibro()
    {
        echo "Titulo: ", $this->titulo, "Autor: ", $this->autor, "Paginas: ", $this->paginas;
    }
}
