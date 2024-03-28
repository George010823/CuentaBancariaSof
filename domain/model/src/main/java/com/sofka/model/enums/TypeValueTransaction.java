package com.sofka.model.enums;

public enum TypeValueTransaction {

    DEPOSITO_SUCURSAL(0),
    DEPOSITO_CAJERO(2),
    DEPOSITO_OTRA_CUENTA(1.5),
    COMPRA_FISICO(0),
    COMPRA_WEB(5),
    RETIRO_CAJERO(1);

    private final double valor;

    TypeValueTransaction(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public static TypeValueTransaction obtenerTipoTransaccion(String nombre) {
        for (TypeValueTransaction tipo : values()) {
            if (tipo.name().equalsIgnoreCase(nombre)) {
                return tipo;
            }
        }
        return null;
    }
}
