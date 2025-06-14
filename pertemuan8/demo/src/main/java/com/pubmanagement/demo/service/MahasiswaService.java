package com.pubmanagement.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pubmanagement.demo.model.Mahasiswa;

@Service
public class MahasiswaService {
    private List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

    // method to get all mahasiswa
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaList;
    }

    // method to add mahasiswa
    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
    }

    // method to get mahasiswa by id
    public Mahasiswa getMahasiswaById(int id) {
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getId() == id) {
                return mahasiswa;
            }
        }
        return null;
    }

    // method to update mahasiswa
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        for (int i = 0; i < mahasiswaList.size(); i++) {
            if (mahasiswaList.get(i).getId() == mahasiswa.getId()) {
                mahasiswaList.set(i, mahasiswa);
                break;
            }
        }
    }

    // method to delete mahasiswa
    public void deleteMahasiswa(int id) {
        for (int i = 0; i < mahasiswaList.size(); i++) {
            if (mahasiswaList.get(i).getId() == id) {
                mahasiswaList.remove(i);
                break;
            }
        }
    }
}
