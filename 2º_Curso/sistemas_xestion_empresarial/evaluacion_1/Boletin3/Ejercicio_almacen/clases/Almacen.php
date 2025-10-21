<?php
    class Almacen {
        private array $almacen;
        private $FILAS = 3;
        private $COLUMNAS = 4;

        public function __construct() {
            $this->almacen = array_fill(0, $this->FILAS, array_fill(0, $this->COLUMNAS, null));
        }

        public function calcularPrecioTotal(): float {
            $total = 0;
            for ($i = 0; $i < $this->FILAS; $i++) {
                for ($j = 0; $j < $this->COLUMNAS; $j++) {
                    if ($this->almacen[$i][$j] !== null) {
                        $total += $this->almacen[$i][$j]->getPrecio();
                    }
                }
            }
            return $total;
        }

        public function calcularPrecioMarca(string $marca): float {
            $total = 0;
            for ($i = 0; $i < $this->FILAS; $i++) {
                for ($j = 0; $j < $this->COLUMNAS; $j++) {
                    if ($this->almacen[$i][$j] !== null && $this->almacen[$i][$j]->getMarca() === $marca) {
                        $total += $this->almacen[$i][$j]->getPrecio();
                    }
                }
            }
            return $total;
        }

        public function calcularPrecioEstanteria(int $columna): float {
            if ($columna < 0 || $columna >= $this->COLUMNAS) {
                return 0;
            }
            
            $total = 0;
            for ($i = 0; $i < $this->FILAS; $i++) {
                if ($this->almacen[$i][$columna] !== null) {
                    $total += $this->almacen[$i][$columna]->getPrecio();
                }
            }
            return $total;
        }

        public function agregarProducto($bebida): bool {
            for ($i = 0; $i < $this->FILAS; $i++) {
                for ($j = 0; $j < $this->COLUMNAS; $j++) {
                    if ($this->almacen[$i][$j] !== null && 
                        $this->almacen[$i][$j]->getId() === $bebida->getId()) {
                        return false;
                    }
                }
            }

            for ($i = 0; $i < $this->FILAS; $i++) {
                for ($j = 0; $j < $this->COLUMNAS; $j++) {
                    if ($this->almacen[$i][$j] === null) {
                        $this->almacen[$i][$j] = $bebida;
                        return true;
                    }
                }
            }
            return false;
        }

        public function eliminarProducto(int $id): bool {
            for ($i = 0; $i < $this->FILAS; $i++) {
                for ($j = 0; $j < $this->COLUMNAS; $j++) {
                    if ($this->almacen[$i][$j] !== null && 
                        $this->almacen[$i][$j]->getId() === $id) {
                        $this->almacen[$i][$j] = null;
                        return true;
                    }
                }
            }
            return false;
        }

        public function mostrarInformacion(): string {
            $info = "<h2>Información del Almacén</h2>";
            for ($i = 0; $i < $this->FILAS; $i++) {
                for ($j = 0; $j < $this->COLUMNAS; $j++) {
                    if ($this->almacen[$i][$j] !== null) {
                        $info .= "<p>Posición [$i][$j]: " . $this->almacen[$i][$j]->toString() . "</p>";
                    }
                }
            }
            if ($info === "<h2>Información del Almacén</h2>") {
                $info = "<p>El almacén está vacío</p>";
            }
            return $info;
        }
    }
?>