package com.company;

public class MobilePhone extends MobileDevice {

    private String operador, versaoRede;

    MobilePhone() {
        super();
        this.operador = "";
        this.versaoRede = "";
    }

    MobilePhone(String brand, String model, int year, String serialNumber, CPU cpu, String operador, String versaoRede) {
        super(brand, model, year, serialNumber, cpu);
        this.operador = operador;
        this.versaoRede = versaoRede;
    }

    public String getOperador() {
        return operador;
    }

    public String getVersaoRede() {
        return versaoRede;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "operador='" + operador + '\'' +
                ", versaoRede='" + versaoRede + '\'' +
                '}';
    }
}