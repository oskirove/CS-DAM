<?php
    class Agua extends Bebidas {

        protected string $origen;

        public function __construct(int $UUID, float $litros, float $precio, string $marca, string $origen) {
            parent::__construct($UUID, $litros, $precio, $marca);
            $this -> origen = $origen;
        }
        
        public function setOrigen(string $origen): void {
            $this -> origen = $origen;
        }

        public function getOrigen(): string {
            return $this -> origen;
        }

        public function toString(): string {
            return parent::toString() . ", Manantial: {$this->origen}";
        }
    }
?>