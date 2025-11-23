<?php

class Refresco extends Bebida
{
    private int $azucar;
    private bool $promocion;

    public function __construct(float $litros, float $precio, string $marca, bool $promocion, int $azucar)
    {
        parent::__construct($litros, $precio, $marca);

        $this->azucar = $azucar;
        $this->promocion = $promocion;
    }

    public function getAzucar()
    {
        return $this->azucar;
    }

    public function setAzucar(int $porcentaje)
    {
        $this->azucar = $porcentaje;
    }

    public function setPromocion(bool $promocion)
    {
        $this->promocion = $promocion;
    }

    public function getPrecio() {
        if ($this->promocion) {
            return parent::getPrecio() * 0.9;
        } else {
            return parent::getPrecio();
        }
    }

    public function visualizar()
    {
        parent::visualizar();
        print ("Azucar: " . $this->azucar . "%" . "Promocion: " . $this->promocion);
    }
}
