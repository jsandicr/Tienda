package com.tienda.controller;

import com.tienda.Service.ReporteService;
import com.tienda.commons.TipoReporteEnum;
import com.tienda.entity.ReporteDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReporteController {
    
    @Autowired
    private ReporteService reporteService;
    
    @GetMapping("/ventas")
    public String ventas(Model model){
        model.addAttribute("fechaInicio", "2022-01-04");
        model.addAttribute("fechaFin", "2022-04-04");
        model.addAttribute("tipo", "PDF");
        return "Ventas";
    }
    
    @GetMapping("/ventas/download")
    public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) throws JRException, IOException, SQLException{
        ReporteDTO dto=reporteService.reporte(params);
        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
                mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
                mediaType = MediaType.APPLICATION_PDF;
        } 
        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"").contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }
}
