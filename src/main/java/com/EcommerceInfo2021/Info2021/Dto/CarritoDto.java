package com.EcommerceInfo2021.Info2021.Dto;

import javax.validation.constraints.NotBlank;

public class CarritoDto {
    /*
   +generadoPor:[M | W | S]
   */
    @NotBlank
   private String generadoPor;

    public String getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }
}
