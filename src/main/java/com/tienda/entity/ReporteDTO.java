package com.tienda.entity;
import java.io.ByteArrayInputStream;
import lombok.Data;

@Data
public class ReporteDTO {
    private String fileName;
    private ByteArrayInputStream stream;
    private int length;
}