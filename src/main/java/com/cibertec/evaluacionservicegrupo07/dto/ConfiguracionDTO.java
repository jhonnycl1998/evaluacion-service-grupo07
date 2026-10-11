package com.cibertec.evaluacionservicegrupo07.dto;

public class ConfiguracionDTO {
    private String minimoAprobacion;
    private String factorEndeudamientoMax;
    private String mensajeRiesgos;
    private String datasourceUrl;

    public ConfiguracionDTO(String minimoAprobacion, String factorEndeudamientoMax, String datasourceUrl, String mensajeRiesgos) {
        this.minimoAprobacion = minimoAprobacion;
        this.factorEndeudamientoMax = factorEndeudamientoMax;
        this.datasourceUrl = datasourceUrl;
        this.mensajeRiesgos = mensajeRiesgos;
    }

    public String getMinimoAprobacion() {
        return minimoAprobacion;
    }

    public String getFactorEndeudamientoMax() {
        return factorEndeudamientoMax;
    }

    public String getMensajeRiesgos() {
        return mensajeRiesgos;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }
}
