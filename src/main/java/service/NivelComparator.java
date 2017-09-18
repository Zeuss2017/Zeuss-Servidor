/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.EjercicioEstudiante;
import java.util.Comparator;

/**
 *
 * @author Maria Jose Mendoza Rincon
 */
 public class NivelComparator implements Comparator<EjercicioEstudiante> {
    @Override
    public int compare(EjercicioEstudiante a, EjercicioEstudiante b) {
        return a.getNivel()-b.getNivel();
    }
 }

