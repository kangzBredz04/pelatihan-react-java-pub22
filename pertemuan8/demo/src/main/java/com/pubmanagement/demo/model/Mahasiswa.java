package com.pubmanagement.demo.model;

import lombok.Data;

@Data
public class Mahasiswa {
    private int id;
    private String nim;
    private String nama;
    private String prodi;
    private String fakultas;
    private int angkatan;
}
