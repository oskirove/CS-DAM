<?php
    class Azucarada extends Bebidas {

        protected int $azucar;
        protected bool $promocion;

        public function __construct(int $UUID, float $litros, float $precio, string $marca, int $azucar, bool $promocion) {
            parent::__construct($UUID, $litros, $precio, $marca);
            $this -> azucar = $azucar;
            $this -> promocion = $promocion;
        }
        
        public function setAzucar(int $azucar): void {

            if ($azucar < 0) {
                throw new InvalidArgumentException("El porcentaje de azucar debe ser positivo");
            }

            $this -> azucar = $azucar;
        }

        public function getAzucar(): int {
            return $this -> azucar;
        }

        public function setPromocion(bool $promocion): void {
            $this -> promocion = $promocion;
        }

        public function getPromocion(): bool {
            return $this -> promocion;
        }

        public function setPrecio(float $precio): void {
            $precioFinal = $precio;

            if ($this -> promocion == true) {
                $precioFinal = $precio * 0.90;
            }

            parent::setPrecio($precioFinal);
        }
    }
?>