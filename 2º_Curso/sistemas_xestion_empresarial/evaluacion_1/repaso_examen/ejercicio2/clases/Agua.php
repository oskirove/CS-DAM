<?php

class Agua extends Bebida
{
    private string $origen;

    public function __construct(float $litros, float $precio, string $marca, string $origen)
    {
        parent::__construct($litros, $precio, $marca);
        $this->origen = $origen;
    }

    //setters y getters
    public function setOrigen(string $origen)
    {
        $this->origen = $origen;
    }

    public function getOrigen() : string {
        return $this->origen;
    } 

    //metodos
    public function visualizar()
    {
        parent::visualizar();
        print ("Origen: " . $this->origen);
    }
}
