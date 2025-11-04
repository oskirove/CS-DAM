<?php

    class Empleado {
        private $empleado;
        private $db;

        public function __construct() {
            $this -> empleado = array();
            $this -> db = new PDO("mysql:host=localhost;dbname=ejempo_mvc;charset=utf8", "root", "");
        }

        public function setEmpleaod($nombre, $apellidos, $telefono, $departamento) {
            $sql="INSERT INTO empleados(nombre, apellidos, telefono, departamento) VALUES ('$nombre', '$apellidos', '$telefono', '$departamento')";
            $result=$this -> db -> query($sql);
            $this -> db = null;

            return $result;
        }

        public function getEmpleado() {
            $sql = "SELECT * FROM empleados";
            $result = $this -> db -> query($sql);

            $this -> empleado = $result -> fetchAll(PDO::FETCH_ASSOC);

            $this -> db = null;

            return $this -> empleado;
        }
    }

?>