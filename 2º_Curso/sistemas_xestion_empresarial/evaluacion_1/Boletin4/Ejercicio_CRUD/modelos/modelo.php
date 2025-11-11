<?php

class Empleado
{
    private $empleado;
    private $db;

    public function __construct()
    {
        $this->empleado = array();
        $this->db = new PDO("mysql:host=localhost;dbname=ejempo_mvc;charset=utf8", "root", "");
    }

    public function setEmpleaod($nombre, $apellidos, $telefono, $departamento)
    {
        $sql = "INSERT INTO empleados(nombre, apellidos, telefono, departamento) VALUES ('$nombre', '$apellidos', '$telefono', '$departamento')";
        $result = $this->db->query($sql);
        $this->db = null;

        return $result;
    }

    public function getEmpleado()
    {
        $sql = "SELECT * FROM empleados";
        $result = $this->db->query($sql);

        $this->empleado = $result->fetchAll(PDO::FETCH_ASSOC);

        $this->db = null;

        return $this->empleado;
    }

    public function edit($uuid)
    {
        $sql = "SELECT nombre,apellidos,telefono,departamento FROM empleados WHERE uuid='{$uuid}'";
        $result = $this->db->query($sql);
        $dato = $result->fetchAll(PDO::FETCH_ASSOC);
        $this->db = null;
        return $dato;
    }

    public function update($nombre, $apellidos, $telefono, $departamento, $uuid)
    {
        $sql = "UPDATE empleados SET nombre = '{$nombre}', apellidos = '{$apellidos}', telefono = '{$telefono}', departamento = '{$departamento}' WHERE uuid={$uuid}";
        $result = $this -> db -> query($sql);
        $this->db = null;

        return $result;
    }

    public function delete($uuid)
    {
        $sql = "DELETE FROM empleados WHERE uuid={$uuid}";
        $result = $this->db->query($sql);
        $this->db = null;

        return $result;
    }
}
