package com.cibertec.evaluacionservicegrupo07.controller;
import com.cibertec.evaluacionservicegrupo07.dto.ConfiguracionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import com.cibertec.evaluacionservicegrupo07.dto.ScoringRiesgoDTO;

@RestController
@RequestMapping("/api/v1/evaluaciones")
@RefreshScope
public class EvaluacionController {

    @GetMapping("/scoring/{clienteId}")
    public ScoringRiesgoDTO getScoring(@PathVariable Long clienteId) {
        if (clienteId == 1L) {
            return new ScoringRiesgoDTO(1L, 780, "BAJO", 30000.0, "Cliente con capacidad crediticia optima");
        } else if (clienteId == 2L) {
            return new ScoringRiesgoDTO(2L, 620, "MEDIO", 12000.0, "Cliente con capacidad moderada");
        } else {
            return new ScoringRiesgoDTO(clienteId, 450, "ALTO", 3000.0, "Cliente con riesgo severo de mora");
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ScoringRiesgoDTO getCliente(@PathVariable Long clienteId) {
        return getScoring(clienteId);
    }


    @Value("${fintech.scoring-minimo-aprobacion}")
    private String minimoAprobacion;
    @Value("${fintech.factor-endeudamiento-max}")
    private String factorEndeudamientoMax;
    @Value("${fintech.mensaje-riesgos}")
    private String mensajeRiesgos;
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @GetMapping("/configuracion")
    public ConfiguracionDTO configuracion(){
        return new ConfiguracionDTO(minimoAprobacion,factorEndeudamientoMax,
                mensajeRiesgos,datasourceUrl);

    }
}
