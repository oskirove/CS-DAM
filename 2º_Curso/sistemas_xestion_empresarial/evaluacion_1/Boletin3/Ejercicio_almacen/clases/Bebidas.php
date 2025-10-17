<?php
    abstract class Bebidas {
        protected int $UUID;
        protected float $litros;
        protected float $precio;
        protected string $marca;

        public function __construct(int $UUID, float $litros, float $precio, string $marca)
        {
            $this -> UUID = $UUID;
            $this -> litros = $litros;
            $this -> precio = $precio;
            $this -> marca = $marca;
        }

        public function setUUID(int $UUID): void {
            $this -> UUID = $UUID;
        }

        public function setLitros(float $litros): void {

            if ($litros < 0) {
                throw new InvalidArgumentException("El precio debe ser positivo");
            }

            $this -> litros = $litros;
        }

        public function setPrecio(float $precio): void {

            if ($precio < 0) {
                throw new InvalidArgumentException("Los litros deben ser positivos");
            }

            $this -> precio = $precio;
        }

        public function setMarca(string $marca): void {
            $this -> marca = $marca;
        }

        public function getUUID(): int {
            return $this -> UUID;
        }

        public function getLitros(): int {
            return $this -> litros;
        }

        public function getPrecio(): int {
            return $this -> precio;
        }

        public function getMarca(): int {
            return $this -> marca;
        }
    } 
?>