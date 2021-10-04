/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdcc.gpao.entity;


import org.springframework.data.annotation.Id;



/**
 *
 * @author Sodecoton
 */
public class Usine  {


	@Id
    private Integer Id_usine;
    private String Nom_usine;
    private String Code_usine;
    
    
   

	public Usine() {
		super();
	}
	
	


	public Usine(String nom_usine, String code_usine) {
		super();
		Nom_usine = nom_usine;
		Code_usine = code_usine;
	}




	public Usine(Integer id_usine, String nom_usine, String code_usine) {
		super();
		Id_usine = id_usine;
		Nom_usine = nom_usine;
		Code_usine = code_usine;
	}


	public Integer getId_usine() {
		return Id_usine;
	}


	public void setId_usine(Integer id_usine) {
		Id_usine = id_usine;
	}


	public String getNom_usine() {
		return Nom_usine;
	}


	public void setNom_usine(String nom_usine) {
		Nom_usine = nom_usine;
	}


	public String getCode_usine() {
		return Code_usine;
	}


	public void setCode_usine(String code_usine) {
		Code_usine = code_usine;
	}




	@Override
	public String toString() {
		return "Usine [Id_usine=" + Id_usine + ", Nom_usine=" + Nom_usine + ", Code_usine=" + Code_usine + "]";
	}

    
}
