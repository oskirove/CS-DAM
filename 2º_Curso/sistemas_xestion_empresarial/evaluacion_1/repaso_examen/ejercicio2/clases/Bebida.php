<?php

abstract class Bebida
{
    protected int $id;
    protected float $litros;
    protected float $precio;
    protected string $marca;

    public function __construct(int $id, float $litros, float $precio, string $marca)
    {
        $this->id = $id;
        $this->litros = $litros;
        $this->precio = $precio;
        $this->marca = $marca;
    }

    //getters
    public function getId()
    {
        return $this->id;
    }

    public function getLitros()
    {
        return $this->litros;
    }

    public function getPrecio()
    {
        return $this->precio;
    }

    public function getMarca()
    {
        return $this->marca;
    }

    //setters
    public function setId(int $id)
    {
        $this->id = $id;
    }

    public function setLitros(float $litros)
    {
        $this->litros = $litros;
    }

    public function setPrecio(float $precio)
    {
        $this->precio = $precio;
    }

    public function setMarca(float $marca)
    {
        $this->marca = $marca;
    }

    //metodos
    public function visualizar()
    {
        print('id: ' . $this->id . '<br> litros: ' . $this->litros . '<br> precio: ' . $this->precio . '<br> marca: ' . $this->marca . '<br>');
    }
}
