<?php
class Almacen {
    private $estanteria = [];
    
    public function __construct(int $filas, int $columnas)
    {
        for ($i=0; $i < $filas; $i++) { 
            for ($j=0; $j < $columnas; $j++) { 
                $this->estanteria[$i][$j] = 0;
            }
        }

        
    }
}
