package com.tienda.Service;

import java.util.Map;
import com.tienda.entity.ReporteDTO;
import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

public interface IReporteService {
    ReporteDTO reporte(Map<String, Object> params) throws JRException, IOException, SQLException;
}